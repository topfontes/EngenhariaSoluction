<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.easyportal.jb.For_fornecedorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
{"resultado":
{"msg":"${for_fornecedorJB.msg}",
     "for_fornecedor":{	"for_nr_id":"${for_fornecedorJB.for_fornecedorT.for_nr_id}"
 ,	"for_tx_nome":"${for_fornecedorJB.for_fornecedorT.for_tx_nome}"
 ,	"for_tx_cnpj":"${for_fornecedorJB.for_fornecedorT.for_tx_cnpj}"
 ,	"for_tx_endereco":"${for_fornecedorJB.for_fornecedorT.for_tx_endereco}"
 ,	"for_tx_bairro":"${for_fornecedorJB.for_fornecedorT.for_tx_bairro}"
 ,	"for_tx_cidade":"${for_fornecedorJB.for_fornecedorT.for_tx_cidade}"
 ,	"for_tx_uf":"${for_fornecedorJB.for_fornecedorT.for_tx_uf}"
 ,	"for_tx_contato":"${for_fornecedorJB.for_fornecedorT.for_tx_contato}"
 ,	"for_tx_telefone":"${for_fornecedorJB.for_fornecedorT.for_tx_telefone}"
 ,	"for_tx_email":"${for_fornecedorJB.for_fornecedorT.for_tx_email}"
  }
    }
     
}                                                                                
   
