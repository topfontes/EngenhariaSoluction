package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.menu.dao.Mep_men_perDAO;
import br.com.easynet.easyportal.menu.transfer.Mep_men_perT;
import java.util.List;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Mep_men_perUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Mep_men_perT mep_men_perT = new Mep_men_perT();

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {
        setMep_men_perT(new Mep_men_perT());
    }

    public void removerUsuarioPerfil() throws Exception {
        Mep_men_perDAO mep_men_perDAO = null;
        try {
            if (exist()) {
                mep_men_perDAO = getMep_men_perDAO();
                mep_men_perDAO.delete(getMep_men_perT());
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Falha ao realizar exclus�o");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            mep_men_perDAO.close();
        }
    }

    public void adicionarUsuarioPerfil() throws Exception {
        Mep_men_perDAO mep_men_perDAO = null;
        try {
            if (!exist()) {
                mep_men_perDAO = getMep_men_perDAO();
                mep_men_perDAO.insert(mep_men_perT);
                setMsg("adicionado com sucesso!");;
                clear();
            } else {
                setMsg("Falha ao realizar cadastro!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            mep_men_perDAO.close();
        }
    }

    public boolean exist() throws Exception {
        Mep_men_perDAO mep_men_perDAO = null;
        try {
            mep_men_perDAO = getMep_men_perDAO();
            List<Mep_men_perT> listTemp = mep_men_perDAO.getById(getMep_men_perT());

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            //mep_men_perDAO.close();
        }
        return false;

    }



    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "mep_men_perConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the mep_men_perT
     */
    public Mep_men_perT getMep_men_perT() {
        return mep_men_perT;
    }

    /**
     * @param mep_men_perT the mep_men_perT to set
     */
    public void setMep_men_perT(Mep_men_perT mep_men_perT) {
        this.mep_men_perT = mep_men_perT;
    }
}
