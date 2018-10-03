<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ficha" class="br.com.easynet.gwt.easyportal.relatorios.ficha_resumo.Ficha_Resumo" scope="request"/>
<jsp:setProperty name="ficha" property="*"/>
<jsp:setProperty name="ficha" property="page" value="${pageContext}"/>
${ficha.execute}