<%-- 
    Document   : autentication
    Created on : 08/06/2008, 19:48:34
    Author     : geoleite
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="gerarsenha" class="br.com.easynet.easyportal.jb.GerarSenhaJB" scope="request"/>
<jsp:setProperty name="gerarsenha" property="*"/>
<jsp:setProperty name="gerarsenha" property="page" value="${pageContext}"/>
${gerarsenha.execute}


<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EasyPortal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!--style type="text/css">td img {display: block;}</style-->
        <script src="script/eventos.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <link href="css/model.css" rel="stylesheet" type="text/css" />

        <!--Fireworks CS3 Dreamweaver CS3 target.  Created Thu Jul 23 18:24:50 GMT-0300 (Hora oficial do Brasil) 2009-->
    </head>
    <body bgcolor="#ffffff">
        <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center">
            <tr>
                <td colspan="4"><br/><br/><br/></td>
            </tr>



            <tr>
                <td rowspan="2"><img name="EASYFIN_r2_c1" src="images/EASYFIN_r2_c1.jpg" width="369" height="104" border="0" id="EASYFIN_r2_c1" alt="" /></td>
                <td><img name="EASYFIN_r2_c2" src="images/EASYFIN_r2_c2.jpg" width="263" height="62" border="0" id="EASYFIN_r2_c2" alt="" /></td>
                <td rowspan="4"><img name="EASYFIN_r2_c3" src="images/EASYFIN_r2_c3.jpg" width="7" height="319" border="0" id="EASYFIN_r2_c3" alt="" /></td>
                <td rowspan="2"><img name="EASYFIN_r2_c4" src="images/EASYFIN_r2_c4.jpg" width="385" height="104" border="0" id="EASYFIN_r2_c4" alt="" /></td>
                <td><img src="images/spacer.gif" width="1" height="62" border="0" alt="" /></td>
            </tr>
            <tr>

                <td><img name="EASYFIN_r3_c2" src="images/EASYFIN_r3_c2.jpg" width="263" height="42" border="0" id="EASYFIN_r3_c2" alt="" /></td>
                <td><img src="spacer.gif" width="1" height="42" border="0" alt="" /></td>
            </tr>
            <tr>
                <td><img name="EASYFIN_r4_c1" src="images/EASYFIN_r4_c1.jpg" width="369" height="153" border="0" id="EASYFIN_r4_c1" alt="" /></td>
                <td>
                    <h3> Form Password Generate </h3>
                    <form action="gerarSenha.jsp" method="post">
                        <input type="hidden" name="op" value="gerarNovaSenha"/>
                        <label class="errorMessage">${gerarsenha.msg}</label>
                        <table width="200px">
                            <tr>
                                <td><label>Username:</label></td>
                                <td><input type="text" name="usu_usuarioT.usu_tx_login" onkeypress="enter(event)"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"><input type="button" value="Generate" onclick="setOp('gerarNovaSenha')"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <label>Volta ao Login</label> <a href="autentication.jsp">Voltar</a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </td>
                <td><img name="EASYFIN_r4_c4" src="images/EASYFIN_r4_c4.jpg" width="385" height="153" border="0" id="EASYFIN_r4_c4" alt="" /></td>
                <td><img src="spacer.gif" width="1" height="153" border="0" alt="" /></td>
            </tr>

            <tr>
                <td rowspan="2"><img name="EASYFIN_r5_c1" src="images/EASYFIN_r5_c1.jpg" width="369" height="213" border="0" id="EASYFIN_r5_c1" alt="" /></td>
                <td><img name="EASYFIN_r5_c2" src="images/EASYFIN_r5_c2.jpg" width="263" height="62" border="0" id="EASYFIN_r5_c2" alt="" /></td>
                <td rowspan="2"><img name="EASYFIN_r5_c4" src="images/EASYFIN_r5_c4.jpg" width="385" height="213" border="0" id="EASYFIN_r5_c4" alt="" /></td>
                <td><img src="spacer.gif" width="1" height="62" border="0" alt="" /></td>
            </tr>
            <tr>
                <td colspan="2"><img name="EASYFIN_r6_c2" src="images/EASYFIN_r6_c2.jpg" width="270" height="151" border="0" id="EASYFIN_r6_c2" alt="" /></td>
                <td><img src="spacer.gif" width="1" height="151" border="0" alt="" /></td>

            </tr>
        </table>
    </body>
</html>

