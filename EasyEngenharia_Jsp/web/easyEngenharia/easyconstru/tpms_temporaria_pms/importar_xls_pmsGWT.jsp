<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="importar_xlsPmsJB" class="br.com.easynet.gwt.easyportal.jb.importar_xlsPmsJB" scope="request"/>
<jsp:setProperty name="importar_xlsPmsJB" property="*"/>
<jsp:setProperty name="importar_xlsPmsJB" property="page" value="${pageContext}"/>
${importar_xlsPmsJB.execute}
{"resultado":"${importar_xlsPmsJB.msg}"}
