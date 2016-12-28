package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.ArrayList;

public class Pms_planilha_medicao_servicoDAO extends ObjectDAO {

    public Pms_planilha_medicao_servicoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.pms_planilha_medicao_servico  ( obr_nr_id, pms_nr_mes, plco_nr_id, pms_nr_quantidade_servico,pms_nr_ano,ipo_nr_id_super, ipo_nr_id,pms_nr_percentual) values ( ?, ?, ?, ? , ? , ? , ? , ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
            pStmt.setObject(2, pms_planilha_medicao_servicoT.getPms_nr_mes());
            pStmt.setObject(3, pms_planilha_medicao_servicoT.getPlco_nr_id());
            pStmt.setObject(4, pms_planilha_medicao_servicoT.getPms_nr_quantidade_servico());
            pStmt.setObject(5, pms_planilha_medicao_servicoT.getPms_nr_ano());
            pStmt.setObject(6, pms_planilha_medicao_servicoT.getIpo_nr_id_super());
            pStmt.setObject(7, pms_planilha_medicao_servicoT.getIpo_nr_id());
            pStmt.setObject(8, pms_planilha_medicao_servicoT.getPms_nr_percentual());
            pStmt.execute();

            Ccff_copia_cronograma_fisico_financeiroDAO ccff_Dao = new Ccff_copia_cronograma_fisico_financeiroDAO(dAOFactory);
            ccff_Dao.recalcularMesesRestante(pms_planilha_medicao_servicoT.getObr_nr_id(), pms_planilha_medicao_servicoT.getIpo_nr_id(), pms_planilha_medicao_servicoT.getIpo_nr_id_super(), pms_planilha_medicao_servicoT.getPlco_nr_id(), pms_planilha_medicao_servicoT.getPms_nr_mes(), pms_planilha_medicao_servicoT.getPms_nr_ano(), pms_planilha_medicao_servicoT.getPms_nr_percentual());

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.pms_planilha_medicao_servico set  obr_nr_id=?, pms_nr_mes=?, plco_nr_id=?, pms_nr_quantidade_servico=?, pms_nr_ano =?,ipo_nr_id_super=?, ipo_nr_id=?, pms_nr_percentual=?  where  pms_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
            pStmt.setObject(2, pms_planilha_medicao_servicoT.getPms_nr_mes());
            pStmt.setObject(3, pms_planilha_medicao_servicoT.getPlco_nr_id());
            pStmt.setObject(4, pms_planilha_medicao_servicoT.getPms_nr_quantidade_servico());
            pStmt.setObject(5, pms_planilha_medicao_servicoT.getPms_nr_ano());
            pStmt.setObject(6, pms_planilha_medicao_servicoT.getIpo_nr_id_super());
            pStmt.setObject(7, pms_planilha_medicao_servicoT.getIpo_nr_id());
            pStmt.setObject(8, pms_planilha_medicao_servicoT.getPms_nr_percentual());
            pStmt.setObject(9, pms_planilha_medicao_servicoT.getPms_nr_id());
            pStmt.execute();

//            Ccff_copia_cronograma_fisico_financeiroDAO ccff_Dao = new Ccff_copia_cronograma_fisico_financeiroDAO(dAOFactory);
//            ccff_Dao.recalcularMesesRestante(pms_planilha_medicao_servicoT.getObr_nr_id(), pms_planilha_medicao_servicoT.getIpo_nr_id(), pms_planilha_medicao_servicoT.getIpo_nr_id_super(), pms_planilha_medicao_servicoT.getPlco_nr_id(), pms_planilha_medicao_servicoT.getPms_nr_mes(), pms_planilha_medicao_servicoT.getPms_nr_ano(), pms_planilha_medicao_servicoT.getPms_nr_percentual());


        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void delete(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.pms_planilha_medicao_servico where  pms_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_id());
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

    public void deleteObra(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.pms_planilha_medicao_servico where obr_nr_id=?";
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

    private List<Pms_planilha_medicao_servicoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pms_planilha_medicao_servicoT> objs = new Vector();
        while (rs.next()) {
            Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
            pms_planilha_medicao_servicoT.setPms_nr_id(rs.getInt("pms_nr_id"));
            pms_planilha_medicao_servicoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            pms_planilha_medicao_servicoT.setPms_nr_mes(rs.getInt("pms_nr_mes"));
            pms_planilha_medicao_servicoT.setPms_nr_ano(rs.getInt("pms_nr_ano"));
            pms_planilha_medicao_servicoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            pms_planilha_medicao_servicoT.setPms_nr_quantidade_servico(rs.getDouble("pms_nr_quantidade_servico"));
            pms_planilha_medicao_servicoT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            pms_planilha_medicao_servicoT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            pms_planilha_medicao_servicoT.setPms_nr_percentual(rs.getDouble("pms_nr_percentual"));
            objs.add(pms_planilha_medicao_servicoT);
        }
        return objs;
    }

    public List<Pms_planilha_medicao_servicoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pms_planilha_medicao_servicoT> list = resultSetToObjectTransfer(rs);
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

    public List<Pms_planilha_medicao_servicoT> getByPK(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  pms_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_id());
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

    public List<Pms_planilha_medicao_servicoT> getByQtdeDigitado(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where obr_nr_id=? and plco_nr_id=? and  pms_nr_mes=? and pms_nr_ano=? and ipo_nr_id_super=? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
            pStmt.setObject(2, pms_planilha_medicao_servicoT.getPlco_nr_id());
            pStmt.setObject(3, pms_planilha_medicao_servicoT.getPms_nr_mes());
            pStmt.setObject(4, pms_planilha_medicao_servicoT.getPms_nr_ano());
            pStmt.setObject(5, pms_planilha_medicao_servicoT.getIpo_nr_id_super());
            pStmt.setObject(6, pms_planilha_medicao_servicoT.getIpo_nr_id());
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

    public int insertValido(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where obr_nr_id=? and plco_nr_id =? and pms_nr_mes=? and pms_nr_ano=? and ipo_nr_id_super =? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
            pStmt.setObject(2, pms_planilha_medicao_servicoT.getPlco_nr_id());
            pStmt.setObject(3, pms_planilha_medicao_servicoT.getPms_nr_mes());
            pStmt.setObject(4, pms_planilha_medicao_servicoT.getPms_nr_ano());
            pStmt.setObject(5, pms_planilha_medicao_servicoT.getIpo_nr_id_super());
            pStmt.setObject(6, pms_planilha_medicao_servicoT.getIpo_nr_id());

            rs = pStmt.executeQuery();
            List<Pms_planilha_medicao_servicoT> list = resultSetToObjectTransfer(rs);
            int id = list.size() > 0 ? list.get(0).getPms_nr_id() : 0;
            return id;
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

    public DataSet getByQtdeAcumulada(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {

        DataSet ds = null;
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select sum(pms_nr_quantidade_servico)as qtde from easyconstru.pms_planilha_medicao_servico");
            buffer.append(" where obr_nr_id = ? and ipo_nr_id=? and plco_nr_id = ? and ((pms_nr_mes < ? and pms_nr_ano = ?)or (pms_nr_ano < ?))");
            ArrayList list = new ArrayList();
            list.add(pms_planilha_medicao_servicoT.getObr_nr_id());
            list.add(pms_planilha_medicao_servicoT.getIpo_nr_id());
            list.add(pms_planilha_medicao_servicoT.getPlco_nr_id());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_mes());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_ano());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_ano());
            Object[] param = list.toArray();
            ds = executeQuery(buffer.toString(), param);
        } catch (Exception e) {
            throw e;
        } finally {
        }
        return ds;
    }

