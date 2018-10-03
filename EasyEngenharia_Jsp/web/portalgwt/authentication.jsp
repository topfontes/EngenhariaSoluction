<%@page contentType="text/html" pageEncoding="utf-8"%>
<jsp:useBean id="authentication" class="br.com.easynet.easyportal.gwt.jb.AuthenteicationJB" scope="request"/>
<jsp:setProperty name="authentication" property="*"/>
<jsp:setProperty name="authentication" property="page" value="${pageContext}"/>
${authentication.execute}
{"resultado":{"autenticacao":"${authentication.result}",
"usuario":"${authentication.usuarioLogado.usu_tx_nome}"}
}