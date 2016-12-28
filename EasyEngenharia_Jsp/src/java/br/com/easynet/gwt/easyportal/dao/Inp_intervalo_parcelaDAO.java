package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Inp_intervalo_parcelaDAO extends ObjectDAO { 
	 public Inp_intervalo_parcelaDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Inp_intervalo_parcelaT inp_intervalo_parcelaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.inp_intervalo_parcela  ( par_nr_id, inp_nr_dias, inp_nr_per,inp_nr_sequencia) values ( ? , ? , ? ,?)";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getPar_nr_id());
			 pStmt.setObject(2, inp_intervalo_parcelaT.getInp_nr_dias());
			 pStmt.setObject(3, inp_intervalo_parcelaT.getInp_nr_per());
                         pStmt.setObject(4, inp_intervalo_parcelaT.getInp_nr_sequencia());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Inp_intervalo_parcelaT inp_intervalo_parcelaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.inp_intervalo_parcela set  par_nr_id=?, inp_nr_dias=?, inp_nr_per=?, inp_nr_sequencia=?  where  inp_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getPar_nr_id());
			 pStmt.setObject(2, inp_intervalo_parcelaT.getInp_nr_dias());
			 pStmt.setObject(3, inp_intervalo_parcelaT.getInp_nr_per());
                         pStmt.setObject(4, inp_intervalo_parcelaT.getInp_nr_sequencia());
			 pStmt.setObject(5, inp_intervalo_parcelaT.getInp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Inp_intervalo_parcelaT inp_intervalo_parcelaT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.inp_intervalo_parcela where  inp_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getInp_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 
 	 public void deleteAllParcela(int par_nr_id ) throws Exception {
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.inp_intervalo_parcela where  par_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, par_nr_id);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try {
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}
 	 private List<Inp_intervalo_parcelaT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Inp_intervalo_parcelaT> objs = new Vector();
		 while (rs.next()) { 
 			 Inp_intervalo_parcelaT inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();
			 inp_intervalo_parcelaT.setInp_nr_id(rs.getInt("inp_nr_id"));
			 inp_intervalo_parcelaT.setPar_nr_id(rs.getInt("par_nr_id"));
			 inp_intervalo_parcelaT.setInp_nr_dias(rs.getInt("inp_nr_dias"));
			 inp_intervalo_parcelaT.setInp_nr_per(rs.getFloat("inp_nr_per"));
			 objs.add(inp_intervalo_parcelaT);
 		 }
 		 return objs; 
 	 }
	 public List<Inp_intervalo_parcelaT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela"; 
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Inp_intervalo_parcelaT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Inp_intervalo_parcelaT> getByPK(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela where  inp_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getInp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Inp_intervalo_parcelaT> getByInp_nr_id(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela where  inp_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getInp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Inp_intervalo_parcelaT> getByPar_nr_id(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela where  par_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getPar_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Inp_intervalo_parcelaT> getByInp_nr_dias(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela where  inp_nr_dias = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getInp_nr_dias());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Inp_intervalo_parcelaT> getByInp_nr_per(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela where  inp_nr_per = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, inp_intervalo_parcelaT.getInp_nr_per());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public TreeMap<Integer,List<Inp_intervalo_parcelaT>> getAllTree() throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.inp_intervalo_parcela";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransferTree(rs);
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}

 	 private TreeMap<Integer,List<Inp_intervalo_parcelaT>> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
		 TreeMap<Integer,List<Inp_intervalo_parcelaT>> tree = new TreeMap<Integer, List<Inp_intervalo_parcelaT>>();
		 while (rs.next()) {
 			 Inp_intervalo_parcelaT inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();
			 inp_intervalo_parcelaT.setInp_nr_id(rs.getInt("inp_nr_id"));
			 inp_intervalo_parcelaT.setPar_nr_id(rs.getInt("par_nr_id"));
			 inp_intervalo_parcelaT.setInp_nr_dias(rs.getInt("inp_nr_dias"));
			 inp_intervalo_parcelaT.setInp_nr_per(rs.getFloat("inp_nr_per"));
                         if(tree.get(inp_intervalo_parcelaT.getPar_nr_id())== null){
                             List<Inp_intervalo_parcelaT> listTemp = new Vector();
                             listTemp.add(inp_intervalo_parcelaT);
                            tree.put(inp_intervalo_parcelaT.getPar_nr_id(), listTemp);
                         }else{
                             tree.get(inp_intervalo_parcelaT.getPar_nr_id()).add(inp_intervalo_parcelaT);
                         }
			
 		 }
 		 return tree;
 	 }
 }