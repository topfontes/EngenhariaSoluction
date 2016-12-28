package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Plco_plano_contas_orcamentoDAO extends ObjectDAO {

    private static Object inserir = "true";

    public Plco_plano_contas_orcamentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxValue() throws SQLException, Exception {
        Statement st = null;
        ResultSet rs = null;
        try {
            String sql = "select max(plco_nr_id) as plco_nr_id from easyconstru.plco_plano_contas_orcamento";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            int id = rs.getInt("plco_nr_id");
            return id;
        } catch (Exception e) {
            throw e;
        }finally{
            try {
                rs.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }

    public int insert(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            synchronized (inserir) {
                String sql = "insert into easyconstru.plco_plano_contas_orcamento  ( plco_tx_nome, plco_tx_tipo, plco_tx_cod_externo, plco_tx_unidade, plco_nr_id_super, plco_nr_nivel,plco_bl_equivalencia) values (? , ?, ? , ? , ? , ? , ? )";
                pStmt = con.prepareStatement(sql);
                pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_tx_nome());
                pStmt.setObject(2, plco_plano_contas_orcamentoT.getPlco_tx_tipo());
                pStmt.setObject(3, plco_plano_contas_orcamentoT.getPlco_tx_cod_externo());
                pStmt.setObject(4, plco_plano_contas_orcamentoT.getPlco_tx_unidade());
                pStmt.setObject(5, plco_plano_contas_orcamentoT.getPlco_nr_id_super());
                pStmt.setObject(6, plco_plano_contas_orcamentoT.getPlco_nr_nivel());
                pStmt.setObject(7, plco_plano_contas_orcamentoT.isPlco_bl_equivalencia());

                pStmt.execute();
                return maxValue();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }

    public void update(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.plco_plano_contas_orcamento set  plco_tx_nome=?, plco_tx_tipo=?, plco_tx_cod_externo=?, plco_tx_unidade=?, plco_nr_id_super=?, plco_nr_nivel=?  where  plco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_tx_nome());
            pStmt.setObject(2, plco_plano_contas_orcamentoT.getPlco_tx_tipo());
            pStmt.setObject(3, plco_plano_contas_orcamentoT.getPlco_tx_cod_externo());
            pStmt.setObject(4, plco_plano_contas_orcamentoT.getPlco_tx_unidade());
            pStmt.setObject(5, plco_plano_contas_orcamentoT.getPlco_nr_id_super());
            pStmt.setObject(6, plco_plano_contas_orcamentoT.getPlco_nr_nivel());
            pStmt.setObject(7, plco_plano_contas_orcamentoT.getPlco_nr_id());
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

    public void delete(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.plco_plano_contas_orcamento where  plco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_nr_id());
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

    private List<Plco_plano_contas_orcamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Plco_plano_contas_orcamentoT> objs = new Vector();
        while (rs.next()) {
            Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
            plco_plano_contas_orcamentoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            plco_plano_contas_orcamentoT.setPlco_tx_nome(rs.getString("plco_tx_nome"));
            plco_plano_contas_orcamentoT.setPlco_tx_tipo(rs.getString("plco_tx_tipo"));
            plco_plano_contas_orcamentoT.setPlco_tx_cod_externo(rs.getString("plco_tx_cod_externo"));
            plco_plano_contas_orcamentoT.setPlco_tx_unidade(rs.getString("plco_tx_unidade"));
            plco_plano_contas_orcamentoT.setPlco_nr_id_super(rs.getInt("plco_nr_id_super"));
            plco_plano_contas_orcamentoT.setPlco_nr_nivel(rs.getInt("plco_nr_nivel"));
            plco_plano_contas_orcamentoT.setPlco_bl_equivalencia(rs.getBoolean("plco_bl_equivalencia"));
            plco_plano_contas_orcamentoT.setSubClasse(" ");
            objs.add(plco_plano_contas_orcamentoT);
        }
        return objs;
    }

    public List<Plco_plano_contas_orcamentoT> getAllNivel(int nivel) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_nr_nivel=? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, nivel);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getAllNivelMDO(int nivel) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String mdo = "M.O.";
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_nr_nivel=? and Upper(plco_tx_tipo)=? order by plco_tx_nome";
            pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, nivel);
            pStmt.setString(2, mdo);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getAllServico() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_nr_nivel<5 ";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getAllSuper() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_tx_unidade is null ";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_tx_unidade is not null order by plco_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getSemEquivalencia() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where plco_nr_id in( select plco_nr_id from easyconstru.ipo_item_plano_contas_obra ipo where ipo.ipo_bl_curva_abc =true)  and plco_nr_id not in(select plco_nr_id from easyconstru.eplc_equivalencia_plano_contas) order by plco_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Plco_plano_contas_orcamentoT> getByPK(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  plco_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_nr_id());
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_nr_id(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_nr_id());
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_tx_nome(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  Upper(plco_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plco_plano_contas_orcamentoT.getPlco_tx_nome() + '%');
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_tx_tipo(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  Upper(plco_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plco_plano_contas_orcamentoT.getPlco_tx_tipo() + '%');
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_tx_cod_externo(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  Upper(plco_tx_cod_externo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plco_plano_contas_orcamentoT.getPlco_tx_cod_externo() + '%');
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

    public Plco_plano_contas_orcamentoT ObjetoValido(String codigo) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  plco_tx_cod_externo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, codigo);
            rs = pStmt.executeQuery();
            List<Plco_plano_contas_orcamentoT> listplco = resultSetToObjectTransfer(rs);
            return listplco.size() != 0 ? listplco.get(0) : new Plco_plano_contas_orcamentoT();
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_tx_unidade(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  Upper(plco_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + plco_plano_contas_orcamentoT.getPlco_tx_unidade() + '%');
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

    public List<Plco_plano_contas_orcamentoT> getByPlco_nr_id_super(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.plco_plano_contas_orcamento where  plco_nr_id_super = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, plco_plano_contas_orcamentoT.getPlco_nr_id_super());
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
