package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Con_composicao_novaDAO extends ObjectDAO {

    private static final String ASPAS = "\"";

    public Con_composicao_novaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.con_composicao_nova  ( con_tx_codigo, con_tx_descricao, con_tx_unidade) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_composicao_novaT.getCon_tx_codigo());
            pStmt.setObject(2, con_composicao_novaT.getCon_tx_descricao());
            pStmt.setObject(3, con_composicao_novaT.getCon_tx_unidade());
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

    public void update(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.con_composicao_nova set  con_nr_id=?, con_tx_codigo=?, con_tx_descricao=?, con_tx_unidade=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_composicao_novaT.getCon_nr_id());
            pStmt.setObject(2, con_composicao_novaT.getCon_tx_codigo());
            pStmt.setObject(3, con_composicao_novaT.getCon_tx_descricao());
            pStmt.setObject(4, con_composicao_novaT.getCon_tx_unidade());
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

    public void delete(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.con_composicao_nova where -";
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

    private List<Con_composicao_novaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Con_composicao_novaT> objs = new Vector();
        while (rs.next()) {
            Con_composicao_novaT con_composicao_novaT = new Con_composicao_novaT();
            con_composicao_novaT.setCon_nr_id(rs.getInt("con_nr_id"));
            con_composicao_novaT.setCon_tx_codigo(rs.getString("con_tx_codigo"));
            String nome = rs.getString("con_tx_descricao");
            nome = nome.replace(ASPAS, "''");
            nome = nome.replace("\r", " ");
            nome = nome.replace("\n", " ");
            con_composicao_novaT.setCon_tx_descricao(nome);
            con_composicao_novaT.setCon_tx_unidade(rs.getString("con_tx_unidade"));
            objs.add(con_composicao_novaT);
        }
        return objs;
    }

    public List<Con_composicao_novaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Con_composicao_novaT> list = resultSetToObjectTransfer(rs);
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

    public List<Con_composicao_novaT> getByPK(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova where -";
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

    public List<Con_composicao_novaT> getByCon_nr_id(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova where  con_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, con_composicao_novaT.getCon_nr_id());
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

    public List<Con_composicao_novaT> getByCon_tx_codigo(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova where  Upper(con_tx_codigo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + con_composicao_novaT.getCon_tx_codigo() + '%');
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

    public List<Con_composicao_novaT> getByCon_tx_descricao(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova where  Upper(con_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + con_composicao_novaT.getCon_tx_descricao() + '%');
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

    public List<Con_composicao_novaT> getByCon_tx_unidade(Con_composicao_novaT con_composicao_novaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.con_composicao_nova where  Upper(con_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + con_composicao_novaT.getCon_tx_unidade() + '%');
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
