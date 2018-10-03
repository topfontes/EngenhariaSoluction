package br.com.easynet.gwt.easyportal.dao;

import br.com.easynet.annotation.Conversion;
import java.text.ParseException;
import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class Fat_fatorDAO extends ObjectDAO {

    public Fat_fatorDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }
    private TreeMap<Integer, Vw_insumo_plc_pmsT> treeVlAcumulado = new TreeMap<Integer, Vw_insumo_plc_pmsT>();
    private TreeMap<Integer, Fat_fatorT> treeFatorProj = new TreeMap<Integer, Fat_fatorT>();

    public void insert(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.fat_fator  ( plc_nr_id, fat_nr_fator_atual, fat_nr_fator_projetado, fat_nr_mes, fat_nr_ano, obr_nr_id) values ( ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getPlc_nr_id());
            pStmt.setObject(2, fat_fatorT.getFat_nr_fator_atual());
            pStmt.setObject(3, fat_fatorT.getFat_nr_fator_projetado());
            pStmt.setObject(4, fat_fatorT.getFat_nr_mes());
            pStmt.setObject(5, fat_fatorT.getFat_nr_ano());
            pStmt.setObject(6, fat_fatorT.getObr_nr_id());
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

    public void update(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.fat_fator set  plc_nr_id=?, fat_nr_fator_atual=?, fat_nr_fator_projetado=?, fat_nr_mes=?, fat_nr_ano=?, obr_nr_id=?  where  fat_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getPlc_nr_id());
            pStmt.setObject(2, fat_fatorT.getFat_nr_fator_atual());
            pStmt.setObject(3, fat_fatorT.getFat_nr_fator_projetado());
            pStmt.setObject(4, fat_fatorT.getFat_nr_mes());
            pStmt.setObject(5, fat_fatorT.getFat_nr_ano());
            pStmt.setObject(6, fat_fatorT.getObr_nr_id());
            pStmt.setObject(7, fat_fatorT.getFat_nr_id());
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

    public void delete(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.fat_fator where  fat_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_id());
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

    private List<Fat_fatorT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Fat_fatorT> objs = new Vector();
        while (rs.next()) {
            Fat_fatorT fat_fatorT = new Fat_fatorT();
            fat_fatorT.setFat_nr_id(rs.getInt("fat_nr_id"));
            fat_fatorT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            fat_fatorT.setFat_nr_fator_atual(rs.getFloat("fat_nr_fator_atual"));
            fat_fatorT.setFat_nr_fator_projetado(rs.getFloat("fat_nr_fator_projetado"));
            fat_fatorT.setFat_nr_mes(rs.getInt("fat_nr_mes"));
            fat_fatorT.setFat_nr_ano(rs.getInt("fat_nr_ano"));
            fat_fatorT.setObr_nr_id(rs.getInt("obr_nr_id"));
            objs.add(fat_fatorT);
        }
        return objs;
    }

    private void addResultSetToObjectTransferTree(ResultSet rs) throws Exception {
        while (rs.next()) {
            Fat_fatorT fat_fatorT = new Fat_fatorT();
            fat_fatorT.setFat_nr_id(rs.getInt("fat_nr_id"));
            fat_fatorT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            fat_fatorT.setFat_nr_fator_atual(rs.getFloat("fat_nr_fator_atual"));
            fat_fatorT.setFat_nr_fator_projetado(rs.getFloat("fat_nr_fator_projetado"));
            fat_fatorT.setFat_nr_mes(rs.getInt("fat_nr_mes"));
            fat_fatorT.setFat_nr_ano(rs.getInt("fat_nr_ano"));
            fat_fatorT.setObr_nr_id(rs.getInt("obr_nr_id"));
            treeFatorProj.put(fat_fatorT.getPlc_nr_id(), fat_fatorT);
        }

    }

    public List<Fat_fatorT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Fat_fatorT> list = resultSetToObjectTransfer(rs);
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

    public List<Fat_fatorT> getByPK(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_id());
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

    public List<Fat_fatorT> getByFat_nr_id(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_id());
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

    public List<Fat_fatorT> getByPlc_nr_id(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getPlc_nr_id());
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

    public Fat_fatorT FatorExiste(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where obr_nr_id=? and plc_nr_id = ? and fat_nr_mes=? and fat_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getObr_nr_id());
            pStmt.setObject(2, fat_fatorT.getPlc_nr_id());
            pStmt.setObject(3, fat_fatorT.getFat_nr_mes());
            pStmt.setObject(4, fat_fatorT.getFat_nr_ano());
            rs = pStmt.executeQuery();
            List<Fat_fatorT> list = resultSetToObjectTransfer(rs);
            return list != null ? list.get(0) : null;
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

    public List<Fat_fatorT> getByFat_nr_fator_atual(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_fator_atual = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_fator_atual());
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

    public List<Fat_fatorT> getByFat_nr_fator_projetado(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_fator_projetado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_fator_projetado());
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

    public List<Fat_fatorT> getByFat_nr_mes(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_mes());
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

    public List<Fat_fatorT> getByFat_nr_ano(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  fat_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getFat_nr_ano());
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

    public List<Fat_fatorT> getByObr_nr_id(Fat_fatorT fat_fatorT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fat_fatorT.getObr_nr_id());
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

    public TreeMap<Integer, Valores_calculo_fatorT> getTreefator(int obr_nr_id, int mes, int ano) throws Exception {
        TreeMap<Integer, Valores_calculo_fatorT> tree = new TreeMap<Integer, Valores_calculo_fatorT>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //add no treeMap os fatores salvos.
            povoaFator_Projetado(obr_nr_id, mes, ano);
            povoaPrevistoAcumulado(obr_nr_id, mes, ano);
            StringBuffer sql = new StringBuffer();
            sql.append("select plc.plc_nr_id, plc.plc_tx_nome, ");
            //select contas pagas
            sql.append(" (select sum(ctp.ctp_nr_valor) from easyconstru.ctp_conta_pagar as ctp where ctp.plc_nr_id = plc.plc_nr_id and ctp.obr_nr_id = ? and ctp.ctp_tx_status ='P'");
            sql.append(" and ((ctp.ctp_nr_mes <= ? and ctp.ctp_nr_ano = ?) or (ctp.ctp_nr_ano < ?)))as vl_pago_acumulado,");
            //select contas a pagar geral
            sql.append(" (select sum(ctp.ctp_nr_valor) from easyconstru.ctp_conta_pagar as ctp where ctp.plc_nr_id = plc.plc_nr_id and ctp.obr_nr_id = ? and ctp.ctp_tx_status ='A' and ctp.ctp_nr_mes=? and ctp.ctp_nr_ano=?)as vl_apagar_geral,");
            //select comprometimento no periodo
            sql.append(" (select sum(comp.com_nr_valor)from easyconstru.com_comprometimento as comp where comp.plc_nr_id = plc.plc_nr_id and comp.obr_nr_id = ?");
            sql.append(" and comp.com_nr_mes = ? and comp.com_nr_ano = ?) as valor_comp_periodo,");
            //select estoque no periodo
            sql.append(" (select sum(estoque.est_nr_vl_total) from easyconstru.est_estoque as estoque where estoque.plc_nr_id = plc.plc_nr_id and estoque.obr_nr_id = ?");
            sql.append(" and estoque.est_nr_mes = ? and estoque.est_nr_ano = ?)as valor_estoque_periodo");
            sql.append(" from easyconstru.plc_plano_contas as plc ");
            sql.append(" where plc.plc_nr_id_super > 0");
            Object[] param = new Object[13];
            //System.out.println(sql.toString());
            ps = con.prepareStatement(sql.toString());
            //contas pagas acumulada até o periodo
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, mes);
            ps.setObject(3, ano);
            ps.setObject(4, ano);
            // contas a pagar geral
            ps.setObject(5, obr_nr_id);
            ps.setObject(6, mes);
            ps.setObject(7, ano);

            //comprometimento no periodo
            ps.setObject(8, obr_nr_id);
            ps.setObject(9, mes);
            ps.setObject(10, ano);
            //estoque no periodo
            ps.setObject(11, obr_nr_id);
            ps.setObject(12, mes);
            ps.setObject(13, ano);
            rs = ps.executeQuery();
            while (rs.next()) {
                Valores_calculo_fatorT vt = new Valores_calculo_fatorT();
                vt.setPlc_nr_id(rs.getInt("plc_nr_id"));
                vt.setPlc_tx_nome(rs.getString("plc_tx_nome"));
                vt.setValor_pago_acumulado(rs.getFloat("vl_pago_acumulado"));
                vt.setValor_apagar_geral(rs.getFloat("vl_apagar_geral"));
                vt.setValor_comp_periodo(rs.getFloat("valor_comp_periodo"));
                vt.setValor_comp_mes_anterior(getValorComp_MesAnt(obr_nr_id, vt.getPlc_nr_id(), mes, ano));
                vt.setValor_est_periodo(rs.getFloat("valor_estoque_periodo"));
                vt.setValor_est_mes_anterior(getValorEstoque_MesAnt(obr_nr_id, vt.getPlc_nr_id(), mes, ano));
               if(vt.getPlc_nr_id() == 77){
                   int a = 7;
               }
                float valor_previsto = getValorPrevisto(vt.getPlc_nr_id());
                float fator = 0;
                if (valor_previsto > 0) {//-0,02386929
                    double novovalor = ((27203.77 + 4712.4) + (0 - (35999.37 + 314.5)));
                    double e = novovalor /  157889.05;
                    fator = (vt.getValor_pago_acumulado() + vt.getValor_apagar_geral() + vt.getValor_comp_periodo() - vt.getValor_est_periodo() + vt.getValor_est_mes_anterior()) / valor_previsto;
                }
                vt.setFator_Atual(fator);

                float projetado = getfatorProjetado(vt.getPlc_nr_id());
                if (projetado == 0) {
                    projetado = fator;
                }
                vt.setFator_projetado(projetado);
                tree.put(vt.getPlc_nr_id(), vt);
            }
            return tree;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            close();
        }

    }

    public void povoaFator_Projetado(int obr_nr_id, int mes, int ano) {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fat_fator where  obr_nr_id = ? and fat_nr_mes=? and fat_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            rs = pStmt.executeQuery();
            addResultSetToObjectTransferTree(rs);
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                pStmt.close();
            } catch (Exception e) {
            }
        }
    }

    public float getfatorProjetado(int plc_nr_id) throws Exception {
        float valor = 0;
        if (plc_nr_id == 164) {
            int a = 2;
        }
        try {
            Fat_fatorT ft = treeFatorProj.get(plc_nr_id);
            if (ft != null) {
                valor = ft.getFat_nr_fator_projetado();
            }
            return valor;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("plc"+plc_nr_id);

        }
        return 0;
    }

    public float getValorComp_MesAnt(int obr_nr_id, int plc, int mes, int ano) {
        float valor = 0;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" select max(comp.com_dt_base)as data from easyconstru.com_comprometimento as comp");
            sql.append(" where comp.com_dt_base <? and comp.obr_nr_id =? and comp.plc_nr_id=?");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strData = "01/" + mes + "/" + ano;
            Date dt = dateFormat.parse(strData);
            Com_comprometimentoT ct = new Com_comprometimentoT();
            ct.setCom_dt_base(dt);
            java.sql.Date date = new java.sql.Date(ct.getCom_dt_base().getTime());
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, date);
            ps.setObject(2, obr_nr_id);
            ps.setObject(3, plc);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getDate("data") != null) {
                dateFormat = new SimpleDateFormat("MM");
                Date dt1 = rs.getDate("data");
                String ultmes = dateFormat.format(dt1);
                dateFormat = new SimpleDateFormat("yyyy");
                String ultano = dateFormat.format(rs.getDate("data"));
                sql = new StringBuffer();
                sql.append("select sum(com_nr_valor)as valor from easyconstru.com_comprometimento as comp");
                sql.append(" where comp.obr_nr_id=? and comp.plc_nr_id=? and comp.com_nr_mes=? and comp.com_nr_ano=?");
                ps = con.prepareCall(sql.toString());
                ps.setObject(1, obr_nr_id);
                ps.setObject(2, plc);
                ps.setObject(3, Integer.parseInt(ultmes));
                ps.setObject(4, Integer.parseInt(ultano));
                rs = ps.executeQuery();
                rs.next();
                valor = rs.getFloat("valor");
            }
            return valor;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return valor;
    }

    public float getValorEstoque_MesAnt(int obr_nr_id, int plc, int mes, int ano) throws ParseException, SQLException {
        float valor = 0;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {

            StringBuffer sql = new StringBuffer();
            sql.append(" select max(est.est_dt_base)as data from easyconstru.est_estoque as est");
            sql.append(" where est.est_dt_base <? and est.obr_nr_id =? and est.plc_nr_id=?");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String strData = "01/" + mes + "/" + ano;
            Date dt = dateFormat.parse(strData);
            Est_estoqueT et = new Est_estoqueT();
            et.setEst_dt_base(dt);
            java.sql.Date date = new java.sql.Date(et.getEst_dt_base().getTime());
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, date);
            ps.setObject(2, obr_nr_id);
            ps.setObject(3, plc);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getDate("data") != null) {
                dateFormat = new SimpleDateFormat("MM");
                String ultmes = dateFormat.format(rs.getDate("data"));
                dateFormat = new SimpleDateFormat("yyyy");
                String ultano = dateFormat.format(rs.getDate("data"));
                sql = new StringBuffer();
                sql.append("select sum(est_nr_vl_total)as valor from easyconstru.est_estoque as est");
                sql.append(" where est.obr_nr_id=? and est.plc_nr_id=? and est.est_nr_mes=? and est.est_nr_ano=?");
                ps = con.prepareCall(sql.toString());
                ps.setObject(1, obr_nr_id);
                ps.setObject(2, plc);
                ps.setObject(3, Integer.parseInt(ultmes));
                ps.setObject(4, Integer.parseInt(ultano));
                rs = ps.executeQuery();
                rs.next();
                valor = rs.getFloat("valor");
            }
        } catch (Exception e) {
        } finally {
            try {
            } catch (Exception e) {
                rs.close();
                ps.close();
            }
        }
        return valor;
    }

    public void povoaPrevistoAcumulado(int obr_nr_id, int mes, int ano) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select plc_nr_id, sum(vl_executado) as vl_executado from easyconstru.vw_insumo_plc_pms");
            sql.append(" where obr_nr_id =?");
            sql.append(" and ((pms_nr_mes <= ? and pms_nr_ano = ?) or (pms_nr_ano < ?))");
            sql.append(" group by plc_nr_id");
            //System.out.println(sql.toString());
            ps = con.prepareStatement(sql.toString());
            ps.setObject(1, obr_nr_id);
            ps.setObject(2, mes);
            ps.setObject(3, ano);
            ps.setObject(4, ano);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vw_insumo_plc_pmsT vt = new Vw_insumo_plc_pmsT();
                vt.setPlc_nr_id(rs.getInt("plc_nr_id"));
                vt.setVl_executado(rs.getFloat("vl_executado"));
                treeVlAcumulado.put(vt.getPlc_nr_id(), vt);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
                ps.close();

            } catch (Exception e) {
            }
        }

    }

    public float getValorPrevisto(int plc_nr_id) {
        float valor = 0;
        Vw_insumo_plc_pmsT vt = treeVlAcumulado.get(plc_nr_id);
        if (vt != null) {
            valor = vt.getVl_executado();
        }

        return valor;
    }
}
