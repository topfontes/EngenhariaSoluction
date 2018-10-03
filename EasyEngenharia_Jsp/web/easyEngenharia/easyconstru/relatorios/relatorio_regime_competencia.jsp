<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="regimecompetencia" class="br.com.easynet.gwt.easyportal.relatorios.cronograma_competencia.Rel_crono_regime_competencia" scope="request"/>
<jsp:setProperty name="regimecompetencia" property="*"/>
<jsp:setProperty name="regimecompetencia" property="page" value="${pageContext}"/>
${regimecompetencia.execute}
{"resultado":"${regimecompetencia.msg}"}
