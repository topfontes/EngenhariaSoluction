<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="frd_faturamento_rec_devolucaoJB" class="br.com.easynet.gwt.easyportal.jb.Frd_faturamento_rec_devolucaoInsertJB" scope="request"/>
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="*"/>
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="page" value="${pageContext}"/>
${frd_faturamento_rec_devolucaoJB.execute}
{"resultado":"${frd_faturamento_rec_devolucaoJB.msg}"}
