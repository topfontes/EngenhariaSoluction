<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.ImportacaoOrcamentoJB" scope="request"/>
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>
${plco_plano_contas_orcamentoJB.execute}
{"resultado":[
   {"registro":"${plco_plano_contas_orcamentoJB.quantidadeImportados}"}
   ,{"status":"${plco_plano_contas_orcamentoJB.status}"}

]}
