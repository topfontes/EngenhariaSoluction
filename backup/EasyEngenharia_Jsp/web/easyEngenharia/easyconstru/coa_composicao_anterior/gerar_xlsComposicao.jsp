<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="compJB" class="br.com.easynet.gwt.easyportal.jb.Gerar_xlsComposicaoJB" scope="request"/>
<jsp:setProperty name="compJB" property="*"/>
<jsp:setProperty name="compJB" property="page" value="${pageContext}"/>
${compJB.execute}
