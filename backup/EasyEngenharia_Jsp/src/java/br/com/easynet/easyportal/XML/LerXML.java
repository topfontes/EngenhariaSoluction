/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.easynet.easyportal.XML;

import br.com.easynet.easyportal.jb.INotSecurity;
import br.com.easynet.gwt.easyportal.jb.SystemBase;
import br.com.easynet.gwt.easyportal.transfer.Arq_arquivoT;
import br.com.easynet.jb.EasyDownloadJB;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.net.URL;
//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
//import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.VerticalAlignment;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;

/**
 *
 * @author marcos
 */
public class LerXML extends SystemBase implements INotSecurity {

    private List<Locations> listLocation = new Vector();
    private List<ScheduleTasks> listSchedueleTasks = new Vector();
    private TreeMap<String, String> treeLocation = new TreeMap<String, String>();
    private Elemento MasterElemento = new Elemento();
    private int linMaster = 0;
    private int colMaster = 0;
    private TreeMap<String, Integer> treePosition = new TreeMap<String, Integer>();
    private TreeMap<String, Elemento> treeElenetos = new TreeMap<String, Elemento>();
    private int maxlegth = 0;
    private int maxNivel = 0;
    private Arq_arquivoT arq_arquivoT = new Arq_arquivoT();
    private String fileName;

//    public static void main(String[] ai) {
//        try {
////            gerarArquivoXls();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Override
    public void pageLoad() throws Exception {
        super.pageLoad();
    }

    public void readXML() {
        try {
            ByteArrayInputStream bais = null;
            System.out.println("Verificando se existe arquivo em anexo");
            if (getArq_arquivoT().getArq_bt_arquivo() != null) {
                System.out.println("arquivo existe");
                bais = new ByteArrayInputStream(getArq_arquivoT().getArq_bt_arquivo());
            }
//            URL url = LerXML.class.getResource("Asa-Branca-Jan14.xml");
//            File file = new File(url.getPath());
            System.out.println("baos");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.out.println("DocumentBuilder");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            System.out.println("SAXBuilder");
            SAXBuilder builder = new SAXBuilder();

//            Document doc = builder.build(file);
            System.out.println("Docs");
            Document doc = builder.build(bais);
            System.out.println("Elements");
            Element elements = doc.getRootElement();

            System.out.println("list schildren");
            List lista = elements.getChildren();
            Iterator i = lista.iterator();

            Element locations = (Element) lista.get(1);
            List<Element> listLocations = locations.getChildren();
            System.out.println("Read Location");
            readLocations(listLocations);
            System.out.println("Final Read Location");

            Element scheduleTasks = (Element) lista.get(3);
//            System.out.println("id =" + scheduleTasks.getAttributeValue(""));
            System.out.println("Read listScheduleTasks");
            List<Element> listScheduleTasks = scheduleTasks.getChildren();
            readScheduleTask(listScheduleTasks);
            System.out.println("Final Read listScheduleTasks");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void gerarArquivoXls() {
        try {

            readXML();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);
            WritableSheet sheet2 = workbook.createSheet("Lista", 0);
//            WritableSheet sheet = workbook.createSheet("Matriz", 1);

            WritableFont arial12font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            WritableFont arial12fontWidth = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            WritableCellFormat arial12format = new WritableCellFormat(arial12font);
            WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10);

            WritableCellFormat celulaformat = new WritableCellFormat();

            celulaformat.setAlignment(Alignment.CENTRE);
            celulaformat.setFont(arial10font);

            WritableCellFormat celulaformatV = new WritableCellFormat();

            celulaformatV.setAlignment(Alignment.CENTRE);
            celulaformatV.setFont(arial10font);
            celulaformatV.setOrientation(Orientation.MINUS_90);
            celulaformatV.setBackground(Colour.GRAY_25);
            celulaformatV.setVerticalAlignment(VerticalAlignment.TOP);

            WritableCellFormat celulaformatTit = new WritableCellFormat();

            celulaformatTit.setAlignment(Alignment.LEFT);
            celulaformatTit.setFont(arial10font);
            celulaformatTit.setBackground(Colour.YELLOW2);


            CellView cellView = new CellView();
            cellView.setFormat(celulaformatV);
            cellView.setAutosize(true);

            WritableCellFormat arial10format = new WritableCellFormat(arial10font);

            WritableCellFormat formatTitile = new WritableCellFormat(NumberFormats.FLOAT);
            formatTitile.setBackground(Colour.GOLD);

            WritableCellFormat formatkey = new WritableCellFormat(NumberFormats.FLOAT);
            formatkey.setBackground(Colour.GOLD);

            WritableCellFormat wt = new WritableCellFormat(NumberFormats.FLOAT);
            wt.setBackground(Colour.GOLD);
            wt.setAlignment(jxl.format.Alignment.RIGHT);
            wt.setFont(arial10font);

            int col = 0;
            int lin = 0;


//            98295045 easybox

            int lastColumn = 0;

            int limitCol = 256;
            WritableSheet sheet;
            int seqPlan = 1;
            sheet = workbook.createSheet("Matriz " + 1, seqPlan);
            preencherEsqueletoMatriz(sheet, arial10format, MasterElemento.getList());
            lastColumn = maxNivel;
            int ct = 0;
            int contPlan = 1;

            for (ScheduleTasks schedule : listSchedueleTasks) {
                if ((limitCol - lastColumn) < 3) {
                    contPlan++;
                    seqPlan++;
                    sheet = workbook.createSheet("Matriz " + contPlan, seqPlan);
                    treePosition.clear();
                    lastColumn = maxNivel;
                    linMaster = 0;
                    preencherEsqueletoMatriz(sheet, arial10format, MasterElemento.getList());
                }
                lastColumn++;
                lastColumn++;


                jxl.write.Label label = new jxl.write.Label(lastColumn, linMaster, schedule.getName(), celulaformatV);

                sheet.setRowView(linMaster, 140 * 20);
                sheet.setColumnView(lastColumn, 11);
                sheet.addCell(label);
                for (Timings timings : schedule.getListTimings()) {
                    int new_lin = treePosition.get(timings.getLocationID());
                    if (new_lin == 0) {
                        int o = 0;
//                        System.out.println(timings.getLocationID());
                    }

                    String valor = timings.getIni_proj() + " " + timings.getFim_proj() + "\n" + timings.getIni_real() + " " + timings.getFim_real();

                    jxl.write.Label lab = new jxl.write.Label(lastColumn, new_lin, timings.getIni_proj(), arial10format);
                    sheet.setColumnView(lastColumn, 7);
                    sheet.addCell(lab);

                    lab = new jxl.write.Label(lastColumn + 1, new_lin, timings.getFim_proj(), arial10format);
                    sheet.setColumnView(lastColumn + 1, 7);
                    sheet.addCell(lab);

                    lab = new jxl.write.Label(lastColumn, new_lin + 1, timings.getIni_real(), arial10format);
                    sheet.addCell(lab);

                    lab = new jxl.write.Label(lastColumn + 1, new_lin + 1, timings.getFim_real(), arial10format);
                    sheet.setColumnView(lastColumn, 7);
                    sheet.addCell(lab);

                }
//                colIni++;
            }

            linMaster = 0;
            treePosition.clear();

            setCabechario(sheet2, celulaformatTit);
            for (ScheduleTasks schedule : listSchedueleTasks) {
                treePosition.clear();
                preencherEsqueletoLista(sheet2, arial10format, MasterElemento.getList(), schedule.getName());
                setValoresLista(schedule.getListTimings(), sheet2, arial10format);
            }

            String file = fileName + ".xls";
            file = file.replace(" ", "_");
            getSession().setAttribute("baos", baos);
            getSession().setAttribute("filename", file);
            workbook.write();
            workbook.close();
            download(baos, file);
            setMsg("Arquivo gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preencherEsqueletoMatriz(WritableSheet sheet, WritableCellFormat arial10format, List<Elemento> list) {
        try {
            for (Elemento elemento : list) {
                int coluna = elemento.getIndex();
                treePosition.put(elemento.getId(), linMaster);
                jxl.write.Label lab = new jxl.write.Label(coluna, linMaster, elemento.getName(), arial10format);
                sheet.setColumnView(coluna, elemento.getName().length() + 2);
                sheet.addCell(lab);
                coluna++;
                List<Elemento> lista = elemento.getList();
//                System.out.println(elemento.getIdParent()+", "+elemento.getId()+", "+ elemento.getName()+", nivel = "+elemento.getIndex()+" "+(lista.size() == 0?"ultimo":" existe"));
                if (lista.size() == 0) {
//                    if (maxNivel == elemento.getIndex()) {
                    //int coll = coluna++;
                    int coll = maxNivel+1;
                    lab = new jxl.write.Label(coll, linMaster, "P", arial10format);
                    sheet.addCell(lab);
                    linMaster++;
                    lab = new jxl.write.Label(coll, linMaster, "R", arial10format);
                    sheet.addCell(lab);
                    linMaster++;

                }

                preencherEsqueletoMatriz(sheet, arial10format, elemento.getList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setCabechario(WritableSheet sheet, WritableCellFormat format) {
        try {
            for (int i = 0; i < maxNivel; i++) {
                jxl.write.Label lab = new jxl.write.Label(i, linMaster, "1", format);
                sheet.addCell(lab);
            }
            int n = maxNivel;
            jxl.write.Label lab = new jxl.write.Label(n++, linMaster, "serviço", format);
            sheet.addCell(lab);
            lab = new jxl.write.Label(n++, linMaster, "Unidade de Controle", format);
            sheet.addCell(lab);
            lab = new jxl.write.Label(n++, linMaster, "Início Prj", format);
            sheet.addCell(lab);
            lab = new jxl.write.Label(n++, linMaster, "Final Prj", format);
            sheet.addCell(lab);
            lab = new jxl.write.Label(n++, linMaster, "Início Real", format);
            sheet.addCell(lab);
            lab = new jxl.write.Label(n++, linMaster, "Final Real", format);
            sheet.addCell(lab);
            linMaster++;

        } catch (Exception e) {
        }

    }

    public void preencherEsqueletoLista(WritableSheet sheet, WritableCellFormat arial10format, List<Elemento> list, String task) throws WriteException {
        try {
            for (Elemento elemento : list) {
                int coluna = elemento.getIndex();
                //System.out.println(elemento.getName());
                treePosition.put(elemento.getId(), linMaster);
                jxl.write.Label lab = new jxl.write.Label(coluna, linMaster, elemento.getName(), arial10format);
                sheet.setColumnView(coluna, elemento.getName().length() + 2);
                sheet.addCell(lab);
                if (elemento.getIndex() == maxNivel) {
                    if (maxlegth < task.length()) {
                        maxlegth = task.length();
                    }
                    lab = new jxl.write.Label(coluna++, linMaster, task, arial10format);
                    sheet.setColumnView((coluna - 1), maxlegth);
                   //System.out.println(task + ", " + (coluna - 1) + " - " + task.trim().length());
                    sheet.addCell(lab);
                    lab = new jxl.write.Label(coluna++, linMaster, elemento.getName(), arial10format);
                    colMaster = coluna;
                    sheet.setColumnView(coluna, task.length() + 2);
                    sheet.addCell(lab);
                    linMaster++;
                }
                preencherEsqueletoLista(sheet, arial10format, elemento.getList(), task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// 291 722 101 - 9745

    public void setValoresLista(List<Timings> list, WritableSheet sheet, WritableCellFormat arial10format) throws WriteException {
        //int col = colMaster;
        for (Timings timings : list) {
            int col = colMaster;
            int lin = treePosition.get(timings.getLocationID());
            jxl.write.Label lab;
            lab = new jxl.write.Label(col++, lin, timings.getIni_projAll(), arial10format);
            sheet.setColumnView(col, 11);
            sheet.addCell(lab);
            lab = new jxl.write.Label(col++, lin, timings.getFim_projAll(), arial10format);
            sheet.setColumnView(col, 11);
            sheet.addCell(lab);
            lab = new jxl.write.Label(col++, lin, timings.getIni_realAll(), arial10format);
            sheet.setColumnView(col, 11);
            sheet.addCell(lab);
            lab = new jxl.write.Label(col, lin, timings.getFim_realAll(), arial10format);
            sheet.setColumnView(col, 11);
            sheet.addCell(lab);

        }
    }

    public boolean dataValida(String data) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = format.parse(data);
        } catch (Exception e) {
            return false;
        }

        return true;
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

    public void ordenarLista(List<Timings> minhaLista) {
        Collections.sort(minhaLista, new Comparator() {
            public int compare(Object o1, Object o2) {
                Timings p1 = (Timings) o1;
                Timings p2 = (Timings) o2;
                String atividade1 = (p1 != null) ? p1.getName_location() : "";
                String atividade2 = (p2 != null) ? p2.getName_location() : "";
                return atividade1.compareTo(atividade2);
            }
        });
    }

    public void readLocations(List<Element> list) {
        try {
            int i = 0;
            for (Element element : list) {
                Locations locations = new Locations();
                locations.setId(element.getAttributeValue("ID"));
                locations.setParentID(element.getAttributeValue("ParentID"));
                locations.setName(element.getAttributeValue("Name"));
                listLocation.add(locations);
                treeLocation.put(element.getAttributeValue("ID"), element.getAttributeValue("Name"));
                if (i == 0) {
                    MasterElemento.setList(new ArrayList<Elemento>());
                    MasterElemento.setId(element.getAttributeValue("ID"));
                    MasterElemento.setIdParent(element.getAttributeValue("ParentID"));
                    MasterElemento.setName(element.getAttributeValue("Name"));
                    MasterElemento.setIndex(-1);
                    treeElenetos.put(element.getAttributeValue("ID"), MasterElemento);
                    i++;
                } else {
                    Elemento ele = new Elemento();
                    ele = new Elemento();
                    ele.setList(new ArrayList<Elemento>());
                    ele.setId(element.getAttributeValue("ID"));
                    ele.setIdParent(element.getAttributeValue("ParentID"));
                    ele.setName(element.getAttributeValue("Name"));

                    Elemento master = treeElenetos.get(ele.getIdParent());
                    if (master != null) {
                        ele.setIndex(master.getIndex() + 1);
                        if (maxNivel < (master.getIndex() + 1)) {
                            maxNivel = master.getIndex() + 1;
                        }
                        master.getList().add(ele);
                    }
                    treeElenetos.put(element.getAttributeValue("ID"), ele);
                }

            }
            
//           recussividade(MasterElemento.getList());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recussividade(List<Elemento> list) {
        for (Elemento elemento1 : list) {
//            System.out.println(elemento1.getId() + " - " + elemento1.getIdParent() + " - " + elemento1.getName());
            recussividade(elemento1.getList());
            
        }
    }

    public void readScheduleTask(List<Element> list) {
        try {
            listSchedueleTasks.clear();
            boolean impresso = false;
            SimpleDateFormat formatDDMM = new SimpleDateFormat("dd/MM");
            SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd");

            for (Element element : list) {
                ScheduleTasks scheduleTasks = new ScheduleTasks();
                scheduleTasks.setId(element.getAttributeValue("ID"));
                scheduleTasks.setName(element.getAttributeValue("Name"));
                List<Timings> listTimings = new Vector<Timings>();
                scheduleTasks.setListTimings(listTimings);
                listSchedueleTasks.add(scheduleTasks);
//                System.out.println(scheduleTasks.getName());
                if ("Jardinagem".equalsIgnoreCase(scheduleTasks.getName())) {
                    int a = 0;
                }


                int contador = 0;
                List<Element> childrenTimings = element.getChildren();
                Element ele = childrenTimings.get(1);
                List<Element> lis = ele.getChildren();
                for (Element timing : lis) {
                    Timings timings = new Timings();
                    timings.setNameTasks(scheduleTasks.getName());
                    listTimings.add(timings);
                    String locId = timing.getAttributeValue("LocationID");
                    if (locId.equalsIgnoreCase("JDqvVGtnkWiQSmBD")) {
                        //System.out.println(scheduleTasks.getName());
                        int a = 0;
                    }
                    Elemento elemento = treeElenetos.get(timing.getAttributeValue("LocationID"));
                    if (elemento != null) {
                        elemento.setTimings(timings);
                    }
                    double percent = Double.parseDouble(timing.getAttributeValue("CompletionRate"));
                    
                    timings.setLocationID(timing.getAttributeValue("LocationID"));
                    timings.setName_location(treeLocation.get(timing.getAttributeValue("LocationID")));
                    List<Element> ll = timing.getChildren();
                    int i = 0;
                    for (Element element1 : ll) {
                        String inicio = "";
                        String fim = "";
                        contador++;
                        String begin = element1.getAttributeValue("Begin");
                        if (begin != null) {
                            begin = begin.replace("-", "/");
                        }
                        if (dataValida(begin)) {
                            begin = begin.substring(0, 10);
                            inicio = begin;
                            begin = formatDDMM.format(format.parse(begin));
                        }
                        String end = element1.getAttributeValue("End");
                        if (end != null) {
                            end = end.replace("-", "/");
                        }
                        if (dataValida(end)) {
                            end = end.substring(0, 10);
                            fim = end;
                            end = formatDDMM.format(format.parse(end));
                        }

                        String new_dateini = null;
                        if (inicio.trim().length() > 0) {
                            new_dateini = formatDateMDY(inicio);
                        }
                        String new_datefim = null;
                        if (fim.trim().length() > 0) {
                            new_datefim = formatDateMDY(fim);
                        }

                        if (element1.getName().equalsIgnoreCase("Planned")) {
                            timings.setIni_proj(begin);
                            timings.setFim_proj(end);
                            timings.setIni_projAll(new_dateini);
                            timings.setFim_projAll(new_datefim);
                        } else if (element1.getName().equalsIgnoreCase("Actual")) {
                            timings.setIni_realAll(new_dateini);
                            timings.setFim_realAll((percent > 0 & percent < 1) ? percent * 100+"%": new_datefim);
                            timings.setIni_real(begin);
                            timings.setFim_real((percent > 0 & percent < 1) ? percent * 100+"%": end);
                        } else {
                            timings.setIni_foreAll(new_dateini);
                            timings.setFim_foreAll(new_datefim);
                            timings.setIni_fore(begin);
                            timings.setFim_fore(end);
                        }
                        i++;
                    }
//                    System.out.println(scheduleTasks.getName() + " itens =" + listTimings.size());
                }
                //System.out.println(scheduleTasks.getName() + " lista =" + listTimings.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String formatDateMDY(String data) throws Exception {
        try {
            String new_date = "";
            if (data.trim().length() > 0) {
                SimpleDateFormat formatDMY = new SimpleDateFormat("dd/MM/yy");
                SimpleDateFormat formatYMD = new SimpleDateFormat("yyyy/MM/dd");
                Date date = formatYMD.parse(data);
                new_date = formatDMY.format(date);
            }
            return new_date;
        } catch (Exception e) {
            return data;
        }
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the arq_arquivoT
     */
    public Arq_arquivoT getArq_arquivoT() {
        return arq_arquivoT;
    }

    /**
     * @param arq_arquivoT the arq_arquivoT to set
     */
    public void setArq_arquivoT(Arq_arquivoT arq_arquivoT) {
        this.arq_arquivoT = arq_arquivoT;
    }
}

class Locations {

    private String id;
    private String name;
    private String parentID;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parentID
     */
    public String getParentID() {
        return parentID;
    }

    /**
     * @param parentID the parentID to set
     */
    public void setParentID(String parentID) {
        this.parentID = parentID;
    }
}

class Timings {

    private String LocationID;
    private String ini_proj;
    private String fim_proj;
    private String ini_real;
    private String fim_real;
    private String name_location;
    private String ini_projAll;
    private String fim_projAll;
    private String ini_realAll;
    private String fim_realAll;
    private String ini_foreAll;
    private String fim_foreAll;
    private String ini_fore;
    private String fim_fore;
    private String nameTasks;

    /**
     * @return the LocationID
     */
    public String getLocationID() {
        return LocationID;
    }

    /**
     * @param LocationID the LocationID to set
     */
    public void setLocationID(String LocationID) {
        this.LocationID = LocationID;
    }

    /**
     * @return the ini_proj
     */
    public String getIni_proj() {
        return ini_proj;
    }

    /**
     * @param ini_proj the ini_proj to set
     */
    public void setIni_proj(String ini_proj) {
        this.ini_proj = ini_proj;
    }

    /**
     * @return the fim_proj
     */
    public String getFim_proj() {
        return fim_proj;
    }

    /**
     * @param fim_proj the fim_proj to set
     */
    public void setFim_proj(String fim_proj) {
        this.fim_proj = fim_proj;
    }

    /**
     * @return the ini_real
     */
    public String getIni_real() {
        return ini_real;
    }

    /**
     * @param ini_real the ini_real to set
     */
    public void setIni_real(String ini_real) {
        this.ini_real = ini_real;
    }

    /**
     * @return the fim_real
     */
    public String getFim_real() {
        return fim_real;
    }

    /**
     * @param fim_real the fim_real to set
     */
    public void setFim_real(String fim_real) {
        this.fim_real = fim_real;
    }

    /**
     * @return the name_location
     */
    public String getName_location() {
        return name_location;
    }

    /**
     * @param name_location the name_location to set
     */
    public void setName_location(String name_location) {
        this.name_location = name_location;
    }

    /**
     * @return the ini_projAll
     */
    public String getIni_projAll() {
        return ini_projAll;
    }

    /**
     * @param ini_projAll the ini_projAll to set
     */
    public void setIni_projAll(String ini_projAll) {
        this.ini_projAll = ini_projAll;
    }

    /**
     * @return the fim_projAll
     */
    public String getFim_projAll() {
        return fim_projAll;
    }

    /**
     * @param fim_projAll the fim_projAll to set
     */
    public void setFim_projAll(String fim_projAll) {
        this.fim_projAll = fim_projAll;
    }

    /**
     * @return the ini_realAll
     */
    public String getIni_realAll() {
        return ini_realAll;
    }

    /**
     * @param ini_realAll the ini_realAll to set
     */
    public void setIni_realAll(String ini_realAll) {
        this.ini_realAll = ini_realAll;
    }

    /**
     * @return the fim_realAll
     */
    public String getFim_realAll() {
        return fim_realAll;
    }

    /**
     * @param fim_realAll the fim_realAll to set
     */
    public void setFim_realAll(String fim_realAll) {
        this.fim_realAll = fim_realAll;
    }

    /**
     * @return the nameTasks
     */
    public String getNameTasks() {
        return nameTasks;
    }

    /**
     * @param nameTasks the nameTasks to set
     */
    public void setNameTasks(String nameTasks) {
        this.nameTasks = nameTasks;
    }

    /**
     * @return the ini_fore
     */
    public String getIni_fore() {
        return ini_fore;
    }

    /**
     * @param ini_fore the ini_fore to set
     */
    public void setIni_fore(String ini_fore) {
        this.ini_fore = ini_fore;
    }

    /**
     * @return the fim_fore
     */
    public String getFim_fore() {
        return fim_fore;
    }

    /**
     * @param fim_fore the fim_fore to set
     */
    public void setFim_fore(String fim_fore) {
        this.fim_fore = fim_fore;
    }

    /**
     * @return the ini_foreAll
     */
    public String getIni_foreAll() {
        return ini_foreAll;
    }

    /**
     * @param ini_foreAll the ini_foreAll to set
     */
    public void setIni_foreAll(String ini_foreAll) {
        this.ini_foreAll = ini_foreAll;
    }

    /**
     * @return the fim_foreAll
     */
    public String getFim_foreAll() {
        return fim_foreAll;
    }

    /**
     * @param fim_foreAll the fim_foreAll to set
     */
    public void setFim_foreAll(String fim_foreAll) {
        this.fim_foreAll = fim_foreAll;
    }
}

class ScheduleTasks {

    private String id;
    private String id_parent;
    private String name;
    private List<Timings> listTimings = new Vector();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the id_parent
     */
    public String getId_parent() {
        return id_parent;
    }

    /**
     * @param id_parent the id_parent to set
     */
    public void setId_parent(String id_parent) {
        this.id_parent = id_parent;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the listTimings
     */
    public List<Timings> getListTimings() {
        return listTimings;
    }

    /**
     * @param listTimings the listTimings to set
     */
    public void setListTimings(List<Timings> listTimings) {
        this.listTimings = listTimings;
    }
}

class Elemento {

    private String id;
    private String idParent;
    private String name;
    private int index;
    private List<Elemento> list;
    private Timings timings;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the idParent
     */
    public String getIdParent() {
        return idParent;
    }

    /**
     * @param idParent the idParent to set
     */
    public void setIdParent(String idParent) {
        this.idParent = idParent;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the list
     */
    public List<Elemento> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Elemento> list) {
        this.list = list;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the timings
     */
    public Timings getTimings() {
        return timings;
    }

    /**
     * @param timings the timings to set
     */
    public void setTimings(Timings timings) {
        this.timings = timings;
    }
}
