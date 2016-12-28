package br.com.easynet.gwt.easyportal.client.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.client.transfer.*;

public class Vw_cffo_mesDAO extends ObjectDAO {  
	 public Vw_cffo_mesDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_cffo_mesT vw_cffo_mesT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_cffo_mes  ( obr_nr_id, cffo_nr_mes, cffo_nr_ano, total) values ( ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getObr_nr_id());
			 pStmt.setObject(2, vw_cffo_mesT.getCffo_nr_mes());
			 pStmt.setObject(3, vw_cffo_mesT.getCffo_nr_ano());
			 pStmt.setObject(4, vw_cffo_mesT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_cffo_mesT vw_cffo_mesT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_cffo_mes set  obr_nr_id=?, cffo_nr_mes=?, cffo_nr_ano=?, total=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getObr_nr_id());
			 pStmt.setObject(2, vw_cffo_mesT.getCffo_nr_mes());
			 pStmt.setObject(3, vw_cffo_mesT.getCffo_nr_ano());
			 pStmt.setObject(4, vw_cffo_mesT.getTotal());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_cffo_mesT vw_cffo_mesT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_cffo_mes where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_cffo_mesT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_cffo_mesT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();
			 vw_cffo_mesT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_cffo_mesT.setCffo_nr_mes(rs.getInt("cffo_nr_mes"));
			 vw_cffo_mesT.setCffo_nr_ano(rs.getInt("cffo_nr_ano"));
			 vw_cffo_mesT.setTotal(rs.getFloat("total"));
			 objs.add(vw_cffo_mesT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_cffo_mesT> getAll(Vw_cffo_mesT vw_cffo_mesT) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where obr_nr_id =?";
			 pStmt = con.prepareStatement(sql);
                         pStmt.setObject(1, vw_cffo_mesT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 List<Vw_cffo_mesT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_cffo_mesT> getByPK(Vw_cffo_mesT vw_cffo_mesT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where -"; 
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

 	 public List<Vw_cffo_mesT> getByObr_nr_id(Vw_cffo_mesT vw_cffo_mesT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_cffo_mesT> getByCffo_nr_mes(Vw_cffo_mesT vw_cffo_mesT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where  cffo_nr_mes = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getCffo_nr_mes());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_cffo_mesT> getByCffo_nr_ano(Vw_cffo_mesT vw_cffo_mesT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where  cffo_nr_ano = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getCffo_nr_ano());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_cffo_mesT> getByTotal(Vw_cffo_mesT vw_cffo_mesT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_cffo_mes where  total = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_cffo_mesT.getTotal());
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