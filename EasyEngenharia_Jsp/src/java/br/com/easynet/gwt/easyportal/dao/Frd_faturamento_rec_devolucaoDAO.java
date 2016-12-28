package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Frd_faturamento_rec_devolucaoDAO extends ObjectDAO {

    public Frd_faturamento_rec_devolucaoDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.frd_faturamento_rec_devolucao  ( frd_nr_valor_permutado, frd_nr_vgv, frd_nr_valor_devolucao, frd_nr_valor_faturamento, frd_nr_valor_recebimento, frd_nr_valor_permutas, obr_nr_id, frd_nr_mes, frd_nr_ano) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutado());
            pStmt.setObject(2, frd_faturamento_rec_devolucaoT.getFrd_nr_vgv());
            pStmt.setObject(3, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_devolucao());
            pStmt.setObject(4, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_faturamento());
            pStmt.setObject(5, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_recebimento());
            pStmt.setObject(6, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutas());
            pStmt.setObject(7, frd_faturamento_rec_devolucaoT.getObr_nr_id());
            pStmt.setObject(8, frd_faturamento_rec_devolucaoT.getFrd_nr_mes());
            pStmt.setObject(9, frd_faturamento_rec_devolucaoT.getFrd_nr_ano());
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

    public void update(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.frd_faturamento_rec_devolucao set  frd_nr_valor_permutado=?, frd_nr_vgv=?, frd_nr_valor_devolucao=?, frd_nr_valor_faturamento=?, frd_nr_valor_recebimento=?, frd_nr_valor_permutas=?, obr_nr_id=?, frd_nr_mes=?, frd_nr_ano=?  where  frd_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutado());
            pStmt.setObject(2, frd_faturamento_rec_devolucaoT.getFrd_nr_vgv());
            pStmt.setObject(3, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_devolucao());
            pStmt.setObject(4, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_faturamento());
            pStmt.setObject(5, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_recebimento());
            pStmt.setObject(6, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutas());
            pStmt.setObject(7, frd_faturamento_rec_devolucaoT.getObr_nr_id());
            pStmt.setObject(8, frd_faturamento_rec_devolucaoT.getFrd_nr_mes());
            pStmt.setObject(9, frd_faturamento_rec_devolucaoT.getFrd_nr_ano());
            pStmt.setObject(10, frd_faturamento_rec_devolucaoT.getFrd_nr_id());
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

    public void delete(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_id());
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

    private List<Frd_faturamento_rec_devolucaoT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Frd_faturamento_rec_devolucaoT> objs = new Vector();
        while (rs.next()) {
            Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT = new Frd_faturamento_rec_devolucaoT();
            frd_faturamento_rec_devolucaoT.setFrd_nr_id(rs.getInt("frd_nr_id"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_valor_permutado(rs.getFloat("frd_nr_valor_permutado"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_vgv(rs.getFloat("frd_nr_vgv"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_valor_devolucao(rs.getFloat("frd_nr_valor_devolucao"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_valor_faturamento(rs.getFloat("frd_nr_valor_faturamento"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_valor_recebimento(rs.getFloat("frd_nr_valor_recebimento"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_valor_permutas(rs.getFloat("frd_nr_valor_permutas"));
            frd_faturamento_rec_devolucaoT.setObr_nr_id(rs.getInt("obr_nr_id"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_mes(rs.getInt("frd_nr_mes"));
            frd_faturamento_rec_devolucaoT.setFrd_nr_ano(rs.getInt("frd_nr_ano"));
            objs.add(frd_faturamento_rec_devolucaoT);
        }
        return objs;
    }

    public List<Frd_faturamento_rec_devolucaoT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Frd_faturamento_rec_devolucaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Frd_faturamento_rec_devolucaoT> getObraMesAno(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where obr_nr_id=? and frd_nr_mes =? and frd_nr_ano=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getObr_nr_id());
            pStmt.setObject(2, frd_faturamento_rec_devolucaoT.getFrd_nr_mes());
            pStmt.setObject(3, frd_faturamento_rec_devolucaoT.getFrd_nr_ano());
            rs = pStmt.executeQuery();
            List<Frd_faturamento_rec_devolucaoT> list = resultSetToObjectTransfer(rs);
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

    public List<Frd_faturamento_rec_devolucaoT> getByPK(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_id());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_id(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_id());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_valor_permutado(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_valor_permutado = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutado());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_vgv(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_vgv = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_vgv());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_valor_devolucao(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_valor_devolucao = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_devolucao());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_valor_faturamento(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_valor_faturamento = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_faturamento());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_valor_recebimento(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_valor_recebimento = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_recebimento());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_valor_permutas(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_valor_permutas = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_valor_permutas());
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

    public List<Frd_faturamento_rec_devolucaoT> getByObr_nr_id(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getObr_nr_id());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_mes(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_mes = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_mes());
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

    public List<Frd_faturamento_rec_devolucaoT> getByFrd_nr_ano(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  frd_nr_ano = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getFrd_nr_ano());
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
    public List<Frd_faturamento_rec_devolucaoT> getAllObraMesAnoRef(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.frd_faturamento_rec_devolucao where  obr_nr_id = ? and frd_nr_mes =? and frd_nr_ano =?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, frd_faturamento_rec_devolucaoT.getObr_nr_id());
            pStmt.setObject(2, frd_faturamento_rec_devolucaoT.getFrd_nr_mes());
            pStmt.setObject(3, frd_faturamento_rec_devolucaoT.getFrd_nr_ano());
            rs = pStmt.executeQuery();
            List<Frd_faturamento_rec_devolucaoT> list = resultSetToObjectTransfer(rs);
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
