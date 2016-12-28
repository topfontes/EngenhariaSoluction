package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.ArrayList;

public class Vw_insumo_plc_pmsDAO extends ObjectDAO {

    public Vw_insumo_plc_pmsDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.vw_insumo_plc_pms  ( obr_nr_id, plc_nr_id_super, plc_tx_nome_super, plc_nr_id, plc_tx_nome, ipo_nr_vl_unitario, pms_nr_mes, pms_nr_ano, plco_nr_id, perc, vl_total, vl_executado) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getObr_nr_id());
            pStmt.setObject(2, vw_insumo_plc_pmsT.getPlc_nr_id_super());
            pStmt.setObject(3, vw_insumo_plc_pmsT.getPlc_tx_nome_super());
            pStmt.setObject(4, vw_insumo_plc_pmsT.getPlc_nr_id());
            pStmt.setObject(5, vw_insumo_plc_pmsT.getPlc_tx_nome());
            pStmt.setObject(6, vw_insumo_plc_pmsT.getIpo_nr_vl_unitario());
            pStmt.setObject(7, vw_insumo_plc_pmsT.getPms_nr_mes());
            pStmt.setObject(8, vw_insumo_plc_pmsT.getPms_nr_ano());
            pStmt.setObject(9, vw_insumo_plc_pmsT.getPlco_nr_id());
            pStmt.setObject(10, vw_insumo_plc_pmsT.getPerc());
            pStmt.setObject(11, vw_insumo_plc_pmsT.getVl_total());
            pStmt.setObject(12, vw_insumo_plc_pmsT.getVl_executado());
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

    public void update(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.vw_insumo_plc_pms set  obr_nr_id=?, plc_nr_id_super=?, plc_tx_nome_super=?, plc_nr_id=?, plc_tx_nome=?, ipo_nr_vl_unitario=?, pms_nr_mes=?, pms_nr_ano=?, plco_nr_id=?, perc=?, vl_total=?, vl_executado=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getObr_nr_id());
            pStmt.setObject(2, vw_insumo_plc_pmsT.getPlc_nr_id_super());
            pStmt.setObject(3, vw_insumo_plc_pmsT.getPlc_tx_nome_super());
            pStmt.setObject(4, vw_insumo_plc_pmsT.getPlc_nr_id());
            pStmt.setObject(5, vw_insumo_plc_pmsT.getPlc_tx_nome());
            pStmt.setObject(6, vw_insumo_plc_pmsT.getIpo_nr_vl_unitario());
            pStmt.setObject(7, vw_insumo_plc_pmsT.getPms_nr_mes());
            pStmt.setObject(8, vw_insumo_plc_pmsT.getPms_nr_ano());
            pStmt.setObject(9, vw_insumo_plc_pmsT.getPlco_nr_id());
            pStmt.setObject(10, vw_insumo_plc_pmsT.getPerc());
            pStmt.setObject(11, vw_insumo_plc_pmsT.getVl_total());
            pStmt.setObject(12, vw_insumo_plc_pmsT.getVl_executado());
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

    public void delete(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.vw_insumo_plc_pms where -";
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

    private List<Vw_insumo_plc_pmsT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_insumo_plc_pmsT> objs = new Vector();
        while (rs.next()) {
            Vw_insumo_plc_pmsT vw_insumo_plc_pmsT = new Vw_insumo_plc_pmsT();
            vw_insumo_plc_pmsT.setObr_nr_id(rs.getInt("obr_nr_id"));
            vw_insumo_plc_pmsT.setPlc_nr_id_super(rs.getInt("plc_nr_id_super"));
            vw_insumo_plc_pmsT.setPlc_tx_nome_super(rs.getString("plc_tx_nome_super"));
            vw_insumo_plc_pmsT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            vw_insumo_plc_pmsT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
            vw_insumo_plc_pmsT.setIpo_nr_vl_unitario(rs.getFloat("ipo_nr_vl_unitario"));
            vw_insumo_plc_pmsT.setPms_nr_mes(rs.getInt("pms_nr_mes"));
            vw_insumo_plc_pmsT.setPms_nr_ano(rs.getInt("pms_nr_ano"));
            vw_insumo_plc_pmsT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            vw_insumo_plc_pmsT.setPerc(rs.getFloat("perc"));
            vw_insumo_plc_pmsT.setVl_total(rs.getFloat("vl_total"));
            vw_insumo_plc_pmsT.setVl_executado(rs.getFloat("vl_executado"));
            objs.add(vw_insumo_plc_pmsT);
        }
        return objs;
    }

    public List<Vw_insumo_plc_pmsT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_insumo_plc_pmsT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_insumo_plc_pmsT> getByPK(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where -";
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

    public List<Vw_insumo_plc_pmsT> getByObr_nr_id(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getObr_nr_id());
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

    public List<Vw_insumo_plc_pmsT> getByPlc_nr_id_super(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  plc_nr_id_super = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPlc_nr_id_super());
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

    public List<Vw_insumo_plc_pmsT> getByPlc_tx_nome_super(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  Upper(plc_tx_nome_super) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_insumo_plc_pmsT.getPlc_tx_nome_super() + '%');
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

    public List<Vw_insumo_plc_pmsT> getByPlc_nr_id(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPlc_nr_id());
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

    public List<Vw_insumo_plc_pmsT> getByPlc_tx_nome(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  Upper(plc_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_insumo_plc_pmsT.getPlc_tx_nome() + '%');
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

    public List<Vw_insumo_plc_pmsT> getByIpo_nr_vl_unitario(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  ipo_nr_vl_unitario = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getIpo_nr_vl_unitario());
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

    public List<Vw_insumo_plc_pmsT> getByPms_nr_mes(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  pms_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPms_nr_mes());
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

    public List<Vw_insumo_plc_pmsT> getByPms_nr_ano(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  pms_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPms_nr_ano());
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

    public List<Vw_insumo_plc_pmsT> getByPlco_nr_id(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPlco_nr_id());
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

    public List<Vw_insumo_plc_pmsT> getByPerc(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  perc = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getPerc());
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

    public List<Vw_insumo_plc_pmsT> getByVl_total(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  vl_total = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getVl_total());
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

    public List<Vw_insumo_plc_pmsT> getByVl_executado(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_insumo_plc_pms where  vl_executado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_insumo_plc_pmsT.getVl_executado());
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

    public DataSet getResumoPmsPlc(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT, boolean acumulado, String tipo) throws Exception {
        Object[] param = null;
        DataSet ds = null;
        if (acumulado) {
            param = new Object[4];
            param[0] = vw_insumo_plc_pmsT.getObr_nr_id();
            param[1] = vw_insumo_plc_pmsT.getPms_nr_mes();
            param[2] = vw_insumo_plc_pmsT.getPms_nr_ano();
            param[3] = vw_insumo_plc_pmsT.getPms_nr_ano();
            if (tipo.equalsIgnoreCase("plc")) {
                ds = executeQuery("select plc_nr_id as id,plc_tx_nome as conta,plc_tx_nome_super as tx_nome_super, plc_tx_nome as und, sum(vl_executado) as vl_total, sum(qtde_executado) as quantidade  from easyconstru.vw_insumo_plc_pms  where obr_nr_id=? and  (pms_nr_mes <=? and pms_nr_ano =? or pms_nr_ano <?) group by 1,2,3,4", param);
            } else {
                ds = executeQuery("select plco_nr_id as id,plco_tx_nome as conta,plco_tx_nome as tx_nome_super, plco_tx_unidade as und, sum(vl_executado) as vl_total, sum(qtde_executado)as quantidade from easyconstru.vw_insumo_plco_pms  where obr_nr_id=? and  (pms_nr_mes <=? and pms_nr_ano =? or pms_nr_ano <?) group by 1,2,3,4", param);
            }
        } else {
            param = new Object[3];
            param[0] = vw_insumo_plc_pmsT.getObr_nr_id();
            param[1] = vw_insumo_plc_pmsT.getPms_nr_mes();
            param[2] = vw_insumo_plc_pmsT.getPms_nr_ano();
            if (tipo.equalsIgnoreCase("plc")) {
                ds = executeQuery("select plc_nr_id as id, plc_tx_nome as conta,plc_tx_nome_super as tx_nome_super, plc_tx_nome as und ,sum(vl_executado) as vl_total, sum(qtde_executado) as quantidade from easyconstru.vw_insumo_plc_pms  where obr_nr_id=? and  pms_nr_mes =? and pms_nr_ano =? group by 1,2,3,4", param);
            } else {
                ds = executeQuery("select plco_nr_id as id, plco_tx_nome as conta,plco_tx_nome as tx_nome_super, plco_tx_unidade as und ,sum(vl_executado) as vl_total, sum(qtde_executado) as quantidade from easyconstru.vw_insumo_plco_pms  where obr_nr_id=? and  pms_nr_mes =? and pms_nr_ano =? group by 1,2,3,4", param);
            }
        }
        return ds;
    }

    public DataSet getResumoPmsPlc(int obr_nr_id, int mes, int ano, boolean acumulado) throws Exception {
        Object[] param = null;
        DataSet ds = null;
        ArrayList list = new ArrayList();
        list.add(obr_nr_id);
        list.add(mes);
        list.add(ano);
        StringBuffer sql = new StringBuffer();
        if (!acumulado) {
            sql.append("select plc_nr_id, plc_tx_nome ,sum(vl_executado) as valor from easyconstru.vw_insumo_plc_pms  where obr_nr_id=? and  pms_nr_mes =? and pms_nr_ano =? group by 1,2");
        } else {
            sql.append("select plc_nr_id, plc_tx_nome ,sum(vl_executado) as valor from easyconstru.vw_insumo_plc_pms  where obr_nr_id=? and  ((pms_nr_mes <=? and pms_nr_ano =?) or (pms_nr_ano <?)) group by 1,2");
            list.add(ano);
        }
        ds = executeQuery(sql.toString(), list.toArray());

        return ds;
    }

    public DataSet getResumoPmsMesAno(int obr_nr_id) throws Exception {
        Object[] param = null;
        DataSet ds = null;
        ArrayList list = new ArrayList();
        list.add(obr_nr_id);
        StringBuffer sql = new StringBuffer();
        sql.append("select pms_nr_mes, pms_nr_ano ,sum(vl_executado) as valor from easyconstru.vw_insumo_plc_pms where obr_nr_id = ? group by 1,2");
        ds = executeQuery(sql.toString(), list.toArray());
        return ds;
    }


    public DataSet getQtdePms1(int obr_nr_id, int mes, int ano) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select vw.plc_nr_id, vw.plco_nr_id, vw.subclasse, vw.plco_tx_nome as insumo, sum(vw.qtde_executado)as qtde from easyconstru.vw_insumo_plco_pms as vw");
            sql.append(" inner join easyconstru.obr_obras obra on(obra.obr_nr_id_plc_mdo_direta = vw.plc_nr_id or obra.obr_nr_id_plc_mdo_indireta = plc_nr_id)");
            sql.append(" where obra.obr_nr_id = ?  and pms_nr_mes = ? and pms_nr_ano = ?");
            sql.append("group by vw.plc_nr_id, vw.plco_nr_id, vw.subclasse, vw.plco_tx_nome");
            sql.append(" order by vw.subclasse, vw.plco_tx_nome");
            Object[] param = new Object[3];
            param[0] = obr_nr_id;
            param[1] = mes;
            param[2] = ano;
            ds = executeQuery(sql.toString(), param);
            return ds;

        } catch (Exception e) {
            throw e;
            //e.printStackTrace();

        }
//        return null;
    }

    public DataSet getQtdePms(int obr_nr_id, int mes, int ano) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
