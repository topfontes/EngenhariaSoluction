<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="uno_unidade_obraJB" class="br.com.easynet.gwt.easyportal.jb.Uno_unidade_obraInsertJB" scope="request"/>
<jsp:setProperty name="uno_unidade_obraJB" property="*"/>
<jsp:setProperty name="uno_unidade_obraJB" property="page" value="${pageContext}"/>
${uno_unidade_obraJB.execute}
{"resultado":"${uno_unidade_obraJB.msg}"}
