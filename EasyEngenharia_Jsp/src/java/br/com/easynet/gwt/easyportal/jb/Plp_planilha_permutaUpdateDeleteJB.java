package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plp_planilha_permutaUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Plp_planilha_permutaT plp_planilha_permutaT = new Plp_planilha_permutaT();

    public void setPlp_planilha_permutaT(Plp_planilha_permutaT plp_planilha_permutaT) {
        this.plp_planilha_permutaT = plp_planilha_permutaT;
    }

    public Plp_planilha_permutaT getPlp_planilha_permutaT() {
        return plp_planilha_permutaT;
    }
    private List<Plp_planilha_permutaT> list;

    public List<Plp_planilha_permutaT> getList() {
        return list;
    }

    public void setList(List<Plp_planilha_permutaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultObr_obras();

    }

    public void clear() throws Exception {

        plp_planilha_permutaT = new Plp_planilha_permutaT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
                plp_planilha_permutaDAO.delete(plp_planilha_permutaT);
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
            List<Plp_planilha_permutaT> listTemp = plp_planilha_permutaDAO.getByPK(plp_planilha_permutaT);

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
                Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
                plp_planilha_permutaDAO.update(plp_planilha_permutaT);
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
// Method de lookup
// 
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
            Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
            List<Plp_planilha_permutaT> listTemp = plp_planilha_permutaDAO.getByPK(plp_planilha_permutaT);

            plp_planilha_permutaT = listTemp.size() > 0 ? listTemp.get(0) : new Plp_planilha_permutaT();

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
            String page = "plp_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "plp_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
