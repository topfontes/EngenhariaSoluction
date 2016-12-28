package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_comprometimentoDAO extends ObjectDAO { 
	 public Vw_comprometimentoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_comprometimentoT vw_comprometimentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_comprometimento  ( obr_nr_id, com_nr_mes, com_nr_ano, plc_nr_id, plc_tx_nome, com_nr_valor) values ( ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getObr_nr_id());
			 pStmt.setObject(2, vw_comprometimentoT.getCom_nr_mes());
			 pStmt.setObject(3, vw_comprometimentoT.getCom_nr_ano());
			 pStmt.setObject(4, vw_comprometimentoT.getPlc_nr_id());
			 pStmt.setObject(5, vw_comprometimentoT.getPlc_tx_nome());
			 pStmt.setObject(6, vw_comprometimentoT.getCom_nr_valor());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_comprometimentoT vw_comprometimentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_comprometimento set  obr_nr_id=?, com_nr_mes=?, com_nr_ano=?, plc_nr_id=?, plc_tx_nome=?, com_nr_valor=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getObr_nr_id());
			 pStmt.setObject(2, vw_comprometimentoT.getCom_nr_mes());
			 pStmt.setObject(3, vw_comprometimentoT.getCom_nr_ano());
			 pStmt.setObject(4, vw_comprometimentoT.getPlc_nr_id());
			 pStmt.setObject(5, vw_comprometimentoT.getPlc_tx_nome());
			 pStmt.setObject(6, vw_comprometimentoT.getCom_nr_valor());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_comprometimentoT vw_comprometimentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_comprometimento where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_comprometimentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_comprometimentoT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_comprometimentoT vw_comprometimentoT = new Vw_comprometimentoT();
                         vw_comprometimentoT.setCom_nr_id(rs.getInt("com_nr_id"));
			 vw_comprometimentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_comprometimentoT.setCom_nr_mes(rs.getInt("com_nr_mes"));
			 vw_comprometimentoT.setCom_nr_ano(rs.getInt("com_nr_ano"));
			 vw_comprometimentoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 vw_comprometimentoT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
                         vw_comprometimentoT.setPlc_tx_nome_super(rs.getString("plc_tx_nome_super"));
			 vw_comprometimentoT.setCom_nr_valor(rs.getDouble("com_nr_valor"));
			 objs.add(vw_comprometimentoT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_comprometimentoT> getAll(Vw_comprometimentoT vw_comprometimentoT, boolean previsto) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where obr_nr_id =? and com_nr_mes=? and com_nr_ano=? and previsto=?";
			 pStmt = con.prepareStatement(sql);
                         pStmt.setObject(1, vw_comprometimentoT.getObr_nr_id());
                         pStmt.setObject(2, vw_comprometimentoT.getCom_nr_mes());
                         pStmt.setObject(3, vw_comprometimentoT.getCom_nr_ano());
                         pStmt.setObject(4, previsto);
			 rs = pStmt.executeQuery();
 			 List<Vw_comprometimentoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_comprometimentoT> getByPK(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where -"; 
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

 	 public List<Vw_comprometimentoT> getByObr_nr_id(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_comprometimentoT> getByCom_nr_mes(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  com_nr_mes = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getCom_nr_mes());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_comprometimentoT> getByCom_nr_ano(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  com_nr_ano = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getCom_nr_ano());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	}

 	 public List<Vw_comprometimentoT> getByCom_nr_id(Vw_comprometimentoT vw_comprometimentoT) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  com_nr_id = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getCom_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs);
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}

 	 public List<Vw_comprometimentoT> getByPlc_nr_id(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_comprometimentoT> getByPlc_tx_nome(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  Upper(plc_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_comprometimentoT.getPlc_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_comprometimentoT> getByCom_nr_valor(Vw_comprometimentoT vw_comprometimentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_comprometimento where  com_nr_valor = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_comprometimentoT.getCom_nr_valor());
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