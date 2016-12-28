<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="inn_insumo_novoJB" class="br.com.easynet.gwt.easyportal.jb.Inn_insumo_novoInsertJB" scope="request"/>
<jsp:setProperty name="inn_insumo_novoJB" property="*"/>
<jsp:setProperty name="inn_insumo_novoJB" property="page" value="${pageContext}"/>
${inn_insumo_novoJB.execute}
{"resultado":"${inn_insumo_novoJB.msg}"}
