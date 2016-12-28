package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plv_planilha_vendasUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Plv_planilha_vendasT plv_planilha_vendasT = new Plv_planilha_vendasT();

    public void setPlv_planilha_vendasT(Plv_planilha_vendasT plv_planilha_vendasT) {
        this.plv_planilha_vendasT = plv_planilha_vendasT;
    }

    public Plv_planilha_vendasT getPlv_planilha_vendasT() {
        return plv_planilha_vendasT;
    }
    private List<Plv_planilha_vendasT> list;

    public List<Plv_planilha_vendasT> getList() {
        return list;
    }

    public void setList(List<Plv_planilha_vendasT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
        consultObr_obras();

    }

    public void clear() throws Exception {

        plv_planilha_vendasT = new Plv_planilha_vendasT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
                plv_planilha_vendasDAO.delete(plv_planilha_vendasT);
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
            Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
            List<Plv_planilha_vendasT> listTemp = plv_planilha_vendasDAO.getByPK(plv_planilha_vendasT);

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
                Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
                plv_planilha_vendasDAO.update(plv_planilha_vendasT);
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
            Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
            List<Plv_planilha_vendasT> listTemp = plv_planilha_vendasDAO.getByPK(plv_planilha_vendasT);

            plv_planilha_vendasT = listTemp.size() > 0 ? listTemp.get(0) : new Plv_planilha_vendasT();

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
            String page = "plv_planilha_vendasConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "plv_planilha_vendasConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
