/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.inc_informacoes_custo;

import br.com.easynet.gwt.easyportal.client.Ano;
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
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.plc_plano_contas.ListPlc_planoContasGWT;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Inc_informacoes_custoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoInsertGWT.jsp";
    private Inc_informacoes_custoConsultGWT consultGWT = new Inc_informacoes_custoConsultGWT();

    public Inc_informacoes_custoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Inc_informacoes_custoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private DateTimeFormat dtf = DateTimeFormat.getFormat("dd/MM/yyyy");
    private TextField<String> inc_nr_id = new TextField<String>();
    public TextField<String> obr_nr_id = new TextField<String>();
    public TextField<String> inc_nes_nr_id = new TextField<String>();
    public TextField<String> inc_nr_ano = new TextField<String>();
    public TextField<String> plc_nr_id = new TextField<String>();
    private TextField<String> inc_tx_custo_acumulado = new TextField<String>();
    private TextField<String> inc_nr_custo_periodo = new TextField<String>();
    private TextField<String> inc_tx_calsas = new TextField<String>();
    private TextField<String> inc_tx_problemas = new TextField<String>();
    private TextField<String> inc_tx_acoes = new TextField<String>();
    private TextField<String> inc_tx_responsavel = new TextField<String>();
    private DateField inc_dt_prazo = new DateField();
    private ComboBox<Obr_obrasTGWT> cbObra = new ComboBox<Obr_obrasTGWT>();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private Button btnfil = new Button("Filtrar");
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Meses> cbMes = new ComboBox<Meses>();
    private ComboBox<Ano> cbAno = new ComboBox<Ano>();
    private ComboBox<Plc_plano_contasTGWT> cbplc = new ComboBox<Plc_plano_contasTGWT>();

    public Inc_informacoes_custoInsertGWT() {
        this.setHeading("Cadastro informação obra");
        this.setSize(500, 230);

        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(4);
        getCpMaster().setLayout(layout);

        getCpMaster().add(new LabelField("Calsas:"));
        getCpMaster().add( inc_tx_calsas);
        inc_tx_calsas.setWidth("300");

        getCpMaster().add( new LabelField("Problemas:"));
        getCpMaster().add( inc_tx_problemas);
        inc_tx_problemas.setWidth("300");

        getCpMaster().add( new LabelField("Ações:"));
        getCpMaster().add( inc_tx_acoes);
        inc_tx_acoes.setWidth("300");

        getCpMaster().add( new LabelField("Responsável:"));
        getCpMaster().add(inc_tx_responsavel);
        inc_tx_responsavel.setWidth("300");

        getCpMaster().add( new LabelField("Prazo:"));
        getCpMaster().add( inc_dt_prazo);

        layout();
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

            param.put("inc_informacoes_custoT.obr_nr_id", obr_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_nr_mes", inc_nes_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_nr_ano", inc_nr_ano.getValue());

            param.put("inc_informacoes_custoT.plc_nr_id", plc_nr_id.getValue());

            param.put("inc_informacoes_custoT.inc_tx_custo_acumulado", inc_tx_custo_acumulado.getValue());

            param.put("inc_informacoes_custoT.inc_nr_custo_periodo", inc_nr_custo_periodo.getValue());

            param.put("inc_informacoes_custoT.inc_tx_calsas", inc_tx_calsas.getValue());

            param.put("inc_informacoes_custoT.inc_tx_problemas", inc_tx_problemas.getValue());

            param.put("inc_informacoes_custoT.inc_tx_acoes", inc_tx_acoes.getValue());

            param.put("inc_informacoes_custoT.inc_tx_responsavel", inc_tx_responsavel.getValue());

            param.put("inc_informacoes_custoT.inc_dt_prazo", dtf.format(inc_dt_prazo.getValue()));

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            Window.alert("Result " + jsonObject.get("resultado").toString());
            close();
        }
    }
}
