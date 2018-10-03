package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_maximo_dias_parcela_plcDAO extends ObjectDAO { 
	 public Vw_maximo_dias_parcela_plcDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_maximo_dias_parcela_plc  ( obr_nr_id, ipo_nr_id_super, ipo_nr_id, plco_nr_id, par_nr_id, dias) values ( ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getObr_nr_id());
			 pStmt.setObject(2, vw_maximo_dias_parcela_plcT.getIpo_nr_id_super());
			 pStmt.setObject(3, vw_maximo_dias_parcela_plcT.getIpo_nr_id());
			 pStmt.setObject(4, vw_maximo_dias_parcela_plcT.getPlco_nr_id());
			 pStmt.setObject(5, vw_maximo_dias_parcela_plcT.getPar_nr_id());
			 pStmt.setObject(6, vw_maximo_dias_parcela_plcT.getDias());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_maximo_dias_parcela_plc set  obr_nr_id=?, ipo_nr_id_super=?, ipo_nr_id=?, plco_nr_id=?, par_nr_id=?, dias=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getObr_nr_id());
			 pStmt.setObject(2, vw_maximo_dias_parcela_plcT.getIpo_nr_id_super());
			 pStmt.setObject(3, vw_maximo_dias_parcela_plcT.getIpo_nr_id());
			 pStmt.setObject(4, vw_maximo_dias_parcela_plcT.getPlco_nr_id());
			 pStmt.setObject(5, vw_maximo_dias_parcela_plcT.getPar_nr_id());
			 pStmt.setObject(6, vw_maximo_dias_parcela_plcT.getDias());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_maximo_dias_parcela_plc where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_maximo_dias_parcela_plcT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_maximo_dias_parcela_plcT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();
			 vw_maximo_dias_parcela_plcT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_maximo_dias_parcela_plcT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
			 vw_maximo_dias_parcela_plcT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
			 vw_maximo_dias_parcela_plcT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 vw_maximo_dias_parcela_plcT.setPar_nr_id(rs.getInt("par_nr_id"));
			 vw_maximo_dias_parcela_plcT.setDias(rs.getInt("dias"));
			 objs.add(vw_maximo_dias_parcela_plcT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_maximo_dias_parcela_plcT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Vw_maximo_dias_parcela_plcT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByPK(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where -"; 
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

 	 public List<Vw_maximo_dias_parcela_plcT> getByObr_nr_id(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  obr_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByIpo_nr_id_super(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  ipo_nr_id_super = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getIpo_nr_id_super());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByIpo_nr_id(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  ipo_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getIpo_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByPlco_nr_id(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByPar_nr_id(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  par_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getPar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_maximo_dias_parcela_plcT> getByDias(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_maximo_dias_parcela_plc where  dias = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_maximo_dias_parcela_plcT.getDias());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 
 	 public TreeMap<Integer,Vw_maximo_dias_parcela_plcT> getByObr_nr_idTree(int obra) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select ipo_nr_id_super, max(dias) as dias from easyconstru.vw_maximo_dias_parcela_plc where  obr_nr_id = ? group by 1";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, obra);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransferTree(rs);
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}

 	 private TreeMap<Integer,Vw_maximo_dias_parcela_plcT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
		 TreeMap<Integer,Vw_maximo_dias_parcela_plcT> objs = new TreeMap<Integer,Vw_maximo_dias_parcela_plcT>();
		 while (rs.next()) {
 			 Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT = new Vw_maximo_dias_parcela_plcT();
			 vw_maximo_dias_parcela_plcT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
			 vw_maximo_dias_parcela_plcT.setDias(rs.getInt("dias"));
			 objs.put(vw_maximo_dias_parcela_plcT.getIpo_nr_id_super(),vw_maximo_dias_parcela_plcT);
 		 }
 		 return objs;
 	 }
 

 }