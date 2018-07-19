/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tes_temporaria_servicoT
/*     */ {
/*     */   private float fator_Atual;
/*     */   private float fator_projetado;
/*     */   private int plc_nr_id;
/*     */   private int plc_nr_id_super;
/*     */   private String plc_tx_nome_super;
/*     */   private String plco_tx_nome;
/*     */   private String plco_tx_tipo;
/*     */   private String plco_tx_unidade;
/*     */   private float plco_nr_quantidade;
/*     */   private float plco_nr_vl_unitario;
/*     */   private float plco_nr_vl_total;
/*     */   private int plco_nr_id;
/*     */   private int tes_plc_nr_id_servico;
/*     */   private String plco_tx_cod_externo;
/*     */   private int obr_nr_id;
/*     */   private int plco_nr_nivel;
/*     */   private int ipo_nr_id_nivel_1;
/*     */   private int ipo_nr_id_nivel_2;
/*     */   private int ipo_nr_id_nivel_3;
/*     */   private int ipo_nr_id;
/*     */   private int ipo_nr_id_super;
/*     */   private List<Meo_meses_obraT> listMesesObra;
/*     */   private double soma_qtde_original;
/*     */   private double soma_qtde_copia;
/*     */   private double dif_qtde;
/*     */   private double soma_valor_original;
/*     */   private double soma_valor_copia;
/*     */   private double dif_valor;
/*     */   private double totalMesesRestante;
/*     */   private boolean repassarMesesSubsequentes;
/*     */   private int ultimoMesComValor;
/*     */   private int ultimoAnoComValor;
/*     */   private double valorTotalCTP;
/*     */   private double fatorDistribuido;
/*     */   
/*     */   public void setPlco_tx_nome(String plco_tx_nome)
/*     */   {
/*  54 */     this.plco_tx_nome = plco_tx_nome;
/*     */   }
/*     */   
/*     */   public String getPlco_tx_nome() {
/*  58 */     return this.plco_tx_nome;
/*     */   }
/*     */   
/*  61 */   public void setPlco_tx_tipo(String plco_tx_tipo) { this.plco_tx_tipo = plco_tx_tipo; }
/*     */   
/*     */   public String getPlco_tx_tipo()
/*     */   {
/*  65 */     return this.plco_tx_tipo;
/*     */   }
/*     */   
/*  68 */   public void setPlco_tx_unidade(String plco_tx_unidade) { this.plco_tx_unidade = plco_tx_unidade; }
/*     */   
/*     */   public String getPlco_tx_unidade()
/*     */   {
/*  72 */     return this.plco_tx_unidade;
/*     */   }
/*     */   
/*  75 */   public void setPlco_nr_quantidade(float plco_nr_quantidade) { this.plco_nr_quantidade = plco_nr_quantidade; }
/*     */   
/*     */   public float getPlco_nr_quantidade()
/*     */   {
/*  79 */     return this.plco_nr_quantidade;
/*     */   }
/*     */   
/*     */   public void setPlco_nr_vl_total(float plco_nr_vl_total) {
/*  83 */     this.plco_nr_vl_total = plco_nr_vl_total;
/*     */   }
/*     */   
/*     */   public float getPlco_nr_vl_total() {
/*  87 */     return this.plco_nr_vl_total;
/*     */   }
/*     */   
/*  90 */   public void setPlco_nr_id(int plco_nr_id) { this.plco_nr_id = plco_nr_id; }
/*     */   
/*     */   public int getPlco_nr_id()
/*     */   {
/*  94 */     return this.plco_nr_id;
/*     */   }
/*     */   
/*  97 */   public void setTes_plc_nr_id_servico(int tes_plc_nr_id_servico) { this.tes_plc_nr_id_servico = tes_plc_nr_id_servico; }
/*     */   
/*     */   public int getTes_plc_nr_id_servico()
/*     */   {
/* 101 */     return this.tes_plc_nr_id_servico;
/*     */   }
/*     */   
/* 104 */   public void setPlco_tx_cod_externo(String plco_tx_cod_externo) { this.plco_tx_cod_externo = plco_tx_cod_externo; }
/*     */   
/*     */   public String getPlco_tx_cod_externo()
/*     */   {
/* 108 */     return this.plco_tx_cod_externo;
/*     */   }
/*     */   
/* 111 */   public void setObr_nr_id(int obr_nr_id) { this.obr_nr_id = obr_nr_id; }
/*     */   
/*     */   public int getObr_nr_id()
/*     */   {
/* 115 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */   public void setPlco_nr_nivel(int plco_nr_nivel) {
/* 119 */     this.plco_nr_nivel = plco_nr_nivel;
/*     */   }
/*     */   
/*     */   public int getPlco_nr_nivel() {
/* 123 */     return this.plco_nr_nivel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getPlco_nr_vl_unitario()
/*     */   {
/* 130 */     return this.plco_nr_vl_unitario;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlco_nr_vl_unitario(float plco_nr_vl_unitario)
/*     */   {
/* 137 */     this.plco_nr_vl_unitario = plco_nr_vl_unitario;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIpo_nr_id_nivel_1()
/*     */   {
/* 144 */     return this.ipo_nr_id_nivel_1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIpo_nr_id_nivel_1(int ipo_nr_id_nivel_1)
/*     */   {
/* 151 */     this.ipo_nr_id_nivel_1 = ipo_nr_id_nivel_1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIpo_nr_id_nivel_2()
/*     */   {
/* 158 */     return this.ipo_nr_id_nivel_2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIpo_nr_id_nivel_2(int ipo_nr_id_nivel_2)
/*     */   {
/* 165 */     this.ipo_nr_id_nivel_2 = ipo_nr_id_nivel_2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIpo_nr_id_nivel_3()
/*     */   {
/* 172 */     return this.ipo_nr_id_nivel_3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIpo_nr_id_nivel_3(int ipo_nr_id_nivel_3)
/*     */   {
/* 179 */     this.ipo_nr_id_nivel_3 = ipo_nr_id_nivel_3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIpo_nr_id()
/*     */   {
/* 186 */     return this.ipo_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIpo_nr_id(int ipo_nr_id)
/*     */   {
/* 193 */     this.ipo_nr_id = ipo_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIpo_nr_id_super()
/*     */   {
/* 200 */     return this.ipo_nr_id_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIpo_nr_id_super(int ipo_nr_id_super)
/*     */   {
/* 207 */     this.ipo_nr_id_super = ipo_nr_id_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Meo_meses_obraT> getListMesesObra()
/*     */   {
/* 214 */     return this.listMesesObra;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setListMesesObra(List<Meo_meses_obraT> listMesesObra)
/*     */   {
/* 221 */     this.listMesesObra = listMesesObra;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getSoma_qtde_original()
/*     */   {
/* 228 */     return this.soma_qtde_original;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSoma_qtde_original(double soma_qtde_original)
/*     */   {
/* 235 */     this.soma_qtde_original = soma_qtde_original;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getSoma_qtde_copia()
/*     */   {
/* 242 */     return this.soma_qtde_copia;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSoma_qtde_copia(double soma_qtde_copia)
/*     */   {
/* 249 */     this.soma_qtde_copia = soma_qtde_copia;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getDif_qtde()
/*     */   {
/* 256 */     return this.dif_qtde;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDif_qtde(double dif_qtde)
/*     */   {
/* 263 */     this.dif_qtde = dif_qtde;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getSoma_valor_original()
/*     */   {
/* 270 */     return this.soma_valor_original;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSoma_valor_original(double soma_valor_original)
/*     */   {
/* 277 */     this.soma_valor_original = soma_valor_original;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getSoma_valor_copia()
/*     */   {
/* 284 */     return this.soma_valor_copia;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSoma_valor_copia(double soma_valor_copia)
/*     */   {
/* 291 */     this.soma_valor_copia = soma_valor_copia;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getDif_valor()
/*     */   {
/* 298 */     return this.dif_valor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDif_valor(double dif_valor)
/*     */   {
/* 305 */     this.dif_valor = dif_valor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPlc_tx_nome_super()
/*     */   {
/* 312 */     return this.plc_tx_nome_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_tx_nome_super(String plc_tx_nome_super)
/*     */   {
/* 319 */     this.plc_tx_nome_super = plc_tx_nome_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPlc_nr_id()
/*     */   {
/* 326 */     return this.plc_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_nr_id(int plc_nr_id)
/*     */   {
/* 333 */     this.plc_nr_id = plc_nr_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getFator_Atual()
/*     */   {
/* 340 */     return this.fator_Atual;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFator_Atual(float fator_Atual)
/*     */   {
/* 347 */     this.fator_Atual = fator_Atual;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getFator_projetado()
/*     */   {
/* 354 */     return this.fator_projetado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFator_projetado(float fator_projetado)
/*     */   {
/* 361 */     this.fator_projetado = fator_projetado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getTotalMesesRestante()
/*     */   {
/* 368 */     return this.totalMesesRestante;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalMesesRestante(double totalMesesRestante)
/*     */   {
/* 375 */     this.totalMesesRestante = totalMesesRestante;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isRepassarMesesSubsequentes()
/*     */   {
/* 382 */     return this.repassarMesesSubsequentes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepassarMesesSubsequentes(boolean repassarMesesSubsequentes)
/*     */   {
/* 389 */     this.repassarMesesSubsequentes = repassarMesesSubsequentes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUltimoMesComValor()
/*     */   {
/* 396 */     return this.ultimoMesComValor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUltimoMesComValor(int ultimoMesComValor)
/*     */   {
/* 403 */     this.ultimoMesComValor = ultimoMesComValor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUltimoAnoComValor()
/*     */   {
/* 410 */     return this.ultimoAnoComValor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUltimoAnoComValor(int ultimoAnoComValor)
/*     */   {
/* 417 */     this.ultimoAnoComValor = ultimoAnoComValor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getValorTotalCTP()
/*     */   {
/* 424 */     return this.valorTotalCTP;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValorTotalCTP(double valorTotalCTP)
/*     */   {
/* 431 */     this.valorTotalCTP = valorTotalCTP;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPlc_nr_id_super()
/*     */   {
/* 438 */     return this.plc_nr_id_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlc_nr_id_super(int plc_nr_id_super)
/*     */   {
/* 445 */     this.plc_nr_id_super = plc_nr_id_super;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getFatorDistribuido()
/*     */   {
/* 452 */     return this.fatorDistribuido;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFatorDistribuido(double fatorDistribuido)
/*     */   {
/* 459 */     this.fatorDistribuido = fatorDistribuido;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Tes_temporaria_servicoT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */