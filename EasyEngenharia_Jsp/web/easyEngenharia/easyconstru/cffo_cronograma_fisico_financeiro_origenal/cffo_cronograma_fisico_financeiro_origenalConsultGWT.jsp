<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="cffo_cronograma_fisico_financeiro_origenalJB" class="br.com.easynet.gwt.easyportal.jb.Cffo_cronograma_fisico_financeiro_origenalConsultJB" scope="request"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="*"/>
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="page" value="${pageContext}"/>
${cffo_cronograma_fisico_financeiro_origenalJB.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${cffo_cronograma_fisico_financeiro_origenalJB.list}" var="item">
     ,{	"cffo_nr_id":"${item.cffo_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"cffo_nr_peso":"${item.cffo_nr_peso}"
 ,	"cffo_nr_mes":"${item.cffo_nr_mes}"
 ,	"cffo_nr_ano":"${item.cffo_nr_ano}"
  ,	"ipo_nr_id_super":"${item.ipo_nr_id_super}"
  ,	"ipo_nr_id":"${item.ipo_nr_id}"
  }
</c:forEach>
]}                                                                                
   
