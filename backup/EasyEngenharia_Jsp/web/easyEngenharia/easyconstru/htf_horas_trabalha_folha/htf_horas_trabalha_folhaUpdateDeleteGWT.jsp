<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="htf_horas_trabalha_folhaJB" class="br.com.easynet.gwt.easyportal.jb.Htf_horas_trabalha_folhaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="*"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="page" value="${pageContext}"/>                                         
${htf_horas_trabalha_folhaJB.execute}                                         
{"resultado":
{"msg":"${htf_horas_trabalha_folhaJB.msg}",
     "htf_horas_trabalha_folha":{	"htf_nr_id":"${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_id}"
 ,	"obr_nr_id":"${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.obr_nr_id}"
 ,	"htf_nr_mes":"${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_mes}"
 ,	"htf_nr_ano":"${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_ano}"
 ,	"htf_nr_horas_trabalhada":"${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada}"
  }
    }
     
}                                                                                
   
