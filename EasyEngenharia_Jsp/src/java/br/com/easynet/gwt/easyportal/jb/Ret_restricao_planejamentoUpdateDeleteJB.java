/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ret_restricao_planejamentoUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Ret_restricao_planejamentoT ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*     */   private List<Ret_restricao_planejamentoT> list;
/*     */   
/*  21 */   public void setRet_restricao_planejamentoT(Ret_restricao_planejamentoT ret_restricao_planejamentoT) { this.ret_restricao_planejamentoT = ret_restricao_planejamentoT; }
/*     */   
/*     */   public Ret_restricao_planejamentoT getRet_restricao_planejamentoT()
/*     */   {
/*  25 */     return this.ret_restricao_planejamentoT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Ret_restricao_planejamentoT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Ret_restricao_planejamentoT> list) {
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
/*  46 */     this.ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  53 */         ret_restricao_planejamentoDAO.delete(this.ret_restricao_planejamentoT);
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
/*  68 */     try { Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  69 */       List<Ret_restricao_planejamentoT> listTemp = ret_restricao_planejamentoDAO.getByPK(this.ret_restricao_planejamentoT);
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
/*  85 */         Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  86 */         ret_restricao_planejamentoDAO.update(this.ret_restricao_planejamentoT);
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
/* 109 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 110 */       List<Ret_restricao_planejamentoT> listTemp = ret_restricao_planejamentoDAO.getByPK(this.ret_restricao_planejamentoT);
/*     */       
/* 112 */       this.ret_restricao_planejamentoT = (listTemp.size() > 0 ? (Ret_restricao_planejamentoT)listTemp.get(0) : new Ret_restricao_planejamentoT());
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
/* 128 */       String page = "ret_restricao_planejamentoConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "ret_restricao_planejamentoConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Ret_restricao_planejamentoUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */