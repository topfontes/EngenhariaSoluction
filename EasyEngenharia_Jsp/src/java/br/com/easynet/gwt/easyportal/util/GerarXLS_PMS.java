/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.util; 

import br.com.easynet.gwt.easyportal.dao.Obr_obrasDAO;
import br.com.easynet.gwt.easyportal.jb.Consult_PMS_JB;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Obr_obrasT;
import br.com.easynet.gwt.easyportal.transfer.Pms_planilha_medicao_servicoT;
import br.com.easynet.gwt.easyportal.transfer.Tpms_temporaria_pmsT;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.CellFormat;
import jxl.Sheet;
import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.DateFormat;
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
public class GerarXLS_PMS extends SystemBase {

    private Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT = new Pms_planilha_medicao_servicoT();
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private Obr_obrasT obr_obrasT = new Obr_obrasT();

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
        gerarArquivoXls();
    }

    public void gerarArquivoXls() {
        try {

            Obr_obrasDAO odao = getObr_obrasDAO();
            obr_obrasT.setObr_nr_id(pms_planilha_medicao_servicoT.getObr_nr_id());

            obr_obrasT = odao.getByObr_nr_id(obr_obrasT).get(0);

            Consult_PMS_JB consult_PMS_JB = new Consult_PMS_JB(pms_planilha_medicao_servicoT, getDAO());
            List<Tpms_temporaria_pmsT> list = consult_PMS_JB.consult();

            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet = workbook.createSheet("PMS", 0);
            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            WritableFont arial12fontWidth = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial12fontWidth.setPointSize(500);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat arial10format = new WritableCellFormat(arial10font);

            //titulo
            Label label = new Label(0, 1, "Obra: " + obr_obrasT.getObr_tx_nome(), arial10format);
            sheet.addCell(label);


            String periodo = odao.getStrMesAno(pms_planilha_medicao_servicoT.getPms_nr_mes(), pms_planilha_medicao_servicoT.getPms_nr_ano());
            label = new Label(0, 2, "Referencia: " + periodo, arial10format);
            sheet.addCell(label);

            String[] cabecalhoColunas = {"IPO","PLC","SUPER", "Código", "Serviço", "Und", "Qtde. Orçada", "Qtde. Acumulado Anterior", "Quantidade Executada", "Qtde. Aculada até período", "Saldo"};
            WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
            formatTitile.setBackground(Colour.GOLD);

            WritableCellFormat formatkey = new WritableCellFormat(NumberFormats.FLOAT);
            formatkey.setBackground(Colour.GOLD);

            for (int i = 0; i < cabecalhoColunas.length; i++) {
                String title = cabecalhoColunas[i];
                label = new Label(i, 4, title, formatTitile);
                sheet.addCell(label);
            }

            WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
            wt.setBackground(Colour.GOLD);
            wt.setAlignment(Alignment.RIGHT);
            wt.setFont(arial10font);

            NumberFormat numberFormat = new NumberFormat("#,##0.00");
            WritableCellFormat format = new WritableCellFormat(numberFormat);

            int y = 5;
            for (int i = 0; i < list.size(); i++) {
                int x = 0;
                label = new Label(x++, y, list.get(i).getIpo_nr_id() + "", formatkey);
                sheet.addCell(label);

                label = new Label(x++, y, list.get(i).getPlco_nr_id() + "", formatkey);
                sheet.addCell(label);

                label = new Label(x++, y, list.get(i).getIpo_nr_id_super() + "", formatkey);
                sheet.addCell(label);

                label = new Label(x++, y, list.get(i).getTpms_tx_codigo_externo(), arial10format);
                sheet.addCell(label);

                label = new Label(x++, y, list.get(i).getTpms_tx_conta(), arial10format);
                sheet.addCell(label);

                label = new Label(x++, y, list.get(i).getTpms_tx_unidade(), arial10format);
                sheet.addCell(label);

                double qtde_orcada = list.get(i).getTpms_nr_quantidade_total();
                jxl.write.Number number = new jxl.write.Number(x++, y, qtde_orcada, format);
                sheet.addCell(number);

                double qtde_acumulada_ant = list.get(i).getTpms_nr_quantidade_acumulada_ant();
                number = new jxl.write.Number(x++, y, qtde_acumulada_ant, format);
                sheet.addCell(number);

                float qtde = 0;
                number = new jxl.write.Number(x++, y, qtde);
                sheet.addCell(number);

                float qtde_acumulada_periodo = 0;
                number = new jxl.write.Number(x++, y, qtde_acumulada_periodo);
                sheet.addCell(number);

                double saldo = list.get(i).getTpms_nr_saldo();
                number = new jxl.write.Number(x++, y++, saldo, format);
                sheet.addCell(number);
            }

            String filename = "PMS";
            filename += "-" + obr_obrasT.getObr_tx_nome() + "-" + periodo+".xls";
            getSession().setAttribute("baos", baos);
            getSession().setAttribute("filename", filename);
            workbook.write();
            workbook.close();
            setMsg("Arquivo gerado com sucesso!");

        } catch (Exception e) {
        }

    }


    /**
     * @return the pms_planilha_medicao_servicoT
     */
    public Pms_planilha_medicao_servicoT getPms_planilha_medicao_servicoT() {
        return pms_planilha_medicao_servicoT;
    }

    /**
     * @param pms_planilha_medicao_servicoT the pms_planilha_medicao_servicoT to set
     */
    public void setPms_planilha_medicao_servicoT(Pms_planilha_medicao_servicoT pms_planilha_medicao_servicoT) {
        this.pms_planilha_medicao_servicoT = pms_planilha_medicao_servicoT;
    }
}

