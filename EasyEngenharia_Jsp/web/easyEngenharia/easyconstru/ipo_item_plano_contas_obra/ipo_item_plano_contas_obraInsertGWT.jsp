<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ipo_item_plano_contas_obraJB" class="br.com.easynet.gwt.easyportal.jb.Ipo_item_plano_contas_obraInsertJB" scope="request"/>
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="*"/>
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="page" value="${pageContext}"/>
${ipo_item_plano_contas_obraJB.execute}
{"resultado":"${ipo_item_plano_contas_obraJB.msg}"}
