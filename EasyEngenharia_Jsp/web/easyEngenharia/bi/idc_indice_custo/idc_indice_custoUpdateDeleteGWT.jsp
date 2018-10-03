<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="idc_indice_custoJB" class="br.com.easynet.gwt.easyportal.jb.Idc_indice_custoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="*"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="page" value="${pageContext}"/>                                         
${idc_indice_custoJB.execute}                                         
{"resultado":
{"msg":"${idc_indice_custoJB.msg}",
     "idc_indice_custo":{	"idc_nr_id":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_id}"
 ,	"obr_nr_id":"${idc_indice_custoJB.idc_indice_custoT.obr_nr_id}"
 ,	"subClasse":"${item.subClasse}"
 ,	"idc_nr_mes":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_mes}"
 ,	"idc_nr_ano":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_ano}"
 ,	"plc_nr_id":"${idc_indice_custoJB.idc_indice_custoT.plc_nr_id}"
 ,	"idc_nr_ic_atual":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_ic_atual}"
 ,	"idc_nr_ic_projetado":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_ic_projetado}"
 ,	"idc_nr_projetado_empreendimento":"${idc_indice_custoJB.idc_indice_custoT.idc_nr_projetado_empreendimento}"
  }
    }
     
}                                                                                
   
