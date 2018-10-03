<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="coa_composicao_anteriorJB" class="br.com.easynet.gwt.easyportal.jb.Coa_composicao_anteriorConsultJB" scope="request"/>                                         
<jsp:setProperty name="coa_composicao_anteriorJB" property="*"/>                                         
<jsp:setProperty name="coa_composicao_anteriorJB" property="page" value="${pageContext}"/>                                         
${coa_composicao_anteriorJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${coa_composicao_anteriorJB.list}" var="item">
     ,{	"coa_nr_id":"${item.coa_nr_id}"
 ,	"coa_tx_codigo":"${item.coa_tx_codigo}"
 ,	"coa_tx_descricao":"${item.coa_tx_descricao}"
 ,	"coa_tx_unidade":"${item.coa_tx_unidade}"
  }
</c:forEach>
]}                                                                                
   
