package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Inp_intervalo_parcelaT { 
	 private int inp_nr_id;
	 private int par_nr_id;
	 private int inp_nr_dias;
	 private float inp_nr_per;
         private int inp_nr_sequencia;
	 public void setInp_nr_id(int inp_nr_id) {
		 this.inp_nr_id=inp_nr_id;
	}
 
	 public int getInp_nr_id() {
		 return inp_nr_id;
 	} 
 	 public void setPar_nr_id(int par_nr_id) {
		 this.par_nr_id=par_nr_id;
	}
 
	 public int getPar_nr_id() {
		 return par_nr_id;
 	} 
 	 public void setInp_nr_dias(int inp_nr_dias) {
		 this.inp_nr_dias=inp_nr_dias;
	}
 
	 public int getInp_nr_dias() {
		 return inp_nr_dias;
 	} 
 	 public void setInp_nr_per(float inp_nr_per) {
		 this.inp_nr_per=inp_nr_per;
	}
 
	 public float getInp_nr_per() {
		 return inp_nr_per;
 	}

    /**
     * @return the inp_nr_sequencia
     */
    public int getInp_nr_sequencia() {
        return inp_nr_sequencia;
    }

    /**
     * @param inp_nr_sequencia the inp_nr_sequencia to set
     */
    public void setInp_nr_sequencia(int inp_nr_sequencia) {
        this.inp_nr_sequencia = inp_nr_sequencia;
    }
 }