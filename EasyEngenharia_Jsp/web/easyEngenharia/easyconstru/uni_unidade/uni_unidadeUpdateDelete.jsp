<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="*"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>                                         
${uni_unidadeJB.execute}                                         


<form name="uni_unidade" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDelete.jsp"/>
    <center>     
        <label class="msg">${uni_unidadeJB.msg}</label><br/>

        <table align="center" border="0" width="50%">
            <tr>
                <td>
                    <label>uni_nr_id:</label>
                </td>
                <td>
                    <input type="text" name="uni_unidadeT.uni_nr_id" value="${uni_unidadeJB.uni_unidadeT.uni_nr_id}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>uni_tx_nome:</label>
                </td>
                <td>
                    <input type="text" name="uni_unidadeT.uni_tx_nome" value="${uni_unidadeJB.uni_unidadeT.uni_tx_nome}" onKeyPress="nextField(this, event)"/>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="Consult" onClick="setOpPortal('uni_unidade', 'consult', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Update"  onClick="setOpPortal('uni_unidade', 'update' , '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Delete"  onClick="setOpPortal('uni_unidade', 'delete' , '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
                    <input type="button" value="Cancel"  onClick="setOpPortal('uni_unidade', 'consult' , '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp')" />
                </td>
            </tr>
        </table>

        <br/>

    </center>     

</form>
