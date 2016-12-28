/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.par_parcelamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.extjs.gxt.ui.client.widget.form.LabelField;

import java.util.HashMap;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import br.com.easynet.gwt.easyportal.client.CadastroGWT;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author geoleite
 */
public class Par_parcelamentoInsertGWT extends CadastroGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoInsertGWT.jsp";
    private Par_parcelamentoConsultGWT consultGWT = new Par_parcelamentoConsultGWT();
    private List<Inp_intervalo_parcelaTGWT> listIntervalo;

    public Par_parcelamentoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Par_parcelamentoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }
    private TextField<String> par_nr_id = new TextField<String>();
    private TextField<String> par_tx_nome = new TextField<String>();
    private NumberField par_nr_parcelas = new NumberField();
    private NumberField par_nr_intervalo_dias = new NumberField();
    private NumberField diasPrimeiraPar = new NumberField();
    private ContentPanel contentPanel = new ContentPanel();
    private ContentPanel contentMaster = new ContentPanel();
    private String intervalo;
    private ListStore<Inp_intervalo_parcelaTGWT> store = new ListStore<Inp_intervalo_parcelaTGWT>();

    public Par_parcelamentoInsertGWT() {
        store.setMonitorChanges(true);
        this.setHeading("Cadastro Condição de Pagamento");
        contentMaster.setHeaderVisible(false);
        this.setSize(670, 220);
        Grid gridMaster = new Grid(1, 2);
        Grid grid = new Grid(5, 2);

        grid.setWidget(1, 0, new LabelField("Nome:"));
        grid.setWidget(1, 1, par_tx_nome);
        par_tx_nome.setWidth("300");

        grid.setWidget(2, 0, new LabelField("N. Parcelas:"));
        grid.setWidget(2, 1, par_nr_parcelas);
        par_nr_parcelas.setWidth("30");
        Grid grid1 = new Grid(1, 4);
        par_nr_intervalo_dias.setWidth("30");
        grid1.setWidget(0, 0, par_nr_intervalo_dias);
        grid1.setWidget(0, 1, new LabelField("Prazo Primeira parcelas(dias):"));
        diasPrimeiraPar.setWidth("30");
        grid1.setWidget(0, 2, diasPrimeiraPar);
        com.extjs.gxt.ui.client.widget.button.Button button = new com.extjs.gxt.ui.client.widget.button.Button("Gerar Intervalos");
        button.addListener(Events.OnClick, new Listener<ButtonEvent>() {

            public void handleEvent(ButtonEvent be) {
                gerar();
            }
        });

        grid1.setWidget(0, 3, button);

        grid.setWidget(3, 0, new LabelField("Intervalo entre parcela(dias):"));
        grid.setWidget(3, 1, grid1);

        par_nr_intervalo_dias.setWidth("30");


        gridMaster.setWidget(0, 0, grid);
        gridMaster.setWidget(0, 1, contentPanel);
        contentPanel.setWidth(130);
        contentPanel.setHeading("Intervalos Parcela");
        //contentPanel.setHeaderVisible(false);
        getCpMaster().add(gridMaster);
        this.layout();
    }

    public boolean dadosvalido() {
        boolean res = true;
        if (par_nr_parcelas.getValue() == null || par_nr_parcelas.getValue().doubleValue() < 1) {
            res = false;
            Window.alert("O campo número de parcelas tem preenchimento obrigatório!");
        } else if (par_nr_intervalo_dias.getValue() == null || par_nr_intervalo_dias.getValue().doubleValue() < 1) {
            res = false;
            Window.alert("O campo intervalo entre parcelas tem preenchimento obrigatório!");
        } else if (diasPrimeiraPar.getValue() == null || diasPrimeiraPar.getValue().doubleValue() < 1) {
            res = false;
            Window.alert("O campo dias da primeira parcelas tem preenchimento obrigatório!");
        }
        return res;
    }

    public void gerar() {
        if (dadosvalido()) {

            int qtdePar = Integer.parseInt(par_nr_parcelas.getValue().toString());
            listIntervalo = new Vector();
            for (int i = 0; i < qtdePar; i++) {
                Inp_intervalo_parcelaTGWT inpT = new Inp_intervalo_parcelaTGWT();
                int seq = i + 1;
                inpT.setInp_nr_sequencia(seq);
                int inicio = Integer.parseInt(diasPrimeiraPar.getValue().toString());
                inpT.setInp_nr_dias((i * Integer.parseInt(par_nr_intervalo_dias.getValue().toString())) + inicio);
                listIntervalo.add(inpT);
            }

            List<ColumnConfig> lisConfig = new ArrayList<ColumnConfig>();
            ColumnConfig config = new ColumnConfig("inp_nr_sequencia", "Seq.", 50);

            lisConfig.add(config);
            config = new ColumnConfig("inp_nr_dias", "Dias.", 50);
            NumberField nf = new NumberField();
            config.setEditor(new CellEditor(nf));
            lisConfig.add(config);
            ColumnModel cm = new ColumnModel(lisConfig);
            store = new ListStore<Inp_intervalo_parcelaTGWT>();
            store.add(listIntervalo);
            com.extjs.gxt.ui.client.widget.grid.EditorGrid<Inp_intervalo_parcelaTGWT> grid = new com.extjs.gxt.ui.client.widget.grid.EditorGrid<Inp_intervalo_parcelaTGWT>(store, cm);
            grid.setStripeRows(true);
            if (contentPanel.getItems().size() > 0) {
                contentPanel.removeAll();
            }
            contentPanel.add(grid);
            contentPanel.layout();
            layout();
            doLayout();
        }
    }

    @Override
    public void btnInsertAction(ButtonEvent ce) {
        btnCadAction(ce);
    }

    @Override
    public void btnLimpartAction(ButtonEvent ce) {
        par_tx_nome.setValue("");
        par_nr_parcelas.setValue(null);
        par_nr_intervalo_dias.setValue(null);
        diasPrimeiraPar.setValue(null);
        store.removeAll();
        
    }

    private void btnCadAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "insert");
//            param.put("par_parcelamentoT.par_nr_id", par_nr_id.getValue());

            param.put("par_parcelamentoT.par_tx_nome", par_tx_nome.getValue());

            param.put("par_parcelamentoT.par_nr_parcelas", par_nr_parcelas.getValue() + "");

            param.put("par_parcelamentoT.par_nr_intervalo_dias", par_nr_intervalo_dias.getValue() + "");

            String inter = getIntervalos();

            param.put("semRef", inter);

            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    public String getIntervalos() {
        Window.alert("0");
        store.commitChanges();
        Window.alert("1");
        List<Inp_intervalo_parcelaTGWT> list = store.getModels();
        Window.alert("2");
        String inter = "0&";
        Window.alert("lista "+ list.size());
        for (Inp_intervalo_parcelaTGWT inpT : list) {
            inter += "intervalo=" + inpT.getInp_nr_dias() + "&";
        }
        return inter;
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            if (jsonObject.get("resultado").toString().indexOf("sucesso") != -1) {
                getShowMsgCadastro();
                btnLimpartAction(null);
                consultGWT.load();
            } else {
                getShowMsgErro(jsonObject.get("resultado").toString());
            }
        }
    }
}

