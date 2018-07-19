<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plc_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Plc_plano_contasInsertJB" scope="request"/>
<jsp:setProperty name="plc_plano_contasJB" property="*"/>
<jsp:setProperty name="plc_plano_contasJB" property="page" value="${pageContext}"/>
${plc_plano_contasJB.execute}
{"resultado":"${plc_plano_contasJB.msg}"}
