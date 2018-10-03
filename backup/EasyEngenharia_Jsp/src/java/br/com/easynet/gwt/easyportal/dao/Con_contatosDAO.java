package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Con_contatosDAO extends ObjectDAO { 
	 public Con_contatosDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Con_contatosT con_contatosT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.con_contatos  ( cli_nr_id, con_tx_nome, set_nr_id, con_tx_cargo_exercicio, con_tx_telefone, con_tx_telefone2, con_tx_email) values ( ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCli_nr_id());
			 pStmt.setObject(2, con_contatosT.getCon_tx_nome());
			 pStmt.setObject(3, con_contatosT.getSet_nr_id());
			 pStmt.setObject(4, con_contatosT.getCon_tx_cargo_exercicio());
			 pStmt.setObject(5, con_contatosT.getCon_tx_telefone());
			 pStmt.setObject(6, con_contatosT.getCon_tx_telefone2());
			 pStmt.setObject(7, con_contatosT.getCon_tx_email());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Con_contatosT con_contatosT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.con_contatos set  cli_nr_id=?, con_tx_nome=?, set_nr_id=?, con_tx_cargo_exercicio=?, con_tx_telefone=?, con_tx_telefone2=?, con_tx_email=?  where  con_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCli_nr_id());
			 pStmt.setObject(2, con_contatosT.getCon_tx_nome());
			 pStmt.setObject(3, con_contatosT.getSet_nr_id());
			 pStmt.setObject(4, con_contatosT.getCon_tx_cargo_exercicio());
			 pStmt.setObject(5, con_contatosT.getCon_tx_telefone());
			 pStmt.setObject(6, con_contatosT.getCon_tx_telefone2());
			 pStmt.setObject(7, con_contatosT.getCon_tx_email());
			 pStmt.setObject(8, con_contatosT.getCon_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Con_contatosT con_contatosT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.con_contatos where  con_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCon_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Con_contatosT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Con_contatosT> objs = new Vector();
		 while (rs.next()) { 
 			 Con_contatosT con_contatosT = new Con_contatosT();
			 con_contatosT.setCon_nr_id(rs.getInt("con_nr_id"));
			 con_contatosT.setCli_nr_id(rs.getInt("cli_nr_id"));
			 con_contatosT.setCon_tx_nome(rs.getString("con_tx_nome"));
			 con_contatosT.setSet_nr_id(rs.getInt("set_nr_id"));
			 con_contatosT.setCon_tx_cargo_exercicio(rs.getString("con_tx_cargo_exercicio"));
			 con_contatosT.setCon_tx_telefone(rs.getString("con_tx_telefone"));
			 con_contatosT.setCon_tx_telefone2(rs.getString("con_tx_telefone2"));
			 con_contatosT.setCon_tx_email(rs.getString("con_tx_email"));
			 objs.add(con_contatosT);
 		 }
 		 return objs; 
 	 }
	 public List<Con_contatosT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Con_contatosT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByPK(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  con_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCon_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_nr_id(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  con_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCon_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCli_nr_id(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  cli_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getCli_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_tx_nome(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  Upper(con_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + con_contatosT.getCon_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getBySet_nr_id(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  set_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, con_contatosT.getSet_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_tx_cargo_exercicio(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  Upper(con_tx_cargo_exercicio) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + con_contatosT.getCon_tx_cargo_exercicio()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_tx_telefone(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  Upper(con_tx_telefone) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + con_contatosT.getCon_tx_telefone()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_tx_telefone2(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  Upper(con_tx_telefone2) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + con_contatosT.getCon_tx_telefone2()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Con_contatosT> getByCon_tx_email(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where  Upper(con_tx_email) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + con_contatosT.getCon_tx_email()+'%' );
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
	 public List<Con_contatosT> getByCli_cliente(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where cli_cliente.cli_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, con_contatosT.getCli_nr_id());
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
	 public List<Con_contatosT> getBySet_setor(Con_contatosT con_contatosT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.con_contatos where set_setor.set_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, con_contatosT.getSet_nr_id());
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