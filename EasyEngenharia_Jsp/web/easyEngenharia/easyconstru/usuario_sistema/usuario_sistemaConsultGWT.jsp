<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="usuarioJB" class="br.com.easynet.gwt.easyportal.jb.Usuario_sistemaConsultJB" scope="request"/>
<jsp:setProperty name="usuarioJB" property="*"/>
<jsp:setProperty name="usuarioJB" property="page" value="${pageContext}"/>
${usuarioJB.execute}
${usuarioJB.msg}
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${usuarioJB.list}" var="item">
    ,{	"usu_tx_nome":"${item.usu_tx_nome}"
    ,	"usu_tx_status":"${item.usu_tx_status}"
    ,	"usu_tx_email":"${item.usu_tx_email}"
    ,	"usu_nr_id":"${item.usu_nr_id}"
    ,	"usu_tx_login":"${item.usu_tx_login}"
    ,	"usu_tx_senha":"${item.usu_tx_senha}"
    }
</c:forEach>
]}

