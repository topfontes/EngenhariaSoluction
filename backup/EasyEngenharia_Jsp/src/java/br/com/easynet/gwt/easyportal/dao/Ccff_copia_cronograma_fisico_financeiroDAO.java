package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.List;

public class Ccff_copia_cronograma_fisico_financeiroDAO extends ObjectDAO {

    public Ccff_copia_cronograma_fisico_financeiroDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.ccff_copia_cronograma_fisico_financeiro  ( obr_nr_id, plco_nr_id, ccff_nr_peso, ccff_nr_mes, ccff_nr_ano, ccff_nr_quantidade, ccff_nr_valor, ipo_nr_id_super,ipo_nr_id) values ( ?, ?, ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
            pStmt.setObject(2, ccff_copia_cronograma_fisico_financeiroT.getPlco_nr_id());
            pStmt.setObject(3, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_peso());
            pStmt.setObject(4, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes());
            pStmt.setObject(5, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano());
            pStmt.setObject(6, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_quantidade());
            pStmt.setObject(7, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_valor());
            pStmt.setObject(8, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id_super());
            pStmt.setObject(9, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
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

    public void update(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ccff_copia_cronograma_fisico_financeiro set  obr_nr_id=?, plco_nr_id=?, ccff_nr_peso=?, ccff_nr_mes=?, ccff_nr_ano=?, ccff_nr_quantidade=?, ccff_nr_valor=?, ipo_nr_id_super=?, ipo_nr_id=?  where  ccff_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
            pStmt.setObject(2, ccff_copia_cronograma_fisico_financeiroT.getPlco_nr_id());
            pStmt.setObject(3, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_peso());
            pStmt.setObject(4, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes());
            pStmt.setObject(5, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano());
            pStmt.setObject(6, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_quantidade());
            pStmt.setObject(7, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_valor());
            pStmt.setObject(8, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id_super());
            pStmt.setObject(9, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
            pStmt.setObject(10, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_id());
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

    public void delete(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_id());
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
            String sql = "delete from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id=?";
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

    public void deleteObraMesesMaior(int obr_nr_id, int ipo_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ccff_copia_cronograma_fisico_financeiro where ipo_nr_id=? and obr_nr_id=? and ((ccff_nr_mes >? and ccff_nr_ano =?) or(ccff_nr_ano > ?))";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ipo_nr_id);
            pStmt.setObject(3, mes);
            pStmt.setObject(4, ano);
            pStmt.setObject(5, ano);
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

    public void deleteObraMesesMenor(int obr_nr_id, int ipo_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id=? and  ipo_nr_id=? and ((ccff_nr_mes <? and ccff_nr_ano =?) or (ccff_nr_ano <?))";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, ipo_nr_id);
            pStmt.setObject(3, mes);
            pStmt.setObject(4, ano);
            pStmt.setObject(5, ano);
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

    public void deleteObraMesesMenor(int obr_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id=? and  ((ccff_nr_mes <=? and ccff_nr_ano =?) or (ccff_nr_ano <?))";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, ano);
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

    private List<Ccff_copia_cronograma_fisico_financeiroT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ccff_copia_cronograma_fisico_financeiroT> objs = new Vector();
        while (rs.next()) {
            Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(rs.getInt("ccff_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_peso(rs.getDouble("ccff_nr_peso"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_mes(rs.getInt("ccff_nr_mes"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_ano(rs.getInt("ccff_nr_ano"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_quantidade(rs.getFloat("ccff_nr_quantidade"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_valor(rs.getDouble("ccff_nr_valor"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            objs.add(ccff_copia_cronograma_fisico_financeiroT);
        }
        return objs;
    }

    public List<Ccff_copia_cronograma_fisico_financeiroT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ccff_copia_cronograma_fisico_financeiroT> list = resultSetToObjectTransfer(rs);
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByPK(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_id());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_id(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_id());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByObr_nr_id(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
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

    public TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> getByItemSemPms(int obr_nr_id) throws Exception {
        TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> tree = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id = ? and ipo_nr_id not in (select ipo_nr_id from easyconstru.pms_planilha_medicao_servico where obr_nr_id = ?) order by ipo_nr_id, ccff_nr_ano, ccff_nr_mes";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, obr_nr_id);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferTreeIpo(rs);
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByPlco_nr_id(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getPlco_nr_id());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_peso(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_peso = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_peso());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_mes(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_ano(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_quantidade(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_quantidade());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getByCcff_nr_valor(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where  ccff_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_valor());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> locateRegistro(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where plco_nr_id =? and obr_nr_id = ? and ccff_nr_mes = ? and ccff_nr_ano = ? and ipo_nr_id_super=? and ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getPlco_nr_id());
            pStmt.setObject(2, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
            pStmt.setObject(3, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_mes());
            pStmt.setObject(4, ccff_copia_cronograma_fisico_financeiroT.getCcff_nr_ano());
            pStmt.setObject(5, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id_super());
            pStmt.setObject(6, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
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

    public List<Ccff_copia_cronograma_fisico_financeiroT> locateRegistroIpo(int ipo_nr_id, int mes, int ano) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where ipo_nr_id = ? and ccff_nr_mes = ? and ccff_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);

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

    public List<Ccff_copia_cronograma_fisico_financeiroT> getAllSuperConta(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {

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
            sql.append("select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where obr_nr_id =? and plco_nr_id in(");
            sql.append(ids.toString());
            sql.append(")");
            String sl = sql.toString();
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            rs = pStmt.executeQuery();
            List<Ccff_copia_cronograma_fisico_financeiroT> list = resultSetToObjectTransfer(rs);
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

    public TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> getByObr_nr_idTree(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ccff_copia_cronograma_fisico_financeiro where obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
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

    private TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT> tree = new TreeMap<String, Ccff_copia_cronograma_fisico_financeiroT>();
        String codigo;
        while (rs.next()) {
            Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(rs.getInt("ccff_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_peso(rs.getDouble("ccff_nr_peso"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_mes(rs.getInt("ccff_nr_mes"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_ano(rs.getInt("ccff_nr_ano"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_quantidade(rs.getDouble("ccff_nr_quantidade"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_valor(rs.getDouble("ccff_nr_valor"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            codigo = rs.getInt("obr_nr_id") + "." + rs.getInt("ipo_nr_id_super") + "." + rs.getInt("plco_nr_id") + "." + rs.getInt("ccff_nr_mes") + "." + rs.getInt("ccff_nr_ano");
            tree.put(codigo, ccff_copia_cronograma_fisico_financeiroT);
        }
        return tree;
    }

private TreeMap<Integer, Ccff_copia_cronograma_fisico_financeiroT> resultSetToObjectTransferTreeRestant(ResultSet rs) throws Exception {
        TreeMap<Integer, Ccff_copia_cronograma_fisico_financeiroT> tree = new TreeMap<Integer, Ccff_copia_cronograma_fisico_financeiroT>();
        String codigo;
        while (rs.next()) {
            Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(rs.getInt("ccff_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_peso(rs.getDouble("ccff_nr_peso"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_mes(rs.getInt("ccff_nr_mes"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_ano(rs.getInt("ccff_nr_ano"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_quantidade(rs.getDouble("ccff_nr_quantidade"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_valor(rs.getDouble("ccff_nr_valor"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
//            codigo = rs.getInt("obr_nr_id") + "." + rs.getInt("ipo_nr_id_super") + "." + rs.getInt("plco_nr_id") + "." + rs.getInt("ccff_nr_mes") + "." + rs.getInt("ccff_nr_ano");
            tree.put(ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id(), ccff_copia_cronograma_fisico_financeiroT);
        }
        return tree;
    }

    private TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> resultSetToObjectTransferTreeIpo(ResultSet rs) throws Exception {
        TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>> tree = new TreeMap<Integer, List<Ccff_copia_cronograma_fisico_financeiroT>>();
        String codigo;
        while (rs.next()) {
            Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT = new Ccff_copia_cronograma_fisico_financeiroT();
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(rs.getInt("ccff_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_peso(rs.getDouble("ccff_nr_peso"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_mes(rs.getInt("ccff_nr_mes"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_ano(rs.getInt("ccff_nr_ano"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_quantidade(rs.getDouble("ccff_nr_quantidade"));
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_valor(rs.getDouble("ccff_nr_valor"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            ccff_copia_cronograma_fisico_financeiroT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            List<Ccff_copia_cronograma_fisico_financeiroT> list = tree.get(ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
            if (list == null) {
                list = new Vector();
                tree.put(ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id(), list);
            }
            list.add(ccff_copia_cronograma_fisico_financeiroT);
        }
        return tree;
    }

    public float totalDigitadoAtePeriodo(int obr_nr_id, int ipo_nr_id, int ipo_nr_id_super, int plco_nr_id, int mes, int ano) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        float total = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select ipo_nr_id,plco_nr_id, ipo_nr_id_super, sum(ccff_nr_peso) as total from easyconstru.ccff_copia_cronograma_fisico_financeiro cfff");
            sql.append(" where obr_nr_id=? and ipo_nr_id =? and (ccff_nr_mes < ? and ccff_nr_ano = ? or ccff_nr_ano < ?)  group by 1,2,3");
            ps = con.prepareCall(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, ipo_nr_id);
            ps.setObject(3, ipo_nr_id_super);
            ps.setObject(4, mes);
            ps.setObject(4, ano);
            rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getFloat("total");
            }

            return total;
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public List<Ccff_copia_cronograma_fisico_financeiroT> getAllServico(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        float total = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.ccff_copia_cronograma_fisico_financeiro cfff");
            sql.append(" where obr_nr_id=? and ipo_nr_id =? and ccff_nr_peso > 0 order by ccff_nr_ano, ccff_nr_mes");
            ps = con.prepareCall(sql.toString());
            ps.setObject(1, ccff_copia_cronograma_fisico_financeiroT.getObr_nr_id());
            ps.setObject(2, ccff_copia_cronograma_fisico_financeiroT.getIpo_nr_id());
            rs = ps.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void recalcularMesesRestante(int obr_nr_id, int ipo_nr_id, int ipo_nr_id_super, int plco_nr_id, int mes, int ano, double percentMes) throws Exception {
        try {
            Cffo_cronograma_fisico_financeiro_origenalDAO cdao = new Cffo_cronograma_fisico_financeiro_origenalDAO(dAOFactory);
            Cffo_cronograma_fisico_financeiro_origenalT cf = cdao.getByUltimoMes(obr_nr_id, ipo_nr_id, ipo_nr_id_super, plco_nr_id, mes, ano);
            int anoIni = ano;
            int anoFim = cf.getCffo_nr_ano();
            int mesIni = mes + 1;
            int mesFim = cf.getCffo_nr_mes();
            if (mesIni == 13) {
                anoIni++;
                mesIni = 1;
            }

            List<Ccff_copia_cronograma_fisico_financeiroT> list = new Vector();
            for (int year = anoIni; year < (anoFim + 1); year++) {
                int mesIniAno = year == anoIni ? mesIni : 1;
                boolean mesValido = true;
                for (int m = mesIniAno; m < 13 & mesValido; m++) {
                    mesValido = false;
                    if (year < anoFim) {
                        mesValido = true;
                    } else if (year == anoFim) {
                        if (m <= mesFim) {
                            mesValido = true;
                        }
                    }
                    if (mesValido) {
                        Ccff_copia_cronograma_fisico_financeiroT ccff = new Ccff_copia_cronograma_fisico_financeiroT();
                        ccff.setObr_nr_id(obr_nr_id);
                        ccff.setIpo_nr_id(ipo_nr_id);
                        ccff.setIpo_nr_id_super(ipo_nr_id_super);
                        ccff.setPlco_nr_id(plco_nr_id);
                        ccff.setCcff_nr_mes(m);
                        ccff.setCcff_nr_ano(year);
                        list.add(ccff);

                    }
                }
            }
            double saldo = 100 - (totalDigitadoAtePeriodo(obr_nr_id, ipo_nr_id, ipo_nr_id_super, plco_nr_id, mes, ano) + percentMes);
            for (Ccff_copia_cronograma_fisico_financeiroT ccff : list) {
                //double saldo = 100 - (totalDigitadoAtePeriodo(obr_nr_id,ipo_nr_id,ipo_nr_id_super,plco_nr_id,mes,ano)+percentMes);
                ccff.setCcff_nr_peso(saldo / list.size());
                mesLancado(ccff);
                if (ccff.getCcff_nr_id() > 0) {
                    update(ccff);
                } else {
                    insert(ccff);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    public void mesLancado(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        List<Ccff_copia_cronograma_fisico_financeiroT> listCcff = locateRegistro(ccff_copia_cronograma_fisico_financeiroT);
        if (listCcff.size() > 0) {
            ccff_copia_cronograma_fisico_financeiroT.setCcff_nr_id(listCcff.get(0).getCcff_nr_id());
        }
    }

    public int maiorAnoLancado(int obr_nr_id) throws Exception {
        int ano = 0;
        PreparedStatement pStmt = null;

        ResultSet rs = null;
        try {
            String sql = "select max(ccff_nr_ano)ano from easyconstru.ccff_copia_cronograma_fisico_financeiro where  obr_nr_id=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                ano = rs.getInt("ano");
            }
            return ano;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public List<Ccff_copia_cronograma_fisico_financeiroT> getMesesRestante(int obr_nr_id, int ipo_nr_id, int mes, int ano) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        float total = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.ccff_copia_cronograma_fisico_financeiro cfff");
            sql.append(" where obr_nr_id=? and ipo_nr_id =? and (ccff_nr_mes >= ? and ccff_nr_ano =? or ccff.nr_ano >?) order by ccff_nr_ano, ccff_nr_mes");
            ps = con.prepareCall(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, ipo_nr_id);
            ps.setObject(3, mes);
            ps.setObject(4, ano);
            rs = ps.executeQuery();
            return resultSetToObjectTransfer(rs);
        } catch (Exception e) {
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public TreeMap<Integer,List<Ccff_copia_cronograma_fisico_financeiroT>> getMesesRestanteTree(int obr_nr_id, int ipo_nr_id, int mes, int ano) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        float total = 0;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.ccff_copia_cronograma_fisico_financeiro ");
            sql.append(" where obr_nr_id=? and ipo_nr_id =? and (ccff_nr_mes >= ? and ccff_nr_ano =? or ccff_nr_ano >?) order by ccff_nr_ano, ccff_nr_mes");
            ps = con.prepareCall(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, ipo_nr_id);
            ps.setObject(3, mes);
            ps.setObject(4, ano);
            ps.setObject(5, ano);
            rs = ps.executeQuery();
            return resultSetToObjectTransferTreeIpo(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
}
