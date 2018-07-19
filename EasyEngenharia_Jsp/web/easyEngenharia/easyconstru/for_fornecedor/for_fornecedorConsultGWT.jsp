<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.easyportal.jb.For_fornecedorConsultJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
{"resultado":[
{"registro":"${for_fornecedorJB.msg}"}
<c:forEach items="${for_fornecedorJB.list}" var="item">
     ,{	"for_nr_id":"${item.for_nr_id}"
 ,	"for_tx_nome":"${item.for_tx_nome}"
 ,	"for_tx_cnpj":"${item.for_tx_cnpj}"
 ,	"for_tx_endereco":"${item.for_tx_endereco}"
 ,	"for_tx_bairro":"${item.for_tx_bairro}"
 ,	"for_tx_cidade":"${item.for_tx_cidade}"
 ,	"for_tx_uf":"${item.for_tx_uf}"
 ,	"for_tx_contato":"${item.for_tx_contato}"
 ,	"for_tx_telefone":"${item.for_tx_telefone}"
 ,	"for_tx_email":"${item.for_tx_email}"
  }
</c:forEach>
]}                                                                                
   
