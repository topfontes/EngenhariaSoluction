<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fol_folha_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fol_folha_pagamentoInsertJB" scope="request"/>
<jsp:setProperty name="fol_folha_pagamentoJB" property="*"/>
<jsp:setProperty name="fol_folha_pagamentoJB" property="page" value="${pageContext}"/>
${fol_folha_pagamentoJB.execute}
{"resultado":[{"msg":"${fol_folha_pagamentoJB.msg}"},{"id":"${fol_folha_pagamentoJB.fol_nr_id}"}]}