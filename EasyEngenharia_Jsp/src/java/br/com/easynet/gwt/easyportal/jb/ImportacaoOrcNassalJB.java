package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import br.com.easynet.jb.EasyFileUpload;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;

/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */
public class ImportacaoOrcNassalJB extends SystemBase implements INotSecurity {

    private String pathBase = "/tmp/";
    // Atributos e propriedades
    private Plco_plano_contas_orcamentoT plco_plano_contas_orcamentoT = new Plco_plano_contas_orcamentoT();
    private int quantidadeImportados = 0;
    private String arquivo;
    private String status;
    private static final String ASPAS = "\"";
    DAOFactory daof;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Arq_arquivoT arq_arquivoTPDF = new Arq_arquivoT();
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
        letraCodExterno = "";
        super.pageLoad();
        totalgeral = 0;
        povoaTreeDescricao();
        letraCodExterno = "." + getLetraCliente();
        importacaovalida = !letraCodExterno.equalsIgnoreCase(".");
        idao = getIpo_item_plano_contas_obraDAO();
    }

    public String getLetraCliente() throws Exception {
        try {
            Obr_obrasDAO oDao = getObr_obrasDAO();
            Obr_obrasT obr_obrasT = new Obr_obrasT();
            obr_obrasT.setObr_nr_id(getObr_nr_id());
            obr_obrasT = oDao.getByObr_nr_id(obr_obrasT).get(0);

            Emp_empreendimentoDAO edao = getEmp_empreendimentoDAO();
            Emp_empreendimentoT emp_empreendimentoT = new Emp_empreendimentoT();
            emp_empreendimentoT.setEmp_nr_id(obr_obrasT.getEmp_nr_id());
            emp_empreendimentoT = edao.getByEmp_nr_id(emp_empreendimentoT).get(0);

            Cli_clienteDAO cdao = getCli_clienteDAO();
            Cli_clienteT cli_clienteT = new Cli_clienteT();
            cli_clienteT.setCli_nr_id(emp_empreendimentoT.getCli_nr_id());
            cli_clienteT = cdao.getByCli_nr_id(cli_clienteT).get(0);
            String vl = cli_clienteT.getCli_tx_letra_orcamento_externo() == null ? "" : cli_clienteT.getCli_tx_letra_orcamento_externo();

            return vl;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public void povoaTreeDescricao() throws Exception {
        try {
            Dso_descricao_servico_obraDAO ddao = getDso_descricao_servico_obraDAO();
            treeDescricao = ddao.getByObr_nr_id(getObr_nr_id());
        } catch (Exception e) {
            throw e;
        }
    }

    public Plco_plano_contas_orcamentoT locateObjecto(String codigo) throws Exception {
        Plco_plano_contas_orcamentoDAO pdao = getPlco_plano_contas_orcamentoDAO();
        return pdao.ObjetoValido(codigo);
    }

    public void insertPlco(String codigo_externo, String nome, int nivel, boolean curva_abc, String tipo, String unidade, Plco_plano_contas_orcamentoT plco, double qtde, double vl_unit, boolean cronograma, double valorTot) throws Exception {
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

            if (nivel == 1) {
                id_super = 0;
                id_nivel_1 = 0;
                id_nivel_2 = 0;
                id_nivel_3 = 0;
                id_nivel_4 = 0;
            }

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
            if (nivel > 3 & (qtde > 0 || vl_unit > 0 || valorTot > 0)) {
                if (qtde > 0) {
                    ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(new BigDecimal(valorTot / qtde).floatValue());
                    ipo_item_plano_contas_obraT.setIpo_nr_quantidade(new BigDecimal(qtde).floatValue());
                    ipo_item_plano_contas_obraT.setIpo_nr_vl_total(new BigDecimal(valorTot).floatValue());
                } else {
                    ipo_item_plano_contas_obraT.setIpo_nr_quantidade(new BigDecimal(valorTot / vl_unit).floatValue());
                    ipo_item_plano_contas_obraT.setIpo_nr_vl_unitario(new BigDecimal(vl_unit).floatValue());
                    ipo_item_plano_contas_obraT.setIpo_nr_vl_total(new BigDecimal(valorTot).floatValue());
                }
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
                //id_super = id_nivel_4;
            }
            if (nivel != 5) {
                id_super = ipo_item_plano_contas_obraT.getIpo_nr_id();
            }
//            cont = 0;
            setQuantidadeImportados(getQuantidadeImportados() + 1);
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertServicoObra(Plco_plano_contas_orcamentoT pt) throws Exception {
        try {
            Dso_descricao_servico_obraDAO ddao = getDso_descricao_servico_obraDAO();
            if (treeDescricao.get(pt.getPlco_nr_id()) == null) {
                Dso_descricao_servico_obraT dt = new Dso_descricao_servico_obraT();
                dt.setDso_tx_codigo_externo(pt.getPlco_tx_cod_externo());
                dt.setDso_tx_descriaco(pt.getPlco_tx_nome());
                dt.setObr_nr_id(getObr_nr_id());
                dt.setPlco_nr_id(pt.getPlco_nr_id());
                ddao.insert(dt);
                treeDescricao.put(pt.getPlco_nr_id(), dt);
                setQuantidadeImportados(getQuantidadeImportados() + 1);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void findImport() throws Exception {
        if (importacaovalida) {
            try {
                int q = 89;
                iniciarTransection();
                if (obr_nr_id > 0) {
                    Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
                    ipo_item_plano_contas_obraT.setObr_nr_id(obr_nr_id);
                    quantidadeImportados = idao.getByqtdeImportado(ipo_item_plano_contas_obraT);
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
                factory.rollbackTransaction();
                throw e;
            } finally {
                factory.close();
            }
        } else {
            this.status = "falha";
            this.setMsg("FALHA");
        }
    }

    public void deleteImportacao() throws Exception {
        try {
            iniciarTransection();
            Ipo_item_plano_contas_obraDAO idao = getIpo_item_plano_contas_obraDAO();
            Pms_planilha_medicao_servicoDAO pmsDAO = getPms_planilha_medicao_servicoDAO();
            pmsDAO.deleteObra(getObr_nr_id());
            Ccff_copia_cronograma_fisico_financeiroDAO ccffDAO = getCcff_copia_cronograma_fisico_financeiroDAO();
            ccffDAO.deleteObra(getObr_nr_id());
            Cffo_cronograma_fisico_financeiro_origenalDAO cffoDAO = getCffo_cronograma_fisico_financeiro_origenalDAO();
            cffoDAO.deleteObra(getObr_nr_id());
            ipo_item_plano_contas_obraT.setObr_nr_id(obr_nr_id);
            idao.deleteAllObra(ipo_item_plano_contas_obraT);
            this.setStatus("ok");
            importar();
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

    public void importar() throws Exception {
        int lin = 0;
        try {
            ConverPDFString converPDFString = new ConverPDFString();
            ByteArrayInputStream is = new ByteArrayInputStream(arq_arquivoTPDF.getArq_bt_arquivo());
            String path = converPDFString.getString(is);
            is.close();
            File file = new File(path);
            FileReader fr = new FileReader(path);
            double total = 0;
            boolean insert = false;
            String fornecedor = "";
            boolean linhaVencimento = false;
            int num_linha_venc = 0;
            int contlinhaRodape = 0;

            ContaTemp temp = new ContaTemp();
            subtotal = 0;
            double meutotal = 0;

            String linha_old="";
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                lin++;
                if (lin == 17) {
                    int a = 7;
                }

                contlinhaRodape++;
                linha = br.readLine().trim();
//                System.out.println(linha);

                if (linha.indexOf("011.18") > -1) {
                    int o = 0;
                }

                if (contaSuper()) {
                    int posicao = posicaoEspaco();
                    cod_conta = linha.substring(0, posicao).trim()+letraCodExterno;
                    if (cod_conta.equalsIgnoreCase("001.04.06.01")) {
                        int s = 89;
                    }

//                    int lengt = cod_conta.length();
//                    if (lengt > 6) {
//                        lengt = 6;
//                    }
//                    cod_conta = cod_conta.substring(0, lengt) + letraCodExterno;
//                    int index = linha.indexOf("Tarefa");
//                    String desc = linha.substring(posicao, index).trim();
//                    if (desc.length() > 49) {
//                        desc = desc.substring(0, 50);
//                    }
//                    cod_conta += desc.trim();
//                    if (subtotal > 0) {
//                        System.out.println("========================== Sub Total -" + formatReight(Funcoes.FormatoMoedaBR_Double(subtotal), 20) + " =========================");
//                    }
                    //subtotal = 0;
//                    if(cod_conta.equalsIgnoreCase("001.08.05.01.0.NA")){
//                        int a = 00;
//                    }
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//                    System.out.println(linha);
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                } else if (valoresValido()) {
                    temp = new ContaTemp();
                    temp.setValorunit(valorUnit);
                    temp.setQuantidade(quantidade);
                    temp.setValorTotal(valorTotal);
                    temp.setUnidade(undPDF);
                    temp.setDescricao(descPDF);
                    temp.setCodigo(linha_old.trim()+letraCodExterno);
                    meutotal += valorTotal;
                    //imprimirConta(temp);
                    List<ContaTemp> list = treeConta.get(cod_conta);
                    if (list == null) {
                        list = new Vector<ContaTemp>();
                        treeConta.put(cod_conta, list);
                    }
//                    if (codigoValido(list, temp.getCodigo())) {
                    list.add(temp);
//                    }else{
//                        System.out.println(cod_conta+ "       "+temp.getCodigo());
//                    }
                }else{
                    linha_old = linha;
                }
            }
            //
            double vlvl = 0;
            System.out.println("total importado " + Funcoes.FormatoMoedaBR_Double(totalgeral) + "  -   " + Funcoes.FormatoMoedaBR_Double(meutotal));
            Set<String> keys = treeConta.keySet();

            double valor = 0;
            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                String key = it.next();
                List<ContaTemp> listtemp = treeConta.get(key);
                valor = 0;
                for (ContaTemp contaTemp : listtemp) {
                    vlvl += contaTemp.getValorTotal();
                    String truncado = key.substring(0, 9);
//                    if (key.equalsIgnoreCase("001.08.NAGesso corrido aplicado sobre alvenaria bloco cerâmico")) {
//                        System.out.println(contaTemp.codigo + "  " + contaTemp.getDescricao() + "   " + contaTemp.getValorTotal());
//                    }
                    valor += contaTemp.getValorTotal();
                }
//                System.out.println(formatLeft(key, 60) + " - " + formatReight(Funcoes.FormatoMoedaBR_Double(valor), 15));
            }
//            System.out.println("total" + Funcoes.FormatoMoedaBR_Double(vlvl));

            lerXLS();
        } catch (Exception e) {
            System.out.println("erro linha " + lin);
            e.printStackTrace();
        }
    }

    public boolean codigoValido(List<ContaTemp> lis, String cod) {

        for (ContaTemp contaTemp : lis) {
            if (contaTemp.getCodigo().equalsIgnoreCase(cod)) {
                return false;
            }
        }
        return true;
    }

    public void imprimirConta(ContaTemp temp) {
        String row = formatLeft(temp.getDescricao(), 80);
        row += formatReight(Funcoes.FormatoMoedaBR_Double(temp.getQuantidade()), 15);
        row += formatReight(Funcoes.FormatoMoedaBR_Double(temp.getValorunit()), 15);
        row += formatReight(Funcoes.FormatoMoedaBR_Double(temp.getValorTotal()), 15);
        subtotal += temp.valorTotal;
//        System.out.println(row);
    }

    public String formatLeft(String descricao, int column) {
        String desc = descricao;
        int restante = column - desc.length();
        for (int i = 0; i < restante; i++) {
            desc += " ";
        }
        return desc;
    }

    public String formatReight(String valor, int column) {
        String vl = "";
        int saldo = column - valor.length();
        for (int i = 0; i < saldo; i++) {
            vl += " ";
        }
        vl += valor;
        return vl;
    }

    public void lerXLS() throws Exception {
        int lin = 24;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(arq_arquivoT.getArq_bt_arquivo());
            Workbook workbook = Workbook.getWorkbook(bais);
            Sheet sheet = workbook.getSheet(0);
            float valorLido = 0;
            float valorImp = 0;
            String doc = "";
            String key = "";
            String nome = "";
            String data = "";
            String vlunit = "";
            String vlTotal = "";
            int linha = 0;
            String dt_emissao = "";
            double tot = 0;
            double totmult = 0;
            int cont = 0;
            for (int i = 7; i < (sheet.getRows() - 1); i++) {
                if (linhaValida(sheet.getCell(1, i).getContents().trim())) {
                    lin = i;
                    cont++;
                    String codigo = sheet.getCell(0, i).getContents().trim()+letraCodExterno;
                    String descricao = sheet.getCell(1, i).getContents().trim();
                    descricao = descricao.trim();
                    String und = sheet.getCell(2, i).getContents().trim();
                    String qtde = sheet.getCell(3, i).getContents().trim();
                    String vlUnitStr = sheet.getCell(4, i).getContents().trim();
                    String vlTotalStr = sheet.getCell(5, i).getContents().trim();
                    int nivel = getNivel(codigo);
                    if (nivel >= 4) {
                        descricao = clearDescriaco(descricao);
                    }
//                    if(codigo.equalsIgnoreCase("001.04.06.01")){
//                        int a = 222;
//                    }

                    float quantidade = 0;
                    float valorUnitario = 0;
                    float valortot = 0;
                    if (und.trim().length() > 0) {
                        qtde = qtde.replace(".", "");
                        qtde = qtde.replace(",", ".");
                        quantidade = Float.parseFloat(qtde);
                        vlUnitStr = vlUnitStr.replace(".", "");
                        vlUnitStr = vlUnitStr.replace(",", ".");
                        valorUnitario = Float.parseFloat(vlUnitStr);
                        vlTotalStr = vlTotalStr.replace(".", "");
                        vlTotalStr = vlTotalStr.replace(",", ".");
                        valortot = Float.parseFloat(vlTotalStr);
                    }
                    if (lin == 8242) {
                        int a = 2;
                    }
                    Plco_plano_contas_orcamentoT plco = new Plco_plano_contas_orcamentoT();
                    insertPlco(codigo, descricao, nivel, false, "", und, plco, quantidade, valorUnitario, true, valortot);

//                    int lengt = codigo.length();
//                    if (lengt > 6) {
//                        lengt = 6;
//                    }
//
//                    String desc = descricao;
//                    if (desc.length() > 49) {
//                        desc = desc.substring(0, 50).trim();
//                    }
//                    String truncado = codigo.substring(0, lengt) + letraCodExterno + desc.trim();

                    List<ContaTemp> list = treeConta.get(codigo);
                    if (list != null) {
                        String newcod = codigo;
                        for (int j = nivel; j < 4; j++) {
                            newcod += ".01";
                            insertPlco(newcod, descricao, j + 1, false, "", und, plco, quantidade, valorUnitario, true, valortot);
                        }
                        for (ContaTemp contaTemp : list) {
                            plco = new Plco_plano_contas_orcamentoT();
                            insertPlco(contaTemp.getCodigo(), contaTemp.getDescricao(), nivel + 1, true, "", contaTemp.getUnidade(), plco, contaTemp.getQuantidade(), contaTemp.getValorunit(), false, contaTemp.getValorTotal());
                            tot += contaTemp.getValorTotal();
                            totmult += contaTemp.getValorunit() * contaTemp.getQuantidade();
                        }
                    } else {
                        if (und.trim().length() > 0) {
//                            System.out.println(codigo);
                        }
                    }
                }
            }

//            System.out.println("total xls              " + Funcoes.formatoMoedaDouble(tot));
//            System.out.println("total xls multiplicação" + Funcoes.formatoMoedaDouble(totmult));
        } catch (Exception e) {
            System.out.println("Erro na linha " + cont);
            setMsg("Erro na linha " + lin);
            status = "FALHA";
            throw e;
        } finally {
        }
    }

    public boolean linhaValida(String vllinha) {
        return vllinha.trim().length() > 0;
    }

    public String clearDescriaco(String codigo) {

        String newCodigo = "";
        for (int i = 0; i < codigo.length(); i++) {
            String ch = codigo.substring(i, i + 1);
            int hash = ch.hashCode();
            if (hash != 160) {
                newCodigo += ch;
            }
        }
        return newCodigo;
    }

    public int getNivel(String codigo) {
        int cont = 0;
        for (int i = 0; i < codigo.length(); i++) {
            String ch = codigo.substring(i, i + 1);
            if (ch.equalsIgnoreCase(".")) {
                cont++;
            }

        }
        return cont + 1;
    }

    public boolean valoresValido() {
        if (linha.indexOf("RM Solum") < 1) {
            int idx = posicaoEspacoDecrecente(linha);
            String newlin  = linha.substring(0,idx);
            if (idx > 0) {
                try {
                    String vl1 = linha.substring(idx,linha.length()).trim();
                    vl1 = vl1.replace(".", "");
                    vl1 = vl1.replace(",", ".");
                    valorTotal = Double.parseDouble(vl1);
                    if (valorTotal > -1) {
                        idx = posicaoEspacoDecrecente(newlin);
                        String vl2 = newlin.substring(idx, newlin.length()).trim();
                        newlin = newlin.substring(0, idx);
                        vl2 = vl2.replace(".", "");
                        vl2 = vl2.replace(",", ".");
                        valorUnit = Double.parseDouble(vl2);
                        if (valorUnit > -1) {
                            idx = posicaoEspacoDecrecente(newlin);
                            String vl3 = newlin.substring(idx, newlin.length()).trim();
                            newlin = newlin.substring(0, idx);
                            vl3 = vl3.replace(".", "");
                            vl3 = vl3.replace(",", ".");
                            quantidade = Double.parseDouble(vl3);
                            if (quantidade > -1) {
                                idx = posicaoEspacoDecrecente(newlin);
                                undPDF = newlin.substring(idx, newlin.length());
                                descPDF  = newlin.substring(0, idx);
                                totalgeral += valorTotal;
                                return true;
                            }
                        }
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean children() {
        if (linha.indexOf("RM Solum") < 1) {
            int cont = qtSeparador();
            if (cont == 3) {
                return true;
            }
        }
        return false;
    }

    public int posicaoEspaco() {
        String caracter = "";
        int index = 0;
        for (int i = 0; i < linha.trim().length(); i++) {
            caracter = linha.substring(i, i + 1);
            if (caracter.equalsIgnoreCase(" ")) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int posicaoEspacoDecrecente(String row) {
        String caracter = "";
        int index = 0;
        for (int i = row.trim().length(); i > 0; i--) {
            caracter = row.substring(i - 1, i);
            if (caracter.equalsIgnoreCase(" ")) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int qtSeparador() {
        int cont = 0;
        String caracter = "";
        String codigo = linha.substring(0, posicaoEspaco());
        for (int i = 0; i < codigo.length(); i++) {
            caracter = codigo.substring(i, i + 1);
            if (caracter.equalsIgnoreCase(".")) {
                cont++;
            }
        }
        return cont;
    }

    public boolean contaSuper() {
        boolean res = false;
        int cont = qtSeparador();
        if (cont > 0) {
            String valor = linha.substring(linha.length() - 1, linha.length());
            res = valor.equalsIgnoreCase(":");
        }
        return res;
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
    public Arq_arquivoT getArq_arquivoTPDF() {
        return arq_arquivoTPDF;
    }

    /**
     * @param arq_arquivoTPDF the arq_arquivoTPDF to set
     */
    public void setArq_arquivoTPDF(Arq_arquivoT arq_arquivoTPDF) {
        this.arq_arquivoTPDF = arq_arquivoTPDF;
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
