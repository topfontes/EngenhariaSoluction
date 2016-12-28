package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Pao_parcelamento_obraT { 
	 private int pao_nr_id;
	 private int obr_nr_id;
	 private int par_nr_id;
	 private int plc_nr_id;
         //apenas para cronograma de desembolso
         private int par_nr_parcelas;
         private int par_nr_intervalo_dias;

	 public void setPao_nr_id(int pao_nr_id) {
		 this.pao_nr_id=pao_nr_id;
	}
 
	 public int getPao_nr_id() {
		 return pao_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setPar_nr_id(int par_nr_id) {
		 this.par_nr_id=par_nr_id;
	}
 
	 public int getPar_nr_id() {
		 return par_nr_id;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
 
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	}

    /**
     * @return the par_nr_parcelas
     */
    public int getPar_nr_parcelas() {
        return par_nr_parcelas;
    }

    /**
     * @param par_nr_parcelas the par_nr_parcelas to set
     */
    public void setPar_nr_parcelas(int par_nr_parcelas) {
        this.par_nr_parcelas = par_nr_parcelas;
    }

    /**
     * @return the par_nr_intervalo_dias
     */
    public int getPar_nr_intervalo_dias() {
        return par_nr_intervalo_dias;
    }

    /**
     * @param par_nr_intervalo_dias the par_nr_intervalo_dias to set
     */
    public void setPar_nr_intervalo_dias(int par_nr_intervalo_dias) {
        this.par_nr_intervalo_dias = par_nr_intervalo_dias;
    }
 }