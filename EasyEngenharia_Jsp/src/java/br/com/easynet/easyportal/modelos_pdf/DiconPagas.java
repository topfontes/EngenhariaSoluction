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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author marcos
 */
public class DiconPagas {

    private List<Ctp_conta_pagarT> list;
    private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private String linha;
    private InputStream is;
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

    public DiconPagas() {
    }

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

    public DiconPagas(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.status = status;
        povoaTreeNumero();
        //deletarAllContas();
        povoaConta();

    }

    public void deletarAllContas() throws Exception {
        if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
            ctp_conta_pagarDAO.deleteAll(ctp_conta_pagarT);
        }
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
            TreeMap<String, Ctp_conta_pagarT> treeTemp = new TreeMap<String, Ctp_conta_pagarT>();
            String key;
            if (treeConta != null) {
                System.out.println("total tree " + treeConta.size());
            }else{
                System.out.println("Tree null");
            }

            Set<String> keys = treeConta.keySet();
            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                key = it.next();
                String keyok = clearEspaco(key);
                treeTemp.put(keyok, treeConta.get(key));
            }

            treeConta.clear();
            treeConta = treeTemp;
            int a = 1;



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] ar) {
//        try {
//            DiconPagas pagas = new DiconPagas();
//            pagas.clearEspaco("bol. 09909");
//        } catch (Exception e) {
//        }
//    }
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

    public boolean contaExiste(String key) {
        Ctp_conta_pagarT ct = treeConta.get(key);
        if (treeConta.get(key) != null) {
            return true;
        }
        return false;
    }

    public String read() {
        int lin = 24;
        try {
            System.out.println("workbook");
                        WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("ISO-8859-1");
            ws.setLocale(new Locale("pt", "BR"));
            Workbook workbook = Workbook.getWorkbook(is,ws);
            Sheet sheet = workbook.getSheet(0);
            System.out.println("Sheet");
            double valorLido = 0;
            double valorImp = 0;
            String doc = "";
            String key = "";
            String nome = "";
            String data = "";
            String vlunit = "";
            String vlTotal = "";
            //System.out.println("xls----------------------------------------------------");

            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            int linha = 0;
            String dt_emissao = "";
            System.out.println("Sheet " + sheet.getRows());
            for (int i = 10; i < (sheet.getRows() - 1); i++) {
                lin = i;

                if (lin == 5000 || lin == 10000 || lin == 15000 || lin == 20000 || lin == 25000) {
                    System.out.println(" linha " + lin);
                }
                //Strin col1
                if (lin == 6489) {
                    int d = 3;
                }
                if (isData(sheet.getCell(1, i).getContents().trim())) {
                    dt_emissao = sheet.getCell(1, i).getContents().trim();
                } else if (linhaValida(sheet.getCell(11, i).getContents().trim())) {
                    nome = sheet.getCell(0, i).getContents().trim();
                    doc = getdoc(sheet.getCell(4, i).getContents().trim());
                    doc += "-" + sheet.getCell(7, i).getContents().trim();
                    data = sheet.getCell(11, i).getContents().trim();
                    vlunit = sheet.getCell(23, i).getContents().trim();

                    vlunit = vlunit.replace("T", "");
                    vlunit = vlunit.replace("P", "");

                    vlunit = formatValueFloat(vlunit);
                    if (!valorValido(vlunit)) {
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");
                    }

//                    vlunit = vlunit.replace(".", "");//38710428
//                    vlunit = vlunit.replace(",", ".");

                    if ("NF.49311-11210/4".equalsIgnoreCase(doc)) {
                        int a = 2;
                    }
                    if (valorValido(vlunit)) {
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        ctp_conta_pagarT.setCtp_nr_documento(doc);
                        if (nome.length() > 100) {
                            nome = nome.substring(0, 99);
                        }
                        ctp_conta_pagarT.setCtp_tx_fornecedor(nome);
                        ctp_conta_pagarT.setCtp_nr_valor(Float.parseFloat(vlunit));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        ctp_conta_pagarT.setCtp_dt_emissao(sdf.parse(dt_emissao));
                        ctp_conta_pagarT.setCtp_dt_vencimento(sdf.parse(data));
                        key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                        key = clearEspaco(key);
//                        System.out.println(key);
                        if (ctp_conta_pagarT.getCtp_nr_documento().equalsIgnoreCase("NF.5139-5085/1")) {
//                          System.out.println(key);
                        }

                        if ("NF.49311-11210/4".equalsIgnoreCase(doc)) {
                            System.out.println(key);
                        }
                        valorLido += Double.parseDouble(vlunit);
                        treeMesAtual.put(key, ctp_conta_pagarT);
                        if (!contaExiste(key)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            valorImp += Double.parseDouble(vlunit);
                        } else {
                            if (treeConta.get(key).getCtp_nr_valor() != ctp_conta_pagarT.getCtp_nr_valor()) {
                                System.out.println(ctp_conta_pagarT.getCtp_nr_documento());
                            }
                        }
                    }
                }
            }
//            CriticaCTP_Alterada cTP_Alterada = new CriticaCTP_Alterada(ctp_conta_pagarT, dao, treeMesAtual);
//            cTP_Alterada.criticaItens_and_value();
            dao.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR_Double(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR_Double(valorImp);
        } catch (Exception e) {
            System.out.println("Erro na linha " + lin);
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

    public String getdoc(String doc) {
        int p = getPosEspaco(doc);
        doc = doc.substring(p, doc.length());
        return doc;
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

    public boolean isData(String nomeData) {
        try {
            nomeData = nomeData.trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(nomeData.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean linhaValida(String nomeData) {
        try {
            nomeData = nomeData.trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(nomeData.trim());
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
