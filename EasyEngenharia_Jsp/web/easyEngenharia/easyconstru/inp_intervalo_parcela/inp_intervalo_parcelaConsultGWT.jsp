<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaConsultJB" scope="request"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>                                         
${inp_intervalo_parcelaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${inp_intervalo_parcelaJB.list}" var="item">
     ,{	"inp_nr_id":"${item.inp_nr_id}"
 ,	"par_nr_id":"${item.par_nr_id}"
 ,	"inp_nr_dias":"${item.inp_nr_dias}"
 ,	"inp_nr_per":"${item.inp_nr_per}"
  ,	"inp_nr_sequencia":"${item.inp_nr_sequencia}"
  }
</c:forEach>
]}                                                                                
   
