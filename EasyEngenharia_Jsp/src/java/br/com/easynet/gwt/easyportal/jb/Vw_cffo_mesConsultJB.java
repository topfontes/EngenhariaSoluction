package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.gwt.easyportal.client.dao.*;
import br.com.easynet.gwt.easyportal.client.transfer.*;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Vw_cffo_mesConsultJB extends SystemBase implements INotSecurity {

    // Atributos e propriedades
    private Vw_cffo_mesT vw_cffo_mesT = new Vw_cffo_mesT();

    public void setVw_cffo_mesT(Vw_cffo_mesT vw_cffo_mesT) {
        this.vw_cffo_mesT = vw_cffo_mesT;
    }

    public Vw_cffo_mesT getVw_cffo_mesT() {
        return vw_cffo_mesT;
    }
    private List<Vw_cffo_mesT> list;

    public List<Vw_cffo_mesT> getList() {
        return list;
    }

    public void setList(List<Vw_cffo_mesT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        try {
            list = new ArrayList<Vw_cffo_mesT>();
            CronogramaDesembolsoSubClasseReprogJB classeReprogJB = new CronogramaDesembolsoSubClasseReprogJB();
            classeReprogJB.setPage(page);
            classeReprogJB.setTipo("R");
            classeReprogJB.setMesRef(vw_cffo_mesT.getCffo_nr_mes());
            classeReprogJB.setAnoRef(vw_cffo_mesT.getCffo_nr_ano());
            classeReprogJB.getVw_importacao_orcamentoT().setObr_nr_id(vw_cffo_mesT.getObr_nr_id());
            classeReprogJB.consult();
            TreeMap<String, Meo_meses_obraT> treeMes = classeReprogJB.getTreeTotalMes();

            Set<String> key = treeMes.keySet();
            for (Iterator<String> it = key.iterator(); it.hasNext();) {
                String newKey = it.next();
                Meo_meses_obraT mes = treeMes.get(newKey);
                if (mes.getTotalMes() != 0) {
                    Vw_cffo_mesT vt = new Vw_cffo_mesT();
                    vt.setCffo_nr_ano(mes.getAno());
                    vt.setCffo_nr_mes(mes.getMes());
                    vt.setTotal(mes.getTotalMes());
                    vt.setObr_nr_id(vw_cffo_mesT.getObr_nr_id());
                    list.add(vt);
                }
            }
            int q = 0;
//      Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
//      list = vw_cffo_mesDAO.getAll(vw_cffo_mesT);
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void delete() throws Exception {
        try {
            Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();
            vw_cffo_mesDAO.delete(vw_cffo_mesT);
            setMsg("Exclusão efetuada com sucesso!");
            vw_cffo_mesT = new Vw_cffo_mesT();
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
            String page = "vw_cffo_mesInsert.jsp";// defina aqui a página que deve ser chamada
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
}
