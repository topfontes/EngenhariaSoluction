/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.transfer;

/**
 *
 * @author marcos
 */
public class ContaOrcamentoT {
    private int codigo;
    private String codigo_externo;
    private String plco_nome;
    private String tipo;
    private String unidade;
    private int nivel;
    private float valor_unit;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigo_esterno
     */
    public String getCodigo_externo() {
        return codigo_externo;
    }

    /**
     * @param codigo_esterno the codigo_esterno to set
     */
    public void setCodigo_externo(String codigo_externo) {
        this.codigo_externo = codigo_externo;
    }

    /**
     * @return the plco_nome
     */
    public String getPlco_nome() {
        return plco_nome;
    }

    /**
     * @param plco_nome the plco_nome to set
     */
    public void setPlco_nome(String plco_nome) {
        this.plco_nome = plco_nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the valor_unit
     */
    public float getValor_unit() {
        return valor_unit;
    }

    /**
     * @param valor_unit the valor_unit to set
     */
    public void setValor_unit(float valor_unit) {
        this.valor_unit = valor_unit;
    }

}
