/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rep_resumo_planejamentoConsultJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Rep_resumo_planejamentoT rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
/*    */   private List<Rep_resumo_planejamentoT> list;
/*    */   
/* 20 */   public void setRep_resumo_planejamentoT(Rep_resumo_planejamentoT rep_resumo_planejamentoT) { this.rep_resumo_planejamentoT = rep_resumo_planejamentoT; }
/*    */   
/*    */   public Rep_resumo_planejamentoT getRep_resumo_planejamentoT()
/*    */   {
/* 24 */     return this.rep_resumo_planejamentoT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Rep_resumo_planejamentoT> getList()
/*    */   {
/* 32 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Rep_resumo_planejamentoT> list) {
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
/* 46 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 47 */       this.list = rep_resumo_planejamentoDAO.getAll(this.obr_nr_id, this.mes, this.ano);
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
/* 58 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 59 */       rep_resumo_planejamentoDAO.delete(this.rep_resumo_planejamentoT);
/* 60 */       setMsg("Exclusao efetuada com sucesso!");
/* 61 */       this.rep_resumo_planejamentoT = new Rep_resumo_planejamentoT();
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
/* 74 */       String page = "rep_resumo_planejamentoInsert.jsp";
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


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Rep_resumo_planejamentoConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */