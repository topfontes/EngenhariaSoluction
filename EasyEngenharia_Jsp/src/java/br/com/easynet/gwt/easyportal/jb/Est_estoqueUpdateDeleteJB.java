package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Est_estoqueUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Est_estoqueT est_estoqueT = new Est_estoqueT();
    private Est_estoqueT est_estoqueTOrig = new Est_estoqueT();
    private boolean addSubClasse;

    public void setEst_estoqueT(Est_estoqueT est_estoqueT) {
        this.est_estoqueT = est_estoqueT;
    }

    public Est_estoqueT getEst_estoqueT() {
        return est_estoqueT;
    }
    private List<Est_estoqueT> list;

    public List<Est_estoqueT> getList() {
        return list;
    }

    public void setList(List<Est_estoqueT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
//        consultPlc_plano_contas();
//        consultObr_obras();

    }

    public void clear() throws Exception {

        est_estoqueT = new Est_estoqueT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
                est_estoqueDAO.delete(est_estoqueT);
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

    public boolean exist() throws Exception {
        try {
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            List<Est_estoqueT> listTemp = est_estoqueDAO.getByPK(est_estoqueT);
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
                Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
                if (addSubClasse) {
                    est_estoqueDAO.updateClasse(est_estoqueT);
                }else{
                    est_estoqueDAO.update(est_estoqueT);
                }
                setMsg("Alteração efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar alteração!");
        } finally {
            close();
        }
    }
    
    public void deleteAllObra() throws Exception {
        try {
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            est_estoqueDAO.deleteObraMesAno(est_estoqueTOrig);
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
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            est_estoqueDAO.updateObraMesAno(est_estoqueTOrig,est_estoqueT);
            setMsg("Alteração efetuada com sucesso!");
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            close();
        }
    }


// Method de lookup
// 
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

    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();
            List<Est_estoqueT> listTemp = est_estoqueDAO.getByPK(est_estoqueT);

            est_estoqueT = listTemp.size() > 0 ? listTemp.get(0) : new Est_estoqueT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a página de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "est_estoqueConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "est_estoqueConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the addSubClasse
     */
    public boolean isAddSubClasse() {
        return addSubClasse;
    }

    /**
     * @param addSubClasse the addSubClasse to set
     */
    public void setAddSubClasse(boolean addSubClasse) {
        this.addSubClasse = addSubClasse;
    }

    /**
     * @return the est_estoqueTOrig
     */
    public Est_estoqueT getEst_estoqueTOrig() {
        return est_estoqueTOrig;
    }

    /**
     * @param est_estoqueTOrig the est_estoqueTOrig to set
     */
    public void setEst_estoqueTOrig(Est_estoqueT est_estoqueTOrig) {
        this.est_estoqueTOrig = est_estoqueTOrig;
    }
}
