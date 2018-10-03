package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Htf_horas_trabalha_folhaInsertJB extends SystemBase {

    // Atributos e propriedades
    private Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();

    public void setHtf_horas_trabalha_folhaT(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) {
        this.htf_horas_trabalha_folhaT = htf_horas_trabalha_folhaT;
    }

    public Htf_horas_trabalha_folhaT getHtf_horas_trabalha_folhaT() {
        return htf_horas_trabalha_folhaT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public boolean existe() throws Exception{
        try {
            
            Htf_horas_trabalha_folhaDAO dAO = getHtf_horas_trabalha_folhaDAO();
            htf_horas_trabalha_folhaT.setHtf_nr_id(dAO.existe(htf_horas_trabalha_folhaT));
            return htf_horas_trabalha_folhaT.getHtf_nr_id() > 0;
        } catch (Exception e) {
            throw e;
        }
    }
    // M�todos de Eventos

    public void insert() throws Exception {
        try {
            Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();
            if (!existe()) {
                htf_horas_trabalha_folhaDAO.insert(htf_horas_trabalha_folhaT);
            } else {
                htf_horas_trabalha_folhaDAO.update(htf_horas_trabalha_folhaT);
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

    public void clear() throws Exception {

        htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "htf_horas_trabalha_folhaConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
