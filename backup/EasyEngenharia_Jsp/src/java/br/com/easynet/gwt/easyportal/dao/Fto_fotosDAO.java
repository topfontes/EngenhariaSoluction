package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Fto_fotosDAO extends ObjectDAO {

    public Fto_fotosDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.fto_fotos  ( obr_nr_id, fto_nr_mes, fto_nr_ano, fto_bt_foto, fto_tx_nome) values ( ?, ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getObr_nr_id());
            pStmt.setObject(2, fto_fotosT.getFto_nr_mes());
            pStmt.setObject(3, fto_fotosT.getFto_nr_ano());
            pStmt.setObject(4, fto_fotosT.getFto_bt_foto());
            pStmt.setObject(5, fto_fotosT.getFto_tx_nome());
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

    public void update(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.fto_fotos set  obr_nr_id=?, fto_nr_mes=?, fto_nr_ano=?, fto_bt_foto=?  where  fto_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getObr_nr_id());
            pStmt.setObject(2, fto_fotosT.getFto_nr_mes());
            pStmt.setObject(3, fto_fotosT.getFto_nr_ano());
            pStmt.setObject(4, fto_fotosT.getFto_bt_foto());
            pStmt.setObject(5, fto_fotosT.getFto_nr_id());
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

    public void delete(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.fto_fotos where  fto_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_nr_id());
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

    private List<Fto_fotosT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Fto_fotosT> objs = new Vector();
        while (rs.next()) {
            Fto_fotosT fto_fotosT = new Fto_fotosT();
            fto_fotosT.setFto_nr_id(rs.getInt("fto_nr_id"));
            fto_fotosT.setObr_nr_id(rs.getInt("obr_nr_id"));
            fto_fotosT.setFto_nr_mes(rs.getInt("fto_nr_mes"));
            fto_fotosT.setFto_nr_ano(rs.getInt("fto_nr_ano"));
            fto_fotosT.setFto_bt_foto(rs.getBytes("fto_bt_foto"));
            fto_fotosT.setFto_tx_nome(rs.getString("fto_tx_nome"));
            objs.add(fto_fotosT);
        }
        return objs;
    }

    public List<Fto_fotosT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Fto_fotosT> list = resultSetToObjectTransfer(rs);
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

    public List<Fto_fotosT> getByPK(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  fto_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_nr_id());
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

    public List<Fto_fotosT> getByFto_nr_id(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  fto_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_nr_id());
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

    public List<Fto_fotosT> getByObraMesAno(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  obr_nr_id = ? and fto_nr_mes = ? and fto_nr_ano = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getObr_nr_id());
            pStmt.setObject(2, fto_fotosT.getFto_nr_mes());
            pStmt.setObject(3, fto_fotosT.getFto_nr_ano());
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

    public List<Fto_fotosT> getByObr_nr_id(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getObr_nr_id());
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

    public List<Fto_fotosT> getByFto_nr_mes(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  fto_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_nr_mes());
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

    public List<Fto_fotosT> getByFto_nr_ano(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  fto_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_nr_ano());
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

    public List<Fto_fotosT> getByFto_bt_foto(Fto_fotosT fto_fotosT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fto_fotos where  fto_bt_foto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fto_fotosT.getFto_bt_foto());
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
