<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_equivalenciaJB" class="br.com.easynet.gwt.easyportal.relatorios.equivalencia.EquivalenciaImpressao" scope="request"/>
<jsp:setProperty name="vw_equivalenciaJB" property="*"/>
<jsp:setProperty name="vw_equivalenciaJB" property="page" value="${pageContext}"/>
${vw_equivalenciaJB.execute}
