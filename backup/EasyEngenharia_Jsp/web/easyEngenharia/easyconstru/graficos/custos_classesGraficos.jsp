<jsp:useBean id="classe" class="br.com.easynet.gwt.easyportal.grafico.custo_classes.Custo_classesGrafico" scope="request"/>
<jsp:setProperty name="classe" property="*"/>
<jsp:setProperty name="classe" property="page" value="${pageContext}"/>
${classe.execute}
