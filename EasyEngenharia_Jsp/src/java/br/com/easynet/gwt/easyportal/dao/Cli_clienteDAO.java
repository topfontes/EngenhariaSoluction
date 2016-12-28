package br.com.easynet.gwt.easyportal.dao;

import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;

public class Cli_clienteDAO extends ObjectDAO {

    public Cli_clienteDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public void insert(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.cli_cliente ( cli_tx_nome, cli_tx_tipo_pessoa, cli_tx_cnpj_cpf, cli_tx_endereco, cli_tx_bairro, cli_tx_cidade, cli_tx_telefone, cli_tx_fax, cli_tx_telefone2, cli_by_logomarca, cli_tx_email, cli_tx_uf,cli_tx_inscricao_estatual, cli_tx_contato,cli_tx_celular, cli_tx_letra_orcamento_externo) values ( ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_tipo_pessoa());
            pStmt.setObject(3, cli_clienteT.getCli_tx_cnpj_cpf());
            pStmt.setObject(4, cli_clienteT.getCli_tx_endereco());
            pStmt.setObject(5, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(6, cli_clienteT.getCli_tx_cidade());
            pStmt.setObject(7, cli_clienteT.getCli_tx_telefone());
            pStmt.setObject(8, cli_clienteT.getCli_tx_fax());
            pStmt.setObject(9, cli_clienteT.getCli_tx_telefone2());
            pStmt.setObject(10, cli_clienteT.getCli_by_logomarca());
            pStmt.setObject(11, cli_clienteT.getCli_tx_email());
            pStmt.setObject(12, cli_clienteT.getCli_tx_uf());
            pStmt.setObject(13, cli_clienteT.getCli_tx_inscricao_estatual());
            pStmt.setObject(14, cli_clienteT.getCli_tx_contato());
            pStmt.setObject(15, cli_clienteT.getCli_tx_celular());
            pStmt.setObject(16, cli_clienteT.getCli_tx_letra_orcamento_externo());
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

    public void update(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.cli_cliente set  cli_tx_nome=?, cli_tx_tipo_pessoa=?, cli_tx_cnpj_cpf=?, cli_tx_endereco=?, cli_tx_bairro=?, cli_tx_cidade=?, cli_tx_telefone=?, cli_tx_fax=?, cli_tx_telefone2=?, cli_by_logomarca=?, cli_tx_email=?, cli_tx_uf=?, cli_tx_inscricao_estatual=?, cli_tx_contato=?, cli_tx_celular=?, cli_tx_letra_orcamento_externo=?  where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_tx_nome());
            pStmt.setObject(2, cli_clienteT.getCli_tx_tipo_pessoa());
            pStmt.setObject(3, cli_clienteT.getCli_tx_cnpj_cpf());
            pStmt.setObject(4, cli_clienteT.getCli_tx_endereco());
            pStmt.setObject(5, cli_clienteT.getCli_tx_bairro());
            pStmt.setObject(6, cli_clienteT.getCli_tx_cidade());
            pStmt.setObject(7, cli_clienteT.getCli_tx_telefone());
            pStmt.setObject(8, cli_clienteT.getCli_tx_fax());
            pStmt.setObject(9, cli_clienteT.getCli_tx_telefone2());
            pStmt.setObject(10, cli_clienteT.getCli_by_logomarca());
            pStmt.setObject(11, cli_clienteT.getCli_tx_email());
            pStmt.setObject(12, cli_clienteT.getCli_tx_uf());
            pStmt.setObject(13, cli_clienteT.getCli_tx_inscricao_estatual());
            pStmt.setObject(14, cli_clienteT.getCli_tx_contato());
            pStmt.setObject(15, cli_clienteT.getCli_tx_celular());
            pStmt.setObject(16, cli_clienteT.getCli_tx_letra_orcamento_externo());
            pStmt.setObject(17, cli_clienteT.getCli_nr_id());
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

    public void delete(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.cli_cliente where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
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

    private List<Cli_clienteT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_tipo_pessoa(rs.getString("cli_tx_tipo_pessoa"));
            cli_clienteT.setCli_tx_cnpj_cpf(rs.getString("cli_tx_cnpj_cpf"));
            cli_clienteT.setCli_tx_endereco(rs.getString("cli_tx_endereco"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_cidade(rs.getString("cli_tx_cidade"));
            cli_clienteT.setCli_tx_telefone(rs.getString("cli_tx_telefone"));
            cli_clienteT.setCli_tx_fax(rs.getString("cli_tx_fax"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
//            cli_clienteT.setCli_by_logomarca(rs.getBytes("cli_by_logomarca"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_inscricao_estatual(rs.getString("cli_tx_inscricao_estatual"));
            cli_clienteT.setCli_tx_contato(rs.getString("cli_tx_contato"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_letra_orcamento_externo(rs.getString("cli_tx_letra_orcamento_externo"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    private List<Cli_clienteT> resultSetToObjectTransferImage(ResultSet rs) throws Exception {
        List<Cli_clienteT> objs = new Vector();
        while (rs.next()) {
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(rs.getInt("cli_nr_id"));
            cli_clienteT.setCli_tx_nome(rs.getString("cli_tx_nome"));
            cli_clienteT.setCli_tx_tipo_pessoa(rs.getString("cli_tx_tipo_pessoa"));
            cli_clienteT.setCli_tx_cnpj_cpf(rs.getString("cli_tx_cnpj_cpf"));
            cli_clienteT.setCli_tx_endereco(rs.getString("cli_tx_endereco"));
            cli_clienteT.setCli_tx_bairro(rs.getString("cli_tx_bairro"));
            cli_clienteT.setCli_tx_cidade(rs.getString("cli_tx_cidade"));
            cli_clienteT.setCli_tx_telefone(rs.getString("cli_tx_telefone"));
            cli_clienteT.setCli_tx_fax(rs.getString("cli_tx_fax"));
            cli_clienteT.setCli_tx_telefone2(rs.getString("cli_tx_telefone2"));
            cli_clienteT.setCli_by_logomarca(rs.getBytes("cli_by_logomarca"));
            cli_clienteT.setCli_tx_email(rs.getString("cli_tx_email"));
            cli_clienteT.setCli_tx_inscricao_estatual(rs.getString("cli_tx_inscricao_estatual"));
            cli_clienteT.setCli_tx_contato(rs.getString("cli_tx_contato"));
            cli_clienteT.setCli_tx_celular(rs.getString("cli_tx_celular"));
            cli_clienteT.setCli_tx_letra_orcamento_externo(rs.getString("cli_tx_letra_orcamento_externo"));
            objs.add(cli_clienteT);
        }
        return objs;
    }

    public List<Cli_clienteT> getAll() throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente order by cli_tx_nome";
            pStmt = con.prepareStatement(sql);
            rs = pStmt.executeQuery();
            List<Cli_clienteT> list = resultSetToObjectTransfer(rs);
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

    public List<Cli_clienteT> getByPK(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  cli_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferImage(rs);
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

    public List<Cli_clienteT> getByCli_nr_id(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  cli_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_nr_id());
            rs = pStmt.executeQuery();
            return resultSetToObjectTransferImage(rs);
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

    public List<Cli_clienteT> getByCli_tx_nome(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_nome() + '%');
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

    public List<Cli_clienteT> getByCli_tx_tipo_pessoa(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_tipo_pessoa) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_tipo_pessoa() + '%');
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

    public List<Cli_clienteT> getByCli_tx_cnpj_cpf(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_cnpj_cpf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cnpj_cpf() + '%');
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

    public List<Cli_clienteT> getByCli_tx_endereco(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_endereco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_endereco() + '%');
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

    public List<Cli_clienteT> getByCli_tx_bairro(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_bairro() + '%');
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

    public List<Cli_clienteT> getByCli_tx_cidade(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_cidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_cidade() + '%');
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

    public List<Cli_clienteT> getByCli_tx_telefone(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_telefone) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_telefone() + '%');
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

    public List<Cli_clienteT> getByCli_tx_fax(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_fax) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_fax() + '%');
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

    public List<Cli_clienteT> getByCli_tx_telefone2(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_telefone2) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_telefone2() + '%');
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

    public List<Cli_clienteT> getByCli_by_logomarca(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  cli_by_logomarca = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, cli_clienteT.getCli_by_logomarca());
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

    public List<Cli_clienteT> getByCli_tx_email(Cli_clienteT cli_clienteT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.cli_cliente where  Upper(cli_tx_email) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + cli_clienteT.getCli_tx_email() + '%');
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
