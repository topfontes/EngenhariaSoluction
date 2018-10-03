package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Ipo_item_plano_contas_obraDAO extends ObjectDAO {

    private static Object insert = "true";

    public Ipo_item_plano_contas_obraDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxValue() throws SQLException, Exception {
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "select max(ipo_nr_id) as ipo_nr_id from easyconstru.ipo_item_plano_contas_obra";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            int id = rs.getInt("ipo_nr_id");
            return id;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }

    }

    public void insert(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        synchronized (insert) {
            try {
                String sql = "insert into easyconstru.ipo_item_plano_contas_obra  ( ipo_nr_quantidade, ipo_nr_vl_unitario, ipo_nr_vl_total, obr_nr_id, plco_nr_id, ipo_plc_nr_id_servico, ipo_nr_id_nivel_1,ipo_nr_id_nivel_2,ipo_nr_id_nivel_3,ipo_nr_id_super, ipo_nr_nivel,ipo_bl_curva_abc, ipo_bl_cronograma) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? )";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_quantidade());
                pStmt.setObject(2, ipo_item_plano_contas_obraT.getIpo_nr_vl_unitario());
                pStmt.setObject(3, ipo_item_plano_contas_obraT.getIpo_nr_vl_total());
                pStmt.setObject(4, ipo_item_plano_contas_obraT.getObr_nr_id());
                pStmt.setObject(5, ipo_item_plano_contas_obraT.getPlco_nr_id());
                pStmt.setObject(6, ipo_item_plano_contas_obraT.getIpo_plc_nr_id_servico());
                pStmt.setObject(7, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_1());
                pStmt.setObject(8, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_2());
                pStmt.setObject(9, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_3());
                pStmt.setObject(10, ipo_item_plano_contas_obraT.getIpo_nr_id_super());
                pStmt.setObject(11, ipo_item_plano_contas_obraT.getIpo_nr_nivel());
                pStmt.setObject(12, ipo_item_plano_contas_obraT.getIpo_bl_curva_abc());
                pStmt.setObject(13, ipo_item_plano_contas_obraT.isIpo_bl_cronograma());
                pStmt.execute();
                ipo_item_plano_contas_obraT.setIpo_nr_id(maxValue());
            } catch (Exception e) {
                throw e;
            } finally {
                try {
                    pStmt.close();
                } catch (Exception e) {
                }

            }
        }
    }

    public void update(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ipo_item_plano_contas_obra set  ipo_nr_quantidade=?, ipo_nr_vl_unitario=?, ipo_nr_vl_total=?, obr_nr_id=?, plco_nr_id=?, ipo_plc_nr_id_servico=?, ipo_nr_id_nivel_1 =?,ipo_nr_id_nivel_2=?,ipo_nr_id_nivel_3=?, ipo_nr_id_super=?, ipo_nr_nivel=?, ipo_bl_curva_abc=?, ipo_bl_cronograma=?  where  ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_quantidade());
            pStmt.setObject(2, ipo_item_plano_contas_obraT.getIpo_nr_vl_unitario());
            pStmt.setObject(3, ipo_item_plano_contas_obraT.getIpo_nr_vl_total());
            pStmt.setObject(4, ipo_item_plano_contas_obraT.getObr_nr_id());
            pStmt.setObject(5, ipo_item_plano_contas_obraT.getPlco_nr_id());
            pStmt.setObject(6, ipo_item_plano_contas_obraT.getIpo_plc_nr_id_servico());
            pStmt.setObject(7, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_1());
            pStmt.setObject(8, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_2());
            pStmt.setObject(9, ipo_item_plano_contas_obraT.getIpo_nr_id_nivel_3());
            pStmt.setObject(10, ipo_item_plano_contas_obraT.getIpo_nr_id_super());
            pStmt.setObject(11, ipo_item_plano_contas_obraT.getIpo_nr_nivel());
            pStmt.setObject(12, ipo_item_plano_contas_obraT.getIpo_bl_curva_abc());
            pStmt.setObject(13, ipo_item_plano_contas_obraT.isIpo_bl_cronograma());
            pStmt.setObject(14, ipo_item_plano_contas_obraT.getIpo_nr_id());
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

    public void delete(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_id());
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

    public void deleteAllObra(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ipo_item_plano_contas_obra where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getObr_nr_id());
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

    private List<Ipo_item_plano_contas_obraT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ipo_item_plano_contas_obraT> objs = new Vector();
        while (rs.next()) {
            Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
            ipo_item_plano_contas_obraT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            ipo_item_plano_contas_obraT.setIpo_nr_quantidade(rs.getFloat("ipo_nr_quantidade"));
            ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(rs.getFloat("ipo_nr_vl_unitario"));
            ipo_item_plano_contas_obraT.setIpo_nr_vl_total(rs.getFloat("ipo_nr_vl_total"));
            ipo_item_plano_contas_obraT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ipo_item_plano_contas_obraT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ipo_item_plano_contas_obraT.setIpo_plc_nr_id_servico(rs.getInt("ipo_plc_nr_id_servico"));
            objs.add(ipo_item_plano_contas_obraT);
        }
        return objs;
    }

    public List<Ipo_item_plano_contas_obraT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Ipo_item_plano_contas_obraT> list = resultSetToObjectTransfer(rs);
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

    public List<Ipo_item_plano_contas_obraT> getByPK(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_id());
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

    public List<Ipo_item_plano_contas_obraT> getByIpo_nr_id(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_id());
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

    public List<Ipo_item_plano_contas_obraT> getByIpo_nr_quantidade(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_quantidade());
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

    public List<Ipo_item_plano_contas_obraT> getByIpo_nr_vl_unitario(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_vl_unitario = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_vl_unitario());
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

    public List<Ipo_item_plano_contas_obraT> getByIpo_nr_vl_total(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  ipo_nr_vl_total = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getIpo_nr_vl_total());
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

    public List<Ipo_item_plano_contas_obraT> getByObr_nr_id(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  obr_nr_id = ? order by ipo_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getObr_nr_id());
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


    public List<Ipo_item_plano_contas_obraT> getByObr_nr_idServico(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  obr_nr_id = ? and ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getObr_nr_id());
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

    public float getTotalObr_nr_id(int obr_nr_id) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(ipo_nr_vl_total) as total from easyconstru.ipo_item_plano_contas_obra where  obr_nr_id = ? and ipo_bl_cronograma = true";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            rs = pStmt.executeQuery();
            float total = 0;
            if(rs.next()){
                total = rs.getFloat("total");
            }
            return total;
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

    public int getByqtdeImportado(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select count(obr_nr_id) as qtde from easyconstru.ipo_item_plano_contas_obra where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getObr_nr_id());
            rs = pStmt.executeQuery();
            rs.next();
            int qt = 0;
            if (rs.getString("qtde").trim().length() > 0) {
                qt = rs.getInt("qtde");
            }
            return qt;
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

    public List<Ipo_item_plano_contas_obraT> getByPlco_nr_id(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getPlco_nr_id());
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

    /** M�todos FK */
    public List<Ipo_item_plano_contas_obraT> getByPlco_plano_contas_orcamento(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ipo_item_plano_contas_obra where plco_plano_contas_orcamento.plco_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ipo_item_plano_contas_obraT.getPlco_nr_id());
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

    public TreeMap<Integer, List<Ipo_item_plano_contas_obraT>> getInsumos(int obr_nr_id) throws SQLException, Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select ipo.*, equiv.plc_nr_id from easyconstru.ipo_item_plano_contas_obra as ipo ");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas as equiv on(equiv.plco_nr_id = ipo.plco_nr_id)");
            sql.append(" where obr_nr_id = ? ");
