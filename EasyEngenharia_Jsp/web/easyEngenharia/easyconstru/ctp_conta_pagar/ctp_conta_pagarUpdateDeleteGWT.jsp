<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.Ctp_conta_pagarUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
{"resultado":
{"msg":"${ctp_conta_pagarJB.msg}",
     "ctp_conta_pagar":{	"ctp_nr_id":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_id}"
 ,	"ctp_tx_fornecedor":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_fornecedor}"
 ,	"ctp_nr_mes":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_mes}"
 ,	"plc_nr_id":"${ctp_conta_pagarJB.ctp_conta_pagarT.plc_nr_id}"
 ,	"ctp_nr_valor":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_valor}"
 ,	"ctp_nr_documento":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_documento}"
 ,	"ctp_tx_status":"${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_status}"
 ,	"obr_nr_id":"${ctp_conta_pagarJB.ctp_conta_pagarT.obr_nr_id}"
  }
    }
     
}                                                                                
   
