<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inn_insumo_novoJB" class="br.com.easynet.gwt.easyportal.jb.Inn_insumo_novoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inn_insumo_novoJB" property="*"/>                                         
<jsp:setProperty name="inn_insumo_novoJB" property="page" value="${pageContext}"/>                                         
${inn_insumo_novoJB.execute}                                         
{"resultado":
{"msg":"${inn_insumo_novoJB.msg}",
     "inn_insumo_novo":{	"inn_nr_id":"${inn_insumo_novoJB.inn_insumo_novoT.inn_nr_id}"
 ,	"inn_tx_codigo":"${inn_insumo_novoJB.inn_insumo_novoT.inn_tx_codigo}"
 ,	"inn_tx_descricao":"${inn_insumo_novoJB.inn_insumo_novoT.inn_tx_descricao}"
 ,	"inn_tx_unidade":"${inn_insumo_novoJB.inn_insumo_novoT.inn_tx_unidade}"
  }
    }
     
}                                                                                
   
