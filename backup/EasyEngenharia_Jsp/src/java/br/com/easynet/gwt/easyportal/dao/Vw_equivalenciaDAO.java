package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_equivalenciaDAO extends ObjectDAO { 
	 public Vw_equivalenciaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_equivalenciaT vw_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_equivalencia  ( eplc_nr_id, plc_nr_id, plco_nr_id, plco_tx_nome, plc_tx_nome, plco_tx_tipo, plco_tx_cod_externo, plco_tx_unidade) values ( ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equivalenciaT.getEplc_nr_id());
			 pStmt.setObject(2, vw_equivalenciaT.getPlc_nr_id());
			 pStmt.setObject(3, vw_equivalenciaT.getPlco_nr_id());
			 pStmt.setObject(4, vw_equivalenciaT.getPlco_tx_nome());
			 pStmt.setObject(5, vw_equivalenciaT.getPlc_tx_nome());
			 pStmt.setObject(6, vw_equivalenciaT.getPlco_tx_tipo());
			 pStmt.setObject(7, vw_equivalenciaT.getPlco_tx_cod_externo());
			 pStmt.setObject(8, vw_equivalenciaT.getPlco_tx_unidade());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_equivalenciaT vw_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_equivalencia set  eplc_nr_id=?, plc_nr_id=?, plco_nr_id=?, plco_tx_nome=?, plc_tx_nome=?, plco_tx_tipo=?, plco_tx_cod_externo=?, plco_tx_unidade=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equivalenciaT.getEplc_nr_id());
			 pStmt.setObject(2, vw_equivalenciaT.getPlc_nr_id());
			 pStmt.setObject(3, vw_equivalenciaT.getPlco_nr_id());
			 pStmt.setObject(4, vw_equivalenciaT.getPlco_tx_nome());
			 pStmt.setObject(5, vw_equivalenciaT.getPlc_tx_nome());
			 pStmt.setObject(6, vw_equivalenciaT.getPlco_tx_tipo());
			 pStmt.setObject(7, vw_equivalenciaT.getPlco_tx_cod_externo());
			 pStmt.setObject(8, vw_equivalenciaT.getPlco_tx_unidade());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_equivalenciaT vw_equivalenciaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_equivalencia where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_equivalenciaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_equivalenciaT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_equivalenciaT vw_equivalenciaT = new Vw_equivalenciaT();
			 vw_equivalenciaT.setEplc_nr_id(rs.getInt("eplc_nr_id"));
			 vw_equivalenciaT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 vw_equivalenciaT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 vw_equivalenciaT.setPlco_tx_nome(rs.getString("plco_tx_nome"));
			 vw_equivalenciaT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
			 vw_equivalenciaT.setPlco_tx_tipo(rs.getString("plco_tx_tipo"));
			 vw_equivalenciaT.setPlco_tx_cod_externo(rs.getString("plco_tx_cod_externo"));
			 vw_equivalenciaT.setPlco_tx_unidade(rs.getString("plco_tx_unidade"));
			 objs.add(vw_equivalenciaT);
 		 }
 		 return objs; 
 	 }
         
	 public List<Vw_equivalenciaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia order by plc_tx_nome";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Vw_equivalenciaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPK(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where -"; 
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

 	 public List<Vw_equivalenciaT> getByEplc_nr_id(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  eplc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equivalenciaT.getEplc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlc_nr_id(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equivalenciaT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlco_nr_id(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equivalenciaT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlco_tx_nome(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  Upper(plco_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equivalenciaT.getPlco_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlc_tx_nome(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  Upper(plc_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equivalenciaT.getPlc_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlco_tx_tipo(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  Upper(plco_tx_tipo) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equivalenciaT.getPlco_tx_tipo()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlco_tx_cod_externo(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  Upper(plco_tx_cod_externo) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equivalenciaT.getPlco_tx_cod_externo()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equivalenciaT> getByPlco_tx_unidade(Vw_equivalenciaT vw_equivalenciaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equivalencia where  Upper(plco_tx_unidade) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equivalenciaT.getPlco_tx_unidade()+'%' );
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