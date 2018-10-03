<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="con_composicao_novaJB" class="br.com.easynet.gwt.easyportal.jb.Con_composicao_novaConsultJB" scope="request"/>                                         
<jsp:setProperty name="con_composicao_novaJB" property="*"/>                                         
<jsp:setProperty name="con_composicao_novaJB" property="page" value="${pageContext}"/>
<%
    String apellido = new String(request.getParameter("con_composicao_novaT.con_tx_descricao").getBytes("ISO-8859-1"),"UTF-8");
    int a = 0;
%>
${con_composicao_novaJB.execute}                                         
{"resultado":[
   {"registro":"marcacao"}
<c:forEach items="${con_composicao_novaJB.list}" var="item">
     ,{	"con_nr_id":"${item.con_nr_id}"
 ,	"con_tx_codigo":"${item.con_tx_codigo}"
 ,	"con_tx_descricao":"${item.con_tx_descricao}"
 ,	"con_tx_unidade":"${item.con_tx_unidade}"
  }
</c:forEach>
]}                                                                                
   