    public Float getByPercentAcumulada(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select sum(pms_nr_percentual)as percent from easyconstru.pms_planilha_medicao_servico");
            buffer.append(" where obr_nr_id = ? and ipo_nr_id=? and plco_nr_id = ? and ((pms_nr_mes < ? and pms_nr_ano = ?)or (pms_nr_ano < ?))");
            ArrayList list = new ArrayList();
            list.add(pms_planilha_medicao_servicoT.getObr_nr_id());
            list.add(pms_planilha_medicao_servicoT.getIpo_nr_id());
            list.add(pms_planilha_medicao_servicoT.getPlco_nr_id());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_mes());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_ano());
            list.add(pms_planilha_medicao_servicoT.getPms_nr_ano());
            Object[] param = list.toArray();
            ds = executeQuery(buffer.toString(), param);
            return Float.parseFloat(ds.getList().get(0).getColumn(0).toString());
        } catch (Exception e) {
            throw e;
        } finally {
        }

    }

    public List<Pms_planilha_medicao_servicoT> getByPms_nr_id(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  pms_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_id());
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

    public List<Pms_planilha_medicao_servicoT> getByObr_nr_id(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  obr_nr_id = ? order by pms_nr_mes, pms_nr_ano";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
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

    public List<Pms_planilha_medicao_servicoT> getByIpoObr_nr_id(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  obr_nr_id = ? order by ipo_nr_id, pms_nr_ano, pms_nr_mes";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getObr_nr_id());
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
    public List<Pms_planilha_medicao_servicoT> getByPms_nr_mes(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  pms_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_mes());
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

    public List<Pms_planilha_medicao_servicoT> getByPlco_nr_id(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPlco_nr_id());
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

    public List<Pms_planilha_medicao_servicoT> getByPms_nr_quantidade_servico(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where  pms_nr_quantidade_servico = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_quantidade_servico());
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

    public String getIdClasses(int[] classes) {
        String cls = "";
        for (int i = 0; i < classes.length; i++) {
            if (i > 0) {
                cls += "," + classes[i];
            }else{
                cls += classes[i];
            }
        }
        cls ="("+cls+")";
        return cls;
    }

    public double getCustoPrevistoPeriodo(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        double valor = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select sum(vl_executado)valor from easyconstru.vw_insumo_plc_pms pms where pms.obr_nr_id=? and pms.pms_nr_mes=? and pms.pms_nr_ano =? and pms.plc_nr_id_super in"+getIdClasses(id_classes));
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, mes);
            ps.setObject(3, ano);
            rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }
            return valor;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }

    public double getCustoPrevistoAcmulado(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        double valor = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select sum(vl_executado)valor from easyconstru.vw_insumo_plc_pms pms where pms.obr_nr_id=? and ((pms.pms_nr_mes<=? and pms.pms_nr_ano =?) or pms.pms_nr_ano<?) and pms.plc_nr_id_super in"+getIdClasses(id_classes));
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, mes);
            ps.setObject(3, ano);
            ps.setObject(4, ano);
            rs = ps.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }

            return valor;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Pms_planilha_medicao_servicoT> getByMaxMesAno(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pms_planilha_medicao_servico where pms_nr_mes in(select max(pms_nr_ano) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pms_planilha_medicao_servicoT.getPms_nr_quantidade_servico());
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
   public int maiorAnoLancado(int obr_nr_id) throws Exception {
        int ano =0;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(pms_nr_ano)ano from easyconstru.pms_planilha_medicao_servico where  obr_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            rs= pStmt.executeQuery();
            if(rs.next()){
                ano = rs.getInt("ano");
            }
            return ano;
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

   public int maiorAnoLancadoServ(int obr_nr_id, int ipo_nr_id) throws Exception {
        int ano =0;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(pms_nr_ano)ano from easyconstru.pms_planilha_medicao_servico where  obr_nr_id=? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ipo_nr_id);
            rs= pStmt.executeQuery();
            if(rs.next()){
                ano = rs.getInt("ano");
            }
            return ano;
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

   public int maiorMesLancado(int obr_nr_id, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(pms_nr_mes)mes from easyconstru.pms_planilha_medicao_servico where  obr_nr_id=? and pms_nr_ano =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ano);
            rs= pStmt.executeQuery();
            if(rs.next()){
                ano = rs.getInt("mes");
            }
            return ano;
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
   public int maiorMesLancadoServ(int obr_nr_id, int ano, int ipo_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(pms_nr_mes)mes from easyconstru.pms_planilha_medicao_servico where  obr_nr_id=? and pms_nr_ano =? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ano);
            pStmt.setObject(3, ipo_nr_id);
            rs= pStmt.executeQuery();
            if(rs.next()){
                ano = rs.getInt("mes");
            }
            return ano;
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
