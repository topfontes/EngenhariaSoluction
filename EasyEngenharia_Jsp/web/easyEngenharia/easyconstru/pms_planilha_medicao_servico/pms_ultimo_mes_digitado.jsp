<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pms_planilha_medicao_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Pms_planilha_medicao_servicoInsertJB" scope="request"/>
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="*"/>
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="page" value="${pageContext}"/>
${pms_planilha_medicao_servicoJB.execute}
{"resultado":"${pms_planilha_medicao_servicoJB.msg}"}
