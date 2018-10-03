package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Fto_fotosInsertJB extends SystemBase {

    // Atributos e propriedades
    private Fto_fotosT fto_fotosT = new Fto_fotosT();

    public void setFto_fotosT(Fto_fotosT fto_fotosT) {
        this.fto_fotosT = fto_fotosT;
    }

    public Fto_fotosT getFto_fotosT() {
        return fto_fotosT;
    }
    private int obra;

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    // M�todos de Eventos
    public void insert() throws Exception {

        try {
            Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
            fto_fotosDAO.insert(fto_fotosT);
            setMsg("Cadastro efetuado com sucesso!");
            clear();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    public void clear() throws Exception {

        fto_fotosT = new Fto_fotosT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "fto_fotosConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the obra
     */
    public int getObra() {
        return obra;
    }

    /**
     * @param obra the obra to set
     */
    public void setObra(int obra) {
        this.obra = obra;
    }
}
