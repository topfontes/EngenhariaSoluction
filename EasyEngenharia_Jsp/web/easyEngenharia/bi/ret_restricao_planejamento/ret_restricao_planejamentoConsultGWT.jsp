<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ret_restricao_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Ret_restricao_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="page" value="${pageContext}"/>                                         
${ret_restricao_planejamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ret_restricao_planejamentoJB.list}" var="item">
     ,{	"ret_nr_id":"${item.ret_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"ret_nr_mes":"${item.ret_nr_mes}"
 ,	"ret_nr_ano":"${item.ret_nr_ano}"
 ,	"ret_tx_restricao":"${item.ret_tx_restricao}"
 ,	"ret_nr_ocorrencia":"${item.ret_nr_ocorrencia}"
 ,	"ret_nr_deficet":"${item.ret_nr_deficet}"
  }
</c:forEach>
]}                                                                                
   
