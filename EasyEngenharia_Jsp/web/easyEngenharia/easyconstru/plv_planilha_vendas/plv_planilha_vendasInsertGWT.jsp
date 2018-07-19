<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plv_planilha_vendasJB" class="br.com.easynet.gwt.easyportal.jb.Plv_planilha_vendasInsertJB" scope="request"/>
<jsp:setProperty name="plv_planilha_vendasJB" property="*"/>
<jsp:setProperty name="plv_planilha_vendasJB" property="page" value="${pageContext}"/>
${plv_planilha_vendasJB.execute}
{"resultado":"${plv_planilha_vendasJB.msg}"}
