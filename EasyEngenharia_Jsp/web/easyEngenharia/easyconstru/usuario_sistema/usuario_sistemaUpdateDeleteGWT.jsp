<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="UsusuarioJB" class="br.com.easynet.gwt.easyportal.jb.usuario_sistemaUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="UsusuarioJB" property="*"/>
<jsp:setProperty name="UsusuarioJB" property="page" value="${pageContext}"/>
${UsusuarioJB.execute}
{"resultado":"${UsusuarioJB.msg}"}