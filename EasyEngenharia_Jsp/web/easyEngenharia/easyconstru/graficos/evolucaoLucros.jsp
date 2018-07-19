<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="evolucao" class="br.com.easynet.gwt.easyportal.grafico.evolucaoLucro.EvolucaoLucro" scope="request"/>
<jsp:setProperty name="evolucao" property="*"/>
<jsp:setProperty name="evolucao" property="page" value="${pageContext}"/>
${evolucao.execute}
