package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Tpms_temporaria_pmsDAO extends ObjectDAO { 
	 public Tpms_temporaria_pmsDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tpms_temporaria_pmsT tpms_temporaria_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.tpms_temporaria_pms  ( plco_nr_id, tpms_nr_quantidade, tpms_bl_servico) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getPlco_nr_id());
			 pStmt.setObject(2, tpms_temporaria_pmsT.getTpms_nr_quantidade());
			 pStmt.setObject(3, tpms_temporaria_pmsT.getTpms_bl_servico());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tpms_temporaria_pmsT tpms_temporaria_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.tpms_temporaria_pms set  plco_nr_id=?, tmps_nr_quantidade=?, tpms_bl_servico=?  where  tmps_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getPlco_nr_id());
			 pStmt.setObject(2, tpms_temporaria_pmsT.getTpms_nr_quantidade());
			 pStmt.setObject(3, tpms_temporaria_pmsT.getTpms_bl_servico());
			 pStmt.setObject(4, tpms_temporaria_pmsT.getTmps_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tpms_temporaria_pmsT tpms_temporaria_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.tpms_temporaria_pms where  tmps_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getTmps_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tpms_temporaria_pmsT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tpms_temporaria_pmsT> objs = new Vector();
		 while (rs.next()) { 
 			 Tpms_temporaria_pmsT tpms_temporaria_pmsT = new Tpms_temporaria_pmsT();
			 tpms_temporaria_pmsT.setTmps_nr_id(rs.getInt("tmps_nr_id"));
			 tpms_temporaria_pmsT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 tpms_temporaria_pmsT.setTmps_nr_quantidade(rs.getDouble("tmps_nr_quantidade"));
			 tpms_temporaria_pmsT.setTpms_bl_servico(rs.getBoolean("tpms_bl_servico"));
			 objs.add(tpms_temporaria_pmsT);
 		 }
 		 return objs; 
 	 }
	 public List<Tpms_temporaria_pmsT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Tpms_temporaria_pmsT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tpms_temporaria_pmsT> getByPK(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms where  tmps_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getTmps_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tpms_temporaria_pmsT> getByTmps_nr_id(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms where  tmps_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getTmps_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tpms_temporaria_pmsT> getByPlco_nr_id(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tpms_temporaria_pmsT> getByTmps_nr_quantidade(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms where  tmps_nr_quantidade = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getTpms_nr_quantidade());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tpms_temporaria_pmsT> getByTpms_bl_servico(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tpms_temporaria_pms where  tpms_bl_servico = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tpms_temporaria_pmsT.getTpms_bl_servico());
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