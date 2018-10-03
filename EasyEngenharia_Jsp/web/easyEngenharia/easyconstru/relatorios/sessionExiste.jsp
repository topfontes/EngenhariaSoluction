<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fatoresPlcJB" class="br.com.easynet.gwt.easyportal.jb.SessionExisteJB" scope="request"/>
<jsp:setProperty name="fatoresPlcJB" property="*"/>
<jsp:setProperty name="fatoresPlcJB" property="page" value="${pageContext}"/>
${fatoresPlcJB.execute}
{"resultado":[
   {"registro":"marcacao"}
   ,{"resposta":"${fatoresPlcJB.msg}"}
]}
