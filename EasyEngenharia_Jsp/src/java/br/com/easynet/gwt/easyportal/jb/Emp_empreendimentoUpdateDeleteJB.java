package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class Emp_empreendimentoUpdateDeleteJB extends SystemBase {

    // Atributos e propriedades
    private Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();

    public void setEmp_empreendimentoT(Emp_empreendimentoT emp_empreendimentoT) {
        this.emp_empreendimentoT = emp_empreendimentoT;
    }

    public Emp_empreendimentoT getEmp_empreendimentoT() {
        return emp_empreendimentoT;
    }
    private List<Emp_empreendimentoT> list;

    public List<Emp_empreendimentoT> getList() {
        return list;
    }

    public void setList(List<Emp_empreendimentoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void clear() throws Exception {

        emp_empreendimentoT = new Emp_empreendimentoT();
    }

    public void delete() throws Exception {
        try {
            if (exist()) {
                Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
                emp_empreendimentoDAO.delete(emp_empreendimentoT);
                setMsg("Exclusão efetuada com sucesso!");
                clear();
            } else {
                setMsg("Error: Registro inexistente!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }

    public boolean exist() throws Exception {
        try {
            Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
            List<Emp_empreendimentoT> listTemp = emp_empreendimentoDAO.getByPK(emp_empreendimentoT);

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
            if (exist()) {
                Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
                if (emp_empreendimentoT.getEmp_bt_logo() == null) {
                    emp_empreendimentoDAO.update(emp_empreendimentoT);
                } else {
                    emp_empreendimentoDAO.updateImage(emp_empreendimentoT);
                }
                setMsg("Alteração efetuada com sucesso!");
            } else {
                setMsg("Error: Registro inexistente!");
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
    private List<Cli_clienteT> listcli_cliente;

    public List<Cli_clienteT> getListcli_cliente() {
        return listcli_cliente;
    }

    public void setListcli_cliente(List<Cli_clienteT> list) {
        this.listcli_cliente = list;
    }

    public void consultCli_cliente() throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();
            listcli_cliente = cli_clienteDAO.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //Method Download Image e montando se houver algum campo do tipo binario
    //|DOWNLOADIMAGE|
    public void findbyid() throws Exception {
        try {
            Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
            List<Emp_empreendimentoT> listTemp = emp_empreendimentoDAO.getByPK(emp_empreendimentoT);

            emp_empreendimentoT = listTemp.size() > 0 ? listTemp.get(0) : new Emp_empreendimentoT();

        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * Volta para a pagina de consulta
     */
    public void consult() throws Exception {
        // TODO Consult
        try {
            String page = "emp_empreendimentoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }

    public void cancel() throws Exception {
        // TODO Cancel
        try {
            String page = "emp_empreendimentoConsult.jsp";// defina aqui a pagina que deve ser chamada
            getResponse().sendRedirect(page);
        } catch (Exception e) {
        }
    }
}
