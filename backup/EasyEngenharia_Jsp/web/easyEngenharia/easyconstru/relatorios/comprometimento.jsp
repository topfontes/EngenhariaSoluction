<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="comprometimento" class="br.com.easynet.gwt.easyportal.relatorios.comprometimento.Comprometimento" scope="request"/>
<jsp:setProperty name="comprometimento" property="*"/>
<jsp:setProperty name="comprometimento" property="page" value="${pageContext}"/>
${comprometimento.execute}