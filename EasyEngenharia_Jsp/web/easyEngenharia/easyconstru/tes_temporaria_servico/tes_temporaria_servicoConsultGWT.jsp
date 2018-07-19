<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="tes_temporaria_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Tes_temporaria_servicoConsultJB" scope="request"/>
<jsp:setProperty name="tes_temporaria_servicoJB" property="*"/>
<jsp:setProperty name="tes_temporaria_servicoJB" property="page" value="${pageContext}"/>
${tes_temporaria_servicoJB.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${tes_temporaria_servicoJB.list}" var="item">
     ,{	"plco_tx_nome":"${item.plco_tx_nome}"
 ,	"plco_tx_unidade":"${item.plco_tx_unidade}"
 ,	"plco_nr_quantidade":"${item.plco_nr_quantidade}"
 ,	"plco_nr_vl_unitario":"${item.plco_nr_vl_unitario}"
 ,	"plco_nr_vl_total":"${item.plco_nr_vl_total}"
 ,	"plco_nr_id":"${item.plco_nr_id}"
 ,	"plco_tx_cod_externo":"${item.plco_tx_cod_externo}"
 ,	"obr_nr_id":"${item.obr_nr_id}"
 ,	"plco_nr_nivel":"${item.plco_nr_nivel}"
 ,	"ipo_nr_id_super":"${item.ipo_nr_id_super}"
 ,	"ipo_nr_id":"${item.ipo_nr_id}"
  }
</c:forEach>
]}
