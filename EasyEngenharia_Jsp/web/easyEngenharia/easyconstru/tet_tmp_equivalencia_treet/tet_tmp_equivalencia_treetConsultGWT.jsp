<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetConsultJB" scope="request"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>                                         
${tet_tmp_equivalencia_treetJB.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tet_tmp_equivalencia_treetJB.list}" var="item">
     ,{	"tet_nr_id":"${item.tet_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"plc_tx_nome":"${item.plc_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
