/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.frd_faturamento_rec_devolucao;

import br.com.easynet.gwt.easyportal.client.Ano;
import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.ListMes_AnoGWT;
import br.com.easynet.gwt.easyportal.client.Meses;
import br.com.easynet.gwt.easyportal.client.Portal2GWT;

import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.*;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.Listener;


import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.HashMap;
import br.com.easynet.gwt.easyportal.client.UpdateDeleteGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.obr_obras.ListObraGWT;
import com.extjs.gxt.ui.client.event.ToolBarEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;

/**
 *
 * @author geoleite
 */
public class Frd_faturamento_rec_devolucaoUpdateDeleteGWT extends UpdateDeleteGWT implements IListenetResponse {

    public static final String PAGE = "easyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoUpdateDeleteGWT.jsp";
    private TextBox frd_nr_id = new TextBox();
    private NumberField frd_nr_valor_permutado = new NumberField();
    private NumberField frd_nr_vgv = new NumberField();
    private NumberField frd_nr_valor_devolucao = new NumberField();
    private NumberField frd_nr_valor_faturamento = new NumberField();
    private NumberField frd_nr_valor_recebimento = new NumberField();
    private NumberField frd_nr_valor_permutas = new NumberField();
    private Frd_faturamento_rec_devolucaoTGWT frd_faturamento_rec_devolucaoTGWT = new Frd_faturamento_rec_devolucaoTGWT();
    private Frd_faturamento_rec_devolucaoConsultGWT consultGWT = new Frd_faturamento_rec_devolucaoConsultGWT();
    private ListObraGWT listObraGWT = new ListObraGWT();
    private ListMes_AnoGWT listMes_AnoGWT = new ListMes_AnoGWT();
    private ComboBox<Obr_obrasTGWT> comboObra = new ComboBox<Obr_obrasTGWT>();
    private ComboBox<Plc_plano_contasTGWT> comboPlc = new ComboBox<Plc_plano_contasTGWT>();
    private ComboBox<Meses> comboMes = new ComboBox<Meses>();
    private ComboBox<Ano> comboAno = new ComboBox<Ano>();
    ToolBar bar = new ToolBar();

    public Frd_faturamento_rec_devolucaoConsultGWT getConsultGWT() {
        return consultGWT;
    }

    /**
     * @param consultGWT the consultGWT to set
     */
    public void setConsultGWT(Frd_faturamento_rec_devolucaoConsultGWT consultGWT) {
        this.consultGWT = consultGWT;
    }

    public Frd_faturamento_rec_devolucaoUpdateDeleteGWT() {
        listObraGWT.povoar();
         this.setSize(530, 330);
        this.setHeading("Alterar Faturamento/Recebimentos/Devoluções");
        TableLayout layout = new TableLayout(2);
        layout.setCellPadding(3);
        getCpMaster().setLayout(layout);
        getCpMaster().setTopComponent(bar);
        frd_nr_valor_permutado.setFormat(NumberFormat.getFormat("#,##0.00"));
        frd_nr_vgv.setFormat(NumberFormat.getFormat("#,##0.00"));
        frd_nr_valor_devolucao.setFormat(NumberFormat.getFormat("#,##0.00"));
        frd_nr_valor_faturamento.setFormat(NumberFormat.getFormat("#,##0.00"));
        frd_nr_valor_recebimento.setFormat(NumberFormat.getFormat("#,##0.00"));
        frd_nr_valor_permutas.setFormat(NumberFormat.getFormat("#,##0.00"));

        montarTela();
        layout();
    }

    public void montarTela() {
        Timer timer = new Timer() {

            @Override
            public void run() {
                if (!listObraGWT.isMostrar()) {
                    schedule(300);
                } else {
                    addCompToolBar();

                    getCpMaster().add(new LabelField("Valor Permutado Acum.:"));
                    getCpMaster().add(frd_nr_valor_permutado);

//                    getCpMaster().add(new LabelField("valor VGV:"));
//                    getCpMaster().add(frd_nr_vgv);

                    getCpMaster().add(new LabelField("Valor Devoolução Acum.:"));
                    getCpMaster().add(frd_nr_valor_devolucao);

                    getCpMaster().add(new LabelField("Valor Faturamento Acum.:"));
                    getCpMaster().add(frd_nr_valor_faturamento);

//                    getCpMaster().add(new LabelField("Valor Recebimento:"));
//                    getCpMaster().add(frd_nr_valor_recebimento);

                    getCpMaster().add(new LabelField("Valor Permutas Acum.:"));
                    getCpMaster().add(frd_nr_valor_permutas);
                    getCpMaster().layout();
                    layout();
                }
            }
        };
        timer.schedule(300);
        layout();
    }

