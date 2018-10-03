<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="infe_item_nota_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Infe_item_nota_entradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="*"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="page" value="${pageContext}"/>                                         
${infe_item_nota_entradaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${infe_item_nota_entradaJB.list}" var="item">
     ,{	"infe_nr_id":"${item.infe_nr_id}"
 ,	"infe_nr_quantidade":"${item.infe_nr_quantidade}"
 ,	"infe_nr_valor_unit":"${item.infe_nr_valor_unit}"
 ,	"infe_nr_valor_total":"${item.infe_nr_valor_total}"
 ,	"nfe_nr_id":"${item.nfe_nr_id}"
 ,	"pro_nr_id":"${item.pro_nr_id}"
  }
</c:forEach>
]}                                                                                
   
