<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="printJB" class="br.com.easynet.gwt.easyportal.relatorios.conf_insumos_subClasse_pms.Conf_insumos_subClasse_pmsJB" scope="request"/>
<jsp:setProperty name="printJB" property="*"/>
<jsp:setProperty name="printJB" property="page" value="${pageContext}"/>
${printJB.execute}
{"resultado":"${printJB.msg}"}