<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="est_estoqueJB" class="br.com.easynet.gwt.easyportal.jb.Est_estoqueConsultJB" scope="request"/>                                         
<jsp:setProperty name="est_estoqueJB" property="*"/>                                         
<jsp:setProperty name="est_estoqueJB" property="page" value="${pageContext}"/>                                         
${est_estoqueJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${est_estoqueJB.ds.list}" var="item">
     ,{	"est_nr_id":"${item.row[0].value}"
 ,	"est_nr_mes":"${item.row[1].value}"
 ,	"plc_nr_id":"${item.row[2].value}"
 ,	"est_nr_quantidade":"${item.row[3].value}"
 ,	"est_nr_vl_unitario":"${item.row[4].value}"
 ,	"est_nr_vl_total":"${item.row[5].value}"
  ,	"obr_nr_id":"${item.row[6].value}"
 ,	"plc_tx_nome":"${item.row[7].value}"
 ,	"est_nr_ano":"${item.row[8].value}"
 ,	"est_tx_unidade":"${item.row[9].value}"
 ,	"est_tx_nome":"${item.row[10].value}"
  }
</c:forEach>
]}