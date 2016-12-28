/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.cen_centro_custo.ListCentroCustoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento.List_Par_parcelamentoConsultGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Plc_plano_contasInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasInsertGWT.jsp";
    private Plc_plano_contasConsultGWT consultGWT;
    private int nivel;

    public Plc_plano_contasConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plc_plano_contasConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> plc_tx_nome = new TextField<String>();
    private ComboBox<Plc_plano_contasTGWT> listPlcSuper = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Par_parcelamentoTGWT> comboParc = new ComboBox<Par_parcelamentoTGWT>();
    private ComboBox<Cen_centro_custoTGWT> listCenrtoCusto = new ComboBox<Cen_centro_custoTGWT>();
    private CheckBox plc_tx_caixa_banco = new CheckBox("Caixa e Banco");
    private List_Par_parcelamentoConsultGWT listParc = new List_Par_parcelamentoConsultGWT();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ListCentroCustoGWT listCentroCustoGWT = new ListCentroCustoGWT();

    public void AddListBoxCentroCusto() throws Exception {
        listCenrtoCusto.setStore(listCentroCustoGWT.getStore());
        listCenrtoCusto.setDisplayField("cen_tx_nome");
        listCenrtoCusto.setAllowBlank(false);
        listCenrtoCusto.setTriggerAction(ComboBox.TriggerAction.ALL);
        listCenrtoCusto.setWidth(300);
    }

    public void AddListBoxClasseSuper() throws Exception {
        listPlcSuper.setStore(listPlc_planoContasGWT.getStore());
        listPlcSuper.setDisplayField("plc_tx_nome");
        listPlcSuper.setAllowBlank(false);
        listPlcSuper.setTriggerAction(ComboBox.TriggerAction.ALL);
        listPlcSuper.setWidth(300);
    }

    public Plc_plano_contasInsertGWT(int nivel) throws Exception {

        this.nivel = nivel;
        //consultGWT = new Plc_plano_contasConsultGWT(nivel);
        this.setHeading(nivel == 1 ? "Cadastro de Classes" : "Cadastro de Sub-Classes");
        this.setSize(500, 250);
        listParc.povoa();
        listCentroCustoGWT.povoa();
        listPlc_planoContasGWT.povoaSuperClasse();
        montarTela();
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    public void montarTela() {
        super.show();
        final int niv = this.nivel;
        try {
            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (!listPlc_planoContasGWT.isInserido()) {
                        schedule(500);
                    } else {
                        final Grid grid = new Grid(5, 2);
                        grid.setWidget(1, 0, new LabelField(niv == 1 ? "Classes" : "Sub-Classes"));
                        grid.setWidget(1, 1, plc_tx_nome);
                        plc_tx_nome.setAllowBlank(false);
                        plc_tx_nome.setWidth("330");
                        if (nivel == 1) {
                            try {
                                Timer timer = new Timer() {
                                    @Override
                                    public void run() {
                                        if (!listCentroCustoGWT.isPovoado()) {
                                            schedule(2000);
                                        } else {
                                            try {
                                                AddListBoxCentroCusto();
                                                grid.setWidget(2, 0, new LabelField("Natureza de Custo:"));
                                                grid.setWidget(2, 1, listCenrtoCusto);
                                            } catch (Exception e) {
                                            }

                                        }
                                    }
                                };
                                timer.schedule(1000);
                            } catch (Exception e) {
                            }

                        } else {
                            try {
                                Timer timer = new Timer() {

                                    @Override
                                    public void run() {
                                        if (!listParc.povoado) {
                                            schedule(2000);
                                        } else {
                                            try {
                                                AddListBoxClasseSuper();
                                                grid.setWidget(2, 0, new LabelField("Classe:"));
                                                grid.setWidget(2, 1, listPlcSuper);
                                                grid.setWidget(3, 0, new LabelField("Condição Pagto."));
                                                ListStore<Par_parcelamentoTGWT> storePar = new ListStore<Par_parcelamentoTGWT>();
                                                storePar.add(listParc.getList());
                                                comboParc.setStore(storePar);
                                                comboParc.setDisplayField("par_tx_nome");
                                                comboParc.setEmptyText("Selecione a condição de pagamento");
                                                comboParc.setAllowBlank(false);
                                                grid.setWidget(3, 1, comboParc);
                                            } catch (Exception ex) {
                                            }

                                        }
                                    }
                                };
                                timer.schedule(1000);

                            } catch (Exception e) {
                            }
                        }
                        getCpMaster().add(grid);
                        layout();
                        doLayout();
                    }
                }
            };
            timer.schedule(500);
        } catch (Exception e) {
        }
    }

    public boolean valido() {
        boolean result = true;

        //Window.alert(""+listCenrtoCusto.getSelectedIndex());
        if (nivel == 1 && listCenrtoCusto.getValue() == null) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Centro de custo tem preenchimento obrigatório!!", null);
        } else if (nivel == 2 && listPlcSuper.getValue() == null) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Super Classe tem preenchimento obrigatório!!", null);
        } else if (plc_tx_nome.getValue().length() == 0) {
            result = false;
            getMbMaster().alert("IMPORTANTE", "O campo Classe tem preenchimento obrigatório!!", null);
        } else if (nivel == 2 && comboParc.getValue() == null) {
            getMbMaster().alert("IMPORTANTE", "O campo Condição Pagamento tem preenchimento obrigatório!!", null);
        }

        return result;
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            if (valido()) {
                String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("op", "insert");
                param.put("plc_plano_contasT.plc_tx_nome", plc_tx_nome.getValue());
                if (nivel == 2) {
                    param.put("plc_plano_contasT.plc_nr_id_super", listPlcSuper.getValue().getPlc_nr_id() + "");
                    param.put("plc_plano_contasT.par_nr_id", comboParc.getValue().getPar_nr_id() + "");
                } else {
                    param.put("plc_plano_contasT.cen_nr_id", listCenrtoCusto.getValue().getCen_nr_id() + "");
                }

                EasyAccessURL eaurl = new EasyAccessURL(this);
                eaurl.accessJSonMap(url, param);
                consultGWT.load();
            }
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            String msg = EasyContainer.clearAspas(jsonObject.get("resultado").toString());
            if (msg.toUpperCase().indexOf("SUCESSO") > -1) {
                getShowMsgCadastro();
                clearFields();
                //plc_tx_nome.setFocus(true);
            } else {
                MessageBox.alert("Falha", msg, null);
            }

        }
    }

    public void clearFields() {
        plc_tx_nome.setValue("");
        if (this.nivel == 1) {
            listCenrtoCusto.setValue(null);
        } else {
            comboParc.setValue(null);
            listPlcSuper.setValue(null);
        }
    }
}

