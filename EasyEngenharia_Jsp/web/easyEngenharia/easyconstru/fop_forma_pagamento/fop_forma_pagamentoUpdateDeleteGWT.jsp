<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fop_forma_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fop_forma_pagamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fop_forma_pagamentoJB.execute}                                         
{"resultado":
{"msg":"${fop_forma_pagamentoJB.msg}",
     "fop_forma_pagamento":{	"fop_nr_id":"${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_nr_id}"
 ,	"fop_tx_nome":"${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_tx_nome}"
 ,	"fop_tx_avista":"${fop_forma_pagamentoJB.fop_forma_pagamentoT.fop_tx_avista}"
  }
    }
     
}                                                                                
   
