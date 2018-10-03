/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Idc_indice_custoUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Idc_indice_custoT idc_indice_custoT = new Idc_indice_custoT();
/*     */   private List<Idc_indice_custoT> list;
/*     */   
/*  21 */   public void setIdc_indice_custoT(Idc_indice_custoT idc_indice_custoT) { this.idc_indice_custoT = idc_indice_custoT; }
/*     */   
/*     */   public Idc_indice_custoT getIdc_indice_custoT()
/*     */   {
/*  25 */     return this.idc_indice_custoT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Idc_indice_custoT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Idc_indice_custoT> list) {
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
/*  46 */     this.idc_indice_custoT = new Idc_indice_custoT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  53 */         idc_indice_custoDAO.delete(this.idc_indice_custoT);
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
/*  68 */     try { Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  69 */       List<Idc_indice_custoT> listTemp = idc_indice_custoDAO.getByPK(this.idc_indice_custoT);
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
/*  85 */         Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  86 */         idc_indice_custoDAO.update(this.idc_indice_custoT);
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
/* 109 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 110 */       List<Idc_indice_custoT> listTemp = idc_indice_custoDAO.getByPK(this.idc_indice_custoT);
/*     */       
/* 112 */       this.idc_indice_custoT = (listTemp.size() > 0 ? (Idc_indice_custoT)listTemp.get(0) : new Idc_indice_custoT());
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
/* 128 */       String page = "idc_indice_custoConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "idc_indice_custoConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Idc_indice_custoUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */