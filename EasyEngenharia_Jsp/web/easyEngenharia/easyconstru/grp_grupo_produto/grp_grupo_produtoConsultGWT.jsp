<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoConsultJB" scope="request"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>                                         
${grp_grupo_produtoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${grp_grupo_produtoJB.list}" var="item">
     ,{	"grp_nr_id":"${item.grp_nr_id}"
 ,	"grp_tx_nome":"${item.grp_tx_nome}"
  }
</c:forEach>
]}                                                                                
   
