package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Ort_orcamento_temporarioDAO extends ObjectDAO {

    public Ort_orcamento_temporarioDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.ort_orcamento_temporario  ( obr_nr_id, con_nr_id, coa_nr_id,ina_nr_id, ort_nr_quantidade, ort_tx_letra, ort_tx_cod_obra) values ( ?, ?, ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getObr_nr_id());
            pStmt.setObject(2, ort_orcamento_temporarioT.getCon_nr_id());
            pStmt.setObject(3, ort_orcamento_temporarioT.getCoa_nr_id());
            pStmt.setObject(4, ort_orcamento_temporarioT.getIna_nr_id());
            pStmt.setObject(5, ort_orcamento_temporarioT.getOrt_nr_quantidade());
            pStmt.setObject(6, ort_orcamento_temporarioT.getOrt_tx_letra());
            pStmt.setObject(7, ort_orcamento_temporarioT.getOrt_tx_cod_obra());
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

    public void update(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ort_orcamento_temporario set  ort_nr_id=?, obr_nr_id=?, con_nr_id=?, coa_nr_id=?, ort_nr_quantidade=?, ort_tx_letra=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getOrt_nr_id());
            pStmt.setObject(2, ort_orcamento_temporarioT.getObr_nr_id());
            pStmt.setObject(3, ort_orcamento_temporarioT.getCon_nr_id());
            pStmt.setObject(4, ort_orcamento_temporarioT.getCoa_nr_id());
            pStmt.setObject(5, ort_orcamento_temporarioT.getOrt_nr_quantidade());
            pStmt.setObject(6, ort_orcamento_temporarioT.getOrt_tx_letra());
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

    public void delete(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ort_orcamento_temporario where -";
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

    public void deleteAll(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ort_orcamento_temporario where obr_nr_id=?";
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

    private List<Ort_orcamento_temporarioT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ort_orcamento_temporarioT> objs = new Vector();
        while (rs.next()) {
            Ort_orcamento_temporarioT ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();
            ort_orcamento_temporarioT.setOrt_nr_id(rs.getInt("ort_nr_id"));
            ort_orcamento_temporarioT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ort_orcamento_temporarioT.setCon_nr_id(rs.getInt("con_nr_id"));
            ort_orcamento_temporarioT.setCoa_nr_id(rs.getInt("coa_nr_id"));
            ort_orcamento_temporarioT.setOrt_nr_quantidade(rs.getFloat("ort_nr_quantidade"));
            ort_orcamento_temporarioT.setOrt_tx_letra(rs.getString("ort_tx_letra"));
            objs.add(ort_orcamento_temporarioT);
        }
        return objs;
    }

    public List<Ort_orcamento_temporarioT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ort_orcamento_temporarioT> list = resultSetToObjectTransfer(rs);
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

    public DataSet getAllObra(int obr_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select con.con_tx_codigo,ort.ort_tx_cod_obra, inn.inn_tx_codigo, ort.ort_nr_quantidade,inn.inn_tx_unidade, ort.ort_tx_letra, coa.coa_tx_codigo, ina.ina_tx_codigo from easyconstru.ort_orcamento_temporario ort");
            sql.append(" left join easyconstru.eqc_equivalencia_composicao eqc on (eqc.coa_nr_id = ort.coa_nr_id)");
            sql.append(" left join easyconstru.con_composicao_nova con on(con.con_nr_id = eqc.con_nr_id)");
            sql.append(" left join easyconstru.coa_composicao_anterior coa on (eqc.coa_nr_id = coa.coa_nr_id)");
            sql.append(" left join easyconstru.eqi_equivalencia_insumo eqi on (eqi.ina_nr_id = ort.ina_nr_id)");
            sql.append(" left join easyconstru.inn_insumo_novo inn on(inn.inn_nr_id = eqi.inn_nr_id)");
            sql.append(" left join easyconstru.ina_insumo_antigo ina on(ina.ina_nr_id = eqi.ina_nr_id)");
            sql.append(" where obr_nr_id = ");
            sql.append(obr_nr_id);
            sql.append(" order by ort_nr_id");
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
    //

    public List<Ort_orcamento_temporarioT> getByPK(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where -";
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

    public List<Ort_orcamento_temporarioT> getByOrt_nr_id(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  ort_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getOrt_nr_id());
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

    public List<Ort_orcamento_temporarioT> getByObr_nr_id(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getObr_nr_id());
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

    public List<Ort_orcamento_temporarioT> getByObr_nr_id(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
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

    public List<Ort_orcamento_temporarioT> getByCon_nr_id(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  con_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getCon_nr_id());
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

    public List<Ort_orcamento_temporarioT> getByCoa_nr_id(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  coa_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getCoa_nr_id());
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

    public List<Ort_orcamento_temporarioT> getByOrt_nr_quantidade(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  ort_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ort_orcamento_temporarioT.getOrt_nr_quantidade());
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

    public List<Ort_orcamento_temporarioT> getByOrt_tx_letra(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ort_orcamento_temporario where  Upper(ort_tx_letra) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ort_orcamento_temporarioT.getOrt_tx_letra() + '%');
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
