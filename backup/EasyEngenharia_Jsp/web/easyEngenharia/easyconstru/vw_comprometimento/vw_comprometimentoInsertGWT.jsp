<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_comprometimentoInsertJB" scope="request"/>
<jsp:setProperty name="vw_comprometimentoJB" property="*"/>
<jsp:setProperty name="vw_comprometimentoJB" property="page" value="${pageContext}"/>
${vw_comprometimentoJB.execute}
{"resultado":"${vw_comprometimentoJB.msg}"}
