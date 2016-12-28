/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

/**
 *
 * @author topfontes
 */
public class ADM_Apagar extends SystemBasePDF implements ModeloPDF {

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad(); //To change body of generated methods, choose Tools | Templates.
    }

    public ADM_Apagar(Ctp_conta_pagarT ctp_conta_pagarT, Ctp_conta_pagarDAO cdao, InputStream is) {
        super(ctp_conta_pagarT, cdao, is);
    }

    public String getDocumento() {
        try {
            return linha.substring(posNextCaracter(linha, " "), posLastCaracter(linha, " "));
        } catch (Exception ex) {
            Logger.getLogger(ADM_Apagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getVencimento() {
        String valor = linha.substring(0, posNextCaracter(linha, " "));
        return valor;
    }

    public float getValor() {
        try {
            String vl = linha.substring(posLastCaracter(linha, " "), linha.length());
            return Float.parseFloat(replaceFormatBR(vl));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getFornecedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getObs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String read() {

        String valor="";
        String emissao="";
        String vencimento="";
        String documento="";

        String fornecedor="";
        SimpleDateFormat format = new SimpleDateFormat("d/MM/yyyy");
        String cheque="";
        int linefirt;
        int opcolumn = 0;
        int maxColunm;
        int qtfieldsAtribuidos = 0;
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

                maxColunm = sheet.getColumns(); 

                for (int j = linefirt; j < (sheet.getRows()); j++) {
                    qtfieldsAtribuidos = 0;
                    
                    if(j==9){
                        int a =1;
                    }
                    for (int col = maxColunm-1; col > -1; col--) {
                        String value = sheet.getCell(col, j).getContents().trim();
                        if (value != "") {
                            switch (qtfieldsAtribuidos) {
                                case 0:
                                    valor = value;
                                    qtfieldsAtribuidos ++;
                                    break;
                                case 1:
                                    cheque = value;
                                    qtfieldsAtribuidos ++;
                                    break;
                                case 2:
                                    emissao = value;
                                    qtfieldsAtribuidos ++;
                                    break;
                                case 3:
                                    fornecedor = value;
                                    qtfieldsAtribuidos ++;
                                    break;
//                                case 4:
//                                    qtfieldsAtribuidos ++;
//                                    break;
//                                case 5:
//                                    vencimento = value;
//                                    qtfieldsAtribuidos ++;
//                                    break;
//                                case 7:
//                                    documento = value;
//                                    qtfieldsAtribuidos ++;
//                                    break;
                                default:
                                    System.out.println("Este não é um dia válido!");

                            }
                        }
                    }

                     documento = sheet.getCell(0, j).getContents().trim();
//                    vencimento = sheet.getCell(2, j).getContents().trim();
//                    fornecedor = sheet.getCell(7, j).getContents().trim();
//                    emissao = sheet.getCell(8, j).getContents().trim();
//                    cheque = sheet.getCell(9, j).getContents().trim();
//                    valor = sheet.getCell(13, j).getContents().trim();

                    if (409740.78 == totalImp) {
                        int a = 0;
                    }

                    System.out.println("linha = "+j);
                    
                    if (valor != "" & dataValida(emissao)) {

                        addObjectCTP(fornecedor, documento+"-"+cheque, format.parse(emissao), Float.parseFloat(getFormatDouble(valor)), "");
                        valor = getFormatDouble(valor);
                        //totalImp += Double.parseDouble(valor); 
                    }
                    System.out.println(valor + "   " + totalImp);
 
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

    }

    public boolean dataValida(String data) {
        try {

            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLinhavalor() {
        try {
            String valor = linha.substring(0, posNextCaracter(linha, " "));
            java.util.Date data = sdf.parse(valor);
            String vl = linha.substring(posLastCaracter(linha, " "), linha.length());
            float vl_fl = Float.parseFloat(replaceFormatBR(vl));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInicioItem() {
        try {
            String valor = linha.substring(0, posNextCaracter(linha, " "));
            java.util.Date data = sdf.parse(valor);
            try {
                String vl = linha.substring(posLastCaracter(linha, " "), linha.length());
                float vl_fl = Float.parseFloat(replaceFormatBR(vl));
            } catch (Exception e) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFormatDouble(String valor) {
        String vl = valor.replace(".", "");
        vl = vl.replace(",", ".");
        return vl;
    }

}
