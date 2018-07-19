<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqi_equivalencia_insumoJB" class="br.com.easynet.gwt.easyportal.jb.Eqi_equivalencia_insumoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eqi_equivalencia_insumoJB" property="*"/>                                         
<jsp:setProperty name="eqi_equivalencia_insumoJB" property="page" value="${pageContext}"/>                                         
${eqi_equivalencia_insumoJB.execute}                                         
{"resultado":
{"msg":"${eqi_equivalencia_insumoJB.msg}",
     "eqi_equivalencia_insumo":{	"ina_nr_id":"${eqi_equivalencia_insumoJB.eqi_equivalencia_insumoT.ina_nr_id}"
 ,	"inn_nr_id":"${eqi_equivalencia_insumoJB.eqi_equivalencia_insumoT.inn_nr_id}"
  }
    }
     
}                                                                                
   
