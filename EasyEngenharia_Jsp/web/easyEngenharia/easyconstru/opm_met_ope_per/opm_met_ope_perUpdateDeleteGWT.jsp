<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="opm_met_ope_per_JB" class="br.com.easynet.gwt.easyportal.jb.Opm_met_ope_perUpdateDelete_JB" scope="request"/>
<jsp:setProperty name="opm_met_ope_per_JB" property="*"/>
<jsp:setProperty name="opm_met_ope_per_JB" property="page" value="${pageContext}"/>
${opm_met_ope_per_JB.execute}
{"resultado":"${opm_met_ope_per_JB.msg}"}
