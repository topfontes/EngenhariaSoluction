<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="frd_faturamento_rec_devolucaoJB" class="br.com.easynet.gwt.easyportal.jb.Frd_faturamento_rec_devolucaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="*"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="page" value="${pageContext}"/>                                         
${frd_faturamento_rec_devolucaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${frd_faturamento_rec_devolucaoJB.list}" var="item">
     ,{	"frd_nr_id":"${item.frd_nr_id}"
 ,	"frd_nr_valor_permutado":"${item.frd_nr_valor_permutado}"
 ,	"frd_nr_vgv":"${item.frd_nr_vgv}"
 ,	"frd_nr_valor_devolucao":"${item.frd_nr_valor_devolucao}"
 ,	"frd_nr_valor_faturamento":"${item.frd_nr_valor_faturamento}"
 ,	"frd_nr_valor_recebimento":"${item.frd_nr_valor_recebimento}"
 ,	"frd_nr_valor_permutas":"${item.frd_nr_valor_permutas}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"frd_nr_mes":"${item.frd_nr_mes}"
 ,	"frd_nr_ano":"${item.frd_nr_ano}"
  }
</c:forEach>
]}                                                                                
   
