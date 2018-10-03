<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_conta_pagar_alteradaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_conta_pagar_alteradaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="*"/>                                         
<jsp:setProperty name="vw_conta_pagar_alteradaJB" property="page" value="${pageContext}"/>                                         
${vw_conta_pagar_alteradaJB.execute}                                         
                                                                                

<form name="vw_conta_pagar_alterada" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_conta_pagar_alteradaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>ctp_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_nr_id" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_nr_mes" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_nr_ano" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_nr_documento:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_nr_documento" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_documento}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_tx_obs:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_tx_obs" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_tx_obs}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_tx_fornecedor:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_tx_fornecedor" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_tx_fornecedor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_nr_valor:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctp_nr_valor" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctp_nr_valor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctpm_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctpm_nr_mes" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctpm_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctpm_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="vw_conta_pagar_alteradaT.ctpm_nr_ano" value="${vw_conta_pagar_alteradaJB.vw_conta_pagar_alteradaT.ctpm_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_conta_pagar_alterada', 'consult', '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_conta_pagar_alterada', 'update' , '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_conta_pagar_alterada', 'delete' , '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_conta_pagar_alterada', 'consult' , '/easyEngenharia/easyconstru/vw_conta_pagar_alterada/vw_conta_pagar_alteradaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
