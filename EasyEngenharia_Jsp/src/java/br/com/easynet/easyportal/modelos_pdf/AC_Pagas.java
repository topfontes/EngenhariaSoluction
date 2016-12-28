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
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author marcos
 */
public class AC_Pagas {

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
    private TreeMap<String, Ctp_conta_pagarT> treeMesAtual = new TreeMap<String, Ctp_conta_pagarT>();

    public AC_Pagas(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.status = status;

        //deletarAllContas();
        if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("P")) {
            povoaConta();
        }
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
        } catch (Exception e) {
        }
    }

    public boolean contaExiste(String key) {
        if (treeConta.get(key) != null) {
            return true;
        }
        return false;
    }

    public String read() {
        int lin = 24;
        try {
                        WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("ISO-8859-1");
            ws.setLocale(new Locale("pt", "BR"));
            Workbook workbook = Workbook.getWorkbook(is,ws);
            Sheet sheet = workbook.getSheet(0);
            float valorLido = 0;
            float valorImp = 0;
            String doc = "";
            String key = "";
            String nome = "";
            String data = "";
            String vlunit = "";
            String vlTotal = "";
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            int linha = 0;
            String dt_emissao = "";
            for (int i = 10; i < (sheet.getRows() - 1); i++) {
                lin = i;
//                String col0 = sheet.getCell(0, i).getContents().trim();
//                String col1 = sheet.getCell(1, i).getContents().trim();
//                String col2 = sheet.getCell(2, i).getContents().trim();
//                String col3 = sheet.getCell(3, i).getContents().trim();
//                String col4 = sheet.getCell(4, i).getContents().trim();
//
//                String col5 = sheet.getCell(5, i).getContents().trim();
//                String col6 = sheet.getCell(6, i).getContents().trim();
//                String documento = sheet.getCell(7, i).getContents().trim();
//                String col8 = sheet.getCell(8, i).getContents().trim();
//
//                String col9 = sheet.getCell(9, i).getContents().trim();
//                String col10 = sheet.getCell(10, i).getContents().trim();
//                String dataVencimento = sheet.getCell(11, i).getContents().trim();
//                String col12 = sheet.getCell(12, i).getContents().trim();
//
//                String col13 = sheet.getCell(13, i).getContents().trim();
//                String valor = sheet.getCell(14, i).getContents().trim();
//                String col15 = sheet.getCell(15, i).getContents().trim();
//                String col16 = sheet.getCell(16, i).getContents().trim();
//
//                String col28 = sheet.getCell(17, i).getContents().trim();
//                String valo29 = sheet.getCell(18, i).getContents().trim();
//                String col130 = sheet.getCell(19, i).getContents().trim();
//                String col31 = sheet.getCell(20, i).getContents().trim();
//                String col21 = sheet.getCell(21, i).getContents().trim();
//                String col22 = sheet.getCell(22, i).getContents().trim();
//                String valor_liq = sheet.getCell(23, i).getContents().trim();
//                String col24 = sheet.getCell(24, i).getContents().trim();

                if (isData(sheet.getCell(2, i).getContents().trim())) {
                    dt_emissao = sheet.getCell(2, i).getContents().trim();
                } else if (linhaValida(sheet.getCell(11, i).getContents().trim())) {
                    nome = sheet.getCell(0, i).getContents().trim();
                    doc = getdoc(sheet.getCell(4, i).getContents().trim());
                    doc += "-" + sheet.getCell(7, i).getContents().trim();
                    data = sheet.getCell(11, i).getContents().trim();
                    vlunit = sheet.getCell(23, i).getContents().trim();
                    // liquido vlunit = sheet.getCell(13, i).getContents().trim();

                    vlunit = vlunit.replace("T", "");
                    vlunit = vlunit.replace("P", "");

                    vlunit = formatValueFloat(vlunit);
                    if (!valorValido(vlunit)) {
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");
                    }


                    if (valorValido(vlunit)) {
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        ctp_conta_pagarT.setCtp_nr_documento(doc);
                        ctp_conta_pagarT.setCtp_tx_fornecedor(nome);
                        ctp_conta_pagarT.setCtp_nr_valor(Float.parseFloat(vlunit));
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        ctp_conta_pagarT.setCtp_dt_emissao(sdf.parse(dt_emissao));
                        ctp_conta_pagarT.setCtp_dt_vencimento(sdf.parse(data));
                        key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                        treeMesAtual.put(key, ctp_conta_pagarT);
                        valorLido += ctp_conta_pagarT.getCtp_nr_valor();
                        if (!contaExiste(key)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            valorImp += ctp_conta_pagarT.getCtp_nr_valor();
                        }
                    }
                }
            }
            
            CriticaCTP_Alterada cTP_Alterada = new CriticaCTP_Alterada(ctp_conta_pagarT, dao, treeMesAtual);
            cTP_Alterada.criticaItens_and_value();
            
            dao.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
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
