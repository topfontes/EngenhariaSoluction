<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="cronoJB" class="br.com.easynet.gwt.easyportal.jb.Cronograma_desembolsoJB" scope="request"/>
<jsp:setProperty name="cronoJB" property="*"/>
<jsp:setProperty name="cronoJB" property="page" value="${pageContext}"/>
${cronoJB.execute}
<form>
    <img border="0" src="/engenharia/easyEngenharia/easyconstru/relatorios/cronograma_desembolso.jsp?op=downloadImage"/>
    <table>
        <tr>
            <td colspan="2" style="font-family: tahoma;font-size: 16">
                <strong>${cronoJB.tipo =='R'?'Relatório Cronograma Físico Financeiro Previsto por Regime de Caixa Atualizado.':'Relatório Cronograma Físico Financeiro Previsto Por Regime de Caixa Original.'}</strong>
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
    <c:if test="${cronoJB.equiv_OK == true}">
        <table border="1" width="100%" style="font-family: tahoma;font-size: 12px;border-collapse: collapse" bordercolor="black" >
            <c:forEach var="item" items="${cronoJB.listServico}" varStatus="cont">
                <c:if test="${cont.count == 1}">
                    <tr>
                        <td> Código </td>
                        <td> Nome </td>
                        <td> UND </td>
                        <td align="right"> Quantidade </td>
                        <td align="right"> Vl. Unitário </td>
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
                    <td valign="top" align="right"> <c:if test="${item.plco_tx_unidade != null}"><fmt:formatNumber value="${item.plco_nr_vl_total}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/></c:if> </td>
                    <c:forEach var="mes" items="${item.listMesesObra}" varStatus="linha">
                        <td valign="top" align="right" ${linha.count %2==0?'bgcolor="#E6E8FA"':''}>
                            <c:if test="${mes.calc_valor_copia > 0}">
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
                <td colspan="4"><label>Total</label></td>
                <td colspan="2"><label><strong><fmt:formatNumber value="${cronoJB.totalGeral}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/>  </strong></label></td>
                <c:forEach var="item" items="${cronoJB.listTotalMeses}">
                    <td align="right">
                        <label><strong> <fmt:formatNumber value="${item.totalMes}"pattern="#,##0.00;-#,##0.00" minFractionDigits="2" type="currency"/> </strong></label>
                    </td>
                </c:forEach>
            </tr>
        </table>
    </c:if>
    <c:if test="${cronoJB.equiv_OK == false}">
        Os Itens abaixo estão sem equivalência
        <table>
            <c:forEach var="item" items="${cronoJB.listNotEquivalencia}">
            <tr>
                <td>${item.plco_tx_cod_externo}</td>
                <td>${item.plco_tx_nome}</td>
            </tr>
            </c:forEach>
        </table>
    </c:if>
</form>
