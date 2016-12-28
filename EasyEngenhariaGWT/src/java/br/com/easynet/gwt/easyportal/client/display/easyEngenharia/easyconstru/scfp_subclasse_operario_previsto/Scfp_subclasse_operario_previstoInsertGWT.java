/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.scfp_subclasse_operario_previsto;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.List_plco_plano_contas_orcamentoGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plco_plano_contas_orcamento.PlcoConsult;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Scfp_subclasse_operario_previstoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoInsertGWT.jsp";
    private Scfp_subclasse_operario_previstoConsultGWT consultGWT = new Scfp_subclasse_operario_previstoConsultGWT();
    private Scfp_subclasse_operario_previstoTGWT scfp_subclasse_operario_previstoTGWT = new Scfp_subclasse_operario_previstoTGWT();

    public Scfp_subclasse_operario_previstoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Scfp_subclasse_operario_previstoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    } 
    private TextBox scfp_nr_id = new TextBox();
    private TextBox plc_nr_id = new TextBox();
    private ComboBox<Plco_plano_contas_orcamentoTGWT> comboPlc = new ComboBox<Plco_plano_contas_orcamentoTGWT>();
    private PlcoConsult listPlcoGWT = new PlcoConsult();

    public Scfp_subclasse_operario_previstoInsertGWT() {
        this.setHeading("Cadastro Sub-Classe da Coluna Operário Previsto(Planilha HH)");
        this.setSize(480, 130);
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(5);
        getCpMaster().setLayout(layout);
        listPlcoGWT.consultarNivel(5);
        montarTela();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listPlcoGWT.isPovoado()) {
                    schedule(500);
                } else {
                    getCpMaster().add(new LabelField("Sub-Classe:"));
                    addCombo();
                    getCpMaster().add(comboPlc);
                    layout();
                    doLayout();
                }
            }
        };
        timer.schedule(500);
    }

    public void addCombo() {
        comboPlc.setStore(listPlcoGWT.getStore());
        comboPlc.setAllowBlank(false);
        comboPlc.setTriggerAction(ComboBox.TriggerAction.ALL);
        comboPlc.setDisplayField("plco_tx_nome");
        comboPlc.setWidth(300);
    }

//    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
            param.put("scfp_subclasse_operario_previstoT.plco_nr_id", comboPlc.getValue().getPlco_nr_id() + "");
            scfp_subclasse_operario_previstoTGWT.setPlco_nr_id(comboPlc.getValue().getPlco_nr_id());
            scfp_subclasse_operario_previstoTGWT.setSubClasse(comboPlc.getValue().getPlco_tx_nome());
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
                JSONObject registro = resultado.get(1).isObject();
                int id = Integer.parseInt(EasyContainer.clearAspas(registro.get("id").toString()));
                if (id > 0) {
                    scfp_subclasse_operario_previstoTGWT.setScfp_nr_id(id);
                    consultGWT.store.insert(scfp_subclasse_operario_previstoTGWT, consultGWT.store.getCount());
                    Info.display("", "Cadastro efetuado com sucesso");
                }
            }else{
                getShowMsgErro("Erro ao tentar inserir registro");
            }
        }
    }
}

