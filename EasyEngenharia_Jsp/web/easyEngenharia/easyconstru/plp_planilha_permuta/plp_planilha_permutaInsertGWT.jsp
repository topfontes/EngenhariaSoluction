<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plp_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plp_planilha_permutaInsertJB" scope="request"/>
<jsp:setProperty name="plp_planilha_permutaJB" property="*"/>
<jsp:setProperty name="plp_planilha_permutaJB" property="page" value="${pageContext}"/>
${plp_planilha_permutaJB.execute}
{"resultado":"${plp_planilha_permutaJB.msg}"}
