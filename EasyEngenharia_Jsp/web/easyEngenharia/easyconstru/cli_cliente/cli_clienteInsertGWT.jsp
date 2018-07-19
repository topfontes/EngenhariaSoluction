<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.easyportal.jb.Cli_clienteInsertJB" scope="request"/>
<jsp:setProperty name="cli_clienteJB" property="*"/>
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>
${cli_clienteJB.execute}
{"resultado":"${cli_clienteJB.msg}"}
