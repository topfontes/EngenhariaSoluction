package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_equiv_insumo_pmsDAO extends ObjectDAO { 
	 public Vw_equiv_insumo_pmsDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }

	 public void insert(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.vw_equiv_insumo_pms  ( obr_nr_id, plc_nr_id, plc_tx_nome, insumo, ipo_nr_vl_unitario, pms_nr_mes, pms_nr_ano, plco_nr_id, perc, vl_total, vl_executado) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getObr_nr_id());
			 pStmt.setObject(2, vw_equiv_insumo_pmsT.getPlc_nr_id());
			 pStmt.setObject(3, vw_equiv_insumo_pmsT.getPlc_tx_nome());
			 pStmt.setObject(4, vw_equiv_insumo_pmsT.getInsumo());
			 pStmt.setObject(5, vw_equiv_insumo_pmsT.getIpo_nr_vl_unitario());
			 pStmt.setObject(6, vw_equiv_insumo_pmsT.getPms_nr_mes());
			 pStmt.setObject(7, vw_equiv_insumo_pmsT.getPms_nr_ano());
			 pStmt.setObject(8, vw_equiv_insumo_pmsT.getPlco_nr_id());
			 pStmt.setObject(9, vw_equiv_insumo_pmsT.getPerc());
			 pStmt.setObject(10, vw_equiv_insumo_pmsT.getVl_total());
			 pStmt.setObject(11, vw_equiv_insumo_pmsT.getVl_executado());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.vw_equiv_insumo_pms set  obr_nr_id=?, plc_nr_id=?, plc_tx_nome=?, insumo=?, ipo_nr_vl_unitario=?, pms_nr_mes=?, pms_nr_ano=?, plco_nr_id=?, perc=?, vl_total=?, vl_executado=?  where -";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getObr_nr_id());
			 pStmt.setObject(2, vw_equiv_insumo_pmsT.getPlc_nr_id());
			 pStmt.setObject(3, vw_equiv_insumo_pmsT.getPlc_tx_nome());
			 pStmt.setObject(4, vw_equiv_insumo_pmsT.getInsumo());
			 pStmt.setObject(5, vw_equiv_insumo_pmsT.getIpo_nr_vl_unitario());
			 pStmt.setObject(6, vw_equiv_insumo_pmsT.getPms_nr_mes());
			 pStmt.setObject(7, vw_equiv_insumo_pmsT.getPms_nr_ano());
			 pStmt.setObject(8, vw_equiv_insumo_pmsT.getPlco_nr_id());
			 pStmt.setObject(9, vw_equiv_insumo_pmsT.getPerc());
			 pStmt.setObject(10, vw_equiv_insumo_pmsT.getVl_total());
			 pStmt.setObject(11, vw_equiv_insumo_pmsT.getVl_executado());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.vw_equiv_insumo_pms where -";
			 pStmt = con.prepareStatement(sql);
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Vw_equiv_insumo_pmsT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Vw_equiv_insumo_pmsT> objs = new Vector();
		 while (rs.next()) { 
 			 Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT = new Vw_equiv_insumo_pmsT();
			 vw_equiv_insumo_pmsT.setObr_nr_id(rs.getInt("obr_nr_id"));
			 vw_equiv_insumo_pmsT.setPlc_nr_id(rs.getInt("plc_nr_id"));
			 vw_equiv_insumo_pmsT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
			 vw_equiv_insumo_pmsT.setInsumo(rs.getString("insumo"));
			 vw_equiv_insumo_pmsT.setIpo_nr_vl_unitario(rs.getFloat("ipo_nr_vl_unitario"));
			 vw_equiv_insumo_pmsT.setPms_nr_mes(rs.getInt("pms_nr_mes"));
			 vw_equiv_insumo_pmsT.setPms_nr_ano(rs.getInt("pms_nr_ano"));
			 vw_equiv_insumo_pmsT.setPlco_nr_id(rs.getInt("plco_nr_id"));
			 vw_equiv_insumo_pmsT.setVl_executado(rs.getFloat("vl_executado"));
			 objs.add(vw_equiv_insumo_pmsT);
 		 }
 		 return objs; 
 	 }
	 public List<Vw_equiv_insumo_pmsT> getAll() throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms";
			 pStmt = con.prepareStatement(sql);
			 rs = pStmt.executeQuery();
 			 List<Vw_equiv_insumo_pmsT> list = resultSetToObjectTransfer(rs);
 			 return list; 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPK(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where -";
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

 	 public List<Vw_equiv_insumo_pmsT> getByObr_nr_id(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  obr_nr_id = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getObr_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPlc_nr_id(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT, boolean acumulado) throws Exception {
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
                     if(! acumulado){
			 String sql = "select obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id,sum(vl_executado)as vl_executado from easyconstru.vw_equiv_insumo_pms where obr_nr_id=? and  plc_nr_id = ? and pms_nr_mes =? and pms_nr_ano=? group by obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id order by plc_tx_nome,insumo";
			 pStmt = con.prepareStatement(sql);
                         pStmt.setObject(1, vw_equiv_insumo_pmsT.getObr_nr_id());
			 pStmt.setObject(2, vw_equiv_insumo_pmsT.getPlc_nr_id());
                         pStmt.setObject(3, vw_equiv_insumo_pmsT.getPms_nr_mes());
                         pStmt.setObject(4, vw_equiv_insumo_pmsT.getPms_nr_ano());
                     }else{
			 String sql = "select obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id,sum(vl_executado)as vl_executado from easyconstru.vw_equiv_insumo_pms where obr_nr_id=? and plc_nr_id=? and  (pms_nr_mes <=? and pms_nr_ano =? or pms_nr_ano <?) group by obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id order by plc_tx_nome,insumo";
			 pStmt = con.prepareStatement(sql);
                         pStmt.setObject(1, vw_equiv_insumo_pmsT.getObr_nr_id());
			 pStmt.setObject(2, vw_equiv_insumo_pmsT.getPlc_nr_id());
                         pStmt.setObject(3, vw_equiv_insumo_pmsT.getPms_nr_mes());
                         pStmt.setObject(4, vw_equiv_insumo_pmsT.getPms_nr_ano());
                         pStmt.setObject(5, vw_equiv_insumo_pmsT.getPms_nr_ano());
                     }

			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 



 	 public List<Vw_equiv_insumo_pmsT> getByPlc_tx_nome(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  Upper(plc_tx_nome) like Upper(?) ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equiv_insumo_pmsT.getPlc_tx_nome()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByInsumo(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  Upper(insumo) like Upper(?) ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, '%' + vw_equiv_insumo_pmsT.getInsumo()+'%' );
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByIpo_nr_vl_unitario(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  ipo_nr_vl_unitario = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getIpo_nr_vl_unitario());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPms_nr_mes(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  pms_nr_mes = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getPms_nr_mes());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPms_nr_ano(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  pms_nr_ano = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getPms_nr_ano());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPlco_nr_id(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  plco_nr_id = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getPlco_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByPerc(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  perc = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getPerc());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByVl_total(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  vl_total = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getVl_total());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Vw_equiv_insumo_pmsT> getByVl_executado(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.vw_equiv_insumo_pms where  vl_executado = ? ";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, vw_equiv_insumo_pmsT.getVl_executado());
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