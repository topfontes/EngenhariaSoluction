<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ort_orcamento_temporarioJB" class="br.com.easynet.gwt.easyportal.jb.Ort_orcamento_temporarioInsertJB" scope="request"/>
<jsp:setProperty name="ort_orcamento_temporarioJB" property="*"/>
<jsp:setProperty name="ort_orcamento_temporarioJB" property="page" value="${pageContext}"/>
${ort_orcamento_temporarioJB.execute}
{"resultado":"${ort_orcamento_temporarioJB.msg}"}
