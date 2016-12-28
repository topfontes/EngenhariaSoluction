package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plr_planilha_recebimentoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Plr_planilha_recebimentoT plr_planilha_recebimentoT = new Plr_planilha_recebimentoT();

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {

        try {
            Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();
            List<Plr_planilha_recebimentoT> list = plr_planilha_permutaDAO.getObrMesAno(plr_planilha_recebimentoT);
            if(list == null || list.size() == 0){
              plr_planilha_permutaDAO.insert(getPlr_planilha_recebimentoT());
            }else{
                plr_planilha_recebimentoT.setPlr_nr_id(list.get(0).getPlr_nr_id());
                plr_planilha_permutaDAO.update(getPlr_planilha_recebimentoT());
            }
            setMsg("Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
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

    public void clear() throws Exception {

        setPlr_planilha_recebimentoT(new Plr_planilha_recebimentoT());
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "plr_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the plr_planilha_recebimentoT
     */
    public Plr_planilha_recebimentoT getPlr_planilha_recebimentoT() {
        return plr_planilha_recebimentoT;
    }

    /**
     * @param plr_planilha_recebimentoT the plr_planilha_recebimentoT to set
     */
    public void setPlr_planilha_recebimentoT(Plr_planilha_recebimentoT plr_planilha_recebimentoT) {
        this.plr_planilha_recebimentoT = plr_planilha_recebimentoT;
    }
}
