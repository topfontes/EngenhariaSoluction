<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeConsultJB" scope="request"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="*"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>                                         
${uni_unidadeJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${uni_unidadeJB.list}" var="item">
     ,{	"uni_nr_id":"${item.uni_nr_id}"
 ,	"uni_tx_nome":"${item.uni_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
