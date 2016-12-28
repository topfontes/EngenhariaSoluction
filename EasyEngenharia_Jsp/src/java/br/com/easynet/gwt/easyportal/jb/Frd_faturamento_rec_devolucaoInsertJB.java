package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Frd_faturamento_rec_devolucaoInsertJB extends SystemBase {

    // Atributos e propriedades
    private Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();

    public void setFrd_faturamento_rec_devolucaoT(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) {
        this.frd_faturamento_rec_devolucaoT = frd_faturamento_rec_devolucaoT;
    }

    public Frd_faturamento_rec_devolucaoT getFrd_faturamento_rec_devolucaoT() {
        return frd_faturamento_rec_devolucaoT;
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
                Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
                frd_faturamento_rec_devolucaoDAO.insert(frd_faturamento_rec_devolucaoT);
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
        int mes = frd_faturamento_rec_devolucaoT.getFrd_nr_mes();
        int ano = frd_faturamento_rec_devolucaoT.getFrd_nr_ano();
        if (mes == 1) {
            ano = ano - 1;
            mes = 12;
        } else {
            mes = mes - 1;
        }
        frd_faturamento_rec_devolucaoT.setFrd_nr_ano(ano);
        frd_faturamento_rec_devolucaoT.setFrd_nr_mes(mes);
    }
    
    public void insertUltimoMesDigitado() throws Exception {
        try {
            Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();
            int mes_ref = frd_faturamento_rec_devolucaoT.getFrd_nr_mes();
            int ano_ref = frd_faturamento_rec_devolucaoT.getFrd_nr_ano();
            calcularMesAnterior();
            List<Frd_faturamento_rec_devolucaoT> list = frd_faturamento_rec_devolucaoDAO.getAllObraMesAnoRef(frd_faturamento_rec_devolucaoT);
            for (Frd_faturamento_rec_devolucaoT frdT : list) {
                frdT.setFrd_nr_ano(ano_ref);
                frdT.setFrd_nr_mes(mes_ref);
                frd_faturamento_rec_devolucaoDAO.insert(frdT);
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
    public void clear() throws Exception {

        frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "frd_faturamento_rec_devolucaoConsult.jsp";// defina aqui a página que deve ser chamada
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
