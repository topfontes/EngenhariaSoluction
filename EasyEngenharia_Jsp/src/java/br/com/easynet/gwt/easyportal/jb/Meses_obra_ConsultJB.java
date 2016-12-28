/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.transfer.Meo_meses_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import java.util.List;

/**
 *
 * @author marcos
 */
public class Meses_obra_ConsultJB extends SystemBase {

    private Meo_meses_obraT meo_meses_obraT = new Meo_meses_obraT();
    private List<Meo_meses_obraT> list;
    private Obr_obrasT obr_obrasT = new Obr_obrasT();

    /**
     * @return the obr_obrasT
     */
    public Obr_obrasT getObr_obrasT() {
        return obr_obrasT;
    }

    /**
     * @param obr_obrasT the obr_obrasT to set
     */
    public void setObr_obrasT(Obr_obrasT obr_obrasT) {
        this.obr_obrasT = obr_obrasT;
    }

    /**
     * @return the meo_meses_obraT
     */
    public Meo_meses_obraT getMeo_meses_obraT() {
        return meo_meses_obraT;
    }

    /**
     * @param meo_meses_obraT the meo_meses_obraT to set
     */
    public void setMeo_meses_obraT(Meo_meses_obraT meo_meses_obraT) {
        this.meo_meses_obraT = meo_meses_obraT;
    }

    /**
     * @return the list
     */
    public List<Meo_meses_obraT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Meo_meses_obraT> list) {
        this.list = list;
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }

    public void consult() throws Exception {
        Obr_obrasDAO odao = getObr_obrasDAO();
        try {
            list = odao.getAllMeses(obr_obrasT);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            odao.close();
        }

    }
}
