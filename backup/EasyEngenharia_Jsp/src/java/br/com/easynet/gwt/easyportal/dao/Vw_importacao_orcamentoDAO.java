package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Vw_importacao_orcamentoDAO extends ObjectDAO {
    private static final String ASPAS = "\"";

    public Vw_importacao_orcamentoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.vw_importacao_orcamento  ( plco_tx_nome, plco_tx_tipo, plco_tx_unidade, ipo_nr_quantidade, ipo_nr_vl_unitario, ipo_nr_vl_total, plco_nr_id, ipo_plc_nr_id_servico, plco_tx_cod_externo, obr_nr_id, plco_nr_nivel) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getPlco_tx_nome());
            pStmt.setObject(2, vw_importacao_orcamentoT.getPlco_tx_tipo());
            pStmt.setObject(3, vw_importacao_orcamentoT.getPlco_tx_unidade());
            pStmt.setObject(4, vw_importacao_orcamentoT.getIpo_nr_quantidade());
            pStmt.setObject(5, vw_importacao_orcamentoT.getIpo_nr_vl_unitario());
            pStmt.setObject(6, vw_importacao_orcamentoT.getIpo_nr_vl_total());
            pStmt.setObject(7, vw_importacao_orcamentoT.getPlco_nr_id());
            pStmt.setObject(8, vw_importacao_orcamentoT.getIpo_plc_nr_id_servico());
            pStmt.setObject(9, vw_importacao_orcamentoT.getPlco_tx_cod_externo());
            pStmt.setObject(10, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(11, vw_importacao_orcamentoT.getPlco_nr_nivel());
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

    public void update(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.vw_importacao_orcamento set  plco_tx_nome=?, plco_tx_tipo=?, plco_tx_unidade=?, ipo_nr_quantidade=?, ipo_nr_vl_unitario=?, ipo_nr_vl_total=?, plco_nr_id=?, ipo_plc_nr_id_servico=?, plco_tx_cod_externo=?, obr_nr_id=?, plco_nr_nivel=?  where -";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getPlco_tx_nome());
            pStmt.setObject(2, vw_importacao_orcamentoT.getPlco_tx_tipo());
            pStmt.setObject(3, vw_importacao_orcamentoT.getPlco_tx_unidade());
            pStmt.setObject(4, vw_importacao_orcamentoT.getIpo_nr_quantidade());
            pStmt.setObject(5, vw_importacao_orcamentoT.getIpo_nr_vl_unitario());
            pStmt.setObject(6, vw_importacao_orcamentoT.getIpo_nr_vl_total());
            pStmt.setObject(7, vw_importacao_orcamentoT.getPlco_nr_id());
            pStmt.setObject(8, vw_importacao_orcamentoT.getIpo_plc_nr_id_servico());
            pStmt.setObject(9, vw_importacao_orcamentoT.getPlco_tx_cod_externo());
            pStmt.setObject(10, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(11, vw_importacao_orcamentoT.getPlco_nr_nivel());
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

    public void delete(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.vw_importacao_orcamento where -";
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

    private List<Vw_importacao_orcamentoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Vw_importacao_orcamentoT> objs = new Vector();
        String nome = "";
        while (rs.next()) {
            Vw_importacao_orcamentoT vw_importacao_orcamentoT = new Vw_importacao_orcamentoT();
            nome = rs.getString("plco_tx_nome");
            nome = nome.replace(ASPAS, "''");
            nome = nome.replace("\r", " ");
            nome = nome.replace("\n", " ");
            vw_importacao_orcamentoT.setPlco_tx_nome(nome);
            vw_importacao_orcamentoT.setPlco_tx_tipo(rs.getString("plco_tx_tipo"));
            vw_importacao_orcamentoT.setPlco_tx_unidade(rs.getString("plco_tx_unidade"));
            vw_importacao_orcamentoT.setIpo_nr_quantidade(rs.getFloat("ipo_nr_quantidade"));
            vw_importacao_orcamentoT.setIpo_nr_vl_unitario(rs.getFloat("ipo_nr_vl_unitario"));
            vw_importacao_orcamentoT.setIpo_nr_vl_total(rs.getFloat("ipo_nr_vl_total"));
            vw_importacao_orcamentoT.setPlco_nr_id(rs.getInt("plco_nr_id"));
            vw_importacao_orcamentoT.setIpo_plc_nr_id_servico(rs.getInt("ipo_plc_nr_id_servico"));
            vw_importacao_orcamentoT.setPlco_tx_cod_externo(rs.getString("plco_tx_cod_externo"));
            vw_importacao_orcamentoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            vw_importacao_orcamentoT.setPlco_nr_nivel(rs.getInt("plco_nr_nivel"));
            vw_importacao_orcamentoT.setIpo_nr_id(rs.getInt("ipo_nr_id"));
            vw_importacao_orcamentoT.setIpo_nr_id_super(rs.getInt("ipo_nr_id_super"));
            vw_importacao_orcamentoT.setIpo_bl_cronograma(rs.getBoolean("ipo_bl_cronograma") & rs.getInt("plco_nr_nivel") > 3);
            objs.add(vw_importacao_orcamentoT);
        }
        return objs;
    }

    public List<Vw_importacao_orcamentoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Vw_importacao_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_importacao_orcamentoT> getAllServico(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        //ok
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where obr_nr_id =? and ipo_bl_cronograma = true ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            rs = pStmt.executeQuery();
            List<Vw_importacao_orcamentoT> list = resultSetToObjectTransfer(rs);
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

    public List<Vw_importacao_orcamentoT> getByPK(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where -";
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

    public List<Vw_importacao_orcamentoT> getByPlco_tx_nome(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  Upper(plco_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_importacao_orcamentoT.getPlco_tx_nome() + '%');
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

    public List<Vw_importacao_orcamentoT> getByPlco_tx_tipo(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  Upper(plco_tx_tipo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_importacao_orcamentoT.getPlco_tx_tipo() + '%');
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

    public List<Vw_importacao_orcamentoT> getByPlco_tx_unidade(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  Upper(plco_tx_unidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_importacao_orcamentoT.getPlco_tx_unidade() + '%');
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

    public List<Vw_importacao_orcamentoT> getByIpo_nr_quantidade(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  ipo_nr_quantidade = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getIpo_nr_quantidade());
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

    public List<Vw_importacao_orcamentoT> getByIpo_nr_vl_unitario(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  ipo_nr_vl_unitario = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getIpo_nr_vl_unitario());
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

    public List<Vw_importacao_orcamentoT> getByIpo_nr_vl_total(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  ipo_nr_vl_total = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getIpo_nr_vl_total());
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

    public List<Vw_importacao_orcamentoT> getByPlco_nr_id(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  plco_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getPlco_nr_id());
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

    public List<Vw_importacao_orcamentoT> getByIpo_plc_nr_id_servico(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  ipo_plc_nr_id_servico = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getIpo_plc_nr_id_servico());
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

    public List<Vw_importacao_orcamentoT> getByPlco_tx_cod_externo(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  Upper(plco_tx_cod_externo) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + vw_importacao_orcamentoT.getPlco_tx_cod_externo() + '%');
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

    public List<Vw_importacao_orcamentoT> getByObr_nr_id(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
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

    public List<Vw_importacao_orcamentoT> getById_Nivel1(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
//            String sql = "select * from easyconstru.vw_importacao_orcamento where obr_nr_id =? and ipo_bl_cronograma = true ";
            //String sql = "select * from easyconstru.vw_importacao_orcamento where  obr_nr_id = ? and ipo_nr_id_nivel_1 =? and plco_nr_nivel < 5 ";
            String sql = "select * from easyconstru.vw_importacao_orcamento where  obr_nr_id = ? and ipo_nr_id_nivel_1 =? and ipo_bl_cronograma = true ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(2, vw_importacao_orcamentoT.getIpo_nr_id_nivel_1());
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

    public List<Vw_importacao_orcamentoT> getById_Nivel2(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  obr_nr_id = ? and ipo_nr_id_nivel_2 =? and plco_nr_nivel < 5 ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(2, vw_importacao_orcamentoT.getIpo_nr_id_nivel_2());
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

    public List<Vw_importacao_orcamentoT> getById_Nivel3(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  obr_nr_id = ? and ipo_nr_id_nivel_3 =? and plco_nr_nivel < 5 ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(2, vw_importacao_orcamentoT.getIpo_nr_id_nivel_3());
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

    public List<Vw_importacao_orcamentoT> getByPlco_nr_nivel(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where  plco_nr_nivel = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getPlco_nr_nivel());
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

    public List<Vw_importacao_orcamentoT> getAllNivel(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.vw_importacao_orcamento where obr_nr_id =? and plco_nr_nivel = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, vw_importacao_orcamentoT.getObr_nr_id());
            pStmt.setObject(2, vw_importacao_orcamentoT.getPlco_nr_nivel());
            rs = pStmt.executeQuery();
            List<Vw_importacao_orcamentoT> list = resultSetToObjectTransfer(rs);
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
}
