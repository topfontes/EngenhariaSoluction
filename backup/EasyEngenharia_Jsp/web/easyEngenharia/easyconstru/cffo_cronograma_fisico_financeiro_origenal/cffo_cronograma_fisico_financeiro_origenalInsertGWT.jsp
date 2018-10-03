<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cffo_cronograma_fisico_financeiro_origenalJB" class="br.com.easynet.gwt.easyportal.jb.Cffo_cronograma_fisico_financeiro_origenalInsertJB" scope="request"/>
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="*"/>
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="page" value="${pageContext}"/>
${cffo_cronograma_fisico_financeiro_origenalJB.execute}
{"resultado":"${cffo_cronograma_fisico_financeiro_origenalJB.msg}"}
