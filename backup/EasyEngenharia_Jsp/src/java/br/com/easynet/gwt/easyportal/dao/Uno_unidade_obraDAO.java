package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Uno_unidade_obraDAO extends ObjectDAO {

    public Uno_unidade_obraDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.uno_unidade_obra  ( obr_nr_id, uni_nr_id, uno_nr_quantidade, uno_nr_area_construida) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
            pStmt.setObject(2, uno_unidade_obraT.getUni_nr_id());
            pStmt.setObject(3, uno_unidade_obraT.getUno_nr_quantidade());
            pStmt.setObject(4, uno_unidade_obraT.getUno_nr_area_construida());
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

    public void update(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.uno_unidade_obra set  obr_nr_id=?, uni_nr_id=?,  uno_nr_quantidade=?, uno_nr_area_construida=?  where  uno_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
            pStmt.setObject(2, uno_unidade_obraT.getUni_nr_id());
            pStmt.setObject(3, uno_unidade_obraT.getUno_nr_quantidade());
            pStmt.setObject(4, uno_unidade_obraT.getUno_nr_area_construida());
            pStmt.setObject(5, uno_unidade_obraT.getUno_nr_id());
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

    public void delete(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.uno_unidade_obra where  uno_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getUno_nr_id());
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
    public void deleteAllObra(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.uno_unidade_obra where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
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
            String sql = "delete from easyconstru.uno_unidade_obra where  obr_nr_id=?";
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

    private List<Uno_unidade_obraT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Uno_unidade_obraT> objs = new Vector();
        while (rs.next()) {
            Uno_unidade_obraT uno_unidade_obraT = new Uno_unidade_obraT();
            uno_unidade_obraT.setUno_nr_id(rs.getInt("uno_nr_id"));
            uno_unidade_obraT.setObr_nr_id(rs.getInt("obr_nr_id"));
            uno_unidade_obraT.setUni_nr_id(rs.getInt("uni_nr_id"));
            uno_unidade_obraT.setUno_nr_quantidade(rs.getInt("uno_nr_quantidade"));
            uno_unidade_obraT.setUno_nr_area_construida(rs.getFloat("uno_nr_area_construida"));
            objs.add(uno_unidade_obraT);
        }
        return objs;
    }

    public DataSet getAll(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        DataSet ds = new DataSet();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select uno.uno_nr_id , uno.obr_nr_id, uno.uno_nr_quantidade, uno.uno_nr_area_construida , uno.uni_nr_id , unidade.uni_tx_nome, obra.obr_tx_nome");
            sql.append(" from easyconstru.uno_unidade_obra as uno inner join easyconstru.uni_unidade as unidade on(uno.uni_nr_id = unidade.uni_nr_id)");
            sql.append(" inner join easyconstru.obr_obras as obra on(uno.obr_nr_id = obra.obr_nr_id)");
            if (uno_unidade_obraT.getObr_nr_id() > 0) {
                sql.append(" where uno.obr_nr_id = ");
                sql.append(uno_unidade_obraT.getObr_nr_id()+"");
            }
            ds = executeQuery(sql.toString(), null);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
            } catch (Exception e) {
            }

        }
    }

    public List<Uno_unidade_obraT> getByPK(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  uno_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getUno_nr_id());
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

    public List<Uno_unidade_obraT> getByUno_nr_id(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  uno_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getUno_nr_id());
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

    public List<Uno_unidade_obraT> getByObr_nr_id(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
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

    public List<Uno_unidade_obraT> getByUno_tx_nome(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  Upper(uno_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + uno_unidade_obraT.getUno_nr_id() + '%');
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

    public List<Uno_unidade_obraT> getByUno_nr_quantidade(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  uno_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getUno_nr_quantidade());
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

    public List<Uno_unidade_obraT> getByUno_nr_area_construida(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where  uno_nr_area_construida = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getUno_nr_area_construida());
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

    /** M�todos FK */
    public List<Uno_unidade_obraT> getByObr_obras(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.uno_unidade_obra where obr_obras.obr_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
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
    public int getQuantidadeUnidadesObra(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(uno_nr_quantidade)qtde from easyconstru.uno_unidade_obra where obr_obras.obr_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, uno_unidade_obraT.getObr_nr_id());
            rs = pStmt.executeQuery();
            int vl = 0;
            if(rs.next()){
                vl = rs.getInt("qtde");
            }
            return vl;
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
