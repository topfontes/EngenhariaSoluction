<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tpms_temporaria_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Tpms_temporaria_pmsUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="*"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="page" value="${pageContext}"/>                                         
${tpms_temporaria_pmsJB.execute}                                         
{"resultado":
{"msg":"${tpms_temporaria_pmsJB.msg}",
     "tpms_temporaria_pms":{	"tmps_nr_id":"${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.tmps_nr_id}"
 ,	"plco_nr_id":"${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.plco_nr_id}"
 ,	"tmps_nr_quantidade":"${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.tmps_nr_quantidade}"
 ,	"tpms_bl_servico":"${tpms_temporaria_pmsJB.tpms_temporaria_pmsT.tpms_bl_servico}"
  }
    }
     
}                                                                                
   
