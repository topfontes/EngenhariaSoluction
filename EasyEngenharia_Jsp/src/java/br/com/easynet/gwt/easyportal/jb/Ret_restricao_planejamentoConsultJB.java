/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ret_restricao_planejamentoConsultJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Ret_restricao_planejamentoT ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*    */   private List<Ret_restricao_planejamentoT> list;
/*    */   
/* 20 */   public void setRet_restricao_planejamentoT(Ret_restricao_planejamentoT ret_restricao_planejamentoT) { this.ret_restricao_planejamentoT = ret_restricao_planejamentoT; }
/*    */   
/*    */   public Ret_restricao_planejamentoT getRet_restricao_planejamentoT()
/*    */   {
/* 24 */     return this.ret_restricao_planejamentoT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Ret_restricao_planejamentoT> getList()
/*    */   {
/* 32 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Ret_restricao_planejamentoT> list) {
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
/* 46 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 47 */       this.list = ret_restricao_planejamentoDAO.getAll(this.obr_nr_id, this.mes, this.ano);
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
/* 58 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 59 */       ret_restricao_planejamentoDAO.delete(this.ret_restricao_planejamentoT);
/* 60 */       setMsg("Exclusao efetuada com sucesso!");
/* 61 */       this.ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
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
/* 74 */       String page = "ret_restricao_planejamentoInsert.jsp";
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


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Ret_restricao_planejamentoConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */