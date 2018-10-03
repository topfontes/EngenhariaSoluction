<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="custo" class="br.com.easynet.gwt.easyportal.relatorios.analiseCustosObraRegimeCompetencia.AnaliseCustosRegimeCompetencia" scope="request"/>
<jsp:setProperty name="custo" property="*"/>
<jsp:setProperty name="custo" property="page" value="${pageContext}"/>
${custo.execute} 
