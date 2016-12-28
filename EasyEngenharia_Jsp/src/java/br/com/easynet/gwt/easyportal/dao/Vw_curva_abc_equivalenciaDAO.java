package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_curva_abc_equivalenciaDAO extends ObjectDAO { 
	 public Vw_curva_abc_equivalenciaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_curva_abc_equivalencia  ( obr_nr_id, plc_nr_id, plc_tx_nome, total) values ( ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abc_equivalenciaT.getObr_nr_id());
			 pStmt.setObject(2, vw_curva_abc_equivalenciaT.getPlc_nr_id());
			 pStmt.setObject(3, vw_curva_abc_equivalenciaT.getPlc_tx_nome());
			 pStmt.setObject(4, vw_curva_abc_equivalenciaT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_curva_abc_equivalencia set  obr_nr_id=?, plc_nr_id=?, plc_tx_nome=?, total=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abc_equivalenciaT.getObr_nr_id());
			 pStmt.setObject(2, vw_curva_abc_equivalenciaT.getPlc_nr_id());
			 pStmt.setObject(3, vw_curva_abc_equivalenciaT.getPlc_tx_nome());
			 pStmt.setObject(4, vw_curva_abc_equivalenciaT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_curva_abc_equivalencia where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_curva_abc_equivalenciaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_curva_abc_equivalenciaT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT = new Vw_curva_abc_equivalenciaT();
			 vw_curva_abc_equivalenciaT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_curva_abc_equivalenciaT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 vw_curva_abc_equivalenciaT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
			 vw_curva_abc_equivalenciaT.setTotal(rs.getFloat("total"));
			 objs.add(vw_curva_abc_equivalenciaT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_curva_abc_equivalenciaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Vw_curva_abc_equivalenciaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abc_equivalenciaT> getByPK(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia where -"; 
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

 	 public List<Vw_curva_abc_equivalenciaT> getByObr_nr_id(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abc_equivalenciaT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abc_equivalenciaT> getByPlc_nr_id(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abc_equivalenciaT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abc_equivalenciaT> getByPlc_tx_nome(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia where  Upper(plc_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_curva_abc_equivalenciaT.getPlc_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_curva_abc_equivalenciaT> getByTotal(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_curva_abc_equivalencia where  total = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_curva_abc_equivalenciaT.getTotal());
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