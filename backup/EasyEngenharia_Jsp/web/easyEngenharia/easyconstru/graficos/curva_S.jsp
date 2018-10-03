<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="curva_S" class="br.com.easynet.gwt.easyportal.grafico.curva_S.Curva_S" scope="request"/>
<jsp:setProperty name="curva_S" property="*"/>
<jsp:setProperty name="curva_S" property="page" value="${pageContext}"/>
${curva_S.execute}
