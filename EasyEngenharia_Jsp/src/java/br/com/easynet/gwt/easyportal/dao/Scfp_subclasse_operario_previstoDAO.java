package br.com.easynet.gwt.easyportal.dao;


import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.List;
import java.util.Vector;

public class Scfp_subclasse_operario_previstoDAO extends ObjectDAO { 
	 public Scfp_subclasse_operario_previstoDAO(DAOFactory dao) throws Exception {
		 setDAOFactory(dao);
 		 con = dao.create();
 	 }


    public int maxId()throws Exception{
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "select max(scfp_nr_id) as id from easyconstru.scfp_subclasse_operario_previsto";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
            //throw e;
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }

	 public void insert(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "insert into easyconstru.scfp_subclasse_operario_previsto  ( plco_nr_id) values ( ? )";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getPlco_nr_id());
			 pStmt.execute();
                         scfp_subclasse_operario_previstoT.setScfp_nr_id(maxId());
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void update(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "update easyconstru.scfp_subclasse_operario_previsto set  plco_nr_id=?  where  scfp_nr_id=?";
 			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getPlco_nr_id());
			 pStmt.setObject(2, scfp_subclasse_operario_previstoT.getScfp_nr_id());
			 pStmt.execute();
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public void delete(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT ) throws Exception { 
		 PreparedStatement pStmt=null;
		 try {
			 String sql = "delete from easyconstru.scfp_subclasse_operario_previsto where  scfp_nr_id=?";
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getScfp_nr_id());
			 pStmt.execute();
		 } catch (Exception e)  {
 			  throw e;
 		} finally {
 			 try { 
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 private List<Scfp_subclasse_operario_previstoT> resultSetToObjectTransfer(ResultSet rs) throws Exception { 
		 List<Scfp_subclasse_operario_previstoT> objs = new Vector();
		 while (rs.next()) { 
 			 Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT = new Scfp_subclasse_operario_previstoT();
			 scfp_subclasse_operario_previstoT.setScfp_nr_id(rs.getInt("scfp_nr_id"));
			 scfp_subclasse_operario_previstoT.setPlco_nr_id(rs.getInt("plc_nr_id"));
			 objs.add(scfp_subclasse_operario_previstoT);
 		 }
 		 return objs; 
 	 }
	 public DataSet getAll() throws Exception {
                DataSet ds = null;
		 try {
			 String sql = "select sc.scfp_nr_id, plco.plco_tx_nome, sc.plco_nr_id from easyconstru.scfp_subclasse_operario_previsto as sc inner join easyconstru.plco_plano_contas_orcamento as plco on(sc.plco_nr_id=plco.plco_nr_id)";
                         ds = executeQuery(sql, null);
 			 return ds;
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
			  
 		} 
 	} 

 	 public List<Scfp_subclasse_operario_previstoT> getByPK(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.scfp_subclasse_operario_previsto where  scfp_nr_id=?"; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getScfp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 		} 
 	}



 	 public List<Scfp_subclasse_operario_previstoT> getByScfp_nr_id(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.scfp_subclasse_operario_previsto where  scfp_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getScfp_nr_id());
			 rs = pStmt.executeQuery();
 			 return resultSetToObjectTransfer(rs); 
 		 } catch (Exception e) {
 			  throw e;
 		} finally {
 			 try { rs.close();
 			 pStmt.close();} catch (Exception e) {}
 			  
 		} 
 	} 

 	 public List<Scfp_subclasse_operario_previstoT> getByPlc_nr_id(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) throws Exception { 
		 PreparedStatement pStmt=null;
		 ResultSet rs=null;
		 try {
			 String sql = "select * from easyconstru.scfp_subclasse_operario_previsto where  plc_nr_id = ? "; 
			 pStmt = con.prepareStatement(sql);
			 pStmt.setObject(1, scfp_subclasse_operario_previstoT.getPlco_nr_id());
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