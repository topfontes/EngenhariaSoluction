/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.dao.Ccff_copia_cronograma_fisico_financeiroDAO;
import br.com.easynet.gwt.easyportal.dao.Cffo_cronograma_fisico_financeiro_origenalDAO;
import br.com.easynet.gwt.easyportal.dao.Cli_clienteDAO;
import br.com.easynet.gwt.easyportal.dao.Dso_descricao_servico_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Emp_empreendimentoDAO;
import br.com.easynet.gwt.easyportal.dao.Ipo_item_plano_contas_obraDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.dao.Plco_plano_contas_orcamentoDAO;
import br.com.easynet.gwt.easyportal.dao.Pms_planilha_medicao_servicoDAO;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import br.com.easynet.gwt.easyportal.transfer.Cli_clienteT;
import br.com.easynet.gwt.easyportal.transfer.Dso_descricao_servico_obraT;
import br.com.easynet.gwt.easyportal.transfer.Emp_empreendimentoT;
import br.com.easynet.gwt.easyportal.transfer.Ipo_item_plano_contas_obraT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Plco_plano_contas_orcamentoT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author marcos
 */

public class ImportacaoNassalJB extends SystemBase implements INotSecurity {

    private TreeMap<Integer, Dso_descricao_servico_obraT> treeDescricao = new TreeMap<Integer, Dso_descricao_servico_obraT>();
    private int obr_nr_id;
    private int quantidadeImportados = 0;
    private String pathBase;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private Arq_arquivoT arq_arquivoTPDF = new Arq_arquivoT();
    private String linha;
    private TreeMap<String, List<ContaTemp>> treeConta = new TreeMap<String, List<ContaTemp>>();
    private String cod_conta = "";
    private double valorUnit;
    private double quantidade;
    private double valorTotal;
    private static final String ASPAS = "\"";
    private Ipo_item_plano_contas_obraT ipo_item_plano_contas_obraT = new Ipo_item_plano_contas_obraT();
    private int id_servico = 0;
    private int id_nivel_1 = 0;
    private int id_nivel_2 = 0;
    private int id_nivel_3 = 0;
    private int id_nivel_4 = 0;
    private int id_super = 0;
    private String letraCodExterno;
    private DAOFactory factory = null;
    private String status;
    private double totalgeral;
    private double subtotal;
    private Ipo_item_plano_contas_obraDAO idao ;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        totalgeral = 0;
        povoaTreeDescricao();
        letraCodExterno = "." + getLetraCliente();
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
            treeDescricao = ddao.getByObr_nr_id(getObr_nr_id());
        } catch (Exception e) {
            throw e;
        }
    }

    public Plco_plano_contas_orcamentoT locateObjecto(String codigo) throws Exception {
        Plco_plano_contas_orcamentoDAO pdao = getPlco_plano_contas_orcamentoDAO();
        return pdao.ObjetoValido(codigo);
    }

    public void insertPlco(String codigo_externo, String nome, int nivel, boolean curva_abc, String tipo, String unidade, Plco_plano_contas_orcamentoT plco, double qtde, double vl_unit, boolean cronograma) throws Exception {
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

            if(nivel == 1){
                id_super = 0;
                id_nivel_1 =0;
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
            if(nivel != 5){
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
        try {
            int q = 89;
//            System.out.println("teste método");

//            iniciarTransection();
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
//            factory.commitTransaction();
//            deleteImportacao();
        } catch (Exception e) {
            factory.rollbackTransaction();
            throw e;
        } finally {
            factory.close();
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
            
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                lin++;
                if (lin == 17) {
                    int a = 7;
                }
                contlinhaRodape++;
                linha = br.readLine().trim();
//                System.out.println(linha);

                if (contaSuper()) {
                    cod_conta = linha.substring(0, posicaoEspaco()).trim();
//                    if (subtotal > 0) {
//                        System.out.println("========================== Sub Total -" + formatReight(Funcoes.FormatoMoedaBR_Double(subtotal), 20) + " =========================");
//                    }
                    subtotal = 0;
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
//                    System.out.println(linha);
//                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                } else if (children()) {
                    try {
                        temp = new ContaTemp();
                        temp.setCodigo(linha.substring(0, posicaoEspaco()).trim());
                        temp.setDescricao(linha.substring(posicaoEspaco(), posicaoEspacoDecrecente()).trim());
                        temp.setUnidade(linha.substring(posicaoEspacoDecrecente(), linha.length()).trim());
                    } catch (Exception e) {
                    }

                } else if (valoresValido()) {
                    temp.setValorunit(valorUnit);
                    temp.setQuantidade(quantidade);
                    temp.setValorTotal(valorTotal);
                    //imprimirConta(temp);
                    List<ContaTemp> list = treeConta.get(cod_conta);
                    if (list == null) {
                        list = new Vector();
                        treeConta.put(cod_conta, list);
                    }
                    list.add(temp);
                }
            }
//            System.out.println("total importado " + Funcoes.FormatoMoedaBR_Double(totalgeral));
//            lerXLS();
        } catch (Exception e) {
            System.out.println("erro linha " + lin);
            e.printStackTrace();
        }
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

    public void lerXLS() {
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
            for (int i = 7; i < (sheet.getRows() - 1); i++) {
                lin = i;
                String codigo = sheet.getCell(0, i).getContents().trim();
                String descricao = sheet.getCell(1, i).getContents().trim();
                String und = sheet.getCell(2, i).getContents().trim();
                String qtde = sheet.getCell(3, i).getContents().trim();
                String vlUnitStr = sheet.getCell(4, i).getContents().trim();
                String vlTotalStr = sheet.getCell(5, i).getContents().trim();
                int nivel = getNivel(codigo);
                float quantidade = 0;
                float valorUnitario = 0;
                if (und.trim().length() > 0) {
                    qtde = qtde.replace(".", "");
                    qtde = qtde.replace(",", ".");
                    quantidade = Float.parseFloat(qtde);
                    vlUnitStr = qtde.replace(".", "");
                    vlUnitStr = qtde.replace(",", ".");
                    valorUnitario = Float.parseFloat(vlUnitStr);
                }
                Plco_plano_contas_orcamentoT plco = new Plco_plano_contas_orcamentoT();
                insertPlco(codigo, descricao, nivel, false, "", und, plco, quantidade, valorUnitario, true);
                List<ContaTemp> list = treeConta.get(codigo);
                if (list != null) {
                    for (ContaTemp contaTemp : list) {
                        plco = new Plco_plano_contas_orcamentoT();
                        insertPlco(contaTemp.getCodigo(), contaTemp.getDescricao(), nivel + 1, true, "", contaTemp.getUnidade(), plco, contaTemp.getQuantidade(), contaTemp.getValorunit(), false);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro na linha " + lin);
            setMsg("Erro na linha "+lin);
            status = "FALHA";
            e.printStackTrace();
        } finally {
            close();
        }
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
            int idx = posicaoEspaco();
            if (idx > 0) {
                try {
                    String vl1 = linha.substring(0, idx).trim();
                    vl1 = vl1.replace(".", "");
                    vl1 = vl1.replace(",", ".");
                    valorUnit = Double.parseDouble(vl1);
                    if (valorUnit > -1) {
                        int idx2 = posicaoEspacoDecrecente();
                        String vl2 = linha.substring(idx, idx2).trim();
                        vl2 = vl2.replace(".", "");
                        vl2 = vl2.replace(",", ".");
                        quantidade = Double.parseDouble(vl2);
                        if (quantidade > -1) {
                            String vl3 = linha.substring(idx2, linha.length()).trim();
                            vl3 = vl3.replace(".", "");
                            vl3 = vl3.replace(",", ".");
                            valorTotal = Double.parseDouble(vl3);
                            if (valorTotal > -1) {
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

    public int posicaoEspacoDecrecente() {
        String caracter = "";
        int index = 0;
        for (int i = linha.trim().length(); i > -1; i--) {
            caracter = linha.substring(i - 1, i);
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
        if (cont == 3) {
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
