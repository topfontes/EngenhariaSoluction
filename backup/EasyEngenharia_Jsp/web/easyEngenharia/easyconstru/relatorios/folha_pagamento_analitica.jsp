<jsp:useBean id="folhaJB" class="br.com.easynet.gwt.easyportal.relatorios.folha_pagamento.FolhaPagamentoAnaliticaREL" scope="request"/>
<jsp:setProperty name="folhaJB" property="*"/>
<jsp:setProperty name="folhaJB" property="page" value="${pageContext}"/>
${folhaJB.execute}
<!--{ "resultado":"$ {folhaJB.msg}"}-->

