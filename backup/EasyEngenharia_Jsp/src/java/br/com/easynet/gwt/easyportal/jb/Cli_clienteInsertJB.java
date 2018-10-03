package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.jb.EasyFileUpload;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Cli_clienteInsertJB extends SystemBase {

    // Atributos e propriedades
    private Cli_clienteT cli_clienteT = new Cli_clienteT();

    public void setCli_clienteT(Cli_clienteT cli_clienteT) {
        this.cli_clienteT = cli_clienteT;
    }

    public Cli_clienteT getCli_clienteT() {
        return cli_clienteT;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        //
    }

    // M�todos de Eventos
    public void insert() throws Exception {
        try {
            if (valido()) {
                Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
                cli_clienteDAO.insert(cli_clienteT);
                setMsg("Cadastro efetuado com sucesso!");
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar cadastro!");
        } finally {
            close();
        }
    }

// Method de lookup
// 
    public boolean valido() throws Exception {
        boolean resposta = true;
        Cli_clienteDAO cdao = getCli_clienteDAO();
        try {
            List<Cli_clienteT> ct = cdao.getByCli_tx_cnpj_cpf(cli_clienteT);
            if (ct.size() > 0) {
                String ms = "CPF";
                if (cli_clienteT.getCli_tx_tipo_pessoa().equalsIgnoreCase("J")) {
                    ms = "CNPJ";
                }
                setMsg("Cliente já cadastrado com esse " + ms);
                resposta = false;
            }
        } catch (Exception e) {
            setMsg("Erro");
            return false;
        }
        return resposta;
    }

    public void clear() throws Exception {
        cli_clienteT = new Cli_clienteT();
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "cli_clienteConsult.jsp";// defina aqui a p�gina que deve ser chamada
            getResponse().sendRedirect(page);

        } catch (Exception e) {
        }
    }
}
