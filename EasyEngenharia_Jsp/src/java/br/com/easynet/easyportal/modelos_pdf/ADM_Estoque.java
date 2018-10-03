/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.modelos_pdf;

import br.com.easynet.gwt.easyportal.dao.Est_estoqueDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.transfer.Est_estoqueT;
import br.com.easynet.gwt.easyportal.util.ConverPDFString;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

/**
 *
 * @author topfontes
 */
public class ADM_Estoque extends SystemBaseEstoquePDF {

    public ADM_Estoque(Est_estoqueT est_estoqueT, Est_estoqueDAO dAO, InputStream is) {
        super(est_estoqueT, dAO, is);
    }
    
        public void povoaEstoque() {
        try {
            treeEst = est_estoqueDAO.getByObr_nr_idTree(est_estoqueT);
        } catch (Exception e) {
        }
    }

    @Override
    public String read() {

        int lin = 0;
        try {

            ConverPDFString converPDFString = new ConverPDFString();
            String path = converPDFString.getString(is);
            is.close();
            file = new File(path);
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            double total = 0;

            factory = est_estoqueDAO.getDAOFactory();
            factory.beginTransaction();
            int linhaColuna = 6;

            String key = "";
            Est_estoqueT est_estoqueTreeT;

            String strvalor;
            String strvalorunit;
            String cod;
            String unidade;
            String strtotal;
            String produto;
            String strquantidade;
            String chave = "";

            boolean inserir;
            boolean linhavalida = false;
            valorLido =0;

            while (br.ready()) { 
                lin++;
                linha = br.readLine();
                linha = linha.trim();
                System.out.println(lin + " - " + linha);
                if (linhaValida(linha)) {
                    String[] fields = getFields(linha);
                    valorLido += Float.parseFloat(fields[4]);
                    //valorLido += Float.parseFloat(fields[4]);
                    chave = fields[0];
                    addObjectEstoque(Float.parseFloat(fields[4]), Float.parseFloat(fields[3]), Float.parseFloat(fields[2]), ".", fields[1], chave.toString());
                    
                }
            }
            factory.commitTransaction();
            return super.read(); //To change body of generated methods, choose Tools | Templates.
            //return "Total Lido = R$ " + Funcoes.FormatoMoedaBR(valorLido) + " Total Importado = R$ " + Funcoes.FormatoMoedaBR(valorImp);
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            return "erro na linha " + lin;
        } finally {
            file.delete();
            est_estoqueDAO.close();
        }

    }

    public String[] getFields(String linha) {
        try {
            String testo = linha;
            int pos = posLastCaracter(testo.trim(), " ");
            String vl = testo.trim().substring(pos, testo.trim().length());
            
            testo = testo.trim().substring(0, pos);

            pos = posLastCaracter(testo, " ");
            String vlunit = testo.substring(pos, testo.trim().length());
            testo = testo.trim().substring(0, pos);

            pos = posLastCaracter(testo, " ");
            String qt = testo.trim().substring(pos, testo.trim().length());
            testo = testo.trim().substring(0, pos);

            pos = posNextCaracter(testo, " ");
            String cod = testo.substring(0, pos);
            testo = testo.substring(pos, testo.length());

            String[] ar ={cod,testo,replaceFormatBR(qt),replaceFormatBR(vlunit),replaceFormatBR(vl)};
            return ar;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean linhaValida(String linha) {
        try {
            String cod = linha.substring(0, posNextCaracter(linha, " "));
            int codigo = Integer.parseInt(cod);
            String vl = linha.substring(posLastCaracter(linha, " "), linha.length());
            vl = replaceFormatBR(vl);
            float valor = Float.parseFloat(vl);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
