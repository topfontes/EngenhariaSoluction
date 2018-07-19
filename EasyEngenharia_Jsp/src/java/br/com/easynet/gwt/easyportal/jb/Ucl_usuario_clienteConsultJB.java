package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.gwt.easyportal.dao.Ucl_usuario_clienteDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Ucl_usuario_clienteT;
/*    */ import br.com.easynet.gwt.easyportal.jb.SystemBase;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ucl_usuario_clienteConsultJB
/*    */   extends SystemBase
/*    */ {
/* 16 */   private Ucl_usuario_clienteT ucl_usuario_clienteT = new Ucl_usuario_clienteT();
/*    */   private List<Ucl_usuario_clienteT> list;
/*    */   
/* 19 */   public void setUcl_usuario_clienteT(Ucl_usuario_clienteT ucl_usuario_clienteT) { this.ucl_usuario_clienteT = ucl_usuario_clienteT; }
/*    */   
/*    */   public Ucl_usuario_clienteT getUcl_usuario_clienteT()
/*    */   {
/* 23 */     return this.ucl_usuario_clienteT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Ucl_usuario_clienteT> getList()
/*    */   {
/* 31 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Ucl_usuario_clienteT> list) {
/* 35 */     this.list = list;
/*    */   }
/*    */   
/*    */   public void pageLoad() throws Exception {
/* 39 */     super.pageLoad();
/* 40 */     consult();
/*    */   }
/*    */   
/*    */   public void consult() throws Exception {
/*    */     try {
/* 45 */       Ucl_usuario_clienteDAO ucl_usuario_clienteDAO = getUcl_usuario_clienteDAO();
/* 46 */       this.list = ucl_usuario_clienteDAO.getAll();
/*    */     } catch (Exception e) {
/* 48 */       e.printStackTrace();
/* 49 */       setMsg("errorMessage", "Falha ao realizar consulta!");
/*    */     } finally {
/* 51 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void delete() throws Exception {
/*    */     try {
/* 57 */       Ucl_usuario_clienteDAO ucl_usuario_clienteDAO = getUcl_usuario_clienteDAO();
/* 58 */       ucl_usuario_clienteDAO.delete(this.ucl_usuario_clienteT);
/* 59 */       setMsg("Exclusao efetuada com sucesso!");
/* 60 */       this.ucl_usuario_clienteT = new Ucl_usuario_clienteT();
/* 61 */       consult();
/*    */     } catch (Exception e) {
/* 63 */       e.printStackTrace();
/* 64 */       setMsg("errorMessage", "Falha ao realizar exclusao!");
/*    */     } finally {
/* 66 */       close();
/*    */     }
/*    */   }
/*    */   
/*    */   public void insert() throws Exception
/*    */   {
/*    */     try {
/* 73 */       String page = "ucl_usuario_clienteInsert.jsp";
/* 74 */       getResponse().sendRedirect(page);
/*    */     } catch (Exception localException) {}
/*    */   }
/*    */   
/*    */   public void cancel() throws Exception {
/*    */     try {
/* 80 */       String page = "";
/* 81 */       getResponse().sendRedirect(page);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/easyportal/jb/Ucl_usuario_clienteConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */