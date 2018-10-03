/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author marcos
 */
public class Celi_ApagarXLS {

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
    private TreeMap<Integer, String> treeFornecedor = new TreeMap<Integer, String>();

    public Celi_ApagarXLS(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is, InputStream is_anexo) throws Exception {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
        this.ctp_conta_pagarDAO = cdao;
        this.is = is;
        this.is_anexo = is_anexo;
        this.status = status;
        povoaConta();
    }

    public void deletarAllContas() throws Exception {
//        if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
//            ctp_conta_pagarDAO.deleteAll(ctp_conta_pagarT);
//        }
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

    public void read_Anexo() throws Exception {
        try {
            Workbook workbook = Workbook.getWorkbook(is_anexo);
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
            Workbook workbook = Workbook.getWorkbook(is);
            Sheet sheet = workbook.getSheet(0);
            float valorLido = 0;
            float valorImp = 0;
            String doc = "";
            String key = "";
            String hist = "";
            String ref = "";
            String fornecedor = "";
            String data = "";
            String vlunit = "";
            String vlTotal = "";
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            int linha = 0;
            int countfornulo = 0;
            String dt_emissao = "";
            valorLido = 0;
            for (int i = 5; i < (sheet.getRows() - 1); i++) {
                lin = i;
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
                    //parcela = "X/Y";

                    vlunit = formatValueFloat(vlunit);
                    if (!valorValido(vlunit)) {
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");
                    }
                    if (valorValido(vlunit)) {

                        //ctp_conta_pagarT.setCtp_nr_documento(ddcc);
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
                            nome_for = fornecedor + " - CELI";
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
                        ctp_conta_pagarT.setCtp_tx_obs(ref + " - " + hist);
                        ctp_conta_pagarT.setCtp_nr_valor(newvalue);
                        valorLido += ctp_conta_pagarT.getCtp_nr_valor();
                        ctp_conta_pagarDAO.insert(ctp_conta_pagarT);
                        valorImp += ctp_conta_pagarT.getCtp_nr_valor();
                    }
                }
            }
            dao.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
        } catch (Exception e) {
            System.out.println("Erro na linha " + lin);
            e.printStackTrace();
            return "erro na linha" + lin;
        } finally {
            dao.close();
        }


    }

    private String formatValueFloat(String valor) {
        String newValor = valor;
        if (valor.length() - 3 > 0) {
            String vl = valor.substring(valor.length() - 3, valor.length() - 2);
            if (vl.equalsIgnoreCase(".")) {
                newValor = valor.replace(",", "");
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

    public boolean linhaValida(Sheet sheet, int linha) {
        try {
            String qt = sheet.getCell(33, linha).getContents().trim();
            String ind = sheet.getCell(36, linha).getContents().trim();
            String dias = sheet.getCell(40, linha).getContents().trim();

            int iqt = Integer.parseInt(qt);
            int int_ind = Integer.parseInt(ind);
            int idias = Integer.parseInt(dias);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
