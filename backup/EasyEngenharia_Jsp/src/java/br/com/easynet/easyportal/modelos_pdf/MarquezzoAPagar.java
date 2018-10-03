/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Ctpm_conta_pagar_modificadaDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.transfer.Ctpm_conta_pagar_modificadaT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import br.com.easynet.gwt.easyportal.util.CriticaCTP_Alterada;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class MarquezzoAPagar extends SystemBase {

    private List<Ctp_conta_pagarT> list;
    private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private Ctp_conta_pagarT ctp_conta_pagarT_Insert = new Ctp_conta_pagarT();
    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private static String linha;
    private InputStream is;
        private int posDoc = 0;
    private Funcoes funcoes = new Funcoes();
    DAOFactory dao;
    private double totalImp = 0;
    TreeMap<String, Integer> TreeNumeros = new TreeMap<String, Integer>();
    int posVirgula;
    TreeMap<String, Ctp_conta_pagarT> treeMesLan = new TreeMap<String, Ctp_conta_pagarT>();

    public MarquezzoAPagar(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        TreeNumeros.put("0", 0);
        TreeNumeros.put("1", 1);
        TreeNumeros.put("2", 2);
        TreeNumeros.put("3", 3);
        TreeNumeros.put("4", 4);
        TreeNumeros.put("5", 5);
        TreeNumeros.put("6", 6);
        TreeNumeros.put("7", 7);
        TreeNumeros.put("8", 8);
        TreeNumeros.put("9", 9);
        //deletarAllContas();
        //povoaConta();
    }

    public MarquezzoAPagar() {
        TreeNumeros.put("0", 0);
        TreeNumeros.put("1", 1);
        TreeNumeros.put("2", 2);
        TreeNumeros.put("3", 3);
        TreeNumeros.put("4", 4);
        TreeNumeros.put("5", 5);
        TreeNumeros.put("6", 6);
        TreeNumeros.put("7", 7);
        TreeNumeros.put("8", 8);
        TreeNumeros.put("9", 9);

    }

//    public static void main(String[] param) {
//        try {
//
//            linha = "450.000,0035 - AVIARIO MINHA CAS 05.01.01-TERRENO Transação";
//            MarquezzoAPagar marquezzo = new MarquezzoAPagar();
//            marquezzo.isDocumento2();
//            marquezzo.getValor();
//            marquezzo.getCodigo();
//        } catch (Exception e) {
//        }
//    }
    public void deletarAllContas() throws Exception {
        if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
            ctp_conta_pagarDAO.deleteAll(ctp_conta_pagarT);


        }
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);


        } catch (Exception e) {
        }
    }

    public boolean contaExiste(String key) {
//        if (treeConta.get(key) != null) {
//            return true;
//        }
        return false;


    }

    public boolean isDocumento() {

        int index = linha.indexOf("NO ");
        String lintemp = linha;


        boolean achou = false;


        int p = 0;


        if (index > -1) {
            index = index + 3;

            do {
                p = lintemp.indexOf(",");
                if (p > -1) {
                    p = p + 3;
                    String v = lintemp.substring(index, p).trim();
                    v = v.replace(".", "");
                    v = v.replace(",", ".");
                    float n;
                    try {
                        n = Float.parseFloat(v);
                        achou = true;
                        posDoc = p;

                    } catch (Exception e) {
                        lintemp = lintemp.substring(p, lintemp.length());
                        index = lintemp.indexOf("NO ");
                    }
                }
            } while (!achou & index - lintemp.length() > 3);



            return achou;



        }
        return false;


    }

    public String getCodigo() {
        String cod = linha.substring(posDoc, linha.length()).trim();
        return cod;


    }

    public String getFornecedor() {
        return linha.substring(11, linha.length()).trim();


    }

    public boolean isVencimento() {
        boolean res = false;
        try {
            if (linha.length() >= 12) {
                String nome = linha.substring(0, 12).trim();
                if ("Vencimento:".equalsIgnoreCase(nome)) {
                    res = true;
                } else {
                    nome = linha.substring(0, 7).trim();
                    res = "Baixa:".equalsIgnoreCase(nome);
                }
            }
            return res;
        } catch (Exception e) {
            return false;
        }
    }

    public Date getVencimento() {
        try {
            int index = linha.indexOf(":");
            String d1 = linha.substring(index + 1, linha.length()).trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(d1);


            return date;


        } catch (Exception e) {
        }
        return null;


    }

    public String getObs() {
        return linha.trim();


    }

    public String getObsValor() {
        int index = linha.indexOf("-");


        return linha.substring(index, linha.length()).trim();


    }

    public int posVirgula(String testo) {
        int p = 0;


        for (int i = testo.length(); i
                > 0; i--) {
            String l = testo.substring(i - 1, i);


            if (l.equalsIgnoreCase(",")) {
                p = i;
                i = 0;


            }
        }
        return p;


    }

    public int posEspaco() {
        int p = 0;
        //int pos_virgula = posVirgula();
        for (int i = posVirgula; i
                > 0; i--) {
            String l = linha.substring(i - 1, i);
            if (l.equalsIgnoreCase(" ")) {
                p = i;
                i = 0;
            }
        }
        return p;


    }

    public boolean isDocumento2() {
        try {
            boolean res = false;
            if(linha.indexOf("/04/G,104/09") > -1){
                int a= 0;
            }

            int duasVirgula = linha.indexOf(",,");
            if (duasVirgula > -1) {
                return false;
            }

            int posBarra = 0;
            int index = linha.length();
            String barra = linha.substring(index - 2, index - 1);
            if (barra.equalsIgnoreCase("/")) {
                posBarra = index - 2;
                String nm = linha.substring(index - 3, index - 2).trim();
                if (TreeNumeros.get(nm) != null) {
                    nm = linha.substring(index - 1, index);
                    if (TreeNumeros.get(nm) != null) {
                        res = true;
                        posBarra = index - 2;
                    }
                }
            } else {
                barra = linha.substring(index - 3, index - 2);
                if (barra.equalsIgnoreCase("/")) {
                    posBarra = index - 2;
                    String nm = linha.substring(index - 4, index - 3).trim();
                    if (TreeNumeros.get(nm) != null) {
                        nm = linha.substring(index - 2, index - 1);
                        if (TreeNumeros.get(nm) != null) {
                            res = true;
                            posBarra = index - 3;
                        }
                    }
                }
            }

            String[] qtBarra = linha.split("/");
            
            if (res) {
                boolean caracterNumero = true;
                for (int i = posBarra; i < linha.length(); i--) {
                    String carac = linha.substring(i - 1, i);
                    if (TreeNumeros.get(carac) == null) {
                        if (carac.equalsIgnoreCase(",") & caracterNumero /*& qtBarra.length < 4*/) {
                            int pe = posEspaco(linha, i);
                            posDoc = i + 2;
                            ;
                            String valor = linha.substring(pe, posDoc);
                            posVirgula = i;
                            res = new_ValorValido();
                            break;
                        } else {
                            caracterNumero = false;
                            res = false;
                            break;
                        }
                    }
                }
            } else {
                index = linha.indexOf("NO");
                
                if (index > -1) {
                    int index2 = linha.indexOf(",");
                    if (index2 > -1 & index2 > index) {
                        String num = linha.substring((index2 + 1), (index2 + 2));
                        try {
                            int n = Integer.parseInt(num);
                            num = linha.substring((index2 + 2), (index2 + 3));
                            n = Integer.parseInt(num);
                            res = true;
                            posVirgula = index2;
                        } catch (Exception e) {
                            res = false;
                        }
                    }
                }
            }
            return res;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean  new_ValorValido(){
        try {
            float valor = getValor();
            return true;
        } catch (Exception e) {
           return false;
        }
    }

    public boolean isValorValidos() {
        boolean bl = false;
        try {
            int id = linha.indexOf(",");
            if (id > -1) {
                for (int i = id; i < linha.length(); i++) {
                    String fracao1 = linha.substring((i), (i + 1));


                    if (TreeNumeros.get(fracao1) != null) {
                        String fracao2 = linha.substring((i + 1), (i + 2));

                        if (TreeNumeros.get(fracao2) != null) {
                            String decimal = linha.substring((i - 2), (i - 1));
                            if (TreeNumeros.get(decimal) != null) {
                                String doc = linha.substring((i + 3), linha.length());

                                if (doc.indexOf("/") > - 1) {
                                    bl = true;
                                    posVirgula = i;
                                    posDoc = i + 2;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            return false;


        } finally {
            return bl;


        }
    }

    public int posVirgula() {
        int p = 0;
        for (int i = linha.length(); i
                > 0; i--) {
            String l = linha.substring(i - 1, i);
            if (l.equalsIgnoreCase(",")) {
                p = i;
                i = 0;
            }
        }
        return p;
    }

    public int posEspaco(String testo) {
        int p = 0;
        int pos_virgula = posVirgula();
        for (int i = pos_virgula; i
                > 0; i--) {
            String l = testo.substring(i - 1, i);
            if (l.equalsIgnoreCase(" ")) {
                p = i;
                i = 0;
            }
        }
        return p;
    }

    public int posEspaco(String testo, int posvirgula) {
        int p = 0;
        int pos_virgula = posvirgula;
        for (int i = pos_virgula; i
                > 0; i--) {
            String l = testo.substring(i - 1, i);
            if (l.equalsIgnoreCase(" ")) {
                p = i;
                i = 0;
            }
        }
        return p;
    }

    public float getValor() throws Exception {
        int index = posEspaco();
        int index2 = posVirgula();
        index2 = index2 + 2;
        String vl = linha.substring(index, index2).trim();
        vl = vl.replace(".", "");
        vl = vl.replace(",", ".");
        float vlr = Float.parseFloat(vl);
        posDoc = index2;
        return vlr;
    }

    public boolean isFornecedor() throws Exception {
        try {
            boolean res = false;
            if (linha.length() >= 11) {
                String fornec = linha.substring(0, 11).trim();
                if (fornec.equals("Fornecedor")) {
                    if (linha.indexOf("Total") < 0) {
                        res = true;
                    }
                }
            }

            return res;
        } catch (Exception e) {
            return false;

        }

    }

    public boolean isrodape() {
        if (linha.length() >= 4) {
            String fim = linha.substring(0, 4).trim();
            if (fim.equals("REL")) {
                return true;
            }
        }
        return false;


    }

    /**
     * método de leitura do arquivo PDF e inserção dos registro no banco de dados.
     * @return resultado da leitura  e da inserção dos registros
     */
    public String read() {
        File file = null;
        int lin = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            list = new Vector();
            ConverPDFString converPDFString = new ConverPDFString();
            String path = converPDFString.getString(is);
            is.close();
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            boolean addhist = false;
            Date vencimento = null;
            float valor = 0;
            String hist = "";
            String documento = "";
            String fornecedor = "";
            int cont_linhaRodape = 0;
            double total = 0;
            totalImp = 0;
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            int cont = 0;
            while (br.ready()) {
                lin++;
                if(lin == 28 |lin == 10524 | lin == 10497| lin == 10509){
                    int o = 0;
                }
                if (lin == 41) {
                    int ff = 0;
                }
                linha = br.readLine();
                System.out.println("A pagar " +lin + "  " + linha);
                if (isrodape()) {
                    cont_linhaRodape = 0;
                }
                if (isFornecedor()) {
                    fornecedor = getFornecedor();
                } else if (isVencimento()) {
                    vencimento = getVencimento();
                    addhist = true;
                    hist = "";
                } else {
                    if (isDocumento2()) {
                        //if (cont > 0) {
                        valor = getValor();
                        documento = getCodigo();

                        String key = documento + "." + sdf.format(vencimento);
                        if (!contaExiste(key)) {
                            addObject(fornecedor, documento, vencimento, valor, hist);
                        }
                        //}
                        //hist = getObsValor();
                        cont++;
                        //valor = getValor();
                        total = total + valor;
                    } else if (addhist & cont_linhaRodape > 8) {
                        hist += " " + getObs();
                    }
                }
                cont_linhaRodape++;
            }

            String a = "s";
            br.close();
            fr.close();
            dao.commitTransaction();
            return "Total Geral lido = R$" + funcoes.FormatoMoedaBR_Double(total) + " Total Importados = R$" + funcoes.FormatoMoedaBR_Double(totalImp);
        } catch (Exception e) {
            dao.rollbackTransaction();
            e.printStackTrace();
            return "Erro na leitura do arquivo na linha " + lin + ", " + linha;
        } finally {
            file.delete();
            dao.close();
        }
    }


    public void addObject(String fornecedor, String documento, Date vencimento, float valor, String hist) throws Exception {
        try {
            ctp_conta_pagarT_Insert.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
            ctp_conta_pagarT_Insert.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
            ctp_conta_pagarT_Insert.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
            ctp_conta_pagarT_Insert.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
            ctp_conta_pagarT_Insert.setCtp_tx_fornecedor(fornecedor);
            ctp_conta_pagarT_Insert.setPlc_nr_id(0);
            ctp_conta_pagarT_Insert.setCtp_nr_documento(documento);
            ctp_conta_pagarT_Insert.setCtp_dt_vencimento(vencimento);
            ctp_conta_pagarT_Insert.setCtp_nr_valor(valor);

            String obs = hist;
            if (hist.length() > 299) {
                obs = hist.substring(0, 299).trim();
            }
            ctp_conta_pagarT_Insert.setCtp_tx_obs(obs);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(vencimento);
            treeConta.put(key, ctp_conta_pagarT);

            ctp_conta_pagarDAO.insert(ctp_conta_pagarT_Insert);
            totalImp = totalImp + ctp_conta_pagarT_Insert.getCtp_nr_valor();


        } catch (Exception e) {
            System.out.println("Erro: " + documento);
            e.printStackTrace();

        }

    }
}
