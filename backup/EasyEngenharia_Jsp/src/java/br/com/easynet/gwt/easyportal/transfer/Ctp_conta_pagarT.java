package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
import java.util.Date;

public class Ctp_conta_pagarT { 
	 private int ctp_nr_id;
	 private String ctp_tx_fornecedor;
	 private int ctp_nr_mes;
	 private int plc_nr_id;
	 private double ctp_nr_valor;
	 private String ctp_nr_documento;
	 private String ctp_tx_status;
	 private int obr_nr_id;
         private int ctp_nr_ano;
         private String ctp_tx_obs;
         @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
         private Date ctp_dt_vencimento;
         @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
         private Date ctp_dt_emissao;
	 public void setCtp_nr_id(int ctp_nr_id) {
		 this.ctp_nr_id=ctp_nr_id;
	}
 
	 public int getCtp_nr_id() {
		 return ctp_nr_id;
 	}

//         public static void main(String[] arg){
//             String nom = "CADGRAFFICS SERVI€OS LTDA";
//             Ctp_conta_pagarT ct = new Ctp_conta_pagarT();
//             ct.setCtp_tx_fornecedor(nom);
//             String ss = ct.getCtp_tx_fornecedor();
//         }

 	 public void setCtp_tx_fornecedor(String ctp_tx_fornecedor) {
		 this.ctp_tx_fornecedor = ctp_tx_fornecedor.replace("€", "Ç");
	}
 
	 public String getCtp_tx_fornecedor() {
		 return ctp_tx_fornecedor;
 	}
         
 	 public void setCtp_nr_mes(int ctp_nr_mes) {
		 this.ctp_nr_mes=ctp_nr_mes;
	}
 
	 public int getCtp_nr_mes() {
		 return ctp_nr_mes;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
  
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	} 
 	 public void setCtp_nr_valor(double ctp_nr_valor) {
		 this.ctp_nr_valor=ctp_nr_valor;
	}
 
	 public double getCtp_nr_valor() {
		 return ctp_nr_valor;
 	} 
 	 public void setCtp_nr_documento(String ctp_nr_documento) {
		 this.ctp_nr_documento=ctp_nr_documento;
	}
 
	 public String getCtp_nr_documento() {
		 return ctp_nr_documento;
 	} 
 	 public void setCtp_tx_status(String ctp_tx_status) {
		 this.ctp_tx_status=ctp_tx_status;
	}
 
	 public String getCtp_tx_status() {
		 return ctp_tx_status;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	}

    /**
     * @return the ctp_nr_ano
     */
    public int getCtp_nr_ano() {
        return ctp_nr_ano;
    }

    /**
     * @param ctp_nr_ano the ctp_nr_ano to set
     */
    public void setCtp_nr_ano(int ctp_nr_ano) {
        this.ctp_nr_ano = ctp_nr_ano;
    }

    /**
     * @return the ctp_tx_obs
     */
    public String getCtp_tx_obs() {
        return ctp_tx_obs;
    }

    /**
     * @param ctp_tx_obs the ctp_tx_obs to set
     */
    public void setCtp_tx_obs(String ctp_tx_obs) {
        this.ctp_tx_obs = ctp_tx_obs;
    }

    /**
     * @return the ctp_dt_vencimento
     */
    public Date getCtp_dt_vencimento() {
        return ctp_dt_vencimento;
    }

    /**
     * @param ctp_dt_vencimento the ctp_dt_vencimento to set
     */
    public void setCtp_dt_vencimento(Date ctp_dt_vencimento) {
        this.ctp_dt_vencimento = ctp_dt_vencimento;
    }

    /**
     * @return the ctp_dt_pagamento
     */
    public Date getCtp_dt_emissao() {
        return ctp_dt_emissao;
    }

    /**
     * @param ctp_dt_pagamento the ctp_dt_pagamento to set
     */
    public void setCtp_dt_emissao(Date ctp_dt_emissao) {
        this.ctp_dt_emissao = ctp_dt_emissao;
    }
 }