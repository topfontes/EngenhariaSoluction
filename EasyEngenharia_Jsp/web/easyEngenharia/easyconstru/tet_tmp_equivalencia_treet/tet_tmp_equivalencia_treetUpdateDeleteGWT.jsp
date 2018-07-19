<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>                                         
${tet_tmp_equivalencia_treetJB.execute}                                         
{"resultado":
{"msg":"${tet_tmp_equivalencia_treetJB.msg}",
     "tet_tmp_equivalencia_treet":{	"tet_nr_id":"${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.tet_nr_id}"
 ,	"plco_nr_id":"${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plco_nr_id}"
 ,	"plc_nr_id":"${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plc_nr_id}"
 ,	"plco_tx_nome":"${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plco_tx_nome}"
 ,	"plc_tx_nome":"${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plc_tx_nome}"
  }
    }
     
}                                                                                
   
