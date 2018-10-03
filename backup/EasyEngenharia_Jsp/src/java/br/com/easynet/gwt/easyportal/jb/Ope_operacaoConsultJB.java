package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Ope_operacaoDAO;
import br.com.easynet.easyportal.transfer.Ope_operacaoT;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Ope_operacaoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Ope_operacaoT ope_operacaoT = new Ope_operacaoT();
    private Per_perfilT per_perfilT = new Per_perfilT();
    private List<Ope_operacaoT> list;


    public void setOpe_operacaoT(Ope_operacaoT ope_operacaoT) {
        this.ope_operacaoT = ope_operacaoT;
    }

    public Ope_operacaoT getOpe_operacaoT() {
        return ope_operacaoT;
    }

    public List<Ope_operacaoT> getList() {
        return list;
    }

    public void setList(List<Ope_operacaoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consultOperacoesPerfil() throws Exception {
        Ope_operacaoDAO ope_operacaoDAO = null;
        try {
            ope_operacaoDAO = getOpe_operacaoDAO();
            per_perfilT.setPer_nr_id(51);
            list = ope_operacaoDAO.getBySis_nr_id(ope_operacaoT);
            setMsg("tes");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            ope_operacaoDAO.close();
        }
    }



    public void consult() throws Exception {
        Ope_operacaoDAO ope_operacaoDAO = null;
        try {
            ope_operacaoDAO = getOpe_operacaoDAO();
            list = ope_operacaoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            ope_operacaoDAO.close();
        }
    }

    public void delete() throws Exception {
        Ope_operacaoDAO ope_operacaoDAO = null;
        try {
            ope_operacaoDAO = getOpe_operacaoDAO();
            ope_operacaoDAO.delete(ope_operacaoT);
            setMsg("Exclus�o efetuada com sucesso!");
            ope_operacaoT = new Ope_operacaoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            ope_operacaoDAO.close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "ope_operacaoInsert.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
        finally{
            close();
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the per_perfilT
     */
    public Per_perfilT getPer_perfilT() {
        return per_perfilT;
    }

    /**
     * @param per_perfilT the per_perfilT to set
     */
    public void setPer_perfilT(Per_perfilT per_perfilT) {
        this.per_perfilT = per_perfilT;
    }


}
