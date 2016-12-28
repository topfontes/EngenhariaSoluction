/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import com.extjs.gxt.ui.client.widget.form.TextField;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo.ListCentroCustoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento.List_Par_parcelamentoConsultGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowCloseListener;
import com.google.gwt.user.client.ui.CheckBox;

/**
 *
 * @author geoleite
 */
public class Plc_plano_contasUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasUpdateDeleteGWT.jsp";
    private TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> plc_tx_nome = new TextField<String>();
    //private ListBox listPlcSuper = new ListBox();
    //private ListBox listCenrtoCusto = new ListBox();
    private CheckBox plc_tx_caixa_banco = new CheckBox("Caixa e Banco");
    private Plc_plano_contasTGWT plc_plano_contasTGWT = new Plc_plano_contasTGWT();
    private Plc_plano_contasConsultGWT consultGWT;
    private int nivel;
    private ListPlc_planoContasGWT listPlcConT = new ListPlc_planoContasGWT();
    private List_Par_parcelamentoConsultGWT listParc = new List_Par_parcelamentoConsultGWT();
    private ListCentroCustoGWT listCentroCustoGWT = new ListCentroCustoGWT();
    private ComboBox<Par_parcelamentoTGWT> comboParc = new ComboBox<Par_parcelamentoTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboSuper = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Cen_centro_custoTGWT> comboCentro = new ComboBox<Cen_centro_custoTGWT>();
    private Par_parcelamentoTGWT par_parcelamentoTGWT;
    private Cen_centro_custoTGWT cen_centro_custoTGWT = new Cen_centro_custoTGWT();
    private Plc_plano_contasTGWT plcSuper = new Plc_plano_contasTGWT();

    public Plc_plano_contasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plc_plano_contasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Plc_plano_contasUpdateDeleteGWT(int nivel) {

        //consultGWT = new Plc_plano_contasConsultGWT(nivel);
        this.nivel = nivel;
        //consultGWT = new Plc_plano_contasConsultGWT(nivel);
        listCentroCustoGWT.povoa();
        listPlcConT.povoaSuperClasse();
        listParc.povoa();
        this.setHeading(nivel == 1 ? "Alteração de Classes" : "Alteração de Sub-Classes");
        this.setSize(500, 200);
    }

    public void montarTela() {
        try {
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (!listParc.povoado) {
                        schedule(50);
                    } else {
                        Timer ti = new Timer() {
                            @Override
                            public void run() {
                                if (!listPlcConT.isInserido()) {
                                    schedule(50);
                                } else {
                                    Grid grid = new Grid(5, 2);
                                    grid.setWidget(1, 0, new LabelField("Classe:"));
                                    grid.setWidget(1, 1, plc_tx_nome);
                                    plc_tx_nome.setWidth("330");
                                    if (nivel == 1) {
                                        try {
                                            ListStore<Cen_centro_custoTGWT> storeCentro = new ListStore<Cen_centro_custoTGWT>();
                                            storeCentro.add(listCentroCustoGWT.getList());
                                            comboCentro.setStore(storeCentro);
                                            comboCentro.setDisplayField("cen_tx_nome");
                                            comboCentro.setValueField("cen_nr_id");
                                            comboCentro.setWidth(330);
                                            comboCentro.setForceSelection(true);
                                            comboCentro.setTriggerAction(ComboBox.TriggerAction.ALL);
                                            if (plc_plano_contasTGWT.getCen_nr_id() > 0) {
                                                comboCentro.setValue(listCentroCustoGWT.getTreecentro().get(plc_plano_contasTGWT.getCen_nr_id()));
                                            }
                                            grid.setWidget(2, 0, new LabelField("Natureza de Custo:"));
                                            grid.setWidget(2, 1, comboCentro);
                                        } catch (Exception e) {
                                        }
                                    } else {
                                        try {

                                            ListStore<Plc_plano_contasTGWT> storesuper = new ListStore<Plc_plano_contasTGWT>();
                                            storesuper.add(listPlcConT.getList());

                                            comboSuper.setStore(storesuper);
                                            comboSuper.setValueField("plc_nr_id");
                                            comboSuper.setDisplayField("plc_tx_nome");
                                            comboSuper.setWidth(330);
                                            comboSuper.setForceSelection(true);
                                            comboSuper.setTriggerAction(ComboBox.TriggerAction.ALL);

                                            if (plcSuper != null) {
                                                comboSuper.setValue(plcSuper);
                                            }

                                            grid.setWidget(2, 0, new LabelField("Classe:"));
                                            grid.setWidget(2, 1, comboSuper);
                                            grid.setWidget(3, 0, new LabelField("Condição Pagto."));
                                            ListStore<Par_parcelamentoTGWT> storePar = new ListStore<Par_parcelamentoTGWT>();
                                            storePar.add(listParc.getList());
                                            comboParc.setStore(storePar);
                                            comboParc.setDisplayField("par_tx_nome");
                                            comboParc.setEmptyText("Selecione a condição de pagamento");
                                            comboParc.setWidth(330);
                                            comboParc.setAutoValidate(true);
                                            grid.setWidget(3, 1, comboParc);

                                            if (plc_plano_contasTGWT.getPar_nr_id() > 0) {
                                                comboParc.setValue(listParc.getTreeParcela().get(plc_plano_contasTGWT.getPar_nr_id()));
                                            }
                                        } catch (Exception e) {
                                        }
                                    }
                                    getCpMaster().add(grid);
                                    layout();
                                    doLayout();
                                }
                            }
                        };
                        ti.schedule(50);
                    }
                }
            };
            timer.schedule(50);
        } catch (Exception e) {
        }
    }

    public void load(Plc_plano_contasTGWT plc_plano_contasTGWT) {
        try {
            this.plc_plano_contasTGWT = plc_plano_contasTGWT;
            plc_tx_nome.setValue(plc_plano_contasTGWT.getPlc_tx_nome());
            plcSuper.setPlc_nr_id(plc_plano_contasTGWT.getPlc_nr_id_super());
            plcSuper.setPlc_tx_nome(plc_plano_contasTGWT.getPlc_tx_super());
            montarTela();
        } catch (Exception ex) {
        } finally {
            this.layout();
        }
    }

    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        if (valido()) {
            try {
                String url = Constantes.URL + PAGE;
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "update");
                param.put("plc_plano_contasT.plc_nr_id", plc_plano_contasTGWT.getPlc_nr_id() + "");
                param.put("plc_plano_contasT.plc_tx_nome", plc_tx_nome.getValue());
                if (nivel == 2) {
                    param.put("plc_plano_contasT.plc_nr_id_super", comboSuper.getValue().getPlc_nr_id() + "");
                    param.put("plc_plano_contasT.par_nr_id", comboParc.getValue().getPar_nr_id() + "");
                }
                if (nivel == 1) {
                    param.put("plc_plano_contasT.cen_nr_id", comboCentro.getValue().getCen_nr_id() + "");
                }
                param.put("plc_plano_contasT.plc_tx_caixa_banco", plc_tx_caixa_banco.getValue() ? "S" : "N");

                EasyAccessURL eaurl = new EasyAccessURL(this);
                eaurl.accessJSonMap(url, param);
                //consultGWT.load();
            } catch (Exception ex) {
            }
        }
    }

    public boolean valido() {
        boolean result = true;
        if (plc_tx_nome.getValue().length() == 0) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Classe tem preenchimento obrigatório!!", null);
        } else if (nivel == 2 & comboParc.getValue() == null) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Parcelamento tem preenchimento obrigatório!!", null);
        } else if (nivel == 1 & comboCentro.getValue() == null) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Centro Custo tem preenchimento obrigatório!!", null);
        }
        return result;
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("plc_plano_contasT.plc_nr_id", plc_plano_contasTGWT.getPlc_nr_id() + "");
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            String msg = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
            if (msg.toUpperCase().indexOf("SUCESSO") > -1) {
                getShowMsgAlteracao();
                consultGWT.load();
                this.close();
            } else {
                MessageBox.alert("Falha", msg, null);
            }

        }
    }
}


