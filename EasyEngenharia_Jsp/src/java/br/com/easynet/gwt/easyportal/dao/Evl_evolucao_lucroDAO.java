package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Evl_evolucao_lucroDAO extends ObjectDAO {

    public Evl_evolucao_lucroDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.evl_evolucao_lucro  ( obr_nr_id, evl_nr_mes, evl_nr_ano, evl_nr_valor, evl_nr_mes_ref, evl_nr_ano_ref, evl_tx_tipo) values ( ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getObr_nr_id());
            pStmt.setObject(2, evl_evolucao_lucroT.getEvl_nr_mes());
            pStmt.setObject(3, evl_evolucao_lucroT.getEvl_nr_ano());
            pStmt.setObject(4, evl_evolucao_lucroT.getEvl_nr_valor());
            pStmt.setObject(5, evl_evolucao_lucroT.getEvl_nr_mes_ref());
            pStmt.setObject(6, evl_evolucao_lucroT.getEvl_nr_ano_ref());
            pStmt.setObject(7, evl_evolucao_lucroT.getEvl_tx_tipo());
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

    public void update(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.evl_evolucao_lucro set  obr_nr_id=?, evl_nr_mes=?, evl_nr_ano=?, evl_nr_valor=?, evl_nr_mes_ref=?, evl_nr_ano_ref=?, evl_tx_tipo=?  where  evl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getObr_nr_id());
            pStmt.setObject(2, evl_evolucao_lucroT.getEvl_nr_mes());
            pStmt.setObject(3, evl_evolucao_lucroT.getEvl_nr_ano());
            pStmt.setObject(4, evl_evolucao_lucroT.getEvl_nr_valor());
            pStmt.setObject(5, evl_evolucao_lucroT.getEvl_nr_mes_ref());
            pStmt.setObject(6, evl_evolucao_lucroT.getEvl_nr_ano_ref());
            pStmt.setObject(7, evl_evolucao_lucroT.getEvl_tx_tipo());
            pStmt.setObject(8, evl_evolucao_lucroT.getEvl_nr_id());
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

    public void delete(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.evl_evolucao_lucro where  evl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_id());
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

    private List<Evl_evolucao_lucroT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Evl_evolucao_lucroT> objs = new Vector();
        while (rs.next()) {
            Evl_evolucao_lucroT evl_evolucao_lucroT = new Evl_evolucao_lucroT();
            evl_evolucao_lucroT.setEvl_nr_id(rs.getInt("evl_nr_id"));
            evl_evolucao_lucroT.setObr_nr_id(rs.getInt("obr_nr_id"));
            evl_evolucao_lucroT.setEvl_nr_mes(rs.getInt("evl_nr_mes"));
            evl_evolucao_lucroT.setEvl_nr_ano(rs.getInt("evl_nr_ano"));
            evl_evolucao_lucroT.setEvl_nr_valor(rs.getFloat("evl_nr_valor"));
            evl_evolucao_lucroT.setEvl_nr_mes_ref(rs.getInt("evl_nr_mes_ref"));
            evl_evolucao_lucroT.setEvl_nr_ano_ref(rs.getInt("evl_nr_ano_ref"));
            evl_evolucao_lucroT.setEvl_tx_tipo(rs.getString("evl_tx_tipo"));
            objs.add(evl_evolucao_lucroT);
        }
        return objs;
    }

    public List<Evl_evolucao_lucroT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Evl_evolucao_lucroT> list = resultSetToObjectTransfer(rs);
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

    public List<Evl_evolucao_lucroT> getAllObraMesAnoRef(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  obr_nr_id = ? and evl_nr_mes_ref =? and evl_nr_ano_ref =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getObr_nr_id());
            pStmt.setObject(2, evl_evolucao_lucroT.getEvl_nr_mes_ref());
            pStmt.setObject(3, evl_evolucao_lucroT.getEvl_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Evl_evolucao_lucroT> list = resultSetToObjectTransfer(rs);
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

    public List<Evl_evolucao_lucroT> getByPK(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_id());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_id(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_id());
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

    public List<Evl_evolucao_lucroT> getByObr_nr_id(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getObr_nr_id());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_mes(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_mes());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_ano(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_ano());
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

    public List<Evl_evolucao_lucroT> getByEvl(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where obr_nr_id =? and evl_nr_mes =? and evl_nr_ano = ? and evl_nr_mes_ref = ? and evl_nr_ano_ref = ? and evl_tx_tipo =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getObr_nr_id());
            pStmt.setObject(2, evl_evolucao_lucroT.getEvl_nr_mes());
            pStmt.setObject(3, evl_evolucao_lucroT.getEvl_nr_ano());
            pStmt.setObject(4, evl_evolucao_lucroT.getEvl_nr_mes_ref());
            pStmt.setObject(5, evl_evolucao_lucroT.getEvl_nr_ano_ref());
            pStmt.setObject(6, evl_evolucao_lucroT.getEvl_tx_tipo());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_valor(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_valor());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_mes_ref(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_mes_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_mes_ref());
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

    public List<Evl_evolucao_lucroT> getByEvl_nr_ano_ref(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  evl_nr_ano_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, evl_evolucao_lucroT.getEvl_nr_ano_ref());
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

    public List<Evl_evolucao_lucroT> getByEvl_tx_tipo(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.evl_evolucao_lucro where  Upper(evl_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + evl_evolucao_lucroT.getEvl_tx_tipo() + '%');
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
