package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Fol_folha_pagamentoDAO extends ObjectDAO {

    private static Object insert = "true";

    public Fol_folha_pagamentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxId() throws Exception {
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "select  max(fol_nr_id) as id from easyconstru.fol_folha_pagamento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
            //throw e;
        } finally {
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
        return 0;
    }

    public void insert(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        synchronized (insert) {
            PreparedStatement pStmt = null;
            try {
                String sql = "insert into easyconstru.fol_folha_pagamento( obr_nr_id, plco_nr_id, fol_nr_mes, fol_nr_ano, fol_nr_salario_bruto_oficial, fol_nr_adiantamento_oficial, fol_nr_horas_extra_oficial, fol_nr_salario_bruto_nao_oficial, fol_nr_adiantamento_nao_oficial, fol_nr_horas_extra_nao_oficial, fol_nr_numero_funcionario) values ( ? , ?, ? , ? , ? , ? , ? , ? , ? , ? , ? )";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, fol_folha_pagamentoT.getObr_nr_id());
                pStmt.setObject(2, fol_folha_pagamentoT.getPlco_nr_id());
                pStmt.setObject(3, fol_folha_pagamentoT.getFol_nr_mes());
                pStmt.setObject(4, fol_folha_pagamentoT.getFol_nr_ano());
                pStmt.setObject(5, fol_folha_pagamentoT.getFol_nr_salario_bruto_oficial());
                pStmt.setObject(6, fol_folha_pagamentoT.getFol_nr_adiantamento_oficial());
                pStmt.setObject(7, fol_folha_pagamentoT.getFol_nr_horas_extra_oficial());
                pStmt.setObject(8, fol_folha_pagamentoT.getFol_nr_salario_bruto_nao_oficial());
                pStmt.setObject(9, fol_folha_pagamentoT.getFol_nr_adiantamento_nao_oficial());
                pStmt.setObject(10, fol_folha_pagamentoT.getFol_nr_horas_extra_nao_oficial());
                pStmt.setObject(11, fol_folha_pagamentoT.getFol_nr_numero_funcionario());
                pStmt.execute();
                fol_folha_pagamentoT.setFol_nr_id(maxId());
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

    public void update(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.fol_folha_pagamento set  obr_nr_id=?, plco_nr_id=?,fol_nr_mes=?, fol_nr_ano=?, fol_nr_salario_bruto_oficial=?, fol_nr_adiantamento_oficial=?, fol_nr_horas_extra_oficial=?, fol_nr_salario_bruto_nao_oficial=?, fol_nr_adiantamento_nao_oficial=?, fol_nr_horas_extra_nao_oficial=?, fol_nr_numero_funcionario=?  where  fol_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getObr_nr_id());
            pStmt.setObject(2, fol_folha_pagamentoT.getPlco_nr_id());
            pStmt.setObject(3, fol_folha_pagamentoT.getFol_nr_mes());
            pStmt.setObject(4, fol_folha_pagamentoT.getFol_nr_ano());
            pStmt.setObject(5, fol_folha_pagamentoT.getFol_nr_salario_bruto_oficial());
            pStmt.setObject(6, fol_folha_pagamentoT.getFol_nr_adiantamento_oficial());
            pStmt.setObject(7, fol_folha_pagamentoT.getFol_nr_horas_extra_oficial());
            pStmt.setObject(8, fol_folha_pagamentoT.getFol_nr_salario_bruto_nao_oficial());
            pStmt.setObject(9, fol_folha_pagamentoT.getFol_nr_adiantamento_nao_oficial());
            pStmt.setObject(10, fol_folha_pagamentoT.getFol_nr_horas_extra_nao_oficial());
            pStmt.setObject(11, fol_folha_pagamentoT.getFol_nr_numero_funcionario());
            pStmt.setObject(12, fol_folha_pagamentoT.getFol_nr_id());
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

    public void delete(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.fol_folha_pagamento where  fol_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_id());
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

    private List<Fol_folha_pagamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Fol_folha_pagamentoT> objs = new Vector();
        while (rs.next()) {
            Fol_folha_pagamentoT fol_folha_pagamentoT = new Fol_folha_pagamentoT();
            fol_folha_pagamentoT.setFol_nr_id(rs.getInt("fol_nr_id"));
            fol_folha_pagamentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            fol_folha_pagamentoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            fol_folha_pagamentoT.setFol_nr_mes(rs.getInt("fol_nr_mes"));
            fol_folha_pagamentoT.setFol_nr_ano(rs.getInt("fol_nr_ano"));
            fol_folha_pagamentoT.setFol_nr_salario_bruto_oficial(rs.getFloat("fol_nr_salario_bruto_oficial"));
            fol_folha_pagamentoT.setFol_nr_adiantamento_oficial(rs.getFloat("fol_nr_adiantamento_oficial"));
            fol_folha_pagamentoT.setFol_nr_horas_extra_oficial(rs.getFloat("fol_nr_horas_extra_oficial"));
            fol_folha_pagamentoT.setFol_nr_salario_bruto_nao_oficial(rs.getFloat("fol_nr_salario_bruto_nao_oficial"));
            fol_folha_pagamentoT.setFol_nr_adiantamento_nao_oficial(rs.getFloat("fol_nr_adiantamento_nao_oficial"));
            fol_folha_pagamentoT.setFol_nr_horas_extra_nao_oficial(rs.getFloat("fol_nr_horas_extra_nao_oficial"));
            fol_folha_pagamentoT.setFol_nr_numero_funcionario(rs.getInt("fol_nr_numero_funcionario"));
            objs.add(fol_folha_pagamentoT);
        }
        return objs;
    }

    public DataSet getAll(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {

        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select folha.fol_nr_id, folha.obr_nr_id, equiv.plc_nr_id, folha.plco_nr_id, folha.fol_nr_mes, folha.fol_nr_ano , plco.plco_tx_nome as fol_tx_funcao ,folha.fol_nr_salario_bruto_oficial, folha.fol_nr_adiantamento_oficial, folha.fol_nr_horas_extra_oficial, folha.fol_nr_salario_bruto_nao_oficial, folha.fol_nr_adiantamento_nao_oficial, folha.fol_nr_horas_extra_nao_oficial, folha.fol_nr_numero_funcionario, plc.plc_tx_nome, plc_super.plc_tx_nome as plc_tx_super");
            sql.append(" from easyconstru.fol_folha_pagamento as folha ");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas as equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = equiv.plc_nr_id)");
            sql.append(" inner join easyconstru.plc_plano_contas as plc_super on(plc.plc_nr_id_super = plc_super.plc_nr_id)");
            sql.append(" inner join easyconstru.plco_plano_contas_orcamento as plco on(folha.plco_nr_id = plco.plco_nr_id)");
            sql.append(" where folha.obr_nr_id =? ");
            sql.append(" and folha.fol_nr_mes =? ");
            sql.append(" and folha.fol_nr_ano =? ");

            Object[] param = new Object[3];
            param[0] = fol_folha_pagamentoT.getObr_nr_id();
            param[1] = fol_folha_pagamentoT.getFol_nr_mes();
            param[2] = fol_folha_pagamentoT.getFol_nr_ano();
            ds = executeQuery(sql.toString(), param);

            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
            } catch (Exception e) {
            }

        }
    }

    public DataSet getAll_GroupBy(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {

        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select folha.obr_nr_id, equiv.plc_nr_id, folha.plco_nr_id, folha.fol_nr_mes, folha.fol_nr_ano , plco.plco_tx_nome as fol_tx_funcao ,sum(folha.fol_nr_salario_bruto_oficial) as fol_nr_salario_bruto_oficial, sum(folha.fol_nr_adiantamento_oficial) as fol_nr_adiantamento_oficial, sum(folha.fol_nr_horas_extra_oficial) as fol_nr_horas_extra_oficial, sum(folha.fol_nr_salario_bruto_nao_oficial) as fol_nr_salario_bruto_nao_oficial, sum(folha.fol_nr_adiantamento_nao_oficial) as fol_nr_adiantamento_nao_oficial, sum(folha.fol_nr_horas_extra_nao_oficial) as fol_nr_horas_extra_nao_oficial, sum(folha.fol_nr_numero_funcionario) as fol_nr_numero_funcionario, plc.plc_tx_nome, plc_super.plc_tx_nome as plc_tx_super");
            sql.append(" from easyconstru.fol_folha_pagamento as folha ");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas as equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner join easyconstru.plc_plano_contas as plc on(plc.plc_nr_id = equiv.plc_nr_id)");
            sql.append(" inner join easyconstru.plc_plano_contas as plc_super on(plc.plc_nr_id_super = plc_super.plc_nr_id)");
            sql.append(" inner join easyconstru.plco_plano_contas_orcamento as plco on(folha.plco_nr_id = plco.plco_nr_id)");
            sql.append(" where folha.obr_nr_id =? ");
            sql.append(" and folha.fol_nr_mes =? ");
            sql.append(" and folha.fol_nr_ano =? ");
            sql.append(" group by ");
            sql.append(" folha.obr_nr_id, equiv.plc_nr_id, folha.plco_nr_id, folha.fol_nr_mes, folha.fol_nr_ano , plco.plco_tx_nome, plc.plc_tx_nome, plc_super.plc_tx_nome ");
            sql.append(" order by plc_super.plc_tx_nome, plco.plco_tx_nome");
            Object[] param = new Object[3];
            param[0] = fol_folha_pagamentoT.getObr_nr_id();
            param[1] = fol_folha_pagamentoT.getFol_nr_mes();
            param[2] = fol_folha_pagamentoT.getFol_nr_ano();
            ds = executeQuery(sql.toString(), param);

            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
            } catch (Exception e) {
            }

        }
    }

    public List<Fol_folha_pagamentoT> getByPK(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_id());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_id(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_id());
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

    public List<Fol_folha_pagamentoT> getByObr_nr_id(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getObr_nr_id());
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

    public List<Fol_folha_pagamentoT> getByPlc_nr_id(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getPlc_nr_id());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_mes(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_mes());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_ano(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_ano());
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

    public List<Fol_folha_pagamentoT> getByFol_tx_funcao(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  Upper(fol_tx_funcao) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + fol_folha_pagamentoT.getFol_tx_funcao() + '%');
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

    public List<Fol_folha_pagamentoT> getByFol_nr_salario_bruto_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_salario_bruto_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_salario_bruto_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_adiantamento_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_adiantamento_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_adiantamento_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_horas_extra_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_horas_extra_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_horas_extra_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_salario_bruto_nao_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_salario_bruto_nao_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_salario_bruto_nao_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_adiantamento_nao_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_adiantamento_nao_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_adiantamento_nao_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_horas_extra_nao_oficial(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_horas_extra_nao_oficial = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_horas_extra_nao_oficial());
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

    public List<Fol_folha_pagamentoT> getByFol_nr_numero_funcionario(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.fol_folha_pagamento where  fol_nr_numero_funcionario = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, fol_folha_pagamentoT.getFol_nr_numero_funcionario());
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

    public DataSet getAllHH(int obr_nr_id, int mes, int ano, int plc_nr_id) throws Exception {
        DataSet ds = null;
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("select equiv.plc_nr_id,folha.plco_nr_id,subclasse.plc_tx_nome as subclasse, conta.plco_tx_nome as insumo, sum(folha.fol_nr_numero_funcionario)as qtde from easyconstru.fol_folha_pagamento as folha");
            sql.append(" inner join easyconstru.plco_plano_contas_orcamento conta on(conta.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner JOIN easyconstru.plc_plano_contas subClasse ON subclasse.plc_nr_id = equiv.plc_nr_id");
            //sql.append(" inner join easyconstru.obr_obras obra on(obra.obr_nr_id_plc_mdo_direta = equiv.plc_nr_id or obra.obr_nr_id_plc_mdo_indireta = equiv.plc_nr_id)");
            sql.append(" where folha.obr_nr_id = ? and folha.fol_nr_mes = ? and folha.fol_nr_ano = ?");
            sql.append(" and equiv.plc_nr_id = ?");
            sql.append(" group by equiv.plc_nr_id,folha.plco_nr_id, subclasse.plc_tx_nome, conta.plco_tx_nome");
            sql.append(" order by subclasse.plc_tx_nome, conta.plco_tx_nome");

            Object[] param = new Object[4];
            param[0] = obr_nr_id;
            param[1] = mes;
            param[2] = ano;
            param[3] = plc_nr_id;
            ds = executeQuery(sql.toString(), param);
            return ds;
        } catch (Exception e) {
            throw e;
        } finally {
        }
        //return ds;
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
    
    public double getCustoRealizadoMesOficial(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();
            sql.append(" select sum(fol_nr_salario_bruto_oficial + fol_nr_adiantamento_oficial + fol_nr_horas_extra_oficial)as valor ");
            sql.append(" from easyconstru.fol_folha_pagamento folha");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner JOIN easyconstru.plc_plano_contas subClasse ON subclasse.plc_nr_id = equiv.plc_nr_id");
            sql.append(" where folha.obr_nr_id =? and folha.fol_nr_mes=? and folha.fol_nr_ano=? and subClasse.plc_nr_id_super in"+getIdClasses(id_classes));

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
    public double getCustoRealizadoAcumuladoOficial(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();
            sql.append(" select sum(fol_nr_salario_bruto_oficial + fol_nr_adiantamento_oficial + fol_nr_horas_extra_oficial)as valor ");
            sql.append(" from easyconstru.fol_folha_pagamento folha");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner JOIN easyconstru.plc_plano_contas subClasse ON subclasse.plc_nr_id = equiv.plc_nr_id");
            sql.append(" where folha.obr_nr_id =? and (folha.fol_nr_mes <=? and folha.fol_nr_ano=? or fol_nr_ano <?) and subClasse.plc_nr_id_super in"+getIdClasses(id_classes));

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, ano);
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

    public double getCustoRealizadoMesNaoOficial(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();
            sql.append(" select sum(fol_nr_salario_bruto_nao_oficial + fol_nr_adiantamento_nao_oficial + fol_nr_horas_extra_nao_oficial) as valor ");
            sql.append(" from easyconstru.fol_folha_pagamento folha");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner JOIN easyconstru.plc_plano_contas subClasse ON subclasse.plc_nr_id = equiv.plc_nr_id");
            sql.append(" where folha.obr_nr_id =? and folha.fol_nr_mes =? and folha.fol_nr_ano=? and subClasse.plc_nr_id_super in"+getIdClasses(id_classes));

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
    public double getCustoRealizadoAcumuladoNaoOficial(int obr_nr_id, int mes, int ano, int[] id_classes) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            double valor = 0;
            StringBuffer sql = new StringBuffer();
            sql.append(" select sum(fol_nr_salario_bruto_nao_oficial + fol_nr_adiantamento_nao_oficial + fol_nr_horas_extra_nao_oficial) as valor");
            sql.append(" from easyconstru.fol_folha_pagamento folha");
            sql.append(" inner join easyconstru.eplc_equivalencia_plano_contas equiv on(equiv.plco_nr_id = folha.plco_nr_id)");
            sql.append(" inner JOIN easyconstru.plc_plano_contas subClasse ON subclasse.plc_nr_id = equiv.plc_nr_id");
            sql.append(" where folha.obr_nr_id =? and (folha.fol_nr_mes <=? and folha.fol_nr_ano=? or fol_nr_ano <?) and subClasse.plc_nr_id_super in"+getIdClasses(id_classes));

            pStmt = con.prepareStatement(sql.toString());
            pStmt.setObject(1, obr_nr_id);
            pStmt.setObject(2, mes);
            pStmt.setObject(3, ano);
            pStmt.setObject(4, ano);
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


}

