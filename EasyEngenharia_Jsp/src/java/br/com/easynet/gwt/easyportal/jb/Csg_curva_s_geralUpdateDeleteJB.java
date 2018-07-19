/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Csg_curva_s_geralUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Csg_curva_s_geralT csg_curva_s_geralT = new Csg_curva_s_geralT();
/*     */   private List<Csg_curva_s_geralT> list;
/*     */   
/*  21 */   public void setCsg_curva_s_geralT(Csg_curva_s_geralT csg_curva_s_geralT) { this.csg_curva_s_geralT = csg_curva_s_geralT; }
/*     */   
/*     */   public Csg_curva_s_geralT getCsg_curva_s_geralT()
/*     */   {
/*  25 */     return this.csg_curva_s_geralT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Csg_curva_s_geralT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Csg_curva_s_geralT> list) {
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
/*  46 */     this.csg_curva_s_geralT = new Csg_curva_s_geralT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  53 */         csg_curva_s_geralDAO.delete(this.csg_curva_s_geralT);
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
/*  68 */     try { Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  69 */       List<Csg_curva_s_geralT> listTemp = csg_curva_s_geralDAO.getByPK(this.csg_curva_s_geralT);
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
/*  85 */         Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  86 */         csg_curva_s_geralDAO.update(this.csg_curva_s_geralT);
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
/* 109 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 110 */       List<Csg_curva_s_geralT> listTemp = csg_curva_s_geralDAO.getByPK(this.csg_curva_s_geralT);
/*     */       
/* 112 */       this.csg_curva_s_geralT = (listTemp.size() > 0 ? (Csg_curva_s_geralT)listTemp.get(0) : new Csg_curva_s_geralT());
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
/* 128 */       String page = "csg_curva_s_geralConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "csg_curva_s_geralConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Csg_curva_s_geralUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */