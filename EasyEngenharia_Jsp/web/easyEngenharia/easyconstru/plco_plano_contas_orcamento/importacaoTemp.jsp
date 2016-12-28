<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="orcJB" class="br.com.easynet.gwt.easyportal.jb.ImportacaoOrcTemp" scope="request"/>
<jsp:setProperty name="orcJB" property="*"/>
<jsp:setProperty name="orcJB" property="page" value="${pageContext}"/>
<% System.out.println(" passou ");%>
${orcJB.execute}
{"resultado":[
   {"registro":"${orcJB.quantidadeImportados}"}
   ,{"status":"${orcJB.status}"}

]}
