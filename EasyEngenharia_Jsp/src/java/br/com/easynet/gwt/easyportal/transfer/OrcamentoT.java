/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.transfer;

/**
 *
 * @author marcos
 */
public class OrcamentoT {//implements Comparable<OrcamentoT>{
    private int codigo_super;
    private int cod_conta;
    private int codigo;
    private String cod_externo;
    private String plco_nome;
    private int nivel;
    private String unidade;
    private String tipo;
    private float qtde;
    private float vl_unit;

    /**
     * @return the codigo_super
     */
    public int getCodigo_super() {
        return codigo_super;
    }

    /**
     * @param codigo_super the codigo_super to set
     */
    public void setCodigo_super(int codigo_super) {
        this.codigo_super = codigo_super;
    }

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
     * @return the cod_externo
     */
    public String getCod_externo() {
        return cod_externo;
    }

    /**
     * @param cod_externo the cod_externo to set
     */
    public void setCod_externo(String cod_externo) {
        this.cod_externo = cod_externo;
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
     * @return the qtde
     */
    public float getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(float qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the cod_conta
     */
    public int getCod_conta() {
        return cod_conta;
    }

    /**
     * @param cod_conta the cod_conta to set
     */
    public void setCod_conta(int cod_conta) {
        this.cod_conta = cod_conta;
    }

//    public int compareTo(OrcamentoT o) {
//        return cod_externo.compareTo(o.getCod_externo());
//    }

    /**
     * @return the vl_unit
     */
    public float getVl_unit() {
        return vl_unit;
    }

    /**
     * @param vl_unit the vl_unit to set
     */
    public void setVl_unit(float vl_unit) {
        this.vl_unit = vl_unit;
    }
}
