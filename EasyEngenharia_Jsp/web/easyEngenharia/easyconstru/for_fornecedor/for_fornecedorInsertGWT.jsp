<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.easyportal.jb.For_fornecedorInsertJB" scope="request"/>
<jsp:setProperty name="for_fornecedorJB" property="*"/>
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>
${for_fornecedorJB.execute}
{"resultado":[{"msg":"${for_fornecedorJB.msg}"},{"id":"${for_fornecedorJB.for_nr_id}"}]}
