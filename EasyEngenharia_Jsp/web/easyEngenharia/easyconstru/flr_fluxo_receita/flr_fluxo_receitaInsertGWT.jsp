<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="flr_fluxo_receitaJB" class="br.com.easynet.gwt.easyportal.jb.Flr_fluxo_receitaInsertJB" scope="request"/>
<jsp:setProperty name="flr_fluxo_receitaJB" property="*"/>
<jsp:setProperty name="flr_fluxo_receitaJB" property="page" value="${pageContext}"/>
${flr_fluxo_receitaJB.execute}
{"resultado":"${flr_fluxo_receitaJB.msg}"}