// sql = "select obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id,sum(vl_executado)as vl_executado from easyconstru.vw_equiv_insumo_pms where obr_nr_id=? and  plc_nr_id = ? and pms_nr_mes =? and pms_nr_ano=? group by obr_nr_id,plc_nr_id,plc_tx_nome,insumo,ipo_nr_vl_unitario,pms_nr_mes,pms_nr_ano,plco_nr_id";

            sql.append("select pms.obr_nr_id, pms.plc_nr_id, pms.plc_nr_id_super, pms.super, pms.plc_tx_nome, pms.insumo, pms.ipo_nr_vl_unitario,  pms.plco_nr_id,sum(vl_executado)as vl_executado ");
            sql.append(" from easyconstru.vw_equiv_insumo_pms pms");
            sql.append(" inner join easyconstru.obr_obras obra on(obra.obr_nr_id_plc_mdo_direta = plc_nr_id_super or obra.obr_nr_id_plc_mdo_indireta = plc_nr_id_super)");
            sql.append(" where pms.obr_nr_id=? and ((pms.pms_nr_mes <=? and pms.pms_nr_ano=?) or pms.pms_nr_ano <?) group by pms.obr_nr_id, pms.plc_nr_id, pms.plc_nr_id_super, pms.super, pms.plc_tx_nome,pms.insumo, pms.ipo_nr_vl_unitario, plco_nr_id");
            sql.append(" order by pms.super, pms.plc_tx_nome");
            ArrayList param = new ArrayList();
            param.add(obr_nr_id);
            param.add(mes);
            param.add(ano);
            param.add(ano);
            ds = executeQuery(sql.toString(), param.toArray());
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }
}
