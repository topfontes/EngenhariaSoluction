/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.database.DataSet;
import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.jb.EasyDownloadJB;
import bsh.org.objectweb.asm.Label;
import java.io.ByteArrayOutputStream;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 *
 * @author marcos
 */
public class GerarXLSOrcTempJB extends SystemBase implements INotSecurity {

    private int obr_nr_id;

    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void gerarArquivoXls() {
        try {

            DataSet ds = getOrt_orcamento_temporarioDAO().getAllObra(obr_nr_id);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet = workbook.createSheet("PMS", 0);
            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            WritableFont arial12fontWidth = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial12fontWidth.setPointSize(500);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);
            WritableCellFormat arial10format = new WritableCellFormat(arial10font);


            String[] cabecalhoColunas = {"Cod. Comp. Antiga","Material Item Pai()Cód Comp Novo)", "Centro(Cód. Obra)", "Cód. insumo Antigo","Material Conponente(Cód. Insumo novo)", "Quant. do Insumo na Composição", "Und medida", "Ctg Item"};
            WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
            formatTitile.setBackground(Colour.GOLD);

            WritableCellFormat formatkey = new WritableCellFormat(NumberFormats.FLOAT);
            formatkey.setBackground(Colour.GOLD);

            for (int i = 0; i < cabecalhoColunas.length; i++) {
                String title = cabecalhoColunas[i];
                jxl.write.Label label = new jxl.write.Label(i, 1, title, formatTitile);
                sheet.addCell(label);
            }

            WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
            wt.setBackground(Colour.GOLD);
            wt.setAlignment(jxl.format.Alignment.RIGHT);
            wt.setFont(arial10font);

            int y = 2;
            for (int i = 0; i < ds.getList().size(); i++) {
                int x = 0;
                String vl = "";

                if (ds.getList().get(i).getColumn("coa_tx_codigo") != null) {
                    vl = ds.getList().get(i).getColumn("coa_tx_codigo").toString();
                }
                jxl.write.Label label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);

                vl = "";
                if (ds.getList().get(i).getColumn("con_tx_codigo") != null) {
                    vl = ds.getList().get(i).getColumn("con_tx_codigo").toString();
                }
                label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);

                vl = "";
                if (ds.getList().get(i).getColumn("ort_tx_cod_obra") != null) {
                    vl = ds.getList().get(i).getColumn("ort_tx_cod_obra").toString();
                }
                label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);

                vl = "";
                if (ds.getList().get(i).getColumn("ina_tx_codigo") != null) {
                    vl = ds.getList().get(i).getColumn("ina_tx_codigo").toString();
                }
                label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);

                vl = "";
                if (ds.getList().get(i).getColumn("inn_tx_codigo") != null) {
                    vl = ds.getList().get(i).getColumn("inn_tx_codigo").toString();
                }
                label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);

                float qtde = Float.parseFloat(ds.getList().get(i).getColumn("ort_nr_quantidade").toString());
                jxl.write.Number number = new jxl.write.Number(x++, y, qtde);
                sheet.addCell(number);

                vl = "";
                if (ds.getList().get(i).getColumn("inn_tx_unidade") != null) {
                    vl = ds.getList().get(i).getColumn("inn_tx_unidade").toString();
                }
                label = new jxl.write.Label(x++, y, vl, arial10format);
                sheet.addCell(label);
                vl = "";
                if (ds.getList().get(i).getColumn("ort_tx_letra") != null) {
                    vl = ds.getList().get(i).getColumn("ort_tx_letra").toString();
                }
                label = new jxl.write.Label(x++, y++, vl, arial10format);
                sheet.addCell(label);


            }

            String filename = "Orcamento.xls";
            getSession().setAttribute("baos", baos);
            getSession().setAttribute("filename", filename);
            workbook.write();
            workbook.close();
            download(baos, filename);
            setMsg("Arquivo gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void download(ByteArrayOutputStream baos, String filename) throws Exception {
        try {
            if (baos != null) {
                getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "arquivo/xls");
                getRequest().setAttribute(EasyDownloadJB.FILE_NAME, filename);
                getRequest().setAttribute(EasyDownloadJB.DATA, baos.toByteArray());
                getPage().forward("/portal/easydownload.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }
    }

    /**
     * @return the obr_nr_id
     */
    public int getObr_nr_id() {
        return obr_nr_id;
    }

    /**
     * @param obr_nr_id the obr_nr_id to set
     */
    public void setObr_nr_id(int obr_nr_id) {
        this.obr_nr_id = obr_nr_id;
    }
}
