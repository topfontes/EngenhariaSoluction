<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fop_forma_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fop_forma_pagamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fop_forma_pagamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${fop_forma_pagamentoJB.list}" var="item">
     ,{	"fop_nr_id":"${item.fop_nr_id}"
 ,	"fop_tx_nome":"${item.fop_tx_nome}"
 ,	"fop_tx_avista":"${item.fop_tx_avista}"
  }
</c:forEach>
]}                                                                                
   
