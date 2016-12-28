<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="evl_evolucao_lucroJB" class="br.com.easynet.gwt.easyportal.jb.Evl_evolucao_lucroConsultJB" scope="request"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="*"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="page" value="${pageContext}"/>                                         
${evl_evolucao_lucroJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${evl_evolucao_lucroJB.list}" var="item">
     ,{	"evl_nr_id":"${item.evl_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"evl_nr_mes":"${item.evl_nr_mes}"
 ,	"evl_nr_ano":"${item.evl_nr_ano}"
 ,	"evl_nr_valor":"${item.evl_nr_valor}"
 ,	"evl_nr_mes_ref":"${item.evl_nr_mes_ref}"
 ,	"evl_nr_ano_ref":"${item.evl_nr_ano_ref}"
 ,	"evl_tx_tipo":"${item.evl_tx_tipo}"
  }
</c:forEach>
]}                                                                                
   
