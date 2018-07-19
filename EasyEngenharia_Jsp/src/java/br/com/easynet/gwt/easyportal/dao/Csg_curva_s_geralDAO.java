/*     */ package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Csg_curva_s_geralT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Csg_curva_s_geralDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Csg_curva_s_geralDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  12 */     setDAOFactory(dao);
/*  13 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception {
/*  17 */     PreparedStatement pStmt = null;
/*     */     try {
/*  19 */       String sql = "insert into bi.csg_curva_s_geral  ( obr_nr_id, csg_nr_mes, csg_nr_ano, csg_nr_mes_plan,  csg_nr_acumulado_plan_po, csg_nr_fisico_acumulado_panejado_base, csg_nr_fisico_acumulado_trab_atual, csg_nr_fisico_acumulado_trab_projetado, csg_nr_fisico_acumulado_atual_projetado) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
/*  20 */       pStmt = this.con.prepareStatement(sql);
/*  21 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getObr_nr_id()));
/*  22 */       pStmt.setObject(2, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_mes()));
/*  23 */       pStmt.setObject(3, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_ano()));
/*  24 */       java.sql.Date dt1 = new java.sql.Date(csg_curva_s_geralT.getCsg_nr_mes_plan().getTime());
/*  25 */       pStmt.setObject(4, dt1);
/*  26 */       pStmt.setObject(5, Float.valueOf(csg_curva_s_geralT.getCsg_nr_acumulado_plan_po()));
/*  27 */       pStmt.setObject(6, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_panejado_base()));
/*  28 */       pStmt.setObject(7, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_atual()));
/*  29 */       pStmt.setObject(8, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_projetado()));
/*  30 */       pStmt.setObject(9, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_atual_projetado()));
/*  31 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  33 */       throw e;
/*     */     } finally {
/*     */       try {
/*  36 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/*  44 */     PreparedStatement pStmt = null;
/*     */     try {
/*  46 */       String sql = "update bi.csg_curva_s_geral set  obr_nr_id=?, csg_nr_mes=?, csg_nr_ano=?, csg_nr_mes_plan=?, csg_nr_acumulado_plan_po=?, csg_nr_fisico_acumulado_panejado_base=?, csg_nr_fisico_acumulado_trab_atual=?, csg_nr_fisico_acumulado_trab_projetado=?, csg_nr_fisico_acumulado_atual_projetado=?  where  csg_nr_id=?";
/*  47 */       pStmt = this.con.prepareStatement(sql);
/*  48 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getObr_nr_id()));
/*  49 */       pStmt.setObject(2, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_mes()));
/*  50 */       pStmt.setObject(3, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_ano()));
/*  51 */       java.sql.Date dt1 = new java.sql.Date(csg_curva_s_geralT.getCsg_nr_mes_plan().getTime());
/*  52 */       pStmt.setObject(4, dt1);
/*     */       
/*  54 */       pStmt.setObject(5, Float.valueOf(csg_curva_s_geralT.getCsg_nr_acumulado_plan_po()));
/*  55 */       pStmt.setObject(6, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_panejado_base()));
/*  56 */       pStmt.setObject(7, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_atual()));
/*  57 */       pStmt.setObject(8, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_projetado()));
/*  58 */       pStmt.setObject(9, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_atual_projetado()));
/*  59 */       pStmt.setObject(10, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_id()));
/*  60 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  62 */       throw e;
/*     */     } finally {
/*     */       try {
/*  65 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/*  73 */     PreparedStatement pStmt = null;
/*     */     try {
/*  75 */       String sql = "delete from bi.csg_curva_s_geral where  csg_nr_id=?";
/*  76 */       pStmt = this.con.prepareStatement(sql);
/*  77 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_id()));
/*  78 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  80 */       throw e;
/*     */     } finally {
/*     */       try {
/*  83 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private List<Csg_curva_s_geralT> resultSetToObjectTransfer(ResultSet rs) throws Exception
/*     */   {
/*  91 */     List<Csg_curva_s_geralT> objs = new java.util.Vector();
/*  92 */     while (rs.next()) {
/*  93 */       Csg_curva_s_geralT csg_curva_s_geralT = new Csg_curva_s_geralT();
/*  94 */       csg_curva_s_geralT.setCsg_nr_id(rs.getInt("csg_nr_id"));
/*  95 */       csg_curva_s_geralT.setObr_nr_id(rs.getInt("obr_nr_id"));
/*  96 */       csg_curva_s_geralT.setCsg_nr_mes(rs.getInt("csg_nr_mes"));
/*  97 */       csg_curva_s_geralT.setCsg_nr_ano(rs.getInt("csg_nr_ano"));
/*  98 */       csg_curva_s_geralT.setCsg_nr_mes_plan(rs.getDate("csg_nr_mes_plan"));
/*  99 */       csg_curva_s_geralT.setCsg_nr_acumulado_plan_po(rs.getFloat("csg_nr_acumulado_plan_po"));
/* 100 */       csg_curva_s_geralT.setCsg_nr_fisico_acumulado_panejado_base(rs.getFloat("csg_nr_fisico_acumulado_panejado_base"));
/* 101 */       csg_curva_s_geralT.setCsg_nr_fisico_acumulado_trab_atual(rs.getFloat("csg_nr_fisico_acumulado_trab_atual"));
/* 102 */       csg_curva_s_geralT.setCsg_nr_fisico_acumulado_trab_projetado(rs.getFloat("csg_nr_fisico_acumulado_trab_projetado"));
/* 103 */       csg_curva_s_geralT.setCsg_nr_fisico_acumulado_atual_projetado(rs.getFloat("csg_nr_fisico_acumulado_atual_projetado"));
/* 104 */       objs.add(csg_curva_s_geralT);
/*     */     }
/* 106 */     return objs;
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getAll(int obr_nr_id, int mes, int ano) throws Exception {
/* 110 */     PreparedStatement pStmt = null;
/* 111 */     ResultSet rs = null;
/*     */     try {
/* 113 */       String filter = " where obr_nr_id > -1";
/* 114 */       if (obr_nr_id > 0) {
/* 115 */         filter = filter + " and obr_nr_id =" + obr_nr_id;
/*     */       }
/* 117 */       if (mes > 0) {
/* 118 */         filter = filter + " and csg_nr_mes =" + mes;
/*     */       }
/* 120 */       if (ano > 0) {
/* 121 */         filter = filter + " and csg_nr_ano =" + ano;
/*     */       }
/* 123 */       String sql = "select * from bi.csg_curva_s_geral " + filter;
/* 124 */       pStmt = this.con.prepareStatement(sql);
/* 125 */       rs = pStmt.executeQuery();
/* 126 */       List<Csg_curva_s_geralT> list = resultSetToObjectTransfer(rs);
/* 127 */       return list;
/*     */     } catch (Exception e) {
/* 129 */       throw e;
/*     */     } finally {
/*     */       try {
/* 132 */         rs.close();
/* 133 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByPK(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 141 */     PreparedStatement pStmt = null;
/* 142 */     ResultSet rs = null;
/*     */     try {
/* 144 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_id=?";
/* 145 */       pStmt = this.con.prepareStatement(sql);
/* 146 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_id()));
/* 147 */       rs = pStmt.executeQuery();
/* 148 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 150 */       throw e;
/*     */     } finally {
/*     */       try {
/* 153 */         rs.close();
/* 154 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_id(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 162 */     PreparedStatement pStmt = null;
/* 163 */     ResultSet rs = null;
/*     */     try {
/* 165 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_id = ? ";
/* 166 */       pStmt = this.con.prepareStatement(sql);
/* 167 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_id()));
/* 168 */       rs = pStmt.executeQuery();
/* 169 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 171 */       throw e;
/*     */     } finally {
/*     */       try {
/* 174 */         rs.close();
/* 175 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByEmp_nr_id(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 183 */     PreparedStatement pStmt = null;
/* 184 */     ResultSet rs = null;
/*     */     try {
/* 186 */       String sql = "select * from bi.csg_curva_s_geral where  emp_nr_id = ? ";
/* 187 */       pStmt = this.con.prepareStatement(sql);
/* 188 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getObr_nr_id()));
/* 189 */       rs = pStmt.executeQuery();
/* 190 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 192 */       throw e;
/*     */     } finally {
/*     */       try {
/* 195 */         rs.close();
/* 196 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_mes(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 204 */     PreparedStatement pStmt = null;
/* 205 */     ResultSet rs = null;
/*     */     try {
/* 207 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_mes = ? ";
/* 208 */       pStmt = this.con.prepareStatement(sql);
/* 209 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_mes()));
/* 210 */       rs = pStmt.executeQuery();
/* 211 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 213 */       throw e;
/*     */     } finally {
/*     */       try {
/* 216 */         rs.close();
/* 217 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_ano(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 225 */     PreparedStatement pStmt = null;
/* 226 */     ResultSet rs = null;
/*     */     try {
/* 228 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_ano = ? ";
/* 229 */       pStmt = this.con.prepareStatement(sql);
/* 230 */       pStmt.setObject(1, Integer.valueOf(csg_curva_s_geralT.getCsg_nr_ano()));
/* 231 */       rs = pStmt.executeQuery();
/* 232 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 234 */       throw e;
/*     */     } finally {
/*     */       try {
/* 237 */         rs.close();
/* 238 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_mes_plan(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 246 */     PreparedStatement pStmt = null;
/* 247 */     ResultSet rs = null;
/*     */     try {
/* 249 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_mes_plan = ? ";
/* 250 */       pStmt = this.con.prepareStatement(sql);
/* 251 */       pStmt.setObject(1, csg_curva_s_geralT.getCsg_nr_mes_plan());
/* 252 */       rs = pStmt.executeQuery();
/* 253 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 255 */       throw e;
/*     */     } finally {
/*     */       try {
/* 258 */         rs.close();
/* 259 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_acumulado_plan_po(Csg_curva_s_geralT csg_curva_s_geralT)
/*     */     throws Exception
/*     */   {
/* 269 */     PreparedStatement pStmt = null;
/* 270 */     ResultSet rs = null;
/*     */     try {
/* 272 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_acumulado_plan_po = ? ";
/* 273 */       pStmt = this.con.prepareStatement(sql);
/* 274 */       pStmt.setObject(1, Float.valueOf(csg_curva_s_geralT.getCsg_nr_acumulado_plan_po()));
/* 275 */       rs = pStmt.executeQuery();
/* 276 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 278 */       throw e;
/*     */     } finally {
/*     */       try {
/* 281 */         rs.close();
/* 282 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_fisico_acumulado_panejado_base(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 290 */     PreparedStatement pStmt = null;
/* 291 */     ResultSet rs = null;
/*     */     try {
/* 293 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_fisico_acumulado_panejado_base = ? ";
/* 294 */       pStmt = this.con.prepareStatement(sql);
/* 295 */       pStmt.setObject(1, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_panejado_base()));
/* 296 */       rs = pStmt.executeQuery();
/* 297 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 299 */       throw e;
/*     */     } finally {
/*     */       try {
/* 302 */         rs.close();
/* 303 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_fisico_acumulado_trab_atual(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 311 */     PreparedStatement pStmt = null;
/* 312 */     ResultSet rs = null;
/*     */     try {
/* 314 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_fisico_acumulado_trab_atual = ? ";
/* 315 */       pStmt = this.con.prepareStatement(sql);
/* 316 */       pStmt.setObject(1, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_atual()));
/* 317 */       rs = pStmt.executeQuery();
/* 318 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 320 */       throw e;
/*     */     } finally {
/*     */       try {
/* 323 */         rs.close();
/* 324 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_fisico_acumulado_trab_projetado(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 332 */     PreparedStatement pStmt = null;
/* 333 */     ResultSet rs = null;
/*     */     try {
/* 335 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_fisico_acumulado_trab_projetado = ? ";
/* 336 */       pStmt = this.con.prepareStatement(sql);
/* 337 */       pStmt.setObject(1, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_trab_projetado()));
/* 338 */       rs = pStmt.executeQuery();
/* 339 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 341 */       throw e;
/*     */     } finally {
/*     */       try {
/* 344 */         rs.close();
/* 345 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Csg_curva_s_geralT> getByCsg_nr_fisico_acumulado_atual_projetado(Csg_curva_s_geralT csg_curva_s_geralT) throws Exception
/*     */   {
/* 353 */     PreparedStatement pStmt = null;
/* 354 */     ResultSet rs = null;
/*     */     try {
/* 356 */       String sql = "select * from bi.csg_curva_s_geral where  csg_nr_fisico_acumulado_atual_projetado = ? ";
/* 357 */       pStmt = this.con.prepareStatement(sql);
/* 358 */       pStmt.setObject(1, Float.valueOf(csg_curva_s_geralT.getCsg_nr_fisico_acumulado_atual_projetado()));
/* 359 */       rs = pStmt.executeQuery();
/* 360 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 362 */       throw e;
/*     */     } finally {
/*     */       try {
/* 365 */         rs.close();
/* 366 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/dao/Csg_curva_s_geralDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */