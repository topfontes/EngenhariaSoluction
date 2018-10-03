<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plv_planilha_vendasJB" class="br.com.easynet.gwt.easyportal.jb.Plv_planilha_vendasConsultJB" scope="request"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="*"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="page" value="${pageContext}"/>                                         
${plv_planilha_vendasJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${plv_planilha_vendasJB.list}" var="item">
     ,{	"plv_nr_id":"${item.plv_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plv_nr_mes_ref":"${item.plv_nr_mes_ref}"
 ,	"plv_nr_ano_ref":"${item.plv_nr_ano_ref}"
 ,	"plv_nr_mes":"${item.plv_nr_mes}"
 ,	"plv_nr_ano":"${item.plv_nr_ano}"
 ,	"plv_nr_previsto":"${item.plv_nr_previsto}"
 ,	"plv_nr_realizado":"${item.plv_nr_realizado}"
  }
</c:forEach>
]}                                                                                
   
