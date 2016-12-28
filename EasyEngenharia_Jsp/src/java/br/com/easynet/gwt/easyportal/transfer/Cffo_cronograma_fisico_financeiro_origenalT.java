package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Cffo_cronograma_fisico_financeiro_origenalT { 
	 private int cffo_nr_id;
	 private int plco_nr_id;
	 private int obr_nr_id;
	 private double cffo_nr_peso;
	 private int cffo_nr_mes;
	 private int cffo_nr_ano;
         private int ipo_nr_id_super;
         private int ipo_nr_id;
	 public void setCffo_nr_id(int cffo_nr_id) {
		 this.cffo_nr_id=cffo_nr_id;
	}
 
	 public int getCffo_nr_id() {
		 return cffo_nr_id;
 	} 
 	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}
 
	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	}
         
 	 public void setCffo_nr_peso(double cffo_nr_peso) {
		 this.cffo_nr_peso=cffo_nr_peso;
	}
 
	 public double getCffo_nr_peso() {
		 return cffo_nr_peso;
 	} 
 	 public void setCffo_nr_mes(int cffo_nr_mes) {
		 this.cffo_nr_mes=cffo_nr_mes;
	}
 
	 public int getCffo_nr_mes() {
		 return cffo_nr_mes;
 	} 
 	 public void setCffo_nr_ano(int cffo_nr_ano) {
		 this.cffo_nr_ano=cffo_nr_ano;
	}
 
	 public int getCffo_nr_ano() {
		 return cffo_nr_ano;
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
     * @return the ipo_nr_id
     */
    public int getIpo_nr_id() {
        return ipo_nr_id;
    }

    /**
     * @param ipo_nr_id the ipo_nr_id to set
     */
    public void setIpo_nr_id(int ipo_nr_id) {
        this.ipo_nr_id = ipo_nr_id;
    }
 }