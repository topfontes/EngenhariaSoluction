<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_conta_pagar_alteradaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_conta_pagar_alteradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="*"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="page" value="${pageContext}"/>                                         
${vw_conta_pagar_alteradaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_conta_pagar_alteradaJB.list}" var="item">
     ,{	"ctp_nr_id":"${item.ctp_nr_id}"
 ,	"ctp_nr_mes":"${item.ctp_nr_mes}"
 ,	"ctp_nr_ano":"${item.ctp_nr_ano}"
 ,	"ctp_nr_documento":"${item.ctp_nr_documento}"
 ,	"ctp_tx_obs":"${item.ctp_tx_obs}"
 ,	"ctp_tx_fornecedor":"${item.ctp_tx_fornecedor}"
 ,	"ctp_nr_valor":"${item.ctp_nr_valor}"
 ,	"ctpm_nr_mes":"${item.ctpm_nr_mes}"
 ,	"ctpm_nr_ano":"${item.ctpm_nr_ano}"
 ,	"ctpm_tx_tipo":"${item.ctpm_tx_tipo}"
  }
</c:forEach>
]}                                                                                
   
