<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="car_carroJB" class="br.com.easynet.gwt.easyportal.jb.Car_carroInsertJB" scope="request"/>
<jsp:setProperty name="car_carroJB" property="*"/>
<jsp:setProperty name="car_carroJB" property="page" value="${pageContext}"/>
${car_carroJB.execute}
{"resultado":"${car_carroJB.msg}"}
