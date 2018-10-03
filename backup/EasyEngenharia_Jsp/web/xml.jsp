<jsp:useBean id="xmlJB" class="br.com.easynet.easyportal.XML.LerXML" scope="request"/>                                         
<jsp:setProperty name="xmlJB" property="*"/>                                         
<jsp:setProperty name="xmlJB" property="page" value="${pageContext}"/>                                         
${xmlJB.execute}    
{"resultado":"${xmlJB.msg}"}
