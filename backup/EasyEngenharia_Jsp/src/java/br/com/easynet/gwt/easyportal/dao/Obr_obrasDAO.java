package br.com.easynet.gwt.easyportal.dao;

import java.text.ParseException;
import java.util.*;
import java.sql.*;
import br.com.easynet.database.DataSet;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.text.SimpleDateFormat;

public class Obr_obrasDAO extends ObjectDAO {

    public Obr_obrasDAO(DAOFactory dao) throws Exception {
        setDAOFactory(dao);
        con = dao.create();
    }

    public int maxId() throws Exception {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "select max(obra.obr_nr_id) as obr_nr_id from easyconstru.obr_obras as obra";
            statement = con.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();
            return rs.getInt("obr_nr_id");
        } catch (Exception e) {
            try {
                statement.close();
                rs.close();
            } catch (Exception e1) {
               
            }
        }
        return 0;

    }

    public void insert(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "insert into easyconstru.obr_obras ( obr_tx_nome, obr_tx_endereco, obr_tx_bairro, obr_tx_cidade, obr_tx_uf, emp_nr_id, obr_nr_area_construida_total, obr_dt_inicio, obr_dt_fim, obr_dt_inicio_controle, obr_dt_termino_controle, obr_nr_area_privativa_total, obr_nr_id_plc_mdo_direta, obr_nr_id_plc_mdo_indireta, obr_nr_percent_mdo_direta, obr_nr_percent_mdo_indireta,obr_nr_valor_permutado,obr_nr_valor_vgv, obr_nr_encarcos_juros_aplicacao, obr_dt_inicio_real, obr_dt_final_real) values ( ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_tx_nome());
            pStmt.setObject(2, obr_obrasT.getObr_tx_endereco());
            pStmt.setObject(3, obr_obrasT.getObr_tx_bairro());
            pStmt.setObject(4, obr_obrasT.getObr_tx_cidade());
            pStmt.setObject(5, obr_obrasT.getObr_tx_uf());
            pStmt.setObject(6, obr_obrasT.getEmp_nr_id());
            pStmt.setObject(7, obr_obrasT.getObr_nr_area_construida_total());
            java.sql.Date dt8 = new java.sql.Date(obr_obrasT.getObr_dt_inicio().getTime());
            pStmt.setObject(8, dt8);
            java.sql.Date dt9 = new java.sql.Date(obr_obrasT.getObr_dt_fim().getTime());
            pStmt.setObject(9, dt9);
            java.sql.Date dt10 = new java.sql.Date(obr_obrasT.getObr_dt_inicio_controle().getTime());
            pStmt.setObject(10, dt10);
            java.sql.Date dt11 = new java.sql.Date(obr_obrasT.getObr_dt_termino_controle().getTime());
            pStmt.setObject(11, dt11);
            pStmt.setObject(12, obr_obrasT.getObr_nr_area_privativa_total());
            pStmt.setObject(13, obr_obrasT.getObr_nr_id_plc_mdo_direta());
            pStmt.setObject(14, obr_obrasT.getObr_nr_id_plc_mdo_indireta());
            pStmt.setObject(15, obr_obrasT.getObr_nr_percent_mdo_direta());
            pStmt.setObject(16, obr_obrasT.getObr_nr_percent_mdo_indireta());
            pStmt.setObject(17, obr_obrasT.getObr_nr_valor_permutado());
            pStmt.setObject(18, obr_obrasT.getObr_nr_valor_vgv());
            pStmt.setObject(19, obr_obrasT.getObr_nr_encarcos_juros_aplicacao());
            java.sql.Date dt20 = new java.sql.Date(obr_obrasT.getObr_dt_inicio_real().getTime());
            pStmt.setObject(20, dt20);
            java.sql.Date dt21 = new java.sql.Date(obr_obrasT.getObr_dt_final_real().getTime());
            pStmt.setObject(21, dt21);
            pStmt.execute();
            int id = maxId();
            obr_obrasT.setObr_nr_id(id);
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                pStmt.close();
            } catch (Exception e) {
            }

        }
    }


