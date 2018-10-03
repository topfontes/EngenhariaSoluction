<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="evl_evolucao_lucroJB" class="br.com.easynet.gwt.easyportal.jb.Evl_evolucao_lucroInsertJB" scope="request"/>
<jsp:setProperty name="evl_evolucao_lucroJB" property="*"/>
<jsp:setProperty name="evl_evolucao_lucroJB" property="page" value="${pageContext}"/>
${evl_evolucao_lucroJB.execute}
{"resultado":"${evl_evolucao_lucroJB.msg}"}
