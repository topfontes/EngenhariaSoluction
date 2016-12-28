<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_comprometimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${vw_comprometimentoJB.execute}                                         
{"resultado":
{"msg":"${vw_comprometimentoJB.msg}",
     "vw_comprometimento":{	"obr_nr_id":"${vw_comprometimentoJB.vw_comprometimentoT.obr_nr_id}"
 ,	"com_nr_mes":"${vw_comprometimentoJB.vw_comprometimentoT.com_nr_mes}"
 ,	"com_nr_ano":"${vw_comprometimentoJB.vw_comprometimentoT.com_nr_ano}"
 ,	"plc_nr_id":"${vw_comprometimentoJB.vw_comprometimentoT.plc_nr_id}"
 ,	"plc_tx_nome":"${vw_comprometimentoJB.vw_comprometimentoT.plc_tx_nome}"
 ,	"com_nr_valor":"${vw_comprometimentoJB.vw_comprometimentoT.com_nr_valor}"
  }
    }
     
}                                                                                
   
