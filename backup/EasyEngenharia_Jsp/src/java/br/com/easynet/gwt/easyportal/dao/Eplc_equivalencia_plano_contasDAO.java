package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Eplc_equivalencia_plano_contasDAO extends ObjectDAO { 
	 public Eplc_equivalencia_plano_contasDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.eplc_equivalencia_plano_contas  ( plc_nr_id, plco_nr_id) values ( ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlc_nr_id());
			 pStmt.setObject(2, eplc_equivalencia_plano_contasT.getPlco_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.eplc_equivalencia_plano_contas set  plc_nr_id=?, plco_nr_id=?  where  eplc_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlc_nr_id());
			 pStmt.setObject(2, eplc_equivalencia_plano_contasT.getPlco_nr_id());
			 pStmt.setObject(3, eplc_equivalencia_plano_contasT.getEplc_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 
 	 public void updateSubClasse(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT ) throws Exception {
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.eplc_equivalencia_plano_contas set  plc_nr_id=?  where  plco_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlc_nr_id());
			 pStmt.setObject(2, eplc_equivalencia_plano_contasT.getPlco_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try {
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}
 	 public void delete(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.eplc_equivalencia_plano_contas where  eplc_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getEplc_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Eplc_equivalencia_plano_contasT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Eplc_equivalencia_plano_contasT> objs = new Vector();
		 while (rs.next()) { 
 			 Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT = new Eplc_equivalencia_plano_contasT();
			 eplc_equivalencia_plano_contasT.setEplc_nr_id(rs.getInt("eplc_nr_id"));
			 eplc_equivalencia_plano_contasT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 eplc_equivalencia_plano_contasT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 objs.add(eplc_equivalencia_plano_contasT);
 		 }
 		 return objs; 
 	 }
	 public List<Eplc_equivalencia_plano_contasT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Eplc_equivalencia_plano_contasT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Eplc_equivalencia_plano_contasT> getByPK(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas where  eplc_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getEplc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Eplc_equivalencia_plano_contasT> getByEplc_nr_id(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas where  eplc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getEplc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Eplc_equivalencia_plano_contasT> getByPlc_nr_id(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Eplc_equivalencia_plano_contasT> getByPlco_nr_id(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlco_nr_id());
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
	 public List<Eplc_equivalencia_plano_contasT> getByPlco_plano_contas_orcamento(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.eplc_equivalencia_plano_contas where plco_plano_contas_orcamento.plco_nr_id=?  ";
			 pStmt = con.prepareStatement(sql);
		 pStmt.setObject(1, eplc_equivalencia_plano_contasT.getPlco_nr_id());
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