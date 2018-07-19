/*     */ package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Com_comenrcialT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Com_comenrcialDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Com_comenrcialDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  12 */     setDAOFactory(dao);
/*  13 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Com_comenrcialT com_comenrcialT) throws Exception {
/*  17 */     PreparedStatement pStmt = null;
/*     */     try {
/*  19 */       String sql = "insert into bi.com_comenrcial  ( obr_nr_id, com_nr_mes, com_nr_ano, com_nr_unidade_med_acum, com_nr_preco_medio_und_vendida, com_nr_unidade_a_vender, com_nr_preco_medio_unid_a_vender, com_nr_recebimento_acumulado_pj, com_nr_recebimento_acumulado_pf, com_nr_recebimento_acumulado_poupanca, com_nr_recebimento_acumulado_aporte, com_nr_inadimplencia, com_nr_vgv_atualizado, com_nr_vgv_original, com_nr_recebimento_total) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
/*  20 */       pStmt = this.con.prepareStatement(sql);
/*  21 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getObr_nr_id()));
/*  22 */       pStmt.setObject(2, Integer.valueOf(com_comenrcialT.getCom_nr_mes()));
/*  23 */       pStmt.setObject(3, Integer.valueOf(com_comenrcialT.getCom_nr_ano()));
/*  24 */       pStmt.setObject(4, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_med_acum()));
/*  25 */       pStmt.setObject(5, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_und_vendida()));
/*  26 */       pStmt.setObject(6, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_a_vender()));
/*  27 */       pStmt.setObject(7, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_unid_a_vender()));
/*  28 */       pStmt.setObject(8, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pj()));
/*  29 */       pStmt.setObject(9, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pf()));
/*  30 */       pStmt.setObject(10, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_poupanca()));
/*  31 */       pStmt.setObject(11, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_aporte()));
/*  32 */       pStmt.setObject(12, Float.valueOf(com_comenrcialT.getCom_nr_inadimplencia()));
/*  33 */       pStmt.setObject(13, Float.valueOf(com_comenrcialT.getCom_nr_vgv_atualizado()));
/*  34 */       pStmt.setObject(14, Float.valueOf(com_comenrcialT.getCom_nr_vgv_original()));
/*  35 */       pStmt.setObject(15, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_total()));
/*  36 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  38 */       throw e;
/*     */     } finally {
/*     */       try {
/*  41 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/*  49 */     PreparedStatement pStmt = null;
/*     */     try {
/*  51 */       String sql = "update bi.com_comenrcial set  obr_nr_id=?, com_nr_mes=?, com_nr_ano=?, com_nr_unidade_med_acum=?, com_nr_preco_medio_und_vendida=?, com_nr_unidade_a_vender=?, com_nr_preco_medio_unid_a_vender=?, com_nr_recebimento_acumulado_pj=?, com_nr_recebimento_acumulado_pf=?, com_nr_recebimento_acumulado_poupanca=?, com_nr_recebimento_acumulado_aporte=?, com_nr_inadimplencia=?, com_nr_vgv_atualizado=?, com_nr_vgv_original=?, com_nr_recebimento_total=?  where  com_nr_id=?";
/*  52 */       pStmt = this.con.prepareStatement(sql);
/*  53 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getObr_nr_id()));
/*  54 */       pStmt.setObject(2, Integer.valueOf(com_comenrcialT.getCom_nr_mes()));
/*  55 */       pStmt.setObject(3, Integer.valueOf(com_comenrcialT.getCom_nr_ano()));
/*  56 */       pStmt.setObject(4, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_med_acum()));
/*  57 */       pStmt.setObject(5, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_und_vendida()));
/*  58 */       pStmt.setObject(6, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_a_vender()));
/*  59 */       pStmt.setObject(7, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_unid_a_vender()));
/*  60 */       pStmt.setObject(8, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pj()));
/*  61 */       pStmt.setObject(9, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pf()));
/*  62 */       pStmt.setObject(10, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_poupanca()));
/*  63 */       pStmt.setObject(11, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_aporte()));
/*  64 */       pStmt.setObject(12, Float.valueOf(com_comenrcialT.getCom_nr_inadimplencia()));
/*  65 */       pStmt.setObject(13, Float.valueOf(com_comenrcialT.getCom_nr_vgv_atualizado()));
/*  66 */       pStmt.setObject(14, Float.valueOf(com_comenrcialT.getCom_nr_vgv_original()));
/*  67 */       pStmt.setObject(15, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_total()));
/*  68 */       pStmt.setObject(16, Integer.valueOf(com_comenrcialT.getCom_nr_id()));
/*  69 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  71 */       throw e;
/*     */     } finally {
/*     */       try {
/*  74 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/*  82 */     PreparedStatement pStmt = null;
/*     */     try {
/*  84 */       String sql = "delete from bi.com_comenrcial where  com_nr_id=?";
/*  85 */       pStmt = this.con.prepareStatement(sql);
/*  86 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_id()));
/*  87 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  89 */       throw e;
/*     */     } finally {
/*     */       try {
/*  92 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private List<Com_comenrcialT> resultSetToObjectTransfer(ResultSet rs) throws Exception
/*     */   {
/* 100 */     List<Com_comenrcialT> objs = new java.util.Vector();
/* 101 */     while (rs.next()) {
/* 102 */       Com_comenrcialT com_comenrcialT = new Com_comenrcialT();
/* 103 */       com_comenrcialT.setCom_nr_id(rs.getInt("com_nr_id"));
/* 104 */       com_comenrcialT.setObr_nr_id(rs.getInt("obr_nr_id"));
/* 105 */       com_comenrcialT.setCom_nr_mes(rs.getInt("com_nr_mes"));
/* 106 */       com_comenrcialT.setCom_nr_ano(rs.getInt("com_nr_ano"));
/* 107 */       com_comenrcialT.setCom_nr_unidade_med_acum(rs.getInt("com_nr_unidade_med_acum"));
/* 108 */       com_comenrcialT.setCom_nr_preco_medio_und_vendida(rs.getFloat("com_nr_preco_medio_und_vendida"));
/* 109 */       com_comenrcialT.setCom_nr_unidade_a_vender(rs.getInt("com_nr_unidade_a_vender"));
/* 110 */       com_comenrcialT.setCom_nr_preco_medio_unid_a_vender(rs.getFloat("com_nr_preco_medio_unid_a_vender"));
/* 111 */       com_comenrcialT.setCom_nr_recebimento_acumulado_pj(rs.getFloat("com_nr_recebimento_acumulado_pj"));
/* 112 */       com_comenrcialT.setCom_nr_recebimento_acumulado_pf(rs.getFloat("com_nr_recebimento_acumulado_pf"));
/* 113 */       com_comenrcialT.setCom_nr_recebimento_acumulado_poupanca(rs.getFloat("com_nr_recebimento_acumulado_poupanca"));
/* 114 */       com_comenrcialT.setCom_nr_recebimento_acumulado_aporte(rs.getFloat("com_nr_recebimento_acumulado_aporte"));
/* 115 */       com_comenrcialT.setCom_nr_inadimplencia(rs.getFloat("com_nr_inadimplencia"));
/* 116 */       com_comenrcialT.setCom_nr_vgv_atualizado(rs.getFloat("com_nr_vgv_atualizado"));
/* 117 */       com_comenrcialT.setCom_nr_vgv_original(rs.getFloat("com_nr_vgv_original"));
/* 118 */       com_comenrcialT.setCom_nr_recebimento_total(rs.getFloat("com_nr_recebimento_total"));
/* 119 */       objs.add(com_comenrcialT);
/*     */     }
/* 121 */     return objs;
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getAll(int obr_nr_id, int mes, int ano) throws Exception {
/* 125 */     PreparedStatement pStmt = null;
/* 126 */     ResultSet rs = null;
/*     */     try {
/* 128 */       String filter = " where obr_nr_id > -1";
/* 129 */       if (obr_nr_id > 0) {
/* 130 */         filter = filter + " and obr_nr_id =" + obr_nr_id;
/*     */       }
/* 132 */       if (mes > 0) {
/* 133 */         filter = filter + " and com_nr_mes =" + mes;
/*     */       }
/* 135 */       if (ano > 0) {
/* 136 */         filter = filter + " and com_nr_ano =" + ano;
/*     */       }
/*     */       
/* 139 */       String sql = "select * from bi.com_comenrcial " + filter;
/* 140 */       pStmt = this.con.prepareStatement(sql);
/* 141 */       rs = pStmt.executeQuery();
/* 142 */       List<Com_comenrcialT> list = resultSetToObjectTransfer(rs);
/* 143 */       return list;
/*     */     } catch (Exception e) {
/* 145 */       throw e;
/*     */     } finally {
/*     */       try {
/* 148 */         rs.close();
/* 149 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByPK(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 157 */     PreparedStatement pStmt = null;
/* 158 */     ResultSet rs = null;
/*     */     try {
/* 160 */       String sql = "select * from bi.com_comenrcial where  com_nr_id=?";
/* 161 */       pStmt = this.con.prepareStatement(sql);
/* 162 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_id()));
/* 163 */       rs = pStmt.executeQuery();
/* 164 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 166 */       throw e;
/*     */     } finally {
/*     */       try {
/* 169 */         rs.close();
/* 170 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_id(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 178 */     PreparedStatement pStmt = null;
/* 179 */     ResultSet rs = null;
/*     */     try {
/* 181 */       String sql = "select * from bi.com_comenrcial where  com_nr_id = ? ";
/* 182 */       pStmt = this.con.prepareStatement(sql);
/* 183 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_id()));
/* 184 */       rs = pStmt.executeQuery();
/* 185 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 187 */       throw e;
/*     */     } finally {
/*     */       try {
/* 190 */         rs.close();
/* 191 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByEmp_nr_id(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 199 */     PreparedStatement pStmt = null;
/* 200 */     ResultSet rs = null;
/*     */     try {
/* 202 */       String sql = "select * from bi.com_comenrcial where  obr_nr_id = ? ";
/* 203 */       pStmt = this.con.prepareStatement(sql);
/* 204 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getObr_nr_id()));
/* 205 */       rs = pStmt.executeQuery();
/* 206 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 208 */       throw e;
/*     */     } finally {
/*     */       try {
/* 211 */         rs.close();
/* 212 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_mes(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 220 */     PreparedStatement pStmt = null;
/* 221 */     ResultSet rs = null;
/*     */     try {
/* 223 */       String sql = "select * from bi.com_comenrcial where  com_nr_mes = ? ";
/* 224 */       pStmt = this.con.prepareStatement(sql);
/* 225 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_mes()));
/* 226 */       rs = pStmt.executeQuery();
/* 227 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 229 */       throw e;
/*     */     } finally {
/*     */       try {
/* 232 */         rs.close();
/* 233 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_ano(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 241 */     PreparedStatement pStmt = null;
/* 242 */     ResultSet rs = null;
/*     */     try {
/* 244 */       String sql = "select * from bi.com_comenrcial where  com_nr_ano = ? ";
/* 245 */       pStmt = this.con.prepareStatement(sql);
/* 246 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_ano()));
/* 247 */       rs = pStmt.executeQuery();
/* 248 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 250 */       throw e;
/*     */     } finally {
/*     */       try {
/* 253 */         rs.close();
/* 254 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCen_nr_id(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 262 */     PreparedStatement pStmt = null;
/* 263 */     ResultSet rs = null;
/*     */     try {
/* 265 */       String sql = "select * from bi.com_comenrcial where  cen_nr_id = ? ";
/* 266 */       pStmt = this.con.prepareStatement(sql);
/* 267 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCen_nr_id()));
/* 268 */       rs = pStmt.executeQuery();
/* 269 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 271 */       throw e;
/*     */     } finally {
/*     */       try {
/* 274 */         rs.close();
/* 275 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_tx_etapa(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 283 */     PreparedStatement pStmt = null;
/* 284 */     ResultSet rs = null;
/*     */     try {
/* 286 */       String sql = "select * from bi.com_comenrcial where  Upper(com_tx_etapa) like Upper(?) ";
/* 287 */       pStmt = this.con.prepareStatement(sql);
/* 288 */       pStmt.setObject(1, '%' + com_comenrcialT.getCom_tx_etapa() + '%');
/* 289 */       rs = pStmt.executeQuery();
/* 290 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 292 */       throw e;
/*     */     } finally {
/*     */       try {
/* 295 */         rs.close();
/* 296 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_unidade_med_acum(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 304 */     PreparedStatement pStmt = null;
/* 305 */     ResultSet rs = null;
/*     */     try {
/* 307 */       String sql = "select * from bi.com_comenrcial where  com_nr_unidade_med_acum = ? ";
/* 308 */       pStmt = this.con.prepareStatement(sql);
/* 309 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_med_acum()));
/* 310 */       rs = pStmt.executeQuery();
/* 311 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 313 */       throw e;
/*     */     } finally {
/*     */       try {
/* 316 */         rs.close();
/* 317 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_preco_medio_und_vendida(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 325 */     PreparedStatement pStmt = null;
/* 326 */     ResultSet rs = null;
/*     */     try {
/* 328 */       String sql = "select * from bi.com_comenrcial where  com_nr_preco_medio_und_vendida = ? ";
/* 329 */       pStmt = this.con.prepareStatement(sql);
/* 330 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_und_vendida()));
/* 331 */       rs = pStmt.executeQuery();
/* 332 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 334 */       throw e;
/*     */     } finally {
/*     */       try {
/* 337 */         rs.close();
/* 338 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_unidade_a_vender(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 346 */     PreparedStatement pStmt = null;
/* 347 */     ResultSet rs = null;
/*     */     try {
/* 349 */       String sql = "select * from bi.com_comenrcial where  com_nr_unidade_a_vender = ? ";
/* 350 */       pStmt = this.con.prepareStatement(sql);
/* 351 */       pStmt.setObject(1, Integer.valueOf(com_comenrcialT.getCom_nr_unidade_a_vender()));
/* 352 */       rs = pStmt.executeQuery();
/* 353 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 355 */       throw e;
/*     */     } finally {
/*     */       try {
/* 358 */         rs.close();
/* 359 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_preco_medio_unid_a_vender(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 367 */     PreparedStatement pStmt = null;
/* 368 */     ResultSet rs = null;
/*     */     try {
/* 370 */       String sql = "select * from bi.com_comenrcial where  com_nr_preco_medio_unid_a_vender = ? ";
/* 371 */       pStmt = this.con.prepareStatement(sql);
/* 372 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_preco_medio_unid_a_vender()));
/* 373 */       rs = pStmt.executeQuery();
/* 374 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 376 */       throw e;
/*     */     } finally {
/*     */       try {
/* 379 */         rs.close();
/* 380 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_recebimento_acumulado_pj(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 388 */     PreparedStatement pStmt = null;
/* 389 */     ResultSet rs = null;
/*     */     try {
/* 391 */       String sql = "select * from bi.com_comenrcial where  com_nr_recebimento_acumulado_pj = ? ";
/* 392 */       pStmt = this.con.prepareStatement(sql);
/* 393 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pj()));
/* 394 */       rs = pStmt.executeQuery();
/* 395 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 397 */       throw e;
/*     */     } finally {
/*     */       try {
/* 400 */         rs.close();
/* 401 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_recebimento_acumulado_pf(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 409 */     PreparedStatement pStmt = null;
/* 410 */     ResultSet rs = null;
/*     */     try {
/* 412 */       String sql = "select * from bi.com_comenrcial where  com_nr_recebimento_acumulado_pf = ? ";
/* 413 */       pStmt = this.con.prepareStatement(sql);
/* 414 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_pf()));
/* 415 */       rs = pStmt.executeQuery();
/* 416 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 418 */       throw e;
/*     */     } finally {
/*     */       try {
/* 421 */         rs.close();
/* 422 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_recebimento_acumulado_poupanca(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 430 */     PreparedStatement pStmt = null;
/* 431 */     ResultSet rs = null;
/*     */     try {
/* 433 */       String sql = "select * from bi.com_comenrcial where  com_nr_recebimento_acumulado_poupanca = ? ";
/* 434 */       pStmt = this.con.prepareStatement(sql);
/* 435 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_poupanca()));
/* 436 */       rs = pStmt.executeQuery();
/* 437 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 439 */       throw e;
/*     */     } finally {
/*     */       try {
/* 442 */         rs.close();
/* 443 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_recebimento_acumulado_aporte(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 451 */     PreparedStatement pStmt = null;
/* 452 */     ResultSet rs = null;
/*     */     try {
/* 454 */       String sql = "select * from bi.com_comenrcial where  com_nr_recebimento_acumulado_aporte = ? ";
/* 455 */       pStmt = this.con.prepareStatement(sql);
/* 456 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_acumulado_aporte()));
/* 457 */       rs = pStmt.executeQuery();
/* 458 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 460 */       throw e;
/*     */     } finally {
/*     */       try {
/* 463 */         rs.close();
/* 464 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_inadimplencia(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 472 */     PreparedStatement pStmt = null;
/* 473 */     ResultSet rs = null;
/*     */     try {
/* 475 */       String sql = "select * from bi.com_comenrcial where  com_nr_inadimplencia = ? ";
/* 476 */       pStmt = this.con.prepareStatement(sql);
/* 477 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_inadimplencia()));
/* 478 */       rs = pStmt.executeQuery();
/* 479 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 481 */       throw e;
/*     */     } finally {
/*     */       try {
/* 484 */         rs.close();
/* 485 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_vgv_atualizado(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 493 */     PreparedStatement pStmt = null;
/* 494 */     ResultSet rs = null;
/*     */     try {
/* 496 */       String sql = "select * from bi.com_comenrcial where  com_nr_vgv_atualizado = ? ";
/* 497 */       pStmt = this.con.prepareStatement(sql);
/* 498 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_vgv_atualizado()));
/* 499 */       rs = pStmt.executeQuery();
/* 500 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 502 */       throw e;
/*     */     } finally {
/*     */       try {
/* 505 */         rs.close();
/* 506 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_vgv_original(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 514 */     PreparedStatement pStmt = null;
/* 515 */     ResultSet rs = null;
/*     */     try {
/* 517 */       String sql = "select * from bi.com_comenrcial where  com_nr_vgv_original = ? ";
/* 518 */       pStmt = this.con.prepareStatement(sql);
/* 519 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_vgv_original()));
/* 520 */       rs = pStmt.executeQuery();
/* 521 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 523 */       throw e;
/*     */     } finally {
/*     */       try {
/* 526 */         rs.close();
/* 527 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Com_comenrcialT> getByCom_nr_recebimento_total(Com_comenrcialT com_comenrcialT) throws Exception
/*     */   {
/* 535 */     PreparedStatement pStmt = null;
/* 536 */     ResultSet rs = null;
/*     */     try {
/* 538 */       String sql = "select * from bi.com_comenrcial where  com_nr_recebimento_total = ? ";
/* 539 */       pStmt = this.con.prepareStatement(sql);
/* 540 */       pStmt.setObject(1, Float.valueOf(com_comenrcialT.getCom_nr_recebimento_total()));
/* 541 */       rs = pStmt.executeQuery();
/* 542 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 544 */       throw e;
/*     */     } finally {
/*     */       try {
/* 547 */         rs.close();
/* 548 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/dao/Com_comenrcialDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */