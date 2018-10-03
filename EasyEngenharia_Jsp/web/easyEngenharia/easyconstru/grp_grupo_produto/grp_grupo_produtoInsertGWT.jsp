<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoInsertJB" scope="request"/>
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>
${grp_grupo_produtoJB.execute}
{"resultado":"${grp_grupo_produtoJB.msg}"}
