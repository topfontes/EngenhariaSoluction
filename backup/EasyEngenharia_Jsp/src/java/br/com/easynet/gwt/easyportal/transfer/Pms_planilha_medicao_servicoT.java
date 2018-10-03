package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Pms_planilha_medicao_servicoT { 
	 private int pms_nr_id;
	 private int obr_nr_id;
	 private int pms_nr_mes;
         private int pms_nr_ano;
	 private int plco_nr_id;
	 private double  pms_nr_quantidade_servico;
         private int ipo_nr_id_super;
         private int ipo_nr_id;
         private double  pms_nr_percentual;
         
	 public void setPms_nr_id(int pms_nr_id) {
		 this.pms_nr_id=pms_nr_id;
	}
 
	 public int getPms_nr_id() {
		 return pms_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setPms_nr_mes(int pms_nr_mes) {
		 this.pms_nr_mes=pms_nr_mes;
	}
 
	 public int getPms_nr_mes() {
		 return pms_nr_mes;
 	} 
 	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}
 
	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	} 
 	 public void setPms_nr_quantidade_servico(double pms_nr_quantidade_servico) {
		 this.pms_nr_quantidade_servico=pms_nr_quantidade_servico;
	}
 
	 public double getPms_nr_quantidade_servico() {
		 return pms_nr_quantidade_servico;
 	}

    /**
     * @return the pms_nr_ano
     */
    public int getPms_nr_ano() {
        return pms_nr_ano;
    }

    /**
     * @param pms_nr_ano the pms_nr_ano to set
     */
    public void setPms_nr_ano(int pms_nr_ano) {
        this.pms_nr_ano = pms_nr_ano;
    }

    /**
     * @return the pms_nr_id_super
     */
    public int getIpo_nr_id_super() {
        return ipo_nr_id_super;
    }

    /**
     * @param pms_nr_id_super the pms_nr_id_super to set
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

    /**
     * @return the pms_nr_percentual
     */
    public double getPms_nr_percentual() {
        return pms_nr_percentual;
    }

    /**
     * @param pms_nr_percentual the pms_nr_percentual to set
     */
    public void setPms_nr_percentual(double pms_nr_percentual) {
        this.pms_nr_percentual = pms_nr_percentual;
    }
 }