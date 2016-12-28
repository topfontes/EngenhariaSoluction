<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_curva_abc_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abc_equivalenciaConsultJB" scope="request"/>
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="*"/>
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="page" value="${pageContext}"/>
${vw_curva_abc_equivalenciaJB.execute} 