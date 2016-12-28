package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Dso_descricao_servico_obraT { 
	 private int plco_nr_id;
	 private String dso_tx_codigo_externo;
	 private String dso_tx_descriaco;
	 private int dso_nr_id;
         private int obr_nr_id;
	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}
 
	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	} 
 	 public void setDso_tx_codigo_externo(String dso_tx_codigo_externo) {
		 this.dso_tx_codigo_externo=dso_tx_codigo_externo;
	}
 
	 public String getDso_tx_codigo_externo() {
		 return dso_tx_codigo_externo;
 	} 
 	 public void setDso_tx_descriaco(String dso_tx_descriaco) {
		 this.dso_tx_descriaco=dso_tx_descriaco;
	}
 
	 public String getDso_tx_descriaco() {
		 return dso_tx_descriaco;
 	} 
 	 public void setDso_nr_id(int dso_nr_id) {
		 this.dso_nr_id=dso_nr_id;
	}
 
	 public int getDso_nr_id() {
		 return dso_nr_id;
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
 }