package br.com.easynet.gwt.easyportal.jb;

import br.com.easynet.easyportal.jb.INotSecurity;
import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.easynet.jb.EasyDownloadJB;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Fto_fotosUpdateDeleteJB extends SystemBase implements INotSecurity{

  // Atributos e propriedades
 private Fto_fotosT fto_fotosT = new Fto_fotosT();
 private String fileName;

  public void setFto_fotosT(Fto_fotosT fto_fotosT) {
    this.fto_fotosT = fto_fotosT;
  }

  public Fto_fotosT getFto_fotosT() {	
    return fto_fotosT;
  }

  private int width;
  private int height;
	
  private List<Fto_fotosT> list;

  public List<Fto_fotosT> getList() {
    return list;
  }
  
  public void setList(List<Fto_fotosT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();

	//
  }

  public void insert_sessao(){
      getSession().setAttribute("foto", fto_fotosT);
  }
  public void clear() throws Exception {
    
      fto_fotosT = new Fto_fotosT();	
  } 

  public void delete() throws Exception {
    try {
      if (exist()) {
        Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
        fto_fotosDAO.delete(fto_fotosT);	 
        setMsg("Exclus�o efetuada com sucesso!");
        clear();
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar exclus�o!");	
    } finally {
	close();
    }
  } 
  public boolean exist() throws Exception {
   try {
      Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
      List<Fto_fotosT> listTemp  = fto_fotosDAO.getByPK( fto_fotosT);	 

      return listTemp.size()>0;      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
    return false;
	
  }

  public void update() throws Exception {
    try {
      if (exist()) {
        Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
        fto_fotosDAO.update(fto_fotosT);	 
        setMsg("Altera��o efetuada com sucesso!");	
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar altera��o!");	
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
    
    public void downloadImageThumb() throws Exception {
        try {
            fto_fotosT = (Fto_fotosT) getSession().getAttribute("foto");
            BufferedImage bi = bytesToImage(fto_fotosT.getFto_bt_foto());
            bi = createScaledImage(bi, width, height);
            byte[] image = imageToBytes(bi);
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, fileName);
            getRequest().setAttribute(EasyDownloadJB.DATA, image);
            //getPage().forward("../../../portal/easydownload.jsp");
            getPage().forward("/portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }


  //Method Download Image � montando se houver algum campo do tipo bin�rio
  //
  /**
   * Download de Imagem caso existe sen�o pode remover
   */
  public void downloadImage() throws Exception {

        try {
            findbyid();
            getRequest().setAttribute(EasyDownloadJB.CONTENT_TYPE, "image/jpg");
            getRequest().setAttribute(EasyDownloadJB.FILE_NAME, "fto_fotosT.jpg");
            getRequest().setAttribute(EasyDownloadJB.DATA, fto_fotosT.getFto_bt_foto());
            //getPage().forward("easydownload.jsp");
            getPage().forward("/portal/easydownload.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            setMsg("Falha ao realizar consulta!");
        } finally {
            close();
        }

    }
 


  public void findbyid() throws Exception {
    try {
      Fto_fotosDAO fto_fotosDAO = getFto_fotosDAO();
      List<Fto_fotosT> listTemp  = fto_fotosDAO.getByPK( fto_fotosT);	 

      fto_fotosT= listTemp.size()>0?listTemp.get(0):new Fto_fotosT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a p�gina de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "fto_fotosConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "fto_fotosConsult.jsp";// defina aqui a p�gina que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
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

}
