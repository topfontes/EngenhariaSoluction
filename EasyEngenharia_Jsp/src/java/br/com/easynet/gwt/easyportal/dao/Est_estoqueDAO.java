package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;

public class Est_estoqueDAO extends ObjectDAO {

    private int cli_nr_id = 0;

    public Est_estoqueDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    private static final String ASPAS = "\"";

    public String getValueSemAspas(String valor) {
        String nome = "";

        if (valor != null) {
            nome = valor.replace(ASPAS, "''");
            nome = nome.replace("\r", " ");
            nome = nome.replace("\n", " ");
        }
        return nome;
    }

    public int getNewClassificassao(Est_estoqueT est_estoqueT) throws Exception {
        int plc = est_estoqueT.getPlc_nr_id();
        try {
            List<Est_estoqueT> list = getItemClassificado(est_estoqueT.getObr_nr_id(), est_estoqueT.getEst_tx_nome().trim());
            if (list != null) {
                if (list.size() > 0) {
                    plc = list.get(0).getPlc_nr_id();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return plc;
    }    

    public List<Est_estoqueT> getItemClassificado_old(int cli, String nome) {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select est.* from easyconstru.est_estoque est ");
            buffer.append(" inner join easyconstru.obr_obras obra on(obra.obr_nr_id = est.obr_nr_id)");
            buffer.append(" inner join easyconstru.emp_empreendimento emp on(emp.emp_nr_id = obra.emp_nr_id)");
            buffer.append(" where emp.cli_nr_id =? and trim(est.est_tx_nome) =?");
            pStmt = con.prepareStatement(buffer.toString());
            pStmt.setObject(1, cli);
            pStmt.setObject(2, nome);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Est_estoqueT> getItemClassificado(int obr_nr_id, String nome) {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer buffer = new StringBuffer();
            buffer.append("select est.* from easyconstru.est_estoque est ");
            buffer.append(" where est.obr_nr_id =? and trim(est.est_tx_nome) =? order by est.est_dt_base desc limit 1");
            pStmt = con.prepareStatement(buffer.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, nome);
            rs = pStmt.executeQuery();
            return resultSetToObjectTransfer(rs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    

    public void insert(Est_estoqueT est_estoqueT) throws Exception {
        est_estoqueT.setEst_tx_nome(getValueSemAspas(est_estoqueT.getEst_tx_nome()));
        PreparedStatement pStmt = null;
        
        try {
            //int id_plc = getClassificassao(est_estoqueT);
            String newKey = est_estoqueT.getObr_nr_id() + "." + est_estoqueT.getEst_tx_key() + "." + est_estoqueT.getEst_nr_mes() + "." + est_estoqueT.getEst_nr_ano();
            String sql = "insert into easyconstru.est_estoque  ( est_nr_mes, plc_nr_id, est_nr_quantidade, est_nr_vl_unitario, est_nr_vl_total, est_tx_unidade, obr_nr_id, est_nr_ano,est_dt_base,est_tx_key, est_tx_nome) values ( ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_mes());
            //pStmt.setObject(2, est_estoqueT.getPlc_nr_id());
            pStmt.setObject(2, getNewClassificassao(est_estoqueT));
            pStmt.setObject(3, est_estoqueT.getEst_nr_quantidade());
            pStmt.setObject(4, est_estoqueT.getEst_nr_vl_unitario());
            pStmt.setObject(5, est_estoqueT.getEst_nr_vl_total());
            pStmt.setObject(6, getValueSemAspas(est_estoqueT.getEst_tx_unidade()));
            pStmt.setObject(7, est_estoqueT.getObr_nr_id());
            pStmt.setObject(8, est_estoqueT.getEst_nr_ano());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String data = "01/" + est_estoqueT.getEst_nr_mes() + "/" + est_estoqueT.getEst_nr_ano();
            est_estoqueT.setEst_dt_base(dateFormat.parse(data));
            java.sql.Date dt = new java.sql.Date(est_estoqueT.getEst_dt_base().getTime());
            pStmt.setObject(9, dt);
            pStmt.setObject(10, newKey);
            pStmt.setObject(11, est_estoqueT.getEst_tx_nome());
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

    public void update(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String newKey = est_estoqueT.getObr_nr_id() + "." + est_estoqueT.getEst_tx_key() + "." + est_estoqueT.getEst_nr_mes() + "." + est_estoqueT.getEst_nr_ano();
            String sql = "update easyconstru.est_estoque set est_nr_mes=?, plc_nr_id=?, est_nr_quantidade=?, est_nr_vl_unitario=?, est_nr_vl_total=?, est_tx_unidade=?, obr_nr_id=?, est_nr_ano=?, est_dt_base=?, est_tx_key=? , est_tx_nome=? where  est_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_mes());
            pStmt.setObject(2, est_estoqueT.getPlc_nr_id());
            pStmt.setObject(3, est_estoqueT.getEst_nr_quantidade());
            pStmt.setObject(4, est_estoqueT.getEst_nr_vl_unitario());
            pStmt.setObject(5, est_estoqueT.getEst_nr_vl_total());
            pStmt.setObject(6, est_estoqueT.getEst_tx_unidade());
            pStmt.setObject(7, est_estoqueT.getObr_nr_id());
            pStmt.setObject(8, est_estoqueT.getEst_nr_ano());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String data = "01/" + est_estoqueT.getEst_nr_mes() + "/" + est_estoqueT.getEst_nr_ano();
            est_estoqueT.setEst_dt_base(dateFormat.parse(data));
            java.sql.Date dt = new java.sql.Date(est_estoqueT.getEst_dt_base().getTime());
            pStmt.setObject(9, dt);
            pStmt.setObject(10, newKey);

            pStmt.setObject(11, est_estoqueT.getEst_tx_nome());
            pStmt.setObject(12, est_estoqueT.getEst_nr_id());
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

    public void updateClasse(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.est_estoque set plc_nr_id=? where est_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getPlc_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_id());
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

    public void delete(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque where  est_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_id());
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

    private List<Est_estoqueT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Est_estoqueT> objs = new Vector();
        while (rs.next()) {
            Est_estoqueT est_estoqueT = new Est_estoqueT();
            est_estoqueT.setEst_nr_id(rs.getInt("est_nr_id"));
            est_estoqueT.setEst_nr_mes(rs.getInt("est_nr_mes"));
            est_estoqueT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            est_estoqueT.setEst_nr_quantidade(rs.getFloat("est_nr_quantidade"));
            est_estoqueT.setEst_nr_vl_unitario(rs.getFloat("est_nr_vl_unitario"));
            est_estoqueT.setEst_nr_vl_total(rs.getFloat("est_nr_vl_total"));
            est_estoqueT.setEst_tx_unidade(rs.getString("est_tx_unidade"));
            est_estoqueT.setObr_nr_id(rs.getInt("obr_nr_id"));
            est_estoqueT.setObr_nr_id(rs.getInt("est_nr_ano"));
            est_estoqueT.setEst_tx_key(rs.getString("est_tx_key"));
            est_estoqueT.setEst_tx_nome(rs.getString("est_tx_nome"));
            objs.add(est_estoqueT);
        }
        return objs;
    }

    public List<Est_estoqueT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Est_estoqueT> list = resultSetToObjectTransfer(rs);
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

    public DataSet getAllDs(Est_estoqueT est_estoqueT) throws Exception {
        DataSet ds = new DataSet();
        ArrayList param = new ArrayList();
        StringBuffer sql = new StringBuffer();

        String nome = "replace (est_tx_nome, '" + ASPAS + "','''') as est_tx_nome";

        sql.append("select estoque.est_nr_id, estoque.est_nr_mes , estoque.plc_nr_id, estoque.est_nr_quantidade, estoque.est_nr_vl_unitario, estoque.est_nr_vl_total, estoque.obr_nr_id,Plano.plc_tx_nome, estoque.est_nr_ano, estoque.est_tx_unidade, ").append(nome);

        sql.append(" from easyconstru.est_estoque as estoque inner join easyconstru.plc_plano_contas as plano on(estoque.plc_nr_id = plano.plc_nr_id)");
        sql.append("  where  estoque.est_nr_id > 0 ");
        if (est_estoqueT.getEst_nr_mes() > 0) {
            sql.append(" and estoque.est_nr_mes = ?");
            param.add(est_estoqueT.getEst_nr_mes());
        }
        if (est_estoqueT.getEst_nr_ano() > 0) {
            sql.append(" and estoque.est_nr_ano = ?");
            param.add(est_estoqueT.getEst_nr_ano());
        }
        if (est_estoqueT.getPlc_nr_id() > 0) {
            sql.append(" and estoque.plc_nr_id = ?");
            param.add(est_estoqueT.getPlc_nr_id());
        }
        if (est_estoqueT.getObr_nr_id() > 0) {
            sql.append(" and estoque.obr_nr_id = ?");
            param.add(est_estoqueT.getObr_nr_id());
        }
        sql.append(" order by est_nr_id ");

        String s = sql.toString();
        ds = executeQuery(sql.toString(), param.toArray());


//        for (int i = 0; i < ds.getList().size(); i++) {
//           System.out.println(ds.getList().get(i).getColumn(5));
//
//        }

        return ds;

    }

    public DataSet getAllDsClassificar(Est_estoqueT est_estoqueT) throws Exception {
        DataSet ds = new DataSet();
        ArrayList param = new ArrayList();
        String nome = "replace (est_tx_nome, '" + ASPAS + "','''') as est_tx_nome";
        StringBuffer sql = new StringBuffer();
        sql.append("select estoque.est_nr_id, estoque.est_nr_mes , estoque.plc_nr_id, estoque.est_nr_quantidade, estoque.est_nr_vl_unitario, estoque.est_nr_vl_total, estoque.obr_nr_id,Plano.plc_tx_nome, estoque.est_nr_ano, estoque.est_tx_unidade,").append(nome);
        sql.append(" from easyconstru.est_estoque as estoque inner join easyconstru.plc_plano_contas as plano on(estoque.plc_nr_id = plano.plc_nr_id)");
        sql.append("  where  estoque.plc_nr_id = 0 ");
        if (est_estoqueT.getEst_nr_mes() > 0) {
            sql.append(" and estoque.est_nr_mes = ?");
            param.add(est_estoqueT.getEst_nr_mes());
        }
        if (est_estoqueT.getEst_nr_ano() > 0) {
            sql.append(" and estoque.est_nr_ano = ?");
            param.add(est_estoqueT.getEst_nr_ano());
        }
        if (est_estoqueT.getPlc_nr_id() > 0) {
            sql.append(" and estoque.plc_nr_id = ?");
            param.add(est_estoqueT.getPlc_nr_id());
        }
        if (est_estoqueT.getObr_nr_id() > 0) {
            sql.append(" and estoque.obr_nr_id = ?");
            param.add(est_estoqueT.getObr_nr_id());
        }
        sql.append(" order by est_nr_id ");
        String s = sql.toString();
        ds = executeQuery(sql.toString(), param.toArray());


//        for (int i = 0; i < ds.getList().size(); i++) {
//           System.out.println(ds.getList().get(i).getColumn(5));
//
//        }

        return ds;

    }

    public List<Est_estoqueT> getByPK(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_id());
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

    public List<Est_estoqueT> getByEst_nr_id(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_id());
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

    public List<Est_estoqueT> getByEst_nr_mes(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_mes());
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

    public List<Est_estoqueT> getByPlc_nr_id(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getPlc_nr_id());
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

    public List<Est_estoqueT> getByEst_nr_quantidade(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_quantidade());
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

    public List<Est_estoqueT> getByEst_nr_vl_unitario(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_vl_unitario = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_vl_unitario());
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

    public List<Est_estoqueT> getByEst_nr_vl_total(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  est_nr_vl_total = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getEst_nr_vl_total());
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

    public List<Est_estoqueT> getByEst_tx_unidade(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  Upper(est_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
//            pStmt.setObject(1, '%' + est_estoqueT.getEst_tx_unidade() + '%');
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

    public List<Est_estoqueT> getByObr_nr_id(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
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

    public List<Est_estoqueT> getByObr_nr_idMesAno(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  obr_nr_id = ? and est_nr_mes=? and est_nr_ano =? order by plc_nr_id";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_mes());
            pStmt.setObject(3, est_estoqueT.getEst_nr_ano());
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

    public TreeMap<String, Est_estoqueT> getByObr_nr_idTree(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.est_estoque where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            rs = pStmt.executeQuery();

            TreeMap<String, Est_estoqueT> tree = new TreeMap<String, Est_estoqueT>();
            while (rs.next()) {
                Est_estoqueT estoqueT = new Est_estoqueT();
                estoqueT.setEst_nr_id(rs.getInt("est_nr_id"));
                estoqueT.setEst_nr_mes(rs.getInt("est_nr_mes"));
                estoqueT.setPlc_nr_id(rs.getInt("plc_nr_id"));
                estoqueT.setEst_nr_quantidade(rs.getFloat("est_nr_quantidade"));
                estoqueT.setEst_nr_vl_unitario(rs.getFloat("est_nr_vl_unitario"));
                estoqueT.setEst_nr_vl_total(rs.getFloat("est_nr_vl_total"));
                estoqueT.setEst_tx_unidade(rs.getString("est_tx_unidade"));
                estoqueT.setObr_nr_id(rs.getInt("obr_nr_id"));
                estoqueT.setObr_nr_id(rs.getInt("est_nr_ano"));
                estoqueT.setEst_tx_key(rs.getString("est_tx_key"));
                tree.put(estoqueT.getEst_tx_key(), estoqueT);
            }
            return tree;
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

    public void deleteAll(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque";
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

    public void deleteObra(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque where obr_nr_id =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
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

    public void deleteObraAno(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque where obr_nr_id =? and est_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_ano());
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

    public void deleteObraMes(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque where obr_nr_id =? and est_nr_mes=? and est_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_mes());
            pStmt.setObject(3, est_estoqueT.getEst_nr_ano());
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

    public DataSet estoqueMesSubClasse(int obr_nr_id, int mes, int ano) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select est.plc_nr_id, conta.plc_tx_nome, sum(est.est_nr_vl_total)as valor from easyconstru.est_estoque est");
            sql.append(" inner join easyconstru.plc_plano_contas conta on(conta.plc_nr_id = est.plc_nr_id)");
            sql.append(" where est.obr_nr_id =? and est.est_nr_mes=? and est.est_nr_ano = ?");
            sql.append(" group by 1,2");
            Object[] param = new Object[3];
            param[0] = obr_nr_id;
            param[1] = mes;
            param[2] = ano;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        }
    }

    public DataSet estoqueMesSubClasse(int obr_nr_id, int mes, int ano, int plc_nr_id_super) throws Exception {
        DataSet ds = null;
        int tamVetor = 3;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select est.plc_nr_id, conta.plc_tx_nome, sum(est.est_nr_vl_total)as valor from easyconstru.est_estoque est");
            sql.append(" inner join easyconstru.plc_plano_contas conta on(conta.plc_nr_id = est.plc_nr_id)");
            sql.append(" where est.obr_nr_id =? and est.est_nr_mes=? and est.est_nr_ano = ? ");
            if (plc_nr_id_super > 0) {
                sql.append(" and conta.plc_nr_id_super =?");
                tamVetor = 4;
            }
            sql.append(" group by 1,2");
            Object[] param = new Object[tamVetor];
            param[0] = obr_nr_id;
            param[1] = mes;
            param[2] = ano;
            if (plc_nr_id_super > 0) {
                param[3] = plc_nr_id_super;
            }
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteObraMesAno(Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.est_estoque where  obr_nr_id=? and est_nr_mes=? and est_nr_ano=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_mes());
            pStmt.setObject(3, est_estoqueT.getEst_nr_ano());

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

    public void updateObraMesAno(Est_estoqueT est_estoqueTOrig, Est_estoqueT est_estoqueT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.est_estoque set obr_nr_id=?, est_nr_mes=?,  est_nr_ano=?  where  obr_nr_id=? and est_nr_mes=? and est_nr_ano=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, est_estoqueT.getObr_nr_id());
            pStmt.setObject(2, est_estoqueT.getEst_nr_mes());
            pStmt.setObject(3, est_estoqueT.getEst_nr_ano());

            pStmt.setObject(4, est_estoqueTOrig.getObr_nr_id());
            pStmt.setObject(5, est_estoqueTOrig.getEst_nr_mes());
            pStmt.setObject(6, est_estoqueTOrig.getEst_nr_ano());

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

    public double getCustoRealizadoPeriodo(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();
            sql.append("select sum(est.est_nr_vl_total) as valor from easyconstru.est_estoque as est");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = est.plc_nr_id)");
            sql.append(" where est.obr_nr_id =? and est_nr_mes =? and est_nr_ano = ?  and plc.plc_nr_id_super in" + getIdClasses(id_classes));
            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            rs = pStmt.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }
            return valor;
        } catch (Exception e) {

            throw e;
        } finally {
            try {
                pStmt.close();
                rs.close();
            } catch (Exception e) {
            }
        }
    }
    public java.util.TreeMap<Integer, Double> getBySubClasseTreeBI(int obr_nr_id, int mes, int ano) throws Exception
/*     */   {
/* 558 */     PreparedStatement pStmt = null;
/* 559 */     ResultSet rs = null;
/*     */     try {
/* 561 */       String sql = "select plc_nr_id, sum(est_nr_vl_total) as est_nr_vl_total from easyconstru.est_estoque where  obr_nr_id = ? and ((est_nr_mes <=? and est_nr_ano = ?) or est_nr_ano <?) group by plc_nr_id";
/* 562 */       pStmt = this.con.prepareStatement(sql);
/* 563 */       pStmt.setObject(1, Integer.valueOf(obr_nr_id));
/* 564 */       pStmt.setObject(2, Integer.valueOf(mes));
/* 565 */       pStmt.setObject(3, Integer.valueOf(ano));
/* 566 */       pStmt.setObject(4, Integer.valueOf(ano));
/* 567 */       rs = pStmt.executeQuery();
/*     */       
/* 569 */       java.util.TreeMap<Integer, Double> tree = new java.util.TreeMap();
/* 570 */       while (rs.next()) {
/* 571 */         tree.put(Integer.valueOf(rs.getInt("plc_nr_id")), Double.valueOf(rs.getDouble("est_nr_vl_total")));
/*     */       }
/* 573 */       return tree;
/*     */     } catch (Exception e) {
/* 575 */       throw e;
/*     */     } finally {
/*     */       try {
/* 578 */         rs.close();
/* 579 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
}
