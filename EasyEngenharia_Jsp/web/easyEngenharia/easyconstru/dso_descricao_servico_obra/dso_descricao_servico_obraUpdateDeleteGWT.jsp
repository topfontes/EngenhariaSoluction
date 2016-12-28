<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dso_descricao_servico_obraJB" class="br.com.easynet.gwt.easyportal.jb.Dso_descricao_servico_obraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="*"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="page" value="${pageContext}"/>                                         
${dso_descricao_servico_obraJB.execute}                                         
{"resultado":
{"msg":"${dso_descricao_servico_obraJB.msg}",
     "dso_descricao_servico_obra":{	"plco_nr_id":"${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.plco_nr_id}"
 ,	"dso_tx_codigo_externo":"${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_tx_codigo_externo}"
 ,	"dso_tx_descriaco":"${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_tx_descriaco}"
 ,	"dso_nr_id":"${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_nr_id}"
  }
    }
     
}                                                                                
   
