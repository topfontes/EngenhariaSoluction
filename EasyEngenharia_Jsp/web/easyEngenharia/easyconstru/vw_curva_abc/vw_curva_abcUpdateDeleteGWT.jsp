<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_curva_abcJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abcUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abcJB.execute}                                         
{"resultado":
{"msg":"${vw_curva_abcJB.msg}",
     "vw_curva_abc":{	"obr_nr_id":"${vw_curva_abcJB.vw_curva_abcT.obr_nr_id}"
 ,	"obr_tx_nome":"${vw_curva_abcJB.vw_curva_abcT.obr_tx_nome}"
 ,	"plco_nr_id":"${vw_curva_abcJB.vw_curva_abcT.plco_nr_id}"
 ,	"plco_tx_nome":"${vw_curva_abcJB.vw_curva_abcT.plco_tx_nome}"
 ,	"total":"${vw_curva_abcJB.vw_curva_abcT.total}"
  }
    }
     
}                                                                                
   
