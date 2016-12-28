package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Ina_insumo_antigoDAO extends ObjectDAO {

    public Ina_insumo_antigoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxId() throws Exception{
        try {
            String sql = "select max(ina_nr_id)as id from easyconstru.ina_insumo_antigo";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                return rs.getInt("id");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insert(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.ina_insumo_antigo  ( ina_tx_codigo, ina_tx_descricao, ina_tx_unidade) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ina_insumo_antigoT.getIna_tx_codigo());
            pStmt.setObject(2, ina_insumo_antigoT.getIna_tx_descricao());
            pStmt.setObject(3, ina_insumo_antigoT.getIna_tx_unidade());
            pStmt.execute();
            ina_insumo_antigoT.setIna_nr_id(maxId());
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ina_insumo_antigo set  ina_nr_id=?, ina_tx_codigo=?, ina_tx_descricao=?, ina_tx_unidade=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ina_insumo_antigoT.getIna_nr_id());
            pStmt.setObject(2, ina_insumo_antigoT.getIna_tx_codigo());
            pStmt.setObject(3, ina_insumo_antigoT.getIna_tx_descricao());
            pStmt.setObject(4, ina_insumo_antigoT.getIna_tx_unidade());
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

    public void delete(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ina_insumo_antigo where -";
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

    private TreeMap<String, Ina_insumo_antigoT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Ina_insumo_antigoT> objs = new TreeMap<String, Ina_insumo_antigoT>();
        while (rs.next()) {
            Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();
            ina_insumo_antigoT.setIna_nr_id(rs.getInt("ina_nr_id"));
            ina_insumo_antigoT.setIna_tx_codigo(rs.getString("ina_tx_codigo"));
            ina_insumo_antigoT.setIna_tx_descricao(rs.getString("ina_tx_descricao"));
            ina_insumo_antigoT.setIna_tx_unidade(rs.getString("ina_tx_unidade"));
            objs.put(ina_insumo_antigoT.getIna_tx_codigo(),ina_insumo_antigoT);
        }
        return objs;
    }
    private List<Ina_insumo_antigoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ina_insumo_antigoT> objs = new Vector();
        while (rs.next()) {
            Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();
            ina_insumo_antigoT.setIna_nr_id(rs.getInt("ina_nr_id"));
            ina_insumo_antigoT.setIna_tx_codigo(rs.getString("ina_tx_codigo"));
            ina_insumo_antigoT.setIna_tx_descricao(rs.getString("ina_tx_descricao"));
            ina_insumo_antigoT.setIna_tx_unidade(rs.getString("ina_tx_unidade"));
            objs.add(ina_insumo_antigoT);
        }
        return objs;
    }

    public List<Ina_insumo_antigoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where ina_nr_id not in(select ina_nr_id from easyconstru.eqi_equivalencia_insumo)";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ina_insumo_antigoT> list = resultSetToObjectTransfer(rs);
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

    public List<Ina_insumo_antigoT> getAllEquiv(int inn_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where ina_nr_id in(select ina_nr_id from easyconstru.eqi_equivalencia_insumo where inn_nr_id =?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inn_nr_id);
            rs = pStmt.executeQuery();
            List<Ina_insumo_antigoT> list = resultSetToObjectTransfer(rs);
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

    public TreeMap<String,Ina_insumo_antigoT> getAllTree() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo";
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

    public List<Ina_insumo_antigoT> getByPK(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where -";
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

    public List<Ina_insumo_antigoT> getByIna_nr_id(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where  ina_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ina_insumo_antigoT.getIna_nr_id());
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

    public List<Ina_insumo_antigoT> getByIna_tx_codigo(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where  Upper(ina_tx_codigo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ina_insumo_antigoT.getIna_tx_codigo() + '%');
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

    public List<Ina_insumo_antigoT> getByIna_tx_descricao(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where  Upper(ina_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ina_insumo_antigoT.getIna_tx_descricao() + '%');
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

    public List<Ina_insumo_antigoT> getByIna_tx_unidade(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ina_insumo_antigo where  Upper(ina_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ina_insumo_antigoT.getIna_tx_unidade() + '%');
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
