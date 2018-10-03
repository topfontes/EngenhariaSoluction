<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="dso_descricao_servico_obraJB" class="br.com.easynet.gwt.easyportal.jb.Dso_descricao_servico_obraInsertJB" scope="request"/>
<jsp:setProperty name="dso_descricao_servico_obraJB" property="*"/>
<jsp:setProperty name="dso_descricao_servico_obraJB" property="page" value="${pageContext}"/>
${dso_descricao_servico_obraJB.execute}
{"resultado":"${dso_descricao_servico_obraJB.msg}"}
