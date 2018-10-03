<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="uno_unidade_obraJB" class="br.com.easynet.gwt.easyportal.jb.Uno_unidade_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="*"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="page" value="${pageContext}"/>                                         
${uno_unidade_obraJB.execute}                                         
{"resultado":[
{"registro":"marcacao"}
<c:forEach items="${uno_unidade_obraJB.ds.list}" var="item">
    ,{	"uno_nr_id":"${item.row[0].value}"
    ,	"obr_nr_id":"${item.row[1].value}"
    ,	"uno_nr_quantidade":"${item.row[2].value}"
    ,	"uno_nr_area_construida":"${item.row[3].value}"
    ,	"uni_nr_id":"${item.row[4].value}"
    ,	"uni_tx_nome":"${item.row[5].value}"
    ,	"obr_tx_nome":"${item.row[6].value}"
    }
</c:forEach>
]}                                                                                

