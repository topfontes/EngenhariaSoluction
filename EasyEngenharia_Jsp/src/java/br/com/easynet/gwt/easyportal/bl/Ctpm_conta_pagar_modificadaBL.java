package br.com.easynet.gwt.easyportal.bl;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.bl.BusinessException;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctpm_conta_pagar_modificadaBL extends SystemBusinessBase {

    /**
     * Insere um registro na tabela
     */
    public boolean insert(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {

        try {
            if (!valide("insert")) {
                throw new BusinessException("Falha na seguranca !");
            }
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
            ctpm_conta_pagar_modificadaDAO.insert(ctpm_conta_pagar_modificadaT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Consulta todos os registros da tabela
     */
    public List<Ctpm_conta_pagar_modificadaT> consult() throws Exception {
        try {
            if (!valide("consult")) {
                throw new BusinessException("Falha na seguranca !");
            }
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
            return ctpm_conta_pagar_modificadaDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    /**
     * Deletar um registro
     */
    public boolean delete(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            if (!valide("delete")) {
                throw new BusinessException("Falha na seguranca !");
            }

            if (exist(ctpm_conta_pagar_modificadaT)) {
                Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
                ctpm_conta_pagar_modificadaDAO.delete(ctpm_conta_pagar_modificadaT);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Verifica se o objeto existe na base
     */
    public boolean exist(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
            List<Ctpm_conta_pagar_modificadaT> listTemp = ctpm_conta_pagar_modificadaDAO.getByPK(ctpm_conta_pagar_modificadaT);
            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

    }

    /**
     * Realiza uma alteração na tabela
     */
    public boolean update(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            if (!valide("update")) {
                throw new BusinessException("Falha na seguranca !");
            }

            if (exist(ctpm_conta_pagar_modificadaT)) {
                Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
                ctpm_conta_pagar_modificadaDAO.update(ctpm_conta_pagar_modificadaT);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }

    /**
     * Obt�m os dados de um registro
     */
    public Ctpm_conta_pagar_modificadaT findbyid(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();
            List<Ctpm_conta_pagar_modificadaT> listTemp = ctpm_conta_pagar_modificadaDAO.getByPK(ctpm_conta_pagar_modificadaT);

            return listTemp.size() > 0 ? listTemp.get(0) : new Ctpm_conta_pagar_modificadaT();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }
}
