package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Pro_produtoDAO extends ObjectDAO {

    public Pro_produtoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.pro_produto  ( pro_tx_nome, grp_nr_id) values ( ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_tx_nome());
            pStmt.setObject(2, pro_produtoT.getGrp_nr_id());
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

    public void update(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.pro_produto set  pro_tx_nome=?, grp_nr_id=?  where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_tx_nome());
            pStmt.setObject(2, pro_produtoT.getGrp_nr_id());
            pStmt.setObject(3, pro_produtoT.getPro_nr_id());
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

    public void delete(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.pro_produto where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
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

    private List<Pro_produtoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pro_produtoT> objs = new Vector();
        while (rs.next()) {
            Pro_produtoT pro_produtoT = new Pro_produtoT();
            pro_produtoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            pro_produtoT.setPro_tx_nome(rs.getString("pro_tx_nome"));
            pro_produtoT.setGrp_nr_id(rs.getInt("grp_nr_id"));
            objs.add(pro_produtoT);
        }
        return objs;
    }

    public List<Pro_produtoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
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

    public List<Pro_produtoT> getAllObraMesAno(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where obr_nr_id= and pro_nr_mes=? and pro_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getObr_nr_id());
            pStmt.setObject(2, pro_programacaoT.getPro_nr_mes());
            pStmt.setObject(3, pro_programacaoT.getPro_nr_ano());
            rs = pStmt.executeQuery();
            List<Pro_produtoT> list = resultSetToObjectTransfer(rs);
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

    public List<Pro_produtoT> getByPK(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
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

    public List<Pro_produtoT> getByPro_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getPro_nr_id());
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

    public List<Pro_produtoT> getByPro_tx_nome(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where  Upper(pro_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + pro_produtoT.getPro_tx_nome() + '%');
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

    public List<Pro_produtoT> getByGrp_nr_id(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where  grp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getGrp_nr_id());
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

    /** Metodos FK */
    public List<Pro_produtoT> getByGrp_grupo_produto(Pro_produtoT pro_produtoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_produto where grp_grupo_produto.grp_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_produtoT.getGrp_nr_id());
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
