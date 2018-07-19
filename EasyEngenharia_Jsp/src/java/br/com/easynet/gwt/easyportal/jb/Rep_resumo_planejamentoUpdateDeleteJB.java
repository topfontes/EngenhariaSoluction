/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rep_resumo_planejamentoUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Rep_resumo_planejamentoT rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
/*     */   private List<Rep_resumo_planejamentoT> list;
/*     */   
/*  21 */   public void setRep_resumo_planejamentoT(Rep_resumo_planejamentoT rep_resumo_planejamentoT) { this.rep_resumo_planejamentoT = rep_resumo_planejamentoT; }
/*     */   
/*     */   public Rep_resumo_planejamentoT getRep_resumo_planejamentoT()
/*     */   {
/*  25 */     return this.rep_resumo_planejamentoT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Rep_resumo_planejamentoT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Rep_resumo_planejamentoT> list) {
/*  36 */     this.list = list;
/*     */   }
/*     */   
/*     */   public void pageLoad() throws Exception {
/*  40 */     super.pageLoad();
/*     */   }
/*     */   
/*     */   public void clear()
/*     */     throws Exception
/*     */   {
/*  46 */     this.rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  53 */         rep_resumo_planejamentoDAO.delete(this.rep_resumo_planejamentoT);
/*  54 */         setMsg("Exclusao efetuada com sucesso!");
/*  55 */         clear();
/*     */       } else {
/*  57 */         setMsg("errorMessage", "Error: Registro inexistente!");
/*     */       }
/*     */     } catch (Exception e) {
/*  60 */       e.printStackTrace();
/*  61 */       setMsg("errorMessage", "Falha ao realizar exclusao!");
/*     */     } finally {
/*  63 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean exist() throws Exception {
/*  68 */     try { Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  69 */       List<Rep_resumo_planejamentoT> listTemp = rep_resumo_planejamentoDAO.getByPK(this.rep_resumo_planejamentoT);
/*     */       
/*  71 */       return listTemp.size() > 0;
/*     */     } catch (Exception e) {
/*  73 */       e.printStackTrace();
/*  74 */       setMsg("Falha ao realizar consulta!");
/*     */     } finally {
/*  76 */       close();
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public void update() throws Exception
/*     */   {
/*     */     try {
/*  84 */       if (exist()) {
/*  85 */         Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  86 */         rep_resumo_planejamentoDAO.update(this.rep_resumo_planejamentoT);
/*  87 */         setMsg("Alteracao efetuada com sucesso!");
/*     */       } else {
/*  89 */         setMsg("errorMessage", "Error: Registro inexistente!");
/*     */       }
/*     */     } catch (Exception e) {
/*  92 */       e.printStackTrace();
/*  93 */       setMsg("errorMessage", "Falha ao realizar alteracao!");
/*     */     } finally {
/*  95 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void findbyid()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 109 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 110 */       List<Rep_resumo_planejamentoT> listTemp = rep_resumo_planejamentoDAO.getByPK(this.rep_resumo_planejamentoT);
/*     */       
/* 112 */       this.rep_resumo_planejamentoT = (listTemp.size() > 0 ? (Rep_resumo_planejamentoT)listTemp.get(0) : new Rep_resumo_planejamentoT());
/*     */     }
/*     */     catch (Exception e) {
/* 115 */       e.printStackTrace();
/* 116 */       setMsg("errorMessage", "Falha ao realizar consulta!");
/*     */     } finally {
/* 118 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 128 */       String page = "rep_resumo_planejamentoConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "rep_resumo_planejamentoConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Rep_resumo_planejamentoUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */