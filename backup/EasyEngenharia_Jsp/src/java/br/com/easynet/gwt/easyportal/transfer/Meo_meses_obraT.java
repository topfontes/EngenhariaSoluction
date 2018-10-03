/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.transfer;

/**
 *br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT
 * @author marcos
 */

public class Meo_meses_obraT {
    private int mes;
    private int ano;
    private String mes_ano;
    private double quantidade;
    //atributos apenas para relatorio

    private double calc_quantidade_original;
    private double calc_valor_original;
    private double calc_quantidade_copia;
    private double calc_valor_copia;
    private double dif_origenal_copia;
    private double totalMes;

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

    /**
     * @return the mes_ano
     */
    public String getMes_ano() {
        return mes_ano;
    }

    /**
     * @param mes_ano the mes_ano to set
     */
    public void setMes_ano(String mes_ano) {
        this.mes_ano = mes_ano;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the calc_quantidade_original
     */
    public double getCalc_quantidade_original() {
        return calc_quantidade_original;
    }

    /**
     * @param calc_quantidade_original the calc_quantidade_original to set
     */
    public void setCalc_quantidade_original(double calc_quantidade_original) {
        this.calc_quantidade_original = calc_quantidade_original;
    }

    /**
     * @return the calc_valor_original
     */
    public double getCalc_valor_original() {
        return calc_valor_original;
    }

    /**
     * @param calc_valor_original the calc_valor_original to set
     */
    public void setCalc_valor_original(double calc_valor_original) {
        this.calc_valor_original = calc_valor_original;
    }

    /**
     * @return the calc_quantidade_copia
     */
    public double getCalc_quantidade_copia() {
        return calc_quantidade_copia;
    }

    /**
     * @param calc_quantidade_copia the calc_quantidade_copia to set
     */
    public void setCalc_quantidade_copia(double calc_quantidade_copia) {
        this.calc_quantidade_copia = calc_quantidade_copia;
    }

    /**
     * @return the calc_valor_copia
     */
    public double getCalc_valor_copia() {
        return calc_valor_copia;
    }

    /**
     * @param calc_valor_copia the calc_valor_copia to set
     */
    public void setCalc_valor_copia(double calc_valor_copia) {
        this.calc_valor_copia = calc_valor_copia;
    }

    /**
     * @return the dif_origenal_copia
     */
    public double getDif_origenal_copia() {
        return dif_origenal_copia;
    }

    /**
     * @param dif_origenal_copia the dif_origenal_copia to set
     */
    public void setDif_origenal_copia(float dif_origenal_copia) {
        this.dif_origenal_copia = dif_origenal_copia;
    }

    /**
     * @return the totalMes
     */
    public double getTotalMes() {
        return totalMes;
    }

    /**
     * @param totalMes the totalMes to set
     */
    public void setTotalMes(double totalMes) {
        this.totalMes = totalMes;
    }

}
