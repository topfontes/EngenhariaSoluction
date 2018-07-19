<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cen_centro_custoJB" class="br.com.easynet.gwt.easyportal.jb.Cen_centro_custoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="*"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="page" value="${pageContext}"/>                                         
${cen_centro_custoJB.execute}                                         
                                                                                

<form name="cen_centro_custo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${cen_centro_custoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>cen_nr_id:</label>
	</td>
	<td>
		<input type="text" name="cen_centro_custoT.cen_nr_id" value="${cen_centro_custoJB.cen_centro_custoT.cen_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cen_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="cen_centro_custoT.cen_tx_nome" value="${cen_centro_custoJB.cen_centro_custoT.cen_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('cen_centro_custo', 'consult', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('cen_centro_custo', 'update' , '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('cen_centro_custo', 'delete' , '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('cen_centro_custo', 'consult' , '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
