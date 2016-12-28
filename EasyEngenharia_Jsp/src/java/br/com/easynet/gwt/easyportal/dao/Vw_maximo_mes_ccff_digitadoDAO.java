package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_maximo_mes_ccff_digitadoDAO extends ObjectDAO {

    public Vw_maximo_mes_ccff_digitadoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.vw_maximo_mes_ccff_digitado  ( obr_nr_id, plco_nr_id, ipo_nr_id_super, ccff_nr_mes, ccff_nr_ano, ccff_nr_peso, nada) values ( ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getObr_nr_id());
            pStmt.setObject(2, vw_maximo_mes_ccff_digitadoT.getPlco_nr_id());
            pStmt.setObject(3, vw_maximo_mes_ccff_digitadoT.getIpo_nr_id_super());
            pStmt.setObject(4, vw_maximo_mes_ccff_digitadoT.getCcff_nr_mes());
            pStmt.setObject(5, vw_maximo_mes_ccff_digitadoT.getCcff_nr_ano());
            pStmt.setObject(6, vw_maximo_mes_ccff_digitadoT.getCcff_nr_peso());
            pStmt.setObject(7, vw_maximo_mes_ccff_digitadoT.getNada());
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

    public void update(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.vw_maximo_mes_ccff_digitado set  obr_nr_id=?, plco_nr_id=?, ipo_nr_id_super=?, ccff_nr_mes=?, ccff_nr_ano=?, ccff_nr_peso=?, nada=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getObr_nr_id());
            pStmt.setObject(2, vw_maximo_mes_ccff_digitadoT.getPlco_nr_id());
            pStmt.setObject(3, vw_maximo_mes_ccff_digitadoT.getIpo_nr_id_super());
            pStmt.setObject(4, vw_maximo_mes_ccff_digitadoT.getCcff_nr_mes());
            pStmt.setObject(5, vw_maximo_mes_ccff_digitadoT.getCcff_nr_ano());
            pStmt.setObject(6, vw_maximo_mes_ccff_digitadoT.getCcff_nr_peso());
            pStmt.setObject(7, vw_maximo_mes_ccff_digitadoT.getNada());
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

    public void delete(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.vw_maximo_mes_ccff_digitado where -";
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

    private List<Vw_maximo_mes_ccff_digitadoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_maximo_mes_ccff_digitadoT> objs = new Vector();
        while (rs.next()) {
            Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();
            vw_maximo_mes_ccff_digitadoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            vw_maximo_mes_ccff_digitadoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            vw_maximo_mes_ccff_digitadoT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_mes(rs.getInt("ccff_nr_mes"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_ano(rs.getInt("ccff_nr_ano"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_peso(rs.getInt("ccff_nr_peso"));
            vw_maximo_mes_ccff_digitadoT.setNada(rs.getLong("nada"));
            objs.add(vw_maximo_mes_ccff_digitadoT);
        }
        return objs;
    }

    public List<Vw_maximo_mes_ccff_digitadoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_maximo_mes_ccff_digitadoT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByPK(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where -";
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByObr_nr_id(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getObr_nr_id());
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByPlco_nr_id(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getPlco_nr_id());
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByIpo_nr_id_super(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  ipo_nr_id_super = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getIpo_nr_id_super());
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByCcff_nr_mes(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  ccff_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getCcff_nr_mes());
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByCcff_nr_ano(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  ccff_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getCcff_nr_ano());
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

    public List<Vw_maximo_mes_ccff_digitadoT> getByCcff_nr_peso(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_maximo_mes_ccff_digitado where  ccff_nr_peso = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_maximo_mes_ccff_digitadoT.getCcff_nr_peso());
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

    public Vw_maximo_mes_ccff_digitadoT getByUltimoMes(int obr_nr_id, int ipo_nr_id, int ipo_nr_id_super, int plco_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffo ");
            sql.append(" where cffo.cffo_nr_mes = ");
            sql.append("(select max(cffomes.cffo_nr_mes) from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffomes ");
            sql.append("where cffomes.cffo_nr_ano =(select max(cffoano.cffo_nr_ano) from easyconstru.cffo_cronograma_fisico_financeiro_origenal cffoano) )");
            sql.append(" and obr_nr_id =? and ipo_nr_id =? and ipo_nr_id_super =? and plco_nr_id =?");
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ipo_nr_id);
            pStmt.setObject(3, ipo_nr_id_super);
            pStmt.setObject(4, plco_nr_id);
            rs = pStmt.executeQuery();
            List<Vw_maximo_mes_ccff_digitadoT> list;
            list = resultSetToObjectTransfer(rs);
            if (list.size() > 0) {
                vw_maximo_mes_ccff_digitadoT = list.get(0);
            }
            return vw_maximo_mes_ccff_digitadoT;
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

    public TreeMap<String, Vw_maximo_mes_ccff_digitadoT> getByObr_nr_idTree(int obra, String tipo) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql ="";
            if (tipo.equalsIgnoreCase("R")) {
                 sql = "select obr_nr_id, plco_nr_id, ipo_nr_id_super, ccff_nr_mes as mes, ccff_nr_ano as ano, ccff_nr_peso as peso, nada  from easyconstru.vw_maximo_mes_ccff_digitado where  obr_nr_id = ? ";
            } else {
                 sql = "select obr_nr_id, plco_nr_id, ipo_nr_id_super, cffo_nr_mes as mes, cffo_nr_ano as ano, cffo_nr_peso as peso, nada  from easyconstru.vw_maximo_mes_cffo_digitado where  obr_nr_id = ? ";
            }
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obra);
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

    private TreeMap<String, Vw_maximo_mes_ccff_digitadoT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Vw_maximo_mes_ccff_digitadoT> objs = new TreeMap<String, Vw_maximo_mes_ccff_digitadoT>();
        while (rs.next()) {
            Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT = new Vw_maximo_mes_ccff_digitadoT();
            vw_maximo_mes_ccff_digitadoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            vw_maximo_mes_ccff_digitadoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            vw_maximo_mes_ccff_digitadoT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_mes(rs.getInt("mes"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_ano(rs.getInt("ano"));
            vw_maximo_mes_ccff_digitadoT.setCcff_nr_peso(rs.getDouble("peso"));
//            vw_maximo_mes_ccff_digitadoT.setNada(rs.getLong("nada"));
            objs.put(vw_maximo_mes_ccff_digitadoT.getPlco_nr_id() + "." + vw_maximo_mes_ccff_digitadoT.getIpo_nr_id_super(), vw_maximo_mes_ccff_digitadoT);
            
        }
        return objs;
    }
}
