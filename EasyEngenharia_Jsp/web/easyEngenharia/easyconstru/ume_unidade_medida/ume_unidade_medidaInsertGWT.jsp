<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ume_unidade_medidaJB" class="br.com.easynet.gwt.easyportal.jb.Ume_unidade_medidaInsertJB" scope="request"/>
<jsp:setProperty name="ume_unidade_medidaJB" property="*"/>
<jsp:setProperty name="ume_unidade_medidaJB" property="page" value="${pageContext}"/>
${ume_unidade_medidaJB.execute}
{"resultado":"${ume_unidade_medidaJB.msg}"}
