package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Infe_item_nota_entradaDAO extends ObjectDAO { 
	 public Infe_item_nota_entradaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Infe_item_nota_entradaT infe_item_nota_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.infe_item_nota_entrada  ( infe_nr_quantidade, infe_nr_valor_unit, infe_nr_valor_total, nfe_nr_id, pro_nr_id) values ( ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_quantidade());
			 pStmt.setObject(2, infe_item_nota_entradaT.getInfe_nr_valor_unit());
			 pStmt.setObject(3, infe_item_nota_entradaT.getInfe_nr_valor_total());
			 pStmt.setObject(4, infe_item_nota_entradaT.getNfe_nr_id());
			 pStmt.setObject(5, infe_item_nota_entradaT.getPro_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Infe_item_nota_entradaT infe_item_nota_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.infe_item_nota_entrada set  infe_nr_quantidade=?, infe_nr_valor_unit=?, infe_nr_valor_total=?, nfe_nr_id=?, pro_nr_id=?  where  infe_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_quantidade());
			 pStmt.setObject(2, infe_item_nota_entradaT.getInfe_nr_valor_unit());
			 pStmt.setObject(3, infe_item_nota_entradaT.getInfe_nr_valor_total());
			 pStmt.setObject(4, infe_item_nota_entradaT.getNfe_nr_id());
			 pStmt.setObject(5, infe_item_nota_entradaT.getPro_nr_id());
			 pStmt.setObject(6, infe_item_nota_entradaT.getInfe_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Infe_item_nota_entradaT infe_item_nota_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.infe_item_nota_entrada where  infe_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Infe_item_nota_entradaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Infe_item_nota_entradaT> objs = new Vector();
		 while (rs.next()) { 
 			 Infe_item_nota_entradaT infe_item_nota_entradaT = new Infe_item_nota_entradaT();
			 infe_item_nota_entradaT.setInfe_nr_id(rs.getInt("infe_nr_id"));
			 infe_item_nota_entradaT.setInfe_nr_quantidade(rs.getFloat("infe_nr_quantidade"));
			 infe_item_nota_entradaT.setInfe_nr_valor_unit(rs.getFloat("infe_nr_valor_unit"));
			 infe_item_nota_entradaT.setInfe_nr_valor_total(rs.getFloat("infe_nr_valor_total"));
			 infe_item_nota_entradaT.setNfe_nr_id(rs.getInt("nfe_nr_id"));
			 infe_item_nota_entradaT.setPro_nr_id(rs.getInt("pro_nr_id"));
			 objs.add(infe_item_nota_entradaT);
 		 }
 		 return objs; 
 	 }
	 public List<Infe_item_nota_entradaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Infe_item_nota_entradaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByPK(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  infe_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByInfe_nr_id(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  infe_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByInfe_nr_quantidade(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  infe_nr_quantidade = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_quantidade());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByInfe_nr_valor_unit(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  infe_nr_valor_unit = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_valor_unit());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByInfe_nr_valor_total(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  infe_nr_valor_total = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getInfe_nr_valor_total());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByNfe_nr_id(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  nfe_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getNfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Infe_item_nota_entradaT> getByPro_nr_id(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where  pro_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, infe_item_nota_entradaT.getPro_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
	/** Metodos FK */
	 public List<Infe_item_nota_entradaT> getByNfe_nota_fiscal_entrada(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where nfe_nota_fiscal_entrada.nfe_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, infe_item_nota_entradaT.getNfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	/** Metodos FK */
	 public List<Infe_item_nota_entradaT> getByPro_produto(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.infe_item_nota_entrada where pro_produto.pro_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, infe_item_nota_entradaT.getPro_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 
 }