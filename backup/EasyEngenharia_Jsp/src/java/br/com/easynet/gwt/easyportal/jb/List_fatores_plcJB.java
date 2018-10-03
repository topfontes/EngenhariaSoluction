/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.transfer.Valores_calculo_fatorT;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class List_fatores_plcJB extends SystemBase{
    private List<Valores_calculo_fatorT> list = new Vector();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        consult();
    }
    public void consult(){
        setList((List<Valores_calculo_fatorT>) getSession().getAttribute("listfatorPlc"));
        getSession().removeAttribute("listfatorPlc");
        
    }

    /**
     * @return the list
     */
    public List<Valores_calculo_fatorT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Valores_calculo_fatorT> list) {
        this.list = list;
    }

}
