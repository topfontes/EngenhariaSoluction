<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="set_setorJB" class="br.com.easynet.gwt.easyportal.jb.Set_setorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
                                                                                

<form name="set_setor" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/set_setor/set_setorUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${set_setorJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>set_nr_id:</label>
	</td>
	<td>
		<input type="text" name="set_setorT.set_nr_id" value="${set_setorJB.set_setorT.set_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
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
		<input type="button" value="Consult" onClick="setOpPortal('set_setor', 'consult', '/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('set_setor', 'update' , '/easyEngenharia/easyconstru/set_setor/set_setorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('set_setor', 'delete' , '/easyEngenharia/easyconstru/set_setor/set_setorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('set_setor', 'consult' , '/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
