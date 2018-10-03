/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author I9
 */
public class usuario_sistemaUpdateDeleteJB extends SystemBase{
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    /**
     * @return the usu_usuarioT
     */

    
    public Usu_usuarioT getUsu_usuarioT() {
        return usu_usuarioT;
    }
    public void delete(){
        Usu_usuarioDAO dAO = null;
        try {
            if (exist()) {
                dAO = getUsu_usuarioDAO();
                dAO.delete(usu_usuarioT);
                setMsg("Exclusao efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }

        } catch (Exception ex) {
            setMsg("Falha ao realizar exclusao!");
            Logger.getLogger(usuario_sistemaUpdateDeleteJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            dAO.close();
        }

    }
    public void update(){
        Usu_usuarioDAO dAO = null;
        try {
            if (exist()) {
                dAO = getUsu_usuarioDAO();
                dAO.update(usu_usuarioT);
                setMsg("Altera��o efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
            }
           
        } catch (Exception ex) {
            setMsg("Falha ao realizar altera��o!");	
            Logger.getLogger(usuario_sistemaUpdateDeleteJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            dAO.close();
        }
    }

    /**
     * @param usu_usuarioT the usu_usuarioT to set
     */
    public void setUsu_usuarioT(Usu_usuarioT usu_usuarioT) {
        this.usu_usuarioT = usu_usuarioT;
    }

    private boolean exist() {
        Usu_usuarioDAO dAO = null;
        try {
            dAO = getUsu_usuarioDAO();
            return (!dAO.getById(usu_usuarioT).isEmpty());
        } catch (Exception ex) {
            Logger.getLogger(usuario_sistemaUpdateDeleteJB.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            close();
        }

        return true;
    }
}
