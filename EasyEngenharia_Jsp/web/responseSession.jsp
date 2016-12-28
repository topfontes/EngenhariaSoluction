<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="responseJB" class="br.com.easynet.gwt.easyportal.jb.ResponseSessionJB" scope="request"/>
<jsp:setProperty name="responseJB" property="*"/>
<jsp:setProperty name="responseJB" property="page" value="${pageContext}"/>
${responseJB.execute}
{"resultado":"${responseJB.msg}"}
