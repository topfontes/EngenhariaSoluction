package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Pro_programacaoDAO extends ObjectDAO {

    public Pro_programacaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.pro_programacao  ( obr_nr_id, pro_nr_mes, pro_nr_ano, pro_dt_coleta_orcamento, pro_dt_coleta_rh, pro_dt_analise_inicio, pro_dt_analise_final, pro_dt_reuniao_engenharia, pro_dt_reuniao_diretoria, pro_dt_reuniao_geral) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getObr_nr_id());
            pStmt.setObject(2, pro_programacaoT.getPro_nr_mes());
            pStmt.setObject(3, pro_programacaoT.getPro_nr_ano());
            java.sql.Date dt4 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_orcamento().getTime());
            pStmt.setObject(4, dt4);
            java.sql.Date dt5 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_rh().getTime());
            pStmt.setObject(5, dt5);
            java.sql.Date dt6 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_inicio().getTime());
            pStmt.setObject(6, dt6);
            java.sql.Date dt7 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_final().getTime());
            pStmt.setObject(7, dt7);
            java.sql.Date dt8 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_engenharia().getTime());
            pStmt.setObject(8, dt8);
            java.sql.Date dt9 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_diretoria().getTime());
            pStmt.setObject(9, dt9);
            java.sql.Date dt10 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_geral().getTime());
            pStmt.setObject(10, dt10);
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

    public void update(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.pro_programacao set  obr_nr_id=?, pro_nr_mes=?, pro_nr_ano=?, pro_dt_coleta_orcamento=?, pro_dt_coleta_rh=?, pro_dt_analise_inicio=?, pro_dt_analise_final=?, pro_dt_reuniao_engenharia=?, pro_dt_reuniao_diretoria=?, pro_dt_reuniao_geral=?  where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getObr_nr_id());
            pStmt.setObject(2, pro_programacaoT.getPro_nr_mes());
            pStmt.setObject(3, pro_programacaoT.getPro_nr_ano());
            java.sql.Date dt4 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_orcamento().getTime());
            pStmt.setObject(4, dt4);
            java.sql.Date dt5 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_rh().getTime());
            pStmt.setObject(5, dt5);
            java.sql.Date dt6 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_inicio().getTime());
            pStmt.setObject(6, dt6);
            java.sql.Date dt7 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_final().getTime());
            pStmt.setObject(7, dt7);
            java.sql.Date dt8 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_engenharia().getTime());
            pStmt.setObject(8, dt8);
            java.sql.Date dt9 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_diretoria().getTime());
            pStmt.setObject(9, dt9);
            java.sql.Date dt10 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_geral().getTime());
            pStmt.setObject(10, dt10);
            pStmt.setObject(11, pro_programacaoT.getPro_nr_id());
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

    public void delete(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.pro_programacao where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getPro_nr_id());
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

    private List<Pro_programacaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Pro_programacaoT> objs = new Vector();
        while (rs.next()) {
            Pro_programacaoT pro_programacaoT = new Pro_programacaoT();
            pro_programacaoT.setPro_nr_id(rs.getInt("pro_nr_id"));
            pro_programacaoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            pro_programacaoT.setPro_nr_mes(rs.getInt("pro_nr_mes"));
            pro_programacaoT.setPro_nr_ano(rs.getInt("pro_nr_ano"));
            pro_programacaoT.setPro_dt_coleta_orcamento(rs.getDate("pro_dt_coleta_orcamento"));
            pro_programacaoT.setPro_dt_coleta_rh(rs.getDate("pro_dt_coleta_rh"));
            pro_programacaoT.setPro_dt_analise_inicio(rs.getDate("pro_dt_analise_inicio"));
            pro_programacaoT.setPro_dt_analise_final(rs.getDate("pro_dt_analise_final"));
            pro_programacaoT.setPro_dt_reuniao_engenharia(rs.getDate("pro_dt_reuniao_engenharia"));
            pro_programacaoT.setPro_dt_reuniao_diretoria(rs.getDate("pro_dt_reuniao_diretoria"));
            pro_programacaoT.setPro_dt_reuniao_geral(rs.getDate("pro_dt_reuniao_geral"));
            objs.add(pro_programacaoT);
        }
        return objs;
    }

    public List<Pro_programacaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Pro_programacaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Pro_programacaoT> getByPK(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getPro_nr_id());
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

    public List<Pro_programacaoT> getByPro_nr_id(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getPro_nr_id());
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

    public List<Pro_programacaoT> getByObr_nr_id(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getObr_nr_id());
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

    public List<Pro_programacaoT> getByObraMesAno(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  obr_nr_id = ? and pro_nr_mes = ? and pro_nr_ano = ?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getObr_nr_id());
            pStmt.setObject(2, pro_programacaoT.getPro_nr_mes());
            pStmt.setObject(3, pro_programacaoT.getPro_nr_ano());
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

    public List<Pro_programacaoT> getByPro_nr_ano(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, pro_programacaoT.getPro_nr_ano());
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

    public List<Pro_programacaoT> getByPro_dt_coleta_orcamento(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_coleta_orcamento = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_orcamento().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_coleta_rh(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_coleta_rh = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_coleta_rh().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_analise_inicio(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_analise_inicio = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_inicio().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_analise_final(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_analise_final = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_analise_final().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_reuniao_engenharia(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_reuniao_engenharia = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_engenharia().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_reuniao_diretoria(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_reuniao_diretoria = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_diretoria().getTime());
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

    public List<Pro_programacaoT> getByPro_dt_reuniao_geral(Pro_programacaoT pro_programacaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.pro_programacao where  pro_dt_reuniao_geral = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(pro_programacaoT.getPro_dt_reuniao_geral().getTime());
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
