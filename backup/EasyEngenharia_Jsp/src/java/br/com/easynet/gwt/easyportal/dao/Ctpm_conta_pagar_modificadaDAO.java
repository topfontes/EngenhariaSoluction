package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Ctpm_conta_pagar_modificadaDAO extends ObjectDAO {

    public Ctpm_conta_pagar_modificadaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.ctpm_conta_pagar_modificada  ( obr_nr_id, ctp_nr_id, ctpm_nr_mes, ctpm_nr_ano, ctpm_tx_tipo) values ( ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getObr_nr_id());
            pStmt.setObject(2, ctpm_conta_pagar_modificadaT.getCtp_nr_id());
            pStmt.setObject(3, ctpm_conta_pagar_modificadaT.getCtpm_nr_mes());
            pStmt.setObject(4, ctpm_conta_pagar_modificadaT.getCtpm_nr_ano());
            pStmt.setObject(5, ctpm_conta_pagar_modificadaT.getCtpm_tx_tipo());
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

    public void update(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctpm_conta_pagar_modificada set  obr_nr_id=?, ctp_nr_id=?, ctpm_nr_mes=?, ctpm_nr_ano=?, ctpm_tx_tipo=?  where  ctpm_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getObr_nr_id());
            pStmt.setObject(2, ctpm_conta_pagar_modificadaT.getCtp_nr_id());
            pStmt.setObject(3, ctpm_conta_pagar_modificadaT.getCtpm_nr_mes());
            pStmt.setObject(4, ctpm_conta_pagar_modificadaT.getCtpm_nr_ano());
            pStmt.setObject(5, ctpm_conta_pagar_modificadaT.getCtpm_tx_tipo());
            pStmt.setObject(6, ctpm_conta_pagar_modificadaT.getCtpm_nr_id());
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

    public void delete(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ctpm_conta_pagar_modificada where  ctpm_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtpm_nr_id());
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

    private List<Ctpm_conta_pagar_modificadaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ctpm_conta_pagar_modificadaT> objs = new Vector();
        while (rs.next()) {
            Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT = new Ctpm_conta_pagar_modificadaT();
            ctpm_conta_pagar_modificadaT.setCtpm_nr_id(rs.getInt("ctpm_nr_id"));
            ctpm_conta_pagar_modificadaT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ctpm_conta_pagar_modificadaT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ctpm_conta_pagar_modificadaT.setCtpm_nr_mes(rs.getInt("ctpm_nr_mes"));
            ctpm_conta_pagar_modificadaT.setCtpm_nr_ano(rs.getInt("ctpm_nr_ano"));
            ctpm_conta_pagar_modificadaT.setCtpm_tx_tipo(rs.getString("ctpm_tx_tipo"));
            objs.add(ctpm_conta_pagar_modificadaT);
        }
        return objs;
    }

    public List<Ctpm_conta_pagar_modificadaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ctpm_conta_pagar_modificadaT> list = resultSetToObjectTransfer(rs);
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

    public List<Ctpm_conta_pagar_modificadaT> getByPK(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  ctpm_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtpm_nr_id());
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

    public List<Ctpm_conta_pagar_modificadaT> getByCtpm_nr_id(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  ctpm_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtpm_nr_id());
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

    public List<Ctpm_conta_pagar_modificadaT> getByObr_nr_id(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getObr_nr_id());
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

    public List<Ctpm_conta_pagar_modificadaT> getByCtp_nr_id(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  ctp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtp_nr_id());
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

    public List<Ctpm_conta_pagar_modificadaT> getByCtpm_nr_mes(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  ctpm_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtpm_nr_mes());
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

    public List<Ctpm_conta_pagar_modificadaT> getByCtpm_nr_ano(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  ctpm_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctpm_conta_pagar_modificadaT.getCtpm_nr_ano());
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

    public List<Ctpm_conta_pagar_modificadaT> getByCtpm_tx_tipo(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctpm_conta_pagar_modificada where  Upper(ctpm_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctpm_conta_pagar_modificadaT.getCtpm_tx_tipo() + '%');
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
