/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.jdragon.dao.DAOFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author marcos
 */
public class Nassal extends SystemBase {

    private List<Ctp_conta_pagarT> list;
    private TreeMap<String, Ctp_conta_pagarT> treeConta = new TreeMap<String, Ctp_conta_pagarT>();
    private Ctp_conta_pagarT ctp_conta_pagarT;
    private Ctp_conta_pagarDAO ctp_conta_pagarDAO;
    private String linha;
    private InputStream is;
    private Funcoes funcoes = new Funcoes();
    private double totalImp;
    private TreeMap<String, Ctp_conta_pagarT> treeMesLancado = new TreeMap<String, Ctp_conta_pagarT>();
    File file;
    DAOFactory dao;
    String quebraPaginaCodigo;
    double totalGeral = 0;
    double totalgrupo = 0;
    boolean imprimi;

    public Nassal(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
//        deletarAllContas();
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
        } catch (Exception e) {
        }
    }

    public boolean contaExiste(String key) {
        if (this.ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("P")) {
            if (treeConta.get(key) != null) {
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] arg) {
//        Nassal nassal = new Nassal(null, null);
//        nassal.linha = " 00463101  SIKA S/A PRODUTOS QUIMICOS   18/02/2010  21/01/2010  3.201,01  REJUNTES, PLASTIFICANTE E   BANCO  1 ";
//        nassal.getCodigo();
//        nassal.getFornecedor();
//        nassal.getVencimento();
//        nassal.getDataEmissao();
//        nassal.getValor();
//
//    }
    /**
     * método de leitura do arquivo PDF e inserção dos registro no banco de
     * dados.
     *
     * @return resultado da leitura e da inserção dos registros
     */
    public String read() {
        int lin = 0;
        try {
            list = new Vector();
            //ConverPDFString converPDFString = new ConverPDFString("c:/bc/contapagar/NOVOSOL_CONTAS_A_PAGAR.pdf");
            ConverPDFString converPDFString = new ConverPDFString();
            String path = converPDFString.getString(is);
            is.close();
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            double total = 0;
            totalGeral = 0;
            totalgrupo = 0;
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            while (br.ready()) {
                lin++;
                if (lin > 18) {
                    linha = br.readLine();
                    if (lin == 1510) {
                        int ss = 9;
                    }
                    if (linha.indexOf("Total Por Despesa:") > -1) {
                        somarTotal(linha);
                    }
//                    if (imprimi) {
//                        System.out.println(lin + " - " + linha);
//                    }
                    if (linhaValido(linha)) {
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        //nao poderá mudar a sequencia por que a variavel strLinha é recortada em cada método

                        ctp_conta_pagarT.setCtp_nr_documento(getCodigo());
                        ctp_conta_pagarT.setCtp_tx_fornecedor(getFornecedor());
                        ctp_conta_pagarT.setCtp_dt_vencimento(getVencimento());
                        ctp_conta_pagarT.setCtp_dt_emissao(getDataEmissao());
                        ctp_conta_pagarT.setCtp_nr_valor(getValor());

                        totalgrupo += ctp_conta_pagarT.getCtp_nr_valor();
                        total += ctp_conta_pagarT.getCtp_nr_valor();
                        ctp_conta_pagarT.setCtp_tx_obs(getHistorico());
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                        if (!contaExiste(key)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            totalImp += ctp_conta_pagarT.getCtp_nr_valor();
                            treeMesLancado.put(key, ctp_conta_pagarT);
                        } else {
                            //System.out.println(""+key);
                        }
                    }
                }
            }

            List<Ctp_conta_pagarT> listAte = ctp_conta_pagarDAO.getAllMesAte(ctp_conta_pagarT);
            for (Ctp_conta_pagarT ctpT : listAte) {
            }

            dao.commitTransaction();
            return "Total Geral lido = R$ " + funcoes.FormatoMoedaBR_Double(total) + " Total Importados = R$ " + funcoes.FormatoMoedaBR_Double(totalImp);
        } catch (Exception e) {
            dao.rollbackTransaction();
            e.printStackTrace();
            file.delete();
            return "Erro na leitura do arquivo na linha " + lin + ", " + linha;

        } finally {
            file.delete();
            dao.close();
        }
    }
    //=======731.695,91-  - 731.183,72

    public void somarTotal(String lin) {
        int i = lin.indexOf(":");
        String vl = lin.substring(i + 1, lin.length());
        vl = vl.trim();
        vl = vl.replace(".", "");
        vl = vl.replace(",", ".");
        if ("73.907,31".equalsIgnoreCase(Funcoes.FormatoMoedaBR_Double(Double.parseDouble(vl.trim())))) {
            imprimi = true;
        }

        totalGeral = totalGeral + Double.parseDouble(vl.trim());
        System.out.println("=======" + Funcoes.FormatoMoedaBR_Double(Double.parseDouble(vl.trim())) + "-  - " + Funcoes.FormatoMoedaBR_Double(totalgrupo));
        totalgrupo = 0;
    }

    public boolean linhaValido(String linha) {
        String str = "";
        boolean valido = false;
        try {
            String lin = linha.trim();
            int index = lin.indexOf(" ");
            String codigo = linha.substring(0, index + 1);
            str = linha.substring(index, linha.length());
            codigo = codigo.trim();
            codigo = codigo.replace("-", "");
            int qt = 0;
            //verifica se a variavel codigo não é uma data, para poder executar o metodo replace
            for (int i = 0; i < codigo.length(); i++) {
                String c = codigo.substring(i, i + 1);
                if (c.equalsIgnoreCase("/")) {
                    qt++;
                }
            }
            if (qt < 2) {
                codigo = codigo.replace("/", "");
            }

            if (codigo.length() < 10) {
                int cod = Integer.parseInt(codigo);
            } else {
                int ini = Integer.parseInt(codigo.substring(0, 9).toString());
                int fin = Integer.parseInt(codigo.substring(codigo.length() - 9, codigo.length()).toString());
            }
            return true;
        } catch (Exception e) {
            try {
                int i = str.indexOf("/");
                if (i > -1) {
                    String nstr = str.substring(i - 3, i + 8);
                    SimpleDateFormat formar = new SimpleDateFormat("dd/MM/yyyy");
                    Date dt = formar.parse(nstr);
                    str = str.substring(i + 8, str.length()).trim();
                    int a = str.indexOf(" ");
                    nstr = str.substring(0, a);
                    dt = formar.parse(nstr);
                    valido = true;
                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
            //e.printStackTrace();
            return valido;
        }
    }

    public String getCodigo() {
        linha = linha.trim();
        int index = linha.indexOf(" ");
        if (index == 0) {
            linha = linha.substring(1, linha.length());
            index = linha.indexOf(" ");
        }
        String cod = linha.substring(0, index).trim();
        linha = linha.substring(index, linha.length()).trim();
        return cod;
    }

    public String getObs() {
        linha = linha.trim();
        return null;
    }

    public Date getVencimento() {
        try {
            int index = linha.indexOf(" ");
            String d1 = linha.substring(0, index).trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(d1);
            linha = linha.substring(index, linha.length()).trim();
            return date;
        } catch (Exception e) {
            System.out.println(linha);
            e.printStackTrace();
        }

        return null;
    }

    public Date getDataEmissao() {
        try {
            int index = linha.indexOf(" ");
            String d1 = linha.substring(0, index).trim();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(d1);
            linha = linha.substring(index, linha.length()).trim();
            return date;
        } catch (Exception e) {
            System.out.println(linha);
            e.printStackTrace();
        }

        return null;
    }

    public String getFornecedor() {

        int index = linha.indexOf("/");
        String sinal = linha.substring(index + 3, index + 4);
        if (sinal.equalsIgnoreCase("/")) {
            index = index - 2;
        } else {
            for (int i = index; i < linha.length(); i++) {
                String ndata = linha.substring(i, i + 11).trim();
                String brMes = ndata.substring(2, 3);
                String brAno = ndata.substring(5, 6);
                String espacoApos = linha.substring((i + 11), (i + 12));
                if (brMes.equalsIgnoreCase("/") & brAno.equalsIgnoreCase("/") & espacoApos.equalsIgnoreCase(" ")) {
                    index = i;
                    break;
                }
            }
        }
        String hist = linha.substring(0, index).trim();
        linha = linha.substring(index, linha.length()).trim();
        return hist;
    }

    public float getValor() {
        String vl ="";
        try {
            int index = linha.indexOf(",") + 3;
            vl = linha.substring(0, index).trim();
            linha = linha.substring(index, linha.length()).trim();
            vl = vl.replace(".", "");
            vl = vl.replace(",", ".");
            float vlr = Float.parseFloat(vl);
            return vlr;
        } catch (Exception e) {
            try {
                vl = vl.substring(0, vl.length()-1);
                float vlr = Float.parseFloat(vl);
                return vlr;
            } catch (Exception ex) {
                ex.printStackTrace();
                return 0;
            }
        }
        //return null;
    }

    public String getHistorico() {
        return linha;
    }
}
