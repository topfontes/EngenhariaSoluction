<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_cffo_mesJB" class="br.com.easynet.gwt.easyportal.client.jb.Vw_cffo_mesUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="*"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="page" value="${pageContext}"/>                                         
${vw_cffo_mesJB.execute}                                         
{"resultado":
{"msg":"${vw_cffo_mesJB.msg}",
     "vw_cffo_mes":{	"obr_nr_id":"${vw_cffo_mesJB.vw_cffo_mesT.obr_nr_id}"
 ,	"cffo_nr_mes":"${vw_cffo_mesJB.vw_cffo_mesT.cffo_nr_mes}"
 ,	"cffo_nr_ano":"${vw_cffo_mesJB.vw_cffo_mesT.cffo_nr_ano}"
 ,	"total":"${vw_cffo_mesJB.vw_cffo_mesT.total}"
  }
    }
     
}                                                                                
   
