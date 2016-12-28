<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_curva_abc_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abc_equivalenciaConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abc_equivalenciaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_curva_abc_equivalenciaJB.list}" var="item">
     ,{	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plc_tx_nome":"${item.plc_tx_nome}"
 ,	"total":"${item.total}"
  }
</c:forEach>
]}                                                                                
   
