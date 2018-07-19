<jsp:useBean id="estoque" class="br.com.easynet.gwt.easyportal.relatorios.estoquesubclasse.EstoqueSubClasseREL" scope="request"/>
<jsp:setProperty name="estoque" property="*"/>
<jsp:setProperty name="estoque" property="page" value="${pageContext}"/>
${estoque.execute}
