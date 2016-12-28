/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;

/**
 *
 * @author marcos
 */
public class Pms_ultimo_mes_digitadoJB extends SystemBase implements INotSecurity{

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void ultimomesdigitado(){
        try {

        Pms_planilha_medicao_servicoDAO dAO = getPms_planilha_medicao_servicoDAO();
//        dAO.
        } catch (Exception e) {
        }

    }
}
