<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="scfp_subclasse_operario_previstoJB" class="br.com.easynet.gwt.easyportal.jb.Scfp_subclasse_operario_previstoConsultJB" scope="request"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="*"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="page" value="${pageContext}"/>                                         
${scfp_subclasse_operario_previstoJB.execute}                                         
{"resultado":[
{"registro":"${scfp_subclasse_operario_previstoJB.msg}"}
   <c:forEach items="${scfp_subclasse_operario_previstoJB.ds.list}" var="item">
     ,{	"scfp_nr_id":"${item.row[0].value}"
     , "subClasse":"${item.row[1].value}"
  }
</c:forEach>
]}                                                                                
