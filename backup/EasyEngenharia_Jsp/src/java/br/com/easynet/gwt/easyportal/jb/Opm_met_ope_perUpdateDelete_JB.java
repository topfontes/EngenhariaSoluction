package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Op_ope_perDAO;
import br.com.easynet.easyportal.transfer.Op_ope_perT;




/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Opm_met_ope_perUpdateDelete_JB extends SystemBase {

    private Op_ope_perT op_ope_perT = new Op_ope_perT();


    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void adicionarOpm_met_ope_per(){
        Op_ope_perDAO dAO = null;
        try {
            dAO = getOp_ope_perDAO();
            dAO.delete(op_ope_perT);
            dAO.insert(op_ope_perT);
            setMsg("adicionado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("erro ao adicionar!");
        } finally {
            dAO.close();
        }
    }
    
    public void removerOpm_met_ope_per(){
        Op_ope_perDAO dAO = null;
        try {
            dAO = getOp_ope_perDAO();
            dAO.delete(op_ope_perT);
            setMsg("removido com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("erro ao remover!");
        } finally {
            dAO.close();
        }
    }

    /**
     * @return the op_ope_perT
     */
    public Op_ope_perT getOp_ope_perT() {
        return op_ope_perT;
    }

    /**
     * @param op_ope_perT the op_ope_perT to set
     */
    public void setOp_ope_perT(Op_ope_perT op_ope_perT) {
        this.op_ope_perT = op_ope_perT;
    }

}
