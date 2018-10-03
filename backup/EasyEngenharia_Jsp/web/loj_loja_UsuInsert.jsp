<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="loj_lojaJB" class="br.com.easynet.easyfin.jb.Loj_Loja_UsuInsertJB" scope="request"/>
<jsp:setProperty name="loj_lojaJB" property="*"/>
<jsp:setProperty name="loj_lojaJB" property="page" value="${pageContext}"/>
${loj_lojaJB.execute}



<link rel="StyleSheet" href="./portal/tree/dtree.css" type="text/css" />
<script type="text/javascript" src="./portal/tree/dtree.js"></script>
<style>
    table.bordasimples2 {border-collapse: collapse;}
    table.bordasimples2 tr td {border:1px solid #FFFF00;}
</style>

<style>
    table.bordasimples {border:1px solid #191970;}

</style>





<html>
    <head>
        <title>Cadastro Loja</title>
        <link href="css/model.css" rel="stylesheet" type="text/css" />
        <script src="script/eventos.js"></script>
    </head>

    <body>

        <table border="0" cellpadding="0" cellspacing="0" width="1024" align="center">

            <tr>
                <td><img src="images/spacer.gif" width="233" height="1" border="0" alt="" /></td>
                <td><img src="images/spacer.gif" width="791" height="1" border="0" alt="" /></td>
                <td><img src="images/spacer.gif" width="1" height="1" border="0" alt="" /></td>
            </tr>

            <tr>
                <td><img name="EASYFIN2_r1_c1" src="images/EASYFIN2_r1_c1.jpg" width="233" height="45" border="0" id="EASYFIN2_r1_c1" alt="" /></td>
                <!--td><img name="EASYFIN2_r1_c2" src="../images/EASYFIN2_r1_c2.jpg" width="791" height="45" border="0" id="EASYFIN2_r1_c2" alt="" /></td-->
                <td style="background-image:url(images/EASYFIN2_r1_c2.jpg)">
                    &nbsp;

                </td>

                <td></td>
            </tr>
            <tr>
                <td colspan="3">

                    <form action="loj_loja_UsuInsert.jsp" method="post">
                        <input type="hidden" name="op" />
                        <center>
                            <label class="msg">${loj_lojaJB.msg}</label><br/>
                            <table width="95%" border="0">
                                <tr>
                                    <td rowspan="21" width="33%" >
                                            <table width="100%" border="0" >

                                                <tr><td><a href="javascript: d.openAll();">abrir todos</a> | <a href="javascript: d.closeAll();">fechar todos</a></td></tr>

                                                <tr>
                                                    <td>
                                                         <div id="Layer1" style=" left:0px; top:0px; width:auto; height:360px; z-index:1; overflow: scroll; overflow-x:hidden;overflow-y:auto">
                                                            <div class="dtree" >

                                                            <!--	<a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a>-->
                                                                    <script type="text/javascript">

                                                                            d = new dTree('d');
                                             d.add(0,-1,'Funcionalidades ');
                                             d.add(1,0,'Cadastro');
                                             d.add(4,1,'Controle de Clientes');
                                             d.add(5,1,'Controle de Fornecedores');
                                             d.add(6,1,'Bancos');
                                             d.add(7,1,'Cartões de Crédito');
                                             d.add(26,1,'Forma de Pagamento');
                                             d.add(27,1,'Parcelamentos');
                                             d.add(32,1,'. . .');

                                             d.add(2,0,'Regra de Negócios');
                                             d.add(9,2,'Controle de Contas Contábeis');
                                             d.add(10,2,'Controle de Centro de Custo');
                                             d.add(11,2,'Previsão ORçamentária');
                                             d.add(12,2,'Regras de Negócio');
                                             d.add(13,2,'Lançamentos Contábeis');
                                             d.add(14,2,'Lançamentos Centro de Custo');
                                             d.add(15,2,'Contas a Pagar/Receber');
                                             d.add(16,1,'. . . ');
                                            d.add(3,0,'Relatório');
                                            d.add(17,3,'DRE(Demonstrativo do Resultado da Empresa)');
                                            d.add(18,3,'Fluxo de caixa');
                                            d.add(19,3,'Razão Analítico');
                                            d.add(20,3,'Movimentação Financeira');
                                            d.add(21,3,'Contas Pagar/Receber');
                                            d.add(22,3,'Centro de Custo');
                                            d.add(23,3,'. . .');

                                             d.add(40,0,'Utilitários');
                                             d.add(24,40,'Sistema de Segurança');
                                             d.add(25,40,'Sistema de Log');
                                             document.write(d);

                                                                    </script>

                                                            </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                            </table>
                                    
                                   </td>
                                </tr>
                                <tr><td rowspan="20" width="4%" > &nbsp;</td></tr>
                                <tr>
                                    <td width="10%">
                                        <label>Empresa: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_razao_social" value="${loj_lojaJB.loj_lojaT.loj_tx_razao_social}" size="70"maxlength="50"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Nome Fantasia: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_nome_fantasia" value="${loj_lojaJB.loj_lojaT.loj_tx_nome_fantasia}" size="70" maxlength="50"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>CPF/CNPJ: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_cnpj" value="${loj_lojaJB.loj_lojaT.loj_tx_cnpj}" onKeyPress="mascara(this,soNumeros)"maxlength="14"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>RG/Inscriao: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_inscricao" value="${loj_lojaJB.loj_lojaT.loj_tx_inscricao}" onKeyPress="mascara(this,soNumeros)"maxlength="14"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Endereço: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_endereco" value="${loj_lojaJB.loj_lojaT.loj_tx_endereco}"size="70" maxlength="100"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Bairro: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_bairro" value="${loj_lojaJB.loj_lojaT.loj_tx_bairro}" size="70"maxlength="50"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Cidade: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_cidade" value="${loj_lojaJB.loj_lojaT.loj_tx_cidade}" size="50" maxlength="50"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>UF: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_estado" value="${loj_lojaJB.loj_lojaT.loj_tx_estado}" size="10" maxlength="2"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>CEP:</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_cep" value="${loj_lojaJB.loj_lojaT.loj_tx_cep}"maxlength="8"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label>Email: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_email" value="${loj_lojaJB.loj_lojaT.loj_tx_email}" size="50" maxlength="50"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Home Page:</label>
                                    </td>
                                    <td>
                                        <input type="text" name="loj_lojaT.loj_tx_home_page" value="${loj_lojaJB.loj_lojaT.loj_tx_home_page}" size="70"maxlength="50"/>
                                    </td>
                                </tr>

                                <tr><td colspan="2"><hr></td></tr>


                                <tr>
                                    <td>
                                        <label>Nome Usuário: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="usu_usuarioT.usu_tx_nome" value="${loj_lojaJB.usu_usuarioT.usu_tx_nome}"size="70" maxlength="50" />
                                    </td>

                                </tr>

                                <tr>
                                    <td>
                                        <label>Login: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="usu_usuarioT.usu_tx_login" value="${loj_lojaJB.usu_usuarioT.usu_tx_login}"maxlength="10"/>
                                    </td>

                                </tr>
                                <tr>
                                    <td>
                                        <label>Senha: *</label>
                                    </td>
                                    <td>
                                        <input type="password" name="usu_usuarioT.usu_tx_senha" maxlength="20"/>
                                    </td>

                                </tr>

                                <tr>
                                    <td>
                                        <label>Email: *</label>
                                    </td>
                                    <td>
                                        <input type="text" name="usu_usuarioT.usu_tx_email" value="${loj_lojaJB.usu_usuarioT.usu_tx_email}"size="70" maxlength="50"/>
                                    </td>

                                </tr>
                                <tr><td colspan="2">&nbsp;</td></tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <input type="button" value="Cadastrar" onclick="setOp('insert')"/> &nbsp;&nbsp;
                                        <label></label> <a href="autentication.jsp">Volta ao Login</a>
                                    </td>
                                </tr>

                            </table>
                        </center>


                    </form>

                </td>
            </tr>
            <tr>
                <td colspan="3" align="center" style="background-image:url(images/EASYFIN2_r4_c1.jpg);text-align:center"><br/><label>Contatos: contato@web10.eti.br <br/><br/></label></td>

            </tr>

        </table>
    </body>
</html>
