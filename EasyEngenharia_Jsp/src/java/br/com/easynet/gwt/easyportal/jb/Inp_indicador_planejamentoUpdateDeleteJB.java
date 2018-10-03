/*     */ package br.com.easynet.gwt.easyportal.jb;
/*     */ 
/*     */ import br.com.easynet.easyportal.jb.INotSecurity;
/*     */ import br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Inp_indicador_planejamentoUpdateDeleteJB
/*     */   extends SystemBase
/*     */   implements INotSecurity
/*     */ {
/*  18 */   private Inp_indicador_planejamentoT inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*     */   private List<Inp_indicador_planejamentoT> list;
/*     */   
/*  21 */   public void setInp_indicador_planejamentoT(Inp_indicador_planejamentoT inp_indicador_planejamentoT) { this.inp_indicador_planejamentoT = inp_indicador_planejamentoT; }
/*     */   
/*     */   public Inp_indicador_planejamentoT getInp_indicador_planejamentoT()
/*     */   {
/*  25 */     return this.inp_indicador_planejamentoT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Inp_indicador_planejamentoT> getList()
/*     */   {
/*  32 */     return this.list;
/*     */   }
/*     */   
/*     */   public void setList(List<Inp_indicador_planejamentoT> list) {
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
/*  46 */     this.inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*     */   }
/*     */   
/*     */   public void delete() throws Exception {
/*     */     try {
/*  51 */       if (exist()) {
/*  52 */         Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  53 */         inp_indicador_planejamentoDAO.delete(this.inp_indicador_planejamentoT);
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
/*  68 */     try { Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  69 */       List<Inp_indicador_planejamentoT> listTemp = inp_indicador_planejamentoDAO.getByPK(this.inp_indicador_planejamentoT);
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
/*  85 */         Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  86 */         inp_indicador_planejamentoDAO.update(this.inp_indicador_planejamentoT);
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
/* 109 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 110 */       List<Inp_indicador_planejamentoT> listTemp = inp_indicador_planejamentoDAO.getByPK(this.inp_indicador_planejamentoT);
/*     */       
/* 112 */       this.inp_indicador_planejamentoT = (listTemp.size() > 0 ? (Inp_indicador_planejamentoT)listTemp.get(0) : new Inp_indicador_planejamentoT());
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
/* 128 */       String page = "inp_indicador_planejamentoConsult.jsp";
/* 129 */       getResponse().sendRedirect(page);
/*     */     } catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   public void cancel() throws Exception {
/*     */     try {
/* 135 */       String page = "inp_indicador_planejamentoConsult.jsp";
/* 136 */       getResponse().sendRedirect(page);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/jb/Inp_indicador_planejamentoUpdateDeleteJB.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */