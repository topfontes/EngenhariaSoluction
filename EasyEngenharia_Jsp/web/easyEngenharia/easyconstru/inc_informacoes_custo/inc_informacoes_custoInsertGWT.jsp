<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="inc_informacoes_custoJB" class="br.com.easynet.gwt.easyportal.jb.Inc_informacoes_custoInsertJB" scope="request"/>
<jsp:setProperty name="inc_informacoes_custoJB" property="*"/>
<jsp:setProperty name="inc_informacoes_custoJB" property="page" value="${pageContext}"/>
${inc_informacoes_custoJB.execute}
{"resultado":"${inc_informacoes_custoJB.msg}"}
