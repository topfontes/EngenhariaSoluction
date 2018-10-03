<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaInsertJB" scope="request"/>
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>
${inp_intervalo_parcelaJB.execute}
{"resultado":"${inp_intervalo_parcelaJB.msg}"}
