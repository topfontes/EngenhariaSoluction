package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Obr_obrasInsertJB extends SystemBase {

    // Atributos e propriedades
    private Obr_obrasT obr_obrasT = new Obr_obrasT();

    public void setObr_obrasT(Obr_obrasT obr_obrasT) {
        this.obr_obrasT = obr_obrasT;
    }

    public Obr_obrasT getObr_obrasT() {
        return obr_obrasT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            obr_obrasDAO.insert(obr_obrasT);
            setMsg("Cadastro efetuado com sucesso!");
            //clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }
// Method de lookup
// 
    private List<Emp_empreendimentoT> listemp_empreendimento;

    public List<Emp_empreendimentoT> getListemp_empreendimento() {
        return listemp_empreendimento;
    }

    public void setListemp_empreendimento(List<Emp_empreendimentoT> list) {
        this.listemp_empreendimento = list;
    }

    public void consultEmp_empreendimento() throws Exception {
        try {
            Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
            listemp_empreendimento = emp_empreendimentoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {

        obr_obrasT = new Obr_obrasT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "obr_obrasConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
