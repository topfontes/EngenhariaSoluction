<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="meses_obraJB" class="br.com.easynet.gwt.easyportal.jb.Meses_obra_ConsultJB" scope="request"/>
<jsp:setProperty name="meses_obraJB" property="*"/>
<jsp:setProperty name="meses_obraJB" property="page" value="${pageContext}"/>

${meses_obraJB.execute}
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${meses_obraJB.list}" var="item">
     ,{	"mes":"${item.mes}"
 ,	"ano":"${item.ano}"
 ,	"mes_ano":"${item.mes_ano}"
 ,	"quantidade":"${item.quantidade}"
  }
</c:forEach>
]}

