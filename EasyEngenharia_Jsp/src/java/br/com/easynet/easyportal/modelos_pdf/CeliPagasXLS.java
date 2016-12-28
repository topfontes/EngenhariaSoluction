/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.util.CriticaCTP_Alterada;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author marcos
 */
public class CeliPagasXLS {

    private List<Ctp_conta_pagarT> list;
    private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private String linha;
    private InputStream is;
    private InputStream is_anexo;
    private Funcoes funcoes = new Funcoes();
    private double totalImp;
    private File file;
    private DAOFactory dao;
    private String quebraPaginaCodigo;
    private String status;
    private float valor;
    private Date dt_baixa;
    private static final String ASPAS = "\"";
    private TreeMap<String, String> treNumero = new TreeMap<String, String>();
    private TreeMap<String, Ctp_conta_pagarT> treeMesAtual = new TreeMap<String, Ctp_conta_pagarT>();
    private TreeMap<Integer, String> treeFornecedor = new TreeMap<Integer, String>();

    public void povoaTreeNumero() {
        treNumero.put("0", "0");
        treNumero.put("1", "1");
        treNumero.put("2", "2");
        treNumero.put("3", "3");
        treNumero.put("4", "4");
        treNumero.put("5", "5");
        treNumero.put("6", "6");
        treNumero.put("7", "7");
        treNumero.put("8", "8");
        treNumero.put("9", "9");
    }

    public CeliPagasXLS(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is, InputStream is_anexo) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.ctp_conta_pagarDAO.setArquivo_engeb(true);
        this.is = is;
        this.is_anexo = is_anexo;
        this.status = status;
        povoaTreeNumero();
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String clearEspaco(String valor) {

        if (valor.indexOf("SE") > -1) {
            int a = 1;
        }
        String novovalor = "";
        int p = 0;
        for (int i = 0; i < valor.length(); i++) {
            String ch = valor.substring(i, i + 1);
            if (treNumero.get(ch) != null) {
                p = i;
                break;
            }
        }
        novovalor = valor.substring(p, valor.length());
        return novovalor;
    }

