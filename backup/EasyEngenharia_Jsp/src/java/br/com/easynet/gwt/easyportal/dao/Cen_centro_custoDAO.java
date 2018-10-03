package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Cen_centro_custoDAO extends ObjectDAO { 
	 public Cen_centro_custoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.cen_centro_custo  ( cen_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 		} 
 	} 

 	 public void update(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.cen_centro_custo set  cen_tx_nome=?  where  cen_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_tx_nome());
			 pStmt.setObject(2, cen_centro_custoT.getCen_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Cen_centro_custoT cen_centro_custoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.cen_centro_custo where  cen_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Cen_centro_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Cen_centro_custoT> objs = new Vector();
		 while (rs.next()) { 
 			 Cen_centro_custoT cen_centro_custoT = new Cen_centro_custoT();
			 cen_centro_custoT.setCen_nr_id(rs.getInt("cen_nr_id"));
			 cen_centro_custoT.setCen_tx_nome(rs.getString("cen_tx_nome"));
			 objs.add(cen_centro_custoT);
 		 }
 		 return objs; 
 	 }
	 public List<Cen_centro_custoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.cen_centro_custo order by cen_tx_nome";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Cen_centro_custoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByPK(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.cen_centro_custo where  cen_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByCen_nr_id(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.cen_centro_custo where  cen_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, cen_centro_custoT.getCen_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Cen_centro_custoT> getByCen_tx_nome(Cen_centro_custoT cen_centro_custoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.cen_centro_custo where  Upper(cen_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + cen_centro_custoT.getCen_tx_nome()+'%' );
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