<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_equiv_insumo_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equiv_insumo_pmsConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_equiv_insumo_pmsJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${vw_equiv_insumo_pmsJB.list}" var="item">
     ,{	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plc_tx_nome":"${item.plc_tx_nome}"
 ,	"insumo":"${item.insumo}"
 ,	"ipo_nr_vl_unitario":"${item.ipo_nr_vl_unitario}"
 ,	"pms_nr_mes":"${item.pms_nr_mes}"
 ,	"pms_nr_ano":"${item.pms_nr_ano}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"vl_executado":"${item.vl_executado}"
  }
</c:forEach>
]}                                                                                
   
