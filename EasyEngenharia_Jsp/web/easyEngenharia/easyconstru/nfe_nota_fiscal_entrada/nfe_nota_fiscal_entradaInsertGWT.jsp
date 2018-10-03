<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaInsertJB" scope="request"/>
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>
${nfe_nota_fiscal_entradaJB.execute}
{"resultado":"${nfe_nota_fiscal_entradaJB.msg}"}
