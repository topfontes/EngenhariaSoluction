<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_curva_abc_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abc_equivalenciaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abc_equivalenciaJB.execute}                                         
{"resultado":
{"msg":"${vw_curva_abc_equivalenciaJB.msg}",
     "vw_curva_abc_equivalencia":{	"obr_nr_id":"${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.obr_nr_id}"
 ,	"plc_nr_id":"${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.plc_nr_id}"
 ,	"plc_tx_nome":"${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.plc_tx_nome}"
 ,	"total":"${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.total}"
  }
    }
     
}                                                                                
   
