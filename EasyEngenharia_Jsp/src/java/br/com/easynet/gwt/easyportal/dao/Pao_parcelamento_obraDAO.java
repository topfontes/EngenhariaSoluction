package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Pao_parcelamento_obraDAO extends ObjectDAO { 
	 public Pao_parcelamento_obraDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Pao_parcelamento_obraT pao_parcelamento_obraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.pao_parcelamento_obra  ( obr_nr_id, par_nr_id, plc_nr_id) values ( ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getObr_nr_id());
			 pStmt.setObject(2, pao_parcelamento_obraT.getPar_nr_id());
			 pStmt.setObject(3, pao_parcelamento_obraT.getPlc_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Pao_parcelamento_obraT pao_parcelamento_obraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.pao_parcelamento_obra set  obr_nr_id=?, par_nr_id=?, plc_nr_id=?  where  pao_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getObr_nr_id());
			 pStmt.setObject(2, pao_parcelamento_obraT.getPar_nr_id());
			 pStmt.setObject(3, pao_parcelamento_obraT.getPlc_nr_id());
			 pStmt.setObject(4, pao_parcelamento_obraT.getPao_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Pao_parcelamento_obraT pao_parcelamento_obraT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.pao_parcelamento_obra where  pao_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getPao_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Pao_parcelamento_obraT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Pao_parcelamento_obraT> objs = new Vector();
		 while (rs.next()) { 
 			 Pao_parcelamento_obraT pao_parcelamento_obraT = new Pao_parcelamento_obraT();
			 pao_parcelamento_obraT.setPao_nr_id(rs.getInt("pao_nr_id"));
			 pao_parcelamento_obraT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 pao_parcelamento_obraT.setPar_nr_id(rs.getInt("par_nr_id"));
			 pao_parcelamento_obraT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 objs.add(pao_parcelamento_obraT);
 		 }
 		 return objs; 
 	 }
	 public List<Pao_parcelamento_obraT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Pao_parcelamento_obraT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pao_parcelamento_obraT> getByPK(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra where  pao_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getPao_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pao_parcelamento_obraT> getByPao_nr_id(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra where  pao_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getPao_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pao_parcelamento_obraT> getByObr_nr_id(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pao_parcelamento_obraT> getByPar_nr_id(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra where  par_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getPar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Pao_parcelamento_obraT> getByPlc_nr_id(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.pao_parcelamento_obra where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, pao_parcelamento_obraT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public TreeMap<Integer,Pao_parcelamento_obraT> getByObr_nr_idTree(int id_obra) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select par_obra.obr_nr_id, par_obra.plc_nr_id, par_Obra.par_nr_id, par.par_nr_intervalo_dias, par.par_nr_parcelas from easyconstru.pao_parcelamento_obra par_Obra inner join easyconstru.par_parcelamento par on(par.par_nr_id = par_obra.par_nr_id) where  obr_nr_id = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, id_obra);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransferTree(rs);
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 		}
 	}
         
 	 private TreeMap<Integer,Pao_parcelamento_obraT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
		 TreeMap<Integer,Pao_parcelamento_obraT> treeMap = new TreeMap<Integer, Pao_parcelamento_obraT>();
		 while (rs.next()) {
 			 Pao_parcelamento_obraT pao_parcelamento_obraT = new Pao_parcelamento_obraT();
			 pao_parcelamento_obraT.setPar_nr_intervalo_dias(rs.getInt("par_nr_intervalo_dias"));
                         pao_parcelamento_obraT.setPar_nr_parcelas(rs.getInt("par_nr_parcelas"));
			 pao_parcelamento_obraT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 pao_parcelamento_obraT.setPar_nr_id(rs.getInt("par_nr_id"));
			 pao_parcelamento_obraT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 treeMap.put(pao_parcelamento_obraT.getPlc_nr_id(), pao_parcelamento_obraT);
 		 }
 		 return treeMap;
 	 }
 }