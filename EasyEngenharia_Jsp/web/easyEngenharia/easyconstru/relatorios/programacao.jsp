<jsp:useBean id="programacao" class="br.com.easynet.gwt.easyportal.relatorios.programacao.Programacao" scope="request"/>
<jsp:setProperty name="programacao" property="*"/>
<jsp:setProperty name="programacao" property="page" value="${pageContext}"/>
${programacao.execute}