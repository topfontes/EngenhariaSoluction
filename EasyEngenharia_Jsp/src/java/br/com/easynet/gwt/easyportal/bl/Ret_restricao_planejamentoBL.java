/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Ret_restricao_planejamentoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Ret_restricao_planejamentoBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Ret_restricao_planejamentoT ret_restricao_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  26 */       ret_restricao_planejamentoDAO.insert(ret_restricao_planejamentoT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  45 */       return ret_restricao_planejamentoDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Ret_restricao_planejamentoT ret_restricao_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO;
/*  64 */       if (exist(ret_restricao_planejamentoT)) {
/*  65 */         ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  66 */         ret_restricao_planejamentoDAO.delete(ret_restricao_planejamentoT);
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
/*     */   public boolean exist(Ret_restricao_planejamentoT ret_restricao_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/*  86 */       List<Ret_restricao_planejamentoT> listTemp = ret_restricao_planejamentoDAO.getByPK(ret_restricao_planejamentoT);
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
/*     */   public boolean update(Ret_restricao_planejamentoT ret_restricao_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO;
/* 107 */       if (exist(ret_restricao_planejamentoT)) {
/* 108 */         ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 109 */         ret_restricao_planejamentoDAO.update(ret_restricao_planejamentoT);
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
/*     */   public Ret_restricao_planejamentoT findbyid(Ret_restricao_planejamentoT ret_restricao_planejamentoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Ret_restricao_planejamentoDAO ret_restricao_planejamentoDAO = getRet_restricao_planejamentoDAO();
/* 128 */       List<Ret_restricao_planejamentoT> listTemp = ret_restricao_planejamentoDAO.getByPK(ret_restricao_planejamentoT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Ret_restricao_planejamentoT)listTemp.get(0) : new Ret_restricao_planejamentoT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Ret_restricao_planejamentoBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */