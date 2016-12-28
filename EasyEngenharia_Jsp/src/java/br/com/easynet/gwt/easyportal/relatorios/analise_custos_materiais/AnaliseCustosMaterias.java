/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.analise_custos_materiais;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.Ctp_ContaPagarSumSubClasseTMP;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class AnaliseCustosMaterias extends RelatorioBase implements INotSecurity {

    private int qtde_item;
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
            setDspagas(cdao.getValorSubClasse(getObr_obrasT().getObr_nr_id(), getPlc_nr_id(), "P", getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), isAcumulado()));
            setDsApagar(cdao.getValorSubClasse(getObr_obrasT().getObr_nr_id(), getPlc_nr_id(), "A", getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno(), isAcumulado()));
            setTotal(0);
            povoaListDsPagas(getDspagas());
            povoaListDsAPagar(getDsApagar());
            OrdenarList();
            ordenarListDecrecente();
            filtrarQtde();

            getParameters().put("subClasse", getSubClasse());
            String path = application.getRealPath("jasper/grafico.jasper");
            path = path.substring(0, path.indexOf("grafico.jasper"));
            getParameters().put("SUBREPORT_DIR", path);

            jRDataSource = new JRBeanCollectionDataSource(list);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
            getParameters().put("list", dataSource);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = AnaliseCustosMaterias.class.getResourceAsStream("analise_custos_materiais.jasper");
            } else {
                url = AnaliseCustosMaterias.class.getResource("analise_custos_materiais.jasper");
            }
            print("AnaliseCustosMateriais", "ANALISE CUSTOS MATERIAIS");

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
            setTotal(getTotal() + classeTMP.getValor_pago());
            getList().add(classeTMP);
            getTree().put(classeTMP.getPlc_nr_id(), classeTMP);
        }
    }

    public void povoaListDsAPagar(DataSet ds) {
        for (int i = 0; i < ds.getList().size(); i++) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP;
            int id = Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString());
            classeTMP = getTree().get(id);
            if (classeTMP == null) {
                classeTMP = new Ctp_ContaPagarSumSubClasseTMP();
                classeTMP.setPlc_nr_id(Integer.parseInt(ds.getList().get(i).getColumn("plc_nr_id").toString()));
                classeTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString());
                classeTMP.setValor_Apagar(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                classeTMP.setTotal(classeTMP.getValor_Apagar());
                getList().add(classeTMP);
            } else {
                classeTMP.setValor_Apagar(Float.parseFloat(ds.getList().get(i).getColumn("valor").toString()));
                classeTMP.setTotal(classeTMP.getValor_pago() + classeTMP.getValor_Apagar());
            }
            setTotal(getTotal() + classeTMP.getValor_Apagar());
        }
    }

    public void OrdenarList() {
        Collections.sort(getList(), new Comparator() {

            public int compare(Object o1, Object o2) {
                Ctp_ContaPagarSumSubClasseTMP classeTMP = (Ctp_ContaPagarSumSubClasseTMP) o1;
                Ctp_ContaPagarSumSubClasseTMP classeTMP2 = (Ctp_ContaPagarSumSubClasseTMP) o2;
                Double valor1 = classeTMP != null ? classeTMP.getTotal() : 0;
                Double valor2 = classeTMP2 != null ? classeTMP2.getTotal() : 0;
                return valor1.compareTo(valor2);
            }
        });
    }

    public void ordenarListDecrecente() {
        List<Ctp_ContaPagarSumSubClasseTMP> listTemp = new ArrayList<Ctp_ContaPagarSumSubClasseTMP>();
        double pago = 0;
        double apagar = 0;
        total = 0;
        for (int i = (getList().size() - 1); i > -1; i--) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP = getList().get(i);
            listTemp.add(classeTMP);
            total += (classeTMP.getValor_Apagar() + classeTMP.getValor_pago());
        }

        getList().clear();
        setList(listTemp);
    }

    public void filtrarQtde() {
        double pago = 0;
        double apagar = 0;
        double dif = 0;
        double valor = 0;
        List<Ctp_ContaPagarSumSubClasseTMP> listTemp = new ArrayList<Ctp_ContaPagarSumSubClasseTMP>();
        for (int i = 0; i < getList().size(); i++) {
            if (getQtde_item() > i) {
                valor = list.get(i).getValor_Apagar() + list.get(i).getValor_pago();
                dif = total - valor;
                list.get(i).setPeso(dif * 100 / valor);
                listTemp.add(getList().get(i));
            } else {
                pago += getList().get(i).getValor_pago();
                apagar += getList().get(i).getValor_Apagar();
            }
        }
        if ((pago + apagar) > 0) {
            Ctp_ContaPagarSumSubClasseTMP classeTMP = new Ctp_ContaPagarSumSubClasseTMP();
            classeTMP.setPlc_tx_nome("Outros Materiais");
            classeTMP.setValor_pago(pago);
            classeTMP.setValor_Apagar(apagar);
            classeTMP.setTotal(pago + apagar);
            dif = total - classeTMP.getTotal();
            classeTMP.setPeso(dif * 100 / classeTMP.getTotal());
            listTemp.add(classeTMP);
        }
        getList().clear();
        setList(listTemp);
    }

    /**
     * @return the qtde_item
     */
    public int getQtde_item() {
        return qtde_item;
    }

    /**
     * @param qtde_item the qtde_item to set
     */
    public void setQtde_item(int qtde_item) {
        this.qtde_item = qtde_item;
    }

    /**
     * @return the dsApagar
     */
    public DataSet getDsApagar() {
        return dsApagar;
    }

    /**
     * @param dsApagar the dsApagar to set
     */
    public void setDsApagar(DataSet dsApagar) {
        this.dsApagar = dsApagar;
    }

    /**
     * @return the dspagas
     */
    public DataSet getDspagas() {
        return dspagas;
    }

    /**
     * @param dspagas the dspagas to set
     */
    public void setDspagas(DataSet dspagas) {
        this.dspagas = dspagas;
    }

    /**
     * @return the plc_nr_id
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
     * @return the list
     */
    public List<Ctp_ContaPagarSumSubClasseTMP> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Ctp_ContaPagarSumSubClasseTMP> list) {
        this.list = list;
    }

    /**
     * @return the tree
     */
    public TreeMap<Integer, Ctp_ContaPagarSumSubClasseTMP> getTree() {
        return tree;
    }

    /**
     * @param tree the tree to set
     */
    public void setTree(TreeMap<Integer, Ctp_ContaPagarSumSubClasseTMP> tree) {
        this.tree = tree;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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
