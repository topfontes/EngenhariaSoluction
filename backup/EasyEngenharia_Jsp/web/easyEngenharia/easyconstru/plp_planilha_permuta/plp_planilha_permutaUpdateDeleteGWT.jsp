<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plp_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plp_planilha_permutaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plp_planilha_permutaJB.execute}                                         
{"resultado":
{"msg":"${plp_planilha_permutaJB.msg}",
     "plp_planilha_permuta":{	"plp_nr_id":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_id}"
 ,	"obr_nr_id":"${plp_planilha_permutaJB.plp_planilha_permutaT.obr_nr_id}"
 ,	"plp_nr_mes_ref":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_mes_ref}"
 ,	"plp_nr_ano_ref":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_ano_ref}"
 ,	"plp_nr_mes":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_mes}"
 ,	"plp_nr_ano":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_ano}"
 ,	"plp_nr_previsto":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_previsto}"
 ,	"plp_nr_realizado":"${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_realizado}"
  }
    }
     
}                                                                                
   
