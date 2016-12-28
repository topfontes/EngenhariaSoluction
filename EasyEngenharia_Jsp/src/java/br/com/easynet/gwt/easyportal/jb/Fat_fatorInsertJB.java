package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Fat_fatorInsertJB extends SystemBase {

    // Atributos e propriedades
    private Fat_fatorT fat_fatorT = new Fat_fatorT();

    public void setFat_fatorT(Fat_fatorT fat_fatorT) {
        this.fat_fatorT = fat_fatorT;
    }

    public Fat_fatorT getFat_fatorT() {
        return fat_fatorT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();
            int id = fatorExiste(fat_fatorT);
            if (id == 0){
                fat_fatorDAO.insert(fat_fatorT);
            }else{
                fat_fatorT.setFat_nr_id(id);
                fat_fatorDAO.update(fat_fatorT);
            }
            setMsg("Cadastro efetuado com sucesso!");
            clear();
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

    public int fatorExiste(Fat_fatorT fat_T) throws Exception{
        try {
            Fat_fatorDAO dAO = getFat_fatorDAO();
            Fat_fatorT ft = dAO.FatorExiste(fat_T);
            return ft != null ? ft.getFat_nr_id() : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
// Method de lookup
// 
    private List<Plc_plano_contasT> listplc_plano_contas;

    public List<Plc_plano_contasT> getListplc_plano_contas() {
        return listplc_plano_contas;
    }

    public void setListplc_plano_contas(List<Plc_plano_contasT> list) {
        this.listplc_plano_contas = list;
    }
    private List<Obr_obrasT> listobr_obras;

    public List<Obr_obrasT> getListobr_obras() {
        return listobr_obras;
    }

    public void setListobr_obras(List<Obr_obrasT> list) {
        this.listobr_obras = list;
    }

    public void clear() throws Exception {

        fat_fatorT = new Fat_fatorT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "fat_fatorConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
