/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.GrupoDespesasClasseCtp;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.Ctp_ContaPagarSumSubClasseTMP;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author marcos
 */
public class GrupoDespesasClasseCtpREL extends RelatorioBase {

    private DataSet dsApagar;
    private DataSet dspagas;
    private int plc_nr_id;
    private List<Ctp_ContaPagarSumSubClasseTMP> list = new ArrayList();
    private TreeMap<Integer, Ctp_ContaPagarSumSubClasseTMP> tree = new TreeMap<Integer, Ctp_ContaPagarSumSubClasseTMP>();
    private double total;
    private String subClasse;
    private boolean acumulado;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Ctp_conta_pagarDAO cdao = null;
        try {
            cdao = getCtp_conta_pagarDAO();
            dspagas =  cdao.getValorSubClasse(getObr_obrasT().getObr_nr_id(), plc_nr_id, "P", getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), acumulado);
            dsApagar = cdao.getValorSubClasse(getObr_obrasT().getObr_nr_id(), plc_nr_id, "A", getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), acumulado);
            total = 0;
            povoaListDsPagas(dspagas);
            povoaListDsAPagar(dsApagar);
            OrdenarList();
            ordenarListDecrecente();
            calcularPeso();
            getParameters().put("subClasse", subClasse);

            jRDataSource = new JRBeanCollectionDataSource(list); 
            if(! getTipo().equalsIgnoreCase("XLS")){
                is = GrupoDespesasClasseCtpREL.class.getResourceAsStream("GrupoDespesasClasseCtpl.jasper");
            }else{
                url  = GrupoDespesasClasseCtpREL.class.getResource("GrupoDespesasClasseCtpl.jasper") ;
            }
            print("custos-anali-pagas-apagar sub-classe","CUSTOS ANALÍTICO DAS CONTAS PAGAS/A PAGAR POR SUB-CLASSES");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void povoaListDsPagas(DataSet ds) {

        for (int i = 0; i < ds.getList().size(); i++) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP = new Ctp_ContaPagarSumSubClasseTMP();
            classeTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
            classeTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
            classeTMP.setValor_pago(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
            classeTMP.setTotal(classeTMP.getValor_pago());
            total = total + classeTMP.getValor_pago();
            list.add(classeTMP);
            tree.put(classeTMP.getPlc_nr_id(), classeTMP);
        }
    }

    public void povoaListDsAPagar(DataSet ds) {
        for (int i = 0; i < ds.getList().size(); i++) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP;
            int id = Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString());
            classeTMP = tree.get(id);
            if (classeTMP == null) {
                classeTMP = new Ctp_ContaPagarSumSubClasseTMP();
                classeTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                classeTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
                classeTMP.setValor_Apagar(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                classeTMP.setTotal(classeTMP.getValor_Apagar());
                list.add(classeTMP);
            }else{
                classeTMP.setValor_Apagar(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                classeTMP.setTotal(classeTMP.getValor_pago() + classeTMP.getValor_Apagar());
            }
            total = total + classeTMP.getValor_Apagar();
        }
    }

    public void OrdenarList(){
        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                Ctp_ContaPagarSumSubClasseTMP classeTMP = (Ctp_ContaPagarSumSubClasseTMP) o1;
                Ctp_ContaPagarSumSubClasseTMP classeTMP2 = (Ctp_ContaPagarSumSubClasseTMP) o2;
                Double valor1 = classeTMP != null? classeTMP.getTotal():0;
                Double valor2 = classeTMP2 != null? classeTMP2.getTotal():0;
                return valor1.compareTo(valor2);
            }
        });
    }

    public void ordenarListDecrecente(){
        List<Ctp_ContaPagarSumSubClasseTMP> listTemp = new ArrayList<Ctp_ContaPagarSumSubClasseTMP>();
        for (int i = (list.size()-1); i > -1 ; i--) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP = list.get(i);
            listTemp.add(classeTMP);
        }
        list.clear();
        list = listTemp;
    }

    public void calcularPeso(){
        for (Ctp_ContaPagarSumSubClasseTMP ctp_ContaPagarSumSubClasseTMP : list) {
            ctp_ContaPagarSumSubClasseTMP.setPeso(ctp_ContaPagarSumSubClasseTMP.getTotal()*100/total);
        }
    }

    /**
     * @return the plc_nr_id 88548025
     */
    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    /**
     * @param plc_nr_id the plc_nr_id to set
     */
    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    /**
     * @return the subClasse
     */
    public String getSubClasse() {
        return subClasse;
    }

    /**
     * @param subClasse the subClasse to set
     */
    public void setSubClasse(String subClasse) {
        this.subClasse = subClasse;
    }

    /**
     * @return the acumulado
     */
    public boolean isAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(boolean acumulado) {
        this.acumulado = acumulado;
    }
}

