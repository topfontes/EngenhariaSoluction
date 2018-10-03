<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ort_orcamento_temporarioJB" class="br.com.easynet.gwt.easyportal.jb.Ort_orcamento_temporarioUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ort_orcamento_temporarioJB" property="*"/>                                         
<jsp:setProperty name="ort_orcamento_temporarioJB" property="page" value="${pageContext}"/>                                         
${ort_orcamento_temporarioJB.execute}                                         
{"resultado":
{"msg":"${ort_orcamento_temporarioJB.msg}",
     "ort_orcamento_temporario":{	"ort_nr_id":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.ort_nr_id}"
 ,	"obr_nr_id":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.obr_nr_id}"
 ,	"con_nr_id":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.con_nr_id}"
 ,	"coa_nr_id":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.coa_nr_id}"
 ,	"ort_nr_quantidade":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.ort_nr_quantidade}"
 ,	"ort_tx_letra":"${ort_orcamento_temporarioJB.ort_orcamento_temporarioT.ort_tx_letra}"
  }
    }
     
}                                                                                
   
