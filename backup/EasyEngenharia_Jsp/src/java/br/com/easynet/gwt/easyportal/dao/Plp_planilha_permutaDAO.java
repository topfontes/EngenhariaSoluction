package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Plp_planilha_permutaDAO extends ObjectDAO {

    public Plp_planilha_permutaDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.plp_planilha_permuta  ( obr_nr_id, plp_nr_mes_ref, plp_nr_ano_ref, plp_nr_mes, plp_nr_ano, plp_nr_previsto, plp_nr_realizado) values ( ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano_ref());
            pStmt.setObject(4, plp_planilha_permutaT.getPlp_nr_mes());
            pStmt.setObject(5, plp_planilha_permutaT.getPlp_nr_ano());
            pStmt.setObject(6, plp_planilha_permutaT.getPlp_nr_previsto());
            pStmt.setObject(7, plp_planilha_permutaT.getPlp_nr_realizado());
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

    public void update(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.plp_planilha_permuta set  obr_nr_id=?, plp_nr_mes_ref=?, plp_nr_ano_ref=?, plp_nr_mes=?, plp_nr_ano=?, plp_nr_previsto=?, plp_nr_realizado=?  where  plp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano_ref());
            pStmt.setObject(4, plp_planilha_permutaT.getPlp_nr_mes());
            pStmt.setObject(5, plp_planilha_permutaT.getPlp_nr_ano());
            pStmt.setObject(6, plp_planilha_permutaT.getPlp_nr_previsto());
            pStmt.setObject(7, plp_planilha_permutaT.getPlp_nr_realizado());
            pStmt.setObject(8, plp_planilha_permutaT.getPlp_nr_id());
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

    public void delete(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.plp_planilha_permuta where  plp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_id());
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

    private List<Plp_planilha_permutaT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plp_planilha_permutaT> objs = new Vector();
        while (rs.next()) {
            Plp_planilha_permutaT plp_planilha_permutaT = new Plp_planilha_permutaT();
            plp_planilha_permutaT.setPlp_nr_id(rs.getInt("plp_nr_id"));
            plp_planilha_permutaT.setObr_nr_id(rs.getInt("obr_nr_id"));
            plp_planilha_permutaT.setPlp_nr_mes_ref(rs.getInt("plp_nr_mes_ref"));
            plp_planilha_permutaT.setPlp_nr_ano_ref(rs.getInt("plp_nr_ano_ref"));
            plp_planilha_permutaT.setPlp_nr_mes(rs.getInt("plp_nr_mes"));
            plp_planilha_permutaT.setPlp_nr_ano(rs.getInt("plp_nr_ano"));
            plp_planilha_permutaT.setPlp_nr_previsto(rs.getInt("plp_nr_previsto"));
            plp_planilha_permutaT.setPlp_nr_realizado(rs.getInt("plp_nr_realizado"));
            objs.add(plp_planilha_permutaT);
        }
        return objs;
    }

    public List<Plp_planilha_permutaT> getAll(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  obr_nr_id = ? and plp_nr_mes_ref = ? and plp_nr_ano_ref = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plp_planilha_permutaT> list = resultSetToObjectTransfer(rs);
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

    public int getQtePermutadaAteperiodo(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(plp_nr_realizado)qtde from easyconstru.plp_planilha_permuta where  obr_nr_id = ? and plp_nr_mes_ref <= ? and plp_nr_ano_ref = ? and (plp_nr_mes <= ? and plp_nr_ano = ? or plp_nr_ano <?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano_ref());
            pStmt.setObject(4, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(5, plp_planilha_permutaT.getPlp_nr_ano_ref());
            pStmt.setObject(6, plp_planilha_permutaT.getPlp_nr_ano_ref());
            rs = pStmt.executeQuery();
            int qtde = 0;
            if (rs.next()) {
                qtde = rs.getInt("qtde");
            }
            return qtde;
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

    public List<Plp_planilha_permutaT> getObrMesAno(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  obr_nr_id = ? and plp_nr_mes = ? and plp_nr_ano = ? and plp_nr_mes_ref = ? and plp_nr_ano_ref = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano());
            pStmt.setObject(4, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(5, plp_planilha_permutaT.getPlp_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plp_planilha_permutaT> list = resultSetToObjectTransfer(rs);
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

    public List<Plp_planilha_permutaT> getByPK(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_id());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_id(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_id());
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

    public List<Plp_planilha_permutaT> getByObr_nr_id(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_mes_ref(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_mes_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_mes_ref());
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
//
    public List<Plp_planilha_permutaT> getByPlp_nr_ano_ref(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_ano_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_ano_ref());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_mes(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_mes());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_ano(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_ano());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_previsto(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_previsto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_previsto());
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

    public List<Plp_planilha_permutaT> getByPlp_nr_realizado(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  plp_nr_realizado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getPlp_nr_realizado());
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
    public List<Plp_planilha_permutaT> getAllObraMesAnoRef(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plp_planilha_permuta where  obr_nr_id = ? and plp_nr_mes_ref =? and plp_nr_ano_ref =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plp_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plp_planilha_permutaT.getPlp_nr_mes_ref());
            pStmt.setObject(3, plp_planilha_permutaT.getPlp_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plp_planilha_permutaT> list = resultSetToObjectTransfer(rs);
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
