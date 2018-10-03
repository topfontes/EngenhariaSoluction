/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.fluxo_caixa_consolidado;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.client.dao.Vw_cffo_mesDAO;
import br.com.easynet.gwt.easyportal.client.transfer.Vw_cffo_mesT;
import br.com.easynet.gwt.easyportal.dao.Flr_fluxo_receitaDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.jb.CronogramaDesembolsoSubClasseReprogJB;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.temp.FluxoCaixaTMP;
import br.com.easynet.gwt.easyportal.transfer.Flr_fluxo_receitaT;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class FluxoCaixa_ConsolidadoJB extends RelatorioBase implements INotSecurity {

    private FluxoCaixaTMP fluxocaixaT = new FluxoCaixaTMP();
    private List<FluxoCaixaTMP> listFluxocaixa = new ArrayList<FluxoCaixaTMP>();
    private List<Flr_fluxo_receitaT> listFlr = new ArrayList<Flr_fluxo_receitaT>();
    private List<Vw_cffo_mesT> listvwCffo = new ArrayList<Vw_cffo_mesT>();
    private List<Meo_meses_obraT> listMeses = new ArrayList<Meo_meses_obraT>();
    private List<Meo_meses_obraT> listDespesasMes = new ArrayList<Meo_meses_obraT>();
    private double ultimovalorConsolidado = 0;
    private TreeMap<String, Meo_meses_obraT> treeDesp;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() throws Exception {
        try {
            consult();
            getParameters().put("ultimo_valor_consolidado", ultimovalorConsolidado);
            jRDataSource = new JRBeanCollectionDataSource(getListFluxocaixa());
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = FluxoCaixa_ConsolidadoJB.class.getResourceAsStream("fluxo_caixa_consolidado.jasper");
            } else {
                url = FluxoCaixa_ConsolidadoJB.class.getResource("fluxo_caixa_consolidado.jasper");
            }
            print("FluxoCaixaConsolidado", "FLUXO DE CAIXA CONSOLIDADO");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public void consult() throws Exception {
        Obr_obrasDAO obr_obrasDAO = null;
        try {
            obr_obrasDAO = getObr_obrasDAO();
            listMeses = obr_obrasDAO.getAllMeses(getObr_obrasT());

            //Despesa
            Vw_cffo_mesDAO vdao = getVw_cffo_mesDAO();
            Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();
            vw_cffo_mesT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            povoaTreeDesp(getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());

            //Receita
            Flr_fluxo_receitaDAO fdao = getFlr_fluxo_receitaDAO();
            Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();
            flr_fluxo_receitaT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            flr_fluxo_receitaT.setFlr_nr_mes_ref(getMeo_meses_obraT().getMes());
            flr_fluxo_receitaT.setFlr_nr_ano_ref(getMeo_meses_obraT().getAno());
            listFlr = fdao.getAll(flr_fluxo_receitaT);


            povoalist();
            calcularColunaFluxoConsolidado();
            calcularInvestimentos();
            calcularRetornos();

        } catch (Exception e) {
            throw e;
        } finally {
            obr_obrasDAO.close();
        }
    }

    public void consultResultado(TreeMap<String, Meo_meses_obraT> treeMeses) throws Exception {
        Obr_obrasDAO obr_obrasDAO = null;
        try {
            treeDesp = treeMeses;
            obr_obrasDAO = getObr_obrasDAO();
            listMeses = obr_obrasDAO.getAllMeses(getObr_obrasT());

            Flr_fluxo_receitaDAO fdao = getFlr_fluxo_receitaDAO();
            Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();
            flr_fluxo_receitaT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            flr_fluxo_receitaT.setFlr_nr_mes_ref(getMeo_meses_obraT().getMes());
            flr_fluxo_receitaT.setFlr_nr_ano_ref(getMeo_meses_obraT().getAno());
            listFlr = fdao.getAll(flr_fluxo_receitaT);

            Vw_cffo_mesDAO vdao = getVw_cffo_mesDAO();
            Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();
            vw_cffo_mesT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            //povoaTreeDesp(getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
            povoalist();
            calcularColunaFluxoConsolidado();
            calcularInvestimentos();
            calcularRetornos();

        } catch (Exception e) {
            throw e;
        } finally {
            obr_obrasDAO.close();
        }
    }


    public double getSaldoIxR(int obr_nr_id, int mes, int ano) throws Exception {
        double valor = 0;
        try {
            getObr_obrasT().setObr_nr_id(obr_nr_id);
            getMeo_meses_obraT().setMes(mes);
            getMeo_meses_obraT().setAno(ano);
//            consult();
            for (FluxoCaixaTMP fluxoCaixaTMP : getListFluxocaixa()) {
                valor += fluxoCaixaTMP.getFluxoIxR();
            } 
        } catch (Exception e) {
            throw e;
        }
        return valor;
    }

    public void povoalist() throws Exception {
        try {//98234808
            int i = 1;
            for (Meo_meses_obraT meo_meses_obraT : listMeses) {
                FluxoCaixaTMP caixaTMP = new FluxoCaixaTMP();
                double valorDesp = 0;
                double valorRec = 0;
                double valor_Desp_valor_Rec = 0;
                double valor_com_encargos=0;
                caixaTMP.setAno(meo_meses_obraT.getAno());
                caixaTMP.setMes(meo_meses_obraT.getMes());
                caixaTMP.setMes_ano(meo_meses_obraT.getMes_ano());
                valorDesp = getDespesas(meo_meses_obraT.getMes(), meo_meses_obraT.getAno());
                caixaTMP.setDespesas(valorDesp);

                valorRec = getReceita(meo_meses_obraT.getMes(), meo_meses_obraT.getAno());
                valor_Desp_valor_Rec =  valorRec - valorDesp;
                valor_com_encargos = getObr_obrasT().getObr_nr_encarcos_juros_aplicacao() * valor_Desp_valor_Rec/100;
                valor_com_encargos = valor_com_encargos * -1;

                caixaTMP.setReceita((valorRec + valor_com_encargos));
                caixaTMP.setReceita_despesas(caixaTMP.getReceita() - caixaTMP.getDespesas());
                caixaTMP.setRetornos(0);
                caixaTMP.setInvestimento(0);
                caixaTMP.setItem(i);
                i++;
                getListFluxocaixa().add(caixaTMP);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void calcularColunaFluxoConsolidado() {
        double valor = 0;
        for (int i = 0; i < getListFluxocaixa().size(); i++) {
            if (i == 0) {
                getListFluxocaixa().get(i).setFluxo_consolidado(getListFluxocaixa().get(i).getReceita_despesas());
                valor = getListFluxocaixa().get(i).getReceita_despesas();
            } else {
                valor = valor + getListFluxocaixa().get(i).getReceita_despesas();
                getListFluxocaixa().get(i).setFluxo_consolidado(valor);
                ultimovalorConsolidado = valor;
            }
        }
    }

    public void calcularInvestimentos() {

        for (int i = 0; i < getListFluxocaixa().size(); i++) {
            double valor = SomaValorInvestimento(i) + getListFluxocaixa().get(i).getFluxo_consolidado();
            if (valor < 0) {
                getListFluxocaixa().get(i).setInvestimento(valor * -1);
            } else {
                getListFluxocaixa().get(i).setInvestimento(0);
            }

        }

    }

    public void calcularRetornos() {
        double menovalor = 0;
        double somaAnterior = 0;
        double valorAnterior = 0;
        for (int i = 0; i < getListFluxocaixa().size(); i++) {
            menovalor = menorValor(i);
            if (i > 0) {
                valorAnterior = getListFluxocaixa().get(i - 1).getFluxo_consolidado();
            }
            //somaAnterior = somavaloresAnteriores(i);

            double ressultado = menovalor - valorAnterior;
            if (ressultado > 0) {
                getListFluxocaixa().get(i).setRetornos(ressultado * -1);
            } else {
                getListFluxocaixa().get(i).setRetornos(0);
            }
            getListFluxocaixa().get(i).setFluxoIxR(getListFluxocaixa().get(i).getRetornos() + getListFluxocaixa().get(i).getInvestimento());
        }
    }

    public double menorValor(int index) {
        double valor = getListFluxocaixa().get(index).getFluxo_consolidado();
        for (int i = index; i < getListFluxocaixa().size(); i++) {
            if (valor > getListFluxocaixa().get(i).getFluxo_consolidado()) {
                valor = getListFluxocaixa().get(i).getFluxo_consolidado();
            }
        }
        return valor;
    }

    public double SomaValorInvestimento(int index) {
        double valor = 0;
        for (int i = 0; i < index; i++) {
            valor += getListFluxocaixa().get(i).getInvestimento();
        }
        return valor;
    }

    public double somavaloresAnteriores(int index) {
        double valor = 0;
        for (int i = index - 1; i >= 0; i--) {
            valor += getListFluxocaixa().get(i).getRetornos();
        }
        return valor;
    }

    public double getReceita(int mes, int ano) {
        double valor = 0;
        for (Flr_fluxo_receitaT flr_fluxo_receitaT : listFlr) {
            if (flr_fluxo_receitaT.getFlr_nr_mes() == mes & flr_fluxo_receitaT.getFlr_nr_ano() == ano) {
                valor = flr_fluxo_receitaT.getFlr_nr_atual();
                break;
            }
        }
        return valor;
    }

    public void povoaTreeDesp(int mes, int ano) throws Exception {
        try {
            CronogramaDesembolsoSubClasseReprogJB classeReprogJB = new CronogramaDesembolsoSubClasseReprogJB();
            classeReprogJB.setPage(page);
            classeReprogJB.setTipo("R");
            classeReprogJB.setMesRef(mes);
            classeReprogJB.setAnoRef(ano);
            classeReprogJB.getVw_importacao_orcamentoT().setObr_nr_id(getObr_obrasT().getObr_nr_id());
            classeReprogJB.consult();
            treeDesp = classeReprogJB.getTreeTotalMes();
        } catch (Exception e) {
            throw e;
        }
    }

    public double getDespesas(int mes, int ano) throws Exception {
        double valor = 0;
        try {
            String key = mes + "." + ano;
            Meo_meses_obraT mt = treeDesp.get(key);
            if (mt != null) {
                valor = mt.getTotalMes();
            }

        } catch (Exception e) {
            throw e;
        }

        return valor;
    }

    /**
     * @return the fluxocaixa
     */
    public FluxoCaixaTMP getFluxocaixaT() {
        return fluxocaixaT;
    }

    /**
     * @param fluxocaixa the fluxocaixa to set
     */
    public void setFluxocaixaT(FluxoCaixaTMP fluxocaixaT) {
        this.fluxocaixaT = fluxocaixaT;
    }

    /**
     * @return the listFluxocaixa
     */
    public List<FluxoCaixaTMP> getListFluxocaixa() {
        return listFluxocaixa;
    }

    /**
     * @param listFluxocaixa the listFluxocaixa to set
     */
    public void setListFluxocaixa(List<FluxoCaixaTMP> listFluxocaixa) {
        this.listFluxocaixa = listFluxocaixa;
    }
}
