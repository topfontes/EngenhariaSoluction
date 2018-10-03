<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="coa_composicao_anteriorJB" class="br.com.easynet.gwt.easyportal.jb.Coa_composicao_anteriorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="coa_composicao_anteriorJB" property="*"/>                                         
<jsp:setProperty name="coa_composicao_anteriorJB" property="page" value="${pageContext}"/>                                         
${coa_composicao_anteriorJB.execute}                                         
{"resultado":
{"msg":"${coa_composicao_anteriorJB.msg}",
     "coa_composicao_anterior":{	"coa_nr_id":"${coa_composicao_anteriorJB.coa_composicao_anteriorT.coa_nr_id}"
 ,	"coa_tx_codigo":"${coa_composicao_anteriorJB.coa_composicao_anteriorT.coa_tx_codigo}"
 ,	"coa_tx_descricao":"${coa_composicao_anteriorJB.coa_composicao_anteriorT.coa_tx_descricao}"
 ,	"coa_tx_unidade":"${coa_composicao_anteriorJB.coa_composicao_anteriorT.coa_tx_unidade}"
  }
    }
     
}                                                                                
   
