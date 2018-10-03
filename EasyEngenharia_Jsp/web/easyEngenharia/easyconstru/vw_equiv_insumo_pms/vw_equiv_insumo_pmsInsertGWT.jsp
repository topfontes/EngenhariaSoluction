<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_equiv_insumo_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equiv_insumo_pmsInsertJB" scope="request"/>
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="*"/>
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="page" value="${pageContext}"/>
${vw_equiv_insumo_pmsJB.execute}
{"resultado":"${vw_equiv_insumo_pmsJB.msg}"}
