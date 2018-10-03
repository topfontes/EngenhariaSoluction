/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Idc_indice_custoInsertJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 16 */   private Idc_indice_custoT idc_indice_custoT = new Idc_indice_custoT();
/*    */   
/*    */   public void setIdc_indice_custoT(Idc_indice_custoT idc_indice_custoT) {
/* 19 */     this.idc_indice_custoT = idc_indice_custoT;
/*    */   }
/*    */   
/*    */   public Idc_indice_custoT getIdc_indice_custoT() {
/* 23 */     return this.idc_indice_custoT;
/*    */   }
/*    */   
/*    */   public void pageLoad() throws Exception {
/* 27 */     super.pageLoad();
/*    */   }
/*    */   
/*    */   public Idc_indice_custoT existe(Idc_indice_custoT idc_indice_custoT)
/*    */     throws Exception
/*    */   {
/* 33 */     Idc_indice_custoDAO idao = getIdc_indice_custoDAO();
/* 34 */     return idao.getByExiste(idc_indice_custoT);
/*    */   }
/*    */   
/*    */   public void insert() throws Exception
/*    */   {
/*    */     try
/*    */     {
/* 41 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 42 */       Idc_indice_custoT idcbase = existe(this.idc_indice_custoT);
/* 43 */       if (idcbase == null) {
/* 44 */         idc_indice_custoDAO.insert(this.idc_indice_custoT);
/* 45 */         setMsg("msg", "Cadastro efetuado com sucesso!");
/*    */       } else {
/* 47 */         idcbase.setIdc_nr_ic_projetado(this.idc_indice_custoT.getIdc_nr_ic_projetado());
/* 48 */         update(idcbase);
/*    */       }
/*    */       
/* 51 */       clear();
/*    */     } catch (Exception e) {
/* 53 */       e.printStackTrace();
/* 54 */       setMsg("errorMessage", "Falha ao realizar cadastro!");
/*    */     } finally {
/* 56 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void update(Idc_indice_custoT idc_indice_custoT) throws Exception
/*    */   {
/*    */     try {
/* 63 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 64 */       idc_indice_custoDAO.update(idc_indice_custoT);
/* 65 */       setMsg("Alteracao efetuada com sucesso!");
/*    */     }
/*    */     catch (Exception e) {
/* 68 */       e.printStackTrace();
/* 69 */       setMsg("errorMessage", "Falha ao realizar alteracao!");
/*    */     } finally {
/* 71 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void clear()
/*    */     throws Exception
/*    */   {
/* 79 */     this.idc_indice_custoT = new Idc_indice_custoT();
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception
/*    */   {
/*    */     try {
/* 85 */       String page = "idc_indice_custoConsult.jsp";
/* 86 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Idc_indice_custoInsertJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */