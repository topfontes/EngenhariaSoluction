package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Dso_descricao_servico_obraConsultJB extends SystemBase {

    // Atributos e propriedades
    private Dso_descricao_servico_obraT dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();

    public void setDso_descricao_servico_obraT(Dso_descricao_servico_obraT dso_descricao_servico_obraT) {
        this.dso_descricao_servico_obraT = dso_descricao_servico_obraT;
    }

    public Dso_descricao_servico_obraT getDso_descricao_servico_obraT() {
        return dso_descricao_servico_obraT;
    }
    private List<Dso_descricao_servico_obraT> list;

    public List<Dso_descricao_servico_obraT> getList() {
        return list;
    }

    public void setList(List<Dso_descricao_servico_obraT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
            list = dso_descricao_servico_obraDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public boolean existeCodigo(Dso_descricao_servico_obraT dt) throws Exception {
        try {
            Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
            return dso_descricao_servico_obraDAO.getByExiste(dso_descricao_servico_obraT);
        } catch (Exception e) {
            throw e;
        }
    }


    public void delete() throws Exception {
        try {
            Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
            dso_descricao_servico_obraDAO.delete(dso_descricao_servico_obraT);
            setMsg("Exclusão efetuada com sucesso!");
            dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "dso_descricao_servico_obraInsert.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
