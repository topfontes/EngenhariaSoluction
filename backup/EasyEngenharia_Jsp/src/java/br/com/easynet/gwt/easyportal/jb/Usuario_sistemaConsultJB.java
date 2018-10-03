/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Per_perfilDAO;
import br.com.easynet.easyportal.dao.Pu_per_usuDAO;
import br.com.easynet.easyportal.dao.Usu_usuarioDAO;
import br.com.easynet.easyportal.jb.UsuariosPerfilJB;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import br.com.easynet.easyportal.transfer.Pu_per_usuT;
import br.com.easynet.easyportal.transfer.Usu_usuarioT;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author I9
 */
public class Usuario_sistemaConsultJB extends  SystemBase{
    private List<Usu_usuarioT> list = new Vector();
    private Usu_usuarioT usu_usuarioT = new Usu_usuarioT();
    private Per_perfilT per_perfilT = new Per_perfilT();

    private Pu_per_usuT pu_per_usuT = new  Pu_per_usuT();

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

     public void removerUsuarioDoPerfil(){
         Pu_per_usuDAO dAO = null;
          try {
            dAO = getPu_per_usuDAO();
            dAO.delete(pu_per_usuT);
            setMsg("removido com sucesso");
        } catch (Exception ex) {
            setMsg("erro ao remover");
            ex.printStackTrace();
        }finally{
            dAO.close();
        }

    }
     public void adicionarUsuarioAoPerfil(){
         Pu_per_usuDAO dAO = null;
         try {
        //    setMsg("adicionarUsuarioAoPerfil"+usu_usuarioT.getUsu_tx_nome());
            dAO = getPu_per_usuDAO();
            dAO.delete(pu_per_usuT);
            dAO.insert(pu_per_usuT);
            setMsg("adicionado com sucesso");
        } catch (Exception ex) {
            setMsg("erro ao inserir");
             ex.printStackTrace();
        }finally{
            dAO.close();
        }

    }

    public void consult(){
        Usu_usuarioDAO dAO=null;
        try {
            dAO = getUsu_usuarioDAO();
            list = dAO.getAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            dAO.close();
        }
    }
    
    public void ususriosPerfil(){
        Usu_usuarioDAO dAO = null;
        try {
             dAO = getUsu_usuarioDAO();
            list = dAO.getUsuariosPerfil(getPer_perfilT());
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            dAO.close();
        }
    }
    public void usuariosNaoPerfil(){
        Usu_usuarioDAO dAO = null;
        try {
            dAO = getUsu_usuarioDAO();
            list = dAO.getUsuariosNaoPerfil(getPer_perfilT());
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            dAO.close();
        }
    }
    public void delete(){
        Usu_usuarioDAO dAO = null;
        try {
            dAO = getUsu_usuarioDAO();
            dAO.delete(usu_usuarioT);
            setMsg("Exclusão efetuada com sucesso!");
        } catch (Exception e) {
             setMsg("Falha ao realizar exclusão!");
        }finally{
            dAO.close();
        }
    }
    /**
     * @return the list
     */
    public List<Usu_usuarioT> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Usu_usuarioT> list) {
        this.list = list;
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

    /**
     * @return the per_perfilT
     */
    public Per_perfilT getPer_perfilT() {
        return per_perfilT;
    }

    /**
     * @param per_perfilT the per_perfilT to set
     */
    public void setPer_perfilT(Per_perfilT per_perfilT) {
        this.per_perfilT = per_perfilT;
    }

    /**
     * @return the pu_per_usuT
     */
    public Pu_per_usuT getPu_per_usuT() {
        return pu_per_usuT;
    }

    /**
     * @param pu_per_usuT the pu_per_usuT to set
     */
    public void setPu_per_usuT(Pu_per_usuT pu_per_usuT) {
        this.pu_per_usuT = pu_per_usuT;
    }


}
