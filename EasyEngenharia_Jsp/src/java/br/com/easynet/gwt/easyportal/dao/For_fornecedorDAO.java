package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class For_fornecedorDAO extends ObjectDAO {

    public For_fornecedorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    private static Object insert = "true";

    public int maxId()throws Exception{
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "select  max(for_nr_id) as id from easyconstru.for_fornecedor";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public void insert(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        synchronized (insert) {
            try {
                String sql = "insert into easyconstru.for_fornecedor  ( for_tx_nome, for_tx_cnpj, for_tx_endereco, for_tx_bairro, for_tx_cidade, for_tx_uf, for_tx_contato, for_tx_telefone, for_tx_email) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, for_fornecedorT.getFor_tx_nome().trim());
                pStmt.setObject(2, for_fornecedorT.getFor_tx_cnpj());
                pStmt.setObject(3, for_fornecedorT.getFor_tx_endereco());
                pStmt.setObject(4, for_fornecedorT.getFor_tx_bairro());
                pStmt.setObject(5, for_fornecedorT.getFor_tx_cidade());
                pStmt.setObject(6, for_fornecedorT.getFor_tx_uf());
                pStmt.setObject(7, for_fornecedorT.getFor_tx_contato());
                pStmt.setObject(8, for_fornecedorT.getFor_tx_telefone());
                pStmt.setObject(9, for_fornecedorT.getFor_tx_email());
                pStmt.execute();
                for_fornecedorT.setFor_nr_id(maxId());

            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    pStmt.close();
                } catch (Exception e) {
                }

            }
        }
    }

    public void update(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.for_fornecedor set  for_tx_nome=?, for_tx_cnpj=?, for_tx_endereco=?, for_tx_bairro=?, for_tx_cidade=?, for_tx_uf=?, for_tx_contato=?, for_tx_telefone=?, for_tx_email=?  where  for_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_tx_nome().trim());
            pStmt.setObject(2, for_fornecedorT.getFor_tx_cnpj());
            pStmt.setObject(3, for_fornecedorT.getFor_tx_endereco());
            pStmt.setObject(4, for_fornecedorT.getFor_tx_bairro());
            pStmt.setObject(5, for_fornecedorT.getFor_tx_cidade());
            pStmt.setObject(6, for_fornecedorT.getFor_tx_uf());
            pStmt.setObject(7, for_fornecedorT.getFor_tx_contato());
            pStmt.setObject(8, for_fornecedorT.getFor_tx_telefone());
            pStmt.setObject(9, for_fornecedorT.getFor_tx_email());
            pStmt.setObject(10, for_fornecedorT.getFor_nr_id());
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

    public void delete(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.for_fornecedor where  for_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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
    
    public void deleteAll(String ids) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.for_fornecedor where  for_nr_id in("+ids+")";
            pStmt = con.prepareStatement(sql);
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

    private List<For_fornecedorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<For_fornecedorT> objs = new Vector();
        while (rs.next()) {
            For_fornecedorT for_fornecedorT = new For_fornecedorT();
            for_fornecedorT.setFor_nr_id(rs.getInt("for_nr_id"));
            for_fornecedorT.setFor_tx_nome(rs.getString("for_tx_nome"));
            for_fornecedorT.setFor_tx_cnpj(rs.getString("for_tx_cnpj"));
            for_fornecedorT.setFor_tx_endereco(rs.getString("for_tx_endereco"));
            for_fornecedorT.setFor_tx_bairro(rs.getString("for_tx_bairro"));
            for_fornecedorT.setFor_tx_cidade(rs.getString("for_tx_cidade"));
            for_fornecedorT.setFor_tx_uf(rs.getString("for_tx_uf"));
            for_fornecedorT.setFor_tx_contato(rs.getString("for_tx_contato"));
            for_fornecedorT.setFor_tx_telefone(rs.getString("for_tx_telefone"));
            for_fornecedorT.setFor_tx_email(rs.getString("for_tx_email"));
            objs.add(for_fornecedorT);
        }
        return objs;
    }

    public List<For_fornecedorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor order by for_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<For_fornecedorT> list = resultSetToObjectTransfer(rs);
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

    public List<For_fornecedorT> getByPK(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where for_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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

    public List<For_fornecedorT> getByFor_nr_id(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  for_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, for_fornecedorT.getFor_nr_id());
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

    public List<For_fornecedorT> getByFor_tx_nome(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_nome) like Upper(?) order by for_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_nome() + '%');
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

    public List<For_fornecedorT> getByFor_tx_cnpj(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_cnpj) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_cnpj() + '%');
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

    public List<For_fornecedorT> getByFor_tx_endereco(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_endereco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_endereco() + '%');
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

    public List<For_fornecedorT> getByFor_tx_bairro(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_bairro() + '%');
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

    public List<For_fornecedorT> getByFor_tx_cidade(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_cidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_cidade() + '%');
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

    public List<For_fornecedorT> getByFor_tx_uf(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_uf() + '%');
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

    public List<For_fornecedorT> getByFor_tx_contato(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_contato) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_contato() + '%');
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

    public List<For_fornecedorT> getByFor_tx_telefone(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_telefone) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_telefone() + '%');
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

    public List<For_fornecedorT> getByFor_tx_email(For_fornecedorT for_fornecedorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.for_fornecedor where  Upper(for_tx_email) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + for_fornecedorT.getFor_tx_email() + '%');
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
}
