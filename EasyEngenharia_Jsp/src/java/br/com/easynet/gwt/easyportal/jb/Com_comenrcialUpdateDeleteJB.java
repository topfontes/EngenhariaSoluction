/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Com_comenrcialUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Com_comenrcialT com_comenrcialT = new Com_comenrcialT();
/*     */   private List<Com_comenrcialT> list;
/*     */   
/*  21 */   public void setCom_comenrcialT(Com_comenrcialT com_comenrcialT) { this.com_comenrcialT = com_comenrcialT; }
/*     */   
/*     */   public Com_comenrcialT getCom_comenrcialT()
/*     */   {
/*  25 */     return this.com_comenrcialT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Com_comenrcialT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Com_comenrcialT> list) {
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
/*  46 */     this.com_comenrcialT = new Com_comenrcialT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  53 */         com_comenrcialDAO.delete(this.com_comenrcialT);
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
/*  68 */     try { Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  69 */       List<Com_comenrcialT> listTemp = com_comenrcialDAO.getByPK(this.com_comenrcialT);
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
/*  85 */         Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  86 */         com_comenrcialDAO.update(this.com_comenrcialT);
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
/* 109 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/* 110 */       List<Com_comenrcialT> listTemp = com_comenrcialDAO.getByPK(this.com_comenrcialT);
/*     */       
/* 112 */       this.com_comenrcialT = (listTemp.size() > 0 ? (Com_comenrcialT)listTemp.get(0) : new Com_comenrcialT());
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
/* 128 */       String page = "com_comenrcialConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "com_comenrcialConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Com_comenrcialUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */