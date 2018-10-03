<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="inaJB" class="br.com.easynet.gwt.easyportal.jb.Gerar_xlsInsumoJB" scope="request"/>
<jsp:setProperty name="inaJB" property="*"/>
<jsp:setProperty name="inaJB" property="page" value="${pageContext}"/>
${inaJB.execute}