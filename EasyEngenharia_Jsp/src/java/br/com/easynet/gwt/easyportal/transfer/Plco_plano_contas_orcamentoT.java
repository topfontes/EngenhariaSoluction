package br.com.easynet.gwt.easyportal.transfer;

import br.com.easynet.annotation.Conversion;

public class Plco_plano_contas_orcamentoT { 
	 private int plco_nr_id;
	 private String plco_tx_nome;
	 private String plco_tx_tipo;
	 private String plco_tx_cod_externo;
	 private String plco_tx_unidade;
	 private int plco_nr_id_super;
         private int plco_nr_nivel;
         private int par_nr_id;
         private boolean plco_bl_equivalencia;
         private String subClasse;
         private int plc_nr_id;
	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}
 
	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	} 
 	 public void setPlco_tx_nome(String plco_tx_nome) {
		 this.plco_tx_nome=plco_tx_nome;
	}
 
	 public String getPlco_tx_nome() {
		 return plco_tx_nome;
 	} 
 	 public void setPlco_tx_tipo(String plco_tx_tipo) {
		 this.plco_tx_tipo=plco_tx_tipo;
	}
 
	 public String getPlco_tx_tipo() {
		 return plco_tx_tipo;
 	} 
 	 public void setPlco_tx_cod_externo(String plco_tx_cod_externo) {
		 this.plco_tx_cod_externo=plco_tx_cod_externo;
	}
 
	 public String getPlco_tx_cod_externo() {
		 return plco_tx_cod_externo;
 	} 
 	 public void setPlco_tx_unidade(String plco_tx_unidade) {
		 this.plco_tx_unidade=plco_tx_unidade;
	}
 
	 public String getPlco_tx_unidade() {
		 return plco_tx_unidade;
 	} 
 	 public void setPlco_nr_id_super(int plco_nr_id_super) {
		 this.plco_nr_id_super=plco_nr_id_super;
	}
 
	 public int getPlco_nr_id_super() {
		 return plco_nr_id_super;
 	}

    /**
     * @return the plco_nr_nivel
     */
    public int getPlco_nr_nivel() {
        return plco_nr_nivel;
    }

    /**
     * @param plco_nr_nivel the plco_nr_nivel to set
     */
    public void setPlco_nr_nivel(int plco_nr_nivel) {
        this.plco_nr_nivel = plco_nr_nivel;
    }

    /**
     * @return the plco_bl_equivalencia
     */
    public boolean isPlco_bl_equivalencia() {
        return plco_bl_equivalencia;
    }

    /**
     * @param plco_bl_equivalencia the plco_bl_equivalencia to set
     */
    public void setPlco_bl_equivalencia(boolean plco_bl_equivalencia) {
        this.plco_bl_equivalencia = plco_bl_equivalencia;
    }

    /**
     * @return the par_nr_id
     */
    public int getPar_nr_id() {
        return par_nr_id;
    }

    /**
     * @param par_nr_id the par_nr_id to set
     */
    public void setPar_nr_id(int par_nr_id) {
        this.par_nr_id = par_nr_id;
    }

    /**
     * @return the subClasse
     */
    public String getSubClasse() {
        return subClasse;
    }

    /**
     * @param subClasse the subClasse to set
     */
    public void setSubClasse(String subClasse) {
        this.subClasse = subClasse;
    }
 }