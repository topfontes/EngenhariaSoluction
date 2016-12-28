package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Plc_plano_contasT { 
	 private int plc_nr_id;
	 private String plc_tx_nome;
	 private int plc_nr_id_super;
	 private String plc_tx_caixa_banco;
         private int cen_nr_id;
         private int par_nr_id;
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
 	 public void setPlc_nr_id_super(int plc_nr_id_super) {
		 this.plc_nr_id_super=plc_nr_id_super;
	}
 
	 public int getPlc_nr_id_super() {
		 return plc_nr_id_super;
 	} 
 	 public void setPlc_tx_caixa_banco(String plc_tx_caixa_banco) {
		 this.plc_tx_caixa_banco=plc_tx_caixa_banco;
	}
 
	 public String getPlc_tx_caixa_banco() {
		 return plc_tx_caixa_banco;
 	}

    /**
     * @return the cen_nr_id
     */
    public int getCen_nr_id() {
        return cen_nr_id;
    }

    /**
     * @param cen_nr_id the cen_nr_id to set
     */
    public void setCen_nr_id(int cen_nr_id) {
        this.cen_nr_id = cen_nr_id;
    }

    /**
     * @return the par_nr_id
     */
    public int getPar_nr_id() {
        return par_nr_id;
    }

    /**
     * @param par_nr_id the par_nr_id to set
     */
    public void setPar_nr_id(int par_nr_id) {
        this.par_nr_id = par_nr_id;
    }
 }