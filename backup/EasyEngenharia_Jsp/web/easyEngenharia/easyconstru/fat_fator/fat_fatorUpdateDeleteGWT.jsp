<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fat_fatorJB" class="br.com.easynet.gwt.easyportal.jb.Fat_fatorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fat_fatorJB" property="*"/>                                         
<jsp:setProperty name="fat_fatorJB" property="page" value="${pageContext}"/>                                         
${fat_fatorJB.execute}                                         
{"resultado":
{"msg":"${fat_fatorJB.msg}",
     "fat_fator":{	"fat_nr_id":"${fat_fatorJB.fat_fatorT.fat_nr_id}"
 ,	"plc_nr_id":"${fat_fatorJB.fat_fatorT.plc_nr_id}"
 ,	"fat_nr_fator_atual":"${fat_fatorJB.fat_fatorT.fat_nr_fator_atual}"
 ,	"fat_nr_fator_projetado":"${fat_fatorJB.fat_fatorT.fat_nr_fator_projetado}"
 ,	"fat_nr_mes":"${fat_fatorJB.fat_fatorT.fat_nr_mes}"
 ,	"fat_nr_ano":"${fat_fatorJB.fat_fatorT.fat_nr_ano}"
 ,	"obr_nr_id":"${fat_fatorJB.fat_fatorT.obr_nr_id}"
  }
    }
     
}                                                                                
   
