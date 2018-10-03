<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="car_carroJB" property="*"/>                                         
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>                                         
${car_carroJB.execute}                                         
{"resultado":
{"msg":"${car_carroJB.msg}",
     "car_carro":{	"car_nr_id":"${car_carroJB.car_carroT.car_nr_id}"
 ,	"car_tx_nome":"${car_carroJB.car_carroT.car_tx_nome}"
 ,	"car_tx_marca":"${car_carroJB.car_carroT.car_tx_marca}"
  }
    }
     
}                                                                                
   
