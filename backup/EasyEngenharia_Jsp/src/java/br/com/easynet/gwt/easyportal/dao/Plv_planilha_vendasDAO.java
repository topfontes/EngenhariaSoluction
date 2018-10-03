package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Plv_planilha_vendasDAO extends ObjectDAO {

    public Plv_planilha_vendasDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.plv_planilha_vendas  ( obr_nr_id, plv_nr_mes_ref, plv_nr_ano_ref, plv_nr_mes, plv_nr_ano, plv_nr_previsto, plv_nr_realizado) values ( ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano_ref());
            pStmt.setObject(4, plv_planilha_vendasT.getPlv_nr_mes());
            pStmt.setObject(5, plv_planilha_vendasT.getPlv_nr_ano());
            pStmt.setObject(6, plv_planilha_vendasT.getPlv_nr_previsto());
            pStmt.setObject(7, plv_planilha_vendasT.getPlv_nr_realizado());
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

    public void update(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.plv_planilha_vendas set  obr_nr_id=?, plv_nr_mes_ref=?, plv_nr_ano_ref=?, plv_nr_mes=?, plv_nr_ano=?, plv_nr_previsto=?, plv_nr_realizado=?  where  plv_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano_ref());
            pStmt.setObject(4, plv_planilha_vendasT.getPlv_nr_mes());
            pStmt.setObject(5, plv_planilha_vendasT.getPlv_nr_ano());
            pStmt.setObject(6, plv_planilha_vendasT.getPlv_nr_previsto());
            pStmt.setObject(7, plv_planilha_vendasT.getPlv_nr_realizado());
            pStmt.setObject(8, plv_planilha_vendasT.getPlv_nr_id());
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

    public void delete(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.plv_planilha_vendas where  plv_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_id());
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

    private List<Plv_planilha_vendasT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plv_planilha_vendasT> objs = new Vector();
        while (rs.next()) {
            Plv_planilha_vendasT plv_planilha_vendasT = new Plv_planilha_vendasT();
            plv_planilha_vendasT.setPlv_nr_id(rs.getInt("plv_nr_id"));
            plv_planilha_vendasT.setObr_nr_id(rs.getInt("obr_nr_id"));
            plv_planilha_vendasT.setPlv_nr_mes_ref(rs.getInt("plv_nr_mes_ref"));
            plv_planilha_vendasT.setPlv_nr_ano_ref(rs.getInt("plv_nr_ano_ref"));
            plv_planilha_vendasT.setPlv_nr_mes(rs.getInt("plv_nr_mes"));
            plv_planilha_vendasT.setPlv_nr_ano(rs.getInt("plv_nr_ano"));
            plv_planilha_vendasT.setPlv_nr_previsto(rs.getInt("plv_nr_previsto"));
            plv_planilha_vendasT.setPlv_nr_realizado(rs.getInt("plv_nr_realizado"));
            objs.add(plv_planilha_vendasT);
        }
        return objs;
    }

    public List<Plv_planilha_vendasT> getAll(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  obr_nr_id = ? and plv_nr_mes_ref = ? and plv_nr_ano_ref =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plv_planilha_vendasT> list = resultSetToObjectTransfer(rs);
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

    public List<Plv_planilha_vendasT> getObrMesAno(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  obr_nr_id = ? and plv_nr_mes = ? and plv_nr_ano =? and plv_nr_mes_ref = ? and plv_nr_ano_ref=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano());
            pStmt.setObject(4, plv_planilha_vendasT.getPlv_nr_ano_ref());
            pStmt.setObject(5, plv_planilha_vendasT.getPlv_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plv_planilha_vendasT> list = resultSetToObjectTransfer(rs);
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

   public int getQteVendaAteperiodoRealizada(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(plv_nr_realizado)qtde from easyconstru.plv_planilha_vendas where  obr_nr_id = ?  and plv_nr_mes_ref = ? and plv_nr_ano_ref=? and (plv_nr_mes <= ? and plv_nr_ano = ? or plv_nr_ano <?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano_ref());
            pStmt.setObject(4, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(5, plv_planilha_vendasT.getPlv_nr_ano_ref());
            pStmt.setObject(6, plv_planilha_vendasT.getPlv_nr_ano_ref());
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


    public List<Plv_planilha_vendasT> getByPK(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_id());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_id(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_id());
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

    public List<Plv_planilha_vendasT> getByObr_nr_id(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_mes_ref(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;

        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_mes_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_mes_ref());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_ano_ref(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {//
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_ano_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_ano_ref());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_mes(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_mes());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_ano(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_ano());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_previsto(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_previsto = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_previsto());
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

    public List<Plv_planilha_vendasT> getByPlv_nr_realizado(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  plv_nr_realizado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getPlv_nr_realizado());
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

    public List<Plv_planilha_vendasT> getAllObraMesAnoRef(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plv_planilha_vendas where  obr_nr_id = ? and plv_nr_mes_ref =? and plv_nr_ano_ref =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plv_planilha_vendasT.getObr_nr_id());
            pStmt.setObject(2, plv_planilha_vendasT.getPlv_nr_mes_ref());
            pStmt.setObject(3, plv_planilha_vendasT.getPlv_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plv_planilha_vendasT> list = resultSetToObjectTransfer(rs);
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
