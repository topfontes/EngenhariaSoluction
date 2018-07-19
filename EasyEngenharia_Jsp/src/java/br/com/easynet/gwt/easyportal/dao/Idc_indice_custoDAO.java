/*     */ package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Idc_indice_custoT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Idc_indice_custoDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Idc_indice_custoDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  12 */     setDAOFactory(dao);
/*  13 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Idc_indice_custoT idc_indice_custoT) throws Exception {
/*  17 */     PreparedStatement pStmt = null;
/*     */     try {
/*  19 */       String sql = "insert into bi.idc_indice_custo  (obr_nr_id, idc_nr_mes, idc_nr_ano, plc_nr_id, idc_nr_ic_atual, idc_nr_ic_projetado, idc_nr_projetado_empreendimento) values ( ? , ? , ? , ? , ? , ?, ? )";
/*  20 */       pStmt = this.con.prepareStatement(sql);
/*  21 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getObr_nr_id()));
/*  22 */       pStmt.setObject(2, Integer.valueOf(idc_indice_custoT.getIdc_nr_mes()));
/*  23 */       pStmt.setObject(3, Integer.valueOf(idc_indice_custoT.getIdc_nr_ano()));
/*  24 */       pStmt.setObject(4, Integer.valueOf(idc_indice_custoT.getPlc_nr_id()));
/*  25 */       pStmt.setObject(5, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_atual()));
/*  26 */       pStmt.setObject(6, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_projetado()));
/*  27 */       pStmt.setObject(7, Double.valueOf(idc_indice_custoT.getIdc_nr_projetado_empreendimento()));
/*  28 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  30 */       throw e;
/*     */     } finally {
/*     */       try {
/*  33 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/*  41 */     PreparedStatement pStmt = null;
/*     */     try {
/*  43 */       String sql = "update bi.idc_indice_custo set  obr_nr_id=?, idc_nr_mes=?, idc_nr_ano=?, plc_nr_id=?, idc_nr_ic_atual=?, idc_nr_ic_projetado=?, idc_nr_projetado_empreendimento=?  where  idc_nr_id=?";
/*  44 */       pStmt = this.con.prepareStatement(sql);
/*  45 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getObr_nr_id()));
/*  46 */       pStmt.setObject(2, Integer.valueOf(idc_indice_custoT.getIdc_nr_mes()));
/*  47 */       pStmt.setObject(3, Integer.valueOf(idc_indice_custoT.getIdc_nr_ano()));
/*  48 */       pStmt.setObject(4, Integer.valueOf(idc_indice_custoT.getPlc_nr_id()));
/*  49 */       pStmt.setObject(5, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_atual()));
/*  50 */       pStmt.setObject(6, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_projetado()));
/*  51 */       pStmt.setObject(7, Double.valueOf(idc_indice_custoT.getIdc_nr_projetado_empreendimento()));
/*  52 */       pStmt.setObject(8, Integer.valueOf(idc_indice_custoT.getIdc_nr_id()));
/*  53 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  55 */       throw e;
/*     */     } finally {
/*     */       try {
/*  58 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/*  66 */     PreparedStatement pStmt = null;
/*     */     try {
/*  68 */       String sql = "delete from bi.idc_indice_custo where  idc_nr_id=?";
/*  69 */       pStmt = this.con.prepareStatement(sql);
/*  70 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getIdc_nr_id()));
/*  71 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  73 */       throw e;
/*     */     } finally {
/*     */       try {
/*  76 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private List<Idc_indice_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception
/*     */   {
/*  84 */     List<Idc_indice_custoT> objs = new java.util.Vector();
/*  85 */     while (rs.next()) {
/*  86 */       Idc_indice_custoT idc_indice_custoT = new Idc_indice_custoT();
/*  87 */       idc_indice_custoT.setIdc_nr_id(rs.getInt("idc_nr_id"));
/*  88 */       idc_indice_custoT.setObr_nr_id(rs.getInt("obr_nr_id"));
/*  89 */       idc_indice_custoT.setIdc_nr_mes(rs.getInt("idc_nr_mes"));
/*  90 */       idc_indice_custoT.setIdc_nr_ano(rs.getInt("idc_nr_ano"));
/*  91 */       idc_indice_custoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
/*  92 */       idc_indice_custoT.setIdc_nr_ic_atual(rs.getFloat("idc_nr_ic_atual"));
/*  93 */       idc_indice_custoT.setIdc_nr_ic_projetado(rs.getInt("idc_nr_ic_projetado"));
/*  94 */       idc_indice_custoT.setIdc_nr_projetado_empreendimento(rs.getFloat("idc_nr_projetado_empreendimento"));
/*  95 */       objs.add(idc_indice_custoT);
/*     */     }
/*  97 */     return objs;
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getAll(int obr_nr_id, int mes, int ano) throws Exception {
/* 101 */     PreparedStatement pStmt = null;
/* 102 */     ResultSet rs = null;
/*     */     try {
/* 104 */       String filter = " where obr_nr_id > -1";
/* 105 */       if (obr_nr_id > 0) {
/* 106 */         filter = filter + " and obr_nr_id =" + obr_nr_id;
/*     */       }
/* 108 */       if (mes > 0) {
/* 109 */         filter = filter + " and idc_nr_mes =" + mes;
/*     */       }
/* 111 */       if (ano > 0) {
/* 112 */         filter = filter + " and idc_nr_ano =" + ano;
/*     */       }
/* 114 */       String sql = "select * from bi.idc_indice_custo " + filter;
/* 115 */       pStmt = this.con.prepareStatement(sql);
/* 116 */       rs = pStmt.executeQuery();
/* 117 */       List<Idc_indice_custoT> list = resultSetToObjectTransfer(rs);
/* 118 */       return list;
/*     */     } catch (Exception e) {
/* 120 */       throw e;
/*     */     } finally {
/*     */       try {
/* 123 */         rs.close();
/* 124 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByPK(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 132 */     PreparedStatement pStmt = null;
/* 133 */     ResultSet rs = null;
/*     */     try {
/* 135 */       String sql = "select * from bi.idc_indice_custo where  idc_nr_id=?";
/* 136 */       pStmt = this.con.prepareStatement(sql);
/* 137 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getIdc_nr_id()));
/* 138 */       rs = pStmt.executeQuery();
/* 139 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 141 */       throw e;
/*     */     } finally {
/*     */       try {
/* 144 */         rs.close();
/* 145 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Idc_indice_custoT getByExiste(Idc_indice_custoT idc_indice_custoT)
/*     */     throws Exception
/*     */   {
/* 157 */     PreparedStatement pStmt = null;
/* 158 */     ResultSet rs = null;
/*     */     try {
/* 160 */       String sql = "select * from bi.idc_indice_custo where  obr_nr_id = ? and idc_nr_mes=? and idc_nr_ano=? and plc_nr_id=? ";
/* 161 */       pStmt = this.con.prepareStatement(sql);
/* 162 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getObr_nr_id()));
/* 163 */       pStmt.setObject(2, Integer.valueOf(idc_indice_custoT.getIdc_nr_mes()));
/* 164 */       pStmt.setObject(3, Integer.valueOf(idc_indice_custoT.getIdc_nr_ano()));
/* 165 */       pStmt.setObject(4, Integer.valueOf(idc_indice_custoT.getPlc_nr_id()));
/* 166 */       rs = pStmt.executeQuery();
/* 167 */       List<Idc_indice_custoT> list = resultSetToObjectTransfer(rs);
/* 168 */       return list.size() > 0 ? (Idc_indice_custoT)list.get(0) : null;
/*     */     } catch (Exception e) {
/* 170 */       throw e;
/*     */     } finally {
/*     */       try {
/* 173 */         rs.close();
/* 174 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.TreeMap<Integer, Double> getByEmp_nr_id(int obr_nr_id, int mes, int ano) throws Exception
/*     */   {
/* 182 */     PreparedStatement pStmt = null;
/* 183 */     ResultSet rs = null;
/*     */     try {
/* 185 */       String sql = "select plc_nr_id, idc_nr_ic_projetado from bi.idc_indice_custo where  obr_nr_id = ? and idc_nr_mes=? and idc_nr_ano=?";
/* 186 */       pStmt = this.con.prepareStatement(sql);
/* 187 */       pStmt.setObject(1, Integer.valueOf(obr_nr_id));
/* 188 */       pStmt.setObject(2, Integer.valueOf(mes));
/* 189 */       pStmt.setObject(3, Integer.valueOf(ano));
/* 190 */       rs = pStmt.executeQuery();
/*     */       
/* 192 */       java.util.TreeMap<Integer, Double> tree = new java.util.TreeMap();
/* 193 */       while (rs.next()) {
/* 194 */         tree.put(Integer.valueOf(rs.getInt("plc_nr_id")), Double.valueOf(rs.getDouble("idc_nr_ic_projetado")));
/*     */       }
/* 196 */       return tree;
/*     */     } catch (Exception e) {
/* 198 */       throw e;
/*     */     } finally {
/*     */       try {
/* 201 */         rs.close();
/* 202 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByIdc_nr_ano(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 210 */     PreparedStatement pStmt = null;
/* 211 */     ResultSet rs = null;
/*     */     try {
/* 213 */       String sql = "select * from bi.idc_indice_custo where  idc_nr_ano = ? ";
/* 214 */       pStmt = this.con.prepareStatement(sql);
/* 215 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getIdc_nr_ano()));
/* 216 */       rs = pStmt.executeQuery();
/* 217 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 219 */       throw e;
/*     */     } finally {
/*     */       try {
/* 222 */         rs.close();
/* 223 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByPlc_nr_id(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 231 */     PreparedStatement pStmt = null;
/* 232 */     ResultSet rs = null;
/*     */     try {
/* 234 */       String sql = "select * from bi.idc_indice_custo where  plc_nr_id = ? ";
/* 235 */       pStmt = this.con.prepareStatement(sql);
/* 236 */       pStmt.setObject(1, Integer.valueOf(idc_indice_custoT.getPlc_nr_id()));
/* 237 */       rs = pStmt.executeQuery();
/* 238 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 240 */       throw e;
/*     */     } finally {
/*     */       try {
/* 243 */         rs.close();
/* 244 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByIdc_nr_ic_atual(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 252 */     PreparedStatement pStmt = null;
/* 253 */     ResultSet rs = null;
/*     */     try {
/* 255 */       String sql = "select * from bi.idc_indice_custo where  idc_nr_ic_atual = ? ";
/* 256 */       pStmt = this.con.prepareStatement(sql);
/* 257 */       pStmt.setObject(1, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_atual()));
/* 258 */       rs = pStmt.executeQuery();
/* 259 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 261 */       throw e;
/*     */     } finally {
/*     */       try {
/* 264 */         rs.close();
/* 265 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByIdc_nr_ic_projetado(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 273 */     PreparedStatement pStmt = null;
/* 274 */     ResultSet rs = null;
/*     */     try {
/* 276 */       String sql = "select * from bi.idc_indice_custo where  idc_nr_ic_projetado = ? ";
/* 277 */       pStmt = this.con.prepareStatement(sql);
/* 278 */       pStmt.setObject(1, Double.valueOf(idc_indice_custoT.getIdc_nr_ic_projetado()));
/* 279 */       rs = pStmt.executeQuery();
/* 280 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 282 */       throw e;
/*     */     } finally {
/*     */       try {
/* 285 */         rs.close();
/* 286 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Idc_indice_custoT> getByIdc_nr_projetado_empreendimento(Idc_indice_custoT idc_indice_custoT) throws Exception
/*     */   {
/* 294 */     PreparedStatement pStmt = null;
/* 295 */     ResultSet rs = null;
/*     */     try {
/* 297 */       String sql = "select * from bi.idc_indice_custo where  idc_nr_projetado_empreendimento = ? ";
/* 298 */       pStmt = this.con.prepareStatement(sql);
/* 299 */       pStmt.setObject(1, Double.valueOf(idc_indice_custoT.getIdc_nr_projetado_empreendimento()));
/* 300 */       rs = pStmt.executeQuery();
/* 301 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 303 */       throw e;
/*     */     } finally {
/*     */       try {
/* 306 */         rs.close();
/* 307 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/gwt/easyportal/dao/Idc_indice_custoDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */