<jsp:useBean id="planilha" class="br.com.easynet.gwt.easyportal.relatorios.planilhahh.PlanilhahhREL" scope="request"/>
<jsp:setProperty name="planilha" property="*"/>
<jsp:setProperty name="planilha" property="page" value="${pageContext}"/>
${planilha.execute}
