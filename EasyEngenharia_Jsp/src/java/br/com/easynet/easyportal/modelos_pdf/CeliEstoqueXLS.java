/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
import br.com.jdragon.dao.DAOFactory;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author marcos
 */
public class CeliEstoqueXLS {

    private List<Est_estoqueT> list;
    private Est_estoqueDAO dAO;
    private TreeMap<String, Est_estoqueT> treeEst;
    private Est_estoqueT est_estoqueT;
    private DAOFactory factory;
    private InputStream is;
    private File file;
    private String linha;
    private static final String ASPAS = "\"";

    public CeliEstoqueXLS() {
    }

    public CeliEstoqueXLS(Est_estoqueT est_estoqueT, Est_estoqueDAO dAO, InputStream is) {
        this.dAO = dAO;
        this.est_estoqueT = est_estoqueT;
        this.is = is;
//        povoaEstoque();
    }

    public boolean linhavalida(String coluna) {
        try {
            int codigo = Integer.parseInt(coluna.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean valorValido(String valor) {
        try {
            float val = Float.parseFloat(valor);
            return true;
        } catch (Exception e) {
            return false;
        }
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

//    public static void main(String[] arg){
//        MarquezzoEstoque estoque = new MarquezzoEstoque(null, null, null);
//        estoque.formatValueFloat("12,812.67");
//    }
    public String read() throws Exception {
        int linha = 0;
        Workbook workbook = null;
        try {
            Est_estoqueT est_estoqueTreeT;
            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("ISO-8859-1");
            ws.setLocale(new Locale("pt", "BR"));
            workbook = Workbook.getWorkbook(is, ws);
            Sheet sheet = workbook.getSheet(0);
            float valorLido = 0;
            float valorImp = 0;
            String chave = "";
            String key = "";
            String nome = "";
            String estoque = "";
            String vlunit = "";
            String vlTotal = "";
            String unidade = "";
            factory = dAO.getDAOFactory();
            factory.beginTransaction();
            for (int i = 0; i < (sheet.getRows() - 1); i++) {
                linha = i;
                if (i > 2) {
                    key = sheet.getCell(0, i).getContents().trim();
                    nome = sheet.getCell(1, i).getContents().trim();
                    unidade = sheet.getCell(4, i).getContents().trim();
                    estoque = sheet.getCell(5, i).getContents().trim();
                    vlunit = sheet.getCell(6, i).getContents().trim();
                    vlTotal = sheet.getCell(7, i).getContents().trim();

                    vlunit = formatValueFloat(vlunit);
                    vlTotal = formatValueFloat(vlTotal);

                    if (!valorValido(vlunit)) {
                        //System.out.println("VALIDAÇÃO UNIT " + vlunit);
                        vlunit = vlunit.replace(".", "");
                        vlunit = vlunit.replace(",", ".");

                    }

                    if (!valorValido(vlTotal)) {
                        //System.out.println("VALIDAÇÃO " + vlTotal);
                        vlTotal = vlTotal.replace(".", "");
                        vlTotal = vlTotal.replace(",", ".");
                    }
//                    System.out.println("FINAL UNIT " + vlunit + " TOTAL " + vlTotal);

                    if (linhavalida(key)) {
                        if (Float.parseFloat(vlTotal) != 0) {
                            est_estoqueT.setEst_nr_vl_total(Float.parseFloat(vlTotal));
                            est_estoqueT.setEst_nr_vl_unitario(Float.parseFloat(vlunit));
                            est_estoqueT.setEst_nr_quantidade(est_estoqueT.getEst_nr_vl_total() / est_estoqueT.getEst_nr_vl_unitario());
                            est_estoqueT.setEst_tx_key(key);
                            est_estoqueT.setEst_tx_unidade(unidade);
                            nome = nome.replace(ASPAS, "''");
                            est_estoqueT.setEst_tx_nome(trata(nome));
                            valorLido = valorLido + Float.parseFloat(vlTotal);
                            chave = est_estoqueT.getObr_nr_id() + "." + est_estoqueT.getEst_tx_key() + "." + est_estoqueT.getEst_nr_mes() + "." + est_estoqueT.getEst_nr_ano();
//                        est_estoqueTreeT = treeEst.get(chave);
//                        if (est_estoqueTreeT != null) {
//                            est_estoqueT.setEst_nr_id(est_estoqueTreeT.getEst_nr_id());
//                            est_estoqueT.setEst_tx_unidade(est_estoqueTreeT.getEst_tx_unidade());
//                            dAO.update(est_estoqueT);
//                        } else {
                            valorImp = valorImp + Float.parseFloat(vlTotal);
                            dAO.insert(est_estoqueT);
//                        }
                        }
                    }
                }
            }
            factory.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
        } catch (Exception e) {
            factory.rollbackTransaction();
            return "Erro na linha " + linha;
        } finally {
            workbook.close();
            factory.close();
        }
    }

    public String trata(String passa) {
        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
        passa = passa.replaceAll("[âãàáä]", "a");
        passa = passa.replaceAll("[ÊÈÉË]", "E");
        passa = passa.replaceAll("[êèéë]", "e");
        passa = passa.replaceAll("ÎÍÌÏ", "I");
        passa = passa.replaceAll("îíìï", "i");
        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
        passa = passa.replaceAll("[ôõòóö]", "o");
        passa = passa.replaceAll("[ÛÙÚÜ]", "U");
        passa = passa.replaceAll("[ûúùü]", "u");
        passa = passa.replaceAll("Ç", "C");
        passa = passa.replaceAll("ç", "c");
        passa = passa.replaceAll("[ýÿ]", "y");
        passa = passa.replaceAll("Ý", "Y");
        passa = passa.replaceAll("ñ", "n");
        passa = passa.replaceAll("Ñ", "N");
        passa = passa.replaceAll("´", "");
        passa = passa.replaceAll("'", "");
        passa = passa.replaceAll("['<>\\|/]", "");
        //System.out.println(passa);

        return passa;
    }

    public String getCodigo() {
        int index = linha.indexOf(" ");
        String cod = linha.substring(0, index);
        linha = linha.substring(index, linha.length());
        return cod;
    }

    public String getNome() {
        String nm = linha.substring(0, 60);
        return nm;
    }
}
