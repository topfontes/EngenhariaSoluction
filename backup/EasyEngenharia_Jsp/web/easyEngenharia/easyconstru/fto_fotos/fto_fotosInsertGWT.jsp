<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosInsertJB" scope="request"/>
<jsp:setProperty name="fto_fotosJB" property="*"/>
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>
${fto_fotosJB.execute}
{"resultado":"${fto_fotosJB.msg}"}
