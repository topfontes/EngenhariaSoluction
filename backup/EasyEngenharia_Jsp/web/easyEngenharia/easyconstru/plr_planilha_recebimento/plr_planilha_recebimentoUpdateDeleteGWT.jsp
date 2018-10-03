<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plr_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plr_planilha_recebimentoUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plr_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plr_planilha_permutaJB.execute}                                         
{"resultado":
{"msg":"${plr_planilha_permutaJB.msg}",
     "plr_planilha_permuta":{	"plr_nr_id":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_id}"
 ,	"obr_nr_id":"${plr_planilha_permutaJB.plr_planilha_permutaT.obr_nr_id}"
 ,	"plr_nr_mes_ref":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_mes_ref}"
 ,	"plr_nr_ano_ref":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_ano_ref}"
 ,	"plr_nr_mes":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_mes}"
 ,	"plr_nr_ano":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_ano}"
 ,	"plr_nr_efetuado_pj":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_efetuado_pj}"
 ,	"plr_nr_realizado_pf":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_realizado_pf}"
 ,	"plr_nr_realizado_pou":"${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_realizado_pou}"
  }
    }
     
}                                                                                
   
