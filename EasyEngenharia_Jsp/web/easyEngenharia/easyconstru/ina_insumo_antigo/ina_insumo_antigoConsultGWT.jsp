<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ina_insumo_antigoJB" class="br.com.easynet.gwt.easyportal.jb.Ina_insumo_antigoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ina_insumo_antigoJB" property="*"/>                                         
<jsp:setProperty name="ina_insumo_antigoJB" property="page" value="${pageContext}"/>                                         
${ina_insumo_antigoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ina_insumo_antigoJB.list}" var="item">
     ,{	"ina_nr_id":"${item.ina_nr_id}"
 ,	"ina_tx_codigo":"${item.ina_tx_codigo}"
 ,	"ina_tx_descricao":"${item.ina_tx_descricao}"
 ,	"ina_tx_unidade":"${item.ina_tx_unidade}"
  }
</c:forEach>
]}                                                                                
   
