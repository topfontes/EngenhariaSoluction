<jsp:useBean id="pms" class="br.com.easynet.gwt.easyportal.relatorios.pms.Pms_REL" scope="request"/>
<jsp:setProperty name="pms" property="*"/>
<jsp:setProperty name="pms" property="page" value="${pageContext}"/>
${pms.execute}