package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;

public class Com_comprometimentoT {

    private int com_nr_id;
    private int plc_nr_id;
    private double com_nr_valor;
    private int obr_nr_id;
    private int com_nr_mes;
    private int com_nr_ano;
    private boolean previsto;
    @Conversion(classe = "br.com.easynet.convesion.ConvertDate", format = "dd/MM/yyyy")
    private Date com_dt_base;

    public void setCom_nr_id(int com_nr_id) {
        this.com_nr_id = com_nr_id;
    }

    public int getCom_nr_id() {
        return com_nr_id;
    }

    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    public void setCom_nr_valor(double com_nr_valor) {
        this.com_nr_valor = com_nr_valor;
    }

    public double getCom_nr_valor() {
        return com_nr_valor;
    }

    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    public int getObr_nr_id() {
        return obr_nr_id;
    }

    public void setCom_nr_mes(int com_nr_mes) {
        this.com_nr_mes = com_nr_mes;
    }

    public int getCom_nr_mes() {
        return com_nr_mes;
    }

    public void setCom_nr_ano(int com_nr_ano) {
        this.com_nr_ano = com_nr_ano;
    }

    public int getCom_nr_ano() {
        return com_nr_ano;
    }

    /**
     * @return the com_dt_base
     */
    public Date getCom_dt_base() {
        return com_dt_base;
    }

    /**
     * @param com_dt_base the com_dt_base to set
     */
    public void setCom_dt_base(Date com_dt_base) {
        this.com_dt_base = com_dt_base;
    }

    /**
     * @return the previsto
     */
    public boolean isPrevisto() {
        return previsto;
    }

    /**
     * @param previsto the previsto to set
     */
    public void setPrevisto(boolean previsto) {
        this.previsto = previsto;
    }
}
