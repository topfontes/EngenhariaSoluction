<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Plco_plano_contas_orcamentoInsertJB" scope="request"/>
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>
${plco_plano_contas_orcamentoJB.execute}
{"resultado":[{"msg":"${plco_plano_contas_orcamentoJB.msg}"}
,{"id":"${plco_plano_contas_orcamentoJB.id}"}
]}
