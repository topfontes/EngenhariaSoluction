<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Plco_plano_contas_orcamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>                                         
${plco_plano_contas_orcamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${plco_plano_contas_orcamentoJB.list}" var="item">
     ,{	"plco_nr_id":"${item.plco_nr_id}"
 ,	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"plco_tx_tipo":"${item.plco_tx_tipo}"
 ,	"plco_tx_cod_externo":"${item.plco_tx_cod_externo}"
 ,	"plco_tx_unidade":"${item.plco_tx_unidade}"
 ,	"plco_nr_id_super":"${item.plco_nr_id_super}"
 ,	"plco_bl_equivalencia":"${item.plco_bl_equivalencia}"
 ,	"plco_nr_nivel":"${item.plco_nr_nivel}"
  }
</c:forEach>
]}
   
