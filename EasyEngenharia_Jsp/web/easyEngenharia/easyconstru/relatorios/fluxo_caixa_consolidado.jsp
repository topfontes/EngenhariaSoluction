<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fluxo" class="br.com.easynet.gwt.easyportal.relatorios.fluxo_caixa_consolidado.FluxoCaixa_ConsolidadoJB" scope="request"/>
<jsp:setProperty name="fluxo" property="*"/>
<jsp:setProperty name="fluxo" property="page" value="${pageContext}"/>
${fluxo.execute}