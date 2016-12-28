package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import br.com.easynet.jb.EasyDownloadJB;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fto_fotosConsultJB extends SystemBase {

  // Atributos e propriedades
    private Fto_fotosT fto_fotosT = new Fto_fotosT();

  public void setFto_fotosT(Fto_fotosT fto_fotosT) {
    this.fto_fotosT = fto_fotosT;
  }

  public Fto_fotosT getFto_fotosT() {	
    return fto_fotosT;
  }
  
  private int width;
  private int height;
  private String fileName;


	
  private List<Fto_fotosT> list;

  public List<Fto_fotosT> getList() {
    return list;
  }
  
  public void setList(List<Fto_fotosT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
  }

  public void consult() throws Exception {
    try {
      Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
      list = fto_fotosDAO.getByObraMesAno(fto_fotosT);
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  public void delete() throws Exception {
    try {
      Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
      fto_fotosDAO.delete(fto_fotosT);	 
      setMsg("Exclusão efetuada com sucesso!");
      fto_fotosT = new Fto_fotosT();
      consult();	  	
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclusão!");	
    } finally {
	close();
    }
  }  

    public byte[] imageToBytes(BufferedImage bi) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "JPG", baos);
        return baos.toByteArray();
    }
    public BufferedImage bytesToImage(byte[] img) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(img);
        BufferedImage bi = ImageIO.read(bais);
        return bi;
    }

    public BufferedImage createScaledImage(BufferedImage image, int width, int heigth) {
        int cachedWidth = width;
        int cachedHeight = heigth;
        BufferedImage scaledImage;
        scaledImage = new BufferedImage(cachedWidth, cachedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = scaledImage.createGraphics();
        g.drawImage(image, 0, 0, cachedWidth, cachedHeight, null);
        return scaledImage;
    }

    public void downloadImage() throws Exception {
        try {
            Fto_fotosDAO fdao = getFto_fotosDAO();
            fto_fotosT = fdao.getByFto_nr_id(fto_fotosT).get(0);
            BufferedImage bi = bytesToImage(fto_fotosT.getFto_bt_foto());
            bi = createScaledImage(bi, width, height);
            byte[] image = imageToBytes(bi);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, fto_fotosT.getFto_tx_nome());
            getRequest().setAttribute(EasyDownloadJB.DATA, image);
            getPage().forward("../../../portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
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

}
