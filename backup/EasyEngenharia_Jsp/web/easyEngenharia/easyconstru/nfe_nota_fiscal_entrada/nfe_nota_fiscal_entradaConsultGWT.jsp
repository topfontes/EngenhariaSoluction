<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>                                         
${nfe_nota_fiscal_entradaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${nfe_nota_fiscal_entradaJB.list}" var="item">
     ,{	"nfe_nr_id":"${item.nfe_nr_id}"
 ,	"nfe_dt_emissao":"<fmt:formatDate value="${item.nfe_dt_emissao}" pattern="dd/MM/yyyy"/>"
 ,	"for_nr_id":"${item.for_nr_id}"
 ,	"nfe_nr_valor_nota":"${item.nfe_nr_valor_nota}"
  }
</c:forEach>
]}                                                                                
   