//            sql.append(" where obr_nr_id = ? and (ipo_nr_nivel = 5 or (ipo_nr_nivel = 5  and ipo_bl_cronograma = true))");
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, obr_nr_id);
            rs = ps.executeQuery();
            return resultSetToObjectTransferTree(rs);
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    private TreeMap<Integer, List<Ipo_item_plano_contas_obraT>> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<Integer, List<Ipo_item_plano_contas_obraT>> tree = new TreeMap<Integer, List<Ipo_item_plano_contas_obraT>>();
        List<Ipo_item_plano_contas_obraT> listTemp = new Vector();
        while (rs.next()) {
            Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
            ipo_item_plano_contas_obraT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            ipo_item_plano_contas_obraT.setIpo_nr_quantidade(rs.getFloat("ipo_nr_quantidade"));
            ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(rs.getFloat("ipo_nr_vl_unitario"));
            ipo_item_plano_contas_obraT.setIpo_nr_vl_total(rs.getFloat("ipo_nr_vl_total"));
            ipo_item_plano_contas_obraT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ipo_item_plano_contas_obraT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            ipo_item_plano_contas_obraT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            ipo_item_plano_contas_obraT.setIpo_plc_nr_id_servico(rs.getInt("ipo_plc_nr_id_servico"));
            ipo_item_plano_contas_obraT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            listTemp.add(ipo_item_plano_contas_obraT);
            if (tree.get(ipo_item_plano_contas_obraT.getIpo_nr_id_super()) == null) {
                List<Ipo_item_plano_contas_obraT> listIpo = new Vector();
                listIpo.add(ipo_item_plano_contas_obraT);
                tree.put(ipo_item_plano_contas_obraT.getIpo_nr_id_super(), listIpo);
            } else {
                tree.get(ipo_item_plano_contas_obraT.getIpo_nr_id_super()).add(ipo_item_plano_contas_obraT);
            }
        }

        for (Ipo_item_plano_contas_obraT ipo_T : listTemp) {
            Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
            ipo_item_plano_contas_obraT.setIpo_nr_id(ipo_T.getIpo_nr_id());
            ipo_item_plano_contas_obraT.setIpo_nr_quantidade(ipo_T.getIpo_nr_quantidade());
            ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(ipo_T.getIpo_nr_vl_unitario());
            ipo_item_plano_contas_obraT.setIpo_nr_vl_total(ipo_T.getIpo_nr_vl_total());
            ipo_item_plano_contas_obraT.setObr_nr_id(ipo_T.getObr_nr_id());
            ipo_item_plano_contas_obraT.setPlco_nr_id(ipo_T.getPlco_nr_id());
            ipo_item_plano_contas_obraT.setIpo_nr_id_super(ipo_T.getIpo_nr_id_super());
            ipo_item_plano_contas_obraT.setIpo_plc_nr_id_servico(ipo_T.getIpo_plc_nr_id_servico());
            ipo_item_plano_contas_obraT.setPlc_nr_id(ipo_T.getPlc_nr_id());
            if (tree.get(ipo_item_plano_contas_obraT.getIpo_nr_id()) == null) {
                List<Ipo_item_plano_contas_obraT> listIpo = new Vector();
                listIpo.add(ipo_item_plano_contas_obraT);
                tree.put(ipo_item_plano_contas_obraT.getIpo_nr_id(), listIpo);
//                System.out.println(ipo_T.getIpo_nr_id()+" - " +ipo_T.getIpo_nr_id_super());
            }
        }
        listTemp.clear();

        return tree;
    }

    public String getIdClasses(int[] classes) {
        String cls = "";
        for (int i = 0; i < classes.length; i++) {
            if (i > 0) {
                cls += "," + classes[i];
            } else {
                cls += classes[i];
            }
        }
        cls = "(" + cls + ")";
        return cls;
    }

    public double getValorOrcadoClasses(int obr_nr_id, int[] ids) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select sum(ipo_nr_vl_total) as total from easyconstru.vw_orcamento_sub_classe where obr_nr_id =? and plc_nr_id_super in" + getIdClasses(ids);
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            rs = pStmt.executeQuery();
            double valor = 0;
            if (rs.next()) {
                valor = rs.getDouble("total");
            }
            return valor;
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
