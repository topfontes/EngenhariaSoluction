<jsp:useBean id="custo" class="br.com.easynet.gwt.easyportal.relatorios.custo_classe_regime_competencia.CustoClasseRegimeCompetencia" scope="request"/>
<jsp:setProperty name="custo" property="*"/>
<jsp:setProperty name="custo" property="page" value="${pageContext}"/>
${custo.execute}