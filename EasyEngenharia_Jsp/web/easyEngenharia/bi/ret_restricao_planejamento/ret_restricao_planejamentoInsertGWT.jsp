<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ret_restricao_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Ret_restricao_planejamentoInsertJB" scope="request"/>
<jsp:setProperty name="ret_restricao_planejamentoJB" property="*"/>
<jsp:setProperty name="ret_restricao_planejamentoJB" property="page" value="${pageContext}"/>
${ret_restricao_planejamentoJB.execute}
{"resultado":"${ret_restricao_planejamentoJB.msg}"}
