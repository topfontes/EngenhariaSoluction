<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="evl_evolucao_lucroJB" class="br.com.easynet.gwt.easyportal.jb.Evl_evolucao_lucroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="*"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="page" value="${pageContext}"/>                                         
${evl_evolucao_lucroJB.execute}                                         
{"resultado":
{"msg":"${evl_evolucao_lucroJB.msg}",
     "evl_evolucao_lucro":{	"evl_nr_id":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_id}"
 ,	"obr_nr_id":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.obr_nr_id}"
 ,	"evl_nr_mes":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_mes}"
 ,	"evl_nr_ano":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_ano}"
 ,	"evl_nr_valor":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_valor}"
 ,	"evl_nr_mes_ref":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_mes_ref}"
 ,	"evl_nr_ano_ref":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_ano_ref}"
 ,	"evl_tx_tipo":"${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_tx_tipo}"
  }
    }
     
}                                                                                
   
