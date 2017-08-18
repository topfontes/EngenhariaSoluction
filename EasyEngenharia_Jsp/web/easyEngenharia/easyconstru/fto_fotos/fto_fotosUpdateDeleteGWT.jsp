<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fto_fotosJB" property="*"/>                                         
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>                                         
${fto_fotosJB.execute}                                         
{"resultado":
{"msg":"${fto_fotosJB.msg}",
     "fto_fotos":{"fto_nr_id":"${fto_fotosJB.fto_fotosT.fto_nr_id}"
 ,	"obr_nr_id":"${fto_fotosJB.fto_fotosT.obr_nr_id}"
 ,	"fto_nr_mes":"${fto_fotosJB.fto_fotosT.fto_nr_mes}"
 ,	"fto_nr_ano":"${fto_fotosJB.fto_fotosT.fto_nr_ano}"
 ,	"fto_bt_foto":"IMAGEM"
  }
    }
     
}                                                                                
   
