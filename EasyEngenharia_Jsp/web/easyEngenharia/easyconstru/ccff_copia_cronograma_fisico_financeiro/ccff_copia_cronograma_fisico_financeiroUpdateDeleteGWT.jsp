<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>                                         
${ccff_copia_cronograma_fisico_financeiroJB.execute}                                         
{"resultado":
{"msg":"${ccff_copia_cronograma_fisico_financeiroJB.msg}",
     "ccff_copia_cronograma_fisico_financeiro":{	"ccff_nr_id":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id}"
 ,	"obr_nr_id":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.obr_nr_id}"
 ,	"plco_nr_id":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.plco_nr_id}"
 ,	"ccff_nr_peso":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso}"
 ,	"ccff_nr_mes":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes}"
 ,	"ccff_nr_ano":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano}"
 ,	"ccff_nr_quantidade":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade}"
 ,	"ccff_nr_valor":"${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor}"
  }
    }
     
}                                                                                
   
