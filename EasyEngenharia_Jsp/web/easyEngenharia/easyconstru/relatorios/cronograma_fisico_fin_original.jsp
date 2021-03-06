<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cffoJB" class="br.com.easynet.gwt.easyportal.jb.Cronograma_fisico_fin_originalJB" scope="request"/>
<jsp:setProperty name="cffoJB" property="*"/>
<jsp:setProperty name="cffoJB" property="page" value="${pageContext}"/>
${cffoJB.execute}
<form>
    <img border="0" src="/engenharia/easyEngenharia/easyconstru/relatorios/cronograma_fisico_fin_original.jsp?op=downloadImage"/>
    <table>
        <tr>
            <td colspan="2" style="font-family: tahoma;font-size: 16">
                <strong>Relat�rio Cronograma F�sico-Financeiro Por Regime de Compet�ncia Original</strong>
            </td>
        </tr>
        <tr>
            <td width="20">
                CLIENTE:
            </td>
            <td>${cffoJB.cli_clienteT.cli_tx_nome}</td>
        </tr>
        <tr>
            <td width="20">
                OBRA:
            </td>
            <td>${cffoJB.obr_obrasT.obr_tx_nome}</td>
        </tr>
    </table>
    <hr>
    <br/>
    <table border="1" width="100%" style="font-family: tahoma;font-size: 12px;border-collapse: collapse" bordercolor="black" >
        <c:forEach var="item" items="${cffoJB.listServico}" varStatus="cont">
            <c:if test="${cont.count == 1}">
                <tr>
                    <td> C�digo </td>
                    <td> Nome </td>
                    <td> UND </td>
                    <td align="right"> Quantidade </td>
                    <td align="right"> Vl. Unit�rio </td>
                    <td align="right"> Vl. Parcial </td>
                    <c:forEach var="mes" items="${item.listMesesObra}">
                        <td align="right">${mes.mes_ano}</td>
                    </c:forEach>
                </tr>
            </c:if>
            <tr>
                <td valign="top"> ${item.plco_tx_unidade == null?'<strong>':''} ${item.plco_tx_cod_externo}${item.plco_tx_unidade == null?'</strong>':''}</td>
                <td valign="top"> ${item.plco_tx_unidade == null?'<strong>':''}${item.plco_tx_nome} ${item.plco_tx_unidade == null?'</strong>':''} </td>
                <td valign="top"> ${item.plco_tx_unidade == null?'<strong>':''}${item.plco_tx_unidade} ${item.plco_tx_unidade == null?'</strong>':''}</td>
                <td valign="top" align="right"> <c:if test="${item.plco_tx_unidade != null}"> <fmt:formatNumber value="${item.plco_nr_quantidade}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </c:if> </td>
                <td valign="top" align="right"> <c:if test="${item.plco_tx_unidade != null}"><fmt:formatNumber value="${item.plco_nr_vl_unitario}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </c:if></td>
                <td valign="top" align="right"> <c:if test="${item.plco_tx_unidade != null}"><fmt:formatNumber value="${item.plco_nr_vl_total}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/><br/>Qtde.<br/>Valor</c:if> </td>
                    <c:forEach var="mes" items="${item.listMesesObra}" varStatus="linha">
                    <td align="right" ${linha.count %2==0?'bgcolor="#E6E8FA"':''}>
                        <c:if test="${mes.quantidade > 0}">
                            <fmt:formatNumber value="${mes.quantidade}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/>%<br/>
                            <fmt:formatNumber value="${mes.calc_quantidade_original}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/><br/>
                            <fmt:formatNumber value="${mes.calc_valor_original}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/>
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
            <td colspan="5">
                <label>Total (R$)</label></br>
                <label>% Executado no per�odo</label></br>
                <label>% Executado acumulado</label>

            </td>
            <td>
                <label><strong> <fmt:formatNumber value="${cffoJB.totalOrcamento}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/></label></strong></br>
            </td>
            <c:forEach var="item" items="${cffoJB.listTotalMeses}">
                <td align="right">
                    <label><strong>
                            <fmt:formatNumber value="${item.calc_valor_original}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/><br/>
                            <fmt:formatNumber value="${item.quantidade}"pattern="0.00%;-0.00%" minFractionDigits="2" type="currency"/> <br/>
                            <fmt:formatNumber value="${item.calc_quantidade_original}"pattern="0.00%;-0.00%" minFractionDigits="2" type="currency"/>
                        </strong></label>
                </td>
            </c:forEach>
        </tr>

    </table>
</form>
