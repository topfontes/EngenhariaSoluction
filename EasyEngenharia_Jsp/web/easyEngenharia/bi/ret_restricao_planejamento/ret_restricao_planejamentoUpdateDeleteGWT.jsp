<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ret_restricao_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Ret_restricao_planejamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="page" value="${pageContext}"/>                                         
${ret_restricao_planejamentoJB.execute}                                         
{"resultado":
{"msg":"${ret_restricao_planejamentoJB.msg}",
     "ret_restricao_planejamento":{	"ret_nr_id":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_id}"
 ,	"obr_nr_id":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.obr_nr_id}"
 ,	"ret_nr_mes":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_mes}"
 ,	"ret_nr_ano":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_ano}"
 ,	"ret_tx_restricao":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_tx_restricao}"
 ,	"ret_nr_ocorrencia":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_ocorrencia}"
 ,	"ret_nr_deficet":"${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_deficet}"
  }
    }
     
}                                                                                
   
