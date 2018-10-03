/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Inp_indicador_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Inp_indicador_planejamentoBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Inp_indicador_planejamentoT inp_indicador_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  26 */       inp_indicador_planejamentoDAO.insert(inp_indicador_planejamentoT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  45 */       return inp_indicador_planejamentoDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Inp_indicador_planejamentoT inp_indicador_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO;
/*  64 */       if (exist(inp_indicador_planejamentoT)) {
/*  65 */         inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  66 */         inp_indicador_planejamentoDAO.delete(inp_indicador_planejamentoT);
/*  67 */         return true;
/*     */       }
/*  69 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  73 */       throw e;
/*     */     } finally {
/*  75 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean exist(Inp_indicador_planejamentoT inp_indicador_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/*  86 */       List<Inp_indicador_planejamentoT> listTemp = inp_indicador_planejamentoDAO.getByPK(inp_indicador_planejamentoT);
/*     */       
/*  88 */       return listTemp.size() > 0;
/*     */     }
/*     */     catch (Exception e) {
/*  91 */       throw e;
/*     */     } finally {
/*  93 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update(Inp_indicador_planejamentoT inp_indicador_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO;
/* 107 */       if (exist(inp_indicador_planejamentoT)) {
/* 108 */         inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 109 */         inp_indicador_planejamentoDAO.update(inp_indicador_planejamentoT);
/* 110 */         return true;
/*     */       }
/* 112 */       return false;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 116 */       throw e;
/*     */     } finally {
/* 118 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public Inp_indicador_planejamentoT findbyid(Inp_indicador_planejamentoT inp_indicador_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Inp_indicador_planejamentoDAO inp_indicador_planejamentoDAO = getInp_indicador_planejamentoDAO();
/* 128 */       List<Inp_indicador_planejamentoT> listTemp = inp_indicador_planejamentoDAO.getByPK(inp_indicador_planejamentoT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Inp_indicador_planejamentoT)listTemp.get(0) : new Inp_indicador_planejamentoT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Inp_indicador_planejamentoBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */