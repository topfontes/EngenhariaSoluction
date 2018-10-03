package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Flr_fluxo_receitaInsertJB extends SystemBase {

    // Atributos e propriedades
    private Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();

    public void setFlr_fluxo_receitaT(Flr_fluxo_receitaT flr_fluxo_receitaT) {
        this.flr_fluxo_receitaT = flr_fluxo_receitaT;
    }

    public Flr_fluxo_receitaT getFlr_fluxo_receitaT() {
        return flr_fluxo_receitaT;
    }
    private boolean insertValorMesAnt;

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            if (insertValorMesAnt) {
                insertUltimoMesDigitado();
            } else {
                Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
                if (!existe()) {
                    flr_fluxo_receitaDAO.insert(flr_fluxo_receitaT);
                } else {
                    flr_fluxo_receitaDAO.update(flr_fluxo_receitaT);
                }
                setMsg("Cadastro efetuado com sucesso!");
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public void calcularMesAnterior() {
        int mes = flr_fluxo_receitaT.getFlr_nr_mes_ref();
        int ano = flr_fluxo_receitaT.getFlr_nr_ano_ref();
        if (mes == 1) {
            ano = ano - 1;
            mes = 12;
        } else {
            mes = mes - 1;
        }
        flr_fluxo_receitaT.setFlr_nr_ano_ref(ano);
        flr_fluxo_receitaT.setFlr_nr_mes_ref(mes);
    }

    public void insertUltimoMesDigitado() throws Exception {
        try {
            Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
            int mes_ref = flr_fluxo_receitaT.getFlr_nr_ano_ref();
            int ano_ref = flr_fluxo_receitaT.getFlr_nr_ano_ref();
            calcularMesAnterior();
            List<Flr_fluxo_receitaT> list = flr_fluxo_receitaDAO.getAllObraMesAnoRef(flr_fluxo_receitaT);
            for (Flr_fluxo_receitaT flrT : list) {
                flrT.setFlr_nr_ano_ref(ano_ref);
                flrT.setFlr_nr_mes_ref(mes_ref);
                flrT.setFlr_nr_atual(0);
                flr_fluxo_receitaDAO.insert(flrT);
            }
            setMsg("Cadastros efetuado com sucesso!");
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }
// Method de lookup
// 

    public boolean existe() {
        boolean res = false;
        try {
            Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();
            flr_fluxo_receitaT.setFlr_tx_key(flr_fluxo_receitaT.getFlr_nr_mes_ref() + "." + flr_fluxo_receitaT.getFlr_nr_ano_ref() + "-" + flr_fluxo_receitaT.getFlr_nr_mes() + "." + flr_fluxo_receitaT.getFlr_nr_ano());
            List<Flr_fluxo_receitaT> list = flr_fluxo_receitaDAO.getByFlr_tx_key(flr_fluxo_receitaT);
            if (!list.isEmpty()) {
                double valorAtual = flr_fluxo_receitaT.getFlr_nr_atual();
                double valorOriginal = flr_fluxo_receitaT.getFlr_nr_original();
                flr_fluxo_receitaT = list.get(0);
                flr_fluxo_receitaT.setFlr_nr_original(valorOriginal);
                flr_fluxo_receitaT.setFlr_nr_atual(valorAtual);
                res = true;
            }
            return res;

        } catch (Exception e) {
        }
        return res;
    }

    public void clear() throws Exception {

        flr_fluxo_receitaT = new Flr_fluxo_receitaT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "flr_fluxo_receitaConsult.jsp";// defina aqui a p�gina que deve ser chamada
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
