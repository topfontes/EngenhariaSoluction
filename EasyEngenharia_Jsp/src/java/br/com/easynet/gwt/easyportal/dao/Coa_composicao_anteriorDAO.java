package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Coa_composicao_anteriorDAO extends ObjectDAO {

    public int maxId() throws Exception {
        try {
            String sql = "select max(coa_nr_id)as id from easyconstru.coa_composicao_anterior";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }

    public Coa_composicao_anteriorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.coa_composicao_anterior  ( coa_tx_codigo, coa_tx_descricao, coa_tx_unidade) values ( ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coa_composicao_anteriorT.getCoa_tx_codigo());
            pStmt.setObject(2, coa_composicao_anteriorT.getCoa_tx_descricao());
            pStmt.setObject(3, coa_composicao_anteriorT.getCoa_tx_unidade());
            pStmt.execute();
            coa_composicao_anteriorT.setCoa_nr_id(maxId());
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.coa_composicao_anterior set  coa_nr_id=?, coa_tx_codigo=?, coa_tx_descricao=?, coa_tx_unidade=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coa_composicao_anteriorT.getCoa_nr_id());
            pStmt.setObject(2, coa_composicao_anteriorT.getCoa_tx_codigo());
            pStmt.setObject(3, coa_composicao_anteriorT.getCoa_tx_descricao());
            pStmt.setObject(4, coa_composicao_anteriorT.getCoa_tx_unidade());
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

    public void delete(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.coa_composicao_anterior where -";
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

    private List<Coa_composicao_anteriorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Coa_composicao_anteriorT> objs = new Vector();
        while (rs.next()) {
            Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();
            coa_composicao_anteriorT.setCoa_nr_id(rs.getInt("coa_nr_id"));
            coa_composicao_anteriorT.setCoa_tx_codigo(rs.getString("coa_tx_codigo"));
            coa_composicao_anteriorT.setCoa_tx_descricao(rs.getString("coa_tx_descricao"));
            coa_composicao_anteriorT.setCoa_tx_unidade(rs.getString("coa_tx_unidade"));
            objs.add(coa_composicao_anteriorT);
        }
        return objs;
    }

    public List<Coa_composicao_anteriorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
           String sql = "select * from easyconstru.coa_composicao_anterior where coa_nr_id not in(select coa_nr_id from easyconstru.eqc_equivalencia_composicao)";
//            String sql = "select * from easyconstru.coa_composicao_anterior";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Coa_composicao_anteriorT> list = resultSetToObjectTransfer(rs);
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

    public List<Coa_composicao_anteriorT> getByPK(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where -";
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

    public List<Coa_composicao_anteriorT> getByCoa_nr_id(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where  coa_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, coa_composicao_anteriorT.getCoa_nr_id());
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

    public List<Coa_composicao_anteriorT> getByCoa_tx_codigo(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where  Upper(coa_tx_codigo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + coa_composicao_anteriorT.getCoa_tx_codigo() + '%');
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

    public List<Coa_composicao_anteriorT> getByCoa_tx_descricao(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where  Upper(coa_tx_descricao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + coa_composicao_anteriorT.getCoa_tx_descricao() + '%');
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

    public List<Coa_composicao_anteriorT> getByCoa_tx_unidade(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where  Upper(coa_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + coa_composicao_anteriorT.getCoa_tx_unidade() + '%');
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

    public List<Coa_composicao_anteriorT> getAllEquiv(int inn_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.coa_composicao_anterior where coa_nr_id in(select coa_nr_id from easyconstru.eqc_equivalencia_composicao where con_nr_id =?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inn_nr_id);
            rs = pStmt.executeQuery();
            List<Coa_composicao_anteriorT> list = resultSetToObjectTransfer(rs);

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
    public TreeMap<String,Coa_composicao_anteriorT> getAllTree() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
           String sql = "select * from easyconstru.coa_composicao_anterior";
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
private TreeMap<String,Coa_composicao_anteriorT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String,Coa_composicao_anteriorT> objs = new TreeMap<String, Coa_composicao_anteriorT>();
        while (rs.next()) {
            Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();
            coa_composicao_anteriorT.setCoa_nr_id(rs.getInt("coa_nr_id"));
            coa_composicao_anteriorT.setCoa_tx_codigo(rs.getString("coa_tx_codigo"));
            coa_composicao_anteriorT.setCoa_tx_descricao(rs.getString("coa_tx_descricao"));
            coa_composicao_anteriorT.setCoa_tx_unidade(rs.getString("coa_tx_unidade"));
            objs.put(coa_composicao_anteriorT.getCoa_tx_codigo(),coa_composicao_anteriorT);
        }
        return objs;
    }

}
