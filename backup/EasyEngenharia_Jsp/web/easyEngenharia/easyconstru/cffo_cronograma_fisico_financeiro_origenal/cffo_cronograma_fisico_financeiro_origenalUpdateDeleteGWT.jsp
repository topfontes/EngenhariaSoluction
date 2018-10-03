<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cffo_cronograma_fisico_financeiro_origenalJB" class="br.com.easynet.gwt.easyportal.jb.Cffo_cronograma_fisico_financeiro_origenalUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="*"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="page" value="${pageContext}"/>                                         
${cffo_cronograma_fisico_financeiro_origenalJB.execute}                                         
{"resultado":
{"msg":"${cffo_cronograma_fisico_financeiro_origenalJB.msg}",
     "cffo_cronograma_fisico_financeiro_origenal":{	"cffo_nr_id":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id}"
 ,	"plco_nr_id":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id}"
 ,	"obr_nr_id":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id}"
 ,	"cffo_nr_peso":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso}"
 ,	"cffo_nr_mes":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes}"
 ,	"cffo_nr_ano":"${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano}"
  }
    }
     
}                                                                                
   
