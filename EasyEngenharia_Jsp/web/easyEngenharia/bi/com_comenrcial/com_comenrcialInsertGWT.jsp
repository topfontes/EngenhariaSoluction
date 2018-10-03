<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="com_comenrcialJB" class="br.com.easynet.gwt.easyportal.jb.Com_comenrcialInsertJB" scope="request"/>
<jsp:setProperty name="com_comenrcialJB" property="*"/>
<jsp:setProperty name="com_comenrcialJB" property="page" value="${pageContext}"/>
${com_comenrcialJB.execute}
{"resultado":"${com_comenrcialJB.msg}"}
