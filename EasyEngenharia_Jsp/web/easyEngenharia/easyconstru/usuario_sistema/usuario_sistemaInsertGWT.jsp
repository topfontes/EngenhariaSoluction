<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="usuariojb" class="br.com.easynet.gwt.easyportal.jb.Usuario_sistemaInsertJB" scope="request"/>
<jsp:setProperty name="usuariojb" property="*"/>
<jsp:setProperty name="usuariojb" property="page" value="${pageContext}"/>
${usuariojb.execute}
{"resultado":"${usuariojb.msg}"}