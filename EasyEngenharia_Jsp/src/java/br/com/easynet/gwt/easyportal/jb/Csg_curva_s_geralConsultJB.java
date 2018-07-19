/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Csg_curva_s_geralConsultJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Csg_curva_s_geralT csg_curva_s_geralT = new Csg_curva_s_geralT();
/*    */   private List<Csg_curva_s_geralT> list;
/*    */   
/* 20 */   public void setCsg_curva_s_geralT(Csg_curva_s_geralT csg_curva_s_geralT) { this.csg_curva_s_geralT = csg_curva_s_geralT; }
/*    */   
/*    */   public Csg_curva_s_geralT getCsg_curva_s_geralT()
/*    */   {
/* 24 */     return this.csg_curva_s_geralT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Csg_curva_s_geralT> getList()
/*    */   {
/* 32 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Csg_curva_s_geralT> list) {
/* 36 */     this.list = list;
/*    */   }
/*    */   
/*    */   public void pageLoad() throws Exception {
/* 40 */     super.pageLoad();
/* 41 */     consult();
/*    */   }
/*    */   
/*    */   public void consult() throws Exception {
/*    */     try {
/* 46 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 47 */       this.list = csg_curva_s_geralDAO.getAll(this.obr_nr_id, this.mes, this.ano);
/*    */     } catch (Exception e) {
/* 49 */       e.printStackTrace();
/* 50 */       setMsg("errorMessage", "Falha ao realizar consulta!");
/*    */     } finally {
/* 52 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void delete() throws Exception {
/*    */     try {
/* 58 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 59 */       csg_curva_s_geralDAO.delete(this.csg_curva_s_geralT);
/* 60 */       setMsg("Exclusao efetuada com sucesso!");
/* 61 */       this.csg_curva_s_geralT = new Csg_curva_s_geralT();
/* 62 */       consult();
/*    */     } catch (Exception e) {
/* 64 */       e.printStackTrace();
/* 65 */       setMsg("errorMessage", "Falha ao realizar exclusao!");
/*    */     } finally {
/* 67 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void insert() throws Exception
/*    */   {
/*    */     try {
/* 74 */       String page = "csg_curva_s_geralInsert.jsp";
/* 75 */       getResponse().sendRedirect(page);
/*    */     } catch (Exception localException) {}
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception {
/*    */     try {
/* 81 */       String page = "";
/* 82 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Csg_curva_s_geralConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */