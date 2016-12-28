/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
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

/**
 *
 * @author marcos
 */
public class NassalEstoque {

    private List<Est_estoqueT> list;
    private Est_estoqueDAO dAO;
    private TreeMap<String, Est_estoqueT> treeEst;
    private Est_estoqueT est_estoqueT;
    private DAOFactory dao;
    private InputStream is;
    private File file;
    private String linha, quebradelinha;
    private boolean existedata = false;
    private static final String ASPAS = "\"";
    private String und;
    private float valorLayout2;

    public NassalEstoque(Est_estoqueT est_estoqueT, Est_estoqueDAO dAO, InputStream is) {
        this.dAO = dAO;
        this.est_estoqueT = est_estoqueT;
        this.is = is;
        //povoaEstoque();
    }

    public void povoaEstoque() {
        try {
            treeEst = dAO.getByObr_nr_idTree(est_estoqueT);
        } catch (Exception e) {
        }
    }

    public String read() {
        int lin = 0;
        String msg = "";
        int contador = 0;
        try {
            list = new Vector();

            ConverPDFString converPDFString = new ConverPDFString();
            String path = converPDFString.getString(is);
             is.close();
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            double total = 0;
            dao = dAO.getDAOFactory();
            dao.beginTransaction();
            float valorImp = 0;
            float valorLido = 0;
            int linhaColuna = 6;

            String key = "";
            Est_estoqueT est_estoqueTreeT;
            dao.beginTransaction();
            boolean inserir;
            boolean linhavalida = false;

            while (br.ready()) {
                lin++;
                linha = br.readLine();
                quebradelinha = linha;

                contador++;

                System.out.println(contador + " - " + linha);
                
                clearUnidade_e_data();
                if (lin > 16) {
                    if (getLinhColuna()) {
                        linhaColuna = 3;
                    } else {
                        linhaColuna++;
                    }
                    if (lin == 31) {
                        int s = 1;
                    }
                    if (linhaColuna > 6) {

                        if (linhavalida) {//condição por contas de layout diferente dos arquivos
                            linhavalida = false;
                            if (linhavalor()) {
//                                est_estoqueT.setEst_nr_vl_unitario(est_estoqueT.getEst_nr_vl_total());
                                est_estoqueT.setEst_nr_vl_total(valorLayout2);
                            }
                            if (est_estoqueT.getEst_nr_vl_total() != 0) {
                                if (valorLayout2 != 0 & est_estoqueT.getEst_nr_quantidade() != 0) {
                                    est_estoqueT.setEst_nr_vl_unitario(valorLayout2 / est_estoqueT.getEst_nr_quantidade());
                                }
                                valorLido += est_estoqueT.getEst_nr_vl_total();
                                valorImp += est_estoqueT.getEst_nr_vl_total();
                                dAO.insert(est_estoqueT);
                            }
                        }//else

                        if (linhaValida()) {
                            linhavalida = true;
                            inserir = false;
                            float saldo = getTotal();
                            est_estoqueT.setEst_nr_vl_total(getTotal());
                            
                            est_estoqueT.setEst_nr_quantidade(saldo);
                            est_estoqueT.setEst_tx_unidade(und);
                            if (est_estoqueT.getEst_nr_vl_total() != 0 & est_estoqueT.getEst_nr_quantidade() != 0) {
                                est_estoqueT.setEst_nr_vl_unitario(est_estoqueT.getEst_nr_vl_total() / est_estoqueT.getEst_nr_quantidade());
                                inserir = true;
                            }
                            est_estoqueT.setEst_tx_key(getKey());
                            linha = linha.replace(ASPAS, "''");

                            est_estoqueT.setEst_tx_nome(linha);

                        }
                    }
                }
            }

            dao.commitTransaction();
            return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
        } catch (Exception e) {
            dao.rollbackTransaction();
            e.printStackTrace();
            return "erro na linha " + contador;
        } finally {
            file.delete();
            dao.close();
        }
    }

    public boolean linhavalor() {
        boolean res = false;
        try {
            String vl = quebradelinha.substring(0, getPosEspacoSequencia() + 1);
            vl = formatValueFloat(vl);

            if (!valorValido(vl)) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
            }

            float vf = Float.parseFloat(vl);
            valorLayout2 = vf;

            res = true;
        } catch (Exception e) {
            return false;
        }
        return res;
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

