<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ipo_item_plano_contas_obraJB" class="br.com.easynet.gwt.easyportal.jb.Ipo_item_plano_contas_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="*"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="page" value="${pageContext}"/>                                         
${ipo_item_plano_contas_obraJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${ipo_item_plano_contas_obraJB.list}" var="item">
     ,{	"ipo_nr_id":"${item.ipo_nr_id}"
 ,	"ipo_nr_quantidade":"${item.ipo_nr_quantidade}"
 ,	"ipo_nr_vl_unitario":"${item.ipo_nr_vl_unitario}"
 ,	"ipo_nr_vl_total":"${item.ipo_nr_vl_total}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
  }
</c:forEach>
]}                                                                                
   
