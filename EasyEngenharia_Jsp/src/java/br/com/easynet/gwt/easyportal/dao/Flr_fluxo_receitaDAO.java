package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Flr_fluxo_receitaDAO extends ObjectDAO {

    public Flr_fluxo_receitaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.flr_fluxo_receita  ( flr_nr_mes, flr_nr_ano, flr_nr_original, flr_nr_atual, flr_tx_key, obr_nr_id, flr_nr_mes_ref, flr_nr_ano_ref) values ( ?, ?, ?, ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_mes());
            pStmt.setObject(2, flr_fluxo_receitaT.getFlr_nr_ano());
            pStmt.setObject(3, flr_fluxo_receitaT.getFlr_nr_original());
            pStmt.setObject(4, flr_fluxo_receitaT.getFlr_nr_atual());
            pStmt.setObject(5, flr_fluxo_receitaT.getFlr_tx_key());
            pStmt.setObject(6, flr_fluxo_receitaT.getObr_nr_id());
            pStmt.setObject(7, flr_fluxo_receitaT.getFlr_nr_mes_ref());
            pStmt.setObject(8, flr_fluxo_receitaT.getFlr_nr_ano_ref());
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

    public void update(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.flr_fluxo_receita set  flr_nr_mes=?, flr_nr_ano=?, flr_nr_original=?, flr_nr_atual=?, flr_tx_key=?, obr_nr_id=?, flr_nr_mes_ref=?, flr_nr_ano_ref=?  where  flr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_mes());
            pStmt.setObject(2, flr_fluxo_receitaT.getFlr_nr_ano());
            pStmt.setObject(3, flr_fluxo_receitaT.getFlr_nr_original());
            pStmt.setObject(4, flr_fluxo_receitaT.getFlr_nr_atual());
            pStmt.setObject(5, flr_fluxo_receitaT.getFlr_tx_key());
            pStmt.setObject(6, flr_fluxo_receitaT.getObr_nr_id());
            pStmt.setObject(7, flr_fluxo_receitaT.getFlr_nr_mes_ref());
            pStmt.setObject(8, flr_fluxo_receitaT.getFlr_nr_ano_ref());
            pStmt.setObject(9, flr_fluxo_receitaT.getFlr_nr_id());
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

    public void delete(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.flr_fluxo_receita where  flr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_id());
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

    private List<Flr_fluxo_receitaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Flr_fluxo_receitaT> objs = new Vector();
        while (rs.next()) {
            Flr_fluxo_receitaT flr_fluxo_receitaT = new Flr_fluxo_receitaT();
            flr_fluxo_receitaT.setFlr_nr_id(rs.getInt("flr_nr_id"));
            flr_fluxo_receitaT.setFlr_nr_mes(rs.getInt("flr_nr_mes"));
            flr_fluxo_receitaT.setFlr_nr_ano(rs.getInt("flr_nr_ano"));
            flr_fluxo_receitaT.setFlr_nr_mes_ref(rs.getInt("flr_nr_mes_ref"));
            flr_fluxo_receitaT.setFlr_nr_ano_ref(rs.getInt("flr_nr_ano_ref"));
            flr_fluxo_receitaT.setFlr_nr_original(rs.getDouble("flr_nr_original"));
            flr_fluxo_receitaT.setFlr_nr_atual(rs.getDouble("flr_nr_atual"));
            flr_fluxo_receitaT.setFlr_tx_key(rs.getString("flr_tx_key"));
            flr_fluxo_receitaT.setObr_nr_id(rs.getInt("obr_nr_id"));
            objs.add(flr_fluxo_receitaT);
        }
        return objs;
    }

    public List<Flr_fluxo_receitaT> getAll(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where obr_nr_id =? and flr_nr_mes_ref =? and flr_nr_ano_ref =? order by flr_nr_ano, flr_nr_mes";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getObr_nr_id());
            pStmt.setObject(2, flr_fluxo_receitaT.getFlr_nr_mes_ref());
            pStmt.setObject(3, flr_fluxo_receitaT.getFlr_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Flr_fluxo_receitaT> list = resultSetToObjectTransfer(rs);
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

    public List<Flr_fluxo_receitaT> getByPK(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_id());
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

    public List<Flr_fluxo_receitaT> getByFlr_nr_id(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_id());
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

    public List<Flr_fluxo_receitaT> getByFlr_nr_mes(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_mes());
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

    public List<Flr_fluxo_receitaT> getByFlr_nr_ano(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_ano());
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

    public List<Flr_fluxo_receitaT> getByFlr_nr_original(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_original = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_original());
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

    public List<Flr_fluxo_receitaT> getByFlr_nr_atual(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_nr_atual = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_nr_atual());
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

    public List<Flr_fluxo_receitaT> getByFlr_tx_key(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  flr_tx_key =? and obr_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getFlr_tx_key());
            pStmt.setObject(2, flr_fluxo_receitaT.getObr_nr_id());
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

    public List<Flr_fluxo_receitaT> getAllObraMesAnoRef(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.flr_fluxo_receita where  obr_nr_id = ? and flr_nr_mes_ref =? and flr_nr_ano_ref =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, flr_fluxo_receitaT.getObr_nr_id());
            pStmt.setObject(2, flr_fluxo_receitaT.getFlr_nr_mes_ref());
            pStmt.setObject(3, flr_fluxo_receitaT.getFlr_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Flr_fluxo_receitaT> list = resultSetToObjectTransfer(rs);
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
}