    public boolean getLinhColuna() {
        if (linha.length() > 7) {
            String linC = linha.substring(0, 7);
            if (linC.equalsIgnoreCase("=======")) {
                return true;
            }
        }
        return false;
    }

    public String getUnidade() {
        linha = linha.trim();
        String unidade = linha.substring(0, linha.indexOf(" "));
        return unidade;
    }

    public String getCodigo() {
        int index = linha.indexOf(" ");
        String cod = linha.substring(0, index);
        linha = linha.substring(index, linha.length()).trim();
        return cod;
    }

    public int getPosEspaco() {
        int p = 0;
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

    public int getPosEspacoSequencia() {
        int p = 0;
        String caracter = "";
        quebradelinha = quebradelinha.trim();
        for (int i = 0; i < quebradelinha.length(); i++) {
            caracter = quebradelinha.substring(i, i + 1);
            if (caracter.equalsIgnoreCase(" ")) {
                p = i;
                break;
            }
        }
        if (p == 0) {
            p = linha.length();
        }
        return p;
    }

    public float getTotal() throws Exception {
        try {
            String vl = "";
            int posicao_Espaco = getPosEspaco();
            if (!existedata) {
                vl = linha.substring(posicao_Espaco, linha.length()).trim();
                linha = linha.substring(0, posicao_Espaco).trim();
            } else {
                linha = linha.substring(0, posicao_Espaco).trim();
                posicao_Espaco = getPosEspaco();
                vl = linha.substring(posicao_Espaco, linha.length()).trim();
                linha = linha.substring(0, posicao_Espaco).trim();
            }

            vl = formatValueFloat(vl);

            if (!valorValido(vl)) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
            }
            return Float.parseFloat(vl);

        } catch (Exception e) {
            throw e;
        }
    }

    public float getNewSaldo() throws Exception {
        try {
            String vl = "";
            int posicao_Espaco = getPosEspaco();
            if (!existedata) {
                vl = linha.substring(posicao_Espaco, linha.length()).trim();
                linha = linha.substring(0, posicao_Espaco).trim();
            } else {
                linha = linha.substring(0, posicao_Espaco).trim();
                posicao_Espaco = getPosEspaco();
                vl = linha.substring(posicao_Espaco, linha.length()).trim();
                linha = linha.substring(0, posicao_Espaco).trim();
            }

            vl = formatValueFloat(vl);

            if (!valorValido(vl)) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
            }
            return Float.parseFloat(vl);

        } catch (Exception e) {
            throw e;
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

    public float getSaldo() throws Exception {
        try {
            int p = getPosEspaco();
            String vl = linha.substring(p, linha.length()).trim();
            linha = linha.substring(0, p).trim();
            vl = vl.replace(".", "");
            vl = vl.replace(",", ".");
            return Float.parseFloat(vl);
        } catch (Exception e) {
            throw e;
        }
    }

    public String getKey() {
        int p = getPosEspaco();
        String key = linha.substring(p, linha.length()).trim();
        linha = linha.substring(0, p).trim();
        return key;
    }

    public boolean linhaValida() {
        boolean res = false;
        if (linha.length() > 20) {
            int p = getPosEspaco();
            String vl = linha.substring(p, linha.length()).trim();
            vl = vl.replace(".", "");
            vl = vl.replace(",", ".");
            try {
                float v = Float.parseFloat(vl);
                res = true;
                int id = linha.indexOf("ESTOQUE");
                if (linha.indexOf("ESTOQUE") != -1) {
                    res = false;
                }
            } catch (Exception e) {
            }
        }
        return res;
    }

    public void clearUnidade_e_data() {
        try {
            und = getUnidade();
            existedata = false;
            linha = linha.trim();
            int index = linha.indexOf(" ");
            linha = linha.substring(index, linha.length()).trim();
            String dt = linha.substring(linha.length() - 10, linha.length()).trim();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date d = format.parse(dt);
            existedata = true;
            linha = linha.substring(0, linha.length() - 10).trim();
        } catch (Exception e) {
        }
    }
}
