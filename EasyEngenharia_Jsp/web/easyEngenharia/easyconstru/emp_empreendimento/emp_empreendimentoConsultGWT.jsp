<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="emp_empreendimentoJB" class="br.com.easynet.gwt.easyportal.jb.Emp_empreendimentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="*"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="page" value="${pageContext}"/>                                         
${emp_empreendimentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${emp_empreendimentoJB.ds.list}" var="item">
     ,{	"emp_nr_id":"${item.row[0].value}"
 ,	"emp_tx_nome":"${item.row[1].value}"
 ,	"emp_tx_endereco":"${item.row[2].value}"
 ,	"emp_tx_bairro":"${item.row[3].value}"
 ,	"emp_tx_cidade":"${item.row[4].value}"
 ,	"emp_tx_uf":"${item.row[5].value}"
 ,	"cli_nr_id":"${item.row[6].value}"
,	"cli_tx_nome":"${item.row[7].value}"
  }
</c:forEach>
]}                                                                                
   
