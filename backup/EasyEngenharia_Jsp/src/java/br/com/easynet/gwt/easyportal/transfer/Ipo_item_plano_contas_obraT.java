package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Ipo_item_plano_contas_obraT {

    private int ipo_nr_id;
    private float ipo_nr_quantidade;
    private float ipo_nr_vl_unitario;
    private float ipo_nr_vl_total;
    private int obr_nr_id;
    private int plco_nr_id;
    private int ipo_plc_nr_id_servico;
    private int ipo_nr_id_super;
    private int ipo_nr_nivel;
    private boolean ipo_bl_curva_abc;
    private boolean ipo_bl_cronograma;

    
    private int ipo_nr_id_nivel_1;
    private int ipo_nr_id_nivel_2;
    private int ipo_nr_id_nivel_3;
    //apenas para cronograma desembolso
    private int plc_nr_id;

    public void setIpo_nr_id(int ipo_nr_id) {
        this.ipo_nr_id = ipo_nr_id;
    }

    public int getIpo_nr_id() {
        return ipo_nr_id;
    }

    public void setIpo_nr_quantidade(float ipo_nr_quantidade) {
        this.ipo_nr_quantidade = ipo_nr_quantidade;
    }

    public float getIpo_nr_quantidade() {
        return ipo_nr_quantidade;
    }

    public void setIpo_nr_vl_unitario(float ipo_nr_vl_unitario) {
        this.ipo_nr_vl_unitario = ipo_nr_vl_unitario;
    }

    public float getIpo_nr_vl_unitario() {
        return ipo_nr_vl_unitario;
    }

    public void setIpo_nr_vl_total(float ipo_nr_vl_total) {
        this.ipo_nr_vl_total = ipo_nr_vl_total;
    }

    public float getIpo_nr_vl_total() {
        return ipo_nr_vl_total;
    }

    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    public int getObr_nr_id() {
        return obr_nr_id;
    }

    public void setPlco_nr_id(int plco_nr_id) {
        this.plco_nr_id = plco_nr_id;
    }

    public int getPlco_nr_id() {
        return plco_nr_id;
    }

    /**
     * @return the ipo_plc_nr_id_servico
     */
    public int getIpo_plc_nr_id_servico() {
        return ipo_plc_nr_id_servico;
    }

    /**
     * @param ipo_plc_nr_id_servico the ipo_plc_nr_id_servico to set
     */
    public void setIpo_plc_nr_id_servico(int ipo_plc_nr_id_servico) {
        this.ipo_plc_nr_id_servico = ipo_plc_nr_id_servico;
    }

    /**
     * @return the ipo_nr_id_nivel_1
     */
    public int getIpo_nr_id_nivel_1() {
        return ipo_nr_id_nivel_1;
    }

    /**
     * @param ipo_nr_id_nivel_1 the ipo_nr_id_nivel_1 to set
     */
    public void setIpo_nr_id_nivel_1(int ipo_nr_id_nivel_1) {
        this.ipo_nr_id_nivel_1 = ipo_nr_id_nivel_1;
    }

    /**
     * @return the ipo_nr_id_nivel_2
     */
    public int getIpo_nr_id_nivel_2() {
        return ipo_nr_id_nivel_2;
    }

    /**
     * @param ipo_nr_id_nivel_2 the ipo_nr_id_nivel_2 to set
     */
    public void setIpo_nr_id_nivel_2(int ipo_nr_id_nivel_2) {
        this.ipo_nr_id_nivel_2 = ipo_nr_id_nivel_2;
    }

    /**
     * @return the ipo_nr_id_nivel_3
     */
    public int getIpo_nr_id_nivel_3() {
        return ipo_nr_id_nivel_3;
    }

    /**
     * @param ipo_nr_id_nivel_3 the ipo_nr_id_nivel_3 to set
     */
    public void setIpo_nr_id_nivel_3(int ipo_nr_id_nivel_3) {
        this.ipo_nr_id_nivel_3 = ipo_nr_id_nivel_3;
    }

    /**
     * @return the ipo_nr_id_super
     */
    public int getIpo_nr_id_super() {
        return ipo_nr_id_super;
    }

    /**
     * @param ipo_nr_id_super the ipo_nr_id_super to set
     */
    public void setIpo_nr_id_super(int ipo_nr_id_super) {
        this.ipo_nr_id_super = ipo_nr_id_super;
    }

    /**
     * @return the ipo_nr_nivel
     */
    public int getIpo_nr_nivel() {
        return ipo_nr_nivel;
    }

    /**
     * @param ipo_nr_nivel the ipo_nr_nivel to set
     */
    public void setIpo_nr_nivel(int ipo_nr_nivel) {
        this.ipo_nr_nivel = ipo_nr_nivel;
    }

    /**
     * @return the ipo_bl_curva_abc
     */
    public boolean getIpo_bl_curva_abc() {
        return ipo_bl_curva_abc;
    }

    /**
     * @param ipo_bl_curva_abc the ipo_bl_curva_abc to set
     */
    public void setIpo_bl_curva_abc(boolean ipo_bl_curva_abc) {
        this.ipo_bl_curva_abc = ipo_bl_curva_abc;
    }

    /**
     * @return the ipo_bl_cronograma
     */
    public boolean isIpo_bl_cronograma() {
        return ipo_bl_cronograma;
    }

    /**
     * @param ipo_bl_cronograma the ipo_bl_cronograma to set
     */
    public void setIpo_bl_cronograma(boolean ipo_bl_cronograma) {
        this.ipo_bl_cronograma = ipo_bl_cronograma;
    }

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
}
