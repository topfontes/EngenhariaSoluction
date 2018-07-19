<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="rep_resumo_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Rep_resumo_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="page" value="${pageContext}"/>                                         
${rep_resumo_planejamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${rep_resumo_planejamentoJB.list}" var="item">
     ,{	"rep_nr_id":"${item.rep_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"rep_nr_mes":"${item.rep_nr_mes}"
 ,	"rep_nr_ano":"${item.rep_nr_ano}"
 ,	"rep_tx_etapa":"${item.rep_tx_etapa}"
 ,	"rep_tx_local":"${item.rep_tx_local}"
 ,	"rep_dt_termino_banco":"<fmt:formatDate value="${item.rep_dt_termino_banco}" pattern="dd/MM/yyyy"/>"
 ,	"rep_dt_termino_cliente":"<fmt:formatDate value="${item.rep_dt_termino_cliente}" pattern="dd/MM/yyyy"/>"
 ,	"rep_nr_duracao_linha_base":"${item.rep_nr_duracao_linha_base}"
 ,	"rep_dt_inicio_linha_base":"<fmt:formatDate value="${item.rep_dt_inicio_linha_base}" pattern="dd/MM/yyyy"/>"
 ,	"rep_dt_termino_linha_base":"<fmt:formatDate value="${item.rep_dt_termino_linha_base}" pattern="dd/MM/yyyy"/>"
 ,	"rep_nr_duracao":"${item.rep_nr_duracao}"
 ,	"rep_dt_inicio":"<fmt:formatDate value="${item.rep_dt_inicio}" pattern="dd/MM/yyyy"/>"
 ,	"rep_dt_termino":"<fmt:formatDate value="${item.rep_dt_termino}" pattern="dd/MM/yyyy"/>"
 ,	"rep_nr_trab_acum_realizado":"${item.rep_nr_trab_acum_realizado}"
 ,	"rep_nr_trab_acum_previsto":"${item.rep_nr_trab_acum_previsto}"
  }
</c:forEach>
]}                                                                                
   
