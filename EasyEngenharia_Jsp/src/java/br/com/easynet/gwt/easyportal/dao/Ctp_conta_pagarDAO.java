package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.easynet.database.ItemDS;
import br.com.easynet.database.RowDS;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
//import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Ctp_conta_pagarDAO extends ObjectDAO {

    private TreeMap<String, Ctp_conta_pagarT> treeMain = null;
    private TreeMap<String, Ctp_conta_pagarT> treeMainEngeb = null;
    private boolean arquivo_engeb;

    public Ctp_conta_pagarDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    private static final String ASPAS = "\"";
    private static final String barraR = "\r";

    public String getValueSemAspas(String valor) {
        String nome = "";

        if (valor != null) {
            nome = valor.replace(ASPAS, "''");
            nome = nome.replace("\r", " ");
            nome = nome.replace("\n", " ");
            //nome = nome.replace("'", " ");
        }
        return nome;
    }

    public void insert(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.ctp_conta_pagar (ctp_tx_fornecedor, ctp_nr_mes, plc_nr_id, ctp_nr_valor, ctp_nr_documento, ctp_tx_status, obr_nr_id, ctp_nr_ano, ctp_tx_obs, ctp_dt_vencimento, ctp_dt_emissao) values ( ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            if (ctp_conta_pagarT.getCtp_tx_fornecedor().length() > 100) {
                ctp_conta_pagarT.setCtp_tx_fornecedor(ctp_conta_pagarT.getCtp_tx_fornecedor().substring(0, 99));
            }
//            if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
            setPlc(ctp_conta_pagarT);
//            } else {
//            }
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_tx_fornecedor());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getPlc_nr_id());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_nr_valor());
            pStmt.setObject(5, ctp_conta_pagarT.getCtp_nr_documento());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_tx_status());
            pStmt.setObject(7, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(8, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(9, ctp_conta_pagarT.getCtp_tx_obs());
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(10, dt1);
            if (ctp_conta_pagarT.getCtp_dt_emissao() != null) {
                java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
                pStmt.setObject(11, dt2);
            } else {
                pStmt.setObject(11, null);
            }
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

    public void setPlc(Ctp_conta_pagarT ctp_conta_pagarT) {
        try {
            if (treeMain == null) {
                treeMain = getByObr_nr_idTree(ctp_conta_pagarT);
            }
            Ctp_conta_pagarT ctp = null;
            if (!arquivo_engeb) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String data = sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + data;
                ctp = treeMain.get(key);
                if (ctp != null) {
                    if (ctp.getPlc_nr_id() > 0) {
                        ctp_conta_pagarT.setPlc_nr_id(ctp.getPlc_nr_id());
                        ctp_conta_pagarT.setCtp_tx_fornecedor(ctp.getCtp_tx_fornecedor());
                    }
                }
            } else {
                if (treeMainEngeb == null) {
                    treeMainEngeb = getByObr_nr_idTreeEngeb(ctp_conta_pagarT);
                }
                ctp = treeMainEngeb.get(ctp_conta_pagarT.getCtp_tx_obs());

                if (ctp != null) {
                    if (ctp.getPlc_nr_id() > 0) {
                        ctp_conta_pagarT.setPlc_nr_id(ctp.getPlc_nr_id());
                        ctp_conta_pagarT.setCtp_tx_fornecedor(ctp.getCtp_tx_fornecedor());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setPlc2(Ctp_conta_pagarT ctp_conta_pagarT) {
        try {
            if (treeMain == null) {
                treeMain = new TreeMap<String, Ctp_conta_pagarT>();
            }

            List<Ctp_conta_pagarT> list = getByCtp_nr_documentoObra(ctp_conta_pagarT);
            if (list.size() > 0) {
                if (list.get(0).getPlc_nr_id() > 0) {
                    ctp_conta_pagarT.setPlc_nr_id(list.get(0).getPlc_nr_id());
                    ctp_conta_pagarT.setCtp_tx_fornecedor(list.get(0).getCtp_tx_fornecedor());
                }
            } else {
                list = getByCtp_tx_obs(ctp_conta_pagarT);
                if (list.size() > 0) {
                    if (list.get(0).getPlc_nr_id() > 0) {
                        ctp_conta_pagarT.setPlc_nr_id(list.get(0).getPlc_nr_id());
                        ctp_conta_pagarT.setCtp_tx_fornecedor(list.get(0).getCtp_tx_fornecedor());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctp_conta_pagar set  ctp_tx_fornecedor=?, ctp_nr_mes=?, plc_nr_id=?, ctp_nr_valor=?, ctp_nr_documento=?, ctp_tx_status=?, obr_nr_id=?, ctp_nr_ano=?,ctp_tx_obs =?, ctp_dt_vencimento=?, ctp_dt_emissao=?  where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_tx_fornecedor());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getPlc_nr_id());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_nr_valor());
            pStmt.setObject(5, ctp_conta_pagarT.getCtp_nr_documento());
            pStmt.setObject(6, ctp_conta_pagarT.getCtp_tx_status());
            pStmt.setObject(7, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(8, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(9, ctp_conta_pagarT.getCtp_tx_obs());
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(10, dt1);
            if (ctp_conta_pagarT.getCtp_dt_emissao() != null) {
                java.sql.Date dt2 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_emissao().getTime());
                pStmt.setObject(11, dt2);

            } else {
                pStmt.setObject(11, null);
            }
            pStmt.setObject(12, ctp_conta_pagarT.getCtp_nr_id());
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

    public void updateObs(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctp_conta_pagar set  ctp_tx_obs =?  where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_tx_obs());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_id());
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

    public void updateVencimento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctp_conta_pagar set ctp_dt_vencimento=?  where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(ctp_conta_pagarT.getCtp_dt_vencimento().getTime());
            pStmt.setObject(1, dt1);
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_id());
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

    public void updateClasse(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctp_conta_pagar set  plc_nr_id=? where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getPlc_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_id());
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

    public void delete(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ctp_conta_pagar where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    public void deleteAll(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ctp_conta_pagar where  obr_nr_id=? and ctp_tx_status=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_tx_status());
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

    private List<Ctp_conta_pagarT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Ctp_conta_pagarT> objs = new Vector();
        while (rs.next()) {
            Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
            ctp_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ctp_conta_pagarT.setCtp_tx_fornecedor(getValueSemAspas(rs.getString("ctp_tx_fornecedor")));
            ctp_conta_pagarT.setCtp_nr_mes(rs.getInt("ctp_nr_mes"));
            ctp_conta_pagarT.setCtp_nr_ano(rs.getInt("ctp_nr_ano"));
            ctp_conta_pagarT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            ctp_conta_pagarT.setCtp_nr_valor(rs.getDouble("ctp_nr_valor"));
            ctp_conta_pagarT.setCtp_nr_documento(getValueSemAspas(rs.getString("ctp_nr_documento")));
            ctp_conta_pagarT.setCtp_tx_status(rs.getString("ctp_tx_status"));
            ctp_conta_pagarT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ctp_conta_pagarT.setCtp_tx_obs(getValueSemAspas(rs.getString("ctp_tx_obs")));
            ctp_conta_pagarT.setCtp_dt_vencimento(rs.getDate("ctp_dt_vencimento"));
            ctp_conta_pagarT.setCtp_dt_emissao(rs.getDate("ctp_dt_emissao"));
            objs.add(ctp_conta_pagarT);
        }
        return objs;
    }

    public DataSet getAll(Ctp_conta_pagarT ctp_conta_pagarT, int IdSuper, boolean acumulado) throws Exception {
        DataSet ds = new DataSet();
        try {
            ArrayList list = new ArrayList();
            list.add(ctp_conta_pagarT.getCtp_tx_status());
            list.add(ctp_conta_pagarT.getObr_nr_id());
            list.add(ctp_conta_pagarT.getCtp_nr_mes());
            list.add(ctp_conta_pagarT.getCtp_nr_ano());

            StringBuffer sql = new StringBuffer();
            if (!acumulado || ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                sql.append("select conta.ctp_nr_id, replace( conta.ctp_tx_fornecedor, '\r', '') as ctp_tx_fornecedor, conta.ctp_nr_mes , conta.plc_nr_id, conta.ctp_nr_valor, replace(ctp_nr_documento,").append("'").append(ASPAS).append("','''''')as ctp_nr_documento, conta.ctp_tx_status, conta.obr_nr_id, conta.ctp_nr_ano, classe.plc_tx_nome, obra.obr_tx_nome, classeSuper.plc_tx_nome as plc_tx_nome_super, conta.ctp_tx_obs, conta.ctp_dt_vencimento ,conta.ctp_dt_emissao, classe.plc_nr_id_super ");
                sql.append(", replace(replace(ctp_tx_obs,").append("'").append(ASPAS).append("',''''''),'\r','')as ctp_tx_obs from easyconstru.ctp_conta_pagar as conta inner join easyconstru.plc_plano_contas as classe on(classe.plc_nr_id = conta.plc_nr_id)");
                sql.append(" inner join easyconstru.obr_obras as obra on(obra.obr_nr_id = conta.obr_nr_id)");
                sql.append("inner join easyconstru.plc_plano_contas as classeSuper on(classeSuper.plc_nr_id = classe.plc_nr_id_super)");
                sql.append(" where conta.ctp_tx_status =? ");
                sql.append(" and conta.obr_nr_id =?");
                sql.append(" and conta.ctp_nr_mes = ?");
                sql.append(" and conta.ctp_nr_ano = ?");
            } else {
                sql.append("select conta.ctp_nr_id, replace( conta.ctp_tx_fornecedor, '\r', '') as ctp_tx_fornecedor, conta.ctp_nr_mes , conta.plc_nr_id, conta.ctp_nr_valor, replace(ctp_nr_documento,").append("'").append(ASPAS).append("','''''')as ctp_nr_documento, conta.ctp_tx_status, conta.obr_nr_id, conta.ctp_nr_ano, classe.plc_tx_nome, obra.obr_tx_nome, classeSuper.plc_tx_nome as plc_tx_nome_super, conta.ctp_tx_obs, conta.ctp_dt_vencimento ,conta.ctp_dt_emissao, classe.plc_nr_id_super ");
                sql.append(", replace(ctp_tx_obs,").append("'").append(ASPAS).append("','''''')as ctp_tx_obs from easyconstru.ctp_conta_pagar as conta inner join easyconstru.plc_plano_contas as classe on(classe.plc_nr_id = conta.plc_nr_id)");
                sql.append(" inner join easyconstru.obr_obras as obra on(obra.obr_nr_id = conta.obr_nr_id)");
                sql.append("inner join easyconstru.plc_plano_contas as classeSuper on(classeSuper.plc_nr_id = classe.plc_nr_id_super)");
                sql.append(" where conta.ctp_tx_status =? ");
                sql.append(" and conta.obr_nr_id =?");
                sql.append(" and ((conta.ctp_nr_mes <= ?");
                sql.append(" and conta.ctp_nr_ano = ?) or (conta.ctp_nr_ano  < ?))");
                list.add(ctp_conta_pagarT.getCtp_nr_ano());
            }

            if (IdSuper > 0) {
                sql.append(" and classe.plc_nr_id_super =?");
                list.add(IdSuper);
            }

            if (ctp_conta_pagarT.getPlc_nr_id() > 0) {
                sql.append(" and conta.plc_nr_id =?");
                list.add(ctp_conta_pagarT.getPlc_nr_id());
            }

            if (ctp_conta_pagarT.getCtp_tx_fornecedor() != null) {
                sql.append(" and conta.ctp_tx_fornecedor =?");
                list.add(ctp_conta_pagarT.getCtp_tx_fornecedor());
            }
            if (ctp_conta_pagarT.getCtp_nr_valor() != 0) {
                sql.append(" and conta.ctp_nr_valor =?");
                list.add(ctp_conta_pagarT.getCtp_nr_valor());
            }
            //sql.append(" order by ctp_nr_id");
            sql.append(" order by ctp_nr_valor desc");

            String s = sql.toString();

            Object[] param = list.toArray();
            ds = executeQuery(sql.toString(), param);

//            ctp_conta_pagarT.setCtp_tx_fornecedor(getValueSemAspas(rs.getString("ctp_tx_fornecedor")));
//            ctp_conta_pagarT.setCtp_nr_documento(getValueSemAspas(rs.getString("ctp_nr_documento")));
//            ctp_conta_pagarT.setCtp_tx_obs(getValueSemAspas(rs.getString("ctp_tx_obs")));
            corrigirCaracter(ds);
            return ds;

        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public void corrigirCaracter(DataSet ds) throws Exception{
        int contator = 0;
        try {
            if (ds != null) {
                
                for (int i = 0; i < ds.getList().size(); i++) {
                    RowDS row = ds.getList().get(i);
                    List<ItemDS> items = row.getRow();
                    for (int j = 0; j < items.size(); j++) {
                        ItemDS item = items.get(j);
                        contator++;
                        if(contator == 948){
                            int inicio = 0;
                        }
                        if (item.getName().equalsIgnoreCase("ctp_tx_fornecedor") || item.getName().equalsIgnoreCase("ctp_nr_documento") || item.getName().equalsIgnoreCase("ctp_tx_obs")) {
                            Object ob = item.getValue();
                            if(ob != null ){
                                if(item.getValue().toString().indexOf("CARTORIO 1")!= -1 ){
                                   String a ="a";
                                }
                              item.setValue(getValueSemAspas(item.getValue().toString()));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("contator "+contator);
            throw e;
        }

    }

    public List<Ctp_conta_pagarT> getAllMesAte(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar conta where obr_nr_id =? and  ctp_tx_status =? and ((ctp_nr_mes <? and ctp_nr_ano = ?)or (ctp_nr_ano < ?)) order by ctp_nr_id";
            ps = con.prepareStatement(sql);
            ps.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            ps.setObject(2, ctp_conta_pagarT.getCtp_tx_status());
            ps.setObject(3, ctp_conta_pagarT.getCtp_nr_mes());
            ps.setObject(4, ctp_conta_pagarT.getCtp_nr_ano());
            ps.setObject(5, ctp_conta_pagarT.getCtp_nr_ano());
            rs = ps.executeQuery();
            return resultSetToObjectTransfer(rs);

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public DataSet getAllAteMes(Ctp_conta_pagarT ctp_conta_pagarT, int IdSuper) throws Exception {
        DataSet ds = new DataSet();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select conta.ctp_nr_id, conta.ctp_tx_fornecedor, conta.ctp_nr_mes , conta.plc_nr_id, conta.ctp_nr_valor, conta.ctp_nr_documento, conta.ctp_tx_status, conta.obr_nr_id, conta.ctp_nr_ano, classe.plc_tx_nome, obra.obr_tx_nome, classeSuper.plc_tx_nome as plc_tx_nome_super, conta.ctp_tx_obs, conta.ctp_dt_vencimento ,conta.ctp_dt_emissao ");
            sql.append(" from easyconstru.ctp_conta_pagar as conta inner join easyconstru.plc_plano_contas as classe on(classe.plc_nr_id = conta.plc_nr_id)");
            sql.append(" inner join easyconstru.obr_obras as obra on(obra.obr_nr_id = conta.obr_nr_id)");
            sql.append("inner join easyconstru.plc_plano_contas as classeSuper on(classeSuper.plc_nr_id = classe.plc_nr_id_super)");

            sql.append(" where conta.ctp_tx_status =? ");
            sql.append(" and ((ctp_nr_mes <= ? and ctp_nr_ano = ?)or (ctp_nr_ano < ?))");
            ArrayList list = new ArrayList();
            list.add(ctp_conta_pagarT.getCtp_tx_status());

            if (ctp_conta_pagarT.getCtp_nr_mes() > 0) {
                list.add(ctp_conta_pagarT.getCtp_nr_mes());
                list.add(ctp_conta_pagarT.getCtp_nr_ano());
            }
            if (ctp_conta_pagarT.getCtp_nr_ano() > 0) {
                list.add(ctp_conta_pagarT.getCtp_nr_ano());
            }
            if (ctp_conta_pagarT.getObr_nr_id() > 0) {
                sql.append(" and conta.obr_nr_id =?");
                list.add(ctp_conta_pagarT.getObr_nr_id());
            }
            sql.append(" order by ctp_nr_id");
            String s = sql.toString();
            //System.out.println(s);

            Object[] param = list.toArray();
            ds = executeQuery(sql.toString(), param);

            corrigirCaracter(ds);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    public List<Ctp_conta_pagarT> getByPK(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  ctp_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  ctp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_mes(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  ctp_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_mes());
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

    public List<Ctp_conta_pagarT> getByPlc_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getPlc_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_valor(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  ctp_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getCtp_nr_valor());
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

    public List<Ctp_conta_pagarT> getByCtp_nr_documento(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  Upper(ctp_nr_documento) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_nr_documento() + '%');
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

    public List<Ctp_conta_pagarT> getByCtp_nr_documentoObra(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  Upper(ctp_nr_documento) like Upper(?) and obr_nr_id =?  and ctp_tx_status =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_nr_documento() + '%');
            pStmt.setObject(2, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_tx_status());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_obs(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  Upper(ctp_tx_obs) like Upper(?) and obr_nr_id =? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_obs() + '%');
            pStmt.setObject(2, ctp_conta_pagarT.getObr_nr_id());
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

    public List<Ctp_conta_pagarT> getByCtp_tx_status(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  Upper(ctp_tx_status) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + ctp_conta_pagarT.getCtp_tx_status() + '%');
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

    public List<Ctp_conta_pagarT> getByObr_nr_id(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
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

    public TreeMap<String, Ctp_conta_pagarT> getByObr_nr_idTree(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  obr_nr_id = ? and ctp_tx_status=? order by ctp_nr_ano, ctp_nr_mes";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_tx_status());
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

    public TreeMap<String, Ctp_conta_pagarT> getByObr_nr_idMesAnoTree(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  obr_nr_id = ? and ctp_tx_status=? and ctp_nr_mes =? and ctp_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_tx_status());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_nr_ano());
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

    public TreeMap<String, Ctp_conta_pagarT> getByObr_nr_idTreeEngeb(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {

            String sql = "select * from easyconstru.ctp_conta_pagar where  obr_nr_id = ? and ctp_tx_status=? ";//and ctp_tx_obs is not null";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_tx_status());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferTreeEngeb(rs);
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

    private TreeMap<String, Ctp_conta_pagarT> resultSetToObjectTransferTreeEngeb(ResultSet rs) throws Exception {
        int cont = 0;
        try {
            TreeMap<String, Ctp_conta_pagarT> objs = new TreeMap<String, Ctp_conta_pagarT>();
            while (rs.next()) {
                cont++;
                Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                ctp_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
                ctp_conta_pagarT.setCtp_tx_fornecedor(rs.getString("ctp_tx_fornecedor"));
                ctp_conta_pagarT.setCtp_nr_mes(rs.getInt("ctp_nr_mes"));
                ctp_conta_pagarT.setPlc_nr_id(rs.getInt("plc_nr_id"));
                ctp_conta_pagarT.setCtp_nr_valor(rs.getFloat("ctp_nr_valor"));
                ctp_conta_pagarT.setCtp_nr_documento(rs.getString("ctp_nr_documento"));
                ctp_conta_pagarT.setCtp_tx_status(rs.getString("ctp_tx_status"));
                ctp_conta_pagarT.setObr_nr_id(rs.getInt("obr_nr_id"));

                String obs = rs.getString("ctp_tx_obs");
                if (!obs.isEmpty()) {
                    obs = getValueSemAspas(obs);
                }

                ctp_conta_pagarT.setCtp_tx_obs(obs);
                ctp_conta_pagarT.setCtp_dt_vencimento(rs.getDate("ctp_dt_vencimento"));
                ctp_conta_pagarT.setCtp_dt_emissao(rs.getDate("ctp_dt_emissao"));
                String key = ctp_conta_pagarT.getCtp_tx_obs();
                objs.put(key, ctp_conta_pagarT);
            }
            return objs;
        } catch (Exception e) {
            System.out.println("cont " + cont);
            throw e;
        }

    }

    private TreeMap<String, Ctp_conta_pagarT> resultSetToObjectTransferTree(ResultSet rs) throws Exception {
        TreeMap<String, Ctp_conta_pagarT> objs = new TreeMap<String, Ctp_conta_pagarT>();
        int i = 1;
        while (rs.next()) {
            Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
            ctp_conta_pagarT.setCtp_nr_id(rs.getInt("ctp_nr_id"));
            ctp_conta_pagarT.setCtp_tx_fornecedor(rs.getString("ctp_tx_fornecedor"));
            ctp_conta_pagarT.setCtp_nr_mes(rs.getInt("ctp_nr_mes"));
            ctp_conta_pagarT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            ctp_conta_pagarT.setCtp_nr_valor(rs.getFloat("ctp_nr_valor"));
            ctp_conta_pagarT.setCtp_nr_documento(rs.getString("ctp_nr_documento"));
            ctp_conta_pagarT.setCtp_tx_status(rs.getString("ctp_tx_status"));
            ctp_conta_pagarT.setObr_nr_id(rs.getInt("obr_nr_id"));
            ctp_conta_pagarT.setCtp_tx_obs(rs.getString("ctp_tx_obs"));
            ctp_conta_pagarT.setCtp_dt_vencimento(rs.getDate("ctp_dt_vencimento"));
            ctp_conta_pagarT.setCtp_dt_emissao(rs.getDate("ctp_dt_emissao"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
            i++;
            objs.put(key, ctp_conta_pagarT);

        }
        return objs;
    }

    public List<Ctp_conta_pagarT> getBySemVinculoZeroPlc(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            int sequencia = 1;
            StringBuffer sql = new StringBuffer();
            sql.append("select * from easyconstru.ctp_conta_pagar where  obr_nr_id = ? and plc_nr_id = 0 ");
            if (ctp_conta_pagarT.getCtp_nr_mes() > 0) {
                sql.append(" and ctp_nr_mes =?");
            }
            if (ctp_conta_pagarT.getCtp_nr_ano() > 0) {
                sql.append(" and ctp_nr_ano =?");
            }
            if (ctp_conta_pagarT.getCtp_tx_status() != null) {
                sql.append(" and ctp_tx_status =?");
            }

            sql.append(" order by ctp_nr_id");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            if (ctp_conta_pagarT.getCtp_nr_mes() > 0) {
                sequencia++;
                pStmt.setObject(sequencia, ctp_conta_pagarT.getCtp_nr_mes());
            }
            if (ctp_conta_pagarT.getCtp_nr_ano() > 0) {
                sequencia++;
                pStmt.setObject(sequencia, ctp_conta_pagarT.getCtp_nr_ano());
            }
            if (ctp_conta_pagarT.getCtp_tx_status() != null) {
                sequencia++;
                pStmt.setObject(sequencia, ctp_conta_pagarT.getCtp_tx_status());
            }
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

    public TreeMap<String, Ctp_ValorMesesSubClasseT> getValorMesesSubClasse(int obr_nr_id, String status, int mes, int ano) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("select obr_nr_id,plc_nr_id, ctp_nr_mes,ctp_nr_ano,sum(ctp_nr_valor)as valor from easyconstru.ctp_conta_pagar");
        sql.append(" where obr_nr_id = ? and ctp_tx_status=?");
        sql.append(" and ((ctp_nr_mes <= ? and ctp_nr_ano = ?) or (ctp_nr_ano < ?))");
        sql.append(" group by obr_nr_id,plc_nr_id, ctp_nr_mes,ctp_nr_ano");
        sql.append(" order by plc_nr_id,ctp_nr_mes,ctp_nr_ano");
        PreparedStatement ps = con.prepareStatement(sql.toString());
        ps.setObject(1, obr_nr_id);
        ps.setObject(2, status);
        ps.setObject(3, mes);
        ps.setObject(4, ano);
        ps.setObject(5, ano);
        ResultSet rs = ps.executeQuery();
        TreeMap<String, Ctp_ValorMesesSubClasseT> tree = new TreeMap<String, Ctp_ValorMesesSubClasseT>();
        while (rs.next()) {
            Ctp_ValorMesesSubClasseT mesesSubClasseT = new Ctp_ValorMesesSubClasseT();
            mesesSubClasseT.setObr_nr_id(rs.getInt("obr_nr_id"));
            mesesSubClasseT.setPlc_nr_id(rs.getInt("Plc_nr_id"));
            mesesSubClasseT.setMes(rs.getInt("ctp_nr_mes"));
            mesesSubClasseT.setAno(rs.getInt("ctp_nr_ano"));
            mesesSubClasseT.setValor(rs.getFloat("valor"));
            String key = mesesSubClasseT.getPlc_nr_id() + "." + mesesSubClasseT.getMes() + "." + mesesSubClasseT.getAno();
            tree.put(key, mesesSubClasseT);
        }
        return tree;
    }

    public TreeMap<String, Ctp_ValorMesesSubClasseT> getValorMesesSubClasseAll(int obr_nr_id) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("select obr_nr_id,plc_nr_id, ctp_nr_mes,ctp_nr_ano,sum(ctp_nr_valor)as valor from easyconstru.ctp_conta_pagar");
        sql.append(" where obr_nr_id = ? and ctp_tx_status=?");
        sql.append(" group by obr_nr_id,plc_nr_id, ctp_nr_mes,ctp_nr_ano");
        sql.append(" order by plc_nr_id,ctp_nr_mes,ctp_nr_ano");
        PreparedStatement ps = con.prepareStatement(sql.toString());
        ps.setObject(1, obr_nr_id);
        ps.setObject(2, "P");
        ResultSet rs = ps.executeQuery();
        TreeMap<String, Ctp_ValorMesesSubClasseT> tree = new TreeMap<String, Ctp_ValorMesesSubClasseT>();
        while (rs.next()) {
            Ctp_ValorMesesSubClasseT mesesSubClasseT = new Ctp_ValorMesesSubClasseT();
            mesesSubClasseT.setObr_nr_id(rs.getInt("obr_nr_id"));
            mesesSubClasseT.setPlc_nr_id(rs.getInt("Plc_nr_id"));
            mesesSubClasseT.setMes(rs.getInt("ctp_nr_mes"));
            mesesSubClasseT.setAno(rs.getInt("ctp_nr_ano"));
            mesesSubClasseT.setValor(rs.getFloat("valor"));
            String key = mesesSubClasseT.getPlc_nr_id() + "." + mesesSubClasseT.getMes() + "." + mesesSubClasseT.getAno();
            tree.put(key, mesesSubClasseT);
        }
        return tree;
    }

    public DataSet getValorSubClasse(int obr_nr_id, int plc_nr_id, String status, int mes, int ano, boolean acumulado) throws SQLException, Exception {
        DataSet ds = null;
        int tamanho = 4;
        try {
            ArrayList list = new ArrayList();
            list.add(obr_nr_id);
            list.add(status);
            list.add(mes);
            list.add(ano);

            StringBuffer sql = new StringBuffer();
            if (!acumulado || status.equalsIgnoreCase("A")) {
                sql.append("select ctp.plc_nr_id, conta.plc_tx_nome, sum(ctp.ctp_nr_valor)as valor from easyconstru.ctp_conta_pagar ctp");
                sql.append(" inner join easyconstru.plc_plano_contas as conta on(conta.plc_nr_id = ctp.plc_nr_id)");
                sql.append(" where obr_nr_id = ? and ctp_tx_status=?");
                sql.append(" and ctp_nr_mes = ? and ctp_nr_ano = ? ");
            } else {
                sql.append("select ctp.plc_nr_id, conta.plc_tx_nome, sum(ctp.ctp_nr_valor)as valor from easyconstru.ctp_conta_pagar ctp");
                sql.append(" inner join easyconstru.plc_plano_contas as conta on(conta.plc_nr_id = ctp.plc_nr_id)");
                sql.append(" where obr_nr_id = ? and ctp_tx_status=?");
                sql.append(" and ((ctp_nr_mes <= ? and ctp_nr_ano = ?)  or (ctp_nr_ano < ?))");
                list.add(ano);
            }

            if (plc_nr_id > 0) {
                sql.append(" and conta.plc_nr_id_super =?");
                list.add(plc_nr_id);
            }
            sql.append(" group by ctp.plc_nr_id, conta.plc_tx_nome");

            ds = executeQuery(sql.toString(), list.toArray());
            corrigirCaracter(ds);
            return ds;
        } catch (Exception e) {
            throw e;
        }
        //return null;
    }

    public DataSet getAllContas(int obr_nr_id, int mes, int ano, boolean acumulado, String status) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            ArrayList list = new ArrayList();
            list.add(obr_nr_id);
            list.add(mes);
            list.add(ano);
            if (!acumulado || status.equalsIgnoreCase("A")) {
                sql.append("select ctp.plc_nr_id, plc.plc_tx_nome, sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
                sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
                sql.append(" where ctp.obr_nr_id =? and ctp.ctp_nr_mes =? and ctp.ctp_nr_ano =? and ctp.ctp_tx_status = ?");
            } else {
                sql.append("select ctp.plc_nr_id, plc.plc_tx_nome, sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
                sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
                sql.append(" where ctp.obr_nr_id =? and ((ctp.ctp_nr_mes <=? and ctp.ctp_nr_ano = ?) or(ctp.ctp_nr_ano <?))  and ctp.ctp_tx_status =?");
                list.add(ano);
            }
            list.add(status);
            sql.append(" group by ctp.plc_nr_id, plc.plc_tx_nome");

            ds = executeQuery(sql.toString(), list.toArray());
            corrigirCaracter(ds);
            return ds;
        } catch (Exception e) {
            throw e;
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
            sql.append("select sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
            sql.append(" where ctp.obr_nr_id =? and ctp_nr_mes =? and ctp_nr_ano = ?  and plc.plc_nr_id_super in" + getIdClasses(id_classes));
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

    public double getCustoRealizadoNoPeriodoPagas(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();

            sql.append("select sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
            sql.append(" where ctp.obr_nr_id =? and (ctp_nr_mes =? and ctp_nr_ano = ?) ");
            sql.append(" and ctp.ctp_tx_status =?");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(4, "P");
            rs = pStmt.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }
            if (rs.next()) {
                valor += rs.getDouble("valor");
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

    public double getCustoRealizadoAcumuladoPagas(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();

            sql.append("select sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
            sql.append(" where ctp.obr_nr_id =? and ((ctp_nr_mes <=? and ctp_nr_ano = ?) or ctp_nr_ano <?) ");
            sql.append(" and ctp.ctp_tx_status =?");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(5, "P");
            rs = pStmt.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }
            if (rs.next()) {
                valor += rs.getDouble("valor");
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

    public double getCustoRealizadoAcumulado(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();

            sql.append("select sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
            sql.append(" where ctp.obr_nr_id =? and ((ctp_nr_mes <=? and ctp_nr_ano = ?) or ctp_nr_ano <?) and plc.plc_nr_id_super in" + getIdClasses(id_classes));
            sql.append(" and ctp.ctp_tx_status =?");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, ano);
            pStmt.setObject(5, "P");
            rs = pStmt.executeQuery();
            if (rs.next()) {
                valor = rs.getDouble("valor");
            }
            sql = new StringBuffer();

            sql.append("select sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = ctp.plc_nr_id)");
            sql.append(" inner join easyconstru.plc_plano_contas as super on(plc.plc_nr_id_super = super.plc_nr_id)");
            sql.append(" where ctp.obr_nr_id =? and ctp_nr_mes =? and ctp_nr_ano = ? and plc.plc_nr_id_super in" + getIdClasses(id_classes));
            sql.append("and ctp.ctp_tx_status =?");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, "A");
            rs = pStmt.executeQuery();
            if (rs.next()) {
                valor += rs.getDouble("valor");
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

    public void deleteObraMesAno(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.ctp_conta_pagar where  obr_nr_id=? and ctp_nr_mes=? and ctp_nr_ano=? and ctp_tx_status=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_status());

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

    public void getObraMesAno(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "select * from easyconstru.ctp_conta_pagar where  obr_nr_id=? and ctp_nr_mes=? and ctp_nr_ano=? and ctp_tx_status=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_status());
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

    public void updateObraMesAno(Ctp_conta_pagarT ctp_conta_pagarTOrig, Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.ctp_conta_pagar set obr_nr_id=?, ctp_nr_mes=?,  ctp_nr_ano=?, ctp_tx_status=?  where  obr_nr_id=? and ctp_nr_mes=? and ctp_nr_ano=? and ctp_tx_status=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, ctp_conta_pagarT.getObr_nr_id());
            pStmt.setObject(2, ctp_conta_pagarT.getCtp_nr_mes());
            pStmt.setObject(3, ctp_conta_pagarT.getCtp_nr_ano());
            pStmt.setObject(4, ctp_conta_pagarT.getCtp_tx_status());

            pStmt.setObject(5, ctp_conta_pagarTOrig.getObr_nr_id());
            pStmt.setObject(6, ctp_conta_pagarTOrig.getCtp_nr_mes());
            pStmt.setObject(7, ctp_conta_pagarTOrig.getCtp_nr_ano());
            pStmt.setObject(8, ctp_conta_pagarTOrig.getCtp_tx_status());

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

    /**
     * @return the arquivo_engeb
     */
    public boolean isArquivo_engeb() {
        return arquivo_engeb;
    }

    /**
     * @param arquivo_engeb the arquivo_engeb to set
     */
    public void setArquivo_engeb(boolean arquivo_engeb) {
        this.arquivo_engeb = arquivo_engeb;
    }
    
    
     public TreeMap<Integer, Double> getCustoRealizadoAcumuladoAgrupadoSubClasseBI(int obr_nr_id, int mes, int ano, String status) throws Exception {
/* 1095 */     PreparedStatement pStmt = null;
/* 1096 */     ResultSet rs = null;
/*      */     try {
/* 1098 */       double valor = 0.0D;
/* 1099 */       StringBuffer sql = new StringBuffer();
/*      */       
/* 1101 */       sql.append("select plc_nr_id, sum(ctp.ctp_nr_valor) as valor from easyconstru.ctp_conta_pagar as ctp");
/*      */       
/* 1103 */       sql.append(" where ctp.obr_nr_id =? and ((ctp_nr_mes <=? and ctp_nr_ano = ?) or ctp_nr_ano <?) ");
/* 1104 */       sql.append(" and ctp.ctp_tx_status =? group by plc_nr_id");
/*      */       
/* 1106 */       pStmt = this.con.prepareStatement(sql.toString());
/* 1107 */       pStmt.setObject(1, Integer.valueOf(obr_nr_id));
/* 1108 */       pStmt.setObject(2, Integer.valueOf(mes));
/* 1109 */       pStmt.setObject(3, Integer.valueOf(ano));
/* 1110 */       pStmt.setObject(4, Integer.valueOf(ano));
/* 1111 */       pStmt.setObject(5, status);
/* 1112 */       rs = pStmt.executeQuery();
/*      */       
/* 1114 */       return resultSetToObjectTransferTreeBI(rs);
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1118 */       throw e;
/*      */     } finally {
/*      */       try {
/* 1121 */         pStmt.close();
/* 1122 */         rs.close();
/*      */       }
/*      */       catch (Exception localException2) {}
/*      */     }
/*      */   }
    
    private TreeMap<Integer, Double> resultSetToObjectTransferTreeBI(ResultSet rs) throws Exception {
/*  773 */     TreeMap<Integer, Double> objs = new TreeMap();
/*  774 */     int i = 1;
/*  775 */     while (rs.next()) {
/*  776 */       objs.put(Integer.valueOf(rs.getInt("plc_nr_id")), Double.valueOf(rs.getDouble("valor")));
/*      */     }
/*  778 */     return objs;
/*      */   }
/*      */   

}
