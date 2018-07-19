<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="emp_empreendimentoJB" class="br.com.easynet.gwt.easyportal.jb.Emp_empreendimentoInsertJB" scope="request"/>
<jsp:setProperty name="emp_empreendimentoJB" property="*"/>
<jsp:setProperty name="emp_empreendimentoJB" property="page" value="${pageContext}"/>
${emp_empreendimentoJB.execute}
{"resultado":"${emp_empreendimentoJB.msg}"}
