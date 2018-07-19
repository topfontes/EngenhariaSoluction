<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ume_unidade_medidaJB" class="br.com.easynet.gwt.easyportal.jb.Ume_unidade_medidaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="*"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="page" value="${pageContext}"/>                                         
${ume_unidade_medidaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ume_unidade_medidaJB.list}" var="item">
     ,{	"ume_nr_id":"${item.ume_nr_id}"
 ,	"ume_tx_nome":"${item.ume_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
