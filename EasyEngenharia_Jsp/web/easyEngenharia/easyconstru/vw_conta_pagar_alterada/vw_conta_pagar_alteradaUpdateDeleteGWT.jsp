<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_conta_pagar_alteradaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_conta_pagar_alteradaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="*"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="page" value="${pageContext}"/>                                         
${vw_conta_pagar_alteradaJB.execute}                                         
{"resultado":
{"msg":"${vw_conta_pagar_alteradaJB.msg}",
     "vw_conta_pagar_alterada":{	"ctp_nr_id":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_id}"
 ,	"ctp_nr_mes":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_mes}"
 ,	"ctp_nr_ano":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_ano}"
 ,	"ctp_nr_documento":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_documento}"
 ,	"ctp_tx_obs":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_tx_obs}"
 ,	"ctp_tx_fornecedor":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_tx_fornecedor}"
 ,	"ctp_nr_valor":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_valor}"
 ,	"ctpm_nr_mes":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctpm_nr_mes}"
 ,	"ctpm_nr_ano":"${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctpm_nr_ano}"
  }
    }
     
}                                                                                
   
