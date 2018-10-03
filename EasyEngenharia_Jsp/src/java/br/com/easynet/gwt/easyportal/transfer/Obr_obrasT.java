/*     */ package br.com.easynet.gwt.easyportal.transfer;
/*     */ 
/*     */ import br.com.easynet.annotation.Conversion;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Obr_obrasT
/*     */ {
/*     */   private int obr_nr_id;
/*     */   private String obr_tx_nome;
/*     */   private String obr_tx_endereco;
/*     */   private String obr_tx_bairro;
/*     */   private String obr_tx_cidade;
/*     */   private String obr_tx_uf;
/*     */   private int emp_nr_id;
/*     */   private float obr_nr_area_construida_total;
/*     */   private float obr_nr_area_privativa_total;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_inicio;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_fim;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_inicio_controle;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_termino_controle;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_inicio_real;
/*     */   @Conversion(classe="br.com.easynet.convesion.ConvertDate", format="dd/MM/yyyy")
/*     */   private Date obr_dt_final_real;
/*     */   private int obr_nr_id_plc_mdo_direta;
/*     */   private int obr_nr_id_plc_mdo_indireta;
/*     */   private float obr_nr_percent_mdo_direta;
/*     */   private float obr_nr_percent_mdo_indireta;
/*     */   private float obr_nr_valor_permutado;
/*     */   private float obr_nr_valor_vgv;
/*     */   private float obr_nr_encarcos_juros_aplicacao;
/*     */   
/*     */   public void setObr_nr_id(int obr_nr_id)
/*     */   {
/*  41 */     this.obr_nr_id = obr_nr_id;
/*     */   }
/*     */   
/*     */   public int getObr_nr_id() {
/*  45 */     return this.obr_nr_id;
/*     */   }
/*     */   
/*     */   public void setObr_tx_nome(String obr_tx_nome) {
/*  49 */     this.obr_tx_nome = obr_tx_nome;
/*     */   }
/*     */   
/*     */   public String getObr_tx_nome() {
/*  53 */     return this.obr_tx_nome;
/*     */   }
/*     */   
/*     */   public void setObr_tx_endereco(String obr_tx_endereco) {
/*  57 */     this.obr_tx_endereco = obr_tx_endereco;
/*     */   }
/*     */   
/*     */   public String getObr_tx_endereco() {
/*  61 */     return this.obr_tx_endereco;
/*     */   }
/*     */   
/*     */   public void setObr_tx_bairro(String obr_tx_bairro) {
/*  65 */     this.obr_tx_bairro = obr_tx_bairro;
/*     */   }
/*     */   
/*     */   public String getObr_tx_bairro() {
/*  69 */     return this.obr_tx_bairro;
/*     */   }
/*     */   
/*     */   public void setObr_tx_cidade(String obr_tx_cidade) {
/*  73 */     this.obr_tx_cidade = obr_tx_cidade;
/*     */   }
/*     */   
/*     */   public String getObr_tx_cidade() {
/*  77 */     return this.obr_tx_cidade;
/*     */   }
/*     */   
/*     */   public void setObr_tx_uf(String obr_tx_uf) {
/*  81 */     this.obr_tx_uf = obr_tx_uf;
/*     */   }
/*     */   
/*     */   public String getObr_tx_uf() {
/*  85 */     return this.obr_tx_uf;
/*     */   }
/*     */   
/*     */   public void setEmp_nr_id(int emp_nr_id) {
/*  89 */     this.emp_nr_id = emp_nr_id;
/*     */   }
/*     */   
/*     */   public int getEmp_nr_id() {
/*  93 */     return this.emp_nr_id;
/*     */   }
/*     */   
/*     */   public void setObr_nr_area_construida_total(float obr_nr_area_construida_total) {
/*  97 */     this.obr_nr_area_construida_total = obr_nr_area_construida_total;
/*     */   }
/*     */   
/*     */   public float getObr_nr_area_construida_total() {
/* 101 */     return this.obr_nr_area_construida_total;
/*     */   }
/*     */   
/*     */   public void setObr_dt_inicio(Date obr_dt_inicio) {
/* 105 */     this.obr_dt_inicio = obr_dt_inicio;
/*     */   }
/*     */   
/*     */   public Date getObr_dt_inicio() {
/* 109 */     return this.obr_dt_inicio;
/*     */   }
/*     */   
/*     */   public void setObr_dt_fim(Date obr_dt_fim) {
/* 113 */     this.obr_dt_fim = obr_dt_fim;
/*     */   }
/*     */   
/*     */   public Date getObr_dt_fim() {
/* 117 */     return this.obr_dt_fim;
/*     */   }
/*     */   
/*     */   public void setObr_dt_inicio_controle(Date obr_dt_inicio_controle) {
/* 121 */     this.obr_dt_inicio_controle = obr_dt_inicio_controle;
/*     */   }
/*     */   
/*     */   public Date getObr_dt_inicio_controle() {
/* 125 */     return this.obr_dt_inicio_controle;
/*     */   }
/*     */   
/*     */   public void setObr_dt_termino_controle(Date obr_dt_termino_controle) {
/* 129 */     this.obr_dt_termino_controle = obr_dt_termino_controle;
/*     */   }
/*     */   
/*     */   public Date getObr_dt_termino_controle() {
/* 133 */     return this.obr_dt_termino_controle;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_area_privativa_total()
/*     */   {
/* 140 */     return this.obr_nr_area_privativa_total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_area_privativa_total(float obr_nr_area_privativa_total)
/*     */   {
/* 147 */     this.obr_nr_area_privativa_total = obr_nr_area_privativa_total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getObr_nr_id_plc_mdo_direta()
/*     */   {
/* 154 */     return this.obr_nr_id_plc_mdo_direta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_id_plc_mdo_direta(int obr_nr_id_plc_mdo_direta)
/*     */   {
/* 161 */     this.obr_nr_id_plc_mdo_direta = obr_nr_id_plc_mdo_direta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getObr_nr_id_plc_mdo_indireta()
/*     */   {
/* 168 */     return this.obr_nr_id_plc_mdo_indireta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_id_plc_mdo_indireta(int obr_nr_id_plc_mdo_indireta)
/*     */   {
/* 175 */     this.obr_nr_id_plc_mdo_indireta = obr_nr_id_plc_mdo_indireta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_percent_mdo_direta()
/*     */   {
/* 182 */     return this.obr_nr_percent_mdo_direta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_percent_mdo_direta(float obr_nr_percent_mdo_direta)
/*     */   {
/* 189 */     this.obr_nr_percent_mdo_direta = obr_nr_percent_mdo_direta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_percent_mdo_indireta()
/*     */   {
/* 196 */     return this.obr_nr_percent_mdo_indireta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_percent_mdo_indireta(float obr_nr_percent_mdo_indireta)
/*     */   {
/* 203 */     this.obr_nr_percent_mdo_indireta = obr_nr_percent_mdo_indireta;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_valor_permutado()
/*     */   {
/* 210 */     return this.obr_nr_valor_permutado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_valor_permutado(float obr_nr_valor_permutado)
/*     */   {
/* 217 */     this.obr_nr_valor_permutado = obr_nr_valor_permutado;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_valor_vgv()
/*     */   {
/* 224 */     return this.obr_nr_valor_vgv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_valor_vgv(float obr_nr_valor_vgv)
/*     */   {
/* 231 */     this.obr_nr_valor_vgv = obr_nr_valor_vgv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getObr_nr_encarcos_juros_aplicacao()
/*     */   {
/* 238 */     return this.obr_nr_encarcos_juros_aplicacao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_nr_encarcos_juros_aplicacao(float obr_nr_encarcos_juros_aplicacao)
/*     */   {
/* 245 */     this.obr_nr_encarcos_juros_aplicacao = obr_nr_encarcos_juros_aplicacao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getObr_dt_inicio_real()
/*     */   {
/* 252 */     return this.obr_dt_inicio_real;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_dt_inicio_real(Date obr_dt_inicio_real)
/*     */   {
/* 259 */     this.obr_dt_inicio_real = obr_dt_inicio_real;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getObr_dt_final_real()
/*     */   {
/* 266 */     return this.obr_dt_final_real;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setObr_dt_final_real(Date obr_dt_final_real)
/*     */   {
/* 273 */     this.obr_dt_final_real = obr_dt_final_real;
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/transfer/Obr_obrasT.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */