package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Pes_pessoaDAO extends ObjectDAO { 
	 public Pes_pessoaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Pes_pessoaT pes_pessoaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.pes_pessoa  ( pes_tx_nome, pes_tx_fone) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pes_pessoaT.getPes_tx_nome());
			 pStmt.setObject(2, pes_pessoaT.getPes_tx_fone());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Pes_pessoaT pes_pessoaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.pes_pessoa set  pes_tx_nome=?, pes_tx_fone=?  where  pes_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pes_pessoaT.getPes_tx_nome());
			 pStmt.setObject(2, pes_pessoaT.getPes_tx_fone());
			 pStmt.setObject(3, pes_pessoaT.getPes_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Pes_pessoaT pes_pessoaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.pes_pessoa where  pes_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pes_pessoaT.getPes_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Pes_pessoaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Pes_pessoaT> objs = new Vector();
		 while (rs.next()) { 
 			 Pes_pessoaT pes_pessoaT = new Pes_pessoaT();
			 pes_pessoaT.setPes_nr_id(rs.getInt("pes_nr_id"));
			 pes_pessoaT.setPes_tx_nome(rs.getString("pes_tx_nome"));
			 pes_pessoaT.setPes_tx_fone(rs.getString("pes_tx_fone"));
			 objs.add(pes_pessoaT);
 		 }
 		 return objs; 
 	 }
	 public List<Pes_pessoaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pes_pessoa"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Pes_pessoaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pes_pessoaT> getByPK(Pes_pessoaT pes_pessoaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pes_pessoa where  pes_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pes_pessoaT.getPes_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pes_pessoaT> getByPes_nr_id(Pes_pessoaT pes_pessoaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pes_pessoa where  pes_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pes_pessoaT.getPes_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pes_pessoaT> getByPes_tx_nome(Pes_pessoaT pes_pessoaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pes_pessoa where  Upper(pes_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + pes_pessoaT.getPes_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pes_pessoaT> getByPes_tx_fone(Pes_pessoaT pes_pessoaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pes_pessoa where  Upper(pes_tx_fone) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + pes_pessoaT.getPes_tx_fone()+'%' );
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