<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="*"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>                                         
${pes_pessoaJB.execute}                                         
{"resultado":
{"msg":"${pes_pessoaJB.msg}",
     "pes_pessoa":{	"pes_nr_id":"${pes_pessoaJB.pes_pessoaT.pes_nr_id}"
 ,	"pes_tx_nome":"${pes_pessoaJB.pes_pessoaT.pes_tx_nome}"
 ,	"pes_tx_fone":"${pes_pessoaJB.pes_pessoaT.pes_tx_fone}"
  }
    }
     
}                                                                                
   
