<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="con_composicao_novaJB" class="br.com.easynet.gwt.easyportal.jb.Con_composicao_novaInsertJB" scope="request"/>
<jsp:setProperty name="con_composicao_novaJB" property="*"/>
<jsp:setProperty name="con_composicao_novaJB" property="page" value="${pageContext}"/>
${con_composicao_novaJB.execute}
{"resultado":"${con_composicao_novaJB.msg}"}