    public boolean contaExisteID(Ctp_conta_pagarT ctp_conta_pagarT) throws Exception {
        try {
            return ctp_conta_pagarDAO.getByPK(ctp_conta_pagarT).size() > 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean contaExiste(String key) {
        Ctp_conta_pagarT ct = treeConta.get(key);
        if (treeConta.get(key) != null) {
            return true;
        }
        return false;
    }

    public void read_Anexo() throws Exception {
        try {
                        WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("ISO-8859-1");
            ws.setLocale(new Locale("pt", "BR"));
            Workbook workbook = Workbook.getWorkbook(is_anexo,ws);
            Sheet sheet = workbook.getSheet(0);
            int linha = 5;
            String fornecedor = "";
            int codigo = 0;
            for (int i = 5; i < (sheet.getRows() - 1); i++) {
                String value = sheet.getCell(0, i).getContents().trim();
                String valueCod = sheet.getCell(1, i).getContents().trim();
                if (!value.trim().isEmpty()) {
                    fornecedor = value.trim();
                } else if (!valueCod.trim().isEmpty()) {
                    if (Integer.parseInt(valueCod) != codigo) {
                        codigo = Integer.parseInt(valueCod);
                        treeFornecedor.put(codigo, fornecedor);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public String read() {
        int lin = 24;
        try {
            read_Anexo();
            povoaConta();
            Workbook workbook = Workbook.getWorkbook(is);
            Sheet sheet = workbook.getSheet(0);
            double valorLido = 0;
            double valorImp = 0;
            String doc = "";
            String key = "";
            String fornecedor = "";
            String data = "";
            String vlunit = "";
            String vlTotal = "";
            String parcela = "";
            String hist = "";
            //System.out.println("xls----------------------------------------------------");

            dao = ctp_conta_pagarDAO.getDAOFactory();

            dao.beginTransaction();
            int linha = 0;
            int cont = 464821;
            int continsert = 0;
            String dt_emissao = "";
            String ref = "";
            String dthr;
            int countfornulo = 0;
            linha = 0;
            for (int i = 5; i < (sheet.getRows() - 1); i++) {
                linha++;
                cont++;
                doc = sheet.getCell(8, i).getContents().trim();
                
                if (doc.trim().length() > 0) {
                    ref = sheet.getCell(4, i).getContents().trim();
                    fornecedor = sheet.getCell(7, i).getContents().trim();
                    hist = sheet.getCell(13, i).getContents().trim();
                    data = sheet.getCell(10, i).getContents().trim();
                    data = data.replace(".", "/");
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
                    Date dt = sdf1.parse(data);

                    sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    String vencimento = sdf1.format(dt);

                    vlunit = sheet.getCell(11, i).getContents().trim();
                    parcela = "X/Y";

                    vlunit = formatValueFloat(vlunit);
                    if (!valorValido(vlunit)) {
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");
                    }
                    if (valorValido(vlunit)) {
                        dthr = new Date(System.currentTimeMillis()) + "";
                        String ddcc = doc;
                        if (doc.length() > 30) {
                            ddcc = doc.substring(0, 29);
                        }
                        if (ddcc.trim().length() == 0) {
                            ddcc = dthr;
                        }
                        ctp_conta_pagarT.setCtp_nr_documento(ddcc);
                        float newvalue = Float.parseFloat(vlunit);
                        if (newvalue < 0) {
                            newvalue = newvalue * -1;
                        }
                        ctp_conta_pagarT.setCtp_nr_valor(newvalue);
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                        String nome_for = treeFornecedor.get(Integer.parseInt(fornecedor));
                        if (nome_for == null) {
                            ++countfornulo;
                            //System.out.println("nullo " + fornecedor);
                            nome_for = fornecedor+" - CELI";
                        } else {
                            nome_for = nome_for.trim().replace("&", "E");
                            nome_for = nome_for.trim().replace("ç", "c");
                            nome_for = nome_for.trim().replace("Ç", "c");
                            nome_for = nome_for.trim().replace("\\n", " ");
                            nome_for = nome_for.trim().replace("\\r", " ");
                            nome_for = nome_for.trim().replace("/r", " ");
                        }
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        ctp_conta_pagarT.setCtp_nr_documento(doc);
                        ctp_conta_pagarT.setCtp_tx_fornecedor(nome_for.trim());
                        ctp_conta_pagarT.setCtp_dt_emissao(sdf.parse(vencimento));
                        ctp_conta_pagarT.setCtp_dt_vencimento(sdf.parse(vencimento));
                        ctp_conta_pagarT.setCtp_tx_obs(ref + " - " +hist);
                        ctp_conta_pagarT.setCtp_nr_valor(newvalue);
                        StringBuffer buffer = new StringBuffer();

                        String chave = ctp_conta_pagarDAO.getValueSemAspas(doc);
                        chave += "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                        valorLido += newvalue;
                        treeMesAtual.put(chave, ctp_conta_pagarT);
                        if (!contaExiste(chave)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            valorImp += newvalue;
                            continsert++;
                        }

                    }
                }
            }
            //System.out.println("lido =" + cont + " inserido =" + continsert);
            CriticaCTP_Alterada cTP_Alterada = new CriticaCTP_Alterada(ctp_conta_pagarT, dao, treeMesAtual);
            cTP_Alterada.criticaItens_and_value();
            dao.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR_Double(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR_Double(valorImp);
        } catch (Exception e) {
            System.out.println("Erro na linha " + linha);
            e.printStackTrace();
        } finally {
            dao.close();
        }
        return null;
    }

    private String formatValueFloat(String valor) {
        String newValor = valor;
        if (valor.length() - 3 > 0) {
            String vl = valor.substring(valor.length() - 3, valor.length() - 2);
            if (vl.equalsIgnoreCase(".")) {
                newValor = valor.replace(",", "");
//                System.out.println("ponto. " + newValor);
            }
        }
        return newValor;
    }

    private boolean valorValido(String val) {
        try {
            float vl = Float.parseFloat(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getPosEspaco(String doc) {
        int p = 0;
        linha = doc.trim();
        String caracter = "";
        for (int i = linha.length(); i > 0; i--) {
            caracter = linha.substring(i - 1, i);
            if (caracter.equalsIgnoreCase(" ")) {
                p = i;
                break;
            }
        }
        return p;
    }
}
