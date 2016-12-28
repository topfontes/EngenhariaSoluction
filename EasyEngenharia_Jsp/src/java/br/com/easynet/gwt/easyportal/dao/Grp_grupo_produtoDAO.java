package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Grp_grupo_produtoDAO extends ObjectDAO { 
	 public Grp_grupo_produtoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Grp_grupo_produtoT grp_grupo_produtoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.grp_grupo_produto  ( grp_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, grp_grupo_produtoT.getGrp_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Grp_grupo_produtoT grp_grupo_produtoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.grp_grupo_produto set  grp_tx_nome=?  where  grp_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, grp_grupo_produtoT.getGrp_tx_nome());
			 pStmt.setObject(2, grp_grupo_produtoT.getGrp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Grp_grupo_produtoT grp_grupo_produtoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.grp_grupo_produto where  grp_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, grp_grupo_produtoT.getGrp_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Grp_grupo_produtoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Grp_grupo_produtoT> objs = new Vector();
		 while (rs.next()) { 
 			 Grp_grupo_produtoT grp_grupo_produtoT = new Grp_grupo_produtoT();
			 grp_grupo_produtoT.setGrp_nr_id(rs.getInt("grp_nr_id"));
			 grp_grupo_produtoT.setGrp_tx_nome(rs.getString("grp_tx_nome"));
			 objs.add(grp_grupo_produtoT);
 		 }
 		 return objs; 
 	 }
	 public List<Grp_grupo_produtoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.grp_grupo_produto"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Grp_grupo_produtoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Grp_grupo_produtoT> getByPK(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.grp_grupo_produto where  grp_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, grp_grupo_produtoT.getGrp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Grp_grupo_produtoT> getByGrp_nr_id(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.grp_grupo_produto where  grp_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, grp_grupo_produtoT.getGrp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Grp_grupo_produtoT> getByGrp_tx_nome(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.grp_grupo_produto where  Upper(grp_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + grp_grupo_produtoT.getGrp_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 

 }