package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
public class Valores_calculo_fatorT{

    private int obr_nr_id;
    private int plc_nr_id;
    private int mes;
    private int ano;
    private String plc_tx_nome;
    private String plc_tx_super;
    private float valor_pago_acumulado;
    private float valor_apagar_geral;
    private float valor_comp_periodo;
    private float valor_comp_mes_anterior;
    private float valor_est_periodo;
    private float valor_est_mes_anterior;
    private float valor_prev_pms_acumulado;
    private float fator_Atual;
    private float fator_projetado;

    /**
     * @return the plc_nr_id
     */
    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    /**
     * @param plc_nr_id the plc_nr_id to set
     */
    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    /**
     * @return the valor_pago_acumulado
     */
    public float getValor_pago_acumulado() {
        return valor_pago_acumulado;
    }

    /**
     * @param valor_pago_acumulado the valor_pago_acumulado to set
     */
    public void setValor_pago_acumulado(float valor_pago_acumulado) {
        this.valor_pago_acumulado = valor_pago_acumulado;
    }

    /**
     * @return the valor_apagar_geral
     */
    public float getValor_apagar_geral() {
        return valor_apagar_geral;
    }

    /**
     * @param valor_apagar_geral the valor_apagar_geral to set
     */
    public void setValor_apagar_geral(float valor_apagar_geral) {
        this.valor_apagar_geral = valor_apagar_geral;
    }

    /**
     * @return the valor_comp_periodo
     */
    public float getValor_comp_periodo() {
        return valor_comp_periodo;
    }

    /**
     * @param valor_comp_periodo the valor_comp_periodo to set
     */
    public void setValor_comp_periodo(float valor_comp_periodo) {
        this.valor_comp_periodo = valor_comp_periodo;
    }

    /**
     * @return the valor_comp_mes_anterior
     */
    public float getValor_comp_mes_anterior() {
        return valor_comp_mes_anterior;
    }

    /**
     * @param valor_comp_mes_anterior the valor_comp_mes_anterior to set
     */
    public void setValor_comp_mes_anterior(float valor_comp_mes_anterior) {
        this.valor_comp_mes_anterior = valor_comp_mes_anterior;
    }

    /**
     * @return the valor_est_periodo
     */
    public float getValor_est_periodo() {
        return valor_est_periodo;
    }

    /**
     * @param valor_est_periodo the valor_est_periodo to set
     */
    public void setValor_est_periodo(float valor_est_periodo) {
        this.valor_est_periodo = valor_est_periodo;
    }

    /**
     * @return the valor_est_mes_anterior
     */
    public float getValor_est_mes_anterior() {
        return valor_est_mes_anterior;
    }

    /**
     * @param valor_est_mes_anterior the valor_est_mes_anterior to set
     */
    public void setValor_est_mes_anterior(float valor_est_mes_anterior) {
        this.valor_est_mes_anterior = valor_est_mes_anterior;
    }

    /**
     * @return the valor_prev_pms_acumulado
     */
    public float getValor_prev_pms_acumulado() {
        return valor_prev_pms_acumulado;
    }

    /**
     * @param valor_prev_pms_acumulado the valor_prev_pms_acumulado to set
     */
    public void setValor_prev_pms_acumulado(float valor_prev_pms_acumulado) {
        this.valor_prev_pms_acumulado = valor_prev_pms_acumulado;
    }

    /**
     * @return the fator_Atual
     */
    public float getFator_Atual() {
        return fator_Atual;
    }

    /**
     * @param fator_Atual the fator_Atual to set
     */
    public void setFator_Atual(float fator_Atual) {
        this.fator_Atual = fator_Atual;
    }

    /**
     * @return the plc_tx_nome
     */
    public String getPlc_tx_nome() {
        return plc_tx_nome;
    }

    /**
     * @param plc_tx_nome the plc_tx_nome to set
     */
    public void setPlc_tx_nome(String plc_tx_nome) {
        this.plc_tx_nome = plc_tx_nome;
    }

    /**
     * @return the fator_projetado
     */
    public float getFator_projetado() {
        return fator_projetado;
    }

    /**
     * @param fator_projetado the fator_projetado to set
     */
    public void setFator_projetado(float fator_projetado) {
        this.fator_projetado = fator_projetado;
    }

    /**
     * @return the plc_tx_super
     */
    public String getPlc_tx_super() {
        return plc_tx_super;
    }

    /**
     * @param plc_tx_super the plc_tx_super to set
     */
    public void setPlc_tx_super(String plc_tx_super) {
        this.plc_tx_super = plc_tx_super;
    }

    /**
     * @return the obr_nr_id
     */
    public int getObr_nr_id() {
        return obr_nr_id;
    }

    /**
     * @param obr_nr_id the obr_nr_id to set
     */
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    /**
     * @return the mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
   
}
