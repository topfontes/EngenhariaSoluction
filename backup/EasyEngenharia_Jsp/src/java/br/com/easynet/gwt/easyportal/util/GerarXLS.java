/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.util;

import br.com.easynet.database.DataSet;
import br.com.easynet.gwt.easyportal.dao.Ctp_conta_pagarDAO;
import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.jb.Funcoes;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Ctp_conta_pagarT;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author marcos
 */
public class GerarXLS extends SystemBase {

    private Ctp_conta_pagarT ctp_conta_pagarT = new Ctp_conta_pagarT();
    private Funcoes funcoes = new Funcoes();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private int acumulado;

    public GerarXLS() {
    }

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        geraArquivoXls();
    }

    public void geraArquivoXls() {
        DataSet ds = null;
        int mesRef = ctp_conta_pagarT.getCtp_nr_mes();
        int anoRef = ctp_conta_pagarT.getCtp_nr_ano();
        try {
            Ctp_conta_pagarDAO cdao = getCtp_conta_pagarDAO();
            if (ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("A")) {
                ds = cdao.getAll(ctp_conta_pagarT, 0,false);
            } else {
                if (acumulado == 1) {
                    ds = cdao.getAllAteMes(ctp_conta_pagarT, 0);
                } else {
                    ds = cdao.getAll(ctp_conta_pagarT, 0,false);
                }
            }


            if (ds != null) {
                Obr_obrasDAO odao = getObr_obrasDAO();
                Obr_obrasT obr_obrasT = new Obr_obrasT();
                obr_obrasT.setObr_nr_id(ctp_conta_pagarT.getObr_nr_id());
                obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);

                WritableWorkbook workbook = Workbook.createWorkbook(baos);
                WritableSheet sheet = workbook.createSheet("Produtos", 0);
                String tit1 = "Vencimento";
                String tit2 = "Dt. Pagamento";

                String[] cabecalhoColunas = {"N. documento", tit1, "Mês do controle", "Fornecedor", "Classe", "Sub Classe", "Valor"};

                WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
                WritableCellFormat arial12format = new WritableCellFormat(arial12font);
                WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
                WritableCellFormat arial10format = new WritableCellFormat(arial10font);

                Label label = new Label(0, 1, "Obra: " + obr_obrasT.getObr_tx_nome(), arial10format);

                sheet.addCell(label);

                String periodo = odao.getStrMesAno(mesRef, anoRef);
                label = new Label(0, 2, "Referencia: " + periodo, arial10format);
                sheet.addCell(label);
                WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
                formatTitile.setBackground(Colour.GOLD);
                for (int i = 0; i < cabecalhoColunas.length; i++) {
                    String title = cabecalhoColunas[i];
                    label = new Label(i, 4, title, formatTitile);
                    sheet.addCell(label);
                }
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date;
                int y = 5;
                
                NumberFormat mask = new NumberFormat("#,##0.00");
                WritableCellFormat format = new WritableCellFormat(mask);

                //Motando valor
                WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
                wt.setBackground(Colour.GOLD);
                wt.setAlignment(Alignment.RIGHT);
                wt.setFont(arial10font);

                int utima_linha =0;
                //"ctp_nr_mes,ctp_nr_valor,ctp_nr_documento,ctp_nr_ano,plc_tx_nome,plc_tx_nome_super,ctp_dt_vencimento ,ctp_dt_pagamento";
                for (int i = 0; i < ds.getList().size(); i++) {
                    int x = 0;
                    label = new Label(x++, y, ds.getList().get(i).getColumn("ctp_nr_documento").toString(), arial10format);
                    sheet.addCell(label);
                    //add vencimento
                    date = (Date) ds.getList().get(i).getColumn("ctp_dt_vencimento");
                    label = new Label(x++, y, sdf.format(date), arial10format);
                    sheet.addCell(label);

                    //montar mes controle
                    String mesControle = odao.getStrMesAno(Integer.parseInt(ds.getList().get(i).getColumn("ctp_nr_mes").toString()), Integer.parseInt(ds.getList().get(i).getColumn("ctp_nr_ano").toString()));
                    label = new Label(x++, y, mesControle, arial10format);
                    sheet.addCell(label);

                    //add fornecedor
                    label = new Label(x++, y, ds.getList().get(i).getColumn("ctp_tx_fornecedor").toString(), arial10format);
                    sheet.addCell(label);

                    //nome classe suber
                    label = new Label(x++, y, ds.getList().get(i).getColumn("plc_tx_nome_super").toString(), arial10format);
                    sheet.addCell(label);

                    //add sub Classe
                    label = new Label(x++, y, ds.getList().get(i).getColumn("plc_tx_nome").toString(), arial10format);
                    sheet.addCell(label);
 
                    float vl = Float.parseFloat(ds.getList().get(i).getColumn("ctp_nr_valor").toString());
                    jxl.write.Number number = new jxl.write.Number(x++, y++, vl, format);
                    utima_linha = x;
                    sheet.addCell(number);
                }


                String referencia = odao.getStrMesAno(ctp_conta_pagarT.getCtp_nr_mes(), ctp_conta_pagarT.getCtp_nr_ano());

                String filename = ctp_conta_pagarT.getCtp_tx_status().equalsIgnoreCase("P") ? "Contas Pagas" : "Contas A Pagar";
                filename += "-" + obr_obrasT.getObr_tx_nome() + "-" + periodo + ".xls";

                getSession().setAttribute("filename", filename);
                getSession().setAttribute("baos", baos);
                workbook.write();
                workbook.close();
                setMsg("Arquivo gerado com sucesso!");
            }
        } catch (Exception e) {
            setMsg("Erro na construção do arquivo, verifique se os parametros estão corretos!");
            e.printStackTrace();
        } finally {
            close();
        }

    }

    /**
     * @return the ctp_conta_pagarT
     */
    public Ctp_conta_pagarT getCtp_conta_pagarT() {
        return ctp_conta_pagarT;
    }

    /**
     * @param ctp_conta_pagarT the ctp_conta_pagarT to set
     */
    public void setCtp_conta_pagarT(Ctp_conta_pagarT ctp_conta_pagarT) {
        this.ctp_conta_pagarT = ctp_conta_pagarT;
    }

    /**
     * @return the acumulado
     */
    public int getAcumulado() {
        return acumulado;
    }

    /**
     * @param acumulado the acumulado to set
     */
    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    /*
    Utilizando a JExcelAPI para criação arquivos para o Excel

    JExcel API oferece várias classes para criar, ler e escrever arquivos para o Excel em tempo real.  A plataforma requerida é a JVM que significa que o código desenvolvido com JExcel pode ser executado no Windows e no Linux sem nenhuma modificação.

    O exemplo abaixo cria um novo documento e escreve dados em diferentes folhas de um novo arquivo do Excel.

    import java.io.*;
    import jxl.*;
    import java.util.*;
    import jxl.Workbook;
    import jxl.write.DateFormat;
    import jxl.write.Number;

    import jxl.write.*;
    import java.text.SimpleDateFormat;

    class  create
    {
    public static void main(String[] args)
    {
    try
    {
    String filename = "entrada.xls";
    WorkbookSettings ws = new WorkbookSettings();
    ws.setLocale(new Locale("en", "EN"));
    WritableWorkbook workbook =
    Workbook.createWorkbook(new File(filename), ws);
    WritableSheet s = workbook.createSheet("Folha1", 0);
    WritableSheet s1 = workbook.createSheet("Folha1", 0);
    writeDataSheet(s);
    writeImageSheet(s1);
    workbook.write();
    workbook.close();
    }
    catch (IOException e)
    {
    e.printStackTrace();
    }
    catch (WriteException e)
    {
    e.printStackTrace();
    }
    }

    private static void writeDataSheet(WritableSheet s)
    throws WriteException
    {

    // Formata a fonte
    WritableFont wf = new WritableFont(WritableFont.ARIAL,
    10, WritableFont.BOLD);
    WritableCellFormat cf = new WritableCellFormat(wf);
    cf.setWrap(true);

    // Cria um label e escreve a data em uma célula da folha
    Label l = new Label(0,0,"Data",cf);
    s.addCell(l);
    WritableCellFormat cf1 =
    new WritableCellFormat(DateFormats.FORMAT9);

    DateTime dt =
    new DateTime(0,1,new Date(), cf1, DateTime.GMT);

    s.adCell(dt);

    // Cria um label e escreve um float numver em uma célula da folha
    l = new Label(2,0,"Float", cf);
    s.addCell(l);
    WritableCellFormat cf2 = new WritableCellFormat(NumberFormats.FLOAT);
    Number n = new Number(2,1,3.1415926535,cf2);
    s.addCell(n);

    n = new Number(2,2,-3.1415926535, cf2);
    s.addCell(n);

    // Cria um label e escreve um float number acima de 3 decimais
    em uma célula da folha
    l = new Label(3,0,"3dps",cf);
    s.addCell(l);
    NumberFormat dp3 = new NumberFormat("#.###");
    WritableCellFormat dp3cell = new WritableCellFormat(dp3);
    n = new Number(3,1,3.1415926535,dp3cell);
    s.addCell(n);

    // Cria um label e adiciona 2 células na folha
    l = new Label(4, 0, "Add 2 cells",cf);
    s.addCell(l);
    n = new Number(4,1,10);
    s.addCell(n);
    n = new Number(4,2,16);
    s.addCell(n);
    Formula f = new Formula(4,3, "E1+E2");
    s.addCell(f);

    // Cria um Label e mulpiplica o valor de uma célula da folha por 2
    l = new Label(5,0, "Multiplica por 2",cf);
    s.addCell(l);
    n = new Number(5,1,10);
    s.addCell(n);
    f = new Formula(5,2, "F1 * 3");
    s.addCell(f);

    // Cria um Label e divide o valor de uma célula da folha por 2.5
    l = new Label(6,0, "Divide por 2.5",cf);
    s.addCell(l);
    n = new Number(6,1, 12);
    s.addCell(n);
    f = new Formula(6,2, "F1/2.5");
    s.addCell(f);
    }

    private static void writeImageSheet(WritableSheet s)
    throws WriteException
    {
    // Cria um label e escreve uma imagem em uma célula da folha
    Label l = new Label(0, 0, "Imagem");
    s.addCell(l);
    WritableImage wi = new WritableImage(0, 3, 5, 7, new File("imagem.png"));
    s.addImage(wi);

    // Cria um label e escreve hyperlink em uma célula da folha
    l = new Label(0,15, "HYPERLINK");
    s.addCell(l);
    Formula f = new Formula(1, 15,
    "DevMedia(\"http://www.devmedia.com.br\", "+
    "\"Portal DevMedia\")");
    s.addCell(f);

    }
    }

     */
}


