<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeInsertJB" scope="request"/>
<jsp:setProperty name="uni_unidadeJB" property="*"/>
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>
${uni_unidadeJB.execute}
{"resultado":"${uni_unidadeJB.msg}"}
