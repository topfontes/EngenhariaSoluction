package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Obr_obrasT {

    private int obr_nr_id;
    private String obr_tx_nome;
    private String obr_tx_endereco;
    private String obr_tx_bairro;
    private String obr_tx_cidade;
    private String obr_tx_uf;
    private int emp_nr_id; 
    private float obr_nr_area_construida_total;
    private float obr_nr_area_privativa_total;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_inicio;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_fim;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_inicio_controle;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_termino_controle;

    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_inicio_real;

    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private java.util.Date obr_dt_final_real;
    //obr_dt_inicio_real,obr_dt_final_real
    private int obr_nr_id_plc_mdo_direta;
    private int obr_nr_id_plc_mdo_indireta;
    private float obr_nr_percent_mdo_direta;
    private float obr_nr_percent_mdo_indireta;
    private float obr_nr_valor_permutado;
    private float obr_nr_valor_vgv;
    private float obr_nr_encarcos_juros_aplicacao;
    
//obr_nr_id_plc_mdo_direta,obr_nr_id_plc_mdo_indireta,obr_nr_percent_mdo_direta,obr_nr_percent_mdo_indireta
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    public int getObr_nr_id() {
        return obr_nr_id;
    }

    public void setObr_tx_nome(String obr_tx_nome) {
        this.obr_tx_nome = obr_tx_nome;
    }

    public String getObr_tx_nome() {
        return obr_tx_nome;
    }

    public void setObr_tx_endereco(String obr_tx_endereco) {
        this.obr_tx_endereco = obr_tx_endereco;
    }

    public String getObr_tx_endereco() {
        return obr_tx_endereco;
    }

    public void setObr_tx_bairro(String obr_tx_bairro) {
        this.obr_tx_bairro = obr_tx_bairro;
    }

    public String getObr_tx_bairro() {
        return obr_tx_bairro;
    }

    public void setObr_tx_cidade(String obr_tx_cidade) {
        this.obr_tx_cidade = obr_tx_cidade;
    }

    public String getObr_tx_cidade() {
        return obr_tx_cidade;
    }

    public void setObr_tx_uf(String obr_tx_uf) {
        this.obr_tx_uf = obr_tx_uf;
    }

    public String getObr_tx_uf() {
        return obr_tx_uf;
    }

    public void setEmp_nr_id(int emp_nr_id) {
        this.emp_nr_id = emp_nr_id;
    }

    public int getEmp_nr_id() {
        return emp_nr_id;
    }

    public void setObr_nr_area_construida_total(float obr_nr_area_construida_total) {
        this.obr_nr_area_construida_total = obr_nr_area_construida_total;
    }

    public float getObr_nr_area_construida_total() {
        return obr_nr_area_construida_total;
    }

    public void setObr_dt_inicio(java.util.Date obr_dt_inicio) {
        this.obr_dt_inicio = obr_dt_inicio;
    }

    public java.util.Date getObr_dt_inicio() {
        return obr_dt_inicio;
    }

    public void setObr_dt_fim(java.util.Date obr_dt_fim) {
        this.obr_dt_fim = obr_dt_fim;
    }

    public java.util.Date getObr_dt_fim() {
        return obr_dt_fim;
    }

    public void setObr_dt_inicio_controle(java.util.Date obr_dt_inicio_controle) {
        this.obr_dt_inicio_controle = obr_dt_inicio_controle;
    }

    public java.util.Date getObr_dt_inicio_controle() {
        return obr_dt_inicio_controle;
    }

    public void setObr_dt_termino_controle(java.util.Date obr_dt_termino_controle) {
        this.obr_dt_termino_controle = obr_dt_termino_controle;
    }

    public java.util.Date getObr_dt_termino_controle() {
        return obr_dt_termino_controle;
    }

    /**
     * @return the obr_nr_area_privativa_total
     */
    public float getObr_nr_area_privativa_total() {
        return obr_nr_area_privativa_total;
    }

    /**
     * @param obr_nr_area_privativa_total the obr_nr_area_privativa_total to set
     */
    public void setObr_nr_area_privativa_total(float obr_nr_area_privativa_total) {
        this.obr_nr_area_privativa_total = obr_nr_area_privativa_total;
    }

    /**
     * @return the obr_nr_id_plc_mdo_direta
     */
    public int getObr_nr_id_plc_mdo_direta() {
        return obr_nr_id_plc_mdo_direta;
    }

    /**
     * @param obr_nr_id_plc_mdo_direta the obr_nr_id_plc_mdo_direta to set
     */
    public void setObr_nr_id_plc_mdo_direta(int obr_nr_id_plc_mdo_direta) {
        this.obr_nr_id_plc_mdo_direta = obr_nr_id_plc_mdo_direta;
    }

    /**
     * @return the obr_nr_id_plc_mdo_indireta
     */
    public int getObr_nr_id_plc_mdo_indireta() {
        return obr_nr_id_plc_mdo_indireta;
    }

    /**
     * @param obr_nr_id_plc_mdo_indireta the obr_nr_id_plc_mdo_indireta to set
     */
    public void setObr_nr_id_plc_mdo_indireta(int obr_nr_id_plc_mdo_indireta) {
        this.obr_nr_id_plc_mdo_indireta = obr_nr_id_plc_mdo_indireta;
    }

    /**
     * @return the obr_nr_percent_mdo_direta
     */
    public float getObr_nr_percent_mdo_direta() {
        return obr_nr_percent_mdo_direta;
    }

    /**
     * @param obr_nr_percent_mdo_direta the obr_nr_percent_mdo_direta to set
     */
    public void setObr_nr_percent_mdo_direta(float obr_nr_percent_mdo_direta) {
        this.obr_nr_percent_mdo_direta = obr_nr_percent_mdo_direta;
    }

    /**
     * @return the obr_nr_percent_mdo_indireta
     */
    public float getObr_nr_percent_mdo_indireta() {
        return obr_nr_percent_mdo_indireta;
    }

    /**
     * @param obr_nr_percent_mdo_indireta the obr_nr_percent_mdo_indireta to set
     */
    public void setObr_nr_percent_mdo_indireta(float obr_nr_percent_mdo_indireta) {
        this.obr_nr_percent_mdo_indireta = obr_nr_percent_mdo_indireta;
    }

    /**
     * @return the obr_nr_valor_permutado
     */
    public float getObr_nr_valor_permutado() {
        return obr_nr_valor_permutado;
    }

    /**
     * @param obr_nr_valor_permutado the obr_nr_valor_permutado to set
     */
    public void setObr_nr_valor_permutado(float obr_nr_valor_permutado) {
        this.obr_nr_valor_permutado = obr_nr_valor_permutado;
    }

    /**
     * @return the obr_nr_valor_vgv
     */
    public float getObr_nr_valor_vgv() {
        return obr_nr_valor_vgv;
    }

    /**
     * @param obr_nr_valor_vgv the obr_nr_valor_vgv to set
     */
    public void setObr_nr_valor_vgv(float obr_nr_valor_vgv) {
        this.obr_nr_valor_vgv = obr_nr_valor_vgv;
    }

    /**
     * @return the obr_nr_encarcos_juros_aplicacao
     */
    public float getObr_nr_encarcos_juros_aplicacao() {
        return obr_nr_encarcos_juros_aplicacao;
    }

    /**
     * @param obr_nr_encarcos_juros_aplicacao the obr_nr_encarcos_juros_aplicacao to set
     */
    public void setObr_nr_encarcos_juros_aplicacao(float obr_nr_encarcos_juros_aplicacao) {
        this.obr_nr_encarcos_juros_aplicacao = obr_nr_encarcos_juros_aplicacao;
    }

    /**
     * @return the obr_dt_inicio_real
     */
    public java.util.Date getObr_dt_inicio_real() {
        return obr_dt_inicio_real;
    }

    /**
     * @param obr_dt_inicio_real the obr_dt_inicio_real to set
     */
    public void setObr_dt_inicio_real(java.util.Date obr_dt_inicio_real) {
        this.obr_dt_inicio_real = obr_dt_inicio_real;
    }

    /**
     * @return the obr_dt_final_real
     */
    public java.util.Date getObr_dt_final_real() {
        return obr_dt_final_real;
    }

    /**
     * @param obr_dt_final_real the obr_dt_final_real to set
     */
    public void setObr_dt_final_real(java.util.Date obr_dt_final_real) {
        this.obr_dt_final_real = obr_dt_final_real;
    }
}
