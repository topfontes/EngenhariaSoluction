<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="infe_item_nota_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Infe_item_nota_entradaInsertJB" scope="request"/>
<jsp:setProperty name="infe_item_nota_entradaJB" property="*"/>
<jsp:setProperty name="infe_item_nota_entradaJB" property="page" value="${pageContext}"/>
${infe_item_nota_entradaJB.execute}
{"resultado":"${infe_item_nota_entradaJB.msg}"}
