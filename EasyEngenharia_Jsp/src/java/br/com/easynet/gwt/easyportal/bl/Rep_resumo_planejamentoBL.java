/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Rep_resumo_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Rep_resumo_planejamentoT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rep_resumo_planejamentoBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Rep_resumo_planejamentoT rep_resumo_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  26 */       rep_resumo_planejamentoDAO.insert(rep_resumo_planejamentoT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Rep_resumo_planejamentoT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  45 */       return rep_resumo_planejamentoDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Rep_resumo_planejamentoT rep_resumo_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO;
/*  64 */       if (exist(rep_resumo_planejamentoT)) {
/*  65 */         rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  66 */         rep_resumo_planejamentoDAO.delete(rep_resumo_planejamentoT);
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
/*     */   public boolean exist(Rep_resumo_planejamentoT rep_resumo_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/*  86 */       List<Rep_resumo_planejamentoT> listTemp = rep_resumo_planejamentoDAO.getByPK(rep_resumo_planejamentoT);
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
/*     */   public boolean update(Rep_resumo_planejamentoT rep_resumo_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO;
/* 107 */       if (exist(rep_resumo_planejamentoT)) {
/* 108 */         rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 109 */         rep_resumo_planejamentoDAO.update(rep_resumo_planejamentoT);
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
/*     */   public Rep_resumo_planejamentoT findbyid(Rep_resumo_planejamentoT rep_resumo_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Rep_resumo_planejamentoDAO rep_resumo_planejamentoDAO = getRep_resumo_planejamentoDAO();
/* 128 */       List<Rep_resumo_planejamentoT> listTemp = rep_resumo_planejamentoDAO.getByPK(rep_resumo_planejamentoT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Rep_resumo_planejamentoT)listTemp.get(0) : new Rep_resumo_planejamentoT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Rep_resumo_planejamentoBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */