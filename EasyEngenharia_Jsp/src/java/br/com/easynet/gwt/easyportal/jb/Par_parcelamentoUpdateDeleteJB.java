package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Par_parcelamentoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Par_parcelamentoT par_parcelamentoT = new Par_parcelamentoT();

    public void setPar_parcelamentoT(Par_parcelamentoT par_parcelamentoT) {
        this.par_parcelamentoT = par_parcelamentoT;
    }

    public Par_parcelamentoT getPar_parcelamentoT() {
        return par_parcelamentoT;
    }
    private int[] intervalo;
    private List<Par_parcelamentoT> list;

    public List<Par_parcelamentoT> getList() {
        return list;
    }

    public void setList(List<Par_parcelamentoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        par_parcelamentoT = new Par_parcelamentoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
                par_parcelamentoDAO.delete(par_parcelamentoT);
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
            Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
            List<Par_parcelamentoT> listTemp = par_parcelamentoDAO.getByPK(par_parcelamentoT);

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
        DAOFactory factory = null;
        try {
            if (exist()) {
                Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
                factory = par_parcelamentoDAO.getDAOFactory();
                factory.beginTransaction();
                par_parcelamentoDAO.update(par_parcelamentoT);
                Inp_intervalo_parcelaDAO idao = getInp_intervalo_parcelaDAO();
                idao.deleteAllParcela(par_parcelamentoT.getPar_nr_id());
                
                if (intervalo != null) {
                    for (int i = 0; i < getIntervalo().length; i++) {
                        Inp_intervalo_parcelaT it = new Inp_intervalo_parcelaT();
                        it.setPar_nr_id(par_parcelamentoT.getPar_nr_id());
                        it.setInp_nr_sequencia((i + 1));
                        it.setInp_nr_dias(getIntervalo()[i]);
                        idao.insert(it);
                    }
                }
                factory.commitTransaction();
                setMsg("Alteração efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
                factory.rollbackTransaction();
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
    //Method Download Image � montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();
            List<Par_parcelamentoT> listTemp = par_parcelamentoDAO.getByPK(par_parcelamentoT);

            par_parcelamentoT = listTemp.size() > 0 ? listTemp.get(0) : new Par_parcelamentoT();

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
            String page = "par_parcelamentoConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "par_parcelamentoConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the intervalo
     */
    public int[] getIntervalo() {
        return intervalo;
    }

    /**
     * @param intervalo the intervalo to set
     */
    public void setIntervalo(int[] intervalo) {
        this.intervalo = intervalo;
    }
}
