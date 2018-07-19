/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Com_comenrcialDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Com_comenrcialBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Com_comenrcialT com_comenrcialT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  26 */       com_comenrcialDAO.insert(com_comenrcialT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  45 */       return com_comenrcialDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Com_comenrcialT com_comenrcialT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Com_comenrcialDAO com_comenrcialDAO;
/*  64 */       if (exist(com_comenrcialT)) {
/*  65 */         com_comenrcialDAO = getCom_comenrcialDAO();
/*  66 */         com_comenrcialDAO.delete(com_comenrcialT);
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
/*     */   public boolean exist(Com_comenrcialT com_comenrcialT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/*  86 */       List<Com_comenrcialT> listTemp = com_comenrcialDAO.getByPK(com_comenrcialT);
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
/*     */   public boolean update(Com_comenrcialT com_comenrcialT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Com_comenrcialDAO com_comenrcialDAO;
/* 107 */       if (exist(com_comenrcialT)) {
/* 108 */         com_comenrcialDAO = getCom_comenrcialDAO();
/* 109 */         com_comenrcialDAO.update(com_comenrcialT);
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
/*     */   public Com_comenrcialT findbyid(Com_comenrcialT com_comenrcialT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Com_comenrcialDAO com_comenrcialDAO = getCom_comenrcialDAO();
/* 128 */       List<Com_comenrcialT> listTemp = com_comenrcialDAO.getByPK(com_comenrcialT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Com_comenrcialT)listTemp.get(0) : new Com_comenrcialT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Com_comenrcialBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */