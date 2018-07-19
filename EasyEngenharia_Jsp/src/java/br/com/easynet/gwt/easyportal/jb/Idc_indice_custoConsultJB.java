/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Plc_plano_contasDAO;
/*     */ import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Plc_plano_contasT;
/*     */ import java.util.List;
/*     */ import java.util.TreeMap;
/*     */ import java.util.Vector;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ public class Idc_indice_custoConsultJB extends SystemBase implements INotSecurity
/*     */ {
/*  20 */   private Idc_indice_custoT idc_indice_custoT = new Idc_indice_custoT();
/*     */   private List<Idc_indice_custoT> list;
/*     */   
/*  23 */   public void setIdc_indice_custoT(Idc_indice_custoT idc_indice_custoT) { this.idc_indice_custoT = idc_indice_custoT; }
/*     */   
/*     */   public Idc_indice_custoT getIdc_indice_custoT()
/*     */   {
/*  27 */     return this.idc_indice_custoT;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Idc_indice_custoT> getList()
/*     */   {
/*  33 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Idc_indice_custoT> list) {
/*  37 */     this.list = list;
/*     */   }
/*     */   
/*     */   public void pageLoad() throws Exception {
/*  41 */     super.pageLoad();
/*  42 */     consult();
/*     */   }
/*     */   
/*     */   public void consult() throws Exception {
/*     */     try {
/*  47 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*     */       
/*  49 */       Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
/*  50 */       TreeMap<Integer, Double> treeApagar = cdao.getCustoRealizadoAcumuladoAgrupadoSubClasseBI(obr_nr_id, mes, ano, "A");
/*  51 */       TreeMap<Integer, Double> treePagas = cdao.getCustoRealizadoAcumuladoAgrupadoSubClasseBI(obr_nr_id, mes, ano, "P");
/*     */       
/*  53 */       Est_estoqueDAO edao = getEst_estoqueDAO();
/*  54 */       TreeMap<Integer, Double> treeEstoque = edao.getBySubClasseTreeBI(obr_nr_id, mes, ano);
/*     */       
/*  56 */       Com_comprometimentoDAO comDao = getCom_comprometimentoDAO();
/*  57 */       TreeMap<Integer, Double> treeComp = comDao.getValorSubClasseAcumuladoBI(obr_nr_id, mes, ano);
/*     */       
/*  59 */       Pms_planilha_medicao_servicoDAO pdao = getPms_planilha_medicao_servicoDAO();
/*  60 */       TreeMap<Integer, Double> treePMS = pdao.getByQtdeAcumuladaSubClasseBI(obr_nr_id, mes, ano);
/*     */       
/*  62 */       Plc_plano_contasDAO plcDao = getPlc_plano_contasDAO();
/*  63 */       List<Plc_plano_contasT> listSubClasse = plcDao.getByContaSubClasseBI(this.obr_nr_id);
/*     */       
/*  65 */       Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
/*  66 */       TreeMap<Integer, Double> treeOrcClasse = idao.getByObr_nr_idClasseBI(this.obr_nr_id);
/*  67 */       TreeMap<Integer, Double> treeOrcPLCO = idao.getByObr_nr_idClassePLCOBI(this.obr_nr_id);
/*     */       
/*  69 */       TreeMap<Integer, Double> treeIC_projetado = idc_indice_custoDAO.getByEmp_nr_id(this.obr_nr_id, this.mes, this.ano);
/*     */       
/*  71 */       float TotalOrcamento = idao.getTotalObr_nr_id(this.obr_nr_id);

/*  89 */       this.list = new Vector();
/*     */       
/*  91 */       for (Plc_plano_contasT plc : listSubClasse) {
/*  92 */         Idc_indice_custoT idc_indice_custoT = new Idc_indice_custoT();
/*  93 */         idc_indice_custoT.setPlc_nr_id(plc.getPlc_nr_id());
/*  94 */         idc_indice_custoT.setObr_nr_id(this.obr_nr_id);
/*  95 */         idc_indice_custoT.setIdc_nr_mes(this.mes);
/*  96 */         idc_indice_custoT.setIdc_nr_ano(this.ano);
/*  97 */         idc_indice_custoT.setSubClasse(plc.getPlc_tx_nome());
/*  98 */         idc_indice_custoT.setClasse(plc.getPlc_tx_nome_classe());
/*     */         
/* 100 */         boolean comdados = false;
/* 101 */         double totalCTP = 0.0D;
/* 102 */         if (treeApagar.containsKey(Integer.valueOf(plc.getPlc_nr_id()))) {
/* 103 */           totalCTP = ((Double)treeApagar.get(Integer.valueOf(plc.getPlc_nr_id()))).doubleValue();
/* 104 */           comdados = true;
/*     */         }
/*     */         
/* 107 */         if (treePagas.containsKey(Integer.valueOf(plc.getPlc_nr_id()))) {
/* 108 */           totalCTP += ((Double)treePagas.get(Integer.valueOf(plc.getPlc_nr_id()))).doubleValue();
/* 109 */           comdados = true;
/*     */         }
/*     */         
/* 112 */         double vl_estoque = 0.0D;
/* 113 */         if (treeEstoque.containsKey(Integer.valueOf(plc.getPlc_nr_id()))) {
/* 114 */           vl_estoque = ((Double)treeEstoque.get(Integer.valueOf(plc.getPlc_nr_id()))).doubleValue();
/* 115 */           comdados = true;
/*     */         }
/*     */         
/* 118 */         double vlComp = 0.0D;
/* 119 */         if (treeComp.containsKey(Integer.valueOf(plc.getPlc_nr_id()))) {
/* 120 */           vlComp = ((Double)treeComp.get(Integer.valueOf(plc.getPlc_nr_id()))).doubleValue();
/* 121 */           comdados = true;
/*     */         }
/*     */         
/* 124 */         double qtPms = 0.0D;
/* 125 */         if (treePMS.containsKey(Integer.valueOf(plc.getPlc_nr_id()))) {
/* 126 */           qtPms = ((Double)treePMS.get(Integer.valueOf(plc.getPlc_nr_id()))).doubleValue();
/* 127 */           comdados = true;
/*     */         }
/*     */         
/* 130 */         double atual = 0.0D;
/* 131 */         if (qtPms > 0.0D) {
/* 132 */           atual = (totalCTP - vl_estoque + vlComp) / qtPms;
/* 133 */           comdados = true;
/*     */         }
/*     */         
/* 136 */         double custo_orcClasse = 0.0D;
/*     */         
/* 138 */         if (treeOrcClasse.containsKey(Integer.valueOf(plc.getPlc_nr_id_super()))) {
/* 139 */           custo_orcClasse = ((Double)treeOrcClasse.get(Integer.valueOf(plc.getPlc_nr_id_super()))).doubleValue();
/*     */         }
/*     */         
/* 142 */         if (comdados) {
/* 143 */           idc_indice_custoT.setIdc_nr_ic_atual(atual);
/* 144 */           idc_indice_custoT.setIdc_nr_ic_projetado(0.0D);
/* 145 */           if (treeIC_projetado.containsKey(Integer.valueOf(plc.getPlc_nr_id_super()))) {
/* 146 */             idc_indice_custoT.setIdc_nr_ic_projetado(((Double)treeIC_projetado.get(Integer.valueOf(plc.getPlc_nr_id_super()))).doubleValue());
/*     */           }
/* 148 */           idc_indice_custoT.setIdc_nr_projetado_empreendimento(custo_orcClasse / TotalOrcamento * idc_indice_custoT.getIdc_nr_ic_projetado());
/* 149 */           this.list.add(idc_indice_custoT); } } } catch (Exception e) { TreeMap<Integer, Double> treeApagar;
/*     */       TreeMap<Integer, Double> treePagas;
/*     */       TreeMap<Integer, Double> treeEstoque;
/*     */       TreeMap<Integer, Double> treeComp;
/*     */       TreeMap<Integer, Double> treePMS;
/*     */       TreeMap<Integer, Double> treeOrcClasse;
/* 155 */       TreeMap<Integer, Double> treeIC_projetado; double TotalOrcamento; e.printStackTrace();
/* 156 */       setMsg("errorMessage", "Falha ao realizar consulta!");
/*     */     } finally {
/* 158 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/* 164 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 165 */       idc_indice_custoDAO.delete(this.idc_indice_custoT);
/* 166 */       setMsg("Exclusao efetuada com sucesso!");
/* 167 */       this.idc_indice_custoT = new Idc_indice_custoT();
/* 168 */       consult();
/*     */     } catch (Exception e) {
/* 170 */       e.printStackTrace();
/* 171 */       setMsg("errorMessage", "Falha ao realizar exclusao!");
/*     */     } finally {
/* 173 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public void insert() throws Exception
/*     */   {
/*     */     try {
/* 180 */       String page = "idc_indice_custoInsert.jsp";
/* 181 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception
/*     */   {
/*     */     try {
/* 189 */       String page = "";
/* 190 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Idc_indice_custoConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */