<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="metJB" class="br.com.easynet.gwt.easyportal.jb.Met_metodoConsult_JB" scope="request"/>
<jsp:setProperty name="metJB" property="*"/>
<jsp:setProperty name="metJB" property="page" value="${pageContext}"/>
${metJB.execute}
{"resultado":[
   {"registro":"marcacao"}
   <c:forEach items="${metJB.listTmp}" var="item">
     ,{	"ope_nr_id":"${item.ope_nr_id}"
 ,	"met_nr_id":"${item.met_nr_id}"
 ,	"met_tx_metodo":"${item.met_tx_metodo}"
 ,	"met_tx_descricao":"${item.met_tx_descricao}"
 ,	"met_tx_status":"${item.met_tx_status}"
 ,	"sis_nr_id":"${item.sis_nr_id}"
 ,	"ope_tx_nome":"${item.ope_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
