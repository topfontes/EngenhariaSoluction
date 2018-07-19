<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="nassalJB" class="br.com.easynet.gwt.easyportal.jb.ImportacaoOrcNassalJB" scope="request"/>
<jsp:setProperty name="nassalJB" property="*"/>
<jsp:setProperty name="nassalJB" property="page" value="${pageContext}"/>
${nassalJB.execute}
{"resultado":[
   {"registro":"${nassalJB.quantidadeImportados}"}
   ,{"status":"${nassalJB.status}"}

]}

