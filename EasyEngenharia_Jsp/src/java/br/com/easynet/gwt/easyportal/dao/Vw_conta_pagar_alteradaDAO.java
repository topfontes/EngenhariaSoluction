package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_conta_pagar_alteradaDAO extends ObjectDAO {

    public Vw_conta_pagar_alteradaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.vw_conta_pagar_alterada  ( ctp_nr_id, ctp_nr_mes, ctp_nr_ano, ctp_nr_documento, ctp_tx_obs, ctp_tx_fornecedor, ctp_nr_valor, ctpm_nr_mes, ctpm_nr_ano) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_id());
            pStmt.setObject(2, vw_conta_pagar_alteradaT.getCtp_nr_mes());
            pStmt.setObject(3, vw_conta_pagar_alteradaT.getCtp_nr_ano());
            pStmt.setObject(4, vw_conta_pagar_alteradaT.getCtp_nr_documento());
            pStmt.setObject(5, vw_conta_pagar_alteradaT.getCtp_tx_obs());
            pStmt.setObject(6, vw_conta_pagar_alteradaT.getCtp_tx_fornecedor());
            pStmt.setObject(7, vw_conta_pagar_alteradaT.getCtp_nr_valor());
            pStmt.setObject(8, vw_conta_pagar_alteradaT.getCtpm_nr_mes());
            pStmt.setObject(9, vw_conta_pagar_alteradaT.getCtpm_nr_ano());
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

    public void update(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.vw_conta_pagar_alterada set  ctp_nr_id=?, ctp_nr_mes=?, ctp_nr_ano=?, ctp_nr_documento=?, ctp_tx_obs=?, ctp_tx_fornecedor=?, ctp_nr_valor=?, ctpm_nr_mes=?, ctpm_nr_ano=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_id());
            pStmt.setObject(2, vw_conta_pagar_alteradaT.getCtp_nr_mes());
            pStmt.setObject(3, vw_conta_pagar_alteradaT.getCtp_nr_ano());
            pStmt.setObject(4, vw_conta_pagar_alteradaT.getCtp_nr_documento());
            pStmt.setObject(5, vw_conta_pagar_alteradaT.getCtp_tx_obs());
            pStmt.setObject(6, vw_conta_pagar_alteradaT.getCtp_tx_fornecedor());
            pStmt.setObject(7, vw_conta_pagar_alteradaT.getCtp_nr_valor());
            pStmt.setObject(8, vw_conta_pagar_alteradaT.getCtpm_nr_mes());
            pStmt.setObject(9, vw_conta_pagar_alteradaT.getCtpm_nr_ano());
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

    public void delete(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.vw_conta_pagar_alterada where -";
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

    private List<Vw_conta_pagar_alteradaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_conta_pagar_alteradaT> objs = new Vector();
        while (rs.next()) {
            Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT = new Vw_conta_pagar_alteradaT();
            vw_conta_pagar_alteradaT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            vw_conta_pagar_alteradaT.setCtp_nr_mes(rs.getInt("ctp_nr_mes"));
            vw_conta_pagar_alteradaT.setCtp_nr_ano(rs.getInt("ctp_nr_ano"));
            vw_conta_pagar_alteradaT.setCtp_nr_documento(rs.getString("ctp_nr_documento"));
            vw_conta_pagar_alteradaT.setCtp_tx_obs(rs.getString("ctp_tx_obs"));
            vw_conta_pagar_alteradaT.setCtp_tx_fornecedor(rs.getString("ctp_tx_fornecedor"));
            vw_conta_pagar_alteradaT.setCtp_nr_valor(rs.getFloat("ctp_nr_valor"));
            vw_conta_pagar_alteradaT.setCtpm_nr_mes(rs.getInt("ctpm_nr_mes"));
            vw_conta_pagar_alteradaT.setCtpm_nr_ano(rs.getInt("ctpm_nr_ano"));
            vw_conta_pagar_alteradaT.setCtpm_tx_tipo(rs.getString("ctpm_tx_tipo"));
            objs.add(vw_conta_pagar_alteradaT);
        }
        return objs;
    }

    public List<Vw_conta_pagar_alteradaT> getAll(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where obr_nr_id =? and ctpm_nr_mes=? and ctpm_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getObr_nr_id());
            pStmt.setObject(2, vw_conta_pagar_alteradaT.getCtpm_nr_mes());
            pStmt.setObject(3, vw_conta_pagar_alteradaT.getCtpm_nr_ano());
            rs = pStmt.executeQuery();
            List<Vw_conta_pagar_alteradaT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_conta_pagar_alteradaT> getByPK(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where -";
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_nr_id(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_id());
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_nr_mes(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctp_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_mes());
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_nr_ano(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctp_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_ano());
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_nr_documento(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  Upper(ctp_nr_documento) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_conta_pagar_alteradaT.getCtp_nr_documento() + '%');
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_tx_obs(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  Upper(ctp_tx_obs) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_conta_pagar_alteradaT.getCtp_tx_obs() + '%');
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_tx_fornecedor(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  Upper(ctp_tx_fornecedor) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_conta_pagar_alteradaT.getCtp_tx_fornecedor() + '%');
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

    public List<Vw_conta_pagar_alteradaT> getByCtp_nr_valor(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctp_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtp_nr_valor());
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

    public List<Vw_conta_pagar_alteradaT> getByCtpm_nr_mes(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctpm_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtpm_nr_mes());
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

    public List<Vw_conta_pagar_alteradaT> getByCtpm_nr_ano(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_conta_pagar_alterada where  ctpm_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_conta_pagar_alteradaT.getCtpm_nr_ano());
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
