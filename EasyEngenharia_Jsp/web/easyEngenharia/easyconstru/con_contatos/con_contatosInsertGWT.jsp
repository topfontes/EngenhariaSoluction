<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="con_contatosJB" class="br.com.easynet.gwt.easyportal.jb.Con_contatosInsertJB" scope="request"/>
<jsp:setProperty name="con_contatosJB" property="*"/>
<jsp:setProperty name="con_contatosJB" property="page" value="${pageContext}"/>
${con_contatosJB.execute}
{"resultado":"${con_contatosJB.msg}"}
