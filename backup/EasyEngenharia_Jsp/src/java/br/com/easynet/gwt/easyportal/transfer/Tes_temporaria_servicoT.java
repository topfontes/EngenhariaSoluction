/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.transfer;

import java.util.List;

/**
 *
 * @author marcos
 */

public class Tes_temporaria_servicoT {
         private float fator_Atual;
         private float fator_projetado;
         private int plc_nr_id;
         private int plc_nr_id_super;
         private String plc_tx_nome_super;
	 private String plco_tx_nome;
	 private String plco_tx_tipo;
	 private String plco_tx_unidade;
	 private float plco_nr_quantidade;
	 private float plco_nr_vl_unitario;
	 private float plco_nr_vl_total;
	 private int plco_nr_id;
	 private int tes_plc_nr_id_servico;
	 private String plco_tx_cod_externo;
	 private int obr_nr_id;
	 private int plco_nr_nivel;
         private int ipo_nr_id_nivel_1;
         private int ipo_nr_id_nivel_2;
         private int ipo_nr_id_nivel_3;
         private int ipo_nr_id;
         private int ipo_nr_id_super;
          
         //atributos apenas para o relatorio
         private List<Meo_meses_obraT> listMesesObra;
         private double soma_qtde_original;
         private double soma_qtde_copia;
         private double dif_qtde;
         private double soma_valor_original;
         private double soma_valor_copia;
         private double dif_valor;
         private double totalMesesRestante;
         private boolean repassarMesesSubsequentes;
         private int ultimoMesComValor;
         private int ultimoAnoComValor;
         private double valorTotalCTP;
         private double fatorDistribuido;

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
 	 public void setPlco_tx_unidade(String plco_tx_unidade) {
		 this.plco_tx_unidade=plco_tx_unidade;
	}

	 public String getPlco_tx_unidade() {
		 return plco_tx_unidade;
 	}
 	 public void setPlco_nr_quantidade(float plco_nr_quantidade) {
		 this.plco_nr_quantidade=plco_nr_quantidade;
	}

	 public float getPlco_nr_quantidade() {
		 return plco_nr_quantidade;
 	}

 	 public void setPlco_nr_vl_total(float plco_nr_vl_total) {
		 this.plco_nr_vl_total=plco_nr_vl_total;
	}

	 public float getPlco_nr_vl_total() {
		 return plco_nr_vl_total;
 	}
 	 public void setPlco_nr_id(int plco_nr_id) {
		 this.plco_nr_id=plco_nr_id;
	}

	 public int getPlco_nr_id() {
		 return plco_nr_id;
 	}
 	 public void setTes_plc_nr_id_servico(int tes_plc_nr_id_servico) {
		 this.tes_plc_nr_id_servico=tes_plc_nr_id_servico;
	}

	 public int getTes_plc_nr_id_servico() {
		 return tes_plc_nr_id_servico;
 	}
 	 public void setPlco_tx_cod_externo(String plco_tx_cod_externo) {
		 this.plco_tx_cod_externo=plco_tx_cod_externo;
	}

	 public String getPlco_tx_cod_externo() {
		 return plco_tx_cod_externo;
 	}
 	 public void setObr_nr_id(int obr_nr_id) {
		 this.obr_nr_id=obr_nr_id;
	}

	 public int getObr_nr_id() {
		 return obr_nr_id;
 	}

	public void setPlco_nr_nivel(int plco_nr_nivel) {
		 this.plco_nr_nivel=plco_nr_nivel;
	}

	 public int getPlco_nr_nivel() {
		 return plco_nr_nivel;
 	}

    /**
     * @return the plco_nr_vl_unitario
     */
    public float getPlco_nr_vl_unitario() {
        return plco_nr_vl_unitario;
    }

    /**
     * @param plco_nr_vl_unitario the plco_nr_vl_unitario to set
     */
    public void setPlco_nr_vl_unitario(float plco_nr_vl_unitario) {
        this.plco_nr_vl_unitario = plco_nr_vl_unitario;
    }

    /**
     * @return the ipo_nr_id_nivel_1
     */
    public int getIpo_nr_id_nivel_1() {
        return ipo_nr_id_nivel_1;
    }

    /**
     * @param ipo_nr_id_nivel_1 the ipo_nr_id_nivel_1 to set
     */
    public void setIpo_nr_id_nivel_1(int ipo_nr_id_nivel_1) {
        this.ipo_nr_id_nivel_1 = ipo_nr_id_nivel_1;
    }

    /**
     * @return the ipo_nr_id_nivel_2
     */
    public int getIpo_nr_id_nivel_2() {
        return ipo_nr_id_nivel_2;
    }

    /**
     * @param ipo_nr_id_nivel_2 the ipo_nr_id_nivel_2 to set
     */
    public void setIpo_nr_id_nivel_2(int ipo_nr_id_nivel_2) {
        this.ipo_nr_id_nivel_2 = ipo_nr_id_nivel_2;
    }

    /**
     * @return the ipo_nr_id_nivel_3
     */
    public int getIpo_nr_id_nivel_3() {
        return ipo_nr_id_nivel_3;
    }

    /**
     * @param ipo_nr_id_nivel_3 the ipo_nr_id_nivel_3 to set
     */
    public void setIpo_nr_id_nivel_3(int ipo_nr_id_nivel_3) {
        this.ipo_nr_id_nivel_3 = ipo_nr_id_nivel_3;
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
     * @return the ipo_nr_id_super
     */
    public int getIpo_nr_id_super() {
        return ipo_nr_id_super;
    }

    /**
     * @param ipo_nr_id_super the ipo_nr_id_super to set
     */
    public void setIpo_nr_id_super(int ipo_nr_id_super) {
        this.ipo_nr_id_super = ipo_nr_id_super;
    }

    /**
     * @return the listMesesObra
     */
    public List<Meo_meses_obraT> getListMesesObra() {
        return listMesesObra;
    }

    /**
     * @param listMesesObra the listMesesObra to set
     */
    public void setListMesesObra(List<Meo_meses_obraT> listMesesObra) {
        this.listMesesObra = listMesesObra;
    }

    /**
     * @return the soma_qtde_original
     */
    public double getSoma_qtde_original() {
        return soma_qtde_original;
    }

    /**
     * @param soma_qtde_original the soma_qtde_original to set
     */
    public void setSoma_qtde_original(double soma_qtde_original) {
        this.soma_qtde_original = soma_qtde_original;
    }

    /**
     * @return the soma_qtde_copia
     */
    public double getSoma_qtde_copia() {
        return soma_qtde_copia;
    }

    /**
     * @param soma_qtde_copia the soma_qtde_copia to set
     */
    public void setSoma_qtde_copia(double soma_qtde_copia) {
        this.soma_qtde_copia = soma_qtde_copia;
    }

    /**
     * @return the dif_qtde
     */
    public double getDif_qtde() {
        return dif_qtde;
    }

    /**
     * @param dif_qtde the dif_qtde to set
     */
    public void setDif_qtde(double dif_qtde) {
        this.dif_qtde = dif_qtde;
    }

    /**
     * @return the soma_valor_original
     */
    public double getSoma_valor_original() {
        return soma_valor_original;
    }

    /**
     * @param soma_valor_original the soma_valor_original to set
     */
    public void setSoma_valor_original(double soma_valor_original) {
        this.soma_valor_original = soma_valor_original;
    }

    /**
     * @return the soma_valor_copia
     */
    public double getSoma_valor_copia() {
        return soma_valor_copia;
    }

    /**
     * @param soma_valor_copia the soma_valor_copia to set
     */
    public void setSoma_valor_copia(double soma_valor_copia) {
        this.soma_valor_copia = soma_valor_copia;
    }

    /**
     * @return the dif_valor
     */
    public double getDif_valor() {
        return dif_valor;
    }

    /**
     * @param dif_valor the dif_valor to set
     */
    public void setDif_valor(double dif_valor) {
        this.dif_valor = dif_valor;
    }

    /**
     * @return the plc_tx_nome_super
     */
    public String getPlc_tx_nome_super() {
        return plc_tx_nome_super;
    }

    /**
     * @param plc_tx_nome_super the plc_tx_nome_super to set
     */
    public void setPlc_tx_nome_super(String plc_tx_nome_super) {
        this.plc_tx_nome_super = plc_tx_nome_super;
    }

    /**
     * @return the plc_nr_id
     */
    public int getPlc_nr_id() {
        return plc_nr_id;
    }

    /**
     * @param plc_nr_id the plc_nr_id to set
     */
    public void setPlc_nr_id(int plc_nr_id) {
        this.plc_nr_id = plc_nr_id;
    }

    /**
     * @return the fator_Atual
     */
    public float getFator_Atual() {
        return fator_Atual;
    }

    /**
     * @param fator_Atual the fator_Atual to set
     */
    public void setFator_Atual(float fator_Atual) {
        this.fator_Atual = fator_Atual;
    }

    /**
     * @return the fator_projetado
     */
    public float getFator_projetado() {
        return fator_projetado;
    }

    /**
     * @param fator_projetado the fator_projetado to set
     */
    public void setFator_projetado(float fator_projetado) {
        this.fator_projetado = fator_projetado;
    }

    /**
     * @return the totalMesesRestante
     */
    public double getTotalMesesRestante() {
        return totalMesesRestante;
    }

    /**
     * @param totalMesesRestante the totalMesesRestante to set
     */
    public void setTotalMesesRestante(double totalMesesRestante) {
        this.totalMesesRestante = totalMesesRestante;
    }

    /**
     * @return the repassarMesesSubsequentes
     */
    public boolean isRepassarMesesSubsequentes() {
        return repassarMesesSubsequentes;
    }

    /**
     * @param repassarMesesSubsequentes the repassarMesesSubsequentes to set
     */
    public void setRepassarMesesSubsequentes(boolean repassarMesesSubsequentes) {
        this.repassarMesesSubsequentes = repassarMesesSubsequentes;
    }

    /**
     * @return the ultimoMesComValor
     */
    public int getUltimoMesComValor() {
        return ultimoMesComValor;
    }

    /**
     * @param ultimoMesComValor the ultimoMesComValor to set
     */
    public void setUltimoMesComValor(int ultimoMesComValor) {
        this.ultimoMesComValor = ultimoMesComValor;
    }

    /**
     * @return the ultimoAnoComValor
     */
    public int getUltimoAnoComValor() {
        return ultimoAnoComValor;
    }

    /**
     * @param ultimoAnoComValor the ultimoAnoComValor to set
     */
    public void setUltimoAnoComValor(int ultimoAnoComValor) {
        this.ultimoAnoComValor = ultimoAnoComValor;
    }

    /**
     * @return the valorTotalCTP
     */
    public double getValorTotalCTP() {
        return valorTotalCTP;
    }

    /**
     * @param valorTotalCTP the valorTotalCTP to set
     */
    public void setValorTotalCTP(double valorTotalCTP) {
        this.valorTotalCTP = valorTotalCTP;
    }

    /**
     * @return the plc_nr_id_super
     */
    public int getPlc_nr_id_super() {
        return plc_nr_id_super;
    }

    /**
     * @param plc_nr_id_super the plc_nr_id_super to set
     */
    public void setPlc_nr_id_super(int plc_nr_id_super) {
        this.plc_nr_id_super = plc_nr_id_super;
    }

    /**
     * @return the fatorDistribuido
     */
    public double getFatorDistribuido() {
        return fatorDistribuido;
    }

    /**
     * @param fatorDistribuido the fatorDistribuido to set
     */
    public void setFatorDistribuido(double fatorDistribuido) {
        this.fatorDistribuido = fatorDistribuido;
    }



}
