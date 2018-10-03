/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.easyportal.modelos_pdf.*;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import br.com.easynet.gwt.easyportal.util.CriticaCTP_Alterada;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class ModuloPagas extends SystemBase {

    private List<Ctp_conta_pagarT> list;
    private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private static String linha;
    private InputStream is;
    private int posEspacoValor = 0;
    private Funcoes funcoes = new Funcoes();
    private DAOFactory dao;
    private Ctp_conta_pagarDAO ctpDAO;
    Ctp_conta_pagarT ctp_conta_pagarT_Insert = new Ctp_conta_pagarT();
    private double totalImp;
    private TreeMap<String, Integer> TreeNumeros = new TreeMap<String, Integer>();
    private int posvisgula;
    int cont_linhaRodape = 0;
    private List<String> list_Fornec = new ArrayList<String>();
    private TreeMap<String, Ctp_conta_pagarT> treeMesAtual = new TreeMap<String, Ctp_conta_pagarT>();
    private String fornecedor = "";

    public ModuloPagas() {
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

    public ModuloPagas(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
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
        povoaConta();
    }

//    public static void main(String[] param) {
//        linha = "Pedido/4355QT 2.450,006428/5/1";
//        try {
//            ModuloPagas marquezzo = new ModuloPagas();
//            marquezzo.isDocumento();
//             marquezzo.getCodigo();
//            marquezzo.getValor();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
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

    public int posVirgula() {
        int p = 0;
        for (int i = linha.length(); i > 0; i--) {
            String l = linha.substring(i - 1, i);
            if (l.equalsIgnoreCase(",")) {
                p = i;
                i = 0;
            }
        }
        return p;
    }

    public int posEspaco() {
        int p = 0;
        int pos_virgula = posVirgula();
        for (int i = pos_virgula; i > 0; i--) {
            String l = linha.substring(i - 1, i);
            if (l.equalsIgnoreCase(" ")) {
                p = i;
                i = 0;
            }
        }
        return p;
    }

    public boolean isDocumento() {
        try {
            boolean res = false;
            int posBarra = 0;
            int index = linha.length();
            String barra = linha.substring(index - 2, index - 1);
            if (barra.equalsIgnoreCase("/")) {
                res = true;
                posBarra = index - 2;
            } else {
                barra = linha.substring(index - 3, index - 2);
                if (barra.equalsIgnoreCase("/")) {
                    String nm = linha.substring(index - 2, index - 1).trim();
                    if (TreeNumeros.get(nm) != null) {
                        res = true;
                        posBarra = index - 3;
                    }
                }
            }

            if (res) {
                for (int i = posBarra; i < linha.length(); i--) {
                    String carac = linha.substring(i - 1, i);
                    if (TreeNumeros.get(carac) == null) {
                        if (carac.equalsIgnoreCase(",") & res) {
                            posvisgula = i;
                            break;
                        } else {
                            if (!carac.equalsIgnoreCase("/")) {
                                res = false;
                                break;
                            }
                        }
                    }
                }
            } else {
                index = linha.indexOf("QT");
                if (index > -1) {
                    int index2 = linha.indexOf(",");
                    if (index2 > -1) {
                        String num = linha.substring((index2 + 1), (index2 + 2));
                        try {
                            int n = Integer.parseInt(num);
                            num = linha.substring((index2 + 2), (index2 + 3));
                            n = Integer.parseInt(num);
                            res = true;
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

    public String getCodigo() {
        int index = posVirgula();
        index = index + 2;
        String cod = linha.substring(index, linha.length()).trim();
        cod = cod.replace(" ", "");
        return cod;
    }

    public String getFornecedor() {
        String fornec = "";
        if (list_Fornec.get(0).indexOf("Vencimento:") > -1) {
            fornec = list_Fornec.get(1);
        }
        if (list_Fornec.get(1).indexOf("Vencimento:") > -1) {
            fornec = list_Fornec.get(2);
        }
        if (list_Fornec.get(2).indexOf("Vencimento:") > -1) {
            fornec = list_Fornec.get(3);
        }
        if (list_Fornec.get(3).indexOf("Vencimento:") > -1) {
            fornec = list_Fornec.get(4);
        } else if (list_Fornec.get(4).indexOf("QT") > 10) {
            fornec = list_Fornec.get(4);
        } else if (list_Fornec.get(3).length() > 7) {
            fornec = list_Fornec.get(3);
        } else {
            fornec = list_Fornec.get(2);
        }
        return fornec;
    }

    public boolean isVencimento() {
        boolean res = false;
        try {
            if (linha.length() >= 12) {
                String nome = linha.substring(0, 12).trim();
                if ("Vencimento:".equalsIgnoreCase(nome)) {
                    res = true;
                } else {
                    if (cont_linhaRodape > 8) {
                        nome = linha.substring(0, 7).trim();
                        res = "Baixa:".equalsIgnoreCase(nome);
                    }
                }
//                return "Vencimento:".equalsIgnoreCase(nome);
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

    public String getObsValor() throws Exception {
        int index = posEspaco();
        return linha.substring(0, index).trim();
    }

    public float getValor() throws Exception {
        int index = posEspaco();
        int index2 = posVirgula();
        index2 = index2 + 2;
        String vl = linha.substring(index, index2).trim();
        vl = vl.replace(".", "");
        vl = vl.replace(",", ".");
        float vlr = Float.parseFloat(vl);
        linha = linha.substring(0, index);
        return vlr;
    }

    public String getHistorico() {
        return linha;
    }

    public boolean isrodape() {
        try {
            if (linha.length() >= 4) {
                String fim = linha.substring(0, 3).trim();
                if (fim.equalsIgnoreCase("REL")) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public void deletarAllContas() throws Exception {
        if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
            ctp_conta_pagarDAO.deleteAll(ctp_conta_pagarT);
        }
    }

    /**
     * método de leitura do arquivo PDF e inserção dos registro no banco de dados.
     * @return resultado da leitura  e da inserção dos registros
     */
    public String read() {
        //String path = "c:/temp/arquivo.txt";
        File file = null;
        int lin = 0;
        try {
            list = new Vector();
            ConverPDFString converPDFString = new ConverPDFString();
            String path = converPDFString.getString(is);
            is.close();
            boolean insert = false;
            boolean addhist = false;
            Date vencimento = null;
            float valor = 0;
            String hist = "";
            String documento = "";
            String fornecedor="";
            

            boolean obs = false;
            double total = 0;

            int cont = 0;
            boolean linha_ant_vencimento = false;
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            totalImp = 0;
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            while (br.ready()) {
                lin++;
                linha = br.readLine();
                addList(linha);

                if (lin == 18) {
                    int a = 0;
                }
                System.out.println(lin + " C P " + linha);
//                if (!obs) {
//                    obs = linha.indexOf("Observação") > -1;
//                }

                if (isrodape()) {
                    cont_linhaRodape = 0;
                    //linha_ant_vencimento = false;
                } else if(isFornecedor()){
                    fornecedor = this.fornecedor;
                }else if (isVencimento()) {
                    vencimento = getVencimento();
                    addhist = true;
                    linha_ant_vencimento = true;
                    insert = false;
                    obs = true;
                } else if (isDocumento()) {
                    obs = false;
                    documento = getCodigo();
                    hist += getObsValor();
                    valor = getValor();

                    linha_ant_vencimento = false;

                    total = total + valor;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String key = documento + "." + sdf.format(vencimento);
                    addObjectTree(key, fornecedor, documento, vencimento, valor, hist);
                    if (!contaExiste(key)) {
                        addObject(fornecedor, documento, vencimento, valor, hist);
                    }
                    hist = "";
                    insert = true;

                } else if (linha.indexOf("Observação") > -1) {
                    obs = true;
                } else if ((insert || linha_ant_vencimento) & linha.indexOf("QT") > -1 & cont_linhaRodape > 8) {
                    fornecedor = getFornecedor();
                    linha_ant_vencimento = false;
                    insert = false;
                } 
//                else if (linha.indexOf("QT") > -1) {//(addhist & cont_linhaRodape > 8 & !linha_ant_vencimento) {
//                    if (cont_linhaRodape >= 9 & linha_ant_vencimento) {
//                        fornecedor = getFornecedor();
//                    }
                    else {
                        hist += getObs();
                    }
//                } else if (linha_ant_vencimento & cont_linhaRodape > 8) {
//                    if (linha.indexOf("QT") > -1) {
//                        fornecedor = getFornecedor();
//                        linha_ant_vencimento = false;
//                    } else {
//                        if (fornecedor.length() == 0) {
//                            fornecedor = linha;
//                        }
////                        obs = false;
//                    }
//                } else if (obs) {
//                    if (fornecedor.length() == 0) {
//                        fornecedor = linha;
//                    }
////                    obs = false;
//                }
                cont_linhaRodape++;
            }

            CriticaCTP_Alterada criticaCTP_Alterada = new CriticaCTP_Alterada(ctp_conta_pagarT, dao, treeMesAtual);
            criticaCTP_Alterada.criticaItens_and_value();

            dao.commitTransaction();
            br.close();
            fr.close();

            return " Total Geral lido = R$ " + funcoes.FormatoMoedaBR_Double(total) + " Total Importados = R$ " + funcoes.FormatoMoedaBR_Double(totalImp);
        } catch (Exception e) {
            dao.rollbackTransaction();
            e.printStackTrace();
            return "Erro na leitura do arquivo na linha " + lin + ", " + linha;
        } finally {
            file.delete();
            dao.close();
        }

        //return "Erro ao abrir o arquivo PDF, o arquivo pode estar em uso!";
        //98125158/98625179
    }

    public boolean isFornecedor() throws Exception {
        try {
            boolean res = false;

            if (linha.length() >= 11) {
                String fornec = linha.substring(0, 11).trim();
                if (fornec.equals("Fornecedor")) {
                    if (linha.indexOf("Total") < 0) {
                        res = true;
                        fornecedor = linha.substring(11, linha.length());
                    }
                } else {
                    String forn = linha.substring(linha.length() - 10, linha.length());
                    if (forn.equalsIgnoreCase("Fornecedor")) {
                        fornecedor = linha.substring(0, linha.indexOf("Fornecedor"));
                        res = true;
                    }
                }
            }

            return res;
        } catch (Exception e) {
            return false;

        }

    }

    public void addList(String valor) {
        if (list_Fornec.size() == 5) {
            list_Fornec.remove(0);
        }
        list_Fornec.add(valor);

    }

    private boolean linhaFornec(String linha) {
        boolean res = false;
        if (linha.indexOf("Total Item:") > -1) {
            res = true;
        } else if (linha.indexOf("Pedido") > -1) {
            res = true;
        }
        if (!res) {
            try {
                String num = linha.substring(0, 2).trim();
                int a = Integer.parseInt(num);
                res = true;
            } catch (Exception e) {
                return false;
            }
        }
        return res;
    }

    public void addObjectTree(String key, String fornecedor, String documento, Date vencimento, float valor, String hist) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Ctp_conta_pagarT ctpT = new Ctp_conta_pagarT();
            ctpT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
            ctpT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
            ctpT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
            ctpT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
            ctpT.setCtp_tx_fornecedor(fornecedor);
            ctpT.setPlc_nr_id(0);
            ctpT.setCtp_nr_documento(documento);
            ctpT.setCtp_dt_vencimento(vencimento);
            ctpT.setCtp_nr_valor(valor);
            String obs = hist;
            if (hist.length() > 299) {
                obs = hist.substring(0, 299).trim();
            }
            ctpT.setCtp_tx_obs(obs);
            treeMesAtual.put(key, ctpT);

        } catch (Exception e) {
            throw e;
        }

    }
    
    public String getValueFormatado(String valor) {
        String newvalue = valor.trim().replace("&", "E");
        newvalue = newvalue.trim().replace("ç", "c");
        newvalue = newvalue.trim().replace("Ç", "c");
        newvalue = newvalue.trim().replace("\\n", " ");
        newvalue = newvalue.trim().replace("\\r", " ");
        newvalue = newvalue.trim().replace("/r", " ");
        return newvalue;
    }
    

    public void addObject(String fornecedor, String documento, Date vencimento, float valor, String hist) throws Exception {
        try {
            ctp_conta_pagarT_Insert.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
            ctp_conta_pagarT_Insert.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
            ctp_conta_pagarT_Insert.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
            ctp_conta_pagarT_Insert.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
            ctp_conta_pagarT_Insert.setCtp_tx_fornecedor(getValueFormatado(fornecedor));
            ctp_conta_pagarT_Insert.setPlc_nr_id(0);
            ctp_conta_pagarT_Insert.setCtp_nr_documento(getValueFormatado(documento));
            ctp_conta_pagarT_Insert.setCtp_dt_vencimento(vencimento);
            ctp_conta_pagarT_Insert.setCtp_nr_valor(valor);
            String obs = hist;
            if (hist.length() > 299) {
                obs = hist.substring(0, 299).trim();
            }
            ctp_conta_pagarT_Insert.setCtp_tx_obs(getValueFormatado(obs));
            ctp_conta_pagarDAO.insert(ctp_conta_pagarT_Insert);
            totalImp = totalImp + ctp_conta_pagarT_Insert.getCtp_nr_valor();
        } catch (Exception e) {
            throw e;
        }

    }
}
