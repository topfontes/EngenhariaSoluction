/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import java.util.List;

/**
 *
 * @author marcos
 */
public class ctp_conta_pagarSemVinculoJB extends SystemBase {

    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private List<Ctp_conta_pagarT> list;
    private int status;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void consult() {
        try {
            if(status ==1){
                ctp_conta_pagarT.setCtp_tx_status("P");
            }else if(status ==2){
                ctp_conta_pagarT.setCtp_tx_status("A");
            }
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            list = cdao.getBySemVinculoZeroPlc(ctp_conta_pagarT);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void updateClasse() {
        try {
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            cdao.updateClasse(ctp_conta_pagarT);
        } catch (Exception e) {
        }finally{
            close();
        }

        
    }

    /**
     * @return the ctp_conta_pagarT
     */
    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    /**
     * @param ctp_conta_pagarT the ctp_conta_pagarT to set
     */
    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    /**
     * @return the list
     */
    public List<Ctp_conta_pagarT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Ctp_conta_pagarT> list) {
        this.list = list;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
