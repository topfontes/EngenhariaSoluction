package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Plp_planilha_permutaInsertJB extends SystemBase {

    private boolean insertValorMesAnt;
    // Atributos e propriedades
    private Plp_planilha_permutaT plp_planilha_permutaT = new Plp_planilha_permutaT();

    public void setPlp_planilha_permutaT(Plp_planilha_permutaT plp_planilha_permutaT) {
        this.plp_planilha_permutaT = plp_planilha_permutaT;
    }

    public Plp_planilha_permutaT getPlp_planilha_permutaT() {
        return plp_planilha_permutaT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    // M�todos de Eventos
    public void insert() throws Exception {

        try {
            if (insertValorMesAnt) {
                insertUltimoMesDigitado();
            } else {
                Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
                List<Plp_planilha_permutaT> list = plp_planilha_permutaDAO.getObrMesAno(plp_planilha_permutaT);
                if (list == null || list.size() == 0) {
                    plp_planilha_permutaDAO.insert(plp_planilha_permutaT);
                } else {
                    plp_planilha_permutaT.setPlp_nr_id(list.get(0).getPlp_nr_id());
                    plp_planilha_permutaDAO.update(plp_planilha_permutaT);
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
        int mes = plp_planilha_permutaT.getPlp_nr_mes_ref();
        int ano = plp_planilha_permutaT.getPlp_nr_ano_ref();
        if (mes == 1) {
            ano = ano - 1;
            mes = 12;
        } else {
            mes = mes - 1;
        }
        plp_planilha_permutaT.setPlp_nr_ano_ref(ano);
        plp_planilha_permutaT.setPlp_nr_mes_ref(mes);
    }

    public void insertUltimoMesDigitado() throws Exception {
        try {
            Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();
            int mes_ref = plp_planilha_permutaT.getPlp_nr_mes_ref();
            int ano_ref = plp_planilha_permutaT.getPlp_nr_ano_ref();
            calcularMesAnterior();
            List<Plp_planilha_permutaT> list = plp_planilha_permutaDAO.getAllObraMesAnoRef(plp_planilha_permutaT);
            for (Plp_planilha_permutaT plpT : list) {
                plpT.setPlp_nr_ano_ref(ano_ref);
                plpT.setPlp_nr_mes_ref(mes_ref);
                plpT.setPlp_nr_realizado(0);
                plp_planilha_permutaDAO.insert(plpT);
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

    public void clear() throws Exception {

        plp_planilha_permutaT = new Plp_planilha_permutaT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "plp_planilha_permutaConsult.jsp";// defina aqui a página que deve ser chamada
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
