<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plc_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Plc_plano_contasConsultJB" scope="request"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="page" value="${pageContext}"/>                                         
${plc_plano_contasJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
   
<c:forEach items="${plc_plano_contasJB.ds.list}" var="item">
     ,{	"plc_nr_id":"${item.row[0].value}"
 ,	"plc_tx_nome":"${item.row[1].value}"
 ,	"plc_nr_id_super":"${item.row[2].value}"
 ,	"plc_tx_caixa_banco":"${item.row[3].value}"
 ,	"cen_nr_id":"${item.row[4].value}"
 ,	"plc_tx_centro_custo":"${item.row[5].value}"
 ,	"plc_tx_super":"${item.row[6].value}"
,	"par_nr_id":"${item.row[7].value}"
,	"par_tx_nome":"${item.row[8].value}"
  }
</c:forEach>
]}                                                                                
   
