<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="vw_cffo_mesJB" class="br.com.easynet.gwt.easyportal.client.jb.Vw_cffo_mesInsertJB" scope="request"/>
<jsp:setProperty name="vw_cffo_mesJB" property="*"/>
<jsp:setProperty name="vw_cffo_mesJB" property="page" value="${pageContext}"/>
${vw_cffo_mesJB.execute}
{"resultado":"${vw_cffo_mesJB.msg}"}
