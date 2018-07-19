<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="frd_faturamento_rec_devolucaoJB" class="br.com.easynet.gwt.easyportal.jb.Frd_faturamento_rec_devolucaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="*"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="page" value="${pageContext}"/>                                         
${frd_faturamento_rec_devolucaoJB.execute}                                         
{"resultado":
{"msg":"${frd_faturamento_rec_devolucaoJB.msg}",
     "frd_faturamento_rec_devolucao":{	"frd_nr_id":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_id}"
 ,	"frd_nr_valor_permutado":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_permutado}"
 ,	"frd_nr_vgv":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_vgv}"
 ,	"frd_nr_valor_devolucao":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_devolucao}"
 ,	"frd_nr_valor_faturamento":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_faturamento}"
 ,	"frd_nr_valor_recebimento":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_recebimento}"
 ,	"frd_nr_valor_permutas":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_permutas}"
 ,	"obr_nr_id":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.obr_nr_id}"
 ,	"frd_nr_mes":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_mes}"
 ,	"frd_nr_ano":"${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_ano}"
  }
    }
     
}                                                                                
   
