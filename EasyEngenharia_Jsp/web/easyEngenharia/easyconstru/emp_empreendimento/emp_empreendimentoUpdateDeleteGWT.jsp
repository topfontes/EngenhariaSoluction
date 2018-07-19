<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.nio.charset.Charset"%>
<%@page import="java.util.Locale"%>
<jsp:useBean id="emp_empreendimentoJB" class="br.com.easynet.gwt.easyportal.jb.Emp_empreendimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="*"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="page" value="${pageContext}"/>                        
<%
  System.out.println(Charset.defaultCharset());
  System.out.println(Locale.getDefault());
  System.out.println(request.getCharacterEncoding());
  System.out.println(request.getContentType());
%>
${emp_empreendimentoJB.execute}
{"resultado":
{"msg":"${emp_empreendimentoJB.msg}",
"emp_empreendimento":{"emp_nr_id":"${emp_empreendimentoJB.emp_empreendimentoT.emp_nr_id}"
 ,"emp_tx_nome":"${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_nome}"
 ,"emp_tx_bairro":"${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_bairro}"
 ,"emp_tx_cidade":"${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_cidade}"
 ,"emp_tx_uf":"${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_uf}"
 ,"cli_nr_id":"${emp_empreendimentoJB.emp_empreendimentoT.cli_nr_id}"
  }
    }
     
}                                                                                
   
