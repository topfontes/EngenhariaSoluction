<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="csg_curva_s_geralJB" class="br.com.easynet.gwt.easyportal.jb.Csg_curva_s_geralInsertJB" scope="request"/>
<jsp:setProperty name="csg_curva_s_geralJB" property="*"/>
<jsp:setProperty name="csg_curva_s_geralJB" property="page" value="${pageContext}"/>
${csg_curva_s_geralJB.execute}
{"resultado":"${csg_curva_s_geralJB.msg}"}
