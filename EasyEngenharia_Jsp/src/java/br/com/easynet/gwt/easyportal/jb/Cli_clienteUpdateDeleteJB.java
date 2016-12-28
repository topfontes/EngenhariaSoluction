package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cli_clienteUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();

    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    public Cli_clienteT getCli_clienteT() {
        return cli_clienteT;
    }
    private List<Cli_clienteT> list;

    public List<Cli_clienteT> getList() {
        return list;
    }

    public void setList(List<Cli_clienteT> list) {
        this.list = list;
    }
    private int id;

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    public void clear() throws Exception {

        cli_clienteT = new Cli_clienteT();
    }

    public void delete() throws Exception {
        try {

            if (exist()) {
                Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                cli_clienteDAO.delete(cli_clienteT);
                setMsg("Exclus�o efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclus�o!");
        } finally {
            close();
        }
    }

    public boolean valido() throws Exception {
        boolean resposta = true;
        Cli_clienteDAO cdao = getCli_clienteDAO();
        try {
            List<Cli_clienteT> ct = cdao.getByCli_tx_cnpj_cpf(cli_clienteT);
            if (ct.size() > 0) {
                if (ct.get(0).getCli_nr_id() != cli_clienteT.getCli_nr_id()) {
                    String ms = "CPF";
                    if (cli_clienteT.getCli_tx_tipo_pessoa().equalsIgnoreCase("J")) {
                        ms = "CNPJ";
                    }
                    setMsg("Cliente " + ct.get(0).getCli_tx_nome() + " já cadastrado com esse " + ms);
                    resposta = false;
                }
            }
        } catch (Exception e) {
            setMsg("Erro");
            return false;
        }
        return resposta;
    }

    public boolean exist() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            return listTemp.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
        return false;

    }

    public void update() throws Exception {
        try {
            if (valido()) {
                if (exist()) {
                    Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                    cli_clienteDAO.update(cli_clienteT);
                    setMsg("Alteração efetuada com sucesso!");
                } else {
                    setMsg("Error: Registro inexistente!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar alteração!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    //Method Download Image � montando se houver algum campo do tipo binario
    //
    /**
     * Download de Imagem caso existe sen�o pode remover
     */
    public void downloadImage() throws Exception {
        try {
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "cli_clienteT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, cli_clienteT.getCli_by_logomarca());
            getPage().forward("easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    public void findbyid() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            cli_clienteT = listTemp.size() > 0 ? listTemp.get(0) : new Cli_clienteT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a página de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "cli_clienteConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cli_clienteConsult.jsp";// defina aqui a página que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
