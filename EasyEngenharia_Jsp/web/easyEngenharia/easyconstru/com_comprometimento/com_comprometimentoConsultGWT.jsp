<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="com_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Com_comprometimentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${com_comprometimentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${com_comprometimentoJB.list}" var="item">
     ,{	"com_nr_id":"${item.com_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"com_nr_valor":"${item.com_nr_valor}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"com_nr_mes":"${item.com_nr_mes}"
 ,	"com_nr_ano":"${item.com_nr_ano}"
  }
</c:forEach>
]}                                                                                
   
