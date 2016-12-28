package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Evl_evolucao_lucroInsertJB extends SystemBase implements INotSecurity {

    // Atributos e propriedades
    private Evl_evolucao_lucroT evl_evolucao_lucroT = new Evl_evolucao_lucroT();
    private boolean insertValorMesAnt = false;

    public void setEvl_evolucao_lucroT(Evl_evolucao_lucroT evl_evolucao_lucroT) {
        this.evl_evolucao_lucroT = evl_evolucao_lucroT;
    }

    public Evl_evolucao_lucroT getEvl_evolucao_lucroT() {
        return evl_evolucao_lucroT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            if (!insertValorMesAnt) {
                Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
                evl_existe();
                if (evl_evolucao_lucroT.getEvl_nr_id() == 0) {
                    evl_evolucao_lucroDAO.insert(evl_evolucao_lucroT);
                    setMsg(INFO, "Cadastro efetuado com sucesso!");
                } else {
                    evl_evolucao_lucroDAO.update(evl_evolucao_lucroT);
                    setMsg(INFO, "Alteração efetuado com sucesso!");
                }
            } else {
                insertUltimoMesDigitado();
            }
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg(ERROR, "Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public void calcularMesAnterior() {
        int mes = evl_evolucao_lucroT.getEvl_nr_mes_ref();
        int ano = evl_evolucao_lucroT.getEvl_nr_ano_ref();
        if (mes == 1) {
            ano = ano - 1;
            mes = 12;
        } else {
            mes = mes - 1;
        }
        evl_evolucao_lucroT.setEvl_nr_ano_ref(ano);
        evl_evolucao_lucroT.setEvl_nr_mes_ref(mes);
    }

    public void insertUltimoMesDigitado() throws Exception {
        try {
            Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();
            int mes_ref = evl_evolucao_lucroT.getEvl_nr_mes_ref();
            int ano_ref = evl_evolucao_lucroT.getEvl_nr_ano_ref();
            calcularMesAnterior();
            List<Evl_evolucao_lucroT> list = evl_evolucao_lucroDAO.getAllObraMesAnoRef(evl_evolucao_lucroT);
            for (Evl_evolucao_lucroT evlT : list) {
                evlT.setEvl_nr_ano_ref(ano_ref);
                evlT.setEvl_nr_mes_ref(mes_ref);
                evl_evolucao_lucroDAO.insert(evlT);
            }
            setMsg("Cadastros efetuado com sucesso!");
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public void evl_existe() throws Exception {
        try {

            Evl_evolucao_lucroDAO edao = getEvl_evolucao_lucroDAO();
            List<Evl_evolucao_lucroT> lis = edao.getByEvl(evl_evolucao_lucroT);
            if (lis != null & lis.size() > 0) {
                evl_evolucao_lucroT.setEvl_nr_id(lis.get(0).getEvl_nr_id());
            }
        } catch (Exception e) {
            throw e;
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
            //listobr_obras = obr_obrasDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void clear() throws Exception {
        evl_evolucao_lucroT = new Evl_evolucao_lucroT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "evl_evolucao_lucroConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the insertValorMesAnt
     */
    public boolean isInsertValorMesAnt() {
        return insertValorMesAnt;
    }

    /**
     * @param insertValorMesAnt the insertValorMesAnt to set
     */
    public void setInsertValorMesAnt(boolean insertValorMesAnt) {
        this.insertValorMesAnt = insertValorMesAnt;
    }
}
