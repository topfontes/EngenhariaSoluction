<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fto_fotosJB" class="br.com.easynet.gwt.easyportal.jb.Fto_fotosConsultJB" scope="request"/>                                         
<jsp:setProperty name="fto_fotosJB" property="*"/>                                         
<jsp:setProperty name="fto_fotosJB" property="page" value="${pageContext}"/>                                         
${fto_fotosJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${fto_fotosJB.list}" var="item">
     ,{	"fto_nr_id":"${item.fto_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"fto_nr_mes":"${item.fto_nr_mes}"
 ,	"fto_nr_ano":"${item.fto_nr_ano}"
 ,	"fto_bt_foto":"IMAGEM"
 ,	"fto_tx_nome":"${item.fto_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
