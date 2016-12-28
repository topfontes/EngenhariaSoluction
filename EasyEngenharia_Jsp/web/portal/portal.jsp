<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="portal" class="br.com.easynet.portal.jb.PortalBaseJB" scope="request"/>
<jsp:setProperty name="portal" property="*"/>
<jsp:setProperty name="portal" property="page" value="${pageContext}"/>
${portal.execute}
<%@page contentType="text/html" pageEncoding="latin1"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>EasyPortal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <!--style type="text/css">td img {display: block;}</style-->
        <script src="../script/eventos.js"></script>
        <script src="../script/calendario.js"></script>
        <script type="text/javascript">var dmWorkPath="menu.files/";</script>
        <script type="text/javascript" src="menu.files/dmenu.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>...::EasyPortal::...</title>
        
        <link href="../css/displaytag.css" rel="stylesheet" type="text/css" />
        <link href="../css/model.css" rel="stylesheet" type="text/css" />
    </head>
    <body bgcolor="#ffffff" style="margin-left:0;margin-top:0" >
        <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center">
            <!-- fwtable fwsrc="EASYFIN2.png" fwpage="Page 1" fwbase="EASYFIN2.jpg" fwstyle="Dreamweaver" fwdocid = "1791252200" fwnested="0" -->
            <tr>
                <td><img src="../images/spacer.gif" width="233" height="1" border="0" alt="" /></td>
                <td><img src="../images/spacer.gif" width="791" height="1" border="0" alt="" /></td>
                <td><img src="../images/spacer.gif" width="1" height="1" border="0" alt="" /></td>
            </tr>

            <tr>
                <td><img name="EASYFIN2_r1_c1" src="../images/EASYFIN2_r1_c1.jpg" width="233" height="45" border="0" id="EASYFIN2_r1_c1" alt="" /></td>
                <!--td><img name="EASYFIN2_r1_c2" src="../images/EASYFIN2_r1_c2.jpg" width="791" height="45" border="0" id="EASYFIN2_r1_c2" alt="" /></td-->
                <td style="background-image:url(../images/EASYFIN2_r1_c2.jpg)">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style="color:white">Bem Vindo ${portal.usuarioLogado.usu_tx_nome}&nbsp;&nbsp;
                        <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=alterarSenha.jsp" style="color:yellow">Alterar Senha</a>
                    </label>

                </td>

                <td></td>
            </tr>
            <tr>
                <td colspan="2" style="background-image:url(../images/EASYFIN2_r2_c1.jpg)">
                    <script type="text/javascript" src="menu/montaMenu2.jsp"></script>
                </td>
                <td><img src="../images/spacer.gif" width="1" height="30" border="0" alt="" /></td>
            </tr>
            <tr>
                <td colspan="3" align="center"><!--img name="EASYFIN2_r3_c1" src="../images/EASYFIN2_r3_c1.jpg" width="1024" height="467" border="0" id="EASYFIN2_r3_c1" alt="" /-->
                    <label class="warnMessage">${autentication.msg}</label>
                    <table align="center" width="100%" height="100%">
                        <tr>
                            <td align="center" valign="top">
                                ${portal.msg}
                            </td>
                        </tr>
                        <tr>
                            <td align="center" valign="top">
                                ${portal.montaCanal}
                            </td>
                        </tr>
                    </table>

                </td>
            </tr>
            <tr>
                <td colspan="3" align="center" style="background-image:url(../images/EASYFIN2_r4_c1.jpg);text-align:center"><br/><label>Contatos: contato@web10.eti.br <br/><br/></label></td>

            </tr>
        </table>
    </body>
</html>
<c:if test="${!empty redirect }">
    <script>

        setTimeout("redirect()",2000)
        function redirect() {
            document.location="${redirect}";
        }


    </script>
</c:if>
