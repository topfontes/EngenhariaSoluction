<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="fol_folha_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fol_folha_pagamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fol_folha_pagamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
   <c:forEach items="${fol_folha_pagamentoJB.ds.list}" var="item">
     ,{	"fol_nr_id":"${item.row[0].value}"
 ,	"obr_nr_id":"${item.row[1].value}"
 ,	"plc_nr_id":"${item.row[2].value}"
 ,	"plco_nr_id":"${item.row[3].value}"
 ,	"fol_nr_mes":"${item.row[4].value}"
 ,	"fol_nr_ano":"${item.row[5].value}"
 ,	"fol_tx_funcao":"${item.row[6].value}"
 ,	"fol_nr_salario_bruto_oficial":"${item.row[7].value}"
 ,	"fol_nr_adiantamento_oficial":"${item.row[8].value}"
 ,	"fol_nr_horas_extra_oficial":"${item.row[9].value}"
 ,	"fol_nr_salario_bruto_nao_oficial":"${item.row[10].value}"
 ,	"fol_nr_adiantamento_nao_oficial":"${item.row[11].value}"
 ,	"fol_nr_horas_extra_nao_oficial":"${item.row[12].value}"
 ,	"fol_nr_numero_funcionario":"${item.row[13].value}"
 ,	"subClasse":"${item.row[14].value}"
 ,	"classe":"${item.row[15].value}"
  }
</c:forEach>
  ,{"horas":"${fol_folha_pagamentoJB.horasTrab}"}
]}                                                                                
   
