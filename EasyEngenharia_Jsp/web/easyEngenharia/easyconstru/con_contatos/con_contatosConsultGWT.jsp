<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="con_contatosJB" class="br.com.easynet.gwt.easyportal.jb.Con_contatosConsultJB" scope="request"/>                                         
<jsp:setProperty name="con_contatosJB" property="*"/>                                         
<jsp:setProperty name="con_contatosJB" property="page" value="${pageContext}"/>                                         
${con_contatosJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${con_contatosJB.list}" var="item">
     ,{	"con_nr_id":"${item.con_nr_id}"
 ,	"cli_nr_id":"${item.cli_nr_id}"
 ,	"con_tx_nome":"${item.con_tx_nome}"
 ,	"set_nr_id":"${item.set_nr_id}"
 ,	"con_tx_cargo_exercicio":"${item.con_tx_cargo_exercicio}"
 ,	"con_tx_telefone":"${item.con_tx_telefone}"
 ,	"con_tx_telefone2":"${item.con_tx_telefone2}"
 ,	"con_tx_email":"${item.con_tx_email}"
  }
</c:forEach>
]}                                                                                
   
