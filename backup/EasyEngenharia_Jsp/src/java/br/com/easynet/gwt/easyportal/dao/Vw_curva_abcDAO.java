package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_curva_abcDAO extends ObjectDAO { 
	 public Vw_curva_abcDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_curva_abcT vw_curva_abcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_curva_abc  ( obr_nr_id, obr_tx_nome, plco_nr_id, plco_tx_nome, total) values ( ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abcT.getObr_nr_id());
			 pStmt.setObject(2, vw_curva_abcT.getObr_tx_nome());
			 pStmt.setObject(3, vw_curva_abcT.getPlco_nr_id());
			 pStmt.setObject(4, vw_curva_abcT.getPlco_tx_nome());
			 pStmt.setObject(5, vw_curva_abcT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_curva_abcT vw_curva_abcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_curva_abc set  obr_nr_id=?, obr_tx_nome=?, plco_nr_id=?, plco_tx_nome=?, total=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abcT.getObr_nr_id());
			 pStmt.setObject(2, vw_curva_abcT.getObr_tx_nome());
			 pStmt.setObject(3, vw_curva_abcT.getPlco_nr_id());
			 pStmt.setObject(4, vw_curva_abcT.getPlco_tx_nome());
			 pStmt.setObject(5, vw_curva_abcT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_curva_abcT vw_curva_abcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_curva_abc where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_curva_abcT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_curva_abcT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_curva_abcT vw_curva_abcT = new Vw_curva_abcT();
			 vw_curva_abcT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_curva_abcT.setObr_tx_nome(rs.getString("obr_tx_nome"));
			 vw_curva_abcT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 vw_curva_abcT.setPlco_tx_nome(rs.getString("plco_tx_nome"));
			 vw_curva_abcT.setTotal(rs.getFloat("total"));
			 objs.add(vw_curva_abcT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_curva_abcT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Vw_curva_abcT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByPK(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where -"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByObr_nr_id(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abcT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByObr_tx_nome(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where  Upper(obr_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_curva_abcT.getObr_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByPlco_nr_id(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abcT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByPlco_tx_nome(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where  Upper(plco_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_curva_abcT.getPlco_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abcT> getByTotal(Vw_curva_abcT vw_curva_abcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc where  total = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abcT.getTotal());
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