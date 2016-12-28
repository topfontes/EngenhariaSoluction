package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plco_plano_contas_orcamentoConsultJB extends SystemBase {

    // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int nivel;
    private int id;
    private Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
    private boolean mdo;

    public void setPlco_plano_contas_orcamentoT(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) {
        this.plco_plano_contas_orcamentoT = plco_plano_contas_orcamentoT;
    }

    public Plco_plano_contas_orcamentoT getPlco_plano_contas_orcamentoT() {
        return plco_plano_contas_orcamentoT;
    }
    private List<Plco_plano_contas_orcamentoT> list;

    public List<Plco_plano_contas_orcamentoT> getList() {
        return list;
    }

    public void setList(List<Plco_plano_contas_orcamentoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
//        consult();
    }

    public void consultNivel() throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
            if (!mdo) {
                list = plco_plano_contas_orcamentoDAO.getAllNivel(nivel);
            }else{
                list = plco_plano_contas_orcamentoDAO.getAllNivelMDO(nivel);

            }


        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consultServico() throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
            list = plco_plano_contas_orcamentoDAO.getAllServico();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void consult() throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
            list = plco_plano_contas_orcamentoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void semEquivalencia() throws Exception {
        try {
            if (plco_plano_contas_orcamentoT.getPlco_nr_id() > 0) {
                Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
                list = plco_plano_contas_orcamentoDAO.getByPlco_nr_id(plco_plano_contas_orcamentoT);
                //System.out.println("" + plco_plano_contas_orcamentoT.getPlco_nr_id());
            } else {
                Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
                list = plco_plano_contas_orcamentoDAO.getSemEquivalencia();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();
            plco_plano_contas_orcamentoDAO.delete(plco_plano_contas_orcamentoT);
            setMsg("Exclusão efetuada com sucesso!");
            plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "plco_plano_contas_orcamentoInsert.jsp";// defina aqui a página que deve ser chamada
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

    /**
     * @return the ipo_item_plano_contas_obraT
     */
    public Ipo_item_plano_contas_obraT getIpo_item_plano_contas_obraT() {
        return ipo_item_plano_contas_obraT;
    }

    /**
     * @param ipo_item_plano_contas_obraT the ipo_item_plano_contas_obraT to set
     */
    public void setIpo_item_plano_contas_obraT(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) {
        this.ipo_item_plano_contas_obraT = ipo_item_plano_contas_obraT;
    }

    public String clearEspaco(String valor) {
        char[] vlString = valor.trim().toCharArray();
        StringBuffer novoValor = new StringBuffer();
        String codLetra = "";
        for (int i = 0; i < vlString.length; i++) {
            codLetra += vlString[i];
            int codigo = codLetra.hashCode();
            if (codigo != 32 && codigo != 160) {
                novoValor.append(vlString[i]);
            }
            codLetra = "";
        }
        return novoValor.toString().trim();
    }

    public String formatValue(String valor) {
        char[] vlCs = clearEspaco(valor).toCharArray();
        String vl = clearEspaco(valor);

        String novo = vl.replace(".", "");
        novo = novo.replace(",", ".");
        String novo1 = vl;
//            String vl = sb.toString();
        return novo;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the mdo
     */
    public boolean isMdo() {
        return mdo;
    }

    /**
     * @param mdo the mdo to set
     */
    public void setMdo(boolean mdo) {
        this.mdo = mdo;
    }
}
