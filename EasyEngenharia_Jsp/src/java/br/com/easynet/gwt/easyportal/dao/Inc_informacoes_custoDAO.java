package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Inc_informacoes_custoDAO extends ObjectDAO {

    public Inc_informacoes_custoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.inc_informacoes_custo  ( obr_nr_id, inc_nr_mes, inc_nr_ano, plc_nr_id, inc_tx_custo_acumulado, inc_nr_custo_periodo, inc_tx_calsas, inc_tx_problemas, inc_tx_acoes, inc_tx_responsavel, inc_dt_prazo) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getObr_nr_id());
            pStmt.setObject(2, inc_informacoes_custoT.getInc_nr_mes());
            pStmt.setObject(3, inc_informacoes_custoT.getInc_nr_ano());
            pStmt.setObject(4, inc_informacoes_custoT.getPlc_nr_id());
            pStmt.setObject(5, inc_informacoes_custoT.getInc_tx_custo_acumulado());
            pStmt.setObject(6, inc_informacoes_custoT.getInc_nr_custo_periodo());
            pStmt.setObject(7, inc_informacoes_custoT.getInc_tx_calsas());
            pStmt.setObject(8, inc_informacoes_custoT.getInc_tx_problemas());
            pStmt.setObject(9, inc_informacoes_custoT.getInc_tx_acoes());
            pStmt.setObject(10, inc_informacoes_custoT.getInc_tx_responsavel());
            java.sql.Date dt11 = new java.sql.Date(inc_informacoes_custoT.getInc_dt_prazo().getTime());
            pStmt.setObject(11, dt11);
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

    public void update(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.inc_informacoes_custo set  obr_nr_id=?, inc_nr_mes=?, inc_nr_ano=?, plc_nr_id=?, inc_tx_custo_acumulado=?, inc_nr_custo_periodo=?, inc_tx_calsas=?, inc_tx_problemas=?, inc_tx_acoes=?, inc_tx_responsavel=?, inc_dt_prazo=?  where  inc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getObr_nr_id());
            pStmt.setObject(2, inc_informacoes_custoT.getInc_nr_mes());
            pStmt.setObject(3, inc_informacoes_custoT.getInc_nr_ano());
            pStmt.setObject(4, inc_informacoes_custoT.getPlc_nr_id());
            pStmt.setObject(5, inc_informacoes_custoT.getInc_tx_custo_acumulado());
            pStmt.setObject(6, inc_informacoes_custoT.getInc_nr_custo_periodo());
            pStmt.setObject(7, inc_informacoes_custoT.getInc_tx_calsas());
            pStmt.setObject(8, inc_informacoes_custoT.getInc_tx_problemas());
            pStmt.setObject(9, inc_informacoes_custoT.getInc_tx_acoes());
            pStmt.setObject(10, inc_informacoes_custoT.getInc_tx_responsavel());
            java.sql.Date dt11 = new java.sql.Date(inc_informacoes_custoT.getInc_dt_prazo().getTime());
            pStmt.setObject(11, dt11);
            pStmt.setObject(12, inc_informacoes_custoT.getInc_nr_id());
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

    public void delete(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.inc_informacoes_custo where  inc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_nr_id());
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

    private List<Inc_informacoes_custoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Inc_informacoes_custoT> objs = new Vector();
        while (rs.next()) {
            Inc_informacoes_custoT inc_informacoes_custoT = new Inc_informacoes_custoT();
            inc_informacoes_custoT.setInc_nr_id(rs.getInt("inc_nr_id"));
            inc_informacoes_custoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            inc_informacoes_custoT.setInc_nr_mes(rs.getInt("inc_nr_mes"));
            inc_informacoes_custoT.setInc_nr_ano(rs.getInt("inc_nr_ano"));
            inc_informacoes_custoT.setPlc_nr_id(rs.getInt("plc_nr_id"));
            inc_informacoes_custoT.setInc_tx_custo_acumulado(rs.getFloat("inc_tx_custo_acumulado"));
            inc_informacoes_custoT.setInc_nr_custo_periodo(rs.getFloat("inc_nr_custo_periodo"));
            inc_informacoes_custoT.setInc_tx_calsas(rs.getString("inc_tx_calsas"));
            inc_informacoes_custoT.setInc_tx_problemas(rs.getString("inc_tx_problemas"));
            inc_informacoes_custoT.setInc_tx_acoes(rs.getString("inc_tx_acoes"));
            inc_informacoes_custoT.setInc_tx_responsavel(rs.getString("inc_tx_responsavel"));
            inc_informacoes_custoT.setInc_dt_prazo(rs.getDate("inc_dt_prazo"));
            objs.add(inc_informacoes_custoT);
        }
        return objs;
    }

    public List<Inc_informacoes_custoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Inc_informacoes_custoT> list = resultSetToObjectTransfer(rs);
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

    public List<Inc_informacoes_custoT> getByPK(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_nr_id());
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

    public List<Inc_informacoes_custoT> getByInc_nr_id(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_nr_id());
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

    public List<Inc_informacoes_custoT> getByObr_nr_id(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getObr_nr_id());
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

    public List<Inc_informacoes_custoT> getByInc_nr_ano(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_nr_ano());
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

    public List<Inc_informacoes_custoT> getByInformacaoCusto(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where obr_nr_id=? and  inc_nr_mes = ? and inc_nr_ano = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getObr_nr_id());
            pStmt.setObject(2, inc_informacoes_custoT.getInc_nr_mes());
            pStmt.setObject(3, inc_informacoes_custoT.getInc_nr_ano());
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

    public List<Inc_informacoes_custoT> getByPlc_nr_id(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  plc_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getPlc_nr_id());
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

    public List<Inc_informacoes_custoT> getByInc_tx_custo_acumulado(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_tx_custo_acumulado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_tx_custo_acumulado());
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

    public List<Inc_informacoes_custoT> getByInc_nr_custo_periodo(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_nr_custo_periodo = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, inc_informacoes_custoT.getInc_nr_custo_periodo());
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

    public List<Inc_informacoes_custoT> getByInc_tx_calsas(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  Upper(inc_tx_calsas) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inc_informacoes_custoT.getInc_tx_calsas() + '%');
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

    public List<Inc_informacoes_custoT> getByInc_tx_problemas(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  Upper(inc_tx_problemas) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inc_informacoes_custoT.getInc_tx_problemas() + '%');
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

    public List<Inc_informacoes_custoT> getByInc_tx_acoes(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  Upper(inc_tx_acoes) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inc_informacoes_custoT.getInc_tx_acoes() + '%');
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

    public List<Inc_informacoes_custoT> getByInc_tx_responsavel(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  Upper(inc_tx_responsavel) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + inc_informacoes_custoT.getInc_tx_responsavel() + '%');
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

    public List<Inc_informacoes_custoT> getByInc_dt_prazo(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.inc_informacoes_custo where  inc_dt_prazo = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(inc_informacoes_custoT.getInc_dt_prazo().getTime());
            pStmt.setObject(1, dt1);
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
