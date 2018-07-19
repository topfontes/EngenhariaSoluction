<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="obr_obrasJB" class="br.com.easynet.gwt.easyportal.jb.Obr_obrasConsultJB" scope="request"/>                                         
<jsp:setProperty name="obr_obrasJB" property="*"/>                                         
<jsp:setProperty name="obr_obrasJB" property="page" value="${pageContext}"/>                                         
${obr_obrasJB.execute}
{"resultado":[
   {"registro":"${obr_obrasJB.msg}"}
<c:forEach items="${obr_obrasJB.ds.list}" var="item">
     ,{	"obr_nr_id":"${item.row[0].value}"
 ,	"obr_tx_nome":"${item.row[1].value}"
 ,	"obr_tx_endereco":"${item.row[2].value}"
 ,	"obr_tx_bairro":"${item.row[3].value}"
 ,	"obr_tx_cidade":"${item.row[4].value}"
 ,	"obr_tx_uf":"${item.row[5].value}"
 ,	"emp_nr_id":"${item.row[6].value}"
 ,	"obr_nr_area_construida_total":"${item.row[7].value}"
 ,	"obr_dt_inicio":"<fmt:formatDate value="${item.row[8].value}" pattern="dd/MM/yyyy"/>"
 ,	"obr_dt_fim":"<fmt:formatDate value="${item.row[9].value}" pattern="dd/MM/yyyy"/>"
 ,	"obr_dt_inicio_controle":"<fmt:formatDate value="${item.row[10].value}" pattern="dd/MM/yyyy"/>"
 ,	"obr_dt_termino_controle":"<fmt:formatDate value="${item.row[11].value}" pattern="dd/MM/yyyy"/>"
  ,	"emp_tx_nome":"${item.row[12].value}"
  ,     "obr_nr_area_privativa_total":"${item.row[13].value}"
  ,     "obr_nr_id_plc_mdo_direta":"${item.row[14].value}"
  ,     "obr_nr_id_plc_mdo_indireta":"${item.row[15].value}"
  ,     "obr_nr_percent_mdo_direta":"${item.row[16].value}"
  ,     "obr_nr_percent_mdo_indireta":"${item.row[17].value}"
  ,     "obr_nr_valor_permutado":"${item.row[18].value}"
  ,     "obr_nr_valor_vgv":"${item.row[19].value}"
  ,     "obr_nr_encarcos_juros_aplicacao":"${item.row[20].value}"
 ,	"obr_dt_inicio_real":"<fmt:formatDate value="${item.row[21].value}" pattern="dd/MM/yyyy"/>"
 ,	"obr_dt_final_real":"<fmt:formatDate value="${item.row[22].value}" pattern="dd/MM/yyyy"/>"

  }
</c:forEach>
]} 
   
