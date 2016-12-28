package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Emp_empreendimentoDAO extends ObjectDAO {

    public Emp_empreendimentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.emp_empreendimento  ( emp_tx_nome, emp_tx_endereco, emp_tx_bairro, emp_tx_cidade, emp_tx_uf, cli_nr_id, emp_bt_logo) values ( ?, ? , ? , ? , ? , ? ,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_tx_nome());
            pStmt.setObject(2, emp_empreendimentoT.getEmp_tx_endereco());
            pStmt.setObject(3, emp_empreendimentoT.getEmp_tx_bairro());
            pStmt.setObject(4, emp_empreendimentoT.getEmp_tx_cidade());
            pStmt.setObject(5, emp_empreendimentoT.getEmp_tx_uf());
            pStmt.setObject(6, emp_empreendimentoT.getCli_nr_id());
            pStmt.setObject(7, emp_empreendimentoT.getEmp_bt_logo());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void updateImage(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.emp_empreendimento set  emp_tx_nome=?, emp_tx_endereco=? ,emp_tx_bairro=?, emp_tx_cidade=?, emp_tx_uf=?, cli_nr_id=?, emp_bt_logo=?  where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_tx_nome());
            pStmt.setObject(2, emp_empreendimentoT.getEmp_tx_endereco());
            pStmt.setObject(3, emp_empreendimentoT.getEmp_tx_bairro());
            pStmt.setObject(4, emp_empreendimentoT.getEmp_tx_cidade());
            pStmt.setObject(5, emp_empreendimentoT.getEmp_tx_uf());
            pStmt.setObject(6, emp_empreendimentoT.getCli_nr_id());
            pStmt.setObject(7, emp_empreendimentoT.getEmp_bt_logo());
            pStmt.setObject(8, emp_empreendimentoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.emp_empreendimento set  emp_tx_nome=?, emp_tx_endereco=? ,emp_tx_bairro=?, emp_tx_cidade=?, emp_tx_uf=?, cli_nr_id=? where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_tx_nome());
            pStmt.setObject(2, emp_empreendimentoT.getEmp_tx_endereco());
            pStmt.setObject(3, emp_empreendimentoT.getEmp_tx_bairro());
            pStmt.setObject(4, emp_empreendimentoT.getEmp_tx_cidade());
            pStmt.setObject(5, emp_empreendimentoT.getEmp_tx_uf());
            pStmt.setObject(6, emp_empreendimentoT.getCli_nr_id());
            pStmt.setObject(7, emp_empreendimentoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.emp_empreendimento where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_nr_id());
            pStmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    private List<Emp_empreendimentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Emp_empreendimentoT> objs = new Vector();
        while (rs.next()) {
            Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
            emp_empreendimentoT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            emp_empreendimentoT.setEmp_tx_nome(rs.getString("emp_tx_nome"));
            emp_empreendimentoT.setEmp_tx_bairro(rs.getString("emp_tx_bairro"));
            emp_empreendimentoT.setEmp_tx_endereco(rs.getString("emp_tx_endereco"));
            emp_empreendimentoT.setEmp_tx_cidade(rs.getString("emp_tx_cidade"));
            emp_empreendimentoT.setEmp_tx_uf(rs.getString("emp_tx_uf"));
            emp_empreendimentoT.setCli_nr_id(rs.getInt("cli_nr_id"));
            objs.add(emp_empreendimentoT);
        }
        return objs;
    }

    public List<Emp_empreendimentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento order by emp_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Emp_empreendimentoT> list = resultSetToObjectTransfer(rs);
            return list;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public DataSet getAllDataSet() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select emp.emp_nr_id, emp.emp_tx_nome, emp.emp_tx_endereco, emp.emp_tx_bairro, emp.emp_tx_cidade, emp.emp_tx_uf, emp.cli_nr_id, cliente.cli_tx_nome  from easyconstru.emp_empreendimento as emp inner join easyconstru.cli_cliente as cliente on(cliente.cli_nr_id = emp.cli_nr_id) ";
            DataSet ds = new DataSet();
            ds = executeQuery(sql, null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByPK(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  emp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByEmp_nr_id(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getEmp_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByEmp_tx_nome(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  Upper(emp_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_empreendimentoT.getEmp_tx_nome() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByEmp_tx_bairro(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  Upper(emp_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_empreendimentoT.getEmp_tx_bairro() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByEmp_tx_cidade(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  Upper(emp_tx_cidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_empreendimentoT.getEmp_tx_cidade() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByEmp_tx_uf(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  Upper(emp_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + emp_empreendimentoT.getEmp_tx_uf() + '%');
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public List<Emp_empreendimentoT> getByCli_nr_id(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    /** M�todos FK */
    public List<Emp_empreendimentoT> getByCli_cliente(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.emp_empreendimento where cli_cliente.cli_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, emp_empreendimentoT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public DataSet getByEmpreendimentoObra(int obr_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select emp.emp_tx_nome, cliente.cli_tx_nome,emp.emp_tx_cidade, emp.emp_tx_uf, cliente.cli_by_logomarca from easyconstru.obr_obras obra");
            sql.append(" inner join easyconstru.emp_empreendimento emp on(emp.emp_nr_id = obra.emp_nr_id)");
            sql.append(" inner join easyconstru.cli_cliente cliente on(cliente.cli_nr_id = emp.cli_nr_id)");
            sql.append(" where obra.obr_nr_id = ?");
            Object[] param = new Object[1];
            param[0] = obr_nr_id;
            ds = executeQuery(sql.toString(), param);

        } catch (Exception e) {
            throw e;
        } finally {
        }
        return ds;
    }
    
    public int getByCliObra(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;        
        int cli_nr_id =0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select emp.cli_nr_id from easyconstru.obr_obras obra");
            sql.append(" inner join easyconstru.emp_empreendimento emp on(emp.emp_nr_id = obra.emp_nr_id)");
            sql.append(" where obra.obr_nr_id = ?");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            rs = pStmt.executeQuery();
            if (rs.next()){
                cli_nr_id = rs.getInt("cli_nr_id");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return cli_nr_id;
    }
    
}
