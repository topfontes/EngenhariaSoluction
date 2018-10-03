<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctpm_conta_pagar_modificadaJB" class="br.com.easynet.gwt.easyportal.jb.Ctpm_conta_pagar_modificadaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="*"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="page" value="${pageContext}"/>                                         
${ctpm_conta_pagar_modificadaJB.execute}                                         
{"resultado":
{"msg":"${ctpm_conta_pagar_modificadaJB.msg}",
     "ctpm_conta_pagar_modificada":{	"ctpm_nr_id":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_nr_id}"
 ,	"obr_nr_id":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.obr_nr_id}"
 ,	"ctp_nr_id":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctp_nr_id}"
 ,	"ctpm_nr_mes":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_nr_mes}"
 ,	"ctpm_nr_ano":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_nr_ano}"
 ,	"ctpm_tx_tipo":"${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_tx_tipo}"
  }
    }
     
}                                                                                
   
