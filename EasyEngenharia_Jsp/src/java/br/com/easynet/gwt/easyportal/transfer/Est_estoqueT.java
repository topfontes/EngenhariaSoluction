package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;
//br.com.easynet.gwt.easyportal.transfer.Est_estoqueT
public class Est_estoqueT { 
	 private int est_nr_id;
	 private int est_nr_mes;
	 private int plc_nr_id;
	 private float est_nr_quantidade;
	 private float est_nr_vl_unitario;
	 private float est_nr_vl_total;
	 private String est_tx_unidade;
	 private int obr_nr_id;
         private int est_nr_ano;
         private String est_tx_key;
         private String est_tx_nome;
         @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
         private Date est_dt_base;
	 public void setEst_nr_id(int est_nr_id) {
		 this.est_nr_id=est_nr_id;
	}
 
	 public int getEst_nr_id() {
		 return est_nr_id;
 	} 
 	 public void setEst_nr_mes(int est_nr_mes) {
		 this.est_nr_mes=est_nr_mes;
	}
 
	 public int getEst_nr_mes() {
		 return est_nr_mes;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
 
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	} 
 	 public void setEst_nr_quantidade(float est_nr_quantidade) {
		 this.est_nr_quantidade=est_nr_quantidade;
	}
 
	 public float getEst_nr_quantidade() {
		 return est_nr_quantidade;
 	} 
 	 public void setEst_nr_vl_unitario(float est_nr_vl_unitario) {
		 this.est_nr_vl_unitario=est_nr_vl_unitario;
	}
 
	 public float getEst_nr_vl_unitario() {
		 return est_nr_vl_unitario;
 	} 
 	 public void setEst_nr_vl_total(float est_nr_vl_total) {
		 this.est_nr_vl_total=est_nr_vl_total;
	}
 
	 public float getEst_nr_vl_total() {
		 return est_nr_vl_total;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	}

    /**
     * @return the est_nr_ano
     */
    public int getEst_nr_ano() {
        return est_nr_ano;
    }

    /**
     * @param est_nr_ano the est_nr_ano to set
     */
    public void setEst_nr_ano(int est_nr_ano) {
        this.est_nr_ano = est_nr_ano;
    }

    /**
     * @return the ume_nr_id
     */
    public String getEst_tx_unidade() {
        return est_tx_unidade;
    }

    /**
     * @param ume_nr_id the ume_nr_id to set
     */
    public void setEst_tx_unidade(String est_tx_unidade) {
        this.est_tx_unidade = est_tx_unidade;
    }

    /**
     * @return the est_dt_base
     */
    public Date getEst_dt_base() {
        return est_dt_base;
    }

    /**
     * @param est_dt_base the est_dt_base to set
     */
    public void setEst_dt_base(Date est_dt_base) {
        this.est_dt_base = est_dt_base;
    }

    /**
     * @return the est_tx_key
     */
    public String getEst_tx_key() {
        return est_tx_key;
    }

    /**
     * @param est_tx_key the est_tx_key to set
     */
    public void setEst_tx_key(String est_tx_key) {
        this.est_tx_key = est_tx_key;
    }

    /**
     * @return the est_tx_nome
     */
    public String getEst_tx_nome() {
        return est_tx_nome;
    }

    /**
     * @param est_tx_nome the est_tx_nome to set
     */
    public void setEst_tx_nome(String est_tx_nome) {
        this.est_tx_nome = est_tx_nome;
    }
 }