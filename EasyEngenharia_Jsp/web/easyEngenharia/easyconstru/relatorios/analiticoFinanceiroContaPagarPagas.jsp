<jsp:useBean id="ctpJB" class="br.com.easynet.gwt.easyportal.relatorios.analiticofinaceirocontapagar.AnaliticoFinaceiroContaPagarPagas" scope="request"/>
<jsp:setProperty name="ctpJB" property="*"/>
<jsp:setProperty name="ctpJB" property="page" value="${pageContext}"/>
${ctpJB.execute}
