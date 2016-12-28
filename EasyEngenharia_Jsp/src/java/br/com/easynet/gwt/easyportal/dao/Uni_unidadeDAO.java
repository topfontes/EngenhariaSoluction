package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Uni_unidadeDAO extends ObjectDAO { 
	 public Uni_unidadeDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Uni_unidadeT uni_unidadeT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.uni_unidade  ( uni_tx_nome) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, uni_unidadeT.getUni_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Uni_unidadeT uni_unidadeT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.uni_unidade set  uni_tx_nome=?  where  uni_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, uni_unidadeT.getUni_tx_nome());
			 pStmt.setObject(2, uni_unidadeT.getUni_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Uni_unidadeT uni_unidadeT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.uni_unidade where  uni_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, uni_unidadeT.getUni_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Uni_unidadeT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Uni_unidadeT> objs = new Vector();
		 while (rs.next()) { 
 			 Uni_unidadeT uni_unidadeT = new Uni_unidadeT();
			 uni_unidadeT.setUni_nr_id(rs.getInt("uni_nr_id"));
			 uni_unidadeT.setUni_tx_nome(rs.getString("uni_tx_nome"));
			 objs.add(uni_unidadeT);
 		 }
 		 return objs; 
 	 }
	 public List<Uni_unidadeT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.uni_unidade order by uni_tx_nome";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Uni_unidadeT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Uni_unidadeT> getByPK(Uni_unidadeT uni_unidadeT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.uni_unidade where  uni_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, uni_unidadeT.getUni_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Uni_unidadeT> getByUni_nr_id(Uni_unidadeT uni_unidadeT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.uni_unidade where  uni_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, uni_unidadeT.getUni_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Uni_unidadeT> getByUni_tx_nome(Uni_unidadeT uni_unidadeT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.uni_unidade where  Upper(uni_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + uni_unidadeT.getUni_tx_nome()+'%' );
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