<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="obr_obrasJB" class="br.com.easynet.gwt.easyportal.jb.Obr_obrasInsertJB" scope="request"/>
<jsp:setProperty name="obr_obrasJB" property="*"/>
<jsp:setProperty name="obr_obrasJB" property="page" value="${pageContext}"/>
${obr_obrasJB.execute}
{"resultado":[
{"registro":"${obr_obrasJB.msg}"}
   ,{"obr_nr_id":"${obr_obrasJB.obr_obrasT.obr_nr_id}"}
   ]}
