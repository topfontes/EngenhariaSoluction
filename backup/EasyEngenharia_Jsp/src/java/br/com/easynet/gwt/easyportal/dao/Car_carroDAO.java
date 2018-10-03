package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Car_carroDAO extends ObjectDAO { 
	 public Car_carroDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Car_carroT car_carroT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.car_carro  ( car_tx_nome, car_tx_marca) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, car_carroT.getCar_tx_nome());
			 pStmt.setObject(2, car_carroT.getCar_tx_marca());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {} 			  
 		} 
 	} 

 	 public void update(Car_carroT car_carroT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.car_carro set  car_tx_nome=?, car_tx_marca=?  where  car_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, car_carroT.getCar_tx_nome());
			 pStmt.setObject(2, car_carroT.getCar_tx_marca());
			 pStmt.setObject(3, car_carroT.getCar_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Car_carroT car_carroT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.car_carro where  car_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, car_carroT.getCar_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Car_carroT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Car_carroT> objs = new Vector();
		 while (rs.next()) { 
 			 Car_carroT car_carroT = new Car_carroT();
			 car_carroT.setCar_nr_id(rs.getInt("car_nr_id"));
			 car_carroT.setCar_tx_nome(rs.getString("car_tx_nome"));
			 car_carroT.setCar_tx_marca(rs.getString("car_tx_marca"));
			 objs.add(car_carroT);
 		 }
 		 return objs; 
 	 }
	 public List<Car_carroT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.car_carro"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Car_carroT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Car_carroT> getByPK(Car_carroT car_carroT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.car_carro where  car_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, car_carroT.getCar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Car_carroT> getByCar_nr_id(Car_carroT car_carroT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.car_carro where  car_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, car_carroT.getCar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Car_carroT> getByCar_tx_nome(Car_carroT car_carroT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.car_carro where  Upper(car_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + car_carroT.getCar_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Car_carroT> getByCar_tx_marca(Car_carroT car_carroT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.car_carro where  Upper(car_tx_marca) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + car_carroT.getCar_tx_marca()+'%' );
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