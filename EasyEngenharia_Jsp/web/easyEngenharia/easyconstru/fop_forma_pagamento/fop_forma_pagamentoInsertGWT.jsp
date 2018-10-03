<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fop_forma_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fop_forma_pagamentoInsertJB" scope="request"/>
<jsp:setProperty name="fop_forma_pagamentoJB" property="*"/>
<jsp:setProperty name="fop_forma_pagamentoJB" property="page" value="${pageContext}"/>
${fop_forma_pagamentoJB.execute}
{"resultado":"${fop_forma_pagamentoJB.msg}"}
