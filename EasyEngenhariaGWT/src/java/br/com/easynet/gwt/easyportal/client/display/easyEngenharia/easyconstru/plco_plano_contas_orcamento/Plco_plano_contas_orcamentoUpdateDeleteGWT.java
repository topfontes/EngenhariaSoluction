/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import com.extjs.gxt.ui.client.widget.form.TextField;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.eplc_equivalencia_plano_contas.Eplc_equivalencia_plano_contasConsultGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.Time;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;

/**
 *
 * @author geoleite
 */
public class Plco_plano_contas_orcamentoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDeleteGWT.jsp";
    private TextField<String> plco_nr_id = new TextField<String>();
    private TextField<String> plco_tx_nome = new TextField<String>();
    private TextField<String> plco_tx_tipo = new TextField<String>();
    private TextField<String> plco_tx_cod_externo = new TextField<String>();
    private TextField<String> plco_tx_unidade = new TextField<String>();
    private NumberField plco_nr_id_super = new NumberField();
    private NumberField par_nr_id = new NumberField();
    private ComboBox<Plc_plano_contasTGWT> comboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ContentPanel cp = new ContentPanel();
    private Plco_plano_contas_orcamentoTGWT plco_plano_contas_orcamentoTGWT = new Plco_plano_contas_orcamentoTGWT();
    private Plco_plano_contas_orcamentoConsultGWT consultGWT = new Plco_plano_contas_orcamentoConsultGWT();
    private int id_equivalencia;

    public Plco_plano_contas_orcamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plco_plano_contas_orcamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Plco_plano_contas_orcamentoUpdateDeleteGWT() {
        this.setSize(460, 220);
        this.setHeading("Alterar Função/Insumo");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(5);
        cp.setLayout(layout);
        listPlc_planoContasGWT.povoa();
        cp.setHeaderVisible(false);
        id_equivalencia = 0;
        montar();
    }

    public void montar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listPlc_planoContasGWT.isInserido() || id_equivalencia ==0) {
                    schedule(500);
                    Info.display("1","");
                } else {

                    cp.add(new LabelField("Função/Insumo:"));
                    plco_tx_nome.setWidth(250);
                    cp.add(plco_tx_nome);

//                    plco_tx_tipo.setEmptyText("Ex: MO,SERV,MAT.");
//                    plco_tx_tipo.setAllowBlank(false);
//                    cp.add(new LabelField("Tipo:"));
//                    cp.add(plco_tx_tipo);

                    plco_tx_unidade.setAllowBlank(false);
                    cp.add(new LabelField("Unidade:"));
                    cp.add(plco_tx_unidade);

                    cp.add(new LabelField("Sub-Classe Equivalete:"));
                    comboSubClasse.setStore(listPlc_planoContasGWT.getStore());
                    comboSubClasse.setDisplayField("plc_tx_nome");
                    comboSubClasse.setAllowBlank(false);
                    comboSubClasse.setWidth(250);
                    comboSubClasse.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboSubClasse.setValue(listPlc_planoContasGWT.getTreePlc().get(id_equivalencia));

                    cp.add(comboSubClasse);

                    getCpMaster().add(cp);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void load(final Plco_plano_contas_orcamentoTGWT plco_plano_contas_orcamentoTGWT) {
        try {
            this.plco_plano_contas_orcamentoTGWT = plco_plano_contas_orcamentoTGWT;
            plco_tx_nome.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_nome());
            plco_tx_tipo.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_tipo());
            plco_tx_unidade.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_unidade());
            plco_tx_tipo.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_tipo());
            plco_tx_unidade.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_unidade());
//            par_nr_id.setValue(plco_plano_contas_orcamentoTGWT.getPar_nr_id());
//            plco_tx_cod_externo.setValue(plco_plano_contas_orcamentoTGWT.getPlco_tx_cod_externo());
//            plco_nr_id_super.setValue(plco_plano_contas_orcamentoTGWT.getPlco_nr_id_super());


            Timer timer = new Timer() {

                @Override
                public void run() {
                    if (!listPlc_planoContasGWT.isInserido()) {
                        schedule(500);
                    } else {
                        Retorno retorno = new Retorno();
                        HashMap<String, String> param = new HashMap<String, String>();
                        param.put("op", "consult_equiv");
                        param.put("eplc_equivalencia_plano_contasT.plco_nr_id", plco_plano_contas_orcamentoTGWT.getPlco_nr_id() + "");
                        try {
                            EasyAccessURL eaurl = new EasyAccessURL(retorno);
                            eaurl.accessJSonMapNoProgress(Constantes.URL + Eplc_equivalencia_plano_contasConsultGWT.PAGE, param);
                        } catch (Exception e) {
                            
                        }
                    }
                }
            };
            timer.schedule(500);


        } catch (Exception ex) {
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
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");

            param.put("plco_plano_contas_orcamentoT.plco_nr_id", plco_plano_contas_orcamentoTGWT.getPlco_nr_id() + "");

            param.put("plco_plano_contas_orcamentoT.plco_nr_nivel", plco_plano_contas_orcamentoTGWT.getPlco_nr_nivel() + "");

            param.put("plco_plano_contas_orcamentoT.Plco_bl_equivalencia", plco_plano_contas_orcamentoTGWT.getPlco_bl_equivalencia() + "");

            param.put("plco_plano_contas_orcamentoT.plco_tx_nome", plco_tx_nome.getValue());

            //param.put("plco_plano_contas_orcamentoT.plco_tx_tipo", plco_tx_tipo.getValue());
            param.put("plco_plano_contas_orcamentoT.plco_tx_tipo", "M.O.");

            param.put("plco_plano_contas_orcamentoT.plco_tx_unidade", plco_tx_unidade.getValue());

            param.put("plco_plano_contas_orcamentoT.plco_tx_cod_externo", plco_plano_contas_orcamentoTGWT.getPlco_tx_cod_externo());

            param.put("subClasse", comboSubClasse.getValue().getPlc_nr_id() + "");

            plco_plano_contas_orcamentoTGWT.setPlco_tx_nome(plco_tx_nome.getValue());

            plco_plano_contas_orcamentoTGWT.setPlco_tx_tipo(plco_tx_tipo.getValue());

            plco_plano_contas_orcamentoTGWT.setPlco_tx_unidade(plco_tx_unidade.getValue());

//            plco_plano_contas_orcamentoTGWT.setPlco_tx_cod_externo(plco_tx_cod_externo.getValue());
//            plco_plano_contas_orcamentoTGWT.setPlco_nr_id_super(plco_nr_id_super.getValue().intValue());


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
//            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ToolBarEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("plco_plano_contas_orcamentoT.plco_nr_id", plco_nr_id.getValue());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if(jsonObject.toString().indexOf("sucesso") > -1){
                getShowMsgAlteracao();
                consultGWT.getStore().update(plco_plano_contas_orcamentoTGWT);
                consultGWT.getStore().commitChanges();
                this.close();
            }else{
                getShowMsgErro("Erro ao tentar alterar a função/insumo, por favor verifique se todos os campos estão preenchidos");
            }
        }
    }

    class Retorno implements IListenetResponse {
        public void read(JSONValue jsonValue) {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                
                if (resultado.size() > 1) {
                    JSONObject registro = resultado.get(1).isObject();
                    int id_plc = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    //Window.alert(id_plc+"");
                    if (id_plc > 0) {
                        id_equivalencia = id_plc;
//                        comboSubClasse.setValue(listPlc_planoContasGWT.getTreePlc().get(id_plc));
                        layout();
                    }else{
                        id_equivalencia = -1;
                    }
                }
            }
        }
    }
}

