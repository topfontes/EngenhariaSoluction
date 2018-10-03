package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Plr_planilha_recebimentoDAO extends ObjectDAO {

    public Plr_planilha_recebimentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.plr_planilha_permuta  ( obr_nr_id, plr_nr_mes_ref, plr_nr_ano_ref, plr_nr_mes, plr_nr_ano, plr_nr_efetuado_pj, plr_nr_realizado_pf, plr_nr_realizado_pou) values ( ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plr_planilha_permutaT.getPlr_nr_mes_ref());
            pStmt.setObject(3, plr_planilha_permutaT.getPlr_nr_ano_ref());
            pStmt.setObject(4, plr_planilha_permutaT.getPlr_nr_mes());
            pStmt.setObject(5, plr_planilha_permutaT.getPlr_nr_ano());
            pStmt.setObject(6, plr_planilha_permutaT.getPlr_nr_efetuado_pj());
            pStmt.setObject(7, plr_planilha_permutaT.getPlr_nr_realizado_pf());
            pStmt.setObject(8, plr_planilha_permutaT.getPlr_nr_realizado_pou());
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

    public void update(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.plr_planilha_permuta set  obr_nr_id=?, plr_nr_mes_ref=?, plr_nr_ano_ref=?, plr_nr_mes=?, plr_nr_ano=?, plr_nr_efetuado_pj=?, plr_nr_realizado_pf=?, plr_nr_realizado_pou=?  where  plr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getObr_nr_id());
            pStmt.setObject(2, plr_planilha_permutaT.getPlr_nr_mes_ref());
            pStmt.setObject(3, plr_planilha_permutaT.getPlr_nr_ano_ref());
            pStmt.setObject(4, plr_planilha_permutaT.getPlr_nr_mes());
            pStmt.setObject(5, plr_planilha_permutaT.getPlr_nr_ano());
            pStmt.setObject(6, plr_planilha_permutaT.getPlr_nr_efetuado_pj());
            pStmt.setObject(7, plr_planilha_permutaT.getPlr_nr_realizado_pf());
            pStmt.setObject(8, plr_planilha_permutaT.getPlr_nr_realizado_pou());
            pStmt.setObject(9, plr_planilha_permutaT.getPlr_nr_id());
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

    public void delete(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.plr_planilha_permuta where  plr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_id());
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

    private List<Plr_planilha_recebimentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plr_planilha_recebimentoT> objs = new Vector();
        while (rs.next()) {
            Plr_planilha_recebimentoT plr_planilha_permutaT = new Plr_planilha_recebimentoT();
            plr_planilha_permutaT.setPlr_nr_id(rs.getInt("plr_nr_id"));
            plr_planilha_permutaT.setObr_nr_id(rs.getInt("obr_nr_id"));
            plr_planilha_permutaT.setPlr_nr_mes_ref(rs.getInt("plr_nr_mes_ref"));
            plr_planilha_permutaT.setPlr_nr_ano_ref(rs.getInt("plr_nr_ano_ref"));
            plr_planilha_permutaT.setPlr_nr_mes(rs.getInt("plr_nr_mes"));
            plr_planilha_permutaT.setPlr_nr_ano(rs.getInt("plr_nr_ano"));
            plr_planilha_permutaT.setPlr_nr_efetuado_pj(rs.getDouble("plr_nr_efetuado_pj"));
            plr_planilha_permutaT.setPlr_nr_realizado_pf(rs.getDouble("plr_nr_realizado_pf"));
            plr_planilha_permutaT.setPlr_nr_realizado_pou(rs.getDouble("plr_nr_realizado_pou"));
            objs.add(plr_planilha_permutaT);
        }
        return objs;
    }

    public List<Plr_planilha_recebimentoT> getAll(Plr_planilha_recebimentoT plr_planilha_recebimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  obr_nr_id = ? and plr_nr_mes_ref = ? and plr_nr_ano_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_recebimentoT.getObr_nr_id());
            pStmt.setObject(2, plr_planilha_recebimentoT.getPlr_nr_mes_ref());
            pStmt.setObject(3, plr_planilha_recebimentoT.getPlr_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plr_planilha_recebimentoT> list = resultSetToObjectTransfer(rs);
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

    public Plr_planilha_recebimentoT getTotalAtePeriodo(Plr_planilha_recebimentoT plr_planilha_recebimentoT) throws Exception {
        PreparedStatement pStmt = null;

        ResultSet rs = null;
        try {
            String sql = "select sum(plr_nr_efetuado_pj) plr_nr_efetuado_pj, sum(plr_nr_realizado_pf) plr_nr_realizado_pf,sum(plr_nr_realizado_pou) plr_nr_realizado_pou from easyconstru.plr_planilha_permuta where  obr_nr_id = ? and plr_nr_mes_ref = ? and plr_nr_ano_ref = ? and(plr_nr_mes <= ? and plr_nr_ano=? or plr_nr_ano < ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_recebimentoT.getObr_nr_id());
            pStmt.setObject(2, plr_planilha_recebimentoT.getPlr_nr_mes_ref());
            pStmt.setObject(3, plr_planilha_recebimentoT.getPlr_nr_ano_ref());
            pStmt.setObject(4, plr_planilha_recebimentoT.getPlr_nr_mes_ref());
            pStmt.setObject(5, plr_planilha_recebimentoT.getPlr_nr_ano_ref());
            pStmt.setObject(6, plr_planilha_recebimentoT.getPlr_nr_ano_ref());
            rs = pStmt.executeQuery();
            double valor = 0;
            if (rs.next()) {
                plr_planilha_recebimentoT.setPlr_nr_realizado_pf(rs.getDouble("plr_nr_realizado_pf"));
                plr_planilha_recebimentoT.setPlr_nr_realizado_pou(rs.getDouble("plr_nr_realizado_pou"));
                plr_planilha_recebimentoT.setPlr_nr_efetuado_pj(rs.getDouble("plr_nr_efetuado_pj"));
            }
            List<Plr_planilha_recebimentoT> list = resultSetToObjectTransfer(rs);
            return plr_planilha_recebimentoT;
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

    public List<Plr_planilha_recebimentoT> getObrMesAno(Plr_planilha_recebimentoT plr_planilha_recebimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  obr_nr_id = ? and plr_nr_mes = ? and plr_nr_ano = ? and plr_nr_mes_ref = ?  and plr_nr_ano_ref = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_recebimentoT.getObr_nr_id());
            pStmt.setObject(2, plr_planilha_recebimentoT.getPlr_nr_mes());
            pStmt.setObject(3, plr_planilha_recebimentoT.getPlr_nr_ano());
            pStmt.setObject(4, plr_planilha_recebimentoT.getPlr_nr_mes_ref());
            pStmt.setObject(5, plr_planilha_recebimentoT.getPlr_nr_ano_ref());
            rs = pStmt.executeQuery();
            List<Plr_planilha_recebimentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plr_planilha_recebimentoT> getByPK(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_id());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_id(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_id());
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

    public List<Plr_planilha_recebimentoT> getByObr_nr_id(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getObr_nr_id());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_mes_ref(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_mes_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_mes_ref());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_ano_ref(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_ano_ref = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_ano_ref());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_mes(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_mes());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_ano(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_ano());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_efetuado_pj(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_efetuado_pj = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_efetuado_pj());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_realizado_pf(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_realizado_pf = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_realizado_pf());
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

    public List<Plr_planilha_recebimentoT> getByPlr_nr_realizado_pou(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plr_planilha_permuta where  plr_nr_realizado_pou = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plr_planilha_permutaT.getPlr_nr_realizado_pou());
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
