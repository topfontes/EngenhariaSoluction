<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_insumo_plc_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_insumo_plc_pmsInsertJB" scope="request"/>
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="*"/>
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="page" value="${pageContext}"/>
${vw_insumo_plc_pmsJB.execute}
{"resultado":"${vw_insumo_plc_pmsJB.msg}"}
