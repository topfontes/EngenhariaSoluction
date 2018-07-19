/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Csg_curva_s_geralDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Csg_curva_s_geralBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  26 */       csg_curva_s_geralDAO.insert(csg_curva_s_geralT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  45 */       return csg_curva_s_geralDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Csg_curva_s_geralDAO csg_curva_s_geralDAO;
/*  64 */       if (exist(csg_curva_s_geralT)) {
/*  65 */         csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  66 */         csg_curva_s_geralDAO.delete(csg_curva_s_geralT);
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
/*     */   public boolean exist(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/*  86 */       List<Csg_curva_s_geralT> listTemp = csg_curva_s_geralDAO.getByPK(csg_curva_s_geralT);
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
/*     */   public boolean update(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Csg_curva_s_geralDAO csg_curva_s_geralDAO;
/* 107 */       if (exist(csg_curva_s_geralT)) {
/* 108 */         csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 109 */         csg_curva_s_geralDAO.update(csg_curva_s_geralT);
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
/*     */   public Csg_curva_s_geralT findbyid(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Csg_curva_s_geralDAO csg_curva_s_geralDAO = getCsg_curva_s_geralDAO();
/* 128 */       List<Csg_curva_s_geralT> listTemp = csg_curva_s_geralDAO.getByPK(csg_curva_s_geralT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Csg_curva_s_geralT)listTemp.get(0) : new Csg_curva_s_geralT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Csg_curva_s_geralBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */