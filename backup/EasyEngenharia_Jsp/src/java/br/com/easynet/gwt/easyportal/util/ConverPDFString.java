/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.easynet.gwt.easyportal.util;
 
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.sound.midi.SysexMessage;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author marcos
 */
public class ConverPDFString extends SystemBase{
    private File file;

    public ConverPDFString(String pathName) {
        this.file = new File(pathName);
    }
     public ConverPDFString() {
        
    }
    public String getString(){
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        PDDocument pdfDocument = null;
        try {
            PDFParser parser = new PDFParser(is);
            parser.parse();
            pdfDocument = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(pdfDocument);

        } catch (IOException e) {
            System.out.println("ERRO: Não é possível abrir a stream" + e);
        } catch (Throwable e) {
            // Fazemos um catch, uma vez que precisamos de fechar o recurso
            System.out.println("ERRO: Um erro ocorreu enquanto tentava obter o conteúdo do PDF" + e);
        } finally {
            if (pdfDocument != null) {
                try {
                    pdfDocument.close();
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o PDF." + e);
                }
            }
        }
        return null;

    }
    public String getString(InputStream is) throws  Exception{
        PDDocument pdfDocument = null;
        try { 
            PDFParser parser = new PDFParser(is);
            parser.parse();
            pdfDocument = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            File diretorio = new File(PATH_WEB);
            String path;
            //System.out.println("PATH_WEB = "+PATH_WEB);
            if (diretorio.exists()){
                path = PATH_WEB.concat("pdf_text.txt");
            }else{
                path = PATH_LOCAL.concat("pdf_text.txt");
            }
            FileWriter fw = new FileWriter(path);
            fw.write(stripper.getText(pdfDocument));
            fw.flush();
            fw.close();
            return path;

        } catch (IOException e) {
            System.out.println("ERRO: Não é possível abrir a stream" + e);
            throw e;
        } catch (Throwable e) {
            // Fazemos um catch, uma vez que precisamos de fechar o recurso
            System.out.println("ERRO: Um erro ocorreu enquanto tentava obter o conteúdo do PDF" + e);
        } finally {
            if (pdfDocument != null) {
                try {
                    pdfDocument.close();
                } catch (IOException e) {
                    System.out.println("ERRO: Não foi possível fechar o PDF." + e);
                }
            }
        }
        return null;

    }



}
