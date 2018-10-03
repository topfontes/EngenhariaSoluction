<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plr_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plr_planilha_recebimentoConsultJB" scope="request"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plr_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plr_planilha_permutaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${plr_planilha_permutaJB.list}" var="item">
     ,{	"plr_nr_id":"${item.plr_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plr_nr_mes_ref":"${item.plr_nr_mes_ref}"
 ,	"plr_nr_ano_ref":"${item.plr_nr_ano_ref}"
 ,	"plr_nr_mes":"${item.plr_nr_mes}"
 ,	"plr_nr_ano":"${item.plr_nr_ano}"
 ,	"plr_nr_efetuado_pj":"${item.plr_nr_efetuado_pj}"
 ,	"plr_nr_realizado_pf":"${item.plr_nr_realizado_pf}"
 ,	"plr_nr_realizado_pou":"${item.plr_nr_realizado_pou}"
  }
</c:forEach>
]}                                                                                
   
