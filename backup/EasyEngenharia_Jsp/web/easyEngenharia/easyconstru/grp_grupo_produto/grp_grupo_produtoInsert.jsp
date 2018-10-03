<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoInsertJB" scope="request"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>                                         
${grp_grupo_produtoJB.execute}                                         
                                                                               
	
<form name="grp_grupo_produto" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoInsert.jsp"/>
    <center>     
     	<label class="msg">${grp_grupo_produtoJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>grp_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="grp_grupo_produtoT.grp_tx_nome" value="${grp_grupo_produtoJB.grp_grupo_produtoT.grp_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('grp_grupo_produto','insert', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('grp_grupo_produto','clear', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('grp_grupo_produto','', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
