<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaConsultJB" scope="request"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="*"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>                                         
${pes_pessoaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${pes_pessoaJB.list}" var="item">
     ,{	"pes_nr_id":"${item.pes_nr_id}"
 ,	"pes_tx_nome":"${item.pes_tx_nome}"
 ,	"pes_tx_fone":"${item.pes_tx_fone}"
  }
</c:forEach>
]}                                                                                
   
