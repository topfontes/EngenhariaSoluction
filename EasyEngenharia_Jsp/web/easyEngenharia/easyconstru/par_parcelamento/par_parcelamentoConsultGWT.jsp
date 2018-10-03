<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="par_parcelamentoJB" class="br.com.easynet.gwt.easyportal.jb.Par_parcelamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="*"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="page" value="${pageContext}"/>                                         
${par_parcelamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${par_parcelamentoJB.list}" var="item">
     ,{	"par_nr_id":"${item.par_nr_id}"
 ,	"par_tx_nome":"${item.par_tx_nome}"
 ,	"par_nr_parcelas":"${item.par_nr_parcelas}"
 ,	"par_nr_intervalo_dias":"${item.par_nr_intervalo_dias}"
  }
</c:forEach>
]}                                                                                
   
