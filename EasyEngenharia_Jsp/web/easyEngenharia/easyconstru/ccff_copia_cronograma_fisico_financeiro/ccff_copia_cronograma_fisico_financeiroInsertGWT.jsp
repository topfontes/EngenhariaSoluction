<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroInsertJB" scope="request"/>
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>
${ccff_copia_cronograma_fisico_financeiroJB.execute}
{"resultado":"${ccff_copia_cronograma_fisico_financeiroJB.msg}"}
