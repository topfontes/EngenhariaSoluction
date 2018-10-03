<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="flr_fluxo_receitaJB" class="br.com.easynet.gwt.easyportal.jb.Flr_fluxo_receitaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="*"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="page" value="${pageContext}"/>                                         
${flr_fluxo_receitaJB.execute}                                         
                                                                                

<form name="flr_fluxo_receita" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${flr_fluxo_receitaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>flr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_nr_id" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>flr_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_nr_mes" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>flr_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_nr_ano" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>flr_nr_original:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_nr_original" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_original}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>flr_nr_atual:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_nr_atual" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_nr_atual}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>flr_tx_key:</label>
	</td>
	<td>
		<input type="text" name="flr_fluxo_receitaT.flr_tx_key" value="${flr_fluxo_receitaJB.flr_fluxo_receitaT.flr_tx_key}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('flr_fluxo_receita', 'consult', '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('flr_fluxo_receita', 'update' , '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('flr_fluxo_receita', 'delete' , '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('flr_fluxo_receita', 'consult' , '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
