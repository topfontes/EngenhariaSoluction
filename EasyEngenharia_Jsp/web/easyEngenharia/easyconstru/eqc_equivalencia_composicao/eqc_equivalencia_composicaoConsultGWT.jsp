<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<jsp:useBean id="eqc_equivalencia_composicaoJB" class="br.com.easynet.gwt.easyportal.jb.Eqc_equivalencia_composicaoConsultJB" scope="request"/>                                         
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="*"/>                                         
<jsp:setProperty name="eqc_equivalencia_composicaoJB" property="page" value="${pageContext}"/>                                         
${eqc_equivalencia_composicaoJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${eqc_equivalencia_composicaoJB.list}" var="item">
     ,{	"coa_nr_id":"${item.coa_nr_id}"
 ,	"con_nr_id":"${item.con_nr_id}"
  }
</c:forEach>
]}                                                                                
   
