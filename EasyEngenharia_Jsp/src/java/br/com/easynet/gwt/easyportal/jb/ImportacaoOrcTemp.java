package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.jb.EasyFileUpload;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.TreeMap;
import jxl.Sheet;
import jxl.Workbook;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class ImportacaoOrcTemp extends SystemBase implements INotSecurity {

    private String pathBase = "/tmp/";
    // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int quantidadeImportados = 0;
    private String arquivo;
    private String status;
    private static final String ASPAS = "\"";
    DAOFactory daof;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Arq_arquivoT arq_arquivoTComp = new Arq_arquivoT();
    private Arq_arquivoT arq_arquivoTEquiv = new Arq_arquivoT();
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
    private double totalgeral;
    private Ipo_item_plano_contas_obraDAO idao;
    private double subtotal;
    private String linha;
    private String cod_conta;
    private double valorTotal;
    private double valorUnit;
    private double quantidade;
    private TreeMap<String, List<ContaTemp>> treeConta = new TreeMap<String, List<ContaTemp>>();
    private boolean importacaovalida;
    private String undPDF;
    private String descPDF;
    private TreeMap<String, Coa_composicao_anteriorT> treeCoa = new TreeMap<String, Coa_composicao_anteriorT>();
    private TreeMap<String, Ina_insumo_antigoT> treeInAnt = new TreeMap<String, Ina_insumo_antigoT>();

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
      System.out.println("inicio pageLoad");
        super.pageLoad();
//        System.out.println("pageLoad");
        File diretorio = new File(PATH_WEB);
        if (diretorio.exists()) {
            pathBase = PATH_WEB;
        } else {
            pathBase = PATH_LOCAL;
        }
    }

    public void insert_Old(Ina_insumo_antigoT ina_insumo_antigoT, Coa_composicao_anteriorT coa_composicao_anteriorT, float qtde, String letra, String cod_obra) throws Exception {
        try {
            int a = 0;
            Coa_composicao_anteriorT coaT;
            Ina_insumo_antigoT inaT;
            Ina_insumo_antigoDAO inaDao = getIna_insumo_antigoDAO();
            //List<Ina_insumo_antigoT> list = inaDao.getByIna_tx_codigo(ina_insumo_antigoT);
            inaT = treeInAnt.get(ina_insumo_antigoT.getIna_tx_codigo());
            if (inaT == null) {
                ina_insumo_antigoT.setIna_tx_descricao(ina_insumo_antigoT.getIna_tx_descricao().replace(ASPAS, "''"));
                ina_insumo_antigoT.setIna_tx_descricao(ina_insumo_antigoT.getIna_tx_descricao().replace("\r", " "));
                ina_insumo_antigoT.setIna_tx_descricao(ina_insumo_antigoT.getIna_tx_descricao().replace("\n", " "));
                inaDao.insert(ina_insumo_antigoT);
                treeInAnt.put(ina_insumo_antigoT.getIna_tx_codigo(), ina_insumo_antigoT);
            } else {
                ina_insumo_antigoT.setIna_nr_id(inaT.getIna_nr_id());
            }

            Coa_composicao_anteriorDAO cdao = getCoa_composicao_anteriorDAO();
//            List<Coa_composicao_anteriorT> listCoa = cdao.getByCoa_tx_codigo(coa_composicao_anteriorT);
            coaT = treeCoa.get(coa_composicao_anteriorT.getCoa_tx_codigo());
            if (coaT == null) {
                coa_composicao_anteriorT.setCoa_tx_descricao(coa_composicao_anteriorT.getCoa_tx_descricao().replace(ASPAS, "''"));
                coa_composicao_anteriorT.setCoa_tx_descricao(coa_composicao_anteriorT.getCoa_tx_descricao().replace("\r", " "));
                coa_composicao_anteriorT.setCoa_tx_descricao(coa_composicao_anteriorT.getCoa_tx_descricao().replace("\n", " "));
                cdao.insert(coa_composicao_anteriorT);
                treeCoa.put(coa_composicao_anteriorT.getCoa_tx_codigo(), coa_composicao_anteriorT);
                ;
            } else {
                coa_composicao_anteriorT.setCoa_nr_id(coaT.getCoa_nr_id());
            }

            Ort_orcamento_temporarioT ort_orcamento_temporarioT = new Ort_orcamento_temporarioT();
            ort_orcamento_temporarioT.setObr_nr_id(getObr_nr_id());
            ort_orcamento_temporarioT.setCoa_nr_id(coa_composicao_anteriorT.getCoa_nr_id());
            ort_orcamento_temporarioT.setIna_nr_id(ina_insumo_antigoT.getIna_nr_id());
            ort_orcamento_temporarioT.setOrt_nr_quantidade(qtde);
            ort_orcamento_temporarioT.setOrt_tx_letra(letra);
            ort_orcamento_temporarioT.setOrt_tx_cod_obra(cod_obra);
            Ort_orcamento_temporarioDAO odao = getOrt_orcamento_temporarioDAO();
            odao.insert(ort_orcamento_temporarioT);
            setQuantidadeImportados(getQuantidadeImportados() + 1);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void insertComp_new() {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoTComp.getArq_bt_arquivo());
            Workbook workbook = Workbook.getWorkbook(bais);
            Sheet sheet = workbook.getSheet(0);
            String cod = "";
            String desc = "";
            String und = "";
            for (int i = 1; i < (sheet.getRows()); i++) {
                if (linhaValida(sheet.getCell(1, i).getContents().trim())) {

                    cod = sheet.getCell(0, i).getContents().trim();
                    und = sheet.getCell(1, i).getContents().trim();
                    desc = sheet.getCell(2, i).getContents().trim();

                    Con_composicao_novaT con_composicao_novaT = new Con_composicao_novaT();

                    con_composicao_novaT.setCon_tx_codigo(cod);
                    con_composicao_novaT.setCon_tx_descricao(desc);
                    con_composicao_novaT.setCon_tx_unidade(und);
                    Inn_insumo_novoDAO idao = getInn_insumo_novoDAO();
                    Con_composicao_novaDAO cdao = getCon_composicao_novaDAO();
                    List<Con_composicao_novaT> lis = cdao.getByCon_tx_codigo(con_composicao_novaT);
                    if (lis.size() == 0) {
                        cdao.insert(con_composicao_novaT);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertInsumo_new() {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoTEquiv.getArq_bt_arquivo());
            Workbook workbook = Workbook.getWorkbook(bais);
            Sheet sheet = workbook.getSheet(0);
            String cod = "";
            String cod_insuno_old = "";
            String desc = "";
            String und = "";
//            System.out.println(sheet.getRows() + " itens");
            int a = 0;
            Inn_insumo_novoDAO idao = getInn_insumo_novoDAO();
            Eqi_equivalencia_insumoDAO edao = getEqi_equivalencia_insumoDAO();
            TreeMap<String, Inn_insumo_novoT> treeNovo = idao.getAllTree();
            TreeMap<String, Ina_insumo_antigoT> treeAntigo = getIna_insumo_antigoDAO().getAllTree();
            TreeMap<String, Eqi_equivalencia_insumoT> treeEquiv = getEqi_equivalencia_insumoDAO().getByEquivalencia();

            Inn_insumo_novoT inn_insumo_novoT = new Inn_insumo_novoT();
            Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();
            for (int i = 1; i < (sheet.getRows()); i++) {
                if (linhaValida(sheet.getCell(1, i).getContents().trim())) {
                    if (i == 2 || i == 10000 || i == 20000 || i == 30000 || i == 40000) {
                        System.out.println("" + i);
                    }
                    //System.out.println("" + i);

                    cod_insuno_old = sheet.getCell(0, i).getContents().trim();
                    cod = sheet.getCell(1, i).getContents().trim();
                    und = sheet.getCell(2, i).getContents().trim();
                    desc = sheet.getCell(3, i).getContents().trim();

                    inn_insumo_novoT.setInn_tx_codigo(cod);
                    inn_insumo_novoT.setInn_tx_descricao(desc);
                    inn_insumo_novoT.setInn_tx_unidade(und);

                    if (treeNovo.get(cod) == null) {
                        idao.insert(inn_insumo_novoT);
                        treeNovo.put(cod, inn_insumo_novoT);

                        ina_insumo_antigoT = treeAntigo.get(cod_insuno_old);

                        if (ina_insumo_antigoT != null) {
                            Eqi_equivalencia_insumoT eqi_equivalencia_insumoT = new Eqi_equivalencia_insumoT();
                            eqi_equivalencia_insumoT.setIna_nr_id(ina_insumo_antigoT.getIna_nr_id());
                            eqi_equivalencia_insumoT.setInn_nr_id(inn_insumo_novoT.getInn_nr_id());
                            String key = ina_insumo_antigoT.getIna_nr_id() + "." + inn_insumo_novoT.getInn_nr_id();
                            if (treeEquiv.get(key) == null) {
                                edao.insert(eqi_equivalencia_insumoT);
                                treeEquiv.put(key, eqi_equivalencia_insumoT);
                            }
                        }
                    }
                }
            }
//            System.out.println("chegou");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findImport() throws Exception {
        try {
            int q = 89;
            iniciarTransection();
            if (obr_nr_id > 0) {
//                System.out.println("inicio find");

                quantidadeImportados = getOrt_orcamento_temporarioDAO().getByObr_nr_id(obr_nr_id).size();
//                System.out.println("quantidade");
                if (quantidadeImportados == 0) {
                    this.status = "ok";
                    importar();
                } else {
                    this.status = "find";
                }
            } else {
                setMsg("código da obra não pode ser zero");
            }
            factory.commitTransaction();
//            deleteImportacao();
        } catch (Exception e) {
            this.status = "falha";
            factory.rollbackTransaction();
            e.printStackTrace();

        } finally {
            factory.close();
        }

    }

    public void deleteImportacao(){
        try {
            iniciarTransection();
//            getOrt_orcamento_temporarioDAO().deleteAll(obr_nr_id);
            getOrt_orcamento_temporarioDAO().deleteAll(obr_nr_id);
            this.setStatus("ok");
            importar();
            factory.commitTransaction();
        } catch (Exception e) {
            this.setStatus("Erro");
            factory.rollbackTransaction();
//            throw e;
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

    public void importar() throws Exception {
        int lin = 0;
        try {
            lerXLSObra();
        } catch (Exception e) {
            throw e;
        }
    }

    public void lerXLSObra() throws Exception {
        int lin = 24;
        try {
//            System.out.println("inicio tree");
            treeCoa = getCoa_composicao_anteriorDAO().getAllTree();
            treeInAnt = getIna_insumo_antigoDAO().getAllTree();

//            System.out.println("arquivo");
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
            Workbook workbook = Workbook.getWorkbook(bais);
            Sheet sheet = workbook.getSheet(0);

//            System.out.println("arquivo ByteArrayInputStream ");

            String cod_comp_old;
            String cod_insu_old;
            String desc_comp_old = "";
            String desc_insu_old = "";
            Ina_insumo_antigoT ina_insumo_antigoT = new Ina_insumo_antigoT();
            Coa_composicao_anteriorT coa_composicao_anteriorT = new Coa_composicao_anteriorT();

            int linha = 0;
            int cont = 0;
            for (int i = 1; i < (sheet.getRows()); i++) {
                if (linhaValida(sheet.getCell(1, i).getContents().trim())) {
                    lin = i;
                    cont++;
                    if (lin == 35) {
                        int a = 2;
                    }

                    //System.out.println("" + lin);
                    cod_comp_old = sheet.getCell(0, i).getContents().trim();
                    desc_comp_old = sheet.getCell(1, i).getContents().trim();
                    cod_insu_old = sheet.getCell(2, i).getContents().trim();
                    desc_insu_old = sheet.getCell(3, i).getContents().trim();
                    String qtde = sheet.getCell(4, i).getContents().trim();
                    String cod_obra = sheet.getCell(6, i).getContents().trim();
                    String letra = sheet.getCell(7, i).getContents().trim();
                    
                    coa_composicao_anteriorT.setCoa_tx_codigo(cod_comp_old);
                    coa_composicao_anteriorT.setCoa_tx_descricao(desc_comp_old);

                    ina_insumo_antigoT.setIna_tx_codigo(cod_insu_old);
                    ina_insumo_antigoT.setIna_tx_descricao(desc_insu_old);

                    qtde = qtde.replace(".", "");
                    qtde = qtde.replace(",", ".");

                    insert_Old(ina_insumo_antigoT, coa_composicao_anteriorT, Float.parseFloat(qtde), letra, cod_obra);
                }
            }
            insertComp_new();
            insertInsumo_new();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro na linha " + cont);
            setMsg("Erro na linha " + lin);
            status = "FALHA";
            throw e;
        } finally {
        }
    }

    public void insertComposicao() {
    }

    public boolean linhaValida(String vllinha) {
        return vllinha.trim().length() > 0;
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
     * @return the arq_arquivoTPDF
     */
    public Arq_arquivoT getArq_arquivoTComp() {
        return arq_arquivoTComp;
    }

    /**
     * @param arq_arquivoTPDF the arq_arquivoTPDF to set
     */
    public void setArq_arquivoTComp(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoTComp = arq_arquivoT;
    }

    /**
     * @return the arq_arquivoTEquiv
     */
    public Arq_arquivoT getArq_arquivoTEquiv() {
        return arq_arquivoTEquiv;
    }

    /**
     * @param arq_arquivoTEquiv the arq_arquivoTEquiv to set
     */
    public void setArq_arquivoTEquiv(Arq_arquivoT arq_arquivoTEquiv) {
        this.arq_arquivoTEquiv = arq_arquivoTEquiv;
    }

    class ContaTemp {

        private String codigo;
        private String descricao;
        private double valorunit;
        private double quantidade;
        private double valorTotal;
        private String unidade;

        /**
         * @return the codigo
         */
        public String getCodigo() {
            return codigo;
        }

        /**
         * @param codigo the codigo to set
         */
        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        /**
         * @return the descricao
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * @param descricao the descricao to set
         */
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        /**
         * @return the valorunit
         */
        public double getValorunit() {
            return valorunit;
        }

        /**
         * @param valorunit the valorunit to set
         */
        public void setValorunit(double valorunit) {
            this.valorunit = valorunit;
        }

        /**
         * @return the quantidade
         */
        public double getQuantidade() {
            return quantidade;
        }

        /**
         * @param quantidade the quantidade to set
         */
        public void setQuantidade(double quantidade) {
            this.quantidade = quantidade;
        }

        /**
         * @return the valorTotal
         */
        public double getValorTotal() {
            return valorTotal;
        }

        /**
         * @param valorTotal the valorTotal to set
         */
        public void setValorTotal(double valorTotal) {
            this.valorTotal = valorTotal;
        }

        /**
         * @return the unidade
         */
        public String getUnidade() {
            return unidade;
        }

        /**
         * @param unidade the unidade to set
         */
        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }
    }

    public void setIpo_item_plano_contas_obraT(Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT) {
        this.ipo_item_plano_contas_obraT = ipo_item_plano_contas_obraT;
    }

    public Ipo_item_plano_contas_obraT getIpo_item_plano_contas_obraT() {
        return ipo_item_plano_contas_obraT;
    }
}
