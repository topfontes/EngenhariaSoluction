/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.criptografia.MD5;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;

/**
 *
 * @author I9
 */
public class Usuario_sistemaInsertJB extends SystemBase{
    private Usu_usuarioT usu_usuarioT  = new Usu_usuarioT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }
    public void insert(){
        Usu_usuarioDAO dAO = null;
        try {
            usu_usuarioT.setUsu_tx_status("A");
            dAO = getUsu_usuarioDAO();
            usu_usuarioT.setUsu_tx_senha(MD5.criptografar(usu_usuarioT.getUsu_tx_senha()));
            dAO.insert(usu_usuarioT);
            setMsg("cadastrado com sucesso");
        } catch (Exception e) {
             setMsg("não foi possivel cadastrar");
        }
        finally{
            dAO.close();
        }
    }

    /**
     * @return the usu_usuarioT
     */
    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }

    /**
     * @param usu_usuarioT the usu_usuarioT to set
     */
    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

}
