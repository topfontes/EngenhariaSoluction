<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Plco_plano_contas_orcamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>                                         
${plco_plano_contas_orcamentoJB.execute}                                         
                                                                                

<form name="plco_plano_contas_orcamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${plco_plano_contas_orcamentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_nr_id" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_tx_nome" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_tipo:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_tx_tipo" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_tx_tipo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_cod_externo:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_tx_cod_externo" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_tx_cod_externo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_unidade:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_tx_unidade" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_tx_unidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_id_super:</label>
	</td>
	<td>
		<input type="text" name="plco_plano_contas_orcamentoT.plco_nr_id_super" value="${plco_plano_contas_orcamentoJB.plco_plano_contas_orcamentoT.plco_nr_id_super}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('plco_plano_contas_orcamento', 'consult', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('plco_plano_contas_orcamento', 'update' , '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('plco_plano_contas_orcamento', 'delete' , '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('plco_plano_contas_orcamento', 'consult' , '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
