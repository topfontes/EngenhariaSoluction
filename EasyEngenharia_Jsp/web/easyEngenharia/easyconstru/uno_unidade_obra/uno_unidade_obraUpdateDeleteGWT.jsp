<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="uno_unidade_obraJB" class="br.com.easynet.gwt.easyportal.jb.Uno_unidade_obraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="*"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="page" value="${pageContext}"/>                                         
${uno_unidade_obraJB.execute}                                         
{"resultado":
{"msg":"${uno_unidade_obraJB.msg}",
     "uno_unidade_obra":{	"uno_nr_id":"${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_id}"
 ,	"obr_nr_id":"${uno_unidade_obraJB.uno_unidade_obraT.obr_nr_id}"
 ,	"uni_nr_id":"${uno_unidade_obraJB.uno_unidade_obraT.uni_nr_id}"
 ,	"uno_nr_quantidade":"${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_quantidade}"
 ,	"uno_nr_area_construida":"${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_area_construida}"
  }
    }
     
}                                                                                
   
