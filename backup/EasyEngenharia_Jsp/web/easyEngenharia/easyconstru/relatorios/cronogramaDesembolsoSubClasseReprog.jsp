<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cronoJB" class="br.com.easynet.gwt.easyportal.jb.CronogramaDesembolsoSubClasseReprogJB" scope="request"/>
<jsp:setProperty name="cronoJB" property="*"/>
<jsp:setProperty name="cronoJB" property="page" value="${pageContext}"/>
${cronoJB.execute}
<form>
    <img border="0" src="/engenharia/easyEngenharia/easyconstru/relatorios/cronogramaDesembolsoSubClasseReprog.jsp?op=downloadImage"/>
    <table>
        <tr>
            <td colspan="2" style="font-family: tahoma;font-size: 16">
                <strong>${cronoJB.tipo =='R'?'Relatório Cronograma Físico-Financeiro de Desembolso por Regime de Caixa Atualizado':'Relatório Cronograma Físico-Financeiro de Desembolso por Regime de Caixa Original'}</strong>
            </td>
        </tr>
        <tr>
            <td width="20">
                CLIENTE:
            </td>
            <td>${cronoJB.cli_clienteT.cli_tx_nome}</td>
        </tr>
        <tr>
            <td width="20">
                OBRA:
            </td>
            <td>${cronoJB.obr_obrasT.obr_tx_nome}</td>
        </tr>
    </table>
    <hr>
    <br/>
    <c:if test="${cronoJB.msg == '0'}">
        <table border="1" width="100%" style="font-family: tahoma;font-size: 12px;border-collapse: collapse" bordercolor="black" >
            <c:forEach var="item" items="${cronoJB.listServico}" varStatus="cont">
                <c:if test="${cont.count == 1}">
                    <tr>
                        <td bgcolor="#E6E8FA">Fator atual</td>
                        <td bgcolor="#E6E8FA">Fator proj.</td>
                        <td bgcolor="#E6E8FA"> Classe </td>
                        <td bgcolor="#E6E8FA"> Sub Classe </td>
                        <c:forEach var="mes" items="${item.listMesesObra}">
                            <td align="right" bgcolor="#E6E8FA">${mes.mes_ano}</td>
                        </c:forEach>
                    </tr>
                </c:if>
                <tr>
                    <td bgcolor="#E6E8FA"><fmt:formatNumber value="${item.fator_Atual}" pattern="0.00"/></td>
                    <td><fmt:formatNumber value="${item.fator_projetado}" pattern="0.00;-0.00" minFractionDigits="2" type="currency"/></td>
                    <td valign="top"> ${item.plc_tx_nome_super}</td>
                    <td valign="top">${item.plco_tx_nome}</td>
                    <c:forEach var="mes" items="${item.listMesesObra}" varStatus="linha">
                        <td valign="top" align="right" ${linha.count %2==0?'bgcolor="#E6E8FA"':''}>
                            <c:if test="${mes.calc_valor_copia != 0}">
                                <fmt:formatNumber value="${mes.calc_valor_copia}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/>
                            </c:if>
                        </td>
                    </c:forEach>
                </tr>
                <c:if test="${item.plco_nr_nivel ==14}">
                    <tr>
                        <td colspan="115"><hr></td>
                    </tr>
                </c:if>
            </c:forEach>
            <tr>
                <td colspan="3"><label><strong>Totais :</strong></label></td>
                <td align="right"><strong><fmt:formatNumber value="${cronoJB.totalGeral}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </strong></td>
                <c:forEach var="item" items="${cronoJB.listMesesTotal}">
                    <td align="right"><strong><fmt:formatNumber value="${item.totalMes}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </strong></td>
                </c:forEach>
            </tr>
            <tr>
                <td colspan="120" align="right"><strong><fmt:formatNumber value="${cronoJB.totalGeral}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </strong></td>
            </tr>
        </table>
    </c:if>

    <c:if test="${cronoJB.msg != '0'}">
        Erro: ${cronoJB.erro}
        <label><strong style="color: red">${cronoJB.msg}</strong></label><br/>
        <table>
            <c:forEach var="item" items="${cronoJB.listImpoNotEquiv}">
                <tr>
                    <td>${item.plco_tx_cod_externo}</td>
                    <td>${item.plco_tx_nome}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</form>
