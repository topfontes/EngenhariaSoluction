<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="custo_plc_pmsJB" class="br.com.easynet.gwt.easyportal.relatorios.custo_plc_pms.Custo_Plc_pmsJB" scope="request"/>
<jsp:setProperty name="custo_plc_pmsJB" property="*"/>
<jsp:setProperty name="custo_plc_pmsJB" property="page" value="${pageContext}"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
${custo_plc_pmsJB.execute}
{"resultado":"${custo_plc_pmsJB.msg}"}
