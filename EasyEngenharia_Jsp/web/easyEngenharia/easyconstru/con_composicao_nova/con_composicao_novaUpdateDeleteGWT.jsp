<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="con_composicao_novaJB" class="br.com.easynet.gwt.easyportal.jb.Con_composicao_novaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="con_composicao_novaJB" property="*"/>                                         
<jsp:setProperty name="con_composicao_novaJB" property="page" value="${pageContext}"/>                                         
${con_composicao_novaJB.execute}                                         
{"resultado":
{"msg":"${con_composicao_novaJB.msg}",
     "con_composicao_nova":{	"con_nr_id":"${con_composicao_novaJB.con_composicao_novaT.con_nr_id}"
 ,	"con_tx_codigo":"${con_composicao_novaJB.con_composicao_novaT.con_tx_codigo}"
 ,	"con_tx_descricao":"${con_composicao_novaJB.con_composicao_novaT.con_tx_descricao}"
 ,	"con_tx_unidade":"${con_composicao_novaJB.con_composicao_novaT.con_tx_unidade}"
  }
    }
     
}                                                                                
   
