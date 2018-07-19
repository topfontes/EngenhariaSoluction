<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ort_orcamento_temporarioJB" class="br.com.easynet.gwt.easyportal.jb.Ort_orcamento_temporarioConsultJB" scope="request"/>                                         
<jsp:setProperty name="ort_orcamento_temporarioJB" property="*"/>                                         
<jsp:setProperty name="ort_orcamento_temporarioJB" property="page" value="${pageContext}"/>                                         
${ort_orcamento_temporarioJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ort_orcamento_temporarioJB.list}" var="item">
     ,{	"ort_nr_id":"${item.ort_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"con_nr_id":"${item.con_nr_id}"
 ,	"coa_nr_id":"${item.coa_nr_id}"
 ,	"ort_nr_quantidade":"${item.ort_nr_quantidade}"
 ,	"ort_tx_letra":"${item.ort_tx_letra}"
  }
</c:forEach>
]}                                                                                
   
