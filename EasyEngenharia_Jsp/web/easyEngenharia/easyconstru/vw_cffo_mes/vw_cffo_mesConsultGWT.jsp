<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_cffo_mesJB" class="br.com.easynet.gwt.easyportal.jb.Vw_cffo_mesConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="*"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="page" value="${pageContext}"/>                                         
${vw_cffo_mesJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_cffo_mesJB.list}" var="item">
     ,{	"obr_nr_id":"${item.obr_nr_id}"
 ,	"cffo_nr_mes":"${item.cffo_nr_mes}"
 ,	"cffo_nr_ano":"${item.cffo_nr_ano}"
 ,	"total":"${item.total}"
  }
</c:forEach>
]}                                                                                
   
