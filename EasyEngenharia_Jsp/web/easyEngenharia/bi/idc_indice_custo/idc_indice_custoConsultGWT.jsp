<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="idc_indice_custoJB" class="br.com.easynet.gwt.easyportal.jb.Idc_indice_custoConsultJB" scope="request"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="*"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="page" value="${pageContext}"/>                                         
${idc_indice_custoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${idc_indice_custoJB.list}" var="item">
     ,{	"idc_nr_id":"${item.idc_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"subClasse":"${item.subClasse}"
 ,	"classe":"${item.classe}"
 ,	"idc_nr_mes":"${item.idc_nr_mes}"
 ,	"idc_nr_ano":"${item.idc_nr_ano}"
 ,	"plc_nr_id":"${item.plc_nr_id}"
 ,	"plc_nr_id_super":"${item.plc_nr_id_super}"
 ,	"idc_nr_ic_atual":"${item.idc_nr_ic_atual}"
 ,	"idc_nr_ic_projetado":"${item.idc_nr_ic_projetado}"
 ,	"idc_nr_projetado_empreendimento":"${item.idc_nr_projetado_empreendimento}"
  }
</c:forEach>
]}                                                                                
   
