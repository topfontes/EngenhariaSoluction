<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_importacao_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="page" value="${pageContext}"/>                                         
${vw_importacao_orcamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_importacao_orcamentoJB.list}" var="item">
     ,{	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"plco_tx_tipo":"${item.plco_tx_tipo}"
 ,	"plco_tx_unidade":"${item.plco_tx_unidade}"
 ,	"ipo_nr_quantidade":"${item.ipo_nr_quantidade}"
 ,	"ipo_nr_vl_unitario":"${item.ipo_nr_vl_unitario}"
 ,	"ipo_nr_vl_total":"${item.ipo_nr_vl_total}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"ipo_plc_nr_id_servico":"${item.ipo_plc_nr_id_servico}"
 ,	"plco_tx_cod_externo":"${item.plco_tx_cod_externo}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plco_nr_nivel":"${item.plco_nr_nivel}"
 ,	"ipo_nr_id":"${item.ipo_nr_id}"
  }
</c:forEach>
]}                                                                                
   
