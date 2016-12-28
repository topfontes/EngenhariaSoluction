package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Dso_descricao_servico_obraDAO extends ObjectDAO {

    public Dso_descricao_servico_obraDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.dso_descricao_servico_obra  (obr_nr_id, plco_nr_id, dso_tx_codigo_externo, dso_tx_descriaco) values ( ? , ? , ? ,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getObr_nr_id());
            pStmt.setObject(2, dso_descricao_servico_obraT.getPlco_nr_id());
            pStmt.setObject(3, dso_descricao_servico_obraT.getDso_tx_codigo_externo());
            pStmt.setObject(4, dso_descricao_servico_obraT.getDso_tx_descriaco());
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

    public void update(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.dso_descricao_servico_obra set obr_nr_id=?, plco_nr_id=?, dso_tx_codigo_externo=?, dso_tx_descriaco=?  where  dso_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getObr_nr_id());
            pStmt.setObject(2, dso_descricao_servico_obraT.getPlco_nr_id());
            pStmt.setObject(3, dso_descricao_servico_obraT.getDso_tx_codigo_externo());
            pStmt.setObject(4, dso_descricao_servico_obraT.getDso_tx_descriaco());
            pStmt.setObject(5, dso_descricao_servico_obraT.getDso_nr_id());
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

    public void delete(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.dso_descricao_servico_obra where  dso_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getDso_nr_id());
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

    public void deleteAllObra(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.dso_descricao_servico_obra where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
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

    private TreeMap<Integer, Dso_descricao_servico_obraT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<Integer, Dso_descricao_servico_obraT> objs = new TreeMap<Integer, Dso_descricao_servico_obraT>();
        while (rs.next()) {
            Dso_descricao_servico_obraT dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();
            dso_descricao_servico_obraT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            dso_descricao_servico_obraT.setDso_tx_codigo_externo(rs.getString("dso_tx_codigo_externo"));
            dso_descricao_servico_obraT.setDso_tx_descriaco(rs.getString("dso_tx_descriaco"));
            dso_descricao_servico_obraT.setDso_nr_id(rs.getInt("dso_nr_id"));
            dso_descricao_servico_obraT.setDso_nr_id(rs.getInt("obr_nr_id"));
            objs.put(dso_descricao_servico_obraT.getPlco_nr_id(), dso_descricao_servico_obraT);
        }
        return objs;
    }

    private List<Dso_descricao_servico_obraT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Dso_descricao_servico_obraT> objs = new Vector();
        while (rs.next()) {
            Dso_descricao_servico_obraT dso_descricao_servico_obraT = new Dso_descricao_servico_obraT();
            dso_descricao_servico_obraT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            dso_descricao_servico_obraT.setDso_tx_codigo_externo(rs.getString("dso_tx_codigo_externo"));
            dso_descricao_servico_obraT.setDso_tx_descriaco(rs.getString("dso_tx_descriaco"));
            dso_descricao_servico_obraT.setDso_nr_id(rs.getInt("dso_nr_id"));
            objs.add(dso_descricao_servico_obraT);
        }
        return objs;
    }

    public List<Dso_descricao_servico_obraT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Dso_descricao_servico_obraT> list = resultSetToObjectTransfer(rs);
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

    public List<Dso_descricao_servico_obraT> getByPK(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  dso_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getDso_nr_id());
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

    public List<Dso_descricao_servico_obraT> getByPlco_nr_id(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getPlco_nr_id());
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

    public TreeMap<Integer, Dso_descricao_servico_obraT> getByObr_nr_id(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
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

    public List<Dso_descricao_servico_obraT> getByDso_tx_codigo_externo(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  Upper(dso_tx_codigo_externo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + dso_descricao_servico_obraT.getDso_tx_codigo_externo() + '%');
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

    public List<Dso_descricao_servico_obraT> getByDso_tx_descriaco(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  Upper(dso_tx_descriaco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + dso_descricao_servico_obraT.getDso_tx_descriaco() + '%');
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

    public List<Dso_descricao_servico_obraT> getByDso_nr_id(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where  dso_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getDso_nr_id());
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

    public boolean getByExiste(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.dso_descricao_servico_obra where dso_tx_codigo_externo =? and  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, dso_descricao_servico_obraT.getDso_tx_codigo_externo());
            pStmt.setObject(2, dso_descricao_servico_obraT.getObr_nr_id());
            rs = pStmt.executeQuery();
            return rs.next();
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
