<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cen_centro_custoJB" class="br.com.easynet.gwt.easyportal.jb.Cen_centro_custoInsertJB" scope="request"/>
<jsp:setProperty name="cen_centro_custoJB" property="*"/>
<jsp:setProperty name="cen_centro_custoJB" property="page" value="${pageContext}"/>
${cen_centro_custoJB.execute}
{"resultado":"${cen_centro_custoJB.msg}"}
