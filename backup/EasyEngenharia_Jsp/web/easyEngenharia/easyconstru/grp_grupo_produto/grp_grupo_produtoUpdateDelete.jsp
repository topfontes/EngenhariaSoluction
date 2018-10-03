<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>                                         
${grp_grupo_produtoJB.execute}                                         
                                                                                

<form name="grp_grupo_produto" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${grp_grupo_produtoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>grp_nr_id:</label>
	</td>
	<td>
		<input type="text" name="grp_grupo_produtoT.grp_nr_id" value="${grp_grupo_produtoJB.grp_grupo_produtoT.grp_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
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
		<input type="button" value="Consult" onClick="setOpPortal('grp_grupo_produto', 'consult', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('grp_grupo_produto', 'update' , '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('grp_grupo_produto', 'delete' , '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('grp_grupo_produto', 'consult' , '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
