<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fat_fatorJB" class="br.com.easynet.gwt.easyportal.jb.Fat_fatorInsertJB" scope="request"/>
<jsp:setProperty name="fat_fatorJB" property="*"/>
<jsp:setProperty name="fat_fatorJB" property="page" value="${pageContext}"/>
${fat_fatorJB.execute}
{"resultado":"${fat_fatorJB.msg}"}
