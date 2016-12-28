<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_comprometimentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${vw_comprometimentoJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${vw_comprometimentoJB.list}" var="item">
    ,{	"com_nr_id":"${item.com_nr_id}"
    ,	"obr_nr_id":"${item.obr_nr_id}"
    ,	"com_nr_mes":"${item.com_nr_mes}"
    ,	"com_nr_ano":"${item.com_nr_ano}"
    ,	"plc_nr_id":"${item.plc_nr_id}"
    ,	"plc_tx_nome":"${item.plc_tx_nome}"
    ,	"com_nr_valor":"${item.com_nr_valor}"
    ,	"plc_tx_nome_super":"${item.plc_tx_nome_super}"
    }
</c:forEach>
]}                                                                                

