package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Inn_insumo_novoDAO extends ObjectDAO {

    private static final String ASPAS = "\"";

    public Inn_insumo_novoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxid() {
        try {
            String sql = "select max(Inn_nr_id)as id from easyconstru.inn_insumo_novo";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("id");
            }

        } catch (Exception e) {
        }
        return 1;
    }

    public void insert(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.inn_insumo_novo  ( inn_tx_codigo, inn_tx_descricao, inn_tx_unidade) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inn_insumo_novoT.getInn_tx_codigo());
            pStmt.setObject(2, inn_insumo_novoT.getInn_tx_descricao());
            pStmt.setObject(3, inn_insumo_novoT.getInn_tx_unidade());
            pStmt.execute();
            inn_insumo_novoT.setInn_nr_id(maxid());
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.inn_insumo_novo set  inn_nr_id=?, inn_tx_codigo=?, inn_tx_descricao=?, inn_tx_unidade=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inn_insumo_novoT.getInn_nr_id());
            pStmt.setObject(2, inn_insumo_novoT.getInn_tx_codigo());

            pStmt.setObject(3, inn_insumo_novoT.getInn_tx_descricao());
            pStmt.setObject(4, inn_insumo_novoT.getInn_tx_unidade());
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

    public void delete(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.inn_insumo_novo where -";
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

    private TreeMap<String, Inn_insumo_novoT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Inn_insumo_novoT> objs = new TreeMap<String, Inn_insumo_novoT>();
        while (rs.next()) {
            Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();
            inn_insumo_novoT.setInn_nr_id(rs.getInt("inn_nr_id"));
            inn_insumo_novoT.setInn_tx_codigo(rs.getString("inn_tx_codigo"));
            inn_insumo_novoT.setInn_tx_descricao(rs.getString("inn_tx_descricao"));
            inn_insumo_novoT.setInn_tx_unidade(rs.getString("inn_tx_unidade"));
            objs.put(inn_insumo_novoT.getInn_tx_codigo(), inn_insumo_novoT);
        }
        return objs;
    }

    private List<Inn_insumo_novoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Inn_insumo_novoT> objs = new Vector();
        while (rs.next()) {
            Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();
            inn_insumo_novoT.setInn_nr_id(rs.getInt("inn_nr_id"));
            inn_insumo_novoT.setInn_tx_codigo(rs.getString("inn_tx_codigo"));
            String nome = rs.getString("inn_tx_descricao");
            nome = nome.replace(ASPAS, "''");
            nome = nome.replace("\r", " ");
            nome = nome.replace("\n", " ");
            inn_insumo_novoT.setInn_tx_descricao(nome);
            inn_insumo_novoT.setInn_tx_unidade(rs.getString("inn_tx_unidade"));
            objs.add(inn_insumo_novoT);
        }
        return objs;
    }

    public List<Inn_insumo_novoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Inn_insumo_novoT> list = resultSetToObjectTransfer(rs);
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

    public TreeMap<String, Inn_insumo_novoT> getAllTree() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferTree(rs);
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

    public List<Inn_insumo_novoT> getByPK(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo where -";
            pStmt = con.prepareStatement(sql);
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

    public List<Inn_insumo_novoT> getByInn_nr_id(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo where  inn_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inn_insumo_novoT.getInn_nr_id());
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

    public List<Inn_insumo_novoT> getByInn_tx_codigo(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo where  Upper(inn_tx_codigo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inn_insumo_novoT.getInn_tx_codigo() + '%');
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

    public List<Inn_insumo_novoT> getByInn_tx_descricao(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo where  Upper(inn_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inn_insumo_novoT.getInn_tx_descricao() + '%');
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

    public List<Inn_insumo_novoT> getByInn_tx_unidade(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inn_insumo_novo where  Upper(inn_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inn_insumo_novoT.getInn_tx_unidade() + '%');
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
