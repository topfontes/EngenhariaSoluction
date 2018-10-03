<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="htf_horas_trabalha_folhaJB" class="br.com.easynet.gwt.easyportal.jb.Htf_horas_trabalha_folhaInsertJB" scope="request"/>
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="*"/>
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="page" value="${pageContext}"/>
${htf_horas_trabalha_folhaJB.execute}
{"resultado":"${htf_horas_trabalha_folhaJB.msg}"}
