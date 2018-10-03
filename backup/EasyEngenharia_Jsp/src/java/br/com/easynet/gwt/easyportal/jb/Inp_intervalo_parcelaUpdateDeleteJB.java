package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Inp_intervalo_parcelaUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Inp_intervalo_parcelaT inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();

    public void setInp_intervalo_parcelaT(Inp_intervalo_parcelaT inp_intervalo_parcelaT) {
        this.inp_intervalo_parcelaT = inp_intervalo_parcelaT;
    }

    public Inp_intervalo_parcelaT getInp_intervalo_parcelaT() {
        return inp_intervalo_parcelaT;
    }
    private List<Inp_intervalo_parcelaT> list;

    public List<Inp_intervalo_parcelaT> getList() {
        return list;
    }

    public void setList(List<Inp_intervalo_parcelaT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {
        inp_intervalo_parcelaT = new Inp_intervalo_parcelaT();
    }

    public void consult_IdParcela() {
        try {
            Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
            list = idao.getByPar_nr_id(inp_intervalo_parcelaT);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
                inp_intervalo_parcelaDAO.delete(inp_intervalo_parcelaT);
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
            Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
            List<Inp_intervalo_parcelaT> listTemp = inp_intervalo_parcelaDAO.getByPK(inp_intervalo_parcelaT);

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
                Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
                inp_intervalo_parcelaDAO.update(inp_intervalo_parcelaT);
                setMsg("Altera��o efetuada com sucesso!");
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
    private List<Par_parcelamentoT> listpar_parcelamento;

    public List<Par_parcelamentoT> getListpar_parcelamento() {
        return listpar_parcelamento;
    }

    public void setListpar_parcelamento(List<Par_parcelamentoT> list) {
        this.listpar_parcelamento = list;
    }

    public void consultPar_parcelamento() throws Exception {
        try {
            Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
            listpar_parcelamento = par_parcelamentoDAO.getAll();
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
            Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();
            List<Inp_intervalo_parcelaT> listTemp = inp_intervalo_parcelaDAO.getByPK(inp_intervalo_parcelaT);

            inp_intervalo_parcelaT = listTemp.size() > 0 ? listTemp.get(0) : new Inp_intervalo_parcelaT();

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
            String page = "inp_intervalo_parcelaConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "inp_intervalo_parcelaConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
