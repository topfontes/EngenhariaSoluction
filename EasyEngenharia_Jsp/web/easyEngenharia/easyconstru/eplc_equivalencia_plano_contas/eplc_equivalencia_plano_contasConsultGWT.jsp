<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasConsultJB" scope="request"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>                                         
${eplc_equivalencia_plano_contasJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${eplc_equivalencia_plano_contasJB.list}" var="item">
     ,{	"eplc_nr_id":"${item.eplc_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
  }
</c:forEach>
]}                                                                                
   
