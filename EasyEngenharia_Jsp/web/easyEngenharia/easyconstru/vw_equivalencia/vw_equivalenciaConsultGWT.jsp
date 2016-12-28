<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equivalenciaConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_equivalenciaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_equivalenciaJB.list}" var="item">
     ,{	"eplc_nr_id":"${item.eplc_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"plc_tx_nome":"${item.plc_tx_nome}"
 ,	"plco_tx_tipo":"${item.plco_tx_tipo}"
 ,	"plco_tx_cod_externo":"${item.plco_tx_cod_externo}"
 ,	"plco_tx_unidade":"${item.plco_tx_unidade}"
  }
</c:forEach>
]}                                                                                
   
