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
import java.util.Set;
import java.util.TreeMap;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author marcos
 */
public class LMarquezzoPagasXLS {

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

    public LMarquezzoPagasXLS(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.status = status;
        povoaTreeNumero();
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
            TreeMap<String, Ctp_conta_pagarT> treeTemp = new TreeMap<String, Ctp_conta_pagarT>();
            String key;
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
        //1330634831394|&1|&16/05/0011|&28.5
        //1330635249385|&1|&16/05/0011|&28.5
        Ctp_conta_pagarT ct = treeConta.get(key);
        if (treeConta.get(key) != null) {
            return true;
        }
        return false;
    }

    public String read() {
        int lin = 24;
        try {
            povoaConta();
            Workbook workbook = Workbook.getWorkbook(is);
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
            int cont = 464821;
            int continsert = 0;
            String dt_emissao = "";
            String obs = "";
            String dthr;
            SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yy");
            for (int i = 0; i < (sheet.getRows() -1); i++) {
                linha++;
                //Strin col1
                

                if(linha==2684){
                    int a = 0;

                }
                if (linha > 1) {
                    cont++;
                    nome = sheet.getCell(0, i).getContents().trim();
                    doc = sheet.getCell(3, i).getContents().trim();
                    obs = sheet.getCell(7, i).getContents().trim();
                    doc = doc.replace(" ", "");

                    String dataEmi = sheet.getCell(5, i).getContents().trim();
                    data = sheet.getCell(5, i).getContents().trim();
                    vlunit = sheet.getCell(8, i).getContents().trim();

                    if (doc.equalsIgnoreCase("33569/01")) {
                        System.out.println("data = " + data);
                        System.out.println("data = " + dataEmi);

                    }

                    vlunit = formatValueFloat(vlunit);
                    if (!valorValido(vlunit)) {
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");
                    }
                    if(linha == 6654){
                        int a = 0;
                    }

                    if (valorValido(vlunit)) {
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        dthr = new Date(System.currentTimeMillis()) + "";

//                        System.out.println(linha+"");
                        Date dt = sdf2.parse(data);
                        String dts = sdf4.format(dt);
                        String chave = doc + "." + dts;

                        if (doc.equalsIgnoreCase("33569/01")) {
//                            System.out.println("============================================================================================================================================================================================================== = ");
//                            System.out.println("data = " + data);
                            dt = sdf2.parse(data);
//                            System.out.println("dt = " + dt);
                            dts = sdf4.format(dt);
//                            System.out.println("dts = " + dts);
                        }


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
                        treeMesAtual.put(chave, ctp_conta_pagarT);
                        Ctp_conta_pagarT ctp = treeConta.get(chave);
                        if (!contaExiste(chave)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            valorImp += Double.parseDouble(vlunit);
                            continsert++;
                        }else{
//                            System.out.println(doc +" - "+dts);
                            ctp.setCtp_dt_vencimento(sdf.parse(dts));
                            ctp_conta_pagarDAO.updateVencimento(ctp);
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