//obr_nr_area_privativa_total

    public void update(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "update easyconstru.obr_obras set  obr_tx_nome=?, obr_tx_endereco=?, obr_tx_bairro=?, obr_tx_cidade=?, obr_tx_uf=?, emp_nr_id=?, obr_nr_area_construida_total=?, obr_dt_inicio=?, obr_dt_fim=?, obr_dt_inicio_controle=?, obr_dt_termino_controle=?, obr_nr_area_privativa_total=?, obr_nr_id_plc_mdo_direta=?, obr_nr_id_plc_mdo_indireta=?, obr_nr_percent_mdo_direta=?, obr_nr_percent_mdo_indireta=?,obr_nr_valor_permutado =?, obr_nr_valor_vgv=?, obr_nr_encarcos_juros_aplicacao=?,obr_dt_inicio_real=?, obr_dt_final_real=?  where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_tx_nome());
            pStmt.setObject(2, obr_obrasT.getObr_tx_endereco());
            pStmt.setObject(3, obr_obrasT.getObr_tx_bairro());
            pStmt.setObject(4, obr_obrasT.getObr_tx_cidade());
            pStmt.setObject(5, obr_obrasT.getObr_tx_uf());
            pStmt.setObject(6, obr_obrasT.getEmp_nr_id());
            pStmt.setObject(7, obr_obrasT.getObr_nr_area_construida_total());
            java.sql.Date dt8 = new java.sql.Date(obr_obrasT.getObr_dt_inicio().getTime());
            pStmt.setObject(8, dt8);
            java.sql.Date dt9 = new java.sql.Date(obr_obrasT.getObr_dt_fim().getTime());
            pStmt.setObject(9, dt9);
            java.sql.Date dt10 = new java.sql.Date(obr_obrasT.getObr_dt_inicio_controle().getTime());
            pStmt.setObject(10, dt10);
            java.sql.Date dt11 = new java.sql.Date(obr_obrasT.getObr_dt_termino_controle().getTime());
            pStmt.setObject(11, dt11);
            pStmt.setObject(12, obr_obrasT.getObr_nr_area_privativa_total());
            pStmt.setObject(13, obr_obrasT.getObr_nr_id_plc_mdo_direta());
            pStmt.setObject(14, obr_obrasT.getObr_nr_id_plc_mdo_indireta());
            pStmt.setObject(15, obr_obrasT.getObr_nr_percent_mdo_direta());
            pStmt.setObject(16, obr_obrasT.getObr_nr_percent_mdo_indireta());
            pStmt.setObject(17, obr_obrasT.getObr_nr_valor_permutado());
            pStmt.setObject(18, obr_obrasT.getObr_nr_valor_vgv());
            pStmt.setObject(19, obr_obrasT.getObr_nr_encarcos_juros_aplicacao());
            
            java.sql.Date dt20 = new java.sql.Date(obr_obrasT.getObr_dt_inicio_real().getTime());
            pStmt.setObject(20, dt20);

            java.sql.Date dt21 = new java.sql.Date(obr_obrasT.getObr_dt_final_real().getTime());
            pStmt.setObject(21, dt21);
            
            pStmt.setObject(22, obr_obrasT.getObr_nr_id());
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

    public void delete(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        try {
            String sql = "delete from easyconstru.obr_obras where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_nr_id());
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

    private List<Obr_obrasT> resultSetToObjectTransfer(ResultSet rs) throws Exception {
        List<Obr_obrasT> objs = new Vector();
        while (rs.next()) {
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(rs.getInt("obr_nr_id"));
            obr_obrasT.setObr_tx_nome(rs.getString("obr_tx_nome"));
            obr_obrasT.setObr_tx_endereco(rs.getString("obr_tx_endereco"));
            obr_obrasT.setObr_tx_bairro(rs.getString("obr_tx_bairro"));
            obr_obrasT.setObr_tx_cidade(rs.getString("obr_tx_cidade"));
            obr_obrasT.setObr_tx_uf(rs.getString("obr_tx_uf"));
            obr_obrasT.setEmp_nr_id(rs.getInt("emp_nr_id"));
            obr_obrasT.setObr_nr_area_construida_total(rs.getFloat("obr_nr_area_construida_total"));
            obr_obrasT.setObr_dt_inicio(rs.getDate("obr_dt_inicio"));
            obr_obrasT.setObr_dt_fim(rs.getDate("obr_dt_fim"));

            obr_obrasT.setObr_dt_inicio_real(rs.getDate("obr_dt_inicio_real"));
            obr_obrasT.setObr_dt_final_real(rs.getDate("obr_dt_final_real"));
 
            obr_obrasT.setObr_dt_inicio_controle(rs.getDate("obr_dt_inicio_controle"));
            obr_obrasT.setObr_dt_termino_controle(rs.getDate("obr_dt_termino_controle"));
            obr_obrasT.setObr_nr_area_privativa_total(rs.getFloat("obr_nr_area_privativa_total"));
            obr_obrasT.setObr_nr_id_plc_mdo_direta(rs.getInt("obr_nr_id_plc_mdo_direta"));
            obr_obrasT.setObr_nr_id_plc_mdo_indireta(rs.getInt("obr_nr_id_plc_mdo_indireta"));
            obr_obrasT.setObr_nr_percent_mdo_direta(rs.getFloat("obr_nr_percent_mdo_direta"));
            obr_obrasT.setObr_nr_percent_mdo_indireta(rs.getFloat("obr_nr_percent_mdo_indireta"));
            obr_obrasT.setObr_nr_valor_permutado(rs.getFloat("obr_nr_valor_permutado"));
            obr_obrasT.setObr_nr_valor_vgv(rs.getFloat("obr_nr_valor_vgv"));
            obr_obrasT.setObr_nr_encarcos_juros_aplicacao(rs.getFloat("obr_nr_encarcos_juros_aplicacao"));
            objs.add(obr_obrasT);
        }
        return objs;
    }
//20118309587

    public int getSequenciaMesAno(Obr_obrasT obr_obrasT, int mesRef, int anoRef) throws Exception {
        int sequencia = 0;
        try {
            int contador = 0;
            List<Meo_meses_obraT> list = getAllMeses(obr_obrasT);
            for (Meo_meses_obraT meses_obraT : list) {
                contador++;
                if (meses_obraT.getMes() == mesRef & meses_obraT.getAno() == anoRef) {
                    sequencia = contador;
                    break;
                }
            }

        } catch (Exception e) {
            throw e;
        }
        return sequencia;
    }


    public List<Meo_meses_obraT> getAllMeses(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_nr_id());
            rs = pStmt.executeQuery();
            List<Obr_obrasT> list = resultSetToObjectTransfer(rs);
            SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
            SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
            int mesIni = Integer.parseInt(sdfMes.format(list.get(0).getObr_dt_inicio_controle()));
            int anoIni = Integer.parseInt(sdfAno.format(list.get(0).getObr_dt_inicio_controle()));
            int mesFim = Integer.parseInt(sdfMes.format(list.get(0).getObr_dt_termino_controle()));
            int anoFim = Integer.parseInt(sdfAno.format(list.get(0).getObr_dt_termino_controle()));
            List<Meo_meses_obraT> listMeo = new ArrayList<Meo_meses_obraT>();

            Meo_meses_obraT meo_meses_obraT;//= new Meo_meses_obraT();

            for (int ano = anoIni; ano < (anoFim + 1); ano++) {
                int mesIniAno = ano == anoIni ? mesIni : 1;
                boolean mesValido = true;
                for (int mes = mesIniAno; mes < 13 & mesValido; mes++) {

                    mesValido = false;
                    if (ano < anoFim) {
                        mesValido = true;
                    } else if (ano == anoFim) {
                        if (mes <= mesFim) {
                            mesValido = true;
                        }
                    }

                    if (mesValido) {
                        meo_meses_obraT = new Meo_meses_obraT();
                        meo_meses_obraT.setAno(ano);
                        meo_meses_obraT.setMes(mes);
                        meo_meses_obraT.setQuantidade(0);
                        meo_meses_obraT.setMes_ano(getStrMesAno(mes, ano));
                        listMeo.add(meo_meses_obraT);
                    }
                }
            }

            return listMeo;

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
    //30410945.

    public List<Meo_meses_obraT> getAddMeses(int mesIni, int anoIni, int mesFim, int anoFim) {

        List<Meo_meses_obraT> listMeo = new ArrayList<Meo_meses_obraT>();
        Meo_meses_obraT meo_meses_obraT;
        for (int ano = anoIni; ano < (anoFim + 1); ano++) {
            int mesIniAno = ano == anoIni ? mesIni : 1;
            boolean mesValido = true;
            for (int mes = mesIniAno; mes < 13 & mesValido; mes++) {
                mesValido = false;
                if (ano < anoFim) {
                    mesValido = true;
                } else if (ano == anoFim) {
                    if (mes <= mesFim) {
                        mesValido = true;
                    }
                }
                if (mesValido) {
                    meo_meses_obraT = new Meo_meses_obraT();
                    meo_meses_obraT.setAno(ano);
                    meo_meses_obraT.setMes(mes);
                    meo_meses_obraT.setQuantidade(0);
                    meo_meses_obraT.setMes_ano(getStrMesAno(mes, ano));
                    listMeo.add(meo_meses_obraT);
                }
            }
        }
        return listMeo;
    }

    public String getStrMesAno(int mes, int ano) {
        String mesAno = "";
        switch (mes) {
            case 1: {
                mesAno = "Jan/" + ano;
                break;
            }
            case 2: {
                mesAno = "Fev/" + ano;
                break;
            }
            case 3: {
                mesAno = "Mar/" + ano;
                break;
            }
            case 4: {
                mesAno = "Abr/" + ano;
                break;
            }
            case 5: {
                mesAno = "Mai/" + ano;
                break;
            }
            case 6: {
                mesAno = "Jun/" + ano;
                break;
            }
            case 7: {
                mesAno = "Jul/" + ano;
                break;
            }
            case 8: {
                mesAno = "Ago/" + ano;
                break;
            }
            case 9: {
                mesAno = "Set/" + ano;
                break;
            }
            case 10: {
                mesAno = "Out/" + ano;
                break;
            }
            case 11: {
                mesAno = "Nov/" + ano;
                break;
            }
            case 12: {
                mesAno = "Dez/" + ano;
                break;
            }
        }
        return mesAno;
    }

    public DataSet getAll() throws Exception {
        try {
            DataSet ds = new DataSet();
            StringBuffer sql = new StringBuffer();
            sql.append("select obra.obr_nr_id,obra.obr_tx_nome, obra.obr_tx_endereco,obra.obr_tx_bairro,obra.obr_tx_cidade,obra.obr_tx_uf, obra.emp_nr_id,obra.obr_nr_area_construida_total,");
            sql.append(" obra.obr_dt_inicio, obra.obr_dt_fim, obra.obr_dt_inicio_controle,obra.obr_dt_termino_controle,");
            sql.append(" emp.emp_tx_nome, obra.obr_nr_area_privativa_total, obra.obr_nr_id_plc_mdo_direta, obra.obr_nr_id_plc_mdo_indireta, obra.obr_nr_percent_mdo_direta, obra.obr_nr_percent_mdo_indireta, obra.obr_nr_valor_permutado, obra.obr_nr_valor_vgv, obr_nr_encarcos_juros_aplicacao, obr_dt_inicio_real, obr_dt_final_real from easyconstru.obr_obras obra inner join easyconstru.emp_empreendimento as emp on(obra.emp_nr_id = emp.emp_nr_id)");
            sql.append(" order by obra.obr_tx_nome");
            ds = executeQuery(sql.toString(), null);
            return ds;

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                ;
            } catch (Exception e) {
            }

        }
    }

    public List<Obr_obrasT> getByPK(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_nr_id=?";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_nr_id());
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

    public List<Obr_obrasT> getByObr_nr_id(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_nr_id());
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

    public List<Obr_obrasT> getByObr_tx_nome(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  Upper(obr_tx_nome) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + obr_obrasT.getObr_tx_nome() + '%');
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

    public List<Obr_obrasT> getByObr_tx_endereco(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  Upper(obr_tx_endereco) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + obr_obrasT.getObr_tx_endereco() + '%');
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

    public List<Obr_obrasT> getByObr_tx_bairro(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  Upper(obr_tx_bairro) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + obr_obrasT.getObr_tx_bairro() + '%');
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

    public List<Obr_obrasT> getByObr_tx_cidade(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  Upper(obr_tx_cidade) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + obr_obrasT.getObr_tx_cidade() + '%');
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

    public List<Obr_obrasT> getByObr_tx_uf(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  Upper(obr_tx_uf) like Upper(?) ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, '%' + obr_obrasT.getObr_tx_uf() + '%');
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

    public List<Obr_obrasT> getByEmp_nr_id(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  emp_nr_id = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getEmp_nr_id());
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

    public List<Obr_obrasT> getByObr_nr_area_construida_total(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_nr_area_construida_total = ? ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getObr_nr_area_construida_total());
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

    public List<Obr_obrasT> getByObr_dt_inicio(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_dt_inicio = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(obr_obrasT.getObr_dt_inicio().getTime());
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

    public List<Obr_obrasT> getByObr_dt_fim(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_dt_fim = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(obr_obrasT.getObr_dt_fim().getTime());
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

    public List<Obr_obrasT> getByObr_dt_inicio_controle(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_dt_inicio_controle = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(obr_obrasT.getObr_dt_inicio_controle().getTime());
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

    public List<Obr_obrasT> getByObr_dt_termino_controle(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where  obr_dt_termino_controle = ? ";
            pStmt = con.prepareStatement(sql);
            java.sql.Date dt1 = new java.sql.Date(obr_obrasT.getObr_dt_termino_controle().getTime());
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

    /** M�todos FK */
    public List<Obr_obrasT> getByEmp_empreendimento(Obr_obrasT obr_obrasT) throws Exception {
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from easyconstru.obr_obras where emp_empreendimento.emp_nr_id=?  ";
            pStmt = con.prepareStatement(sql);
            pStmt.setObject(1, obr_obrasT.getEmp_nr_id());
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
