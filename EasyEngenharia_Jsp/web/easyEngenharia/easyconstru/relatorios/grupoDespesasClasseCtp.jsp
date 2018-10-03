<jsp:useBean id="despCtpJB" class="br.com.easynet.gwt.easyportal.relatorios.GrupoDespesasClasseCtp.GrupoDespesasClasseCtpREL" scope="request"/>
<jsp:setProperty name="despCtpJB" property="*"/>
<jsp:setProperty name="despCtpJB" property="page" value="${pageContext}"/>
${despCtpJB.execute}
