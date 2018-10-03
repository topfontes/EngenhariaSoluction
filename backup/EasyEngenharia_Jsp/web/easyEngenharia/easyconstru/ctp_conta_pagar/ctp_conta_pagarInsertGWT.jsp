<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.Ctp_conta_pagarInsertJB" scope="request"/>
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>
${ctp_conta_pagarJB.execute}
{"resultado":"${ctp_conta_pagarJB.msg}"}
