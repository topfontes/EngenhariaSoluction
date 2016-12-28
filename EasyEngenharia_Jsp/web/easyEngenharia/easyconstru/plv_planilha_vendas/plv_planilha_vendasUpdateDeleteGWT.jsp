<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plv_planilha_vendasJB" class="br.com.easynet.gwt.easyportal.jb.Plv_planilha_vendasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="*"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="page" value="${pageContext}"/>                                         
${plv_planilha_vendasJB.execute}                                         
{"resultado":
{"msg":"${plv_planilha_vendasJB.msg}",
     "plv_planilha_vendas":{	"plv_nr_id":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_id}"
 ,	"obr_nr_id":"${plv_planilha_vendasJB.plv_planilha_vendasT.obr_nr_id}"
 ,	"plv_nr_mes_ref":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_mes_ref}"
 ,	"plv_nr_ano_ref":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_ano_ref}"
 ,	"plv_nr_mes":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_mes}"
 ,	"plv_nr_ano":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_ano}"
 ,	"plv_nr_previsto":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_previsto}"
 ,	"plv_nr_realizado":"${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_realizado}"
  }
    }
     
}                                                                                
   
