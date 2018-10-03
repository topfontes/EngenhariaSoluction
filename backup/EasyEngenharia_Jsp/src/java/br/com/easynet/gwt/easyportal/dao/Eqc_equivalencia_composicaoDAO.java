package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Eqc_equivalencia_composicaoDAO extends ObjectDAO {

    public Eqc_equivalencia_composicaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.eqc_equivalencia_composicao  ( coa_nr_id, con_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCoa_nr_id());
            pStmt.setObject(2, eqc_equivalencia_composicaoT.getCon_nr_id());
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

    public void update(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.eqc_equivalencia_composicao set - where  coa_nr_id=? and con_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCoa_nr_id());
            pStmt.setObject(2, eqc_equivalencia_composicaoT.getCon_nr_id());
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

    public void delete(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.eqc_equivalencia_composicao where  coa_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCoa_nr_id());
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

    private List<Eqc_equivalencia_composicaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Eqc_equivalencia_composicaoT> objs = new Vector();
        while (rs.next()) {
            Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT = new Eqc_equivalencia_composicaoT();
            eqc_equivalencia_composicaoT.setCoa_nr_id(rs.getInt("coa_nr_id"));
            eqc_equivalencia_composicaoT.setCon_nr_id(rs.getInt("con_nr_id"));
            objs.add(eqc_equivalencia_composicaoT);
        }
        return objs;
    }

    public List<Eqc_equivalencia_composicaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqc_equivalencia_composicao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Eqc_equivalencia_composicaoT> list = resultSetToObjectTransfer(rs);
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

    public DataSet getAllDs() throws Exception {
        DataSet ds = null;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select coa.coa_tx_codigo, coa.coa_tx_descricao, con.con_tx_codigo, con.con_tx_descricao, con.con_tx_unidade from easyconstru.eqc_equivalencia_composicao eqc");
            sql.append(" inner join easyconstru.coa_composicao_anterior coa on(coa.coa_nr_id = eqc.coa_nr_id)");
            sql.append(" inner join easyconstru.con_composicao_nova con on(con.con_nr_id = eqc.con_nr_id)");
            sql.append(" order by con.con_tx_descricao, 2");
            ds = executeQuery(sql.toString(), null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public List<Eqc_equivalencia_composicaoT> getByPK(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqc_equivalencia_composicao where  coa_nr_id=? and con_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCoa_nr_id());
            pStmt.setObject(2, eqc_equivalencia_composicaoT.getCon_nr_id());
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

    public List<Eqc_equivalencia_composicaoT> getByCoa_nr_id(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqc_equivalencia_composicao where  coa_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCoa_nr_id());
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

    public List<Eqc_equivalencia_composicaoT> getByCon_nr_id(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.eqc_equivalencia_composicao where  con_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, eqc_equivalencia_composicaoT.getCon_nr_id());
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
