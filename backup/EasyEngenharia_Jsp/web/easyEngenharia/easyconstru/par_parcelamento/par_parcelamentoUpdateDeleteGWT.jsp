<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="par_parcelamentoJB" class="br.com.easynet.gwt.easyportal.jb.Par_parcelamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="*"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="page" value="${pageContext}"/>                                         
${par_parcelamentoJB.execute}                                         
{"resultado":"${par_parcelamentoJB.msg}"}
   
