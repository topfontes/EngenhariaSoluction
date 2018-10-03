<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cen_centro_custoJB" class="br.com.easynet.gwt.easyportal.jb.Cen_centro_custoInsertJB" scope="request"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="*"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="page" value="${pageContext}"/>                                         
${cen_centro_custoJB.execute}                                         
                                                                               
	
<form name="cen_centro_custo" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoInsert.jsp"/>
    <center>     
     	<label class="msg">${cen_centro_custoJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>cen_tx_nome:</label>
	</td>
	<td>
            <input type="text" style="font-style: inherit" name="cen_centro_custoT.cen_tx_nome" value="${cen_centro_custoJB.cen_centro_custoT.cen_tx_nome}" onKeyPress="nextField(this, event)"/>
 	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('cen_centro_custo','insert', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('cen_centro_custo','clear', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('cen_centro_custo','', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
