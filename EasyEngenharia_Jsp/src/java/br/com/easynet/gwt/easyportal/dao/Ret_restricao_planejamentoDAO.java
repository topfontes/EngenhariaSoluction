/*     */ package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ret_restricao_planejamentoT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Ret_restricao_planejamentoDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Ret_restricao_planejamentoDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  12 */     setDAOFactory(dao);
/*  13 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception {
/*  17 */     PreparedStatement pStmt = null;
/*     */     try {
/*  19 */       String sql = "insert into bi.ret_restricao_planejamento  (obr_nr_id, ret_nr_mes, ret_nr_ano, ret_tx_restricao, ret_nr_ocorrencia, ret_nr_deficet) values ( ? , ? , ? , ? , ? , ? )";
/*  20 */       pStmt = this.con.prepareStatement(sql);
/*  21 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getObr_nr_id()));
/*  22 */       pStmt.setObject(2, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_mes()));
/*  23 */       pStmt.setObject(3, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_ano()));
/*  24 */       pStmt.setObject(4, ret_restricao_planejamentoT.getRet_tx_restricao());
/*  25 */       pStmt.setObject(5, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_ocorrencia()));
/*  26 */       pStmt.setObject(6, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_deficet()));
/*  27 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  29 */       throw e;
/*     */     } finally {
/*     */       try {
/*  32 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/*  40 */     PreparedStatement pStmt = null;
/*     */     try {
/*  42 */       String sql = "update bi.ret_restricao_planejamento set  obr_nr_id=?, ret_nr_mes=?, ret_nr_ano=?, ret_tx_restricao=?, ret_nr_ocorrencia=?, ret_nr_deficet=?  where  ret_nr_id=?";
/*  43 */       pStmt = this.con.prepareStatement(sql);
/*  44 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getObr_nr_id()));
/*  45 */       pStmt.setObject(2, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_mes()));
/*  46 */       pStmt.setObject(3, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_ano()));
/*  47 */       pStmt.setObject(4, ret_restricao_planejamentoT.getRet_tx_restricao());
/*  48 */       pStmt.setObject(5, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_ocorrencia()));
/*  49 */       pStmt.setObject(6, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_deficet()));
/*  50 */       pStmt.setObject(7, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_id()));
/*  51 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  53 */       throw e;
/*     */     } finally {
/*     */       try {
/*  56 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/*  64 */     PreparedStatement pStmt = null;
/*     */     try {
/*  66 */       String sql = "delete from bi.ret_restricao_planejamento where  ret_nr_id=?";
/*  67 */       pStmt = this.con.prepareStatement(sql);
/*  68 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_id()));
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
/*     */   private List<Ret_restricao_planejamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception
/*     */   {
/*  82 */     List<Ret_restricao_planejamentoT> objs = new java.util.Vector();
/*  83 */     while (rs.next()) {
/*  84 */       Ret_restricao_planejamentoT ret_restricao_planejamentoT = new Ret_restricao_planejamentoT();
/*  85 */       ret_restricao_planejamentoT.setRet_nr_id(rs.getInt("ret_nr_id"));
/*  86 */       ret_restricao_planejamentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
/*  87 */       ret_restricao_planejamentoT.setRet_nr_mes(rs.getInt("ret_nr_mes"));
/*  88 */       ret_restricao_planejamentoT.setRet_nr_ano(rs.getInt("ret_nr_ano"));
/*  89 */       ret_restricao_planejamentoT.setRet_tx_restricao(rs.getString("ret_tx_restricao"));
/*  90 */       ret_restricao_planejamentoT.setRet_nr_ocorrencia(rs.getFloat("ret_nr_ocorrencia"));
/*  91 */       ret_restricao_planejamentoT.setRet_nr_deficet(rs.getFloat("ret_nr_deficet"));
/*  92 */       objs.add(ret_restricao_planejamentoT);
/*     */     }
/*  94 */     return objs;
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getAll(int obr_nr_id, int mes, int ano) throws Exception {
/*  98 */     PreparedStatement pStmt = null;
/*  99 */     ResultSet rs = null;
/*     */     try {
/* 101 */       String filter = " where obr_nr_id > -1";
/* 102 */       if (obr_nr_id > 0) {
/* 103 */         filter = filter + " and obr_nr_id =" + obr_nr_id;
/*     */       }
/* 105 */       if (mes > 0) {
/* 106 */         filter = filter + " and ret_nr_mes =" + mes;
/*     */       }
/* 108 */       if (ano > 0) {
/* 109 */         filter = filter + " and ret_nr_ano =" + ano;
/*     */       }
/* 111 */       String sql = "select * from bi.ret_restricao_planejamento " + filter;
/* 112 */       pStmt = this.con.prepareStatement(sql);
/* 113 */       rs = pStmt.executeQuery();
/* 114 */       List<Ret_restricao_planejamentoT> list = resultSetToObjectTransfer(rs);
/* 115 */       return list;
/*     */     } catch (Exception e) {
/* 117 */       throw e;
/*     */     } finally {
/*     */       try {
/* 120 */         rs.close();
/* 121 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByPK(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 129 */     PreparedStatement pStmt = null;
/* 130 */     ResultSet rs = null;
/*     */     try {
/* 132 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_id=?";
/* 133 */       pStmt = this.con.prepareStatement(sql);
/* 134 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_id()));
/* 135 */       rs = pStmt.executeQuery();
/* 136 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 138 */       throw e;
/*     */     } finally {
/*     */       try {
/* 141 */         rs.close();
/* 142 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_nr_id(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 150 */     PreparedStatement pStmt = null;
/* 151 */     ResultSet rs = null;
/*     */     try {
/* 153 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_id = ? ";
/* 154 */       pStmt = this.con.prepareStatement(sql);
/* 155 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_id()));
/* 156 */       rs = pStmt.executeQuery();
/* 157 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 159 */       throw e;
/*     */     } finally {
/*     */       try {
/* 162 */         rs.close();
/* 163 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByEmp_nr_id(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 171 */     PreparedStatement pStmt = null;
/* 172 */     ResultSet rs = null;
/*     */     try {
/* 174 */       String sql = "select * from bi.ret_restricao_planejamento where obr_nr_id = ? ";
/* 175 */       pStmt = this.con.prepareStatement(sql);
/* 176 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getObr_nr_id()));
/* 177 */       rs = pStmt.executeQuery();
/* 178 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 180 */       throw e;
/*     */     } finally {
/*     */       try {
/* 183 */         rs.close();
/* 184 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_nr_mes(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 192 */     PreparedStatement pStmt = null;
/* 193 */     ResultSet rs = null;
/*     */     try {
/* 195 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_mes = ? ";
/* 196 */       pStmt = this.con.prepareStatement(sql);
/* 197 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_mes()));
/* 198 */       rs = pStmt.executeQuery();
/* 199 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 201 */       throw e;
/*     */     } finally {
/*     */       try {
/* 204 */         rs.close();
/* 205 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_nr_ano(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 213 */     PreparedStatement pStmt = null;
/* 214 */     ResultSet rs = null;
/*     */     try {
/* 216 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_ano = ? ";
/* 217 */       pStmt = this.con.prepareStatement(sql);
/* 218 */       pStmt.setObject(1, Integer.valueOf(ret_restricao_planejamentoT.getRet_nr_ano()));
/* 219 */       rs = pStmt.executeQuery();
/* 220 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 222 */       throw e;
/*     */     } finally {
/*     */       try {
/* 225 */         rs.close();
/* 226 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_tx_restricao(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 234 */     PreparedStatement pStmt = null;
/* 235 */     ResultSet rs = null;
/*     */     try {
/* 237 */       String sql = "select * from bi.ret_restricao_planejamento where  Upper(ret_tx_restricao) like Upper(?) ";
/* 238 */       pStmt = this.con.prepareStatement(sql);
/* 239 */       pStmt.setObject(1, '%' + ret_restricao_planejamentoT.getRet_tx_restricao() + '%');
/* 240 */       rs = pStmt.executeQuery();
/* 241 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 243 */       throw e;
/*     */     } finally {
/*     */       try {
/* 246 */         rs.close();
/* 247 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_nr_ocorrencia(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 255 */     PreparedStatement pStmt = null;
/* 256 */     ResultSet rs = null;
/*     */     try {
/* 258 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_ocorrencia = ? ";
/* 259 */       pStmt = this.con.prepareStatement(sql);
/* 260 */       pStmt.setObject(1, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_ocorrencia()));
/* 261 */       rs = pStmt.executeQuery();
/* 262 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 264 */       throw e;
/*     */     } finally {
/*     */       try {
/* 267 */         rs.close();
/* 268 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Ret_restricao_planejamentoT> getByRet_nr_deficet(Ret_restricao_planejamentoT ret_restricao_planejamentoT) throws Exception
/*     */   {
/* 276 */     PreparedStatement pStmt = null;
/* 277 */     ResultSet rs = null;
/*     */     try {
/* 279 */       String sql = "select * from bi.ret_restricao_planejamento where  ret_nr_deficet = ? ";
/* 280 */       pStmt = this.con.prepareStatement(sql);
/* 281 */       pStmt.setObject(1, Float.valueOf(ret_restricao_planejamentoT.getRet_nr_deficet()));
/* 282 */       rs = pStmt.executeQuery();
/* 283 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 285 */       throw e;
/*     */     } finally {
/*     */       try {
/* 288 */         rs.close();
/* 289 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/dao/Ret_restricao_planejamentoDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */