<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeInsertJB" scope="request"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="*"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>                                         
${uni_unidadeJB.execute}                                         
                                                                               
	
<form name="uni_unidade" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/uni_unidade/uni_unidadeInsert.jsp"/>
    <center>     
     	<label class="msg">${uni_unidadeJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('uni_unidade','insert', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('uni_unidade','clear', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('uni_unidade','', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
