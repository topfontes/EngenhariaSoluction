package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Plc_plano_contasDAO extends ObjectDAO {

    public Plc_plano_contasDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.plc_plano_contas  ( plc_tx_nome, plc_nr_id_super, plc_tx_caixa_banco, cen_nr_id, par_nr_id) values ( ?, ?, ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_tx_nome());
            pStmt.setObject(2, plc_plano_contasT.getPlc_nr_id_super());
            pStmt.setObject(3, "N");
            pStmt.setObject(4, plc_plano_contasT.getCen_nr_id() > 0 ? plc_plano_contasT.getCen_nr_id() : null);
            pStmt.setObject(5, plc_plano_contasT.getPar_nr_id());
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

    public void update(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.plc_plano_contas set  plc_tx_nome=?, plc_nr_id_super=?, plc_tx_caixa_banco=? ,cen_nr_id=?, par_nr_id=? where  plc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_tx_nome());
            pStmt.setObject(2, plc_plano_contasT.getPlc_nr_id_super());
            pStmt.setObject(3, "N");
            pStmt.setObject(4, plc_plano_contasT.getCen_nr_id() > 0 ? plc_plano_contasT.getCen_nr_id() : null);
            pStmt.setObject(5, plc_plano_contasT.getPar_nr_id());
            pStmt.setObject(6, plc_plano_contasT.getPlc_nr_id());
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

    public void delete(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.plc_plano_contas where  plc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
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

    private List<Plc_plano_contasT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plc_plano_contasT> objs = new Vector();
        while (rs.next()) {
            Plc_plano_contasT plc_plano_contasT = new Plc_plano_contasT();
            plc_plano_contasT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            plc_plano_contasT.setPlc_tx_nome(rs.getString("plc_tx_nome"));
            plc_plano_contasT.setPlc_nr_id_super(rs.getInt("plc_nr_id_super"));
            plc_plano_contasT.setPlc_tx_caixa_banco(rs.getString("plc_tx_caixa_banco"));
            plc_plano_contasT.setCen_nr_id(rs.getInt("cen_nr_id"));
            plc_plano_contasT.setPar_nr_id(rs.getInt("par_nr_id"));
            objs.add(plc_plano_contasT);
        }
        return objs;
    }

    public DataSet getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.plc_nr_id, conta.plc_tx_nome, conta.plc_nr_id_super, conta.plc_tx_caixa_banco, conta.cen_nr_id, custo.cen_tx_nome, super.plc_tx_nome as super, conta.par_nr_id, par.par_tx_nome");
            sql.append(" from easyconstru.plc_plano_contas conta left outer join easyconstru.cen_centro_custo custo on(custo.cen_nr_id = conta.cen_nr_id)");
            sql.append(" left outer join easyconstru.plc_plano_contas super on (conta.plc_nr_id_super =super.plc_nr_id)");
            sql.append(" left outer join easyconstru.par_parcelamento as par on(conta.par_nr_id = par.par_nr_id)");
            sql.append(" order by super.plc_tx_nome, conta.plc_tx_nome");
            DataSet ds = new DataSet();
            ds = executeQuery(sql.toString(), null);
            return ds;
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

    public List<Plc_plano_contasT> getByPK(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  plc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
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

    public TreeMap<Integer, Plc_plano_contasT> getAllPlc() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas order by plc_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferPlc(rs);
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

    public List<Plc_plano_contasT> getByPlc_nr_id(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id());
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

    public List<Plc_plano_contasT> getByPlc_tx_nome(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  Upper(plc_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_nome() + '%');
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

    public List<Plc_plano_contasT> getByPlc_nr_id_super(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  plc_nr_id_super = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getPlc_nr_id_super());
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

    public List<Plc_plano_contasT> getByCen_nr_id(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  cen_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plc_plano_contasT.getCen_nr_id());
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

    public DataSet getByContaSuper() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.plc_nr_id, conta.plc_tx_nome, conta.plc_nr_id_super, conta.plc_tx_caixa_banco, conta.cen_nr_id, custo.cen_tx_nome, super.plc_tx_nome as super, conta.par_nr_id, par.par_tx_nome");
            sql.append(" from easyconstru.plc_plano_contas conta left outer join easyconstru.cen_centro_custo custo on(custo.cen_nr_id = conta.cen_nr_id)");
            sql.append(" left outer join easyconstru.plc_plano_contas super on (conta.plc_nr_id_super =super.plc_nr_id)");
            sql.append(" left outer join easyconstru.par_parcelamento as par on(conta.par_nr_id = par.par_nr_id)");
            sql.append(" where conta.plc_nr_id_super = 0 ");
            sql.append(" order by super.plc_tx_nome,conta.plc_tx_nome");
            DataSet ds = new DataSet();
            ds = executeQuery(sql.toString(), null);
            return ds;
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

    public DataSet getByContaSubClasse() throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.plc_nr_id, conta.plc_tx_nome, conta.plc_nr_id_super, conta.plc_tx_caixa_banco, conta.cen_nr_id, custo.cen_tx_nome, super.plc_tx_nome as super,conta.par_nr_id, par.par_tx_nome");
            sql.append(" from easyconstru.plc_plano_contas conta left outer join easyconstru.cen_centro_custo custo on(custo.cen_nr_id = conta.cen_nr_id)");
            sql.append(" left outer join easyconstru.plc_plano_contas super on (conta.plc_nr_id_super =super.plc_nr_id)");
            sql.append(" left outer join easyconstru.par_parcelamento as par on(conta.par_nr_id = par.par_nr_id)");
            sql.append(" where conta.plc_nr_id_super > 0 ");
            sql.append(" order by super.plc_tx_nome,conta.plc_tx_nome");
            //System.out.println(sql.toString());
            ds = new DataSet();
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

    public List<Plc_plano_contasT> getByPlc_tx_caixa_banco(Plc_plano_contasT plc_plano_contasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plc_plano_contas where  Upper(plc_tx_caixa_banco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plc_plano_contasT.getPlc_tx_caixa_banco() + '%');
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

    public TreeMap<Integer, SubClasseParcelamentoT> getSubClasseParcelamento(int obr_nr_id, TreeMap<Integer, Pao_parcelamento_obraT> treeParcelaObra) throws SQLException {
        String sql = "select plc.plc_nr_id, par.par_nr_intervalo_dias, par.par_nr_parcelas,par.par_nr_id from easyconstru.plc_plano_contas as plc inner join easyconstru.par_parcelamento as par on(par.par_nr_id = plc.par_nr_id)";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return resultSetToObjectTransferSubClassePar(rs, treeParcelaObra);
    }

    public TreeMap<Integer, SubClasseParcelamentoT> resultSetToObjectTransferSubClassePar(ResultSet rs, TreeMap<Integer, Pao_parcelamento_obraT> treeParcelaObra) throws SQLException {
        TreeMap<Integer, SubClasseParcelamentoT> treeMap = new TreeMap<Integer, SubClasseParcelamentoT>();
        while (rs.next()) {
            SubClasseParcelamentoT scpt = new SubClasseParcelamentoT();
            scpt.setIntervalo(rs.getInt("par_nr_intervalo_dias"));
            scpt.setNumero_parcelas(rs.getInt("par_nr_parcelas"));
            scpt.setPlc_nr_id(rs.getInt("plc_nr_id"));
            scpt.setPar_nr_id(rs.getInt("par_nr_id"));
            Pao_parcelamento_obraT pt = treeParcelaObra.get(scpt.getPlc_nr_id());
            if (pt != null) {
                scpt.setNumero_parcelas(pt.getPar_nr_parcelas());
                scpt.setIntervalo(pt.getPar_nr_intervalo_dias());
            }
            treeMap.put(scpt.getPlc_nr_id(), scpt);
        }
        return treeMap;
    }

    public TreeMap<Integer, Plc_plano_contasT> resultSetToObjectTransferPlc(ResultSet rs) throws SQLException {
        TreeMap<Integer, Plc_plano_contasT> treeMap = new TreeMap<Integer, Plc_plano_contasT>();
        while (rs.next()) {
            Plc_plano_contasT plc = new Plc_plano_contasT();
            plc.setPlc_nr_id_super(rs.getInt("plc_nr_id_super"));
            plc.setPlc_nr_id(rs.getInt("plc_nr_id"));
            plc.setPlc_tx_nome(rs.getString("plc_tx_nome"));
            treeMap.put(plc.getPlc_nr_id(), plc);
        }
        return treeMap;
    }

    public List<Plc_plano_contasT> getPlc_Sem_Equivalencia(int obr_nr_id) {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.plc_plano_contas  plc where plc_nr_id in (");
            sql.append(" select distinct plc_nr_id from easyconstru.ctp_conta_pagar where ctp_tx_status='P'");
            sql.append(" and obr_nr_id = ");
            sql.append(obr_nr_id+"");
            sql.append(" and plc_nr_id not in(select plc_nr_id from easyconstru.vw_orcamento_sub_classe where obr_nr_id=");
            sql.append(obr_nr_id+"))");
            sql.append(" and cen_nr_id is null");
            sql.append(" order by plc_nr_id");
            pStmt = con.prepareStatement(sql.toString());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
            try {
                pStmt.close();
            } catch (Exception e1) {
            }
            try {
                rs.close();
            } catch (Exception e2) {
            }
        }
        return null;
    }
}
