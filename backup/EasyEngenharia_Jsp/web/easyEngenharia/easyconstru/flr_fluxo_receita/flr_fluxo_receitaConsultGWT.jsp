<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="flr_fluxo_receitaJB" class="br.com.easynet.gwt.easyportal.jb.Flr_fluxo_receitaConsultJB" scope="request"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="*"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="page" value="${pageContext}"/>                                         
${flr_fluxo_receitaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${flr_fluxo_receitaJB.list}" var="item">
     ,{	"flr_nr_id":"${item.flr_nr_id}"
 ,	"flr_nr_mes":"${item.flr_nr_mes}"
 ,	"flr_nr_ano":"${item.flr_nr_ano}"
 ,	"flr_nr_original":"${item.flr_nr_original}"
 ,	"flr_nr_atual":"${item.flr_nr_atual}"
 ,	"flr_tx_key":"${item.flr_tx_key}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
  }
</c:forEach>
]}                                                                                
   
