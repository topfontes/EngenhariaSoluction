/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.fol_folha_pagamento;

import br.com.easynet.gwt.easyportal.client.Constantes;
import br.com.easynet.gwt.easyportal.client.EasyAccessURL;
import br.com.easynet.gwt.easyportal.client.EasyContainer;
import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Fol_folha_pagamentoTGWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Fol_Folha_pagamentoDAO implements IListenetResponse {

    private List<Fol_folha_pagamentoTGWT> list;
    private boolean povoado;
    private float qtdHoras;

    public void getAll(int obr_nr_id, int mes, int ano) {
        try {
            povoado = false;
            EasyAccessURL eaurl = new EasyAccessURL(this);
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("op", "consult");
            param.put("fol_folha_pagamentoT.obr_nr_id", obr_nr_id + "");
            param.put("fol_folha_pagamentoT.fol_nr_mes", mes + "");
            param.put("fol_folha_pagamentoT.fol_nr_ano", ano + "");
            eaurl.accessJSonMap(Constantes.URL + Fol_folha_pagamentoConsultGWT.PAGE, param);
        } catch (Exception e) {
        }

    }

    public void read(JSONValue jsonValue) {
        try {
            JSONObject jsonObject;
            if (jsonValue != null && (jsonObject = jsonValue.isObject()) != null) {
                //Window.alert("chegou");
                JSONArray resultado = jsonObject.get("resultado").isArray();

                list = new Vector();
                for (int i = 1; i < resultado.size()-1; i++) {
                    Fol_folha_pagamentoTGWT fol_folha_pagamentoTGWT = new Fol_folha_pagamentoTGWT();
                    JSONObject registro = resultado.get(i).isObject();
                    Integer fol_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_id").toString()));
                    fol_folha_pagamentoTGWT.setFol_nr_id(fol_nr_id);

                    Integer obr_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("obr_nr_id").toString()));
                    fol_folha_pagamentoTGWT.setObr_nr_id(obr_nr_id);

                    Integer plc_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plc_nr_id").toString()));
                    fol_folha_pagamentoTGWT.setPlc_nr_id(plc_nr_id);

                    Integer plco_nr_id = Integer.parseInt(EasyContainer.clearAspas(registro.get("plco_nr_id").toString()));
                    fol_folha_pagamentoTGWT.setPlco_nr_id(plco_nr_id);

                    Integer fol_nr_mes = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_mes").toString()));
                    fol_folha_pagamentoTGWT.setFol_nr_mes(fol_nr_mes);

                    Integer fol_nr_ano = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_ano").toString()));
                    fol_folha_pagamentoTGWT.setFol_nr_ano(fol_nr_ano);

                    String fol_tx_funcao = EasyContainer.clearAspas(registro.get("fol_tx_funcao").toString());
                    fol_folha_pagamentoTGWT.setFol_tx_funcao(fol_tx_funcao);

                    String classe = EasyContainer.clearAspas(registro.get("classe").toString());
                    fol_folha_pagamentoTGWT.setClasse(classe);

                    String subClasse = EasyContainer.clearAspas(registro.get("subClasse").toString());
                    fol_folha_pagamentoTGWT.setSubClasse(subClasse);

                    float fol_nr_salario_bruto_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_oficial").toString()));
                    if (fol_nr_salario_bruto_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_oficial(fol_nr_salario_bruto_oficial);
                    }

                    float fol_nr_adiantamento_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_oficial").toString()));
                    if (fol_nr_adiantamento_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_adiantamento_oficial(fol_nr_adiantamento_oficial);
                    }

                    float fol_nr_horas_extra_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_oficial").toString()));

                    if (fol_nr_horas_extra_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_horas_extra_oficial(fol_nr_horas_extra_oficial);
                    }

                    float fol_nr_salario_bruto_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_salario_bruto_nao_oficial").toString()));
                    if (fol_nr_salario_bruto_nao_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_salario_bruto_nao_oficial(fol_nr_salario_bruto_nao_oficial);
                    }

                    float fol_nr_adiantamento_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_adiantamento_nao_oficial").toString()));
                    if (fol_nr_adiantamento_nao_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_adiantamento_nao_oficial(fol_nr_adiantamento_nao_oficial);
                    }

                    float fol_nr_horas_extra_nao_oficial = Float.parseFloat(EasyContainer.clearAspas(registro.get("fol_nr_horas_extra_nao_oficial").toString()));
                    if (fol_nr_horas_extra_nao_oficial > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_horas_extra_nao_oficial(fol_nr_horas_extra_nao_oficial);
                    }
                    Integer fol_nr_numero_funcionario = Integer.parseInt(EasyContainer.clearAspas(registro.get("fol_nr_numero_funcionario").toString()));
                    if (fol_nr_numero_funcionario > 0) {
                        fol_folha_pagamentoTGWT.setFol_nr_numero_funcionario(fol_nr_numero_funcionario);
                    }
                    list.add(fol_folha_pagamentoTGWT);
                }
                JSONObject registro = resultado.get(resultado.size()-1).isObject();
                qtdHoras = Float.parseFloat(EasyContainer.clearAspas(registro.get("horas").toString()));

            }

        } catch (Exception e) {
        } finally {
            povoado = true;
        }
    }

    /**
     * @return the list
     */
    public List<Fol_folha_pagamentoTGWT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Fol_folha_pagamentoTGWT> list) {
        this.list = list;
    }

    /**
     * @return the povoado
     */
    public boolean isPovoado() {
        return povoado;
    }

    /**
     * @param povoado the povoado to set
     */
    public void setPovoado(boolean povoado) {
        this.povoado = povoado;
    }

    /**
     * @return the qtdHoras
     */
    public float getQtdHoras() {
        return qtdHoras;
    }

    /**
     * @param qtdHoras the qtdHoras to set
     */
    public void setQtdHoras(float qtdHoras) {
        this.qtdHoras = qtdHoras;
    }
}
