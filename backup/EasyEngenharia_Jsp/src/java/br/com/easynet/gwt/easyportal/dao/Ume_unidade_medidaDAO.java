package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Ume_unidade_medidaDAO extends ObjectDAO { 
	 public Ume_unidade_medidaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Ume_unidade_medidaT ume_unidade_medidaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.ume_unidade_medida  ( ume_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ume_unidade_medidaT.getUme_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Ume_unidade_medidaT ume_unidade_medidaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.ume_unidade_medida set  ume_tx_nome=?  where  ume_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ume_unidade_medidaT.getUme_tx_nome());
			 pStmt.setObject(2, ume_unidade_medidaT.getUme_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Ume_unidade_medidaT ume_unidade_medidaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.ume_unidade_medida where  ume_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ume_unidade_medidaT.getUme_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Ume_unidade_medidaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Ume_unidade_medidaT> objs = new Vector();
		 while (rs.next()) { 
 			 Ume_unidade_medidaT ume_unidade_medidaT = new Ume_unidade_medidaT();
			 ume_unidade_medidaT.setUme_nr_id(rs.getInt("ume_nr_id"));
			 ume_unidade_medidaT.setUme_tx_nome(rs.getString("ume_tx_nome"));
			 objs.add(ume_unidade_medidaT);
 		 }
 		 return objs; 
 	 }
	 public List<Ume_unidade_medidaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.ume_unidade_medida"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Ume_unidade_medidaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ume_unidade_medidaT> getByPK(Ume_unidade_medidaT ume_unidade_medidaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.ume_unidade_medida where  ume_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ume_unidade_medidaT.getUme_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ume_unidade_medidaT> getByUme_nr_id(Ume_unidade_medidaT ume_unidade_medidaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.ume_unidade_medida where  ume_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, ume_unidade_medidaT.getUme_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Ume_unidade_medidaT> getByUme_tx_nome(Ume_unidade_medidaT ume_unidade_medidaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.ume_unidade_medida where  Upper(ume_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + ume_unidade_medidaT.getUme_tx_nome()+'%' );
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