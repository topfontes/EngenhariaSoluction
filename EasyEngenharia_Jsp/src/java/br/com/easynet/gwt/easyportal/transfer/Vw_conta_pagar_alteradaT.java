package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Vw_conta_pagar_alteradaT { 
	 private int ctp_nr_id;
         private int obr_nr_id;
	 private int ctp_nr_mes;
	 private int ctp_nr_ano;
	 private String ctp_nr_documento;
	 private String ctp_tx_obs;
	 private String ctp_tx_fornecedor;
	 private float ctp_nr_valor;
	 private int ctpm_nr_mes;
	 private int ctpm_nr_ano;
         private String ctpm_tx_tipo;
	 public void setCtp_nr_id(int ctp_nr_id) {
		 this.ctp_nr_id=ctp_nr_id;
	}
 
	 public int getCtp_nr_id() {
		 return ctp_nr_id;
 	} 
 	 public void setCtp_nr_mes(int ctp_nr_mes) {
		 this.ctp_nr_mes=ctp_nr_mes;
	}
 
	 public int getCtp_nr_mes() {
		 return ctp_nr_mes;
 	} 
 	 public void setCtp_nr_ano(int ctp_nr_ano) {
		 this.ctp_nr_ano=ctp_nr_ano;
	}
 
	 public int getCtp_nr_ano() {
		 return ctp_nr_ano;
 	} 
 	 public void setCtp_nr_documento(String ctp_nr_documento) {
		 this.ctp_nr_documento=ctp_nr_documento;
	}
 
	 public String getCtp_nr_documento() {
		 return ctp_nr_documento;
 	} 
 	 public void setCtp_tx_obs(String ctp_tx_obs) {
		 this.ctp_tx_obs=ctp_tx_obs;
	}
 
	 public String getCtp_tx_obs() {
		 return ctp_tx_obs;
 	} 
 	 public void setCtp_tx_fornecedor(String ctp_tx_fornecedor) {
		 this.ctp_tx_fornecedor=ctp_tx_fornecedor;
	}
 
	 public String getCtp_tx_fornecedor() {
		 return ctp_tx_fornecedor;
 	} 
 	 public void setCtp_nr_valor(float ctp_nr_valor) {
		 this.ctp_nr_valor=ctp_nr_valor;
	}
 
	 public float getCtp_nr_valor() {
		 return ctp_nr_valor;
 	} 
 	 public void setCtpm_nr_mes(int ctpm_nr_mes) {
		 this.ctpm_nr_mes=ctpm_nr_mes;
	}
 
	 public int getCtpm_nr_mes() {
		 return ctpm_nr_mes;
 	} 
 	 public void setCtpm_nr_ano(int ctpm_nr_ano) {
		 this.ctpm_nr_ano=ctpm_nr_ano;
	}
 
	 public int getCtpm_nr_ano() {
		 return ctpm_nr_ano;
 	}

    /**
     * @return the ctpm_tx_tipo
     */
    public String getCtpm_tx_tipo() {
        return ctpm_tx_tipo;
    }

    /**
     * @param ctpm_tx_tipo the ctpm_tx_tipo to set
     */
    public void setCtpm_tx_tipo(String ctpm_tx_tipo) {
        this.ctpm_tx_tipo = ctpm_tx_tipo;
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