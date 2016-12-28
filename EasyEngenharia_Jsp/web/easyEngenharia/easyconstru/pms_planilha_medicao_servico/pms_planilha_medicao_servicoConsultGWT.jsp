<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pms_planilha_medicao_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Pms_planilha_medicao_servicoConsultJB" scope="request"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="*"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="page" value="${pageContext}"/>                                         
${pms_planilha_medicao_servicoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${pms_planilha_medicao_servicoJB.list}" var="item">
     ,{	"pms_nr_id":"${item.pms_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"pms_nr_mes":"${item.pms_nr_mes}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"ipo_nr_id":"${item.ipo_nr_id}"
 ,	"pms_nr_quantidade_servico":"${item.pms_nr_quantidade_servico}"
 ,	"pms_nr_percentual":"${item.pms_nr_percentual}"
  }
</c:forEach>
]}                                                                                
   
