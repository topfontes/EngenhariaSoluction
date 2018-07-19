<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ina_insumo_antigoJB" class="br.com.easynet.gwt.easyportal.jb.Ina_insumo_antigoInsertJB" scope="request"/>
<jsp:setProperty name="ina_insumo_antigoJB" property="*"/>
<jsp:setProperty name="ina_insumo_antigoJB" property="page" value="${pageContext}"/>
${ina_insumo_antigoJB.execute}
{"resultado":"${ina_insumo_antigoJB.msg}"}
