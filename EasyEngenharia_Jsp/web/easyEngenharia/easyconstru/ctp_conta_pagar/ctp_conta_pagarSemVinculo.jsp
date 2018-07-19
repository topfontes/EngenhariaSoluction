<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.ctp_conta_pagarSemVinculoJB" scope="request"/>
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>
${ctp_conta_pagarJB.execute}
{"resultado":[
{"registro":"marcacao"}

<c:forEach items="${ctp_conta_pagarJB.list}" var="item">
    ,{
    "ctp_nr_id":"${item.ctp_nr_id}"
    ,"ctp_tx_fornecedor":"${item.ctp_tx_fornecedor}"
    ,"ctp_nr_mes":"${item.ctp_nr_mes}"
    ,"ctp_nr_ano":"${item.ctp_nr_ano}"
    ,"plc_nr_id":"${item.plc_nr_id}"
    ,"ctp_nr_valor":"${item.ctp_nr_valor}"
    ,"ctp_nr_documento":"${item.ctp_nr_documento}"
    ,"ctp_tx_status":"${item.ctp_tx_status}"
    ,"obr_nr_id":"${item.obr_nr_id}"
    ,"ctp_tx_obs":"${item.ctp_tx_obs}"
    ,"ctp_tx_status":"${item.ctp_tx_status}"
    ,"ctp_dt_vencimento":"<fmt:formatDate value="${item.ctp_dt_vencimento}"pattern="dd/MM/yyyy"/>"
    ,"ctp_dt_emissao":"<fmt:formatDate value="${item.ctp_dt_emissao}"pattern="dd/MM/yyyy"/>"
    }
</c:forEach>
]}



















