 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

/**
 *
 * @author marcos
 */
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
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

public class DiconAPagar {

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

    public DiconAPagar(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is, String status) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.status = status;
        //deletarAllContas();
        //povoaConta();
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
//        if (treeConta.get(key) != null) {
//            return true;
//        }
        return false;
    }

    public String read() {
        int lin = 24;
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
            boolean insert = false;
            String fornecedor = "";
            boolean linhaVencimento = false;
            int num_linha_venc = 0;
            int contlinhaRodape = 0;

            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            while (br.ready()) {
                lin++;
                contlinhaRodape++;

                if (lin > 24) {
                    linha = br.readLine();
                    if (lin == 136) {
                        int ss = 9;
                    }
                    //System.out.println(lin + " - " + linha);

                    insert = false;
                    if (!isVencimento()) {
                        if (!isRodape()) {
                            insert = linhaValidoApagar();
                        } else {
                            contlinhaRodape = 0;

                        }
                    } else {
                        //contlinhaRodape = 0;
                        fornecedor = "";
                        linhaVencimento = true;
                        num_linha_venc = lin;
                    }

                    if (insert) {
                        linhaVencimento = false;
                        Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
                        ctp_conta_pagarT.setCtp_nr_ano(this.ctp_conta_pagarT.getCtp_nr_ano());
                        ctp_conta_pagarT.setCtp_nr_mes(this.ctp_conta_pagarT.getCtp_nr_mes());
                        ctp_conta_pagarT.setObr_nr_id(this.ctp_conta_pagarT.getObr_nr_id());
                        ctp_conta_pagarT.setCtp_tx_status(this.ctp_conta_pagarT.getCtp_tx_status());
                        ctp_conta_pagarT.setPlc_nr_id(0);
                        ctp_conta_pagarT.setCtp_nr_valor(valor);
                        ctp_conta_pagarT.setCtp_dt_emissao(dt_baixa);
                        ctp_conta_pagarT.setCtp_dt_vencimento(ctp_conta_pagarT.getCtp_dt_emissao());
                        ctp_conta_pagarT.setCtp_nr_documento(getDocumento());
                        if (linha.length() > 0 & !isInteiro()) {
                            fornecedor = linha;
                        }
                        ctp_conta_pagarT.setCtp_tx_fornecedor(fornecedor);
                        total = total + valor;

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String key = ctp_conta_pagarT.getCtp_nr_documento() + "." + sdf.format(ctp_conta_pagarT.getCtp_dt_vencimento());
                        //if (!contaExiste(key)) {
                            ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                            totalImp += ctp_conta_pagarT.getCtp_nr_valor();
                        //}
                        fornecedor = "";
                    } else if (linhaVencimento & lin > num_linha_venc & contlinhaRodape > 6) {
                        fornecedor += linha;
                        if (titulosColunas(fornecedor)) {
                            fornecedor ="";
                        }
                    }
                }
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

    public boolean titulosColunas (String fornec) {

        if (fornec.equalsIgnoreCase("Credor Documento Lançamento Qt. Ind. Dias Valor novenctoAcréscimo Desconto Total")) {
            return true;
        }
        return false;

    }

    private boolean isInteiro() {
        try {
            int i = Integer.parseInt(linha);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean isRodape() {
        if (linha.indexOf("SOFTPLAN") > -1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isVencimento() {
        try {
            if (status.equalsIgnoreCase("A")) {
                if (linha.indexOf("Data de vencimento") > -1) {
                    int inicio = getPosEspaco();
                    String dtStr = linha.substring(inicio, linha.length());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    dt_baixa = format.parse(dtStr);
                    return true;
                }
            } else {
                if (linha.indexOf("Data da baixa :") > -1) {
                    int inicio = getPosEspaco();
                    String dtStr = linha.substring(inicio, linha.length());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    dt_baixa = format.parse(dtStr);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public int getPosEspaco() {
        int p = 0;
        linha = linha.trim();
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

    public boolean isValor(String vl) {
        boolean res = false;
        int p = 0;
        linha = linha.trim();
        String caracter = "";
        for (int i = vl.length(); i > 0; i--) {
            caracter = vl.substring(i - 1, i);
            if (caracter.equalsIgnoreCase(",")) {
                p = i;
                break;
            }
        }

        if (vl.length() > 2) {
            if ((vl.length() - p) == 2) {
                res = true;
            }
        }
        return res;

    }

    public boolean linhaValidoApagar() {
        boolean res = false;
        try {
            linha = linha.trim();
            int inicio = getPosEspaco();
            //verifica se a ultima coluna é um valor
            String vl = linha.substring(inicio, linha.length()).trim();
            if (isValor(vl)) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
                float vl_f = Float.parseFloat(vl);
                valor = vl_f;
                linha = linha.substring(0, inicio).trim();

                inicio = getPosEspaco();
                //verifica se a penutima coluna é um valor
                vl = linha.substring(inicio, linha.length()).trim();
                if (isValor(vl)) {
                    vl = vl.replace(".", "");
                    vl = vl.replace(",", ".");
                    vl_f = Float.parseFloat(vl);
                    linha = linha.substring(0, inicio).trim();

                    //verifica se a Ant-penutima coluna é um valor
                    inicio = getPosEspaco();
                    vl = linha.substring(inicio, linha.length()).trim();
                    if (isValor(vl)) {
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        inicio = getPosEspaco();
                        vl = linha.substring(inicio, linha.length()).trim();
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        inicio = getPosEspaco();
                        vl = linha.substring(inicio, linha.length()).trim();
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        inicio = getPosEspaco();
                        vl = linha.substring(inicio, linha.length()).trim();
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        inicio = getPosEspaco();
                        vl = linha.substring(inicio, linha.length()).trim();
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        res = true;
                    }
                }
            }
            if (res) {
                if (linha.indexOf("do credor") > 0) {
                    res = false;
                }
            }
            return res;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public boolean linhaValidoPagas() {
        boolean res = false;
        try {
            linha = linha.trim();
            int inicio = getPosEspaco();
            //verifica se a ultima coluna é um valor
            String vl = linha.substring(inicio, linha.length()).trim();
            if (isValor(vl)) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
                float vl_f = Float.parseFloat(vl);
                valor = vl_f;
                linha = linha.substring(0, inicio).trim();

                inicio = getPosEspaco();
                //verifica se a penutima coluna é um valor
                vl = linha.substring(inicio, linha.length()).trim();
                if (isValor(vl)) {
                    vl = vl.replace(".", "");
                    vl = vl.replace(",", ".");
                    vl_f = Float.parseFloat(vl);
                    linha = linha.substring(0, inicio).trim();

                    //verifica se a Ant-penutima coluna é um valor
                    inicio = getPosEspaco();
                    vl = linha.substring(inicio, linha.length()).trim();
                    if (isValor(vl)) {
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl_f = Float.parseFloat(vl);
                        linha = linha.substring(0, inicio).trim();

                        inicio = getPosEspaco();
                        vl = linha.substring(inicio, linha.length()).trim();
                        vl = vl.replace(".", "");
                        vl = vl.replace(",", ".");
                        vl = vl.replace("T", "");
                        vl_f = Float.parseFloat(vl);
                        valor = vl_f;
                        linha = linha.substring(0, inicio).trim();
                        res = true;
                    }
                }
            }
            if (res) {
                int t = linha.indexOf("do credor");
                if (t > 0) {
                    res = false;
                } else {
                    if (linha.indexOf("Grupo Empresa") > -1) {
                        res = false;
                    } else if (linha.indexOf("Total   :") > -1) {
                        res = false;
                    } else if (linha.indexOf("Total do Dia") > - 1) {
                        res = false;
                    } else if (linha.indexOf("Total do Mês") > -1) {
                        res = false;
                    }
                }
            }

            return res;
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }

    public boolean isdata(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = format.parse(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Date getData() throws Exception {
        try {
            boolean colunadate = true;
            int inicio = getPosEspaco();
            //System.out.println(linha);
            String ndt = linha.substring(inicio, linha.length()).trim();
            if (!isdata(ndt)) {
                linha = linha.substring(0, inicio);
                inicio = getPosEspaco();
                colunadate = false;
            }
            String strDt = linha.substring(inicio, linha.length()).trim();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = format.parse(strDt);
            linha = linha.substring(0, inicio).trim();
            if (!colunadate) {
                inicio = getPosEspaco();
                linha = linha.substring(0, inicio).trim();
            }
            return dt;
        } catch (Exception e) {
            //return null;
            throw e;
        }

    }

    public String getDocumento() {
        int inicio = getPosEspaco();
        String doc = "";
        String parcela = linha.substring(inicio, linha.length()).trim();
        if (status.equalsIgnoreCase("A")) {
            linha = linha.substring(0, inicio).trim();
            inicio = getPosEspaco();
            doc = linha.substring(inicio, linha.length());
            linha = linha.substring(0, inicio);
            inicio = getPosEspaco();
            linha = linha.substring(0, inicio).trim();
            doc = doc + "-" + parcela;
        } else {
            doc = parcela;
            inicio = getPosEspaco();
            linha = linha.substring(0, inicio).trim();

            inicio = getPosEspaco();
            doc = linha.substring(inicio, linha.length()).trim() + "-" + doc;
            linha = linha.substring(0, inicio);

            inicio = getPosEspaco();
            //doc += linha.substring(inicio, linha.length());
            linha = linha.substring(0, inicio).trim();

            inicio = getPosEspaco();
            //doc += linha.substring(inicio, linha.length());
            linha = linha.substring(0, inicio).trim();


        }

        return doc;
    }
}
