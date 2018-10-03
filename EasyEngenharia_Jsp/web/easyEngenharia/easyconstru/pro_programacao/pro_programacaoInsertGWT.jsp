<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pro_programacaoJB" class="br.com.easynet.gwt.easyportal.jb.Pro_programacaoInsertJB" scope="request"/>
<jsp:setProperty name="pro_programacaoJB" property="*"/>
<jsp:setProperty name="pro_programacaoJB" property="page" value="${pageContext}"/>
${pro_programacaoJB.execute}
{"resultado":"${pro_programacaoJB.msg}"}
