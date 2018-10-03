<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="inp_indicador_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Inp_indicador_planejamentoInsertJB" scope="request"/>
<jsp:setProperty name="inp_indicador_planejamentoJB" property="*"/>
<jsp:setProperty name="inp_indicador_planejamentoJB" property="page" value="${pageContext}"/>
${inp_indicador_planejamentoJB.execute}
{"resultado":"${inp_indicador_planejamentoJB.msg}"}
