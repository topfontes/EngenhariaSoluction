<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plp_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plp_planilha_permutaConsultJB" scope="request"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plp_planilha_permutaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${plp_planilha_permutaJB.list}" var="item">
     ,{	"plp_nr_id":"${item.plp_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plp_nr_mes_ref":"${item.plp_nr_mes_ref}"
 ,	"plp_nr_ano_ref":"${item.plp_nr_ano_ref}"
 ,	"plp_nr_mes":"${item.plp_nr_mes}"
 ,	"plp_nr_ano":"${item.plp_nr_ano}"
 ,	"plp_nr_previsto":"${item.plp_nr_previsto}"
 ,	"plp_nr_realizado":"${item.plp_nr_realizado}"
  }
</c:forEach>
]}                                                                                
   
