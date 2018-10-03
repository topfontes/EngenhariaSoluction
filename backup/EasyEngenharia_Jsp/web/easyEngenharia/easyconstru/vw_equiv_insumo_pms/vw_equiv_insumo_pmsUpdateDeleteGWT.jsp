<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_equiv_insumo_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equiv_insumo_pmsUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_equiv_insumo_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_equiv_insumo_pmsJB.execute}                                         
{"resultado":
{"msg":"${vw_equiv_insumo_pmsJB.msg}",
     "vw_equiv_insumo_pms":{	"obr_nr_id":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.obr_nr_id}"
 ,	"plc_nr_id":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.plc_nr_id}"
 ,	"plc_tx_nome":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.plc_tx_nome}"
 ,	"insumo":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.insumo}"
 ,	"ipo_nr_vl_unitario":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.ipo_nr_vl_unitario}"
 ,	"pms_nr_mes":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.pms_nr_mes}"
 ,	"pms_nr_ano":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.pms_nr_ano}"
 ,	"plco_nr_id":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.plco_nr_id}"
 ,	"perc":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.perc}"
 ,	"vl_total":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.vl_total}"
 ,	"vl_executado":"${vw_equiv_insumo_pmsJB.vw_equiv_insumo_pmsT.vl_executado}"
  }
    }
     
}                                                                                
   
