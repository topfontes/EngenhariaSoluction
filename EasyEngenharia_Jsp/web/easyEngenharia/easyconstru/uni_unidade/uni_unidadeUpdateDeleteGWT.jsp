<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="*"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>                                         
${uni_unidadeJB.execute}                                         
{"resultado":
{"msg":"${uni_unidadeJB.msg}",
     "uni_unidade":{	"uni_nr_id":"${uni_unidadeJB.uni_unidadeT.uni_nr_id}"
 ,	"uni_tx_nome":"${uni_unidadeJB.uni_unidadeT.uni_tx_nome}"
  }
    }
     
}                                                                                
   
