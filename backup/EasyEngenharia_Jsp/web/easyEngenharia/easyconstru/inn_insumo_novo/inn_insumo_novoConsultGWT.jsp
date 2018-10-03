<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inn_insumo_novoJB" class="br.com.easynet.gwt.easyportal.jb.Inn_insumo_novoConsultJB" scope="request"/>                                         
<jsp:setProperty name="inn_insumo_novoJB" property="*"/>                                         
<jsp:setProperty name="inn_insumo_novoJB" property="page" value="${pageContext}"/>                                         
${inn_insumo_novoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${inn_insumo_novoJB.list}" var="item">
     ,{	"inn_nr_id":"${item.inn_nr_id}"
 ,	"inn_tx_codigo":"${item.inn_tx_codigo}"
 ,	"inn_tx_descricao":"${item.inn_tx_descricao}"
 ,	"inn_tx_unidade":"${item.inn_tx_unidade}"
  }
</c:forEach>
]}                                                                                
   
