<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="eqc_equivalencia_composicaoJB" class="br.com.easynet.gwt.easyportal.jb.Eqc_equivalencia_composicaoInsertJB" scope="request"/>
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="*"/>
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="page" value="${pageContext}"/>
${eqc_equivalencia_composicaoJB.execute}
{"resultado":"${eqc_equivalencia_composicaoJB.msg}"}
