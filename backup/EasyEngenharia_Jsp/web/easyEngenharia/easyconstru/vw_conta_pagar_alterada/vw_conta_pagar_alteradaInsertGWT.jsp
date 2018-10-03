<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_conta_pagar_alteradaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_conta_pagar_alteradaInsertJB" scope="request"/>
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="*"/>
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="page" value="${pageContext}"/>
${vw_conta_pagar_alteradaJB.execute}
{"resultado":"${vw_conta_pagar_alteradaJB.msg}"}
