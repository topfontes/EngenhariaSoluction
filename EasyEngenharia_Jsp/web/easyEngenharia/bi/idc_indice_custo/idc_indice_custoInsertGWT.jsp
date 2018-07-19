<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="idc_indice_custoJB" class="br.com.easynet.gwt.easyportal.jb.Idc_indice_custoInsertJB" scope="request"/>
<jsp:setProperty name="idc_indice_custoJB" property="*"/>
<jsp:setProperty name="idc_indice_custoJB" property="page" value="${pageContext}"/>
${idc_indice_custoJB.execute}
{"resultado":"${idc_indice_custoJB.msg}"}
