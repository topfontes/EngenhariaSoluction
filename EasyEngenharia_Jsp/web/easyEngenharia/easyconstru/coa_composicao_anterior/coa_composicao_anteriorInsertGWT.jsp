<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="coa_composicao_anteriorJB" class="br.com.easynet.gwt.easyportal.jb.Coa_composicao_anteriorInsertJB" scope="request"/>
<jsp:setProperty name="coa_composicao_anteriorJB" property="*"/>
<jsp:setProperty name="coa_composicao_anteriorJB" property="page" value="${pageContext}"/>
${coa_composicao_anteriorJB.execute}
{"resultado":"${coa_composicao_anteriorJB.msg}"}
