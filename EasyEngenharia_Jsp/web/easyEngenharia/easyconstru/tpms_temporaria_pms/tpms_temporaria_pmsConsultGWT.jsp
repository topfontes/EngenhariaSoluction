<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="tpms_temporaria_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Tpms_temporaria_pmsConsultJB" scope="request"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="*"/>                                         
<jsp:setProperty name="tpms_temporaria_pmsJB" property="page" value="${pageContext}"/>                                         
${tpms_temporaria_pmsJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tpms_temporaria_pmsJB.list}" var="item">
     ,{	"tmps_nr_id":"${item.tmps_nr_id}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"tpms_nr_quantidade":"${item.tpms_nr_quantidade}"
 ,	"tpms_bl_servico":"${item.tpms_bl_servico}"
 ,	"tpms_tx_conta":"${item.tpms_tx_conta}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"tpms_tx_codigo_externo":"${item.tpms_tx_codigo_externo}"
 ,	"tpms_tx_unidade":"${item.tpms_tx_unidade}"
 ,	"tpms_nr_quantidade_total":"${item.tpms_nr_quantidade_total}"
 ,	"tpms_nr_quantidade_acumulada_ant":"${item.tpms_nr_quantidade_acumulada_ant}"
 ,	"tpms_nr_quantidade_acumulada_atual":"${item.tpms_nr_quantidade_acumulada_atual}"
 ,	"tpms_nr_saldo":"${item.tpms_nr_saldo}"
 ,	"ipo_nr_id_super":"${item.ipo_nr_id_super}"
 ,	"ipo_nr_id":"${item.ipo_nr_id}"
 ,	"tpms_nr_percentAcumuladoMes":"${item.tpms_nr_percentAcumuladoMes}"
 ,	"tpms_nr_percentAcumuladoPeriodo":"${item.tpms_nr_percentAcumuladoPeriodo}"
 ,	"tpms_nr_percentSaldo":"${item.tpms_nr_percentSaldo}"
 ,	"tpms_nr_percentual":"${item.tpms_nr_percentual}"
  }
</c:forEach>
]}                                                                                
   
