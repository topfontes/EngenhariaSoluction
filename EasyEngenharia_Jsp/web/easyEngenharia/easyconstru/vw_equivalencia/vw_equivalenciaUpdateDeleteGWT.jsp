<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equivalenciaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_equivalenciaJB.execute}                                         
{"resultado":
{"msg":"${vw_equivalenciaJB.msg}",
     "vw_equivalencia":{	"eplc_nr_id":"${vw_equivalenciaJB.vw_equivalenciaT.eplc_nr_id}"
 ,	"plc_nr_id":"${vw_equivalenciaJB.vw_equivalenciaT.plc_nr_id}"
 ,	"plco_nr_id":"${vw_equivalenciaJB.vw_equivalenciaT.plco_nr_id}"
 ,	"plco_tx_nome":"${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_nome}"
 ,	"plc_tx_nome":"${vw_equivalenciaJB.vw_equivalenciaT.plc_tx_nome}"
 ,	"plco_tx_tipo":"${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_tipo}"
 ,	"plco_tx_cod_externo":"${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_cod_externo}"
 ,	"plco_tx_unidade":"${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_unidade}"
  }
    }
     
}                                                                                
   
