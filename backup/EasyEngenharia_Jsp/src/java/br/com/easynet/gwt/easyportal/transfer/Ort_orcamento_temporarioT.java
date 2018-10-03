package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Ort_orcamento_temporarioT { 
	 private int ort_nr_id;
	 private int obr_nr_id;
	 private int con_nr_id;
	 private int coa_nr_id;
         private int ina_nr_id;
	 private float ort_nr_quantidade;
	 private String ort_tx_letra;
         private String ort_tx_cod_obra;
	 public void setOrt_nr_id(int ort_nr_id) {
		 this.ort_nr_id=ort_nr_id;
	}
 
	 public int getOrt_nr_id() {
		 return ort_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setCon_nr_id(int con_nr_id) {
		 this.con_nr_id=con_nr_id;
	}
 
	 public int getCon_nr_id() {
		 return con_nr_id;
 	} 
 	 public void setCoa_nr_id(int coa_nr_id) {
		 this.coa_nr_id=coa_nr_id;
	}
 
	 public int getCoa_nr_id() {
		 return coa_nr_id;
 	} 
 	 public void setOrt_nr_quantidade(float ort_nr_quantidade) {
		 this.ort_nr_quantidade=ort_nr_quantidade;
	}
 
	 public float getOrt_nr_quantidade() {
		 return ort_nr_quantidade;
 	} 
 	 public void setOrt_tx_letra(String ort_tx_letra) {
		 this.ort_tx_letra=ort_tx_letra;
	}
 
	 public String getOrt_tx_letra() {
		 return ort_tx_letra;
 	}

    /**
     * @return the ina_nr_id
     */
    public int getIna_nr_id() {
        return ina_nr_id;
    }

    /**
     * @param ina_nr_id the ina_nr_id to set
     */
    public void setIna_nr_id(int ina_nr_id) {
        this.ina_nr_id = ina_nr_id;
    }

    /**
     * @return the ort_tx_cod_obra
     */
    public String getOrt_tx_cod_obra() {
        return ort_tx_cod_obra;
    }

    /**
     * @param ort_tx_cod_obra the ort_tx_cod_obra to set
     */
    public void setOrt_tx_cod_obra(String ort_tx_cod_obra) {
        this.ort_tx_cod_obra = ort_tx_cod_obra;
    }
 }