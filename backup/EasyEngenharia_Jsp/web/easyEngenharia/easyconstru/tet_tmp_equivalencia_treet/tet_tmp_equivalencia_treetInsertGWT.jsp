<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetInsertJB" scope="request"/>
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>
${tet_tmp_equivalencia_treetJB.execute}
{"resultado":"${tet_tmp_equivalencia_treetJB.msg}"}
