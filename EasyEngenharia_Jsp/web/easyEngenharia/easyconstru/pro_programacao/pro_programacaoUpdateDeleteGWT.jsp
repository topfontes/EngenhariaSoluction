<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="pro_programacaoJB" class="br.com.easynet.gwt.easyportal.jb.Pro_programacaoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="*"/>                                         
<jsp:setProperty name="pro_programacaoJB" property="page" value="${pageContext}"/>                                         
${pro_programacaoJB.execute}                                         
{"resultado":
{"msg":"${pro_programacaoJB.msg}",
     "pro_programacao":{	"pro_nr_id":"${pro_programacaoJB.pro_programacaoT.pro_nr_id}"
 ,	"obr_nr_id":"${pro_programacaoJB.pro_programacaoT.obr_nr_id}"
 ,	"pro_nr_mes":"${pro_programacaoJB.pro_programacaoT.pro_nr_mes}"
 ,	"pro_nr_ano":"${pro_programacaoJB.pro_programacaoT.pro_nr_ano}"
 ,	"pro_dt_coleta_orcamento":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_coleta_orcamento}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_coleta_rh":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_coleta_rh}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_analise_inicio":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_analise_inicio}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_analise_final":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_analise_final}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_reuniao_engenharia":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_engenharia}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_reuniao_diretoria":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_diretoria}" pattern="dd/MM/yyyy"/>"
 ,	"pro_dt_reuniao_geral":"<fmt:formatDate value="${pro_programacaoJB.pro_programacaoT.pro_dt_reuniao_geral}" pattern="dd/MM/yyyy"/>"
  }
    }
     
}                                                                                
   
