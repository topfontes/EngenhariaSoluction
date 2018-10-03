<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fotos" class="br.com.easynet.gwt.easyportal.relatorios.fotos_rel.Fotos_REL" scope="request"/>
<jsp:setProperty name="fotos" property="*"/>
<jsp:setProperty name="fotos" property="page" value="${pageContext}"/>
${fotos.execute}
