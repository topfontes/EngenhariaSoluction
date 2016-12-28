package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.jb.Vw_curva_abcConsultJB;
import br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoConsultJB;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Cffo_cronograma_fisico_financeiro_origenalDAO extends ObjectDAO {

    public Cffo_cronograma_fisico_financeiro_origenalDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.cffo_cronograma_fisico_financeiro_origenal  ( plco_nr_id, obr_nr_id, cffo_nr_peso, cffo_nr_mes, cffo_nr_ano, ipo_nr_id_super, ipo_nr_id) values ( ?, ?, ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getPlco_nr_id());
            pStmt.setObject(2, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            pStmt.setObject(3, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
            pStmt.setObject(4, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes());
            pStmt.setObject(5, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano());
            pStmt.setObject(6, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id_super());
            pStmt.setObject(7, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id());
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

    public void update(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.cffo_cronograma_fisico_financeiro_origenal set  plco_nr_id=?, obr_nr_id=?, cffo_nr_peso=?, cffo_nr_mes=?, cffo_nr_ano=?, ipo_nr_id_super=?, ipo_nr_id=?  where  cffo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getPlco_nr_id());
            pStmt.setObject(2, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            pStmt.setObject(3, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
            pStmt.setObject(4, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes());
            pStmt.setObject(5, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano());
            pStmt.setObject(6, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id_super());
            pStmt.setObject(7, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id());
            pStmt.setObject(8, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_id());
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

    public void delete(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  cffo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_id());
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
            String sql = "delete from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  obr_nr_id=?";
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

    private List<Cffo_cronograma_fisico_financeiro_origenalT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cffo_cronograma_fisico_financeiro_origenalT> objs = new Vector();
        while (rs.next()) {
            Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_id(rs.getInt("cffo_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setObr_nr_id(rs.getInt("obr_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_peso(rs.getDouble("cffo_nr_peso"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_mes(rs.getInt("cffo_nr_mes"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_ano(rs.getInt("cffo_nr_ano"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            objs.add(cffo_cronograma_fisico_financeiro_origenalT);
        }
        return objs;
    }

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cffo_cronograma_fisico_financeiro_origenalT> list = resultSetToObjectTransfer(rs);
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getAllSuperConta(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {

        Vw_importacao_orcamentoDAO vdao = new Vw_importacao_orcamentoDAO(dAOFactory);
        List<Vw_importacao_orcamentoT> listvw = vdao.getById_Nivel1(vw_importacao_orcamentoT);
        StringBuffer ids = new StringBuffer();
        ids.append("0");
        for (Vw_importacao_orcamentoT vw_T : listvw) {
            ids.append(",");
            ids.append(vw_T.getPlco_nr_id());
        }

        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where obr_nr_id =? and plco_nr_id in(");
            sql.append(ids.toString());
            sql.append(")");
            String sl = sql.toString();
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            rs = pStmt.executeQuery();
            List<Cffo_cronograma_fisico_financeiro_origenalT> list = resultSetToObjectTransfer(rs);
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByPK(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where cffo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_id());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByCffo_nr_id(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  cffo_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_id());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByPlco_nr_id(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getPlco_nr_id());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByObr_nr_id(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByCffo_nr_peso(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  cffo_nr_peso = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_peso());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByCffo_nr_mes(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  cffo_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> getByCffo_nr_ano(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where  cffo_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano());
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

    public List<Cffo_cronograma_fisico_financeiro_origenalT> locateRegistro(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where plco_nr_id =? and obr_nr_id = ? and cffo_nr_mes = ? and cffo_nr_ano = ? and ipo_nr_id_super=? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getPlco_nr_id());
            pStmt.setObject(2, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            pStmt.setObject(3, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_mes());
            pStmt.setObject(4, cffo_cronograma_fisico_financeiro_origenalT.getCffo_nr_ano());
            pStmt.setObject(5, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id_super());
            pStmt.setObject(6, cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id());

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

    public TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> getByObr_nr_idTree(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal where obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
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

    private TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> tree = new TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT>();
        String codigo;
        while (rs.next()) {
            Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_id(rs.getInt("cffo_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setObr_nr_id(rs.getInt("obr_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_peso(rs.getFloat("cffo_nr_peso"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_mes(rs.getInt("cffo_nr_mes"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_ano(rs.getInt("cffo_nr_ano"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            codigo = rs.getInt("obr_nr_id") + "." + rs.getInt("ipo_nr_id_super") + "." + rs.getInt("plco_nr_id") + "." + rs.getInt("cffo_nr_mes") + "." + rs.getInt("cffo_nr_ano");
            tree.put(codigo, cffo_cronograma_fisico_financeiro_origenalT);
        }
        return tree;
    }

    private TreeMap<Integer, List<Cffo_cronograma_fisico_financeiro_origenalT>> resultSetToObjectTransferTreeKeyIpo(ResultSet rs) throws Exception {
        TreeMap<Integer, List<Cffo_cronograma_fisico_financeiro_origenalT>> tree = new TreeMap<Integer, List<Cffo_cronograma_fisico_financeiro_origenalT>>();
        String codigo;
        while (rs.next()) {
            Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_id(rs.getInt("cffo_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setObr_nr_id(rs.getInt("obr_nr_id"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_peso(rs.getFloat("cffo_nr_peso"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_mes(rs.getInt("cffo_nr_mes"));
            cffo_cronograma_fisico_financeiro_origenalT.setCffo_nr_ano(rs.getInt("cffo_nr_ano"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            cffo_cronograma_fisico_financeiro_origenalT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            codigo = rs.getInt("obr_nr_id") + "." + rs.getInt("ipo_nr_id_super") + "." + rs.getInt("plco_nr_id") + "." + rs.getInt("cffo_nr_mes") + "." + rs.getInt("cffo_nr_ano");
            List<Cffo_cronograma_fisico_financeiro_origenalT> list = tree.get(cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id());
            if(list == null){
                list = new Vector();
                tree.put(cffo_cronograma_fisico_financeiro_origenalT.getIpo_nr_id(), list);
            }
            list.add(cffo_cronograma_fisico_financeiro_origenalT);
        }
        return tree;
    }

    public TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> somaPercetServico(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) {
        TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT> tree = new TreeMap<String, Cffo_cronograma_fisico_financeiro_origenalT>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select obr_nr_id, plco_nr_id, ipo_nr_id,sum(cffo_nr_peso)as peso from easyconstru.cffo_cronograma_fisico_financeiro_origenal");
            sql.append(" where obr_nr_id=?");
            sql.append(" group by 1,2,3");
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setObject(1, cffo_cronograma_fisico_financeiro_origenalT.getObr_nr_id());
            ResultSet rs = ps.executeQuery();
            String key = "";
            while (rs.next()) {
                Cffo_cronograma_fisico_financeiro_origenalT ct = new Cffo_cronograma_fisico_financeiro_origenalT();
                ct.setObr_nr_id(rs.getInt("obr_nr_id"));
                ct.setIpo_nr_id(rs.getInt("ipo_nr_id"));
                ct.setPlco_nr_id(rs.getInt("plco_nr_id"));
                ct.setCffo_nr_peso(rs.getFloat("peso"));
                key = ct.getObr_nr_id() + "." + ct.getIpo_nr_id() + "." + ct.getPlco_nr_id();
                tree.put(key, ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tree;
    }

    public Cffo_cronograma_fisico_financeiro_origenalT getByUltimoMes(int obr_nr_id, int ipo_nr_id, int ipo_nr_id_super, int plco_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT = new Cffo_cronograma_fisico_financeiro_origenalT();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffo ");
            sql.append(" where cffo.cffo_nr_mes = ");
            sql.append("(select max(cffomes.cffo_nr_mes) from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffomes ");
            sql.append(" where cffomes.cffo_nr_ano =(select max(cffoano.cffo_nr_ano) from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffoano) )");
            sql.append(" and obr_nr_id =? and ipo_nr_id =? and ipo_nr_id_super =? and plco_nr_id =?");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ipo_nr_id);
            pStmt.setObject(3, ipo_nr_id_super);
            pStmt.setObject(4, plco_nr_id);
            rs = pStmt.executeQuery();
            List<Cffo_cronograma_fisico_financeiro_origenalT> list;
            list = resultSetToObjectTransfer(rs);
            if (list.size() > 0) {
                cffo_cronograma_fisico_financeiro_origenalT = list.get(0);
            }
            return cffo_cronograma_fisico_financeiro_origenalT;
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

    public TreeMap<Integer,List<Cffo_cronograma_fisico_financeiro_origenalT>> ItensSemPMS(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal cff where obr_nr_id = ? and ipo_nr_id not in (select ipo_nr_id from easyconstru.pms_planilha_medicao_servico where obr_nr_id = ?) order by cffo_nr_ano, cffo_nr_mes";
            pStmt = con.prepareCall(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, obr_nr_id);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferTreeKeyIpo(rs);
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
