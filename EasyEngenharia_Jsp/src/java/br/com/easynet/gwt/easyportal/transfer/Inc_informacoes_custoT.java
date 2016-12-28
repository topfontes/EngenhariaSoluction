package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;
//br.com.easynet.gwt.easyportal.transfer.Inc_informacoes_custoT
public class Inc_informacoes_custoT { 
	 private int inc_nr_id;
	 private int obr_nr_id;
	 private int inc_nr_mes;
	 private int inc_nr_ano;
	 private int plc_nr_id;
	 private float inc_tx_custo_acumulado;
	 private float inc_nr_custo_periodo;
	 private String inc_tx_calsas;
	 private String inc_tx_problemas;
	 private String inc_tx_acoes;
	 private String inc_tx_responsavel;
         private String inc_tx_custo_eco_excede_periodo;
         private String inc_tx_custo_eco_excede_acum;
	@Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
	 private java.util.Date inc_dt_prazo;
	 public void setInc_nr_id(int inc_nr_id) {
		 this.inc_nr_id=inc_nr_id;
	}
 
	 public int getInc_nr_id() {
		 return inc_nr_id;
 	} 
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}
 
	 public int getObr_nr_id() {
		 return obr_nr_id;
 	} 
 	 public void setInc_nr_mes(int inc_nr_mes) {
		 this.inc_nr_mes = inc_nr_mes;
	}
 
	 public int getInc_nr_mes() {
		 return inc_nr_mes;
 	} 
 	 public void setInc_nr_ano(int inc_nr_ano) {
		 this.inc_nr_ano=inc_nr_ano;
	}
 
	 public int getInc_nr_ano() {
		 return inc_nr_ano;
 	} 
 	 public void setPlc_nr_id(int plc_nr_id) {
		 this.plc_nr_id=plc_nr_id;
	}
 
	 public int getPlc_nr_id() {
		 return plc_nr_id;
 	} 
 	 public void setInc_tx_custo_acumulado(float inc_tx_custo_acumulado) {
		 this.inc_tx_custo_acumulado=inc_tx_custo_acumulado;
	}
 
	 public float getInc_tx_custo_acumulado() {
		 return inc_tx_custo_acumulado;
 	} 
 	 public void setInc_nr_custo_periodo(float inc_nr_custo_periodo) {
		 this.inc_nr_custo_periodo=inc_nr_custo_periodo;
	}
 
	 public float getInc_nr_custo_periodo() {
		 return inc_nr_custo_periodo;
 	} 
 	 public void setInc_tx_calsas(String inc_tx_calsas) {
		 this.inc_tx_calsas=inc_tx_calsas;
	}
 
	 public String getInc_tx_calsas() {
		 return inc_tx_calsas;
 	} 
 	 public void setInc_tx_problemas(String inc_tx_problemas) {
		 this.inc_tx_problemas=inc_tx_problemas;
	}
 
	 public String getInc_tx_problemas() {
		 return inc_tx_problemas;
 	} 
 	 public void setInc_tx_acoes(String inc_tx_acoes) {
		 this.inc_tx_acoes=inc_tx_acoes;
	}
 
	 public String getInc_tx_acoes() {
		 return inc_tx_acoes;
 	} 
 	 public void setInc_tx_responsavel(String inc_tx_responsavel) {
		 this.inc_tx_responsavel=inc_tx_responsavel;
	}
 
	 public String getInc_tx_responsavel() {
		 return inc_tx_responsavel;
 	} 
 	 public void setInc_dt_prazo(java.util.Date inc_dt_prazo) {
		 this.inc_dt_prazo=inc_dt_prazo;
	}
 
	 public java.util.Date getInc_dt_prazo() {
		 return inc_dt_prazo;
 	}

    /**
     * @return the inc_tx_custo_eco_excede_periodo
     */
    public String getInc_tx_custo_eco_excede_periodo() {
        return inc_tx_custo_eco_excede_periodo;
    }

    /**
     * @param inc_tx_custo_eco_excede_periodo the inc_tx_custo_eco_excede_periodo to set
     */
    public void setInc_tx_custo_eco_excede_periodo(String inc_tx_custo_eco_excede_periodo) {
        this.inc_tx_custo_eco_excede_periodo = inc_tx_custo_eco_excede_periodo;
    }

    /**
     * @return the inc_tx_custo_eco_excede_acum
     */
    public String getInc_tx_custo_eco_excede_acum() {
        return inc_tx_custo_eco_excede_acum;
    }

    /**
     * @param inc_tx_custo_eco_excede_acum the inc_tx_custo_eco_excede_acum to set
     */
    public void setInc_tx_custo_eco_excede_acum(String inc_tx_custo_eco_excede_acum) {
        this.inc_tx_custo_eco_excede_acum = inc_tx_custo_eco_excede_acum;
    }
 }