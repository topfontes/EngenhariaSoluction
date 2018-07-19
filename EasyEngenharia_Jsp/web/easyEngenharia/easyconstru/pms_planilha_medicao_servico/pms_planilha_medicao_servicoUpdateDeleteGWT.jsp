<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pms_planilha_medicao_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Pms_planilha_medicao_servicoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="*"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="page" value="${pageContext}"/>                                         
${pms_planilha_medicao_servicoJB.execute}                                         
{"resultado":
{"msg":"${pms_planilha_medicao_servicoJB.msg}",
     "pms_planilha_medicao_servico":{	"pms_nr_id":"${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_id}"
 ,	"obr_nr_id":"${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.obr_nr_id}"
 ,	"pms_nr_mes":"${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_mes}"
 ,	"plco_nr_id":"${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.plco_nr_id}"
 ,	"pms_nr_quantidade_servico":"${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_quantidade_servico}"
  }
    }
     
}                                                                                
   
