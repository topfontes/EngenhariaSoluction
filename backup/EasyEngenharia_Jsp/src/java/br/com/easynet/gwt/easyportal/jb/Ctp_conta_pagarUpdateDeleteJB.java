package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ctp_conta_pagarUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Ctp_conta_pagarT ctp_conta_pagarTOrig = new Ctp_conta_pagarT();
    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();

    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }
    private List<Ctp_conta_pagarT> list;

    public List<Ctp_conta_pagarT> getList() {
        return list;
    }

    public void setList(List<Ctp_conta_pagarT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {

        ctp_conta_pagarT = new Ctp_conta_pagarT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                ctp_conta_pagarDAO.delete(ctp_conta_pagarT);
                setMsg("Exclus�o efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }

    public void deleteAllObra() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.deleteObraMesAno(getCtp_conta_pagarTOrig());
            setMsg("Exclusãoo efetuada com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }
    public void updateObraMesAno(){
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            ctp_conta_pagarDAO.updateObraMesAno(ctp_conta_pagarTOrig,ctp_conta_pagarT);
            setMsg("Alteração efetuada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (exist()) {
                Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
                ctp_conta_pagarDAO.update(ctp_conta_pagarT);
                setMsg("Alteraçãoo efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar altera��o!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<For_fornecedorT> listfor_fornecedor;

    public List<For_fornecedorT> getListfor_fornecedor() {
        return listfor_fornecedor;
    }

    public void setListfor_fornecedor(List<For_fornecedorT> list) {
        this.listfor_fornecedor = list;
    }

    public void consultFor_fornecedor() throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();
            listfor_fornecedor = for_fornecedorDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Plc_plano_contasT> listplc_plano_contas;

    public List<Plc_plano_contasT> getListplc_plano_contas() {
        return listplc_plano_contas;
    }

    public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
        this.listplc_plano_contas = list;
    }

    public void consultPlc_plano_contas() throws Exception {
        try {
            Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();
            DataSet listplc_plano_contas = plc_plano_contasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
    private List<Obr_obrasT> listobr_obras;

    public List<Obr_obrasT> getListobr_obras() {
        return listobr_obras;
    }

    public void setListobr_obras(List<Obr_obrasT> list) {
        this.listobr_obras = list;
    }

    public void consultObr_obras() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            DataSet listobr_obras = obr_obrasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image � montando se houver algum campo do tipo bin�rio
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();
            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            ctp_conta_pagarT = listTemp.size() > 0 ? listTemp.get(0) : new Ctp_conta_pagarT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a p�gina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "ctp_conta_pagarConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "ctp_conta_pagarConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the ctp_conta_pagarTOrig
     */
    public Ctp_conta_pagarT getCtp_conta_pagarTOrig() {
        return ctp_conta_pagarTOrig;
    }

    /**
     * @param ctp_conta_pagarTOrig the ctp_conta_pagarTOrig to set
     */
    public void setCtp_conta_pagarTOrig(Ctp_conta_pagarT ctp_conta_pagarTOrig) {
        this.ctp_conta_pagarTOrig = ctp_conta_pagarTOrig;
    }
}
