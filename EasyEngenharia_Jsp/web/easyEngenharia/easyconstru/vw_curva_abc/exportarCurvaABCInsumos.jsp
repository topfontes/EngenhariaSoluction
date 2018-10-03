<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_curva_abcJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abcConsultJB" scope="request"/>
<jsp:setProperty name="vw_curva_abcJB" property="*"/>
<jsp:setProperty name="vw_curva_abcJB" property="page" value="${pageContext}"/>
${vw_curva_abcJB.execute}    