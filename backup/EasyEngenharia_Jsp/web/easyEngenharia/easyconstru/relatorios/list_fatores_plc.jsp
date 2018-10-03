<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="fatoresPlcJB" class="br.com.easynet.gwt.easyportal.jb.List_fatores_plcJB" scope="request"/>
<jsp:setProperty name="fatoresPlcJB" property="*"/>
<jsp:setProperty name="fatoresPlcJB" property="page" value="${pageContext}"/>
${fatoresPlcJB.execute}
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${fatoresPlcJB.list}" var="item">
    ,{	"plc_nr_id":"${item.plc_nr_id}"
    ,	"obr_nr_id":"${item.obr_nr_id}"
    ,	"mes":"${item.mes}"
    ,	"ano":"${item.ano}"
    ,	"plc_tx_nome":"${item.plc_tx_nome}"
    ,	"plc_tx_super":"${item.plc_tx_super}"
    ,	"fator_Atual":"${item.fator_Atual}"
    ,	"fator_projetado":"${item.fator_projetado}"
    }
</c:forEach>
]} 