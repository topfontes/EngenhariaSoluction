package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Eqi_equivalencia_insumoDAO extends ObjectDAO {

    public Eqi_equivalencia_insumoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.eqi_equivalencia_insumo  ( ina_nr_id, inn_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getIna_nr_id());
            pStmt.setObject(2, eqi_equivalencia_insumoT.getInn_nr_id());
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

    public void update(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.eqi_equivalencia_insumo set - where  ina_nr_id=? and inn_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getIna_nr_id());
            pStmt.setObject(2, eqi_equivalencia_insumoT.getInn_nr_id());
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

    public void delete(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.eqi_equivalencia_insumo where  ina_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getIna_nr_id());
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

    private List<Eqi_equivalencia_insumoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Eqi_equivalencia_insumoT> objs = new Vector();
        while (rs.next()) {
            Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();
            eqi_equivalencia_insumoT.setIna_nr_id(rs.getInt("ina_nr_id"));
            eqi_equivalencia_insumoT.setInn_nr_id(rs.getInt("inn_nr_id"));
            objs.add(eqi_equivalencia_insumoT);
        }
        return objs;
    }

    private TreeMap<String,Eqi_equivalencia_insumoT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String,Eqi_equivalencia_insumoT> objs = new TreeMap<String,Eqi_equivalencia_insumoT>();
        while (rs.next()) {
            Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();
            eqi_equivalencia_insumoT.setIna_nr_id(rs.getInt("ina_nr_id"));
            eqi_equivalencia_insumoT.setInn_nr_id(rs.getInt("inn_nr_id"));
            String key = eqi_equivalencia_insumoT.getIna_nr_id()+"."+eqi_equivalencia_insumoT.getInn_nr_id();
            objs.put(key,eqi_equivalencia_insumoT);
        }
        return objs;
    }

    public List<Eqi_equivalencia_insumoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqi_equivalencia_insumo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Eqi_equivalencia_insumoT> list = resultSetToObjectTransfer(rs);
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

    public List<Eqi_equivalencia_insumoT> getByPK(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqi_equivalencia_insumo where  ina_nr_id=? and inn_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getIna_nr_id());
            pStmt.setObject(2, eqi_equivalencia_insumoT.getInn_nr_id());
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

    public List<Eqi_equivalencia_insumoT> getByIna_nr_id(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqi_equivalencia_insumo where  ina_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getIna_nr_id());
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

    public List<Eqi_equivalencia_insumoT> getByInn_nr_id(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqi_equivalencia_insumo where  inn_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqi_equivalencia_insumoT.getInn_nr_id());
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

    public TreeMap<String,Eqi_equivalencia_insumoT> getByEquivalencia() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqi_equivalencia_insumo ";
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
}
