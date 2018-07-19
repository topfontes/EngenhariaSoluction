<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="gerar_xlsJB" class="br.com.easynet.gwt.easyportal.relatorios.equivalencia_comp.ImprimirEQC" scope="request"/>
<jsp:setProperty name="gerar_xlsJB" property="*"/>
<jsp:setProperty name="gerar_xlsJB" property="page" value="${pageContext}"/>
${gerar_xlsJB.execute}
{"resultado":"${gerar_xlsJB.msg}"}