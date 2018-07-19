<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="classe" class="br.com.easynet.gwt.easyportal.relatorios.classes_subclasses.Classe_SubClasses" scope="request"/>
<jsp:setProperty name="classe" property="*"/>
<jsp:setProperty name="classe" property="page" value="${pageContext}"/>
${classe.execute}
