<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="set_setorJB" class="br.com.easynet.gwt.easyportal.jb.Set_setorInsertJB" scope="request"/>                                         
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
                                                                               
	
<form name="set_setor" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/set_setor/set_setorInsert.jsp"/>
    <center>     
     	<label class="msg">${set_setorJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>set_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="set_setorT.set_tx_nome" value="${set_setorJB.set_setorT.set_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('set_setor','insert', '/easyEngenharia/easyconstru/set_setor/set_setorInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('set_setor','clear', '/easyEngenharia/easyconstru/set_setor/set_setorInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('set_setor','', '/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
