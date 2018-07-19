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
import java.text.ParseException;
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
            treeConta = ctp_conta_pagarDAO.getByObr_nr_idTreeEngeb(this.ctp_conta_pagarT);
            int a = 2;
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

                return getClearCaracterToString(parte.substring(posInidoc, parte.length()).trim(), "%");
            } catch (Exception e) {
                posInidoc = posIniVal;
                if (parte.indexOf("CH ") > 0) {
                    int p = parte.indexOf("CH ");
                    int c = 0;
                    for (int i = p; i < parte.length(); i++) {
                        String v = parte.substring(i, i + 1);
                        if (v.equalsIgnoreCase(" ")) {
                            c++;
                            if (c == 2) {
                                return parte.substring(p, i);
                            }
                        }

                    }

                }
                return "";
            }

        } catch (Exception e) {
            return "";
        }

    }

    public String getClearCaracterToString(String valor, String caracter) {
        if (valor.trim().indexOf(caracter) > 0) {
            for (int i = valor.trim().indexOf(caracter); i > 0; i--) {
                String l = valor.substring(i - 1, i);
                if (l.equals(" ")) {
                    if (i > 3) {
                        return valor.substring(0, i);
                    }
                }
            }
        }
        return valor;
    }

    public String getClearDateToString(String valor) {
        if (valor.indexOf(" ") > 0) {
            String vl = valor.substring(0, valor.indexOf(" "));
            if (dataValida(vl)) {
                return valor.substring(valor.indexOf(" "), valor.length());
            }
        }
        return valor;
    }

    public String getVencimento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float getValor() {
        String vl = linha.substring(posIniVal, linha.length());
        vl = vl.replace(".", "");
        vl = vl.replace(",", ".");
        if (vl.indexOf("(") > -1) {
            if (vl.indexOf(")") > -1) {
                vl = vl.replace("(", "");
                vl = vl.replace(")", "");
                vl = "-" + vl;
            }
        }
        return Float.parseFloat(vl);
    }

    public String getFornecedor() {
        try {
            String vl = getClearCaracterToString(linha.trim().substring(linha.indexOf(" "), posInidoc), "%");
            vl = getClearDateToString(vl);
            return vl;

        } catch (Exception e) {

        }
        return "";
    }

    public String getObs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean valorValido() {
        String vl = "";
        try {
            posIniVal = posLastCaracter(linha, " ");
            vl = linha.substring(posIniVal, linha.length());
            if (vl.indexOf(",") > -1) {
                vl = vl.replace(".", "");
                vl = vl.replace(",", ".");
                vl = vl.replace("(", "");
                vl = vl.replace(")", "");
                float vlf = Float.parseFloat(vl.trim());
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
                    if (lin == 264) {
                        int a = 0;
                    }
                    System.out.println("A pagar " + lin + "  " + linha);
                    if (dataValida(campo)) {
                        datapreenchida = true;
                        String dtStr = campo.trim().length() > 7 ? campo : "01/" + campo;
                        vencimento = sdf.parse(dtStr);
                        if (valorValido()) {

                            valor = getValor();
                            total += valor;
                            documento = getDocumento().trim();
                            fornecedor = getFornecedor().trim();
                            documento = documento.trim().isEmpty() ? "SD" : documento;
                            if (documento.indexOf("%") > -1) {
                                documento = "SD";
                            }
                            StringBuffer key = new StringBuffer().append(documento.trim()).append(".").append(sdf.format(vencimento));
                            key.append(".").append(fornecedor.trim()).append(".").append(Float.toString(valor));
                            String keyStr = ctp_conta_pagarDAO.getValueSemAspas(key.toString());
                            if (keyStr.length() > 299) {
                                keyStr = keyStr.substring(0, 299).trim();
                            }
                            if (treeConta.get(keyStr.toString()) == null) {
                                addObjectCTP(fornecedor.trim(), documento.trim(), vencimento, valor, key.toString().trim());
                                System.out.println(" insert");
                            }
                            datapreenchida = false;
                        } else {
                            fornecedor = linha.substring(0, linha.length());
                            fornecedor = getClearCaracterToString(fornecedor, "%");
                            fornecedor = getClearDateToString(fornecedor);
                        }

//                        System.out.println("A pagar " + lin + "  " + linha);
                    } else {
                        if (datapreenchida) {
                            if (valorValido()) {
                                valor = getValor();
                                total += valor;
                                try {
                                    documento = getClearCaracterToString(linha.substring(0, posIniVal), "%");
                                    documento = documento.trim().isEmpty() ? "SD" : documento;
                                } catch (Exception e) {
                                }
                                documento = documento.trim().isEmpty() ? "SD" : documento;
                                if (documento.indexOf("%") > -1) {
                                    documento = "SD";
                                }
                                StringBuffer key = new StringBuffer().append(documento.trim()).append(".").append(sdf.format(vencimento));
                                key.append(".").append(fornecedor).append(".").append(Float.toString(valor));
                                String keyStr = ctp_conta_pagarDAO.getValueSemAspas(key.toString());
                                if (keyStr.length() > 299) {
                                    keyStr = keyStr.substring(0, 299).trim();
                                }
                                if (treeConta.get(keyStr.trim()) == null) {
                                    addObjectCTP(fornecedor.trim(), documento.trim(), vencimento, valor, key.toString().trim());
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
            if (data.trim().length() == 5) {
                if (data.indexOf("/") == 2) {
                    data = "01/" + data;
                    try {
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                        return true;
                    } catch (Exception ex) {
                    }
                    //return false;

                }
            }
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
