<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasInsertJB" scope="request"/>
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>
${eplc_equivalencia_plano_contasJB.execute}
{"resultado":"${eplc_equivalencia_plano_contasJB.msg}"}
