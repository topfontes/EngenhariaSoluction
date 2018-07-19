<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="com_comenrcialJB" class="br.com.easynet.gwt.easyportal.jb.Com_comenrcialUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="*"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="page" value="${pageContext}"/>                                         
${com_comenrcialJB.execute}                                         
{"resultado":
{"msg":"${com_comenrcialJB.msg}",
     "com_comenrcial":{	"com_nr_id":"${com_comenrcialJB.com_comenrcialT.com_nr_id}"
 ,	"obr_nr_id":"${com_comenrcialJB.com_comenrcialT.obr_nr_id}"
 ,	"com_nr_mes":"${com_comenrcialJB.com_comenrcialT.com_nr_mes}"
 ,	"com_nr_ano":"${com_comenrcialJB.com_comenrcialT.com_nr_ano}"
 ,	"cen_nr_id":"${com_comenrcialJB.com_comenrcialT.cen_nr_id}"
 ,	"com_tx_etapa":"${com_comenrcialJB.com_comenrcialT.com_tx_etapa}"
 ,	"com_nr_unidade_med_acum":"${com_comenrcialJB.com_comenrcialT.com_nr_unidade_med_acum}"
 ,	"com_nr_preco_medio_und_vendida":"${com_comenrcialJB.com_comenrcialT.com_nr_preco_medio_und_vendida}"
 ,	"com_nr_unidade_a_vender":"${com_comenrcialJB.com_comenrcialT.com_nr_unidade_a_vender}"
 ,	"com_nr_preco_medio_unid_a_vender":"${com_comenrcialJB.com_comenrcialT.com_nr_preco_medio_unid_a_vender}"
 ,	"com_nr_recebimento_acumulado_pj":"${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_pj}"
 ,	"com_nr_recebimento_acumulado_pf":"${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_pf}"
 ,	"com_nr_recebimento_acumulado_poupanca":"${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_poupanca}"
 ,	"com_nr_recebimento_acumulado_aporte":"${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_aporte}"
 ,	"com_nr_inadimplencia":"${com_comenrcialJB.com_comenrcialT.com_nr_inadimplencia}"
 ,	"com_nr_vgv_atualizado":"${com_comenrcialJB.com_comenrcialT.com_nr_vgv_atualizado}"
 ,	"com_nr_vgv_original":"${com_comenrcialJB.com_comenrcialT.com_nr_vgv_original}"
 ,	"com_nr_recebimento_total":"${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_total}"
  }
    }
     
}                                                                                
   
