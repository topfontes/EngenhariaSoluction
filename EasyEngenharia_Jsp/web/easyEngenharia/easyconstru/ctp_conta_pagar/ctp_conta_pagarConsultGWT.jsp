<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.Ctp_conta_pagarConsultJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>   
${ctp_conta_pagarJB.execute}
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${ctp_conta_pagarJB.ds.list}" var="item">
,{"ctp_nr_id":"${item.row[0].value}"
,"ctp_tx_fornecedor":"${item.row[1].value}"
,"ctp_nr_mes":"${item.row[2].value}"
,"plc_nr_id":"${item.row[3].value}"
,"ctp_nr_valor":"${item.row[4].value}"
,"ctp_nr_documento":"${item.row[5].value}"
,"ctp_tx_status":"${item.row[6].value}"
,"obr_nr_id":"${item.row[7].value}"
,"ctp_nr_ano":"${item.row[8].value}"
,"plc_tx_nome":"${item.row[9].value}"
,"obr_tx_nome":"${item.row[10].value}"
,"plc_tx_nome_super":"${item.row[11].value}"
,"ctp_dt_vencimento":"<fmt:formatDate value="${item.row[13].value}" pattern="dd/MM/yyyy"/>"
,"plc_nr_id_super":"${item.row[15].value}"
,"ctp_tx_obs":"${item.row[16].value}"
}
</c:forEach>
]}