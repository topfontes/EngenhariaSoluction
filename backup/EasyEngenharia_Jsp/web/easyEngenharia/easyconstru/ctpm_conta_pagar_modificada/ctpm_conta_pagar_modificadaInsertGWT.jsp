<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ctpm_conta_pagar_modificadaJB" class="br.com.easynet.gwt.easyportal.jb.Ctpm_conta_pagar_modificadaInsertJB" scope="request"/>
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="*"/>
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="page" value="${pageContext}"/>
${ctpm_conta_pagar_modificadaJB.execute}
{"resultado":"${ctpm_conta_pagar_modificadaJB.msg}"}
