<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroConsultJB" scope="request"/>                                         
<jsp:setProperty name="car_carroJB" property="*"/>                                         
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>                                         
${car_carroJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${car_carroJB.list}" var="item">
     ,{	"car_nr_id":"${item.car_nr_id}"
 ,	"car_tx_nome":"${item.car_tx_nome}"
 ,	"car_tx_marca":"${item.car_tx_marca}"
  }
</c:forEach>
]}                                                                                
   