    public void addCompToolBar() {

        bar.add(new LabelToolItem("Obra:"));
        comboObra.setStore(listObraGWT.getStore());
        comboObra.setValueField("obr_nr_id");
        comboObra.setDisplayField("obr_tx_nome");
        comboObra.setEmptyText("Selecione a obra");
        bar.add(comboObra);
        comboObra.setValue(listObraGWT.getTreeObra().get(frd_faturamento_rec_devolucaoTGWT.getObr_nr_id()));
        bar.add(new SeparatorToolItem());

        bar.add(new LabelToolItem("Mês:"));
        ListStore<Meses> storemeses = new ListStore<Meses>();
        storemeses.add(listMes_AnoGWT.getMeses());
        comboMes.setStore(storemeses);
        comboMes.setDisplayField("display");
        comboMes.setEmptyText("Selecione o Mês");
        comboMes.setWidth(110);
        comboMes.setValue(listMes_AnoGWT.getTreeMeses().get(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_mes()));
        bar.add(comboMes);
        bar.add(new SeparatorToolItem());

        bar.add(new LabelToolItem("Ano:"));
        ListStore<Ano> storeAno = new ListStore<Ano>();
        storeAno.add(listMes_AnoGWT.getListAno());
        comboAno.setStore(storeAno);
        comboAno.setDisplayField("display");
        comboAno.setEmptyText("Selecione o Ano");
        comboAno.setWidth(80);
        comboAno.setValue(listMes_AnoGWT.getTreeAno().get(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_ano()));
        bar.add(comboAno);
        getCpMaster().layout();
        layout();
    }

    public void load(Frd_faturamento_rec_devolucaoTGWT frd_faturamento_rec_devolucaoTGWT) {
        try {
            this.frd_faturamento_rec_devolucaoTGWT = frd_faturamento_rec_devolucaoTGWT;
            frd_nr_valor_permutado.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_valor_permutado());
//            frd_nr_vgv.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_vgv());
            frd_nr_valor_devolucao.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_valor_devolucao());
            frd_nr_valor_faturamento.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_valor_faturamento());
            //frd_nr_valor_recebimento.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_valor_recebimento());
            frd_nr_valor_permutas.setValue(frd_faturamento_rec_devolucaoTGWT.getFrd_nr_valor_permutas());

        } catch (Exception ex) {
        }
    }

//    @Override
    public void btnUpdateAction(ButtonEvent ce) {
        btnAltAction(ce);
    }

//    @Override
    public void btnDeltAction(ButtonEvent ce) {
        btnDeltAction(ce);
    }

    private void btnAltAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "update");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_id", frd_faturamento_rec_devolucaoTGWT.getFrd_nr_id()+"");
            
            param.put("frd_faturamento_rec_devolucaoT.frd_nr_valor_permutado", frd_nr_valor_permutado.getValue() + "");

//            param.put("frd_faturamento_rec_devolucaoT.frd_nr_vgv", frd_nr_vgv.getValue() + "");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_valor_devolucao", frd_nr_valor_devolucao.getValue() + "");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_valor_faturamento", frd_nr_valor_faturamento.getValue() + "");

//            param.put("frd_faturamento_rec_devolucaoT.frd_nr_valor_recebimento", frd_nr_valor_recebimento.getValue() + "");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_valor_permutas", frd_nr_valor_permutas.getValue() + "");

            param.put("frd_faturamento_rec_devolucaoT.obr_nr_id", comboObra.getValue().getObr_nr_id() + "");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_mes", comboMes.getValue().getValue() + "");

            param.put("frd_faturamento_rec_devolucaoT.frd_nr_ano", comboAno.getValue().getValue() + "");


            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
            consultGWT.load();
        } catch (Exception ex) {
        }
    }

    private void btnDelAction(ButtonEvent sender) {
        try {
            String url = Constantes.URL + PAGE;//"portalgwt/exemplos/cadastro.jsp";
//            url = "http://localhost:8084/easyportalgwt/agenda/agenda/usu_usuario/usu_usuarioUpdateDeleteGWT.jsp";
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "delete");
            param.put("frd_faturamento_rec_devolucaoT.frd_nr_id", frd_nr_id.getText());
            EasyAccessURL eaurl = new EasyAccessURL(this);
            eaurl.accessJSonMap(url, param);
        } catch (Exception ex) {
        }
    }

    public void read(JSONValue jsonValue) {
        JSONObject jsonObject;
        if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                if (jsonValue.toString().indexOf("sucesso") > -1) {
                    getShowMsgAlteracao();
                    consultGWT.load();
                    this.close();
                }else{
                    getShowMsgErro("Erro ao tentar executar a operação");
                }

        }

    }
}
