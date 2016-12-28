package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import javax.print.DocFlavor.STRING;

public class Tet_tmp_equivalencia_treetDAO extends ObjectDAO { 
	 public Tet_tmp_equivalencia_treetDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.tet_tmp_equivalencia_treeT  ( plco_nr_id, plc_nr_id, plco_tx_nome, plc_tx_nome) values ( ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getPlco_nr_id());
			 pStmt.setObject(2, tet_tmp_equivalencia_treetT.getPlc_nr_id());
			 pStmt.setObject(3, tet_tmp_equivalencia_treetT.getPlco_tx_nome());
			 pStmt.setObject(4, tet_tmp_equivalencia_treetT.getPlc_tx_nome());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.tet_tmp_equivalencia_treeT set  plco_nr_id=?, plc_nr_id=?, plco_tx_nome=?, plc_tx_nome=?  where  tet_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getPlco_nr_id());
			 pStmt.setObject(2, tet_tmp_equivalencia_treetT.getPlc_nr_id());
			 pStmt.setObject(3, tet_tmp_equivalencia_treetT.getPlco_tx_nome());
			 pStmt.setObject(4, tet_tmp_equivalencia_treetT.getPlc_tx_nome());
			 pStmt.setObject(5, tet_tmp_equivalencia_treetT.getTet_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.tet_tmp_equivalencia_treeT where  tet_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getTet_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Tet_tmp_equivalencia_treetT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Tet_tmp_equivalencia_treetT> objs = new Vector();
                 int i= 1;
		 while (rs.next()) { 
 			 Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT = new Tet_tmp_equivalencia_treetT();
			 tet_tmp_equivalencia_treetT.setTet_nr_id(i);
			 tet_tmp_equivalencia_treetT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 tet_tmp_equivalencia_treetT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 tet_tmp_equivalencia_treetT.setPlco_tx_nome(rs.getString("plco_tx_nome"));
			 tet_tmp_equivalencia_treetT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
			 objs.add(tet_tmp_equivalencia_treetT);
                         i++;
 		 }
 		 return objs; 
 	 }
	 public List<Tet_tmp_equivalencia_treetT> getAllPlco() throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 StringBuffer sql = new StringBuffer();
                         sql.append("select  equiv.plc_nr_id, plco.plco_nr_id ,plco.plco_tx_nome , plc.plc_tx_nome");
                         sql.append(" from  easyconstru.plco_plano_contas_orcamento as plco");
                         sql.append(" left outer join easyconstru.eplc_equivalencia_plano_contas as equiv on (equiv.plc_nr_id = plco.plco_nr_id)");
                         sql.append(" left outer join easyconstru.plc_plano_contas as plc on (plc.plc_nr_id = equiv.plc_nr_id)");
			 pStmt = con.prepareStatement(sql.toString());
			 rs = pStmt.executeQuery();
 			 List<Tet_tmp_equivalencia_treetT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	}

	 public List<Tet_tmp_equivalencia_treetT> getAllPlc() throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 StringBuffer sql = new StringBuffer();
                         sql.append("select  plc.plc_nr_id, plco.plco_nr_id ,plco.plco_tx_nome , plc.plc_tx_nome");
                         sql.append(" from  easyconstru.plc_plano_contas as plc");
                         sql.append(" left outer join easyconstru.eplc_equivalencia_plano_contas as equiv on (plc.plc_nr_id = equiv.plc_nr_id)");
                         sql.append(" left outer join easyconstru.plco_plano_contas_orcamento as plco on (equiv.plc_nr_id = plco.plco_nr_id)");
			 pStmt = con.prepareStatement(sql.toString());
			 rs = pStmt.executeQuery();
 			 List<Tet_tmp_equivalencia_treetT> list = resultSetToObjectTransfer(rs);
 			 return list;
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}

 		}
 	}

 	 public List<Tet_tmp_equivalencia_treetT> getByPK(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  tet_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getTet_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tet_tmp_equivalencia_treetT> getByTet_nr_id(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  tet_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getTet_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tet_tmp_equivalencia_treetT> getByPlco_nr_id(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  plco_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tet_tmp_equivalencia_treetT> getByPlc_nr_id(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, tet_tmp_equivalencia_treetT.getPlc_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tet_tmp_equivalencia_treetT> getByPlco_tx_nome(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  Upper(plco_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tet_tmp_equivalencia_treetT.getPlco_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Tet_tmp_equivalencia_treetT> getByPlc_tx_nome(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.tet_tmp_equivalencia_treeT where  Upper(plc_tx_nome) like Upper(?) "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + tet_tmp_equivalencia_treetT.getPlc_tx_nome()+'%' );
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