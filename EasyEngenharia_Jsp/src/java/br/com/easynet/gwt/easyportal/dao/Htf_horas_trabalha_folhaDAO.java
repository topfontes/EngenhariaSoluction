package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Htf_horas_trabalha_folhaDAO extends ObjectDAO {

    public Htf_horas_trabalha_folhaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.htf_horas_trabalha_folha  ( obr_nr_id, htf_nr_mes, htf_nr_ano, htf_nr_horas_trabalhada) values ( ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getObr_nr_id());
            pStmt.setObject(2, htf_horas_trabalha_folhaT.getHtf_nr_mes());
            pStmt.setObject(3, htf_horas_trabalha_folhaT.getHtf_nr_ano());
            pStmt.setObject(4, htf_horas_trabalha_folhaT.getHtf_nr_horas_trabalhada());
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

    public void update(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.htf_horas_trabalha_folha set  obr_nr_id=?, htf_nr_mes=?, htf_nr_ano=?, htf_nr_horas_trabalhada=?  where  htf_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getObr_nr_id());
            pStmt.setObject(2, htf_horas_trabalha_folhaT.getHtf_nr_mes());
            pStmt.setObject(3, htf_horas_trabalha_folhaT.getHtf_nr_ano());
            pStmt.setObject(4, htf_horas_trabalha_folhaT.getHtf_nr_horas_trabalhada());
            pStmt.setObject(5, htf_horas_trabalha_folhaT.getHtf_nr_id());
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

    public void delete(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.htf_horas_trabalha_folha where  htf_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_id());
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

    private List<Htf_horas_trabalha_folhaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Htf_horas_trabalha_folhaT> objs = new Vector();
        while (rs.next()) {
            Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT = new Htf_horas_trabalha_folhaT();
            htf_horas_trabalha_folhaT.setHtf_nr_id(rs.getInt("htf_nr_id"));
            htf_horas_trabalha_folhaT.setObr_nr_id(rs.getInt("obr_nr_id"));
            htf_horas_trabalha_folhaT.setHtf_nr_mes(rs.getInt("htf_nr_mes"));
            htf_horas_trabalha_folhaT.setHtf_nr_ano(rs.getInt("htf_nr_ano"));
            htf_horas_trabalha_folhaT.setHtf_nr_horas_trabalhada(rs.getFloat("htf_nr_horas_trabalhada"));
            objs.add(htf_horas_trabalha_folhaT);
        }
        return objs;
    }

    public List<Htf_horas_trabalha_folhaT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Htf_horas_trabalha_folhaT> list = resultSetToObjectTransfer(rs);
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

    public List<Htf_horas_trabalha_folhaT> getByPK(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  htf_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_id());
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

    public List<Htf_horas_trabalha_folhaT> getByHtf_nr_id(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  htf_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_id());
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

    public List<Htf_horas_trabalha_folhaT> getByObr_nr_id(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getObr_nr_id());
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

    public List<Htf_horas_trabalha_folhaT> getByHtf_nr_mes(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  htf_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_mes());
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

    public List<Htf_horas_trabalha_folhaT> getByHtf_nr_ano(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  htf_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_ano());
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

    public List<Htf_horas_trabalha_folhaT> getByHtf_nr_horas_trabalhada(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.htf_horas_trabalha_folha where  htf_nr_horas_trabalhada = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getHtf_nr_horas_trabalhada());
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

    public float getHohrasMes(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT){
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select htf_nr_horas_trabalhada from easyconstru.htf_horas_trabalha_folha where obr_nr_id=? and htf_nr_mes=? and htf_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getObr_nr_id());
            pStmt.setObject(2, htf_horas_trabalha_folhaT.getHtf_nr_mes());
            pStmt.setObject(3, htf_horas_trabalha_folhaT.getHtf_nr_ano());
            rs = pStmt.executeQuery();
            return rs.next()?rs.getFloat("htf_nr_horas_trabalhada"):0;
        } catch (Exception e) {
        }finally{
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }

    public float getHohrasMes(int obr_nr_id, int mes, int ano){
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select htf_nr_horas_trabalhada from easyconstru.htf_horas_trabalha_folha where obr_nr_id=? and htf_nr_mes=? and htf_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            rs = pStmt.executeQuery();
            return rs.next()?rs.getFloat("htf_nr_horas_trabalhada"):0;
        } catch (Exception e) {
        }finally{
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }

        }
        return 0;
    }


    public int existe(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select htf_nr_id from easyconstru.htf_horas_trabalha_folha where obr_nr_id=? and htf_nr_mes=? and htf_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, htf_horas_trabalha_folhaT.getObr_nr_id());
            pStmt.setObject(2, htf_horas_trabalha_folhaT.getHtf_nr_mes());
            pStmt.setObject(3, htf_horas_trabalha_folhaT.getHtf_nr_ano());
            rs = pStmt.executeQuery();
            return rs.next()?rs.getInt("htf_nr_id"):0;
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
