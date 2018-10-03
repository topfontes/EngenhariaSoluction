/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.pms;

import br.com.easynet.gwt.easyportal.jb.Consult_PMS_JB;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.pmsTMP;
import br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Tpms_temporaria_pmsT;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Pms_REL extends RelatorioBase {

    private List<pmsTMP> list = new Vector();
    private Pms_planilha_medicao_servicoT pms = new Pms_planilha_medicao_servicoT();
    List<Tpms_temporaria_pmsT> listtmp;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
    

    public void imprimir() throws Exception {
        try {
            pms.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            Consult_PMS_JB consult = new Consult_PMS_JB( getPms(), getDAO());
            listtmp = consult.consult();
            povoaList();

            jRDataSource = new JRBeanCollectionDataSource(list);

            if (!getTipo().equalsIgnoreCase("XLS")) {
                 is = Pms_REL.class.getResourceAsStream("pms.jasper");
            } else {
                url = Pms_REL.class.getResource("pms.jasper");
            }

            print("PMS_C/CUSTOS_ORCADOS", "PMS C/CUSTOS ORÇADOS");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public void povoaList(){

        for (Tpms_temporaria_pmsT tpms : listtmp) {
            pmsTMP tMP = new pmsTMP();
            tMP.setCodigo(tpms.getTpms_tx_codigo_externo());
            tMP.setServico(tpms.getTpms_tx_conta());
            tMP.setUnidade(tpms.getTpms_tx_unidade());
            tMP.setQtde_orcada(tpms.getTpms_nr_quantidade_total());
            tMP.setCusto_unitario(tpms.getTpms_nr_valor_unit());
            tMP.setCusto_orcado(tpms.getTpms_nr_valor_total());

            tMP.setQtde_acumulada_ant(tpms.getTpms_nr_quantidade_acumulada_ant());
            double calc = 100 -((tpms.getTpms_nr_quantidade_total() - tpms.getTpms_nr_quantidade_acumulada_ant()) * 100/tpms.getTpms_nr_quantidade_total());
            tMP.setCusto_acumulado_ant(calc * tpms.getTpms_nr_valor_total()/100);

            if(tMP.getCodigo().equalsIgnoreCase("02940.6.10.18")){
                int a = 8;
            }

            tMP.setQtde_executada_mes(tpms.getTpms_nr_quantidade());
            tMP.setCusto_executado_mes(tpms.getTpms_nr_percentual() * tpms.getTpms_nr_valor_total()/100);
            tMP.setPerc_executado_mes(tpms.getTpms_nr_percentual());

            tMP.setQtde_acumulado_periodo(tpms.getTpms_nr_quantidade_acumulada_atual());
            tMP.setCusto_acumulado_periodo(tpms.getTpms_nr_percentAcumuladoPeriodo() * tpms.getTpms_nr_valor_total()/100);
            tMP.setPerc_executado_periodo(tpms.getTpms_nr_percentAcumuladoPeriodo());

            tMP.setQtde_saldo(tpms.getTpms_nr_saldo());
            tMP.setCusto_saldo(tpms.getTpms_nr_percentSaldo() * tpms.getTpms_nr_valor_total() /100);
            tMP.setPerc_saldo(tpms.getTpms_nr_percentSaldo());

            list.add(tMP);
        }
    }

    /**
     * @return the pms
     */
    public Pms_planilha_medicao_servicoT getPms() {
        return pms;
    }

    /**
     * @param pms the pms to set
     */
    public void setPms(Pms_planilha_medicao_servicoT pms) {
        this.pms = pms;
    }
}
