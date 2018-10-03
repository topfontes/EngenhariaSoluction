/*     */ package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Inp_indicador_planejamentoT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Inp_indicador_planejamentoDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Inp_indicador_planejamentoDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  12 */     setDAOFactory(dao);
/*  13 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception {
/*  17 */     PreparedStatement pStmt = null;
/*     */     try {
/*  19 */       String sql = "insert into bi.inp_indicador_planejamento  ( obr_nr_id, inp_nr_mes, inp_nr_ano, inp_numero_fun_prev_mdo_direta, inp_numero_fun_real_mdo_direta, inp_nr_nemro_fun_eqv_mdo_direta, inp_nr_perc_eficiencia_mdo_direta, inp_nr_ppp, inp_nr_ppc) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
/*  20 */       pStmt = this.con.prepareStatement(sql);
/*  21 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getObr_nr_id()));
/*  22 */       pStmt.setObject(2, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_mes()));
/*  23 */       pStmt.setObject(3, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_ano()));
/*  24 */       pStmt.setObject(4, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_prev_mdo_direta()));
/*  25 */       pStmt.setObject(5, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_real_mdo_direta()));
/*  26 */       pStmt.setObject(6, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_nemro_fun_eqv_mdo_direta()));
/*  27 */       pStmt.setObject(7, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_perc_eficiencia_mdo_direta()));
/*  28 */       pStmt.setObject(8, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppp()));
/*  29 */       pStmt.setObject(9, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppc()));
/*  30 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  32 */       throw e;
/*     */     } finally {
/*     */       try {
/*  35 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/*  43 */     PreparedStatement pStmt = null;
/*     */     try {
/*  45 */       String sql = "update bi.inp_indicador_planejamento set  obr_nr_id=?, inp_nr_mes=?, inp_nr_ano=?, inp_numero_fun_prev_mdo_direta=?, inp_numero_fun_real_mdo_direta=?, inp_nr_nemro_fun_eqv_mdo_direta=?, inp_nr_perc_eficiencia_mdo_direta=?, inp_nr_ppp=?, inp_nr_ppc=?  where  inp_nr_id=?";
/*  46 */       pStmt = this.con.prepareStatement(sql);
/*  47 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getObr_nr_id()));
/*  48 */       pStmt.setObject(2, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_mes()));
/*  49 */       pStmt.setObject(3, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_ano()));
/*  50 */       pStmt.setObject(4, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_prev_mdo_direta()));
/*  51 */       pStmt.setObject(5, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_real_mdo_direta()));
/*  52 */       pStmt.setObject(6, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_nemro_fun_eqv_mdo_direta()));
/*  53 */       pStmt.setObject(7, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_perc_eficiencia_mdo_direta()));
/*  54 */       pStmt.setObject(8, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppp()));
/*  55 */       pStmt.setObject(9, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppc()));
/*  56 */       pStmt.setObject(10, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_id()));
/*  57 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  59 */       throw e;
/*     */     } finally {
/*     */       try {
/*  62 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/*  70 */     PreparedStatement pStmt = null;
/*     */     try {
/*  72 */       String sql = "delete from bi.inp_indicador_planejamento where  inp_nr_id=?";
/*  73 */       pStmt = this.con.prepareStatement(sql);
/*  74 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_id()));
/*  75 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  77 */       throw e;
/*     */     } finally {
/*     */       try {
/*  80 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private List<Inp_indicador_planejamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception
/*     */   {
/*  88 */     List<Inp_indicador_planejamentoT> objs = new java.util.Vector();
/*  89 */     while (rs.next()) {
/*  90 */       Inp_indicador_planejamentoT inp_indicador_planejamentoT = new Inp_indicador_planejamentoT();
/*  91 */       inp_indicador_planejamentoT.setInp_nr_id(rs.getInt("inp_nr_id"));
/*  92 */       inp_indicador_planejamentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
/*  93 */       inp_indicador_planejamentoT.setInp_nr_mes(rs.getInt("inp_nr_mes"));
/*  94 */       inp_indicador_planejamentoT.setInp_nr_ano(rs.getInt("inp_nr_ano"));
/*  95 */       inp_indicador_planejamentoT.setInp_numero_fun_prev_mdo_direta(rs.getInt("inp_numero_fun_prev_mdo_direta"));
/*  96 */       inp_indicador_planejamentoT.setInp_numero_fun_real_mdo_direta(rs.getInt("inp_numero_fun_real_mdo_direta"));
/*  97 */       inp_indicador_planejamentoT.setInp_nr_nemro_fun_eqv_mdo_direta(rs.getInt("inp_nr_nemro_fun_eqv_mdo_direta"));
/*  98 */       inp_indicador_planejamentoT.setInp_nr_perc_eficiencia_mdo_direta(rs.getFloat("inp_nr_perc_eficiencia_mdo_direta"));
/*  99 */       inp_indicador_planejamentoT.setInp_nr_ppp(rs.getFloat("inp_nr_ppp"));
/* 100 */       inp_indicador_planejamentoT.setInp_nr_ppc(rs.getFloat("inp_nr_ppc"));
/* 101 */       objs.add(inp_indicador_planejamentoT);
/*     */     }
/* 103 */     return objs;
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getAll(int obr_nr_id, int mes, int ano) throws Exception {
/* 107 */     PreparedStatement pStmt = null;
/* 108 */     ResultSet rs = null;
/*     */     try {
/* 110 */       String filter = " where obr_nr_id > -1";
/* 111 */       if (obr_nr_id > 0) {
/* 112 */         filter = filter + " and obr_nr_id =" + obr_nr_id;
/*     */       }
/* 114 */       if (mes > 0) {
/* 115 */         filter = filter + " and inp_nr_mes =" + mes;
/*     */       }
/* 117 */       if (ano > 0) {
/* 118 */         filter = filter + " and inp_nr_ano =" + ano;
/*     */       }
/* 120 */       String sql = "select * from bi.inp_indicador_planejamento " + filter;
/* 121 */       pStmt = this.con.prepareStatement(sql);
/* 122 */       rs = pStmt.executeQuery();
/* 123 */       List<Inp_indicador_planejamentoT> list = resultSetToObjectTransfer(rs);
/* 124 */       return list;
/*     */     } catch (Exception e) {
/* 126 */       throw e;
/*     */     } finally {
/*     */       try {
/* 129 */         rs.close();
/* 130 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByPK(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 138 */     PreparedStatement pStmt = null;
/* 139 */     ResultSet rs = null;
/*     */     try {
/* 141 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_id=?";
/* 142 */       pStmt = this.con.prepareStatement(sql);
/* 143 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_id()));
/* 144 */       rs = pStmt.executeQuery();
/* 145 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 147 */       throw e;
/*     */     } finally {
/*     */       try {
/* 150 */         rs.close();
/* 151 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_id(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 159 */     PreparedStatement pStmt = null;
/* 160 */     ResultSet rs = null;
/*     */     try {
/* 162 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_id = ? ";
/* 163 */       pStmt = this.con.prepareStatement(sql);
/* 164 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_id()));
/* 165 */       rs = pStmt.executeQuery();
/* 166 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 168 */       throw e;
/*     */     } finally {
/*     */       try {
/* 171 */         rs.close();
/* 172 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByEmp_nr_id(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 180 */     PreparedStatement pStmt = null;
/* 181 */     ResultSet rs = null;
/*     */     try {
/* 183 */       String sql = "select * from bi.inp_indicador_planejamento where  obr_nr_id = ? ";
/* 184 */       pStmt = this.con.prepareStatement(sql);
/* 185 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getObr_nr_id()));
/* 186 */       rs = pStmt.executeQuery();
/* 187 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 189 */       throw e;
/*     */     } finally {
/*     */       try {
/* 192 */         rs.close();
/* 193 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_mes(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 201 */     PreparedStatement pStmt = null;
/* 202 */     ResultSet rs = null;
/*     */     try {
/* 204 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_mes = ? ";
/* 205 */       pStmt = this.con.prepareStatement(sql);
/* 206 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_mes()));
/* 207 */       rs = pStmt.executeQuery();
/* 208 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 210 */       throw e;
/*     */     } finally {
/*     */       try {
/* 213 */         rs.close();
/* 214 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_ano(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 222 */     PreparedStatement pStmt = null;
/* 223 */     ResultSet rs = null;
/*     */     try {
/* 225 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_ano = ? ";
/* 226 */       pStmt = this.con.prepareStatement(sql);
/* 227 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_ano()));
/* 228 */       rs = pStmt.executeQuery();
/* 229 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 231 */       throw e;
/*     */     } finally {
/*     */       try {
/* 234 */         rs.close();
/* 235 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_numero_fun_prev_mdo_direta(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 243 */     PreparedStatement pStmt = null;
/* 244 */     ResultSet rs = null;
/*     */     try {
/* 246 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_numero_fun_prev_mdo_direta = ? ";
/* 247 */       pStmt = this.con.prepareStatement(sql);
/* 248 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_prev_mdo_direta()));
/* 249 */       rs = pStmt.executeQuery();
/* 250 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 252 */       throw e;
/*     */     } finally {
/*     */       try {
/* 255 */         rs.close();
/* 256 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_numero_fun_real_mdo_direta(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 264 */     PreparedStatement pStmt = null;
/* 265 */     ResultSet rs = null;
/*     */     try {
/* 267 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_numero_fun_real_mdo_direta = ? ";
/* 268 */       pStmt = this.con.prepareStatement(sql);
/* 269 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_numero_fun_real_mdo_direta()));
/* 270 */       rs = pStmt.executeQuery();
/* 271 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 273 */       throw e;
/*     */     } finally {
/*     */       try {
/* 276 */         rs.close();
/* 277 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_nemro_fun_eqv_mdo_direta(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 285 */     PreparedStatement pStmt = null;
/* 286 */     ResultSet rs = null;
/*     */     try {
/* 288 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_nemro_fun_eqv_mdo_direta = ? ";
/* 289 */       pStmt = this.con.prepareStatement(sql);
/* 290 */       pStmt.setObject(1, Integer.valueOf(inp_indicador_planejamentoT.getInp_nr_nemro_fun_eqv_mdo_direta()));
/* 291 */       rs = pStmt.executeQuery();
/* 292 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 294 */       throw e;
/*     */     } finally {
/*     */       try {
/* 297 */         rs.close();
/* 298 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_perc_eficiencia_mdo_direta(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 306 */     PreparedStatement pStmt = null;
/* 307 */     ResultSet rs = null;
/*     */     try {
/* 309 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_perc_eficiencia_mdo_direta = ? ";
/* 310 */       pStmt = this.con.prepareStatement(sql);
/* 311 */       pStmt.setObject(1, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_perc_eficiencia_mdo_direta()));
/* 312 */       rs = pStmt.executeQuery();
/* 313 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 315 */       throw e;
/*     */     } finally {
/*     */       try {
/* 318 */         rs.close();
/* 319 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_ppp(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 327 */     PreparedStatement pStmt = null;
/* 328 */     ResultSet rs = null;
/*     */     try {
/* 330 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_ppp = ? ";
/* 331 */       pStmt = this.con.prepareStatement(sql);
/* 332 */       pStmt.setObject(1, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppp()));
/* 333 */       rs = pStmt.executeQuery();
/* 334 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 336 */       throw e;
/*     */     } finally {
/*     */       try {
/* 339 */         rs.close();
/* 340 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Inp_indicador_planejamentoT> getByInp_nr_ppc(Inp_indicador_planejamentoT inp_indicador_planejamentoT) throws Exception
/*     */   {
/* 348 */     PreparedStatement pStmt = null;
/* 349 */     ResultSet rs = null;
/*     */     try {
/* 351 */       String sql = "select * from bi.inp_indicador_planejamento where  inp_nr_ppc = ? ";
/* 352 */       pStmt = this.con.prepareStatement(sql);
/* 353 */       pStmt.setObject(1, Float.valueOf(inp_indicador_planejamentoT.getInp_nr_ppc()));
/* 354 */       rs = pStmt.executeQuery();
/* 355 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 357 */       throw e;
/*     */     } finally {
/*     */       try {
/* 360 */         rs.close();
/* 361 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/dao/Inp_indicador_planejamentoDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */