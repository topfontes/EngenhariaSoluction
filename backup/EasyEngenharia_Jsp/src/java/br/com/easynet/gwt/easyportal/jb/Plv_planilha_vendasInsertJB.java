package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plv_planilha_vendasInsertJB extends SystemBase {

    // Atributos e propriedades
    private Plv_planilha_vendasT plv_planilha_vendasT = new Plv_planilha_vendasT();

    public void setPlv_planilha_vendasT(Plv_planilha_vendasT plv_planilha_vendasT) {
        this.plv_planilha_vendasT = plv_planilha_vendasT;
    }

    public Plv_planilha_vendasT getPlv_planilha_vendasT() {
        return plv_planilha_vendasT;
    }
    private boolean insertValorMesAnt;

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            if (!isInsertValorMesAnt()) {
                Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
                List<Plv_planilha_vendasT> list = plv_planilha_vendasDAO.getObrMesAno(plv_planilha_vendasT);
                if (list == null || list.size() == 0) {
                    plv_planilha_vendasDAO.insert(plv_planilha_vendasT);
                } else {
                    plv_planilha_vendasT.setPlv_nr_id(list.get(0).getPlv_nr_id());
                    plv_planilha_vendasDAO.update(plv_planilha_vendasT);
                }
                setMsg("Cadastro efetuado com sucesso!");
                clear();
            } else {
                insertUltimoMesDigitado();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public void calcularMesAnterior() {
        int mes = plv_planilha_vendasT.getPlv_nr_mes_ref();
        int ano = plv_planilha_vendasT.getPlv_nr_ano_ref();
        if (mes == 1) {
            ano = ano - 1;
            mes = 12;
        } else {
            mes = mes - 1;
        }
        plv_planilha_vendasT.setPlv_nr_ano_ref(ano);
        plv_planilha_vendasT.setPlv_nr_mes_ref(mes);
    }

    public void insertUltimoMesDigitado() throws Exception {
        try {
            Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();
            int mes_ref = plv_planilha_vendasT.getPlv_nr_mes_ref();
            int ano_ref = plv_planilha_vendasT.getPlv_nr_ano_ref();
            calcularMesAnterior();
            List<Plv_planilha_vendasT> list = plv_planilha_vendasDAO.getAllObraMesAnoRef(plv_planilha_vendasT);
            for (Plv_planilha_vendasT plvT : list) {
                plvT.setPlv_nr_ano_ref(ano_ref);
                plvT.setPlv_nr_mes_ref(mes_ref);
                plvT.setPlv_nr_realizado(0);
                plv_planilha_vendasDAO.insert(plvT);
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

        plv_planilha_vendasT = new Plv_planilha_vendasT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "plv_planilha_vendasConsult.jsp";// defina aqui a p�gina que deve ser chamada
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
