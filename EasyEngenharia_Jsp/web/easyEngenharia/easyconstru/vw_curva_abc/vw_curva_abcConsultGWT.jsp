<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_curva_abcJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abcConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abcJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_curva_abcJB.list}" var="item">
     ,{	"obr_nr_id":"${item.obr_nr_id}"
 ,	"obr_tx_nome":"${item.obr_tx_nome}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"total":"${item.total}"
  }
</c:forEach>
]}                                                                                
   
