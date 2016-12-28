<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plr_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plr_planilha_recebimentoInsertJB" scope="request"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="*"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="page" value="${pageContext}"/>
${plr_planilha_permutaJB.execute}
{"resultado":"${plr_planilha_permutaJB.msg}"}
