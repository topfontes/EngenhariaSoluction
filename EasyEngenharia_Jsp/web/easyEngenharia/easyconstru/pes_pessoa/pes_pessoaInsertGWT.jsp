<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaInsertJB" scope="request"/>
<jsp:setProperty name="pes_pessoaJB" property="*"/>
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>
${pes_pessoaJB.execute}
{"resultado":"${pes_pessoaJB.msg}"}
