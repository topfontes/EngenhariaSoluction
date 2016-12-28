<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fat_fatorJB" class="br.com.easynet.gwt.easyportal.jb.Fat_fatorConsultJB" scope="request"/>                                         
<jsp:setProperty name="fat_fatorJB" property="*"/>                                         
<jsp:setProperty name="fat_fatorJB" property="page" value="${pageContext}"/>                                         
${fat_fatorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${fat_fatorJB.list}" var="item">
     ,{	"fat_nr_id":"${item.fat_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"fat_nr_fator_atual":"${item.fat_nr_fator_atual}"
 ,	"fat_nr_fator_projetado":"${item.fat_nr_fator_projetado}"
 ,	"fat_nr_mes":"${item.fat_nr_mes}"
 ,	"fat_nr_ano":"${item.fat_nr_ano}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
  }
</c:forEach>
]}                                                                                
   
