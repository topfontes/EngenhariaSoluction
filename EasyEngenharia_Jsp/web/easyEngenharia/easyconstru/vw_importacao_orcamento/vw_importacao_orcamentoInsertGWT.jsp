<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_importacao_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoInsertJB" scope="request"/>
<jsp:setProperty name="vw_importacao_orcamentoJB" property="*"/>
<jsp:setProperty name="vw_importacao_orcamentoJB" property="page" value="${pageContext}"/>
${vw_importacao_orcamentoJB.execute}
{"resultado":"${vw_importacao_orcamentoJB.msg}"}
