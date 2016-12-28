/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.grafico.custo_classes;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Inc_informacoes_custoDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.relatorios.custo_classe_regime_competencia.CustoClasseRegimeCompetencia;
import br.com.easynet.gwt.easyportal.temp.Custo_classe_regime_competenciaTMP;
import br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Custo_classesGrafico extends RelatorioBase implements INotSecurity {

    private List<Meo_meses_obraT> listMses = new ArrayList<Meo_meses_obraT>();
    private String cod_item;
    public double valorMesref;
    public double ultimovalorMes;
    public TreeMap<Integer, String> treeCod_item = new TreeMap<Integer, String>();
    private int plc_nr_id;
    private Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
    private double maiorValor;
    private double menorValor;
    private String custoAc;
    private String custoPer;
    private CustoClasseRegimeCompetencia custo = new CustoClasseRegimeCompetencia();
    private Custo_classe_regime_competenciaTMP CustoTemp;

    public Custo_classesGrafico() {
    }

    public void povoaTreeCodigo() {
        treeCod_item.put(65, "2");
        treeCod_item.put(204, "3");
        treeCod_item.put(191, "4");
        treeCod_item.put(37, "5");
        treeCod_item.put(38, "6");
        treeCod_item.put(82, "7");
        treeCod_item.put(55, "8");
        treeCod_item.put(56, "9");
        treeCod_item.put(57, "10");
//        treeCod_item.put(65, "11");
//        treeCod_item.put(65, "12");
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        custo.setPage(page);
        custo.setObr_obrasT(getObr_obrasT());
    }

    public void imprimir() {
        try {
            getClasse();
            //setValueParamenter();
            povoaTreeCodigo();
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            listMses = obr_obrasDAO.getAllMeses(getObr_obrasT());

//            listMses.get(0).setTotalMes(0.8924);
//            listMses.get(1).setTotalMes(0.7944);
//            listMses.get(listMses.size() - 1).setTotalMes(0.9725);

            getValorMesesAtePeriodo();
            setValorUltimoMes();
            calcularMesesSubsequente(valorMesref, ultimovalorMes);
            setValueParamenter();
            jRDataSource = new JRBeanCollectionDataSource(listMses);
            if (!getTipo().equalsIgnoreCase("XLS")) {
                is = Custo_classesGrafico.class.getResourceAsStream("custo_classe.jasper");
            } else {
                url = Custo_classesGrafico.class.getResource("custo_classe.jasper");
            }
            //easyEngenharia/easyconstru/graficos/custos_classesGraficos.jsp?op=imprimir&obr_obrasT.obr_nr_id=43&meo_meses_obraT.mes=3&meo_meses_obraT.ano=2011&tipo=PDF&plc_plano_contasT.plc_nr_id=65

            print("graf", "CUSTO DOS " + getPlc_plano_contasT().getPlc_tx_nome().toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void setValorUltimoMes() throws Exception {
        try {
            custo.setMeo_meses_obraT(getMeo_meses_obraT());
            custo.povoarLista();
            ultimovalorMes = custo.getList().get(custo.getList().size() - 1).getAcum_prev_realiz();
        } catch (Exception e) {
            throw e;
        }

    }

    public void setValueParamenter() throws Exception {
        try {
            Inc_informacoes_custoDAO idao = getInc_informacoes_custoDAO();
            List<Inc_informacoes_custoT> lista = new ArrayList<Inc_informacoes_custoT>();
            Inc_informacoes_custoT incT = new Inc_informacoes_custoT();
            incT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            incT.setInc_nr_ano(getMeo_meses_obraT().getAno());
            incT.setInc_nr_mes(getMeo_meses_obraT().getMes());
            lista = idao.getByInformacaoCusto(incT);
            lista.get(0).setInc_nr_custo_periodo(new BigDecimal(CustoTemp.getCusto_realizado() - CustoTemp.getCustos_previsto()).floatValue());
            lista.get(0).setInc_tx_custo_acumulado(new BigDecimal(CustoTemp.getAcum_realizado() - CustoTemp.getAcum_previsto()).floatValue());

            setMenorMaiorvalor();
            lista.get(0).setInc_tx_custo_eco_excede_acum("ECONOMIA");
            lista.get(0).setInc_tx_custo_eco_excede_periodo("ECONOMIA");
            if (lista.get(0).getInc_tx_custo_acumulado() > 0) {
                lista.get(0).setInc_tx_custo_eco_excede_acum("EXCEDENTE");
            }
            if (lista.get(0).getInc_nr_custo_periodo() > 0) {
                lista.get(0).setInc_tx_custo_eco_excede_periodo("EXCEDENTE");
            }

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
            getParameters().put("informacoes", dataSource);
            getParameters().put("titilo_grafico", "Custos Previstos X Realizados " + getPlc_plano_contasT().getPlc_tx_nome());
            getParameters().put("menor_valor", menorValor);
            getParameters().put("maior_valor", maiorValor);
            getParameters().put("custo_acumulado", custoAc);
            getParameters().put("custo_periodo", custoPer);
        } catch (Exception e) {
        }
    }

    public void setMenorMaiorvalor() {
        for (Meo_meses_obraT meo_meses_obraT : listMses) {
            if (menorValor > meo_meses_obraT.getTotalMes()) {
                menorValor = meo_meses_obraT.getTotalMes();
            }
            if (maiorValor < meo_meses_obraT.getTotalMes()) {
                maiorValor = meo_meses_obraT.getTotalMes();
            }
        }
    }

    public void getValorMesesAtePeriodo() throws Exception {

        //custo.setMeo_meses_obraT(getMeo_meses_obraT());
        boolean calcular = true;

        for (Meo_meses_obraT meo_meses_obraT : listMses) {
            if (calcular) {
                custo.getMeo_meses_obraT().setAno(meo_meses_obraT.getAno());
                custo.getMeo_meses_obraT().setMes(meo_meses_obraT.getMes());
                CustoTemp = custo.getItemRealizadoPrevisto(treeCod_item.get(plc_plano_contasT.getPlc_nr_id()));
                meo_meses_obraT.setTotalMes(CustoTemp.getAcum_prev_realiz());
            }
            if (getMeo_meses_obraT().getMes() == meo_meses_obraT.getMes() & meo_meses_obraT.getAno() == getMeo_meses_obraT().getAno()) {
                calcular = false;
                valorMesref = meo_meses_obraT.getTotalMes();
            }
        }
    }

    public void calcularMesesSubsequente(double inicio, double fim) {
        double diferenca = fim - inicio;
        diferenca = diferenca;
        double qtMesesRestante = getQtMesrestante(getMeo_meses_obraT().getMes(), getMeo_meses_obraT().getAno());
        double valor = diferenca / qtMesesRestante;
        boolean calcular = false;
        double valorMescalculado = 0;
        for (Meo_meses_obraT meo_meses_obraT : listMses) {
            if (calcular) {
                valorMescalculado += valor;
                meo_meses_obraT.setTotalMes(valorMescalculado);
            }
            if (getMeo_meses_obraT().getMes() == meo_meses_obraT.getMes() & getMeo_meses_obraT().getAno() == meo_meses_obraT.getAno()) {
                calcular = true;
                valorMescalculado = meo_meses_obraT.getTotalMes();
            }
        }
    }

    public int getQtMesrestante(int mes, int ano) {
        int qt = 0;
        boolean iniciar_contagem = false;
        for (Meo_meses_obraT meo_meses_obraT : listMses) {
            if (mes == meo_meses_obraT.getMes() & ano == meo_meses_obraT.getAno()) {
                iniciar_contagem = true;
            }
            if (iniciar_contagem) {
                qt++;
            }
        }
        return qt - 1;
    }

    /**
     * @return the cod_item
     */
    public String getCod_item() {
        return cod_item;
    }

    /**
     * @param cod_item the cod_item to set
     */
    public void setCod_item(String cod_item) {
        this.cod_item = cod_item;
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

    private void getClasse() throws Exception {
        try {
            Plc_plano_contasDAO pdao = getPlc_plano_contasDAO();
            if (plc_nr_id > 0) {
                plc_plano_contasT.setPlc_nr_id(plc_nr_id);
            }
            setPlc_plano_contasT(pdao.getByPlc_nr_id(plc_plano_contasT).get(0));

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * @return the plc_plano_contasT
     */
    public Plc_plano_contasT getPlc_plano_contasT() {
        return plc_plano_contasT;
    }

    /**
     * @param plc_plano_contasT the plc_plano_contasT to set
     */
    public void setPlc_plano_contasT(Plc_plano_contasT plc_plano_contasT) {
        this.plc_plano_contasT = plc_plano_contasT;
    }
}
