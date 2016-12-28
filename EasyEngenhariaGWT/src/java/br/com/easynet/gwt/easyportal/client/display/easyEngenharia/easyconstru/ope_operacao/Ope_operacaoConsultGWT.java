/*
 * EasyNet JDragon
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.ope_operacao;

import br.com.easynet.gwt.easyportal.client.BaseBorderLayoutGWT;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.google.gwt.json.client.JSONValue;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.Listener;

import java.util.ArrayList;
import java.util.List;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.met_metodo.ListMetodoGWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.per_perfil.Per_perfilConsultGWT;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.dnd.GridDragSource;
import com.extjs.gxt.ui.client.dnd.GridDropTarget;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.table.NumberCellRenderer;

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Timer;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author geoleitejjjjjjjjjjjjjjjjjjjjjjjjjjjj
 */
public class Ope_operacaoConsultGWT extends BaseBorderLayoutGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/ope_operacao/ope_operacaoConsultGWT.jsp";
    public static final String PAGEOPM = "easyEngenharia/easyconstru/opm_met_ope_per/opm_met_ope_perUpdateDeleteGWT.jsp";
    private List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
    final Ope_operacaoConsultGWT ope_operacaoConsultGWT = this;
    private Per_perfilConsultGWT consultGWT = new Per_perfilConsultGWT();
    private Per_perfilTGWT per_perfilTGWT = new Per_perfilTGWT();
    private ListMetodoGWT metodosVinc = new ListMetodoGWT();
    private ListMetodoGWT metodosNaoVinc = new ListMetodoGWT();
    // ContentPanel cpVinc = new ContentPanel();
    //  ContentPanel cpNotVinc = new ContentPanel();
    private GridDropTarget targetVinc;
    private GridDropTarget targetNotVinc;
    private BorderLayoutData dataWEST = new BorderLayoutData(LayoutRegion.WEST,100);
    private BorderLayoutData dataEAST = new BorderLayoutData(LayoutRegion.EAST,100);
    private ContentPanel cpLeste = new ContentPanel(new FillLayout());
    private ContentPanel cpOeste = new ContentPanel(new FillLayout());
    private Ope_operacaoTGWT ope_operacaoTGWT;

    public Ope_operacaoConsultGWT() {
        try {
            setLayout(new BorderLayout());
            getDataEAST().setSize(280);

            this.setSize("580", "330");
            final NumberFormat currency = NumberFormat.getCurrencyFormat();
            final NumberFormat number = NumberFormat.getFormat("0.00");
            final NumberCellRenderer<Grid<Ope_operacaoTGWT>> numberRenderer = new NumberCellRenderer<Grid<Ope_operacaoTGWT>>(currency);
            ColumnConfig column = null;
            column = new ColumnConfig();
            column.setId("ope_tx_descricao");
            column.setHeader("operacao");
            column.setWidth(200);
            configs.add(column);

            montarGridOperacao();

        } catch (Exception ex) {
        }

    }

    public void montarGridOperacao() throws Exception {
        EasyAccessURL eaurl = new EasyAccessURL(this);
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("op", "consultOperacoesPerfil");
        param.put("ope_operacaoT.sis_nr_id", "28");
        eaurl.accessJSonMap(Constantes.URL + PAGE, param);//"portalgwt/exemplos/gridexemplo.jsp");
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {

                if (!metodosVinc.preechido || !metodosNaoVinc.preechido) {
                    schedule(500);
                } else {
                    cpLeste.removeAll();
                    ContentPanel cpNotVinc = new ContentPanel(new FillLayout());
                    ContentPanel cpVinc = new ContentPanel(new FillLayout());
                    cpVinc.setScrollMode(Scroll.AUTOX);
                    cpNotVinc.setHeight(ope_operacaoConsultGWT.getHeight() /2);
                    //cpNotVinc.setScrollMode(Scroll.AUTOX);
                    
                    ListStore<Met_metodoTGWT> storevinc = new ListStore<Met_metodoTGWT>();
                    storevinc.add(metodosVinc.getList());
                    ListStore<Met_metodoTGWT> storenotvinc = new ListStore<Met_metodoTGWT>();
                    storenotvinc.add(metodosNaoVinc.getList());

                    cpNotVinc.setHeaderVisible(true);
                    cpNotVinc.setHeading("Nao Adicionado");
                    ColumnModel cmnotvinc = new ColumnModel(createConfig());

                    Grid<Met_metodoTGWT> grid_notvinc = new Grid<Met_metodoTGWT>(storenotvinc, cmnotvinc);
                    grid_notvinc.setLoadMask(true);

                    grid_notvinc.setBorders(true);
                    cpNotVinc.add(grid_notvinc);

                    cpVinc.setLayout(new FitLayout());

                    cpVinc.setHeading("Adicionado");
                    cpVinc.setHeaderVisible(true);

                    final ColumnModel cmvinc = new ColumnModel(createConfig());
                    Grid<Met_metodoTGWT> grid_vinc = new Grid<Met_metodoTGWT>(storevinc, cmvinc);

                    grid_vinc.setLoadMask(true);

                    grid_vinc.setBorders(true);
                    cpVinc.add(grid_vinc);

                    GridDragSource gridSourceVinc = new GridDragSource(grid_vinc);
                    GridDragSource gridSourceNotVinc = new GridDragSource(grid_notvinc);
                    GridDropTarget targetVinc = new GridDropTarget(grid_vinc) {
                        protected void onDragDrop(DNDEvent event) {

                            List<Met_metodoTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Met_metodoTGWT met_metodoTGWT : lis) {
                                    adicionarMetodo(met_metodoTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };
                    targetVinc.setAllowSelfAsSource(false);

                    GridDropTarget targetNotVinc = new GridDropTarget(grid_notvinc) {

                        protected void onDragDrop(DNDEvent event) {
                            List<Met_metodoTGWT> lis = event.getData();
                            if (!lis.isEmpty()) {
                                for (Met_metodoTGWT met_metodoTGWT : lis) {
                                    removerMetodo(met_metodoTGWT);
                                }
                            }
                            super.onDragDrop(event);
                        }
                    };

                    targetNotVinc.setAllowSelfAsSource(false);
                    ContentPanel cp = new ContentPanel(new FillLayout());
                    cp.setScrollMode(Scroll.AUTOX);
                    cp.setHeaderVisible(false);

                    cp.add(cpNotVinc);
                    cp.add(cpVinc);

                    getCpRight().add(cp);

                    layout();
                    doLayout();

                }
            }
        };
        timer.schedule(500);
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
            //Set<String> keys = jsonObject.keySet();
            //Window.alert(usuario);
            JSONArray resultado = jsonObject.get("resultado").isArray();
            ListStore<Ope_operacaoTGWT> store = new ListStore<Ope_operacaoTGWT>();
            for (int i = 1; i < resultado.size(); i++) {
                Ope_operacaoTGWT ope_operacaoTGWT1 = new Ope_operacaoTGWT();
                JSONObject registro = resultado.get(i).isObject();
                Integer ope_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("ope_nr_id").toString()));
                ope_operacaoTGWT1.setOpe_nr_id(ope_nr_id);

                Integer sis_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("sis_nr_id").toString()));
                ope_operacaoTGWT1.setSis_nr_id(sis_nr_id);

                String ope_tx_nome = EasyContainer.clearAspas(registro.get("ope_tx_nome").toString());
                ope_operacaoTGWT1.setOpe_tx_nome(ope_tx_nome);

                String ope_tx_status = EasyContainer.clearAspas(registro.get("ope_tx_status").toString());
                ope_operacaoTGWT1.setOpe_tx_status(ope_tx_status);

                String ope_tx_url = EasyContainer.clearAspas(registro.get("ope_tx_url").toString());
                ope_operacaoTGWT1.setOpe_tx_url(ope_tx_url);

                String ope_tx_descricao = EasyContainer.clearAspas(registro.get("ope_tx_descricao").toString());
                ope_operacaoTGWT1.setOpe_tx_descricao(ope_tx_descricao);

                String ope_tx_classe = EasyContainer.clearAspas(registro.get("ope_tx_classe").toString());
                ope_operacaoTGWT1.setOpe_tx_classe(ope_tx_classe);
                store.add(ope_operacaoTGWT1);
            }


            ColumnModel cm = new ColumnModel(configs);

            Grid<Ope_operacaoTGWT> grid = new Grid<Ope_operacaoTGWT>(store, cm);
            grid.setLoadMask(true);

            grid.setStyleAttribute("borderTop", "none");
            grid.setBorders(true);
            grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            grid.getSelectionModel().addListener(Events.SelectionChange, new Listener<SelectionChangedEvent>() {

                public void handleEvent(SelectionChangedEvent be) {
                    ope_operacaoTGWT = (Ope_operacaoTGWT) be.getSelection().get(0);
                    metodosVinc = new ListMetodoGWT();
                    metodosNaoVinc = new ListMetodoGWT();
                    metodosVinc.povoaMetodosVinculado(per_perfilTGWT, ope_operacaoTGWT);
                    metodosNaoVinc.povoaMetodosNaoVinculado(per_perfilTGWT, ope_operacaoTGWT);
                    getCpRight().removeAll();
                    montarTela();
                }
            });
            grid.setStripeRows(true);
            getCpMaster().add(grid);
            this.layout();
            doLayout();
        }
    }

    public List<ColumnConfig> createConfig() {
        List<ColumnConfig> configMetodos = new Vector();
        ColumnConfig column = new ColumnConfig();
        column.setId("met_tx_metodo");
        column.setHeader("descricao");
        column.setWidth(200);
        configMetodos.add(column);
        return configMetodos;

    }

    public void adicionarMetodo(Met_metodoTGWT met_metodoTGWT) {
        try {

            Resposta resposta = new Resposta();
            EasyAccessURL eaurl = new EasyAccessURL(resposta);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "adicionarOpm_met_ope_per");
            param.put("op_ope_perT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("op_ope_perT.ope_nr_id", met_metodoTGWT.getOpe_nr_id() + "");
            param.put("op_ope_perT.sis_nr_id", met_metodoTGWT.getSis_nr_id() + "");
            param.put("op_ope_perT.met_nr_id", met_metodoTGWT.getMet_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGEOPM, param);

        } catch (Exception ex) {
        }

    }

    public void removerMetodo(Met_metodoTGWT met_metodoTGWT) {
        //com.google.gwt.user.client.Window.alert("remover " + met_metodoTGWT.getMet_tx_metodo());

        try {
            Info.display("debug", "passou " + per_perfilTGWT + " - " + met_metodoTGWT);
            Resposta resposta = new Resposta();
            EasyAccessURL eaurl = new EasyAccessURL(resposta);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "removerOpm_met_ope_per");
            param.put("op_ope_perT.per_nr_id", per_perfilTGWT.getPer_nr_id() + "");
            param.put("op_ope_perT.ope_nr_id", met_metodoTGWT.getOpe_nr_id() + "");
            param.put("op_ope_perT.sis_nr_id", met_metodoTGWT.getSis_nr_id() + "");
            param.put("op_ope_perT.met_nr_id", met_metodoTGWT.getMet_nr_id() + "");
            eaurl.accessJSonMap(Constantes.URL + PAGEOPM, param);

        } catch (Exception ex) {
        }

    }

    public void load(Per_perfilTGWT per_perfilTGWT) {
        try {
            this.per_perfilTGWT = per_perfilTGWT;
            this.setHeading("Operacoes do Perfil "+per_perfilTGWT.getPer_tx_nome());
        } catch (Exception e) {
        }
    }

    /**
     * @return the per_perfilTGWT
     */
    public Per_perfilTGWT getPer_perfilTGWT() {
        return per_perfilTGWT;
    }

    /**
     * @param per_perfilTGWT the per_perfilTGWT to set
     */
    public void setPer_perfilTGWT(Per_perfilTGWT per_perfilTGWT) {
        this.per_perfilTGWT = per_perfilTGWT;
    }

    /**
     * @return the consultGWT
     */
    public Per_perfilConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Per_perfilConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    /**
     * @return the ope_operacaoTGWT
     */
    public Ope_operacaoTGWT getOpe_operacaoTGWT() {
        return ope_operacaoTGWT;
    }

    /**
     * @param ope_operacaoTGWT the ope_operacaoTGWT to set
     */
    public void setOpe_operacaoTGWT(Ope_operacaoTGWT ope_operacaoTGWT) {
        this.ope_operacaoTGWT = ope_operacaoTGWT;
    }
}

class Resposta implements IListenetResponse {

    public void read(JSONValue jsonValue) {
        Info.display(" entrou ", " entrou");
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {

            Info.display("info", EasyContainer.clearAspas(jsonObject.get("resultado").toString()));
        }

    }
}
