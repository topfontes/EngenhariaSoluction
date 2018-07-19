package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;

public class Com_comprometimentoDAO extends ObjectDAO {

    public Com_comprometimentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.com_comprometimento ( plc_nr_id, com_nr_valor, obr_nr_id, com_nr_mes, com_nr_ano, com_dt_base, previsto) values ( ?, ? , ? , ? , ? , ? ,?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getPlc_nr_id());
            pStmt.setObject(2, com_comprometimentoT.getCom_nr_valor());
            pStmt.setObject(3, com_comprometimentoT.getObr_nr_id());
            pStmt.setObject(4, com_comprometimentoT.getCom_nr_mes());
            pStmt.setObject(5, com_comprometimentoT.getCom_nr_ano());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String data = "01/" + com_comprometimentoT.getCom_nr_mes() + "/" + com_comprometimentoT.getCom_nr_ano();
            com_comprometimentoT.setCom_dt_base(dateFormat.parse(data));
            java.sql.Date dt = new java.sql.Date(com_comprometimentoT.getCom_dt_base().getTime());
            pStmt.setObject(6, dt);
            pStmt.setObject(7, com_comprometimentoT.isPrevisto());

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

    public void update(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.com_comprometimento set  plc_nr_id=?, com_nr_valor=?, obr_nr_id=?, com_nr_mes=?, com_nr_ano=?, com_dt_base=?, previsto=?  where  com_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getPlc_nr_id());
            pStmt.setObject(2, com_comprometimentoT.getCom_nr_valor());
            pStmt.setObject(3, com_comprometimentoT.getObr_nr_id());
            pStmt.setObject(4, com_comprometimentoT.getCom_nr_mes());
            pStmt.setObject(5, com_comprometimentoT.getCom_nr_ano());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String data = "01/" + com_comprometimentoT.getCom_nr_mes() + "/" + com_comprometimentoT.getCom_nr_ano();
            com_comprometimentoT.setCom_dt_base(dateFormat.parse(data));
            java.sql.Date dt = new java.sql.Date(com_comprometimentoT.getCom_dt_base().getTime());
            pStmt.setObject(6, dt);
            pStmt.setObject(7, com_comprometimentoT.isPrevisto());
            pStmt.setObject(8, com_comprometimentoT.getCom_nr_id());
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

    public void delete(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.com_comprometimento where  com_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_id());
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

    private List<Com_comprometimentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Com_comprometimentoT> objs = new Vector();
        while (rs.next()) {
            Com_comprometimentoT com_comprometimentoT = new Com_comprometimentoT();
            com_comprometimentoT.setCom_nr_id(rs.getInt("com_nr_id"));
            com_comprometimentoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            com_comprometimentoT.setCom_nr_valor(rs.getDouble("com_nr_valor"));
            com_comprometimentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            com_comprometimentoT.setCom_nr_mes(rs.getInt("com_nr_mes"));
            com_comprometimentoT.setCom_nr_ano(rs.getInt("com_nr_ano"));
            objs.add(com_comprometimentoT);
        }
        return objs;
    }

    public List<Com_comprometimentoT> getAll(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where previsto=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.isPrevisto());
            rs = pStmt.executeQuery();
            List<Com_comprometimentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Com_comprometimentoT> getByPK(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  com_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_id());
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

    public List<Com_comprometimentoT> getByCom_nr_id(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  com_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_id());
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

    public List<Com_comprometimentoT> getByPlc_nr_id(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getPlc_nr_id());
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

    public List<Com_comprometimentoT> getByCom_nr_valor(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  com_nr_valor = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_valor());
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

    public List<Com_comprometimentoT> getByObr_nr_id(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getObr_nr_id());
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

    public List<Com_comprometimentoT> getByCom_nr_mes(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  com_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_mes());
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

    public List<Com_comprometimentoT> getByCom_nr_ano(Com_comprometimentoT com_comprometimentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.com_comprometimento where  com_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, com_comprometimentoT.getCom_nr_ano());
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

    public DataSet CompSubClasseMes(int obr_nr_id, int mes, int ano, boolean previsto) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select comp.plc_nr_id, conta.plc_tx_nome, sum(comp.com_nr_valor)as valor from easyconstru.com_comprometimento comp");
            sql.append(" inner join easyconstru.plc_plano_contas conta on(conta.plc_nr_id = comp.plc_nr_id)");
            sql.append(" where comp.obr_nr_id = ? and comp.com_nr_mes=? and comp.com_nr_ano =?");
            sql.append(" and comp.previsto=?");
            sql.append(" group by 1,2");
            Object[] param = new Object[4];
            param[0] = obr_nr_id;
            param[1] = mes;
            param[2] = ano;
            param[3] = previsto;

            ds = executeQuery(sql.toString(), param);
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
            }else{
                cls += classes[i];
            }
        }
        cls ="("+cls+")";
        return cls;
    }

    public double getValorClassePeriodo(int obr_nr_id, int mes, int ano, int[] classes, boolean previsto) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select sum(comp.com_nr_valor)as valor from easyconstru.com_comprometimento comp");
            sql.append(" inner join easyconstru.plc_plano_contas conta on(conta.plc_nr_id = comp.plc_nr_id)");
            sql.append(" where comp.obr_nr_id = ? and comp.com_nr_mes=? and comp.com_nr_ano =? and conta.plc_nr_id_super in"+getIdClasses(classes));
            sql.append(" and comp.previsto=?");
            pStmt = con.prepareStatement(sql.toString());

            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, previsto);
            rs = pStmt.executeQuery();
            double valor = 0;
            if (rs.next()) {
                valor = rs.getDouble("valor");
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

    public double getValorClasseAcumulado(int obr_nr_id, int mes, int ano, int[] classes, boolean previsto) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select sum(comp.com_nr_valor)as valor from easyconstru.com_comprometimento comp");
            sql.append(" inner join easyconstru.plc_plano_contas conta on(conta.plc_nr_id = comp.plc_nr_id)");
            sql.append(" where comp.obr_nr_id =? and (comp.com_nr_mes <=? and comp.com_nr_ano =? or comp.com_nr_ano <? ) and conta.plc_nr_id_super in"+getIdClasses(classes));
            sql.append(" and comp.previsto=?");

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, ano);
            pStmt.setObject(5, previsto);
            rs = pStmt.executeQuery();
            double valor = 0;
            if (rs.next()) {
                valor = rs.getDouble("valor");
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
    public java.util.TreeMap<Integer, Double> getValorSubClasseAcumuladoBI(int obr_nr_id, int mes, int ano) throws Exception {
/* 377 */     PreparedStatement pStmt = null;
/* 378 */     ResultSet rs = null;
/*     */     try {
/* 380 */       StringBuffer sql = new StringBuffer();
/* 381 */       sql.append("select plc_nr_id,  sum(com_nr_valor)as valor from easyconstru.com_comprometimento");
/* 382 */       sql.append(" where obr_nr_id =? and ((com_nr_mes <=? and com_nr_ano =?) or com_nr_ano <?)");
/* 383 */       sql.append(" group by plc_nr_id");
/*     */       
/* 385 */       pStmt = this.con.prepareStatement(sql.toString());
/* 386 */       pStmt.setObject(1, Integer.valueOf(obr_nr_id));
/* 387 */       pStmt.setObject(2, Integer.valueOf(mes));
/* 388 */       pStmt.setObject(3, Integer.valueOf(ano));
/* 389 */       pStmt.setObject(4, Integer.valueOf(ano));
/* 390 */       rs = pStmt.executeQuery();
/* 391 */       java.util.TreeMap<Integer, Double> obj = new java.util.TreeMap();
/* 392 */       while (rs.next()) {
/* 393 */         obj.put(Integer.valueOf(rs.getInt("plc_nr_id")), Double.valueOf(rs.getDouble("valor")));
/*     */       }
/* 395 */       return obj;
/*     */     } catch (Exception e) {
/* 397 */       throw e;
/*     */     } finally {
/*     */       try {
/* 400 */         rs.close();
/* 401 */         pStmt.close();
/*     */       }
/*     */       catch (Exception localException2) {}
/*     */     }
/*     */   }
/*     */ 
}
