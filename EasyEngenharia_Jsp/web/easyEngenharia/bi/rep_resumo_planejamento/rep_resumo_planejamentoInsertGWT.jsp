<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="rep_resumo_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Rep_resumo_planejamentoInsertJB" scope="request"/>
<jsp:setProperty name="rep_resumo_planejamentoJB" property="*"/>
<jsp:setProperty name="rep_resumo_planejamentoJB" property="page" value="${pageContext}"/>
${rep_resumo_planejamentoJB.execute}
{"resultado":"${rep_resumo_planejamentoJB.msg}"}
