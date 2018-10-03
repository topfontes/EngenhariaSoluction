<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ina_insumo_antigoJB" class="br.com.easynet.gwt.easyportal.jb.Ina_insumo_antigoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ina_insumo_antigoJB" property="*"/>                                         
<jsp:setProperty name="ina_insumo_antigoJB" property="page" value="${pageContext}"/>                                         
${ina_insumo_antigoJB.execute}                                         
{"resultado":
{"msg":"${ina_insumo_antigoJB.msg}",
     "ina_insumo_antigo":{	"ina_nr_id":"${ina_insumo_antigoJB.ina_insumo_antigoT.ina_nr_id}"
 ,	"ina_tx_codigo":"${ina_insumo_antigoJB.ina_insumo_antigoT.ina_tx_codigo}"
 ,	"ina_tx_descricao":"${ina_insumo_antigoJB.ina_insumo_antigoT.ina_tx_descricao}"
 ,	"ina_tx_unidade":"${ina_insumo_antigoJB.ina_insumo_antigoT.ina_tx_unidade}"
  }
    }
     
}                                                                                
   
