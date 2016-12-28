/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.extjs.gxt.ui.client.widget.form.TextField;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plc_plano_contasTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Plco_plano_contas_orcamentoTGWT;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Plco_plano_contas_orcamentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoInsertGWT.jsp";
    private Plco_plano_contas_orcamentoConsultGWT consultGWT = new Plco_plano_contas_orcamentoConsultGWT();
    private Plco_plano_contas_orcamentoTGWT plco_plano_contas_orcamentoTGWT = new Plco_plano_contas_orcamentoTGWT();
    private TextField<String> plco_tx_nome = new TextField<String>();
    private TextField<String> plco_tx_tipo = new TextField<String>();
    private TextField<String> plco_tx_cod_externo = new TextField<String>();
    private TextField<String> plco_tx_unidade = new TextField<String>();
    private TextField<String> plco_nr_id_super = new TextField<String>();
    private ComboBox<Plc_plano_contasTGWT> comboSubClasse = new ComboBox<Plc_plano_contasTGWT>();
    private ListPlc_planoContasGWT listPlc_planoContasGWT = new ListPlc_planoContasGWT();
    private ContentPanel cp = new ContentPanel();

    public Plco_plano_contas_orcamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Plco_plano_contas_orcamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Plco_plano_contas_orcamentoInsertGWT() {
        this.setHeading("Cadastro de Funções/Insumos");
        this.setSize(460, 220);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(5);
        cp.setLayout(layout);
        listPlc_planoContasGWT.povoa();
        cp.setHeaderVisible(false);
        montar();
    }

    public void montar() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listPlc_planoContasGWT.isInserido()) {
                    schedule(500);
                } else {

                    cp.add(new LabelField("Função/Insumo:"));
                    plco_tx_nome.setAllowBlank(false);
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

                    cp.add(comboSubClasse);

                    getCpMaster().add(cp);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");

            param.put("plco_plano_contas_orcamentoT.plco_tx_nome", plco_tx_nome.getValue());
            //param.put("plco_plano_contas_orcamentoT.plco_tx_tipo", plco_tx_tipo.getValue());
            param.put("plco_plano_contas_orcamentoT.plco_tx_tipo", "M.O.");
            param.put("plco_plano_contas_orcamentoT.plco_tx_unidade", plco_tx_unidade.getValue());
            param.put("plco_plano_contas_orcamentoT.plco_nr_nivel", "5");
            param.put("plco_plano_contas_orcamentoT.plco_tx_cod_externo", "Sistema");
            param.put("plco_plano_contas_orcamentoT.Plco_bl_equivalencia", "true");
            param.put("subClasse", comboSubClasse.getValue().getPlc_nr_id() + "");

            plco_plano_contas_orcamentoTGWT.setPlco_tx_nome(plco_tx_nome.getValue());
            plco_plano_contas_orcamentoTGWT.setPlco_tx_tipo("M.O.");
            plco_plano_contas_orcamentoTGWT.setPlco_tx_unidade("H");

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);

        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonValue.toString().indexOf("sucesso") > -1) {
                JSONArray resultado = jsonObject.get("resultado").isArray();
                JSONObject object = resultado.get(1).isObject();
                int id = Integer.parseInt(EasyContainer.clearAspas(object.get("id").toString()));
                if (id > 0) {
                    plco_plano_contas_orcamentoTGWT.setPlco_nr_id(id);
                    plco_plano_contas_orcamentoTGWT.setPlco_tx_cod_externo("BC-"+id);
                    consultGWT.getStore().insert(plco_plano_contas_orcamentoTGWT, consultGWT.getStore().getCount());
                    getShowMsgCadastro();
                }
            }
        }
    }
}

