/*    */ package br.com.easynet.gwt.easyportal.jb;
/*    */ 
/*    */ import br.com.easynet.easyportal.jb.INotSecurity;
/*    */ import br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO;
/*    */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Inp_indicador_planejamentoConsultJB
/*    */   extends SystemBase
/*    */   implements INotSecurity
/*    */ {
/* 17 */   private Inp_indicador_planejamentoT inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*    */   private List<Inp_indicador_planejamentoT> list;
/*    */   
/* 20 */   public void setInp_indicador_planejamentoT(Inp_indicador_planejamentoT inp_indicador_planejamentoT) { this.inp_indicador_planejamentoT = inp_indicador_planejamentoT; }
/*    */   
/*    */   public Inp_indicador_planejamentoT getInp_indicador_planejamentoT()
/*    */   {
/* 24 */     return this.inp_indicador_planejamentoT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Inp_indicador_planejamentoT> getList()
/*    */   {
/* 32 */     return this.list;
/*    */   }
/*    */   
/*    */   public void setList(List<Inp_indicador_planejamentoT> list) {
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
/* 46 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 47 */       this.list = inp_indicador_planejamentoDAO.getAll(this.obr_nr_id, this.mes, this.ano);
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
/* 58 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 59 */       inp_indicador_planejamentoDAO.delete(this.inp_indicador_planejamentoT);
/* 60 */       setMsg("Exclusao efetuada com sucesso!");
/* 61 */       this.inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
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
/* 74 */       String page = "inp_indicador_planejamentoInsert.jsp";
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


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Inp_indicador_planejamentoConsultJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */