/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.analiticofinaceirocontapagar;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.Ctp_ContaPagarSumSubClasseTMP;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class AnaliticoFinaceiroContaPagarPagas extends RelatorioBase {

    private DataSet ds;
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private int id_plc_super;
    private List<Ctp_ContaPagarSumSubClasseTMP> list = new ArrayList();
    private Obr_obrasDAO odao;
    private String filtro;
    private boolean acumulado;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        Ctp_conta_pagarDAO cdao = null;
        try {

            odao = getObr_obrasDAO();
            cdao = getCtp_conta_pagarDAO();
            ds = cdao.getAll(getCtp_conta_pagarT(), getId_plc_super(), acumulado);
            getSession().setAttribute("ds", ds);

            povoaList(ds);

            jRDataSource = new JRBeanCollectionDataSource(list);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = AnaliticoFinaceiroContaPagarPagas.class.getResourceAsStream("AnaliticoFinaceiroContaPagarPagas.jasper");
            } else {
                url = AnaliticoFinaceiroContaPagarPagas.class.getResource("AnaliticoFinaceiroContaPagarPagas.jasper");
            }

            String descStatus = ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A") ? " A PAGAR" : " PAGAS";
            print("Analitico.Fin.Conta" + descStatus, "CUSTOS ANALÍTICOS DAS CONTAS PAGAS/A PAGAR POR FORNECEDOR" + descStatus);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
//           sql.append("select conta.ctp_nr_id, conta.ctp_tx_fornecedor, conta.ctp_nr_mes , conta.plc_nr_id, conta.ctp_nr_valor, conta.ctp_nr_documento, conta.ctp_tx_status, conta.obr_nr_id, conta.ctp_nr_ano, classe.plc_tx_nome, obra.obr_tx_nome, classeSuper.plc_tx_nome as plc_tx_nome_super, conta.ctp_tx_obs, conta.ctp_dt_vencimento ,conta.ctp_dt_emissao, classe.plc_nr_id_super ");

    public void povoaList(DataSet ds) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i< ds.getList().size(); i++) {
            Ctp_ContaPagarSumSubClasseTMP contaTMP = new Ctp_ContaPagarSumSubClasseTMP();
            Date date = (Date) ds.getList().get(i).getColumn("ctp_dt_vencimento");
            contaTMP.setData(format.format(date));
            contaTMP.setMesControle(getMesExtenso(Integer.parseInt(ds.getList().get(i).getColumn("ctp_nr_mes").toString()), Integer.parseInt(ds.getList().get(i).getColumn("ctp_nr_ano").toString())));
            contaTMP.setDocumento(ds.getList().get(i).getColumn("ctp_nr_documento").toString().trim());
            contaTMP.setFornecedor(ds.getList().get(i).getColumn("ctp_tx_fornecedor").toString().trim());
            contaTMP.setPlc_tx_nome(ds.getList().get(i).getColumn("plc_tx_nome").toString().trim());
            contaTMP.setPlc_tx_super(ds.getList().get(i).getColumn("plc_tx_nome_super").toString().trim());
            contaTMP.setTotal(Double.parseDouble(ds.getList().get(i).getColumn("ctp_nr_valor").toString().trim()));
            list.add(contaTMP);
        }
        getSession().setAttribute("listAniliCTP", list);
    }

    public String getMesExtenso(int mes, int ano) {
        try {
            return odao.getStrMesAno(mes, ano);
        } catch (Exception e) {
        }

        return "";


    }

    /**
     * @return the ctp_conta_pagarT
     */
    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    /**
     * @param ctp_conta_pagarT the ctp_conta_pagarT to set
     */
    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;


    }

    /**
     * @return the id_plc_super
     */
    public int getId_plc_super() {
        return id_plc_super;


    }

    /**
     * @param id_plc_super the id_plc_super to set
     */
    public void setId_plc_super(int id_plc_super) {
        this.id_plc_super = id_plc_super;


    }

    /**
     * @return the filtro
     */
    public String getFiltro() {
        return filtro;


    }

    /**
     * @param filtro the filtro to set
     */
    public void setFiltro(String filtro) {
        this.filtro = filtro;


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
