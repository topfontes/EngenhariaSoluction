package br.com.easynet.gwt.easyportal.bl;
import br.com.easynet.bl.BusinessBase;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.List;
import javax.sql.DataSource;



public class SystemBusinessBase_1 extends BusinessBase {


  private int typeDatabase = DAOFactory.POSTGRESQL;
  private String url  = "jdbc:postgresql://127.0.0.1:5432/dbengenharia";
  private String user = "postgres";
  private String pass = "postgres";

  private DAOFactory dao;

  private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";

  public DAOFactory getDAO() throws Exception {
    if (dao != null) {
      return dao;
    }
    return getDAO(typeDatabase, url, user, pass);
  }	 

  public DAOFactory getDAODataSource() throws Exception {

    DataSource ds = getDataSource(datasourceName);
    return DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
  }

  public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
    if (dao != null) {
      return dao;
    }
    return DAOFactory.getDAOFactory(typeDatabase, url, user, pass);	
  }

  public void close() {
    try {
	dao.close();
      dao = null;
    } catch (Exception e) {
      
    }
  }

/**
 * Método para validar a seguranca
 */
    public boolean valide(String metodo) throws Exception {
        // Logica da seguranca
        return true;
    }


    public Ctpm_conta_pagar_modificadaDAO getCtpm_conta_pagar_modificadaDAO() throws Exception {
    dao = getDAO();
    return new Ctpm_conta_pagar_modificadaDAO(dao); 
  }


  public Vw_conta_pagar_alteradaDAO getVw_conta_pagar_alteradaDAO() throws Exception {
    dao = getDAO();
    return new Vw_conta_pagar_alteradaDAO(dao); 
  }


	 

   
    public Ctpm_conta_pagar_modificadaT findbyIdCtpm_conta_pagar_modificada(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();

            List<Ctpm_conta_pagar_modificadaT> listTemp = ctpm_conta_pagar_modificadaDAO.getByPK(ctpm_conta_pagar_modificadaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
 
 
 
    public Vw_conta_pagar_alteradaT findbyIdVw_conta_pagar_alterada(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        try {
            Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();

            List<Vw_conta_pagar_alteradaT> listTemp = vw_conta_pagar_alteradaDAO.getByPK(vw_conta_pagar_alteradaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
 
 
	 

}
