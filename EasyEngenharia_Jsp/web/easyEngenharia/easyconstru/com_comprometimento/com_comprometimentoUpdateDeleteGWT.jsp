<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="com_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Com_comprometimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${com_comprometimentoJB.execute}                                         
{"resultado":"${com_comprometimentoJB.msg}"}
     
                                                                                
   
