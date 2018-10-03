<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="inp_indicador_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Inp_indicador_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="page" value="${pageContext}"/>                                         
${inp_indicador_planejamentoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${inp_indicador_planejamentoJB.list}" var="item">
     ,{	"inp_nr_id":"${item.inp_nr_id}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"inp_nr_mes":"${item.inp_nr_mes}"
 ,	"inp_nr_ano":"${item.inp_nr_ano}"
 ,	"inp_numero_fun_prev_mdo_direta":"${item.inp_numero_fun_prev_mdo_direta}"
 ,	"inp_numero_fun_real_mdo_direta":"${item.inp_numero_fun_real_mdo_direta}"
 ,	"inp_nr_nemro_fun_eqv_mdo_direta":"${item.inp_nr_nemro_fun_eqv_mdo_direta}"
 ,	"inp_nr_perc_eficiencia_mdo_direta":"${item.inp_nr_perc_eficiencia_mdo_direta}"
 ,	"inp_nr_ppp":"${item.inp_nr_ppp}"
 ,	"inp_nr_ppc":"${item.inp_nr_ppc}"
  }
</c:forEach>
]}                                                                                
   
