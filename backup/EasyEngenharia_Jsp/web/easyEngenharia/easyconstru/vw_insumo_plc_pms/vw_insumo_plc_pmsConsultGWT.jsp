<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="vw_insumo_plc_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_insumo_plc_pmsConsultJB" scope="request"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_insumo_plc_pmsJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${vw_insumo_plc_pmsJB.ds.list}" var="item">
    ,{"plc_nr_id":"${item.row[0].value}"
    ,	"plc_tx_nome":"${item.row[1].value}"
    ,	"plc_tx_nome_super":"${item.row[2].value}"
    ,	"und":"${item.row[3].value}"
    ,	"vl_total":"${item.row[4].value}"
    ,	"quantidade":"${item.row[5].value}"
    }
</c:forEach>
]}                                                                                

