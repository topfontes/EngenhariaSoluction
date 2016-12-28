/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.vw_conta_pagar_alterada;

import br.com.easynet.gwt.easyportal.client.IListenetResponse;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_comprometimentoTGWT;
import br.com.easynet.gwt.easyportal.client.display.easyEngenharia.easyconstru.transfer.Vw_conta_pagar_alteradaTGWT;
import com.google.gwt.json.client.JSONValue;
import java.util.HashMap;

/**
 *
 * @author marcos
 */
public class List_ContasPagasAlteradasGWTDAO implements IListenetResponse{

    public static final String PAGE = "easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsultGWT.jsp";
    private boolean finalized;

    public List_ContasPagasAlteradasGWTDAO() {

    }


    public void consult(Vw_conta_pagar_alteradaTGWT vw_conta_pagar_alteradaTGWT){
        setFinalized(false);
        HashMap<String,String> param = new HashMap<String, String>();


    }


    public void read(JSONValue jsonValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the finalized
     */
    public boolean isFinalized() {
        return finalized;
    }

    /**
     * @param finalized the finalized to set
     */
    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }

}
