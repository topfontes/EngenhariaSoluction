/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author topfontes
 */
public class ADM_Pagas extends SystemBasePDF implements ModeloPDF {

    int posIniVal = -1;
    int posInidoc = -1;

    public ADM_Pagas(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) {
        super(ctp_conta_pagarT, cdao, is);
    }

    public void povoaConta() {
        try {
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTree(this.ctp_conta_pagarT);
        } catch (Exception e) {
        }
    }

    public String getDocumento() {
        try {
            String parte = linha.substring(0, posIniVal).trim();
            posInidoc = posLastCaracter(parte, " ");
            String vl = parte.substring(posInidoc, parte.length()).trim();
            try {
                int a = Integer.parseInt(vl);
                return parte.substring(posInidoc, parte.length()).trim();
            } catch (Exception e) {
                posInidoc = posIniVal;
                return "";
            }

        } catch (Exception e) {
            return "";
        }

    }

    public String getVencimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getValor() {
        String vl = linha.substring(posIniVal, linha.length());
        vl = vl.replace(".", "");
        vl = vl.replace(",", ".");
        return Float.parseFloat(vl);
    }

    public String getFornecedor() {
        try {

            return linha.substring(linha.indexOf(" "), posInidoc);

        } catch (Exception e) {

        }
        return "";
    }

    public String getObs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean valorValido() {
        try {
            posIniVal = posLastCaracter(linha, " ");
            String vl = linha.substring(posIniVal, linha.length());
            if (vl.indexOf(",") > -1) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
                float vlf = Float.parseFloat(vl);
                return true;
            }
            return false;
        } catch (Exception e) {
        }
        return false;
    }

    public String read() {
        povoaConta();
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
            String campo = "";
            int cont_linhaRodape = 0;
            double total = 0;
            boolean iniciar = false;
            totalImp = 0;
            total = 0;
            dao = ctp_conta_pagarDAO.getDAOFactory();
            dao.beginTransaction();
            int cont = 0;
            boolean datapreenchida = false;
            while (br.ready()) {
                lin++;
                linha = br.readLine();
                linha = linha.trim();
                if (linha.indexOf("Despesas") != -1 && lin > 3) {
                    iniciar = true;
                }
                if (iniciar) {

                    campo = "";
                    try {
                        campo = linha.substring(0, linha.indexOf(" "));
                    } catch (Exception e) {
                        System.out.println("A pagar  exception " + lin + "  " + linha);
                        //continue; 
                    }
                    if (lin == 227) {
                        int a = 0;
                    }
                    System.out.println("A pagar " + lin + "  " + linha);
                    if (dataValida(campo)) {
                        datapreenchida = true;

                        vencimento = sdf.parse(campo);
                        if (valorValido()) {

                            valor = getValor();
                            total += valor;
                            documento = getDocumento().trim();
                            fornecedor = getFornecedor().trim();
                            String key = documento + "." + sdf.format(vencimento);
                            if (treeConta.get(key) == null) {
                                addObjectCTP(fornecedor, documento, vencimento, valor, hist);
                                System.out.println(" insert");
                            }
                            datapreenchida = false;
                        } else {
                            fornecedor = linha.substring(0, linha.length());
                        }
//                        System.out.println("A pagar " + lin + "  " + linha);
                    } else {
                        if (datapreenchida) {
                            if (valorValido()) {
                                valor = getValor();
                                total += valor;
                                try {
                                    documento = linha.substring(0, posIniVal);
                                } catch (Exception e) {
                                }
                                String key = documento + "." + sdf.format(vencimento);
                                if (treeConta.get(key) == null) {
                                    addObjectCTP(fornecedor, documento, vencimento, valor, hist);
                                    System.out.println(" insert");
                                }
                                datapreenchida = false;
                            }
                        }

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

        /*        String valor;
         String emissao;
         String vencimento;
         String documento;
         String fornecedor;
         SimpleDateFormat format = new SimpleDateFormat("d/MM/yyyy");
         String cheque;
         int linefirt;
         int opcolumn = 0;
         totalImp = 0;
         total = 0;
         String key;
         try {
         WorkbookSettings ws = new WorkbookSettings();
         ws.setEncoding("ISO-8859-1");
         ws.setLocale(new Locale("pt", "BR"));
         Workbook workbook = Workbook.getWorkbook(is, ws);
         Sheet[] abas = workbook.getSheets();

         for (int i = 0; i < abas.length; i++) {
         linefirt = i == 0 ? 1 : 0;
         Sheet sheet = workbook.getSheet(i);
         opcolumn = sheet.getColumns() == 7 ? 0 : 1;
         for (int j = 0; j < (sheet.getRows()); j++) {
         if (j == 35) {
         int a = 2; 
         }
         String linha = ""; 
         System.out.println(""+sheet.getColumns());
         for (int k = 0; k < sheet.getColumns(); k++) {
                        
                        
         if (!sheet.getCell(k, j).getContents().trim().isEmpty()) {
         //System.out.println(sheet.getCell(k, j).getContents().trim());
         linha += sheet.getCell(k, j).getContents().trim()+"|";
         }
         } 
         System.out.println(linha+" fim");
         //documento = sheet.getCell(0, j).getContents().trim();
         //                    vencimento = sheet.getCell(1, j).getContents().trim();
         //                    fornecedor = sheet.getCell(3 - opcolumn, j).getContents().trim();
         //                    emissao = sheet.getCell(4 - opcolumn, j).getContents().trim();
         //                    cheque = sheet.getCell(5 - opcolumn, j).getContents().trim();
         //                    valor = sheet.getCell(6 - opcolumn, j).getContents().trim();
         //                    System.out.println(documento + " | " + vencimento + "  |  " + fornecedor + " | " + emissao);
         //                    
         //                    if(409740.78 == totalImp){
         //                        int a = 0;
         //                    }
         //                    
         //                    if (valor != "" & dataValida(emissao)) {
         //  
         //                        addObjectCTP(fornecedor, documento, format.parse(vencimento),Float.parseFloat(getFormatDouble(valor)), "");
         //                        valor = getFormatDouble(valor);
         //                        //totalImp += Double.parseDouble(valor); 
         //                    }
         //                    System.out.println(valor +"   "+totalImp);

         }
         }

         System.out.println("" + funcoes.FormatoMoedaBR_Double(totalImp));
         return "Total Geral lido = R$" + funcoes.FormatoMoedaBR_Double(totalImp) + " Total Importados = R$" + funcoes.FormatoMoedaBR_Double(totalImp);

         } catch (Exception e) {
         e.printStackTrace();
         } finally {
         ctp_conta_pagarDAO.close();
         }
         return null;
         */
    }

    public boolean dataValida(String data) {
        try {

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInicioItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getFormatDouble(String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
