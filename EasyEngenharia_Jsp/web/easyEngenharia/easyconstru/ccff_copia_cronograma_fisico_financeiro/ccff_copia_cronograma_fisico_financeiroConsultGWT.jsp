<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroConsultJB" scope="request"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>                                         
${ccff_copia_cronograma_fisico_financeiroJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ccff_copia_cronograma_fisico_financeiroJB.list}" var="item">
     ,{	"ccff_nr_id":"${item.ccff_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"ccff_nr_peso":"${item.ccff_nr_peso}"
 ,	"ccff_nr_mes":"${item.ccff_nr_mes}"
 ,	"ccff_nr_ano":"${item.ccff_nr_ano}"
 ,	"ccff_nr_quantidade":"${item.ccff_nr_quantidade}"
 ,	"ccff_nr_valor":"${item.ccff_nr_valor}"
  ,	"ipo_nr_id_super":"${item.ipo_nr_id_super}"
  ,	"ipo_nr_id":"${item.ipo_nr_id}"
  }
</c:forEach>
]}                                                                                
   
