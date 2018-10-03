<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="scfp_subclasse_operario_previstoJB" class="br.com.easynet.gwt.easyportal.jb.Scfp_subclasse_operario_previstoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="*"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="page" value="${pageContext}"/>                                         
${scfp_subclasse_operario_previstoJB.execute}                                         
{"resultado":
{"msg":"${scfp_subclasse_operario_previstoJB.msg}",
     "scfp_subclasse_operario_previsto":{	"scfp_nr_id":"${scfp_subclasse_operario_previstoJB.scfp_subclasse_operario_previstoT.scfp_nr_id}"
 ,	"plc_nr_id":"${scfp_subclasse_operario_previstoJB.scfp_subclasse_operario_previstoT.plc_nr_id}"
  }
    }
     
}                                                                                
   
