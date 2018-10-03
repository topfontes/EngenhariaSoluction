<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqi_equivalencia_insumoJB" class="br.com.easynet.gwt.easyportal.jb.Eqi_equivalencia_insumoConsultJB" scope="request"/>                                         
<jsp:setProperty name="eqi_equivalencia_insumoJB" property="*"/>                                         
<jsp:setProperty name="eqi_equivalencia_insumoJB" property="page" value="${pageContext}"/>                                         
${eqi_equivalencia_insumoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${eqi_equivalencia_insumoJB.list}" var="item">
     ,{	"ina_nr_id":"${item.ina_nr_id}"
 ,	"inn_nr_id":"${item.inn_nr_id}"
  }
</c:forEach>
]}                                                                                
   
