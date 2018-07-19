/*     */ package br.com.easynet.gwt.easyportal.bl;
/*     */ 
/*     */ import br.com.easynet.bl.BusinessException;
/*     */ import br.com.easynet.gwt.easyportal.dao.Idc_indice_custoDAO;
/*     */ import br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Idc_indice_custoBL
/*     */   extends SystemBusinessBase
/*     */ {
/*     */   public boolean insert(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  22 */       if (!valide("insert")) {
/*  23 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  25 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  26 */       idc_indice_custoDAO.insert(idc_indice_custoT);
/*  27 */       return true;
/*     */     }
/*     */     catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*  32 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> consult()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  41 */       if (!valide("consult")) {
/*  42 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*  44 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  45 */       return idc_indice_custoDAO.getAll(0, 0, 0);
/*     */     }
/*     */     catch (Exception e) {
/*  48 */       throw e;
/*     */     } finally {
/*  50 */       close();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean delete(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  60 */       if (!valide("delete")) {
/*  61 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Idc_indice_custoDAO idc_indice_custoDAO;
/*  64 */       if (exist(idc_indice_custoT)) {
/*  65 */         idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  66 */         idc_indice_custoDAO.delete(idc_indice_custoT);
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
/*     */   public boolean exist(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  85 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/*  86 */       List<Idc_indice_custoT> listTemp = idc_indice_custoDAO.getByPK(idc_indice_custoT);
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
/*     */   public boolean update(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 103 */       if (!valide("update")) {
/* 104 */         throw new BusinessException("Falha na seguranca !");
/*     */       }
/*     */       Idc_indice_custoDAO idc_indice_custoDAO;
/* 107 */       if (exist(idc_indice_custoT)) {
/* 108 */         idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 109 */         idc_indice_custoDAO.update(idc_indice_custoT);
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
/*     */   public Idc_indice_custoT findbyid(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/* 127 */       Idc_indice_custoDAO idc_indice_custoDAO = getIdc_indice_custoDAO();
/* 128 */       List<Idc_indice_custoT> listTemp = idc_indice_custoDAO.getByPK(idc_indice_custoT);
/*     */       
/* 130 */       return listTemp.size() > 0 ? (Idc_indice_custoT)listTemp.get(0) : new Idc_indice_custoT();
/*     */     }
/*     */     catch (Exception e) {
/* 133 */       throw e;
/*     */     } finally {
/* 135 */       close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/bl/Idc_indice_custoBL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */