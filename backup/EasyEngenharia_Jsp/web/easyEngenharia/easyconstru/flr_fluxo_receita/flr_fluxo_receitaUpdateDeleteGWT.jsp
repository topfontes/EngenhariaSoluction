<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="flr_fluxo_receitaJB" class="br.com.easynet.gwt.easyportal.jb.Flr_fluxo_receitaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="*"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="page" value="${pageContext}"/>                                         
${flr_fluxo_receitaJB.execute}                                         
{"resultado":
{"msg":"${flr_fluxo_receitaJB.msg}",
     "flr_fluxo_receita":{	"flr_nr_id":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_id}"
 ,	"flr_nr_mes":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_mes}"
 ,	"flr_nr_ano":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_ano}"
 ,	"flr_nr_original":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_original}"
 ,	"flr_nr_atual":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_atual}"
 ,	"flr_tx_key":"${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_tx_key}"
  }
    }
     
}                                                                                
   
