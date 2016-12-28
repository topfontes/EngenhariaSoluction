<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_importacao_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="page" value="${pageContext}"/>                                         
${vw_importacao_orcamentoJB.execute}                                         
{"resultado":
{"msg":"${vw_importacao_orcamentoJB.msg}",
     "vw_importacao_orcamento":{	"plco_tx_nome":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_nome}"
 ,	"plco_tx_tipo":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_tipo}"
 ,	"plco_tx_unidade":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_unidade}"
 ,	"ipo_nr_quantidade":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_quantidade}"
 ,	"ipo_nr_vl_unitario":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_vl_unitario}"
 ,	"ipo_nr_vl_total":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_vl_total}"
 ,	"plco_nr_id":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_nr_id}"
 ,	"ipo_plc_nr_id_servico":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_plc_nr_id_servico}"
 ,	"plco_tx_cod_externo":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_cod_externo}"
 ,	"obr_nr_id":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.obr_nr_id}"
 ,	"plco_nr_nivel":"${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_nr_nivel}"
  }
    }
     
}                                                                                
   
