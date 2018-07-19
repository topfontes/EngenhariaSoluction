<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inc_informacoes_custoJB" class="br.com.easynet.gwt.easyportal.jb.Inc_informacoes_custoConsultJB" scope="request"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="*"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="page" value="${pageContext}"/>                                         
${inc_informacoes_custoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${inc_informacoes_custoJB.list}" var="item">
     ,{	"inc_nr_id":"${item.inc_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"inc_nr_mes":"${item.inc_nr_mes}"
 ,	"inc_nr_ano":"${item.inc_nr_ano}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"inc_tx_custo_acumulado":"${item.inc_tx_custo_acumulado}"
 ,	"inc_nr_custo_periodo":"${item.inc_nr_custo_periodo}"
 ,	"inc_tx_calsas":"${item.inc_tx_calsas}"
 ,	"inc_tx_problemas":"${item.inc_tx_problemas}"
 ,	"inc_tx_acoes":"${item.inc_tx_acoes}"
 ,	"inc_tx_responsavel":"${item.inc_tx_responsavel}"
 ,	"inc_dt_prazo":"<fmt:formatDate value="${item.inc_dt_prazo}" pattern="dd/MM/yyyy"/>"
  }
</c:forEach>
]}                                                                                
   
