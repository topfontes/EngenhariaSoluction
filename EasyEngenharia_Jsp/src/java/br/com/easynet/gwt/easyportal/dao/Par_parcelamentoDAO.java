package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Par_parcelamentoDAO extends ObjectDAO {
    private final Object inserir = "true";
	 public Par_parcelamentoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }
         public int maxId() throws SQLException{
             String sql = "select max(par.par_nr_id) as id from easyconstru.par_parcelamento as par";
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             rs.next();
             return rs.getInt("id");
         }

	 public void insert(Par_parcelamentoT par_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
                     synchronized(inserir){
			 String sql = "insert into easyconstru.par_parcelamento  ( par_tx_nome, par_nr_parcelas, par_nr_intervalo_dias) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_tx_nome());
			 pStmt.setObject(2, par_parcelamentoT.getPar_nr_parcelas());
			 pStmt.setObject(3, par_parcelamentoT.getPar_nr_intervalo_dias());
			 pStmt.execute();
                         par_parcelamentoT.setPar_nr_id(maxId());
                     }
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 		} 
 	} 

 	 public void update(Par_parcelamentoT par_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.par_parcelamento set  par_tx_nome=?, par_nr_parcelas=?, par_nr_intervalo_dias=?  where  par_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_tx_nome());
			 pStmt.setObject(2, par_parcelamentoT.getPar_nr_parcelas());
			 pStmt.setObject(3, par_parcelamentoT.getPar_nr_intervalo_dias());
			 pStmt.setObject(4, par_parcelamentoT.getPar_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Par_parcelamentoT par_parcelamentoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.par_parcelamento where  par_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Par_parcelamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Par_parcelamentoT> objs = new Vector();
		 while (rs.next()) { 
 			 Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();
			 par_parcelamentoT.setPar_nr_id(rs.getInt("par_nr_id"));
			 par_parcelamentoT.setPar_tx_nome(rs.getString("par_tx_nome"));
			 par_parcelamentoT.setPar_nr_parcelas(rs.getInt("par_nr_parcelas"));
			 par_parcelamentoT.setPar_nr_intervalo_dias(rs.getInt("par_nr_intervalo_dias"));
			 objs.add(par_parcelamentoT);
 		 }
 		 return objs; 
 	 }
	 public List<Par_parcelamentoT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Par_parcelamentoT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Par_parcelamentoT> getByPK(Par_parcelamentoT par_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento where  par_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Par_parcelamentoT> getByPar_nr_id(Par_parcelamentoT par_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento where  par_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Par_parcelamentoT> getByPar_tx_nome(Par_parcelamentoT par_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento where  Upper(par_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + par_parcelamentoT.getPar_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Par_parcelamentoT> getByPar_nr_parcelas(Par_parcelamentoT par_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento where  par_nr_parcelas = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_nr_parcelas());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Par_parcelamentoT> getByPar_nr_intervalo_dias(Par_parcelamentoT par_parcelamentoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.par_parcelamento where  par_nr_intervalo_dias = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_parcelamentoT.getPar_nr_intervalo_dias());
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