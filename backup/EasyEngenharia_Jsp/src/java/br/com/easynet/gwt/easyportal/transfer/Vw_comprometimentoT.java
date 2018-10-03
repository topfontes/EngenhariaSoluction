package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

//br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT
public class Vw_comprometimentoT { 
	 private int obr_nr_id;
	 private int com_nr_mes;
	 private int com_nr_ano;
	 private int plc_nr_id;
	 private String plc_tx_nome;
	 private double com_nr_valor;
         private int com_nr_id;
         private String plc_tx_nome_super;

	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setCom_nr_mes(int com_nr_mes) {
		 this.com_nr_mes=com_nr_mes;
	}
 
	 public int getCom_nr_mes() {
		 return com_nr_mes;
 	} 
 	 public void setCom_nr_ano(int com_nr_ano) {
		 this.com_nr_ano=com_nr_ano;
	}
 
	 public int getCom_nr_ano() {
		 return com_nr_ano;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
 
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	} 
 	 public void setPlc_tx_nome(String plc_tx_nome) {
		 this.plc_tx_nome=plc_tx_nome;
	}
 
	 public String getPlc_tx_nome() {
		 return plc_tx_nome;
 	}

 	 public void setCom_nr_valor(double com_nr_valor) {
		 this.com_nr_valor=com_nr_valor;
	}
 
	 public double getCom_nr_valor() {
		 return com_nr_valor;
 	}

    /**
     * @return the com_nr_id
     */
    public int getCom_nr_id() {
        return com_nr_id;
    }

    /**
     * @param com_nr_id the com_nr_id to set
     */
    public void setCom_nr_id(int com_nr_id) {
        this.com_nr_id = com_nr_id;
    }

    /**
     * @return the plc_tx_nome_super
     */
    public String getPlc_tx_nome_super() {
        return plc_tx_nome_super;
    }

    /**
     * @param plc_tx_nome_super the plc_tx_nome_super to set
     */
    public void setPlc_tx_nome_super(String plc_tx_nome_super) {
        this.plc_tx_nome_super = plc_tx_nome_super;
    }
 }