package br.com.easynet.gwt.easyportal.dao;
/*     */ 
/*     */ import br.com.easynet.gwt.easyportal.transfer.Ucl_usuario_clienteT;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ 
/*     */ public class Ucl_usuario_clienteDAO extends br.com.jdragon.dao.ObjectDAO
/*     */ {
/*     */   public Ucl_usuario_clienteDAO(br.com.jdragon.dao.DAOFactory dao) throws Exception
/*     */   {
/*  11 */     setDAOFactory(dao);
/*  12 */     this.con = dao.create();
/*     */   }
/*     */   
/*     */   public void insert(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/*  16 */     PreparedStatement pStmt = null;
/*     */     try {
/*  18 */       String sql = "insert into easyconstru.ucl_usuario_cliente  ( usu_nr_id, cli_nr_id) values ( ? , ? )";
/*  19 */       pStmt = this.con.prepareStatement(sql);
/*  20 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUsu_nr_id()));
/*  21 */       pStmt.setObject(2, Integer.valueOf(ucl_usuario_clienteT.getCli_nr_id()));
/*  22 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  24 */       throw e;
/*     */     } finally {
/*     */       try {
/*  27 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/*  33 */     PreparedStatement pStmt = null;
/*     */     try {
/*  35 */       String sql = "update easyconstru.ucl_usuario_cliente set  usu_nr_id=?, cli_nr_id=?  where  ucl_nr_id=?";
/*  36 */       pStmt = this.con.prepareStatement(sql);
/*  37 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUsu_nr_id()));
/*  38 */       pStmt.setObject(2, Integer.valueOf(ucl_usuario_clienteT.getCli_nr_id()));
/*  39 */       pStmt.setObject(3, Integer.valueOf(ucl_usuario_clienteT.getUcl_nr_id()));
/*  40 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  42 */       throw e;
/*     */     } finally {
/*     */       try {
/*  45 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public void delete(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/*  51 */     PreparedStatement pStmt = null;
/*     */     try {
/*  53 */       String sql = "delete from easyconstru.ucl_usuario_cliente where  ucl_nr_id=?";
/*  54 */       pStmt = this.con.prepareStatement(sql);
/*  55 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUcl_nr_id()));
/*  56 */       pStmt.execute(); return;
/*     */     } catch (Exception e) {
/*  58 */       throw e;
/*     */     } finally {
/*     */       try {
/*  61 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private java.util.List<Ucl_usuario_clienteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
/*  67 */     java.util.List<Ucl_usuario_clienteT> objs = new java.util.Vector();
/*  68 */     while (rs.next()) {
/*  69 */       Ucl_usuario_clienteT ucl_usuario_clienteT = new Ucl_usuario_clienteT();
/*  70 */       ucl_usuario_clienteT.setUcl_nr_id(rs.getInt("ucl_nr_id"));
/*  71 */       ucl_usuario_clienteT.setUsu_nr_id(rs.getInt("usu_nr_id"));
/*  72 */       ucl_usuario_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
/*  73 */       objs.add(ucl_usuario_clienteT);
/*     */     }
/*  75 */     return objs;
/*     */   }
/*     */   
/*  78 */   public java.util.List<Ucl_usuario_clienteT> getAll() throws Exception { PreparedStatement pStmt = null;
/*  79 */     ResultSet rs = null;
/*     */     try {
/*  81 */       String sql = "select * from easyconstru.ucl_usuario_cliente";
/*  82 */       pStmt = this.con.prepareStatement(sql);
/*  83 */       rs = pStmt.executeQuery();
/*  84 */       java.util.List<Ucl_usuario_clienteT> list = resultSetToObjectTransfer(rs);
/*  85 */       return list;
/*     */     } catch (Exception e) {
/*  87 */       throw e;
/*     */     } finally {
/*  89 */       try { rs.close();
/*  90 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.List<Ucl_usuario_clienteT> getByPK(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/*  96 */     PreparedStatement pStmt = null;
/*  97 */     ResultSet rs = null;
/*     */     try {
/*  99 */       String sql = "select * from easyconstru.ucl_usuario_cliente where  ucl_nr_id=?";
/* 100 */       pStmt = this.con.prepareStatement(sql);
/* 101 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUcl_nr_id()));
/* 102 */       rs = pStmt.executeQuery();
/* 103 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 105 */       throw e;
/*     */     } finally {
/* 107 */       try { rs.close();
/* 108 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.List<Ucl_usuario_clienteT> getByUcl_nr_id(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/* 114 */     PreparedStatement pStmt = null;
/* 115 */     ResultSet rs = null;
/*     */     try {
/* 117 */       String sql = "select * from easyconstru.ucl_usuario_cliente where  ucl_nr_id = ? ";
/* 118 */       pStmt = this.con.prepareStatement(sql);
/* 119 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUcl_nr_id()));
/* 120 */       rs = pStmt.executeQuery();
/* 121 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 123 */       throw e;
/*     */     } finally {
/* 125 */       try { rs.close();
/* 126 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.List<Ucl_usuario_clienteT> getByUsu_nr_id(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/* 132 */     PreparedStatement pStmt = null;
/* 133 */     ResultSet rs = null;
/*     */     try {
/* 135 */       String sql = "select * from easyconstru.ucl_usuario_cliente where  usu_nr_id = ? ";
/* 136 */       pStmt = this.con.prepareStatement(sql);
/* 137 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getUsu_nr_id()));
/* 138 */       rs = pStmt.executeQuery();
/* 139 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 141 */       throw e;
/*     */     } finally {
/* 143 */       try { rs.close();
/* 144 */         pStmt.close();
/*     */       } catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.List<Ucl_usuario_clienteT> getByCli_nr_id(Ucl_usuario_clienteT ucl_usuario_clienteT) throws Exception {
/* 150 */     PreparedStatement pStmt = null;
/* 151 */     ResultSet rs = null;
/*     */     try {
/* 153 */       String sql = "select * from easyconstru.ucl_usuario_cliente where  cli_nr_id = ? ";
/* 154 */       pStmt = this.con.prepareStatement(sql);
/* 155 */       pStmt.setObject(1, Integer.valueOf(ucl_usuario_clienteT.getCli_nr_id()));
/* 156 */       rs = pStmt.executeQuery();
/* 157 */       return resultSetToObjectTransfer(rs);
/*     */     } catch (Exception e) {
/* 159 */       throw e;
/*     */     } finally {
/* 161 */       try { rs.close();
/* 162 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/marcos/fontes3/engenharia.jar!/br/com/easynet/easyportal/dao/Ucl_usuario_clienteDAO.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */