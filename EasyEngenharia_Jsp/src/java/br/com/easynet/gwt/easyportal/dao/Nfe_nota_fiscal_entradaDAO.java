package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Nfe_nota_fiscal_entradaDAO extends ObjectDAO { 
	 public Nfe_nota_fiscal_entradaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.nfe_nota_fiscal_entrada  ( nfe_dt_emissao, for_nr_id, nfe_nr_valor_nota) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
		 java.sql.Date dt1= new java.sql.Date(nfe_nota_fiscal_entradaT.getNfe_dt_emissao().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, nfe_nota_fiscal_entradaT.getFor_nr_id());
			 pStmt.setObject(3, nfe_nota_fiscal_entradaT.getNfe_nr_valor_nota());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.nfe_nota_fiscal_entrada set  nfe_dt_emissao=?, for_nr_id=?, nfe_nr_valor_nota=?  where  nfe_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
		 java.sql.Date dt1= new java.sql.Date(nfe_nota_fiscal_entradaT.getNfe_dt_emissao().getTime());
			 pStmt.setObject(1, dt1);
			 pStmt.setObject(2, nfe_nota_fiscal_entradaT.getFor_nr_id());
			 pStmt.setObject(3, nfe_nota_fiscal_entradaT.getNfe_nr_valor_nota());
			 pStmt.setObject(4, nfe_nota_fiscal_entradaT.getNfe_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.nfe_nota_fiscal_entrada where  nfe_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, nfe_nota_fiscal_entradaT.getNfe_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Nfe_nota_fiscal_entradaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Nfe_nota_fiscal_entradaT> objs = new Vector();
		 while (rs.next()) { 
 			 Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT = new Nfe_nota_fiscal_entradaT();
			 nfe_nota_fiscal_entradaT.setNfe_nr_id(rs.getInt("nfe_nr_id"));
			 nfe_nota_fiscal_entradaT.setNfe_dt_emissao(rs.getDate("nfe_dt_emissao"));
			 nfe_nota_fiscal_entradaT.setFor_nr_id(rs.getInt("for_nr_id"));
			 nfe_nota_fiscal_entradaT.setNfe_nr_valor_nota(rs.getFloat("nfe_nr_valor_nota"));
			 objs.add(nfe_nota_fiscal_entradaT);
 		 }
 		 return objs; 
 	 }
	 public List<Nfe_nota_fiscal_entradaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Nfe_nota_fiscal_entradaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Nfe_nota_fiscal_entradaT> getByPK(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada where  nfe_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, nfe_nota_fiscal_entradaT.getNfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Nfe_nota_fiscal_entradaT> getByNfe_nr_id(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada where  nfe_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, nfe_nota_fiscal_entradaT.getNfe_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Nfe_nota_fiscal_entradaT> getByNfe_dt_emissao(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada where  nfe_dt_emissao = ? "; 
			 pStmt = con.prepareStatement(sql);
		 java.sql.Date dt1= new java.sql.Date(nfe_nota_fiscal_entradaT.getNfe_dt_emissao().getTime());
			 pStmt.setObject(1,dt1);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Nfe_nota_fiscal_entradaT> getByFor_nr_id(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada where  for_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, nfe_nota_fiscal_entradaT.getFor_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Nfe_nota_fiscal_entradaT> getByNfe_nr_valor_nota(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.nfe_nota_fiscal_entrada where  nfe_nr_valor_nota = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, nfe_nota_fiscal_entradaT.getNfe_nr_valor_nota());
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