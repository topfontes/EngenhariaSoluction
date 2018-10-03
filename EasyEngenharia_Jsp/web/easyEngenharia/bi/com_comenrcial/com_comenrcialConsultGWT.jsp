<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="com_comenrcialJB" class="br.com.easynet.gwt.easyportal.jb.Com_comenrcialConsultJB" scope="request"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="*"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="page" value="${pageContext}"/>                                         
${com_comenrcialJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${com_comenrcialJB.list}" var="item">
     ,{	"com_nr_id":"${item.com_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"com_nr_mes":"${item.com_nr_mes}"
 ,	"com_nr_ano":"${item.com_nr_ano}"
 ,	"cen_nr_id":"${item.cen_nr_id}"
 ,	"com_tx_etapa":"${item.com_tx_etapa}"
 ,	"com_nr_unidade_med_acum":"${item.com_nr_unidade_med_acum}"
 ,	"com_nr_preco_medio_und_vendida":"${item.com_nr_preco_medio_und_vendida}"
 ,	"com_nr_unidade_a_vender":"${item.com_nr_unidade_a_vender}"
 ,	"com_nr_preco_medio_unid_a_vender":"${item.com_nr_preco_medio_unid_a_vender}"
 ,	"com_nr_recebimento_acumulado_pj":"${item.com_nr_recebimento_acumulado_pj}"
 ,	"com_nr_recebimento_acumulado_pf":"${item.com_nr_recebimento_acumulado_pf}"
 ,	"com_nr_recebimento_acumulado_poupanca":"${item.com_nr_recebimento_acumulado_poupanca}"
 ,	"com_nr_recebimento_acumulado_aporte":"${item.com_nr_recebimento_acumulado_aporte}"
 ,	"com_nr_inadimplencia":"${item.com_nr_inadimplencia}"
 ,	"com_nr_vgv_atualizado":"${item.com_nr_vgv_atualizado}"
 ,	"com_nr_vgv_original":"${item.com_nr_vgv_original}"
 ,	"com_nr_recebimento_total":"${item.com_nr_recebimento_total}"
  }
</c:forEach>
]}                                                                                
   
