<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.easyportal.jb.Cli_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cli_clienteJB" property="*"/>                                         
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>                                         
${cli_clienteJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cli_clienteJB.list}" var="item">
     ,{	"cli_nr_id":"${item.cli_nr_id}"
 ,	"cli_tx_nome":"${item.cli_tx_nome}"
 ,	"cli_tx_tipo_pessoa":"${item.cli_tx_tipo_pessoa}"
 ,	"cli_tx_cnpj_cpf":"${item.cli_tx_cnpj_cpf}"
 ,	"cli_tx_endereco":"${item.cli_tx_endereco}"
 ,	"cli_tx_bairro":"${item.cli_tx_bairro}"
 ,	"cli_tx_cidade":"${item.cli_tx_cidade}"
 ,	"cli_tx_telefone":"${item.cli_tx_telefone}"
 ,	"cli_tx_fax":"${item.cli_tx_fax}"
 ,	"cli_tx_telefone2":"${item.cli_tx_telefone2}"
 ,	"cli_by_logomarca":"IMAGEM"
 ,	"cli_tx_email":"${item.cli_tx_email}"
 ,	"cli_tx_inscricao_estatual":"${item.cli_tx_inscricao_estatual}"
 ,	"cli_tx_contato":"${item.cli_tx_contato}"
 ,	"cli_tx_celular":"${item.cli_tx_celular}"
 ,	"cli_tx_letra_orcamento_externo":"${item.cli_tx_letra_orcamento_externo}"
  }
</c:forEach>
]}                                                                                
   
