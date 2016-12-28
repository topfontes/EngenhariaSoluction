<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="dso_descricao_servico_obraJB" class="br.com.easynet.gwt.easyportal.jb.Dso_descricao_servico_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="*"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="page" value="${pageContext}"/>                                         
${dso_descricao_servico_obraJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${dso_descricao_servico_obraJB.list}" var="item">
     ,{	"plco_nr_id":"${item.plco_nr_id}"
 ,	"dso_tx_codigo_externo":"${item.dso_tx_codigo_externo}"
 ,	"dso_tx_descriaco":"${item.dso_tx_descriaco}"
 ,	"dso_nr_id":"${item.dso_nr_id}"
  }
</c:forEach>
]}                                                                                
   
