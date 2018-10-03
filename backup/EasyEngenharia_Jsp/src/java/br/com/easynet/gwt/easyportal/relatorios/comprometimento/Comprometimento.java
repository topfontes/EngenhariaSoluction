/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.relatorios.comprometimento;

import br.com.easynet.gwt.easyportal.dao.Com_comprometimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Vw_comprometimentoDAO;
import br.com.easynet.gwt.easyportal.relatorios.RelatorioBase;
import br.com.easynet.gwt.easyportal.transfer.Vw_comprometimentoT;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author marcos
 */
public class Comprometimento extends RelatorioBase {
    private boolean previsto;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void imprimir() {
        try {
            List<Vw_comprometimentoT> list = new Vector();
            Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();

            Vw_comprometimentoT vw_comprometimentoT = new Vw_comprometimentoT();
            vw_comprometimentoT.setObr_nr_id(getObr_obrasT().getObr_nr_id());
            vw_comprometimentoT.setCom_nr_mes(getMeo_meses_obraT().getMes());
            vw_comprometimentoT.setCom_nr_ano(getMeo_meses_obraT().getAno());

            list = vw_comprometimentoDAO.getAll(vw_comprometimentoT, previsto);
            jRDataSource = new JRBeanCollectionDataSource(list);

            if(!getTipo().equalsIgnoreCase("XLS")){
                is = Comprometimento.class.getResourceAsStream("comprometimento.jasper");
            }else{
                url = Comprometimento.class.getResource("comprometimento.jasper");
            }
            
            String prev = previsto?"Previsto":"Realizado";
            print("Comprometimento-"+prev, "Comprometimento-"+prev);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            close();
        }
    }

    /**
     * @return the previsto
     */
    public boolean isPrevisto() {
        return previsto;
    }

    /**
     * @param previsto the previsto to set
     */
    public void setPrevisto(boolean previsto) {
        this.previsto = previsto;
    }
}
