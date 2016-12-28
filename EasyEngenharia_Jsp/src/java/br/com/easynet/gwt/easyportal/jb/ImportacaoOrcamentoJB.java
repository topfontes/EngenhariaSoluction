package br.com.easynet.gwt.easyportal.jb;

import java.io.IOException;
import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.jb.EasyFileUpload;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.Table;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import jxl.Cell;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class ImportacaoOrcamentoJB extends SystemBase {

    private String pathBase = "/tmp/";
    // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int quantidadeImportados = 0;
    private String arquivo;
    private Cell codigo;
    private Cell nome;
    private Cell nomeclasse;
    private Cell uni;
    private Cell quantidade;
    private Cell unitario;
    private Cell total;
    private String status;
    private static final String ASPAS = "\"";
    DAOFactory daof;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
    private EasyFileUpload uplo;
    private int obr_nr_id;
    private int id_servico = 0;
    private int id_nivel_1 = 0;
    private int id_nivel_2 = 0;
    private int id_nivel_3 = 0;
    private int id_nivel_4 = 0;
    private int id_super = 0;
    //private Connection conMDB;
    private ResultSet rsListaContas;
    private ResultSet rsListaOrcamento;
    private ResultSet rsComposicao;
    private float qtde_servico = 0;
    private float somavlUnitInsumos = 0;
    static List<OrcamentoT> listOrcamento;
    static List<ComposicaoT> listComposicao;
    static List<ContaOrcamentoT> listContaOrcamento;
    private int qtdeConsulta;
    static TreeMap<Integer, ContaOrcamentoT> contTreeMap = new TreeMap<Integer, ContaOrcamentoT>();
    static TreeMap<Integer, OrcamentoT> orcTreeMap = new TreeMap<Integer, OrcamentoT>();
    static TreeMap<Integer, ComposicaoT> compTreeMap = new TreeMap<Integer, ComposicaoT>();
    List<Float> listQtde = new ArrayList<Float>();
    boolean valido;
    int cont = 0;
    private DAOFactory factory = null;
    private TreeMap<Integer, Dso_descricao_servico_obraT> treeDescricao = new TreeMap<Integer, Dso_descricao_servico_obraT>();
    private boolean externo;
    private String letraCodExterno;

    public void setPlco_plano_contas_orcamentoT(Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT) {
        this.plco_plano_contas_orcamentoT = plco_plano_contas_orcamentoT;
    }

    public Plco_plano_contas_orcamentoT getPlco_plano_contas_orcamentoT() {
        return plco_plano_contas_orcamentoT;
    }
    private List<Plco_plano_contas_orcamentoT> list;

    public List<Plco_plano_contas_orcamentoT> getList() {
        return list;
    }

    public void setList(List<Plco_plano_contas_orcamentoT> list) {
        this.list = list;
    }

    public void pageLoad() throws Exception {
        super.pageLoad();
        File diretorio = new File(PATH_WEB);
        if (diretorio.exists()) {
            pathBase = PATH_WEB;
        } else {
            pathBase = PATH_LOCAL;
        }
        setLetraCodExterno("");
        if (isExterno()) {
            letraCodExterno = "." + getLetraCliente();
            getSession().setAttribute("letra", letraCodExterno);
        }else{
            letraCodExterno = getSession().getAttribute("letra")!= null ? (String)getSession().getAttribute("letra"):"";
        }
    }

    public String getLetraCliente() throws Exception {
        try {

            Obr_obrasDAO oDao = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(obr_nr_id);
            obr_obrasT = oDao.getByObr_nr_id(obr_obrasT).get(0);

            Emp_empreendimentoDAO edao = getEmp_empreendimentoDAO();
            Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
            emp_empreendimentoT.setEmp_nr_id(obr_obrasT.getEmp_nr_id());
            emp_empreendimentoT = edao.getByEmp_nr_id(emp_empreendimentoT).get(0);

            Cli_clienteDAO cdao = getCli_clienteDAO();
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(emp_empreendimentoT.getCli_nr_id());
            cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);
            return cli_clienteT.getCli_tx_letra_orcamento_externo();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void povoaTreeDescricao() throws Exception {
        try {
            Dso_descricao_servico_obraDAO ddao = getDso_descricao_servico_obraDAO();
            treeDescricao = ddao.getByObr_nr_id(obr_nr_id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertServicoObra(Plco_plano_contas_orcamentoT pt) throws Exception {
        try {
            Dso_descricao_servico_obraDAO ddao = getDso_descricao_servico_obraDAO();
            if(pt.getPlco_nr_id() == 3157){
                int a = 66;
            }
            if (treeDescricao.get(pt.getPlco_nr_id()) == null) {
                Dso_descricao_servico_obraT dt = new Dso_descricao_servico_obraT();
                dt.setDso_tx_codigo_externo(pt.getPlco_tx_cod_externo());
                dt.setDso_tx_descriaco(pt.getPlco_tx_nome());
                dt.setObr_nr_id(obr_nr_id);
                dt.setPlco_nr_id(pt.getPlco_nr_id());
                ddao.insert(dt);
                treeDescricao.put(pt.getPlco_nr_id(), dt);
                quantidadeImportados++;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void preencherListas() {
        File file = null;
        Database database = null;
        try {
            String sql;
            int inicio = 1;
            int fim = 999;
            int linhas = 0;
            file = new File(pathBase.concat(getSession().getId()) + ".mdb");
            //file = new File("c:/bc/marcos/habitacional.mdb");

            database = Database.open(file);

            Table tblConta = database.getTable("TV1_ITOR");
            Map<String, Object> row;
            //preencher Tree Map de plano de contas
            while ((row = tblConta.getNextRow()) != null) {
                ContaOrcamentoT contaOrcamentoT = new ContaOrcamentoT();
                contaOrcamentoT.setCodigo((Integer) row.get("ITOR1_COD"));
                contaOrcamentoT.setCodigo_externo((String) row.get("ITOR1_COD_ITEM") + getLetraCodExterno());
                contaOrcamentoT.setPlco_nome((String) row.get("ITOR1_DES"));
                contaOrcamentoT.setNivel((Integer) row.get("NIVE1_COD"));
                contaOrcamentoT.setTipo((String) row.get("CLAS1_ABR"));
                contaOrcamentoT.setUnidade((String) row.get("ITOR1_UNI_PRO"));
                contaOrcamentoT.setValor_unit(Float.parseFloat(row.get("ITOR1_PRC_COMTAXA").toString()));
                contTreeMap.put((Integer) row.get("ITOR1_COD"), contaOrcamentoT);
            }

            listOrcamento = new ArrayList<OrcamentoT>();
            ContaOrcamentoT contaTemp = new ContaOrcamentoT();
            Table tblOrcamento = database.getTable("TV1_PLOR");
            //preencher lista da tabela de Orçamento
            while ((row = tblOrcamento.getNextRow()) != null) {
                OrcamentoT orcamentoT = new OrcamentoT();
                orcamentoT.setCod_conta((Integer) row.get("ITOR1_COD"));
                orcamentoT.setCodigo((Integer) row.get("PLOR1_COD"));
                orcamentoT.setCodigo_super(row.get("PLOR1_COD0") != null ? (Integer) row.get("PLOR1_COD0") : 0);
                orcamentoT.setQtde(Float.parseFloat(row.get("PLOR1_QTD").toString()));
                //localizar o registro do plano de contas para pegar o nome e etc....
                contaTemp = contTreeMap.get(orcamentoT.getCod_conta());

                orcamentoT.setCod_externo(contaTemp.getCodigo_externo());
                orcamentoT.setPlco_nome(contaTemp.getPlco_nome());
                orcamentoT.setUnidade(contaTemp.getUnidade());
                orcamentoT.setNivel(contaTemp.getNivel());
                orcamentoT.setTipo(contaTemp.getTipo());
                orcamentoT.setVl_unit(contaTemp.getValor_unit());
//                orcTreeMap.put(orcamentoT.getCod_externo(), orcamentoT);
//                System.out.println(contaTemp.getCodigo_externo() +" - "+contaTemp.getCodigo() +" - "+ orcamentoT.getCod_conta()+" - "+orcamentoT.getQtde());
                listOrcamento.add(orcamentoT);
            }


            Collections.sort(listOrcamento, new Comparator() {

                public int compare(Object o1, Object o2) {
                    OrcamentoT p1 = (OrcamentoT) o1;
                    OrcamentoT p2 = (OrcamentoT) o2;
                    String atividade1 = (p1 != null) ? p1.getCod_externo() : "";
                    String atividade2 = (p2 != null) ? p2.getCod_externo() : "";
                    return atividade1.compareTo(atividade2);
                }
            });


            listComposicao = new ArrayList<ComposicaoT>();
            Table tblComp = database.getTable("TV1_COMP");
            //preencher lista da tabela de composição
            while ((row = tblComp.getNextRow()) != null) {
                ComposicaoT composicaoT = new ComposicaoT();
                composicaoT.setCodigo((Integer) row.get("ITOR1_COD0"));
                composicaoT.setCodigo_super((Integer) row.get("ITOR1_COD"));
                composicaoT.setQtde(Float.parseFloat(row.get("COMP1_COE").toString()));
                contaTemp = contTreeMap.get(composicaoT.getCodigo());
                composicaoT.setCod_externo(contaTemp.getCodigo_externo());
                composicaoT.setPlco_nome(contaTemp.getPlco_nome());
                composicaoT.setNivel(contaTemp.getNivel());
                composicaoT.setTipo(contaTemp.getTipo());
                composicaoT.setUnidade(contaTemp.getUnidade());
                composicaoT.setValor_unit(contaTemp.getValor_unit());
                listComposicao.add(composicaoT);
            }

            Collections.sort(listComposicao, new Comparator() {

                public int compare(Object o1, Object o2) {
                    ComposicaoT p1 = (ComposicaoT) o1;
                    ComposicaoT p2 = (ComposicaoT) o2;
                    String atividade1 = (p1 != null) ? p1.getCod_externo() : "";
                    String atividade2 = (p2 != null) ? p2.getCod_externo() : "";
                    return atividade1.compareTo(atividade2);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                database.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            file.delete();
        }
    }

    public void insertPlco(String codigo_externo, String nome, int nivel, boolean curva_abc, String tipo, String unidade, Plco_plano_contas_orcamentoT plco, float qtde, float vl_unit, boolean cronograma) throws Exception {
        try {
            Plco_plano_contas_orcamentoDAO pdao = getPlco_plano_contas_orcamentoDAO();
            plco = locateObjecto(codigo_externo);
            if (plco.getPlco_nr_id() == 0) {
                plco = new Plco_plano_contas_orcamentoT();
                plco.setPlco_tx_cod_externo(codigo_externo);
                nome = nome.replace(ASPAS, "''");
                nome = nome.replace("\r", " ");
                nome = nome.replace("\n", " ");
                plco.setPlco_tx_nome(nome);
                plco.setPlco_nr_nivel(nivel);
                plco.setPlco_bl_equivalencia(curva_abc);
                if (nivel > 3) {
                    plco.setPlco_tx_tipo(tipo);
                    plco.setPlco_tx_unidade(unidade);
                }
                plco.setPlco_nr_id(pdao.insert(plco));
            }
            plco.setPlco_tx_nome(nome);
            insertServicoObra(plco);

            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
            ipo_item_plano_contas_obraT.setObr_nr_id(getObr_nr_id());
            ipo_item_plano_contas_obraT.setPlco_nr_id(plco.getPlco_nr_id());
            ipo_item_plano_contas_obraT.setIpo_plc_nr_id_servico(id_nivel_4);
            ipo_item_plano_contas_obraT.setIpo_nr_id_super(id_super);
            ipo_item_plano_contas_obraT.setIpo_nr_id_nivel_1(id_nivel_1);
            ipo_item_plano_contas_obraT.setIpo_nr_id_nivel_2(id_nivel_2);
            ipo_item_plano_contas_obraT.setIpo_nr_id_nivel_3(id_nivel_3);
            ipo_item_plano_contas_obraT.setIpo_nr_nivel(nivel);
            ipo_item_plano_contas_obraT.setIpo_bl_curva_abc(curva_abc);
            ipo_item_plano_contas_obraT.setIpo_bl_cronograma(cronograma);
            if (nivel > 3) {
                ipo_item_plano_contas_obraT.setIpo_nr_quantidade(qtde);
                ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(vl_unit);
                ipo_item_plano_contas_obraT.setIpo_nr_vl_total(vl_unit * qtde);
            }

            idao.insert(ipo_item_plano_contas_obraT);
            //de acordo com o nível será atribuido ao id do nivel respectivamente.
            if (nivel == 1) {
                id_nivel_1 = ipo_item_plano_contas_obraT.getIpo_nr_id();
            } else if (nivel == 2) {
                id_nivel_2 = ipo_item_plano_contas_obraT.getIpo_nr_id();
            } else if (nivel == 3) {
                id_nivel_3 = ipo_item_plano_contas_obraT.getIpo_nr_id();
            } else if (nivel == 4) {
                id_nivel_4 = ipo_item_plano_contas_obraT.getIpo_nr_id();
                id_super = id_nivel_4;
            }
            cont = 0;
            quantidadeImportados++;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * primeiro laço a ser executado;
     * @param cod_super
     */
    public void povoaOrcamento(int cod_super) throws Exception {
        //Plco_plano_contas_orcamentoDAO dAO;

        //dAO = getPlco_plano_contas_orcamentoDAO();
        List<OrcamentoT> listTemp = new ArrayList<OrcamentoT>();
        for (OrcamentoT orcaT : listOrcamento) {
            if (orcaT.getCodigo_super() == cod_super) {
                listTemp.add(orcaT);
            }
        }
        int nivel = 0;
        boolean curva_abc, cronograma;

        for (OrcamentoT orcT : listTemp) {
            curva_abc = false;
            cronograma = true;
            boolean existeFilhos = false;
            float SomaVlInsumos = 0;
            somavlUnitInsumos = 0;
            listQtde.clear();
            float qtdeServ = 0;
            if (18 == orcT.getNivel()) {
                nivel = 1;
                id_super = 0;
            } else if (19 == orcT.getNivel()) {
                nivel = 2;
                id_super = id_nivel_1;
            } else if (20 == orcT.getNivel()) {
                nivel = 3;
                id_super = id_nivel_2;
            } else if (21 == orcT.getNivel()) {
                // o nivel 21 tanto pode ser nivel 4 quanto nivel 5
                //o que diferencia é que se o item possuir filhos ele é nível 4 se não nivel 5
                existeFilhos = findChildren(orcT.getCod_conta());
                if (existeFilhos) {
                    qtdeServ = orcT.getQtde();
                    id_super = id_nivel_3;
                    nivel = 4;
                    qtde_servico = orcT.getQtde();
                    SomaVlInsumos = Somar_VlUnit_Composicao(orcT.getCod_conta(), orcT.getQtde());
                } else {
                    //o item sendo nivel 4 ele vai ser um item que irar ser realizado a equivalencia e pertençe ao relatório
                    //da curva abc
                    //id_super = id_nivel_4;
                    id_super = id_nivel_3;
                    nivel = 5;
                    curva_abc = true;
                    qtdeServ = orcT.getQtde();
                    SomaVlInsumos = orcT.getVl_unit();
                }
            }

            Plco_plano_contas_orcamentoT plco = new Plco_plano_contas_orcamentoT();
            insertPlco(orcT.getCod_externo(), orcT.getPlco_nome(), nivel, curva_abc, orcT.getTipo(), orcT.getUnidade(), plco, qtdeServ, SomaVlInsumos, cronograma);
            qtde_servico = 0;
            //existindo filhos iremos chamar o método que procura os filhos e inseri na base;
            if (existeFilhos) {
                qtde_servico = orcT.getQtde();
                povoaComposicao(orcT.getCod_conta(), qtde_servico);
            }
            povoaOrcamento(orcT.getCodigo());
        }

    }

    /**
     * Verificar se a conta possui filhos;
     * @param codigo_conta
     * @return
     */
    public boolean findChildren(int codigo_conta) throws Exception {
        boolean res = false;
        for (ComposicaoT compT : listComposicao) {
            if (compT.getCodigo_super() == codigo_conta) {
                res = true;
                break;
            }
        }

        return res;
    }

    /**
     * Povoa o composição dos Serviços e insumos que possuem outros insumos
     * @param id_suber_composicao
     * @param dAO
     * @param base
     * @return
     */
    public float povoaComposicao(int id_suber_composicao, float base) throws Exception {

        List<ComposicaoT> listComp = new ArrayList<ComposicaoT>();
        for (ComposicaoT comT : listComposicao) {
            if (comT.getCodigo_super() == id_suber_composicao) {
                listComp.add(comT);
            }
        }

        for (ComposicaoT compT : listComp) {
            boolean existe = findChildren(compT.getCodigo());
            //verifica se existe filhos!
            if (!existe) {
                float valor = 1;
                //se a quantidade do serviço for diferente da variavel base que
                //é passado como paramento do método
                // é por que o insumo tem filhos
                if (qtde_servico != base) {
                    valor = qtde_servico;
                }
                float resOp = (compT.getQtde() * base) * valor;
                insertPlco(compT.getCod_externo(), compT.getPlco_nome(), 5, true, compT.getTipo(), compT.getUnidade(), plco_plano_contas_orcamentoT, resOp, compT.getValor_unit(), false);
            } else {
                float novo_valor = compT.getQtde();
                //se a quantidade do serviço for diferente da variavel base que
                //é passado como paramento do método
                // é por que o insumo tem filhos, e o novo valor atribuido ao parametro é o proprio parametro vezes a quantidade
                if (qtde_servico != base) {
                    novo_valor = compT.getQtde() * base;
                }
                float newBase = compT.getQtde();
                povoaComposicao(compT.getCodigo(), novo_valor);
            }
        }

        return 0;
    }

    /**
     * Soma a composição dos insumos para add do serviço
     * @param id_suber_composicao
     * @param dAO
     * @param base
     * @return
     */
    public float Somar_VlUnit_Composicao(int id_suber_composicao, float base) throws Exception {

        List<ComposicaoT> listComp = new ArrayList<ComposicaoT>();
        for (ComposicaoT compT : listComposicao) {
            if (compT.getCodigo_super() == id_suber_composicao) {
                listComp.add(compT);
            }
        }
        float vl = 0;
        for (ComposicaoT compT : listComp) {
            boolean existe = findChildren(compT.getCodigo());
            //verifica se existe filhos!
            if (!existe) {
                float valor = 1;
                float calcQtde = compT.getQtde() * compT.getValor_unit();
                //se a quantidade do serviço for diferente da variavel base que
                //é passado como paramento do método
                // é por que o insumo tem filhos
                if (qtde_servico != base) {
                    calcQtde = (base * compT.getQtde()) * compT.getValor_unit();
                    valor = qtde_servico;
                }
                float resOp = (compT.getQtde() * base) * valor;
                compT.setQtde_calc(resOp);
                somavlUnitInsumos += calcQtde;

            } else {
                float novo_Valor = compT.getQtde();
                //se a quantidade do serviço for diferente da variavel base que
                //é passado como paramento do método
                // é por que o insumo tem filhos, e o novo valor atribuido ao parametro é o proprio parametro vezes a quantidade
                if (qtde_servico != base) {
                    novo_Valor = compT.getQtde() * base;
                }
                Somar_VlUnit_Composicao(compT.getCodigo(), novo_Valor);
            }
        }

        return somavlUnitInsumos;
    }

    /**
     * Verificar se existe arquivos importados para determinada Obra.
     * @throws Exception
     */
    public void findImportacao() throws Exception {
        try {
            iniciarTransection();
            if (obr_nr_id > 0) {
                Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
                ipo_item_plano_contas_obraT.setObr_nr_id(obr_nr_id);

                quantidadeImportados = idao.getByqtdeImportado(ipo_item_plano_contas_obraT);
                if (quantidadeImportados == 0) {
                    salvarArquivo();
                    this.status = "ok";
                    importar();
                } else {
                    this.status = "find";
                    salvarArquivo();
                }
            } else {
                setMsg("código da obra não pode ser zero");
            }

            factory.commitTransaction();
        } catch (Exception e) {
            factory.rollbackTransaction();
            throw e;
        } finally {
            factory.close();
        }
    }

    public void iniciarTransection() {
        try {
            if (factory == null) {
                Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
                factory = idao.getDAOFactory();
            }
            factory.beginTransaction();

        } catch (Exception e) {
        }

    }

    private void salvarArquivo() {
        try {
            String dir = pathBase.concat(getSession().getId());
            FileOutputStream fos = new FileOutputStream(pathBase.concat(getSession().getId()) + ".mdb");
            fos.write(arq_arquivoT.getArq_bt_arquivo());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void lerArquivo() {
        try {
            File file = new File(pathBase.concat(getSession().getId()));
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int controle = -1;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((controle = fis.read(buffer)) != -1) {
                byte[] bufferTemp = new byte[controle];
                System.arraycopy(buffer, 0, bufferTemp, 0, controle);
                baos.write(bufferTemp);
            }
            fis.close();
            file.delete();
            arq_arquivoT.setArq_bt_arquivo(baos.toByteArray());
        } catch (Exception e) {
        }
    }

    /**
     * Apagar arquivos importados para determinada Obra.
     * @throws Exception
     */
    public void deleteImportacao() throws Exception {
        try {
            iniciarTransection();
            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            Pms_planilha_medicao_servicoDAO pmsDAO = getPms_planilha_medicao_servicoDAO();
            pmsDAO.deleteObra(obr_nr_id);
            Ccff_copia_cronograma_fisico_financeiroDAO ccffDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
            ccffDAO.deleteObra(obr_nr_id);
            Cffo_cronograma_fisico_financeiro_origenalDAO cffoDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
            cffoDAO.deleteObra(obr_nr_id);
            idao.deleteAllObra(ipo_item_plano_contas_obraT);

            this.status = "ok";
            importar();
            factory.commitTransaction();
        } catch (Exception e) {
            factory.rollbackTransaction();
            throw e;
        } finally {
            factory.close();
        }
    }
    public void deleteDescricao(){
        try {

        Dso_descricao_servico_obraDAO dso_descricao_servico_obraDAO = getDso_descricao_servico_obraDAO();
        dso_descricao_servico_obraDAO.deleteAllObra(obr_nr_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void importar() throws Exception {
        try {
            preencherListas();
            deleteDescricao();
//            povoaTreeDescricao();
            quantidadeImportados = 0;
            Plco_plano_contas_orcamentoDAO dao = getPlco_plano_contas_orcamentoDAO();
//            DAOFactory dAOFactory = dao.getDAOFactory();

            //          dAOFactory.beginTransaction();
            povoaOrcamento(0);
//            dAOFactory.commitTransaction();
            //factory.commitTransaction();
            int i = 0;
        } catch (Exception e) {
            e.printStackTrace();
            status = "erro";
            factory.rollbackTransaction();
            clone();
            throw e;
        }
    }

    public Plco_plano_contas_orcamentoT locateObjecto(String codigo) throws Exception {
        Plco_plano_contas_orcamentoDAO pdao = getPlco_plano_contas_orcamentoDAO();
        return pdao.ObjetoValido(codigo);
    }

    /**
     * @return the quantidadeImportados
     */
    public int getQuantidadeImportados() {
        return quantidadeImportados;
    }

    /**
     * @param quantidadeImportados the quantidadeImportados to set
     */
    public void setQuantidadeImportados(int quantidadeImportados) {
        this.quantidadeImportados = quantidadeImportados;
    }

    /**
     * @return the arquivo
     */
    public String getArquivo() {
        return arquivo;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * @return the ipo_item_plano_contas_obraT
     */
    public Ipo_item_plano_contas_obraT getIpo_item_plano_contas_obraT() {
        return ipo_item_plano_contas_obraT;
    }

    /**
     * @param ipo_item_plano_contas_obraT the ipo_item_plano_contas_obraT to set
     */
    public void setIpo_item_plano_contas_obraT(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) {
        this.ipo_item_plano_contas_obraT = ipo_item_plano_contas_obraT;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the arq_arquivoT
     */
    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }

    /**
     * @param arq_arquivoT the arq_arquivoT to set
     */
    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }

    /**
     * @return the obr_nr_id
     */
    public int getObr_nr_id() {
        return obr_nr_id;
    }

    /**
     * @param obr_nr_id the obr_nr_id to set
     */
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }

    /**
     * @return the externo
     */
    public boolean isExterno() {
        return externo;
    }

    /**
     * @param externo the externo to set
     */
    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    /**
     * @return the letraCodExterno
     */
    public String getLetraCodExterno() {
        return letraCodExterno;
    }

    /**
     * @param letraCodExterno the letraCodExterno to set
     */
    public void setLetraCodExterno(String letraCodExterno) {
        this.letraCodExterno = letraCodExterno;
    }
}
