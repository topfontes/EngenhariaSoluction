<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_insumo_plc_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_insumo_plc_pmsUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_insumo_plc_pmsJB.execute}                                         
{"resultado":
{"msg":"${vw_insumo_plc_pmsJB.msg}",
     "vw_insumo_plc_pms":{	"obr_nr_id":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.obr_nr_id}"
 ,	"plc_nr_id_super":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_nr_id_super}"
 ,	"plc_tx_nome_super":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_tx_nome_super}"
 ,	"plc_nr_id":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_nr_id}"
 ,	"plc_tx_nome":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_tx_nome}"
 ,	"ipo_nr_vl_unitario":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.ipo_nr_vl_unitario}"
 ,	"pms_nr_mes":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.pms_nr_mes}"
 ,	"pms_nr_ano":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.pms_nr_ano}"
 ,	"plco_nr_id":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plco_nr_id}"
 ,	"perc":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.perc}"
 ,	"vl_total":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.vl_total}"
 ,	"vl_executado":"${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.vl_executado}"
  }
    }
     
}                                                                                
   
