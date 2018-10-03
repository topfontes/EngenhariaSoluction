package br.com.easynet.gwt.easyportal.jb;

import java.util.List;
import br.com.easynet.jb.BeanBase;
import br.com.jdragon.dao.DAOFactory;
import br.com.easynet.gwt.easyportal.dao.*;
import br.com.easynet.gwt.easyportal.transfer.*;



/** Classe Criada Automaticamente pelo "EasyNet Generate JDragon" */

public class Infe_item_nota_entradaInsertJB extends SystemBase {

  // Atributos e propriedades
    private Infe_item_nota_entradaT infe_item_nota_entradaT = new Infe_item_nota_entradaT();

  public void setInfe_item_nota_entradaT(Infe_item_nota_entradaT infe_item_nota_entradaT) {
    this.infe_item_nota_entradaT = infe_item_nota_entradaT;
  }

  public Infe_item_nota_entradaT getInfe_item_nota_entradaT() {	
    return infe_item_nota_entradaT;
  }

	
  public void pageLoad() throws Exception {
	super.pageLoad();
	//
		consultNfe_nota_fiscal_entrada();

		consultPro_produto();

  }

  // Metodos de Eventos
  public void insert() throws Exception {
    
    try {
      Infe_item_nota_entradaDAO infe_item_nota_entradaDAO =  getInfe_item_nota_entradaDAO();
      infe_item_nota_entradaDAO.insert(infe_item_nota_entradaT);	 
      setMsg("Cadastro efetuado com sucesso!");
      clear();
    } catch (Exception e) {
      e.printStackTrace();
      setMsg("Falha ao realizar cadastro!");	
    } finally {
	close();
    }
  } 

// Method de lookup
// 
	private List<Nfe_nota_fiscal_entradaT> listnfe_nota_fiscal_entrada;
	public List<Nfe_nota_fiscal_entradaT> getListnfe_nota_fiscal_entrada() {
		return listnfe_nota_fiscal_entrada;
	}

	 public void setListnfe_nota_fiscal_entrada(List<Nfe_nota_fiscal_entradaT> list) {
		this.listnfe_nota_fiscal_entrada=list;
	}
	public void consultNfe_nota_fiscal_entrada() throws Exception {
		try {
			Nfe_nota_fiscal_entradaDAO nfe_nota_fiscal_entradaDAO = getNfe_nota_fiscal_entradaDAO();
			listnfe_nota_fiscal_entrada=nfe_nota_fiscal_entradaDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	private List<Pro_produtoT> listpro_produto;
	public List<Pro_produtoT> getListpro_produto() {
		return listpro_produto;
	}

	 public void setListpro_produto(List<Pro_produtoT> list) {
		this.listpro_produto=list;
	}
	public void consultPro_produto() throws Exception {
		try {
			Pro_produtoDAO pro_produtoDAO = getPro_produtoDAO();
			listpro_produto=pro_produtoDAO.getAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}


  
  public void clear() throws Exception {
    
      infe_item_nota_entradaT = new Infe_item_nota_entradaT();	
  } 


  public void cancel() throws Exception {
	// TODO Cancel
	try {
	  String page = "infe_item_nota_entradaConsult.jsp";// defina aqui a pagina que deve ser chamada
	  getResponse().sendRedirect(page); 
	} catch (Exception e){} 
  } 

}
