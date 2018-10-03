/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
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
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author marcos
 */
public class AdmXlsPagas extends SystemBase {

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

    public AdmXlsPagas(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.status = status;
        povoaTreeNumero();
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTreeAdmxls(this.ctp_conta_pagarT);
//            TreeMap<String, Ctp_conta_pagarT> treeTemp = new TreeMap<String, Ctp_conta_pagarT>();
//            String key;
//            Set<String> keys = treeConta.keySet();
//            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
//                key = it.next();
//                String keyok = clearEspaco(key);
//                treeTemp.put(keyok, treeConta.get(key));
//            }
//
//            treeConta.clear();
//            treeConta = treeTemp;
            int a = 1;
        } catch (Exception e) {
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

    public String read() {

        int lin = 1;
        try {
            boolean despesa = false;
            povoaConta();
            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("ISO-8859-1");
            //ws.setEncoding("NTF-8");
            ws.setLocale(new Locale("pt", "BR"));
            Workbook workbook = Workbook.getWorkbook(is, ws);

            Sheet sheet = workbook.getSheet(0);

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
            int cont = 0;
            int continsert = 0;
            String dt_emissao = "";
            String obs = "";
            String dthr;
            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
            for (int i = 0; i < (sheet.getRows() - 1); i++) {
                linha++;
                //Strin col1

                if (cont == 1127) {
                    int a = 0;

                }
                if (!despesa) {
                    String column = sheet.getCell(0, i).getContents().trim().toUpperCase();
                    int idx = column.indexOf("DESPESAS");
                    if (idx > -1 && idx < 9) {
                        despesa = true;
                    }
                }

                System.out.println("column 1 " + sheet.getCell(4, i).getContents().trim());

                vlunit = sheet.getCell(4, i).getContents().trim();
                if (despesa && valorValido(vlunit)) {

                    if (vlunit.indexOf("(") > -1) {
                        int a = 1;
                    }
                    boolean negativo = false;
                    if (vlunit.indexOf("(") > -1) {
                        negativo = true;
                        vlunit = vlunit.replace("(", "-");
                        vlunit = vlunit.replace(")", "");
                    }

                    cont++;
                    if (cont == 466250) {
                        int a = 2;
                    }

                    data = sheet.getCell(0, i).getContents().trim();
                    data = data.trim().length() > 7 ? data : "01/" + data;
                    nome = sheet.getCell(1, i).getContents().trim();
                    doc = sheet.getCell(2, i).getContents().trim();
                    try {
                        doc = doc.trim().isEmpty() ? "SD" : doc;
                        if (doc.indexOf("%") > -1) {
                            doc = "SD";
                        }
                    } catch (Exception e) {
                        doc = "SD";
                    }
                    obs = nome;
                    System.out.println(cont);
                    vlunit = vlunit.replace(".", "");
                    vlunit = vlunit.replace(",", ".");
                    if (dataValida(data)) {
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        dthr = new Date(System.currentTimeMillis()) + "";

                        Date dt = sdf2.parse(data);
                        String dts = sdf4.format(dt);

                        dthr = clearEspaco(dthr);
                        ctp_conta_pagarT.setCtp_nr_documento(doc);
                        ctp_conta_pagarT.setCtp_tx_fornecedor(nome.trim());
                        ctp_conta_pagarT.setCtp_nr_valor(Float.parseFloat(vlunit));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        ctp_conta_pagarT.setCtp_dt_emissao(sdf.parse(dts));
                        ctp_conta_pagarT.setCtp_dt_vencimento(sdf.parse(dts));
                        ctp_conta_pagarT.setCtp_tx_obs(obs);
                        StringBuffer buffer = new StringBuffer();

                        valorLido += Double.parseDouble(vlunit);

                        String chave = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento()) + "." + Funcoes.FormatoMoedaBR_Double(ctp_conta_pagarT.getCtp_nr_valor());

                        treeMesAtual.put(chave, ctp_conta_pagarT);
                        Ctp_conta_pagarT ctp = treeConta.get(chave);
                        if (!contaExiste(chave)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            valorImp += Double.parseDouble(vlunit);
                            continsert++;
                        }
                    }
                }
            }

            CriticaCTP_Alterada cTP_Alterada = new CriticaCTP_Alterada(ctp_conta_pagarT, dao, treeMesAtual);
            cTP_Alterada.criticaItens_and_value();

            //System.out.println("lido =" + cont + " inserido =" + continsert);
            dao.commitTransaction();
            String msg = "Total Lido = R$ " + Funcoes.FormatoMoedaBR_Double(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR_Double(valorImp);
            return msg;
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

    private boolean dataValida(String vl) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(vl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean valorValido(String vl) {
        try {

            vl = vl.replace(".", "");
            vl = vl.replace(",", ".");
            vl = vl.replace("(", "");
            vl = vl.replace(")", "");
            float val = Float.parseFloat(vl);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private float getValueFormat(String vl) throws Exception {
        try {
            vl = vl.replace(".", "");
            vl = vl.replace(",", ".");
            float val = Float.parseFloat(vl);
            return val;
        } catch (Exception e) {
            throw e;
        }
    }
}
