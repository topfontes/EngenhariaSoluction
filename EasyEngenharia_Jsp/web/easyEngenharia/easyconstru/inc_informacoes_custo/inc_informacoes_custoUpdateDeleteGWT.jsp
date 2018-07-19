<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inc_informacoes_custoJB" class="br.com.easynet.gwt.easyportal.jb.Inc_informacoes_custoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="*"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="page" value="${pageContext}"/>                                         
${inc_informacoes_custoJB.execute}                                         
{"resultado":
{"msg":"${inc_informacoes_custoJB.msg}",
     "inc_informacoes_custo":{	"inc_nr_id":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_id}"
 ,	"obr_nr_id":"${inc_informacoes_custoJB.inc_informacoes_custoT.obr_nr_id}"
 ,	"inc_nes_nr_id":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nes_nr_id}"
 ,	"inc_nr_ano":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_ano}"
 ,	"plc_nr_id":"${inc_informacoes_custoJB.inc_informacoes_custoT.plc_nr_id}"
 ,	"inc_tx_custo_acumulado":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_custo_acumulado}"
 ,	"inc_nr_custo_periodo":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_custo_periodo}"
 ,	"inc_tx_calsas":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_calsas}"
 ,	"inc_tx_problemas":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_problemas}"
 ,	"inc_tx_acoes":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_acoes}"
 ,	"inc_tx_responsavel":"${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_responsavel}"
 ,	"inc_dt_prazo":"<fmt:formatDate value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_dt_prazo}" pattern="dd/MM/yyyy"/>"
  }
    }
     
}                                                                                
   
