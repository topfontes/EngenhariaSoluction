<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ipo_item_plano_contas_obraJB" class="br.com.easynet.gwt.easyportal.jb.Ipo_item_plano_contas_obraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="*"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="page" value="${pageContext}"/>                                         
${ipo_item_plano_contas_obraJB.execute}                                         
{"resultado":
{"msg":"${ipo_item_plano_contas_obraJB.msg}",
     "ipo_item_plano_contas_obra":{	"ipo_nr_id":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_id}"
 ,	"ipo_nr_quantidade":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_quantidade}"
 ,	"ipo_nr_vl_unitario":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_vl_unitario}"
 ,	"ipo_nr_vl_total":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_vl_total}"
 ,	"obr_nr_id":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.obr_nr_id}"
 ,	"plco_nr_id":"${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.plco_nr_id}"
  }
    }
     
}                                                                                
   
