package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
 
public class Flr_fluxo_receitaT { 
	 private int flr_nr_id;
	 private int flr_nr_mes;
	 private int flr_nr_ano;
	 private int flr_nr_mes_ref;
	 private int flr_nr_ano_ref;
	 private double flr_nr_original;
	 private double flr_nr_atual;
	 private String flr_tx_key;
         private int obr_nr_id;
	 public void setFlr_nr_id(int flr_nr_id) {
		 this.flr_nr_id=flr_nr_id;
	}
 
	 public int getFlr_nr_id() {
		 return flr_nr_id;
 	} 
 	 public void setFlr_nr_mes(int flr_nr_mes) {
		 this.flr_nr_mes=flr_nr_mes;
	}
 
	 public int getFlr_nr_mes() {
		 return flr_nr_mes;
 	} 
 	 public void setFlr_nr_ano(int flr_nr_ano) {
		 this.flr_nr_ano=flr_nr_ano;
	}
 
	 public int getFlr_nr_ano() {
		 return flr_nr_ano;
 	} 
 	 public void setFlr_nr_original(double flr_nr_original) {
		 this.flr_nr_original=flr_nr_original;
	}
 
	 public double getFlr_nr_original() {
		 return flr_nr_original;
 	} 
 	 public void setFlr_nr_atual(double flr_nr_atual) {
		 this.flr_nr_atual=flr_nr_atual;
	}
 
	 public double getFlr_nr_atual() {
		 return flr_nr_atual;
 	} 
 	 public void setFlr_tx_key(String flr_tx_key) {
		 this.flr_tx_key=flr_tx_key;
	}
 
	 public String getFlr_tx_key() {
		 return flr_tx_key;
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
     * @return the flr_nr_mes_ref
     */
    public int getFlr_nr_mes_ref() {
        return flr_nr_mes_ref;
    }

    /**
     * @param flr_nr_mes_ref the flr_nr_mes_ref to set
     */
    public void setFlr_nr_mes_ref(int flr_nr_mes_ref) {
        this.flr_nr_mes_ref = flr_nr_mes_ref;
    }

    /**
     * @return the flr_nr_ano_ref
     */
    public int getFlr_nr_ano_ref() {
        return flr_nr_ano_ref;
    }

    /**
     * @param flr_nr_ano_ref the flr_nr_ano_ref to set
     */
    public void setFlr_nr_ano_ref(int flr_nr_ano_ref) {
        this.flr_nr_ano_ref = flr_nr_ano_ref;
    }
 }