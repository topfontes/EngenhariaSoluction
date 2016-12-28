package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
//br.com.easynet.gwt.easyportal.transfer.Fto_fotosT
public class Fto_fotosT { 
	 private int fto_nr_id;
	 private int obr_nr_id;
	 private int fto_nr_mes;
	 private int fto_nr_ano;
	 private byte[] fto_bt_foto;
         private String fto_tx_nome;
	 public void setFto_nr_id(int fto_nr_id) {
		 this.fto_nr_id=fto_nr_id;
	}
 
	 public int getFto_nr_id() {
		 return fto_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setFto_nr_mes(int fto_nr_mes) {
		 this.fto_nr_mes=fto_nr_mes;
	}
 
	 public int getFto_nr_mes() {
		 return fto_nr_mes;
 	} 
 	 public void setFto_nr_ano(int fto_nr_ano) {
		 this.fto_nr_ano=fto_nr_ano;
	}
 
	 public int getFto_nr_ano() {
		 return fto_nr_ano;
 	} 
 	 public void setFto_bt_foto(byte[] fto_bt_foto) {
		 this.fto_bt_foto=fto_bt_foto;
	}
 
	 public byte[] getFto_bt_foto() {
		 return fto_bt_foto;
 	}

    /**
     * @return the fto_tx_nome
     */
    public String getFto_tx_nome() {
        return fto_tx_nome;
    }

    /**
     * @param fto_tx_nome the fto_tx_nome to set
     */
    public void setFto_tx_nome(String fto_tx_nome) {
        this.fto_tx_nome = fto_tx_nome;
    }
 }