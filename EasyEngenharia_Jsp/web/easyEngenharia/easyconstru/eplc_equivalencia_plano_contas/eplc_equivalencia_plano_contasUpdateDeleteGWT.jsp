<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>                                         
${eplc_equivalencia_plano_contasJB.execute}                                         
{"resultado":
{"msg":"${eplc_equivalencia_plano_contasJB.msg}",
     "eplc_equivalencia_plano_contas":{	"eplc_nr_id":"${eplc_equivalencia_plano_contasJB.eplc_equivalencia_plano_contasT.eplc_nr_id}"
 ,	"plc_nr_id":"${eplc_equivalencia_plano_contasJB.eplc_equivalencia_plano_contasT.plc_nr_id}"
 ,	"plco_nr_id":"${eplc_equivalencia_plano_contasJB.eplc_equivalencia_plano_contasT.plco_nr_id}"
  }
    }
     
}                                                                                
   
