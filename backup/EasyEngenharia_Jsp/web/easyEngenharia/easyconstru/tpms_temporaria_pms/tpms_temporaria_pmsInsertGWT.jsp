<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tpms_temporaria_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Tpms_temporaria_pmsInsertJB" scope="request"/>
<jsp:setProperty name="tpms_temporaria_pmsJB" property="*"/>
<jsp:setProperty name="tpms_temporaria_pmsJB" property="page" value="${pageContext}"/>
${tpms_temporaria_pmsJB.execute}
{"resultado":"${tpms_temporaria_pmsJB.msg}"}
