package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.dao.Met_metodoDAO;
import br.com.easynet.easyportal.dao.Ope_operacaoDAO;
import br.com.easynet.easyportal.transfer.Met_metodoT;
import br.com.easynet.easyportal.transfer.Ope_operacaoT;
import br.com.easynet.easyportal.transfer.Per_perfilT;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Met_metodoConsult_JB extends SystemBase {

    // Atributos e propriedades
    private Met_metodoT met_metodoT = new Met_metodoT();
    private Per_perfilT per_pefilT = new Per_perfilT();
    private boolean allSistema;
    private String dd;
    private TreeMap<Integer,Ope_operacaoT> treeOp = new TreeMap<Integer, Ope_operacaoT>();

    public void setMet_metodoT(Met_metodoT met_metodoT) {
        this.met_metodoT = met_metodoT;
    }

    public Met_metodoT getMet_metodoT() {
        return met_metodoT;
    }
    private List<Met_metodoT> list;
    private List<met_metodoTMP> listTmp;

    public List<Met_metodoT> getList() {
        return list;
    }

    public void setList(List<Met_metodoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();

    }

    public void consult() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = getMet_metodoDAO();
            list = met_metodoDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
        }
    }

    public void consultMetodosPerfil() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        Ope_operacaoDAO ope_operacaoDAO = null;
        try {
            met_metodoDAO = getMet_metodoDAO();
            if(!allSistema){
                list = met_metodoDAO.getByMetodosPerfil(per_pefilT, met_metodoT);
            }else{
                list = met_metodoDAO.getAllMetodosPerfilSistema(per_pefilT, met_metodoT);
            }
            ope_operacaoDAO = getOpe_operacaoDAO();
            Ope_operacaoT ope_operacaoT = new Ope_operacaoT();
            ope_operacaoT.setSis_nr_id(met_metodoT.getSis_nr_id());
            List<Ope_operacaoT> listOp =ope_operacaoDAO.getBySis_sistema(ope_operacaoT);
            povoaTreeOperacao(listOp);
            povoaListTemp();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
            ope_operacaoDAO.close();
        }
    }

    private void povoaTreeOperacao(List<Ope_operacaoT> listOp) {
        for (Ope_operacaoT ope_operacaoT : listOp) {
            getTreeOp().put(ope_operacaoT.getOpe_nr_id(), ope_operacaoT);
        }
    }
 
    public void consultMetodosNaoPerfil() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        Ope_operacaoDAO ope_operacaoDAO = null;
        try {
            met_metodoDAO = getMet_metodoDAO();
            list = met_metodoDAO.getByMetodosNaoPerfil(per_pefilT, met_metodoT);

            ope_operacaoDAO = getOpe_operacaoDAO();
            Ope_operacaoT ope_operacaoT = new Ope_operacaoT();
            ope_operacaoT.setSis_nr_id(met_metodoT.getSis_nr_id());
            List<Ope_operacaoT> listOp =ope_operacaoDAO.getBySis_sistema(ope_operacaoT);
            povoaTreeOperacao(listOp);

            povoaListTemp();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            met_metodoDAO.close();
            ope_operacaoDAO.close();
        }
    }

    public void povoaListTemp(){
        listTmp = new ArrayList<met_metodoTMP>();
        for (Met_metodoT met_metodoT : list) {
            met_metodoTMP tMP = new met_metodoTMP();
            tMP.setMet_nr_id(met_metodoT.getMet_nr_id());
            tMP.setMet_tx_descricao(met_metodoT.getMet_tx_descricao());
            tMP.setMet_tx_metodo(met_metodoT.getMet_tx_metodo());
            tMP.setMet_tx_status(met_metodoT.getMet_tx_status());
            tMP.setOpe_nr_id(met_metodoT.getOpe_nr_id());
            tMP.setOpe_tx_nome(treeOp.get(met_metodoT.getOpe_nr_id()).getOpe_tx_nome());
            tMP.setSis_nr_id(met_metodoT.getSis_nr_id());
            listTmp.add(tMP);
            
        }
    }

    
    public void delete() throws Exception {
        Met_metodoDAO met_metodoDAO = null;
        try {
            met_metodoDAO = getMet_metodoDAO();
            met_metodoDAO.delete(met_metodoT);
            setMsg("Exclus�o efetuada com sucesso!");
            met_metodoT = new Met_metodoT();
            consult();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            met_metodoDAO.close();
        }
    }

    public void insert() throws Exception {
        // TODO Insert
        try {
            String page = "met_metodoInsert.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the per_pefilT
     */
    public Per_perfilT getPer_pefilT() {
        return per_pefilT;
    }

    /**
     * @param per_pefilT the per_pefilT to set
     */
    public void setPer_pefilT(Per_perfilT per_pefilT) {
        this.per_pefilT = per_pefilT;
    }

    /**
     * @return the allSistema
     */
    public boolean getAllSistema() {
        return allSistema;
    }

    /**
     * @param allSistema the allSistema to set
     */
    public void setAllSistema(boolean allSistema) {
        this.allSistema = allSistema;
    }

    /**
     * @return the treeOp
     */
    public TreeMap<Integer, Ope_operacaoT> getTreeOp() {
        return treeOp;
    }

    /**
     * @param treeOp the treeOp to set
     */
    public void setTreeOp(TreeMap<Integer, Ope_operacaoT> treeOp) {
        this.treeOp = treeOp;
    }

    /**
     * @return the listTmp
     */
    public List<met_metodoTMP> getListTmp() {
        return listTmp;
    }

    /**
     * @param listTmp the listTmp to set
     */
    public void setListTmp(List<met_metodoTMP> listTmp) {
        this.listTmp = listTmp;
    }

   public class met_metodoTMP{

        private  int ope_nr_id;
        private int met_nr_id;
        private String met_tx_metodo;
        private String met_tx_descricao;
        private String met_tx_status;
        private int sis_nr_id;
        private String ope_tx_nome;

        /**
         * @return the ope_nr_id
         */
        public int getOpe_nr_id() {
            return ope_nr_id;
        }

        /**
         * @param ope_nr_id the ope_nr_id to set
         */
        public void setOpe_nr_id(int ope_nr_id) {
            this.ope_nr_id = ope_nr_id;
        }

        /**
         * @return the met_nr_id
         */
        public int getMet_nr_id() {
            return met_nr_id;
        }

        /**
         * @param met_nr_id the met_nr_id to set
         */
        public void setMet_nr_id(int met_nr_id) {
            this.met_nr_id = met_nr_id;
        }

        /**
         * @return the met_tx_metodo
         */
        public String getMet_tx_metodo() {
            return met_tx_metodo;
        }

        /**
         * @param met_tx_metodo the met_tx_metodo to set
         */
        public void setMet_tx_metodo(String met_tx_metodo) {
            this.met_tx_metodo = met_tx_metodo;
        }

        /**
         * @return the met_tx_descricao
         */
        public String getMet_tx_descricao() {
            return met_tx_descricao;
        }

        /**
         * @param met_tx_descricao the met_tx_descricao to set
         */
        public void setMet_tx_descricao(String met_tx_descricao) {
            this.met_tx_descricao = met_tx_descricao;
        }

        /**
         * @return the met_tx_status
         */
        public String getMet_tx_status() {
            return met_tx_status;
        }

        /**
         * @param met_tx_status the met_tx_status to set
         */
        public void setMet_tx_status(String met_tx_status) {
            this.met_tx_status = met_tx_status;
        }

        /**
         * @return the sis_nr_id
         */
        public int getSis_nr_id() {
            return sis_nr_id;
        }

        /**
         * @param sis_nr_id the sis_nr_id to set
         */
        public void setSis_nr_id(int sis_nr_id) {
            this.sis_nr_id = sis_nr_id;
        }

        /**
         * @return the ope_tx_nome
         */
        public String getOpe_tx_nome() {
            return ope_tx_nome;
        }

        /**
         * @param ope_tx_nome the ope_tx_nome to set
         */
        public void setOpe_tx_nome(String ope_tx_nome) {
            this.ope_tx_nome = ope_tx_nome;
        }
    }
}
