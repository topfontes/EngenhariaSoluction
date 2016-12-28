package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.*;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.util.List;
import br.com.easynet.easyportal.jb.EasySecurityJB;
import br.com.easynet.gwt.easyportal.client.dao.Vw_cffo_mesDAO;
import br.com.easynet.gwt.easyportal.client.transfer.Vw_cffo_mesT;
import java.sql.PreparedStatement;
import java.util.Locale;
import java.util.TimeZone;
import javax.sql.DataSource;

public class SystemBase extends EasySecurityJB {

    private int typeDatabase = DAOFactory.POSTGRESQL;
//    private String url = "jdbc:postgresql://web10.eti.br:5432/dbengenharia";
//    private String user = "marcos";
//    private String pass = "topfontes";
    private DAOFactory dao;
    //private String datasourceName = "java:comp/env/jdbc/aplicacaods";
    //private String datasourceName = "java:comp/env/jdbc/NOME_CONEXAO";
    private String datasourceName = "java:comp/env/jdbc/engenhariads";
    public final String PATH_WEB = "/tmp/";
//    public final String PATH_WEB = "/home/bcengcustos/engenharia";
    public final String PATH_LOCAL = "C:/temp/";

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        Locale.setDefault(new Locale("pt", "BR"));
        getResponse().setCharacterEncoding("UTF-8");
        TimeZone tz = TimeZone.getTimeZone("GMT-3");
        TimeZone.setDefault(tz);
    }

    private void configureByteaPostgresql() {
        PreparedStatement ps = null;
        try {
            dao.create();
            ps = dao.getConnection().prepareStatement("SET bytea_output = 'escape'");
            ps.execute();
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (Exception e) {
            }
        }
    }

    public DAOFactory getDAO() throws Exception {
        if (dao != null && dao.getConnection() != null && !dao.getConnection().isClosed()) {
            return dao;
        }
        try {
            String dsName = getApplication().getInitParameter("datasource_name");
            if (dsName != null) {
                datasourceName = dsName;
            }
            DataSource ds = getDataSource(datasourceName);
            dao = DAOFactory.getDAOFactory(typeDatabase, ds.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            configureByteaPostgresql();
        }
        return dao;
    }

    public DAOFactory getDAO(int typeDatabase, String url, String user, String pass) throws Exception {
        String urlWebConfig = getApplication().getInitParameter("urljdbc");
        String userWebConfig = getApplication().getInitParameter("userjdbc");
        String passwordWebConfig = getApplication().getInitParameter("passwordjdbc");
        if (urlWebConfig != null) {
            url = urlWebConfig;
            user = userWebConfig;
            pass = passwordWebConfig;
        }
        if (dao != null) {
            return dao;
        }
        dao = DAOFactory.getDAOFactory(typeDatabase, url, user, pass);
        configureByteaPostgresql();
        return dao;
    }

    public void close() {
        try {
            dao.close();
            dao = null;
        } catch (Exception e) {
        }
    }

    public Cen_centro_custoDAO getCen_centro_custoDAO() throws Exception {
        dao = getDAO();
        return new Cen_centro_custoDAO(dao);
    }

    public Cli_clienteDAO getCli_clienteDAO() throws Exception {
        dao = getDAO();
        return new Cli_clienteDAO(dao);
    }

    public Con_contatosDAO getCon_contatosDAO() throws Exception {
        dao = getDAO();
        return new Con_contatosDAO(dao);
    }

    public Emp_empreendimentoDAO getEmp_empreendimentoDAO() throws Exception {
        dao = getDAO();
        return new Emp_empreendimentoDAO(dao);
    }

    public Fop_forma_pagamentoDAO getFop_forma_pagamentoDAO() throws Exception {
        dao = getDAO();
        return new Fop_forma_pagamentoDAO(dao);
    }

    public For_fornecedorDAO getFor_fornecedorDAO() throws Exception {
        dao = getDAO();
        return new For_fornecedorDAO(dao);
    }

    public Grp_grupo_produtoDAO getGrp_grupo_produtoDAO() throws Exception {
        dao = getDAO();
        return new Grp_grupo_produtoDAO(dao);
    }

    public Infe_item_nota_entradaDAO getInfe_item_nota_entradaDAO() throws Exception {
        dao = getDAO();
        return new Infe_item_nota_entradaDAO(dao);
    }

    public Nfe_nota_fiscal_entradaDAO getNfe_nota_fiscal_entradaDAO() throws Exception {
        dao = getDAO();
        return new Nfe_nota_fiscal_entradaDAO(dao);
    }

    public Obr_obrasDAO getObr_obrasDAO() throws Exception {
        dao = getDAO();
        return new Obr_obrasDAO(dao);
    }

    public Par_parcelamentoDAO getPar_parcelamentoDAO() throws Exception {
        dao = getDAO();
        return new Par_parcelamentoDAO(dao);
    }

    public Plc_plano_contasDAO getPlc_plano_contasDAO() throws Exception {
        dao = getDAO();
        return new Plc_plano_contasDAO(dao);
    }

    public Pro_produtoDAO getPro_produtoDAO() throws Exception {
        dao = getDAO();
        return new Pro_produtoDAO(dao);
    }

    public Set_setorDAO getSet_setorDAO() throws Exception {
        dao = getDAO();
        return new Set_setorDAO(dao);
    }

    public Uno_unidade_obraDAO getUno_unidade_obraDAO() throws Exception {
        dao = getDAO();
        return new Uno_unidade_obraDAO(dao);
    }

    public Cli_clienteT findbyIdCli_cliente(Cli_clienteT cli_clienteT) throws Exception {
        try {
            Cli_clienteDAO cli_clienteDAO = getCli_clienteDAO();

            List<Cli_clienteT> listTemp = cli_clienteDAO.getByPK(cli_clienteT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Con_contatosT findbyIdCon_contatos(Con_contatosT con_contatosT) throws Exception {
        try {
            Con_contatosDAO con_contatosDAO = getCon_contatosDAO();

            List<Con_contatosT> listTemp = con_contatosDAO.getByPK(con_contatosT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Emp_empreendimentoT findbyIdEmp_empreendimento(Emp_empreendimentoT emp_empreendimentoT) throws Exception {
        try {
            Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();

            List<Emp_empreendimentoT> listTemp = emp_empreendimentoDAO.getByPK(emp_empreendimentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Fop_forma_pagamentoT findbyIdFop_forma_pagamento(Fop_forma_pagamentoT fop_forma_pagamentoT) throws Exception {
        try {
            Fop_forma_pagamentoDAO fop_forma_pagamentoDAO = getFop_forma_pagamentoDAO();

            List<Fop_forma_pagamentoT> listTemp = fop_forma_pagamentoDAO.getByPK(fop_forma_pagamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public For_fornecedorT findbyIdFor_fornecedor(For_fornecedorT for_fornecedorT) throws Exception {
        try {
            For_fornecedorDAO for_fornecedorDAO = getFor_fornecedorDAO();

            List<For_fornecedorT> listTemp = for_fornecedorDAO.getByPK(for_fornecedorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Grp_grupo_produtoT findbyIdGrp_grupo_produto(Grp_grupo_produtoT grp_grupo_produtoT) throws Exception {
        try {
            Grp_grupo_produtoDAO grp_grupo_produtoDAO = getGrp_grupo_produtoDAO();

            List<Grp_grupo_produtoT> listTemp = grp_grupo_produtoDAO.getByPK(grp_grupo_produtoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Infe_item_nota_entradaT findbyIdInfe_item_nota_entrada(Infe_item_nota_entradaT infe_item_nota_entradaT) throws Exception {
        try {
            Infe_item_nota_entradaDAO infe_item_nota_entradaDAO = getInfe_item_nota_entradaDAO();

            List<Infe_item_nota_entradaT> listTemp = infe_item_nota_entradaDAO.getByPK(infe_item_nota_entradaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Nfe_nota_fiscal_entradaT findbyIdNfe_nota_fiscal_entrada(Nfe_nota_fiscal_entradaT nfe_nota_fiscal_entradaT) throws Exception {
        try {
            Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();

            List<Nfe_nota_fiscal_entradaT> listTemp = nfe_nota_fiscal_entradaDAO.getByPK(nfe_nota_fiscal_entradaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Obr_obrasT findbyIdObr_obras(Obr_obrasT obr_obrasT) throws Exception {
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();

            List<Obr_obrasT> listTemp = obr_obrasDAO.getByPK(obr_obrasT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Par_parcelamentoT findbyIdPar_parcelamento(Par_parcelamentoT par_parcelamentoT) throws Exception {
        try {
            Par_parcelamentoDAO par_parcelamentoDAO = getPar_parcelamentoDAO();

            List<Par_parcelamentoT> listTemp = par_parcelamentoDAO.getByPK(par_parcelamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plc_plano_contasT findbyIdPlc_plano_contas(Plc_plano_contasT plc_plano_contasT) throws Exception {
        try {
            Plc_plano_contasDAO plc_plano_contasDAO = getPlc_plano_contasDAO();

            List<Plc_plano_contasT> listTemp = plc_plano_contasDAO.getByPK(plc_plano_contasT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pro_produtoT findbyIdPro_produto(Pro_produtoT pro_produtoT) throws Exception {
        try {
            Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();

            List<Pro_produtoT> listTemp = pro_produtoDAO.getByPK(pro_produtoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Set_setorT findbyIdSet_setor(Set_setorT set_setorT) throws Exception {
        try {
            Set_setorDAO set_setorDAO = getSet_setorDAO();

            List<Set_setorT> listTemp = set_setorDAO.getByPK(set_setorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Uno_unidade_obraT findbyIdUno_unidade_obra(Uno_unidade_obraT uno_unidade_obraT) throws Exception {
        try {
            Uno_unidade_obraDAO uno_unidade_obraDAO = getUno_unidade_obraDAO();

            List<Uno_unidade_obraT> listTemp = uno_unidade_obraDAO.getByPK(uno_unidade_obraT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Uni_unidadeDAO getUni_unidadeDAO() throws Exception {
        dao = getDAO();
        return new Uni_unidadeDAO(dao);
    }

    public Est_estoqueDAO getEst_estoqueDAO() throws Exception {
        dao = getDAO();
        return new Est_estoqueDAO(dao);
    }

    public Ctp_conta_pagarDAO getCtp_conta_pagarDAO() throws Exception {
        dao = getDAO();
        return new Ctp_conta_pagarDAO(dao);
    }

    public Uni_unidadeT findbyIdUni_unidade(Uni_unidadeT uni_unidadeT) throws Exception {
        try {
            Uni_unidadeDAO uni_unidadeDAO = getUni_unidadeDAO();

            List<Uni_unidadeT> listTemp = uni_unidadeDAO.getByPK(uni_unidadeT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Est_estoqueT findbyIdEst_estoque(Est_estoqueT est_estoqueT) throws Exception {
        try {
            Est_estoqueDAO est_estoqueDAO = getEst_estoqueDAO();

            List<Est_estoqueT> listTemp = est_estoqueDAO.getByPK(est_estoqueT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ctp_conta_pagarT findbyIdCtp_conta_pagar(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            Ctp_conta_pagarDAO ctp_conta_pagarDAO = getCtp_conta_pagarDAO();

            List<Ctp_conta_pagarT> listTemp = ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ume_unidade_medidaDAO getUme_unidade_medidaDAO() throws Exception {
        dao = getDAO();
        return new Ume_unidade_medidaDAO(dao);
    }

    public Ume_unidade_medidaT findbyIdUme_unidade_medida(Ume_unidade_medidaT ume_unidade_medidaT) throws Exception {
        try {
            Ume_unidade_medidaDAO ume_unidade_medidaDAO = getUme_unidade_medidaDAO();

            List<Ume_unidade_medidaT> listTemp = ume_unidade_medidaDAO.getByPK(ume_unidade_medidaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Eplc_equivalencia_plano_contasDAO getEplc_equivalencia_plano_contasDAO() throws Exception {
        dao = getDAO();
        return new Eplc_equivalencia_plano_contasDAO(dao);
    }

    public Ipo_item_plano_contas_obraDAO getIpo_item_plano_contas_obraDAO() throws Exception {
        dao = getDAO();
        return new Ipo_item_plano_contas_obraDAO(dao);
    }

    public Plco_plano_contas_orcamentoDAO getPlco_plano_contas_orcamentoDAO() throws Exception {
        dao = getDAO();
        return new Plco_plano_contas_orcamentoDAO(dao);
    }

    public Eplc_equivalencia_plano_contasT findbyIdEplc_equivalencia_plano_contas(Eplc_equivalencia_plano_contasT eplc_equivalencia_plano_contasT) throws Exception {
        try {
            Eplc_equivalencia_plano_contasDAO eplc_equivalencia_plano_contasDAO = getEplc_equivalencia_plano_contasDAO();

            List<Eplc_equivalencia_plano_contasT> listTemp = eplc_equivalencia_plano_contasDAO.getByPK(eplc_equivalencia_plano_contasT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ipo_item_plano_contas_obraT findbyIdIpo_item_plano_contas_obra(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) throws Exception {
        try {
            Ipo_item_plano_contas_obraDAO ipo_item_plano_contas_obraDAO = getIpo_item_plano_contas_obraDAO();

            List<Ipo_item_plano_contas_obraT> listTemp = ipo_item_plano_contas_obraDAO.getByPK(ipo_item_plano_contas_obraT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plco_plano_contas_orcamentoT findbyIdPlco_plano_contas_orcamento(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO plco_plano_contas_orcamentoDAO = getPlco_plano_contas_orcamentoDAO();

            List<Plco_plano_contas_orcamentoT> listTemp = plco_plano_contas_orcamentoDAO.getByPK(plco_plano_contas_orcamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tet_tmp_equivalencia_treetDAO getTet_tmp_equivalencia_treetDAO() throws Exception {
        dao = getDAO();
        return new Tet_tmp_equivalencia_treetDAO(dao);
    }

    public Tet_tmp_equivalencia_treetT findbyIdTet_tmp_equivalencia_treet(Tet_tmp_equivalencia_treetT tet_tmp_equivalencia_treetT) throws Exception {
        try {
            Tet_tmp_equivalencia_treetDAO tet_tmp_equivalencia_treetDAO = getTet_tmp_equivalencia_treetDAO();

            List<Tet_tmp_equivalencia_treetT> listTemp = tet_tmp_equivalencia_treetDAO.getByPK(tet_tmp_equivalencia_treetT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_equivalenciaDAO getVw_equivalenciaDAO() throws Exception {
        dao = getDAO();
        return new Vw_equivalenciaDAO(dao);
    }

    public Vw_equivalenciaT findbyIdVw_equivalencia(Vw_equivalenciaT vw_equivalenciaT) throws Exception {
        try {
            Vw_equivalenciaDAO vw_equivalenciaDAO = getVw_equivalenciaDAO();

            List<Vw_equivalenciaT> listTemp = vw_equivalenciaDAO.getByPK(vw_equivalenciaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_importacao_orcamentoDAO getVw_importacao_orcamentoDAO() throws Exception {
        dao = getDAO();
        return new Vw_importacao_orcamentoDAO(dao);
    }

    public Vw_importacao_orcamentoT findbyIdVw_importacao_orcamento(Vw_importacao_orcamentoT vw_importacao_orcamentoT) throws Exception {
        try {
            Vw_importacao_orcamentoDAO vw_importacao_orcamentoDAO = getVw_importacao_orcamentoDAO();

            List<Vw_importacao_orcamentoT> listTemp = vw_importacao_orcamentoDAO.getByPK(vw_importacao_orcamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_curva_abcDAO getVw_curva_abcDAO() throws Exception {
        dao = getDAO();
        return new Vw_curva_abcDAO(dao);
    }

    public Vw_curva_abcT findbyIdVw_curva_abc(Vw_curva_abcT vw_curva_abcT) throws Exception {
        try {
            Vw_curva_abcDAO vw_curva_abcDAO = getVw_curva_abcDAO();

            List<Vw_curva_abcT> listTemp = vw_curva_abcDAO.getByPK(vw_curva_abcT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Tpms_temporaria_pmsDAO getTpms_temporaria_pmsDAO() throws Exception {
        dao = getDAO();
        return new Tpms_temporaria_pmsDAO(dao);
    }

    public Pms_planilha_medicao_servicoDAO getPms_planilha_medicao_servicoDAO() throws Exception {
        dao = getDAO();
        return new Pms_planilha_medicao_servicoDAO(dao);
    }

    public Cffo_cronograma_fisico_financeiro_origenalDAO getCffo_cronograma_fisico_financeiro_origenalDAO() throws Exception {
        dao = getDAO();
        return new Cffo_cronograma_fisico_financeiro_origenalDAO(dao);
    }

    public Tpms_temporaria_pmsT findbyIdTpms_temporaria_pms(Tpms_temporaria_pmsT tpms_temporaria_pmsT) throws Exception {
        try {
            Tpms_temporaria_pmsDAO tpms_temporaria_pmsDAO = getTpms_temporaria_pmsDAO();

            List<Tpms_temporaria_pmsT> listTemp = tpms_temporaria_pmsDAO.getByPK(tpms_temporaria_pmsT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pms_planilha_medicao_servicoT findbyIdPms_planilha_medicao_servico(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) throws Exception {
        try {
            Pms_planilha_medicao_servicoDAO pms_planilha_medicao_servicoDAO = getPms_planilha_medicao_servicoDAO();

            List<Pms_planilha_medicao_servicoT> listTemp = pms_planilha_medicao_servicoDAO.getByPK(pms_planilha_medicao_servicoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Cffo_cronograma_fisico_financeiro_origenalT findbyIdCffo_cronograma_fisico_financeiro_origenal(Cffo_cronograma_fisico_financeiro_origenalT cffo_cronograma_fisico_financeiro_origenalT) throws Exception {
        try {
            Cffo_cronograma_fisico_financeiro_origenalDAO cffo_cronograma_fisico_financeiro_origenalDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();

            List<Cffo_cronograma_fisico_financeiro_origenalT> listTemp = cffo_cronograma_fisico_financeiro_origenalDAO.getByPK(cffo_cronograma_fisico_financeiro_origenalT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ccff_copia_cronograma_fisico_financeiroDAO getCcff_copia_cronograma_fisico_financeiroDAO() throws Exception {
        dao = getDAO();
        return new Ccff_copia_cronograma_fisico_financeiroDAO(dao);
    }

    public Ccff_copia_cronograma_fisico_financeiroT findbyIdCcff_copia_cronograma_fisico_financeiro(Ccff_copia_cronograma_fisico_financeiroT ccff_copia_cronograma_fisico_financeiroT) throws Exception {
        try {
            Ccff_copia_cronograma_fisico_financeiroDAO ccff_copia_cronograma_fisico_financeiroDAO = getCcff_copia_cronograma_fisico_financeiroDAO();

            List<Ccff_copia_cronograma_fisico_financeiroT> listTemp = ccff_copia_cronograma_fisico_financeiroDAO.getByPK(ccff_copia_cronograma_fisico_financeiroT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_curva_abc_equivalenciaDAO getVw_curva_abc_equivalenciaDAO() throws Exception {
        dao = getDAO();
        return new Vw_curva_abc_equivalenciaDAO(dao);
    }

    public Vw_curva_abc_equivalenciaT findbyIdVw_curva_abc_equivalencia(Vw_curva_abc_equivalenciaT vw_curva_abc_equivalenciaT) throws Exception {
        try {
            Vw_curva_abc_equivalenciaDAO vw_curva_abc_equivalenciaDAO = getVw_curva_abc_equivalenciaDAO();

            List<Vw_curva_abc_equivalenciaT> listTemp = vw_curva_abc_equivalenciaDAO.getByPK(vw_curva_abc_equivalenciaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pao_parcelamento_obraDAO getPao_parcelamento_obraDAO() throws Exception {
        dao = getDAO();
        return new Pao_parcelamento_obraDAO(dao);
    }

    public Pao_parcelamento_obraT findbyIdPao_parcelamento_obra(Pao_parcelamento_obraT pao_parcelamento_obraT) throws Exception {
        try {
            Pao_parcelamento_obraDAO pao_parcelamento_obraDAO = getPao_parcelamento_obraDAO();

            List<Pao_parcelamento_obraT> listTemp = pao_parcelamento_obraDAO.getByPK(pao_parcelamento_obraT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Inp_intervalo_parcelaDAO getInp_intervalo_parcelaDAO() throws Exception {
        dao = getDAO();
        return new Inp_intervalo_parcelaDAO(dao);
    }

    public Inp_intervalo_parcelaT findbyIdInp_intervalo_parcela(Inp_intervalo_parcelaT inp_intervalo_parcelaT) throws Exception {
        try {
            Inp_intervalo_parcelaDAO inp_intervalo_parcelaDAO = getInp_intervalo_parcelaDAO();

            List<Inp_intervalo_parcelaT> listTemp = inp_intervalo_parcelaDAO.getByPK(inp_intervalo_parcelaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_maximo_dias_parcela_plcDAO getVw_maximo_dias_parcela_plcDAO() throws Exception {
        dao = getDAO();
        return new Vw_maximo_dias_parcela_plcDAO(dao);
    }

    public Vw_maximo_mes_ccff_digitadoDAO getVw_maximo_mes_ccff_digitadoDAO() throws Exception {
        dao = getDAO();
        return new Vw_maximo_mes_ccff_digitadoDAO(dao);
    }

    public Vw_maximo_dias_parcela_plcT findbyIdVw_maximo_dias_parcela_plc(Vw_maximo_dias_parcela_plcT vw_maximo_dias_parcela_plcT) throws Exception {
        try {
            Vw_maximo_dias_parcela_plcDAO vw_maximo_dias_parcela_plcDAO = getVw_maximo_dias_parcela_plcDAO();

            List<Vw_maximo_dias_parcela_plcT> listTemp = vw_maximo_dias_parcela_plcDAO.getByPK(vw_maximo_dias_parcela_plcT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_maximo_mes_ccff_digitadoT findbyIdVw_maximo_mes_ccff_digitado(Vw_maximo_mes_ccff_digitadoT vw_maximo_mes_ccff_digitadoT) throws Exception {
        try {
            Vw_maximo_mes_ccff_digitadoDAO vw_maximo_mes_ccff_digitadoDAO = getVw_maximo_mes_ccff_digitadoDAO();

            List<Vw_maximo_mes_ccff_digitadoT> listTemp = vw_maximo_mes_ccff_digitadoDAO.getByPK(vw_maximo_mes_ccff_digitadoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Com_comprometimentoDAO getCom_comprometimentoDAO() throws Exception {
        dao = getDAO();
        return new Com_comprometimentoDAO(dao);
    }

    public Com_comprometimentoT findbyIdCom_comprometimento(Com_comprometimentoT com_comprometimentoT) throws Exception {
        try {
            Com_comprometimentoDAO com_comprometimentoDAO = getCom_comprometimentoDAO();

            List<Com_comprometimentoT> listTemp = com_comprometimentoDAO.getByPK(com_comprometimentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_comprometimentoDAO getVw_comprometimentoDAO() throws Exception {
        dao = getDAO();
        return new Vw_comprometimentoDAO(dao);
    }

    public Vw_comprometimentoT findbyIdVw_comprometimento(Vw_comprometimentoT vw_comprometimentoT) throws Exception {
        try {
            Vw_comprometimentoDAO vw_comprometimentoDAO = getVw_comprometimentoDAO();

            List<Vw_comprometimentoT> listTemp = vw_comprometimentoDAO.getByPK(vw_comprometimentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Fat_fatorDAO getFat_fatorDAO() throws Exception {
        dao = getDAO();
        return new Fat_fatorDAO(dao);
    }

    public Fat_fatorT findbyIdFat_fator(Fat_fatorT fat_fatorT) throws Exception {
        try {
            Fat_fatorDAO fat_fatorDAO = getFat_fatorDAO();

            List<Fat_fatorT> listTemp = fat_fatorDAO.getByPK(fat_fatorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_insumo_plc_pmsDAO getVw_insumo_plc_pmsDAO() throws Exception {
        dao = getDAO();
        return new Vw_insumo_plc_pmsDAO(dao);
    }

    public Vw_insumo_plc_pmsT findbyIdVw_insumo_plc_pms(Vw_insumo_plc_pmsT vw_insumo_plc_pmsT) throws Exception {
        try {
            Vw_insumo_plc_pmsDAO vw_insumo_plc_pmsDAO = getVw_insumo_plc_pmsDAO();

            List<Vw_insumo_plc_pmsT> listTemp = vw_insumo_plc_pmsDAO.getByPK(vw_insumo_plc_pmsT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_equiv_insumo_pmsDAO getVw_equiv_insumo_pmsDAO() throws Exception {
        dao = getDAO();
        return new Vw_equiv_insumo_pmsDAO(dao);
    }

    public Vw_equiv_insumo_pmsT findbyIdVw_equiv_insumo_pms(Vw_equiv_insumo_pmsT vw_equiv_insumo_pmsT) throws Exception {
        try {
            Vw_equiv_insumo_pmsDAO vw_equiv_insumo_pmsDAO = getVw_equiv_insumo_pmsDAO();

            List<Vw_equiv_insumo_pmsT> listTemp = vw_equiv_insumo_pmsDAO.getByPK(vw_equiv_insumo_pmsT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
    //-----------------

    public Fol_folha_pagamentoDAO getFol_folha_pagamentoDAO() throws Exception {
        dao = getDAO();
        return new Fol_folha_pagamentoDAO(dao);
    }

    public Htf_horas_trabalha_folhaDAO getHtf_horas_trabalha_folhaDAO() throws Exception {
        dao = getDAO();
        return new Htf_horas_trabalha_folhaDAO(dao);
    }

    public Fol_folha_pagamentoT findbyIdFol_folha_pagamento(Fol_folha_pagamentoT fol_folha_pagamentoT) throws Exception {
        try {
            Fol_folha_pagamentoDAO fol_folha_pagamentoDAO = getFol_folha_pagamentoDAO();

            List<Fol_folha_pagamentoT> listTemp = fol_folha_pagamentoDAO.getByPK(fol_folha_pagamentoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Htf_horas_trabalha_folhaT findbyIdHtf_horas_trabalha_folha(Htf_horas_trabalha_folhaT htf_horas_trabalha_folhaT) throws Exception {
        try {
            Htf_horas_trabalha_folhaDAO htf_horas_trabalha_folhaDAO = getHtf_horas_trabalha_folhaDAO();

            List<Htf_horas_trabalha_folhaT> listTemp = htf_horas_trabalha_folhaDAO.getByPK(htf_horas_trabalha_folhaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Dso_descricao_servico_obraDAO getDso_descricao_servico_obraDAO() throws Exception {
        dao = getDAO();
        return new Dso_descricao_servico_obraDAO(dao);
    }

    public Dso_descricao_servico_obraT findbyIdDso_descricao_servico_obra(Dso_descricao_servico_obraT dso_descricao_servico_obraT) throws Exception {
        try {
            Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();

            List<Dso_descricao_servico_obraT> listTemp = dso_descricao_servico_obraDAO.getByPK(dso_descricao_servico_obraT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Scfp_subclasse_operario_previstoDAO getScfp_subclasse_operario_previstoDAO() throws Exception {
        dao = getDAO();
        return new Scfp_subclasse_operario_previstoDAO(dao);
    }

    public Scfp_subclasse_operario_previstoT findbyIdScfp_subclasse_operario_previsto(Scfp_subclasse_operario_previstoT scfp_subclasse_operario_previstoT) throws Exception {
        try {
            Scfp_subclasse_operario_previstoDAO scfp_subclasse_operario_previstoDAO = getScfp_subclasse_operario_previstoDAO();

            List<Scfp_subclasse_operario_previstoT> listTemp = scfp_subclasse_operario_previstoDAO.getByPK(scfp_subclasse_operario_previstoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Frd_faturamento_rec_devolucaoDAO getFrd_faturamento_rec_devolucaoDAO() throws Exception {
        dao = getDAO();
        return new Frd_faturamento_rec_devolucaoDAO(dao);
    }

    public Frd_faturamento_rec_devolucaoT findbyIdFrd_faturamento_rec_devolucao(Frd_faturamento_rec_devolucaoT frd_faturamento_rec_devolucaoT) throws Exception {
        try {
            Frd_faturamento_rec_devolucaoDAO frd_faturamento_rec_devolucaoDAO = getFrd_faturamento_rec_devolucaoDAO();

            List<Frd_faturamento_rec_devolucaoT> listTemp = frd_faturamento_rec_devolucaoDAO.getByPK(frd_faturamento_rec_devolucaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Flr_fluxo_receitaDAO getFlr_fluxo_receitaDAO() throws Exception {
        dao = getDAO();
        return new Flr_fluxo_receitaDAO(dao);
    }

    public Flr_fluxo_receitaT findbyIdFlr_fluxo_receita(Flr_fluxo_receitaT flr_fluxo_receitaT) throws Exception {
        try {
            Flr_fluxo_receitaDAO flr_fluxo_receitaDAO = getFlr_fluxo_receitaDAO();

            List<Flr_fluxo_receitaT> listTemp = flr_fluxo_receitaDAO.getByPK(flr_fluxo_receitaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_cffo_mesDAO getVw_cffo_mesDAO() throws Exception {
        dao = getDAO();
        return new Vw_cffo_mesDAO(dao);
    }

    public Vw_cffo_mesT findbyIdVw_cffo_mes(Vw_cffo_mesT vw_cffo_mesT) throws Exception {
        try {
            Vw_cffo_mesDAO vw_cffo_mesDAO = getVw_cffo_mesDAO();

            List<Vw_cffo_mesT> listTemp = vw_cffo_mesDAO.getByPK(vw_cffo_mesT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Evl_evolucao_lucroDAO getEvl_evolucao_lucroDAO() throws Exception {
        dao = getDAO();
        return new Evl_evolucao_lucroDAO(dao);
    }

    public Pro_programacaoDAO getPro_programacaoDAO() throws Exception {
        dao = getDAO();
        return new Pro_programacaoDAO(dao);
    }

    public Evl_evolucao_lucroT findbyIdEvl_evolucao_lucro(Evl_evolucao_lucroT evl_evolucao_lucroT) throws Exception {
        try {
            Evl_evolucao_lucroDAO evl_evolucao_lucroDAO = getEvl_evolucao_lucroDAO();

            List<Evl_evolucao_lucroT> listTemp = evl_evolucao_lucroDAO.getByPK(evl_evolucao_lucroT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Pro_programacaoT findbyIdPro_programacao(Pro_programacaoT pro_programacaoT) throws Exception {
        try {
            Pro_programacaoDAO pro_programacaoDAO = getPro_programacaoDAO();

            List<Pro_programacaoT> listTemp = pro_programacaoDAO.getByPK(pro_programacaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plr_planilha_recebimentoDAO getPlr_planilha_permutaDAO() throws Exception {
        dao = getDAO();
        return new Plr_planilha_recebimentoDAO(dao);
    }

    public Plv_planilha_vendasDAO getPlv_planilha_vendasDAO() throws Exception {
        dao = getDAO();
        return new Plv_planilha_vendasDAO(dao);
    }

    public Plp_planilha_permutaDAO getPlp_planilha_permutaDAO() throws Exception {
        dao = getDAO();
        return new Plp_planilha_permutaDAO(dao);
    }

    public Plr_planilha_recebimentoT findbyIdPlr_planilha_permuta(Plr_planilha_recebimentoT plr_planilha_permutaT) throws Exception {
        try {
            Plr_planilha_recebimentoDAO plr_planilha_permutaDAO = getPlr_planilha_permutaDAO();

            List<Plr_planilha_recebimentoT> listTemp = plr_planilha_permutaDAO.getByPK(plr_planilha_permutaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plv_planilha_vendasT findbyIdPlv_planilha_vendas(Plv_planilha_vendasT plv_planilha_vendasT) throws Exception {
        try {
            Plv_planilha_vendasDAO plv_planilha_vendasDAO = getPlv_planilha_vendasDAO();

            List<Plv_planilha_vendasT> listTemp = plv_planilha_vendasDAO.getByPK(plv_planilha_vendasT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Plp_planilha_permutaT findbyIdPlp_planilha_permuta(Plp_planilha_permutaT plp_planilha_permutaT) throws Exception {
        try {
            Plp_planilha_permutaDAO plp_planilha_permutaDAO = getPlp_planilha_permutaDAO();

            List<Plp_planilha_permutaT> listTemp = plp_planilha_permutaDAO.getByPK(plp_planilha_permutaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Inc_informacoes_custoDAO getInc_informacoes_custoDAO() throws Exception {
        dao = getDAO();
        return new Inc_informacoes_custoDAO(dao);
    }

    public Inc_informacoes_custoT findbyIdInc_informacoes_custo(Inc_informacoes_custoT inc_informacoes_custoT) throws Exception {
        try {
            Inc_informacoes_custoDAO inc_informacoes_custoDAO = getInc_informacoes_custoDAO();

            List<Inc_informacoes_custoT> listTemp = inc_informacoes_custoDAO.getByPK(inc_informacoes_custoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Fto_fotosDAO getFto_fotosDAO() throws Exception {
        dao = getDAO();
        return new Fto_fotosDAO(dao);
    }

    public Fto_fotosT findbyIdFto_fotos(Fto_fotosT fto_fotosT) throws Exception {
        try {
            Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();

            List<Fto_fotosT> listTemp = fto_fotosDAO.getByPK(fto_fotosT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Coa_composicao_anteriorDAO getCoa_composicao_anteriorDAO() throws Exception {
        dao = getDAO();
        return new Coa_composicao_anteriorDAO(dao);
    }

    public Con_composicao_novaDAO getCon_composicao_novaDAO() throws Exception {
        dao = getDAO();
        return new Con_composicao_novaDAO(dao);
    }

    public Eqc_equivalencia_composicaoDAO getEqc_equivalencia_composicaoDAO() throws Exception {
        dao = getDAO();
        return new Eqc_equivalencia_composicaoDAO(dao);
    }

    public Eqi_equivalencia_insumoDAO getEqi_equivalencia_insumoDAO() throws Exception {
        dao = getDAO();
        return new Eqi_equivalencia_insumoDAO(dao);
    }

    public Ina_insumo_antigoDAO getIna_insumo_antigoDAO() throws Exception {
        dao = getDAO();
        return new Ina_insumo_antigoDAO(dao);
    }

    public Inn_insumo_novoDAO getInn_insumo_novoDAO() throws Exception {
        dao = getDAO();
        return new Inn_insumo_novoDAO(dao);
    }

    public Coa_composicao_anteriorT findbyIdCoa_composicao_anterior(Coa_composicao_anteriorT coa_composicao_anteriorT) throws Exception {
        try {
            Coa_composicao_anteriorDAO coa_composicao_anteriorDAO = getCoa_composicao_anteriorDAO();

            List<Coa_composicao_anteriorT> listTemp = coa_composicao_anteriorDAO.getByPK(coa_composicao_anteriorT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Con_composicao_novaT findbyIdCon_composicao_nova(Con_composicao_novaT con_composicao_novaT) throws Exception {
        try {
            Con_composicao_novaDAO con_composicao_novaDAO = getCon_composicao_novaDAO();

            List<Con_composicao_novaT> listTemp = con_composicao_novaDAO.getByPK(con_composicao_novaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Eqc_equivalencia_composicaoT findbyIdEqc_equivalencia_composicao(Eqc_equivalencia_composicaoT eqc_equivalencia_composicaoT) throws Exception {
        try {
            Eqc_equivalencia_composicaoDAO eqc_equivalencia_composicaoDAO = getEqc_equivalencia_composicaoDAO();

            List<Eqc_equivalencia_composicaoT> listTemp = eqc_equivalencia_composicaoDAO.getByPK(eqc_equivalencia_composicaoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Eqi_equivalencia_insumoT findbyIdEqi_equivalencia_insumo(Eqi_equivalencia_insumoT eqi_equivalencia_insumoT) throws Exception {
        try {
            Eqi_equivalencia_insumoDAO eqi_equivalencia_insumoDAO = getEqi_equivalencia_insumoDAO();

            List<Eqi_equivalencia_insumoT> listTemp = eqi_equivalencia_insumoDAO.getByPK(eqi_equivalencia_insumoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ina_insumo_antigoT findbyIdIna_insumo_antigo(Ina_insumo_antigoT ina_insumo_antigoT) throws Exception {
        try {
            Ina_insumo_antigoDAO ina_insumo_antigoDAO = getIna_insumo_antigoDAO();

            List<Ina_insumo_antigoT> listTemp = ina_insumo_antigoDAO.getByPK(ina_insumo_antigoT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Inn_insumo_novoT findbyIdInn_insumo_novo(Inn_insumo_novoT inn_insumo_novoT) throws Exception {
        try {
            Inn_insumo_novoDAO inn_insumo_novoDAO = getInn_insumo_novoDAO();
            List<Inn_insumo_novoT> listTemp = inn_insumo_novoDAO.getByPK(inn_insumo_novoT);
            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ort_orcamento_temporarioDAO getOrt_orcamento_temporarioDAO() throws Exception {
        dao = getDAO();
        return new Ort_orcamento_temporarioDAO(dao);
    }

    public Ort_orcamento_temporarioT findbyIdOrt_orcamento_temporario(Ort_orcamento_temporarioT ort_orcamento_temporarioT) throws Exception {
        try {
            Ort_orcamento_temporarioDAO ort_orcamento_temporarioDAO = getOrt_orcamento_temporarioDAO();

            List<Ort_orcamento_temporarioT> listTemp = ort_orcamento_temporarioDAO.getByPK(ort_orcamento_temporarioT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Ctpm_conta_pagar_modificadaDAO getCtpm_conta_pagar_modificadaDAO() throws Exception {
        dao = getDAO();
        return new Ctpm_conta_pagar_modificadaDAO(dao);
    }

    public Vw_conta_pagar_alteradaDAO getVw_conta_pagar_alteradaDAO() throws Exception {
        dao = getDAO();
        return new Vw_conta_pagar_alteradaDAO(dao);
    }

    public Ctpm_conta_pagar_modificadaT findbyIdCtpm_conta_pagar_modificada(Ctpm_conta_pagar_modificadaT ctpm_conta_pagar_modificadaT) throws Exception {
        try {
            Ctpm_conta_pagar_modificadaDAO ctpm_conta_pagar_modificadaDAO = getCtpm_conta_pagar_modificadaDAO();

            List<Ctpm_conta_pagar_modificadaT> listTemp = ctpm_conta_pagar_modificadaDAO.getByPK(ctpm_conta_pagar_modificadaT);

            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public Vw_conta_pagar_alteradaT findbyIdVw_conta_pagar_alterada(Vw_conta_pagar_alteradaT vw_conta_pagar_alteradaT) throws Exception {
        try {
            Vw_conta_pagar_alteradaDAO vw_conta_pagar_alteradaDAO = getVw_conta_pagar_alteradaDAO();
            List<Vw_conta_pagar_alteradaT> listTemp = vw_conta_pagar_alteradaDAO.getByPK(vw_conta_pagar_alteradaT);
            return listTemp.size() > 0 ? listTemp.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }
}
