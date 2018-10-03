<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="correcao" class="br.com.easynet.gwt.easyportal.jb.Correcao" scope="request"/>
<jsp:setProperty name="correcao" property="*"/>
<jsp:setProperty name="correcao" property="page" value="${pageContext}"/>
${correcao.execute}
{"resultado":[
   {"registro":"${correcao.quantidadeImportados}"}
   ,{"status":"${correcao.status}"}

]}