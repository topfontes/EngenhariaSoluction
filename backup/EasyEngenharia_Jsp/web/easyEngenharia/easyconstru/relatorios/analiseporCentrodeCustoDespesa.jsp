<jsp:useBean id="custoDespesa" class="br.com.easynet.gwt.easyportal.relatorios.analiseporCentrodeCustoDespesa.AnaliseporCentrodeCustoDespesaREL" scope="request"/>
<jsp:setProperty name="custoDespesa" property="*"/>
<jsp:setProperty name="custoDespesa" property="page" value="${pageContext}"/>
${custoDespesa.execute}
