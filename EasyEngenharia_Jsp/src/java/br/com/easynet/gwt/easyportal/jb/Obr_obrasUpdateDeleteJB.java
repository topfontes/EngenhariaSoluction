package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Obr_obrasUpdateDeleteJB extends SystemBase {

  // Atributos e propriedades
    private Obr_obrasT obr_obrasT = new Obr_obrasT();

  public void setObr_obrasT(Obr_obrasT obr_obrasT) {
    this.obr_obrasT = obr_obrasT;
  }

  public Obr_obrasT getObr_obrasT() {	
    return obr_obrasT;
  }

	
  private List<Obr_obrasT> list;

  public List<Obr_obrasT> getList() {
    return list;
  }
  
  public void setList(List<Obr_obrasT> list) {
    this.list = list;
  }

  public void pageLoad() throws Exception {
	super.pageLoad();
        //consultEmp_empreendimento();

  }

  public void clear() throws Exception {
    
      obr_obrasT = new Obr_obrasT();	
  } 

    public void delete() throws Exception {
        DAOFactory factory = null;
        try {
            Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
            factory = obr_obrasDAO.getDAOFactory();
            factory.beginTransaction();
            Uno_unidade_obraDAO udao = getUno_unidade_obraDAO();
            udao.deleteAllObra(obr_obrasT.getObr_nr_id());
            obr_obrasDAO.delete(obr_obrasT);
            factory.commitTransaction();
            setMsg("Exclusão efetuada com sucesso!");
            obr_obrasT = new Obr_obrasT();
            consult();
        } catch (Exception e) {
            factory.rollbackTransaction();
            e.printStackTrace();
            setMsg("Falha ao realizar exclusão!");
        } finally {
            close();
        }
    }
  public boolean exist() throws Exception {
   try {
      Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
      List<Obr_obrasT> listTemp  = obr_obrasDAO.getByPK( obr_obrasT);	 

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
        Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
        obr_obrasDAO.update(obr_obrasT);	 
        setMsg("Alteraçao efetuada com sucesso!");
      } else {  
	setMsg("Error: Registro inexistente!");
      } 
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar alteração!");	
    } finally {
	close();
    }
  }   

// Method de lookup
// 
	private List<Emp_empreendimentoT> listemp_empreendimento;
	public List<Emp_empreendimentoT> getListemp_empreendimento() {
		return listemp_empreendimento;
	}

	 public void setListemp_empreendimento(List<Emp_empreendimentoT> list) {
		this.listemp_empreendimento=list;
	}
	public void consultEmp_empreendimento() throws Exception {
		try {
			Emp_empreendimentoDAO emp_empreendimentoDAO = getEmp_empreendimentoDAO();
			listemp_empreendimento=emp_empreendimentoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}



  //Method Download Image � montando se houver algum campo do tipo binario
  //|DOWNLOADIMAGE| 


  public void findbyid() throws Exception {
    try {
      Obr_obrasDAO obr_obrasDAO = getObr_obrasDAO();
      List<Obr_obrasT> listTemp  = obr_obrasDAO.getByPK( obr_obrasT);	 

      obr_obrasT= listTemp.size()>0?listTemp.get(0):new Obr_obrasT();
      
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar consulta!");	
    } finally {
	close();
    }
  }  

  /**
   * Volta para a página de consulta
   */	
  public void consult() throws Exception {
	// TODO Consult
	try {
	  String page = "obr_obrasConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 
  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "obr_obrasConsult.jsp";// defina aqui a página que deve ser chamada  
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
