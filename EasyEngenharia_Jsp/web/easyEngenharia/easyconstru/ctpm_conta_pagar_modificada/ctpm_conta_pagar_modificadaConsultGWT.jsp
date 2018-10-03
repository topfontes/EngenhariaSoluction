<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctpm_conta_pagar_modificadaJB" class="br.com.easynet.gwt.easyportal.jb.Ctpm_conta_pagar_modificadaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="*"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="page" value="${pageContext}"/>                                         
${ctpm_conta_pagar_modificadaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ctpm_conta_pagar_modificadaJB.list}" var="item">
     ,{	"ctpm_nr_id":"${item.ctpm_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"ctp_nr_id":"${item.ctp_nr_id}"
 ,	"ctpm_nr_mes":"${item.ctpm_nr_mes}"
 ,	"ctpm_nr_ano":"${item.ctpm_nr_ano}"
 ,	"ctpm_tx_tipo":"${item.ctpm_tx_tipo}"
  }
</c:forEach>
]}                                                                                
   
