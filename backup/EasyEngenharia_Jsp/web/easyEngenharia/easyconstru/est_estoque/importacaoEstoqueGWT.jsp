<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="est_estoqueJB" class="br.com.easynet.gwt.easyportal.jb.ImportacaoEstoqueJB" scope="request"/>
<jsp:setProperty name="est_estoqueJB" property="*"/>
<jsp:setProperty name="est_estoqueJB" property="page" value="${pageContext}"/>
${est_estoqueJB.execute}
{"resultado":"${est_estoqueJB.msg}"}