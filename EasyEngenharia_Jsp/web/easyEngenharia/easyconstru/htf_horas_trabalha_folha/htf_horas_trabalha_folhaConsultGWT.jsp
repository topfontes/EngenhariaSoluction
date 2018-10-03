<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="htf_horas_trabalha_folhaJB" class="br.com.easynet.gwt.easyportal.jb.Htf_horas_trabalha_folhaConsultJB" scope="request"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="*"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="page" value="${pageContext}"/>                                         
${htf_horas_trabalha_folhaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${htf_horas_trabalha_folhaJB.list}" var="item">
     ,{	"htf_nr_id":"${item.htf_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"htf_nr_mes":"${item.htf_nr_mes}"
 ,	"htf_nr_ano":"${item.htf_nr_ano}"
 ,	"htf_nr_horas_trabalhada":"${item.htf_nr_horas_trabalhada}"
  }
</c:forEach>
]}                                                                                
   
