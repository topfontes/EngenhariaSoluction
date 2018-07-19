<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ume_unidade_medidaJB" class="br.com.easynet.gwt.easyportal.jb.Ume_unidade_medidaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="*"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="page" value="${pageContext}"/>                                         
${ume_unidade_medidaJB.execute}                                         
{"resultado":
{"msg":"${ume_unidade_medidaJB.msg}",
     "ume_unidade_medida":{	"ume_nr_id":"${ume_unidade_medidaJB.ume_unidade_medidaT.ume_nr_id}"
 ,	"ume_tx_nome":"${ume_unidade_medidaJB.ume_unidade_medidaT.ume_tx_nome}"
  }
    }
     
}                                                                                
   
