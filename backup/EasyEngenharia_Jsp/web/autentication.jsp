<%@page contentType="text/html" pageEncoding="latin1"%>
<jsp:useBean id="autentication" class="br.com.easynet.easyportal.jb.AutenticationJB" scope="request"/>
<jsp:setProperty name="autentication" property="*"/>
<jsp:setProperty name="autentication" property="page" value="${pageContext}"/>
${autentication.execute}
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
    <body bgcolor="#ffffff" style="margin-left:0;margin-top:0">
        <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center">

            <tr>
                <td colspan="4"><br/><br/><br/></td>
            </tr>

            <tr>
                <td rowspan="2"></td>
                <td><img name="EASYFIN_r2_c2" src="images/EASYFIN_r2_c2.jpg" width="263" height="62" border="0" id="EASYFIN_r2_c2" alt="" /></td>
                <td rowspan="4"><img name="EASYFIN_r2_c3" src="images/EASYFIN_r2_c3.jpg" width="7" height="319" border="0" id="EASYFIN_r2_c3" alt="" /></td>
                <td rowspan="2"></td>
                <td></td>
            </tr>
            <tr>
                <td><img name="EASYFIN_r3_c2" src="images/EASYFIN_r3_c2.jpg" width="263"  height="42" border="0" id="EASYFIN_r3_c2" alt="" /></td>
                <td></td>
            </tr>
            <tr>
                <td><img name="EASYFIN_r4_c1" src="images/EASYFIN_r4_c1.jpg" width="369" height="153" border="0" id="EASYFIN_r4_c1" alt="" /></td>
                <td align="center">
                    <label class="warnMessage">${autentication.msg}</label>
                    <form action="autentication.jsp" method="post">
                        <input type="hidden" name="op" value="autenticar"/>
                        <table width="200px" border="0">
                            <tr>
                                <td colspan="3" align="center">
                                    <h3>
                                        <a href="loj_loja_UsuInsert.jsp">Não sou cadastrado. </a>
                                    </h3>

                                </td>
                            </tr>

                            <tr>
                                <td rowspan="3" width="27%"><img src="images/chave.gif" border="0"/></td>
                                <td colspan="2"><label>Username:</label><br/>
                                    <input type="text" size="17" name="usu_usuarioT.usu_tx_login" onKeyPress="enter(event)"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><label>Password:</label><br/>
                                    <input type="password" size="17" name="usu_usuarioT.usu_tx_senha" onKeyPress="enter(event)"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">


                                    <input type="button" value="Enter" onClick="setOp('autenticar')"/>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="3">

                                    <label>
                                        Esqueceu a senha? Clique <a href="gerarSenha.jsp">aqui
                                        </a>
                                    </label>

                                </td>
                            </tr>

                        </table>
                    </form>

                </td>
                <td><img name="EASYFIN_r4_c4" src="images/EASYFIN_r4_c4.jpg" width="385" height="153" border="0" id="EASYFIN_r4_c4" alt="" /></td>
                <td><img src="images/spacer.gif" width="1" height="153" border="0" alt="" /></td>
            </tr>
            <tr>
                <td rowspan="2"></td>
                <td><img name="EASYFIN_r5_c2" src="images/EASYFIN_r5_c2.jpg" width="263" height="62" border="0" id="EASYFIN_r5_c2" alt="" /></td>
                <td rowspan="2"></td>
                <td><img src="images/spacer.gif" width="1" height="62" border="0" alt="" /></td>
            </tr>
        </table>
    </body>
</html>
