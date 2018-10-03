<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Plco_plano_contas_orcamentoInsertJB" scope="request"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>                                         
${plco_plano_contas_orcamentoJB.execute}                                         
                                                                               
	
<form name="plco_plano_contas_orcamento" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoInsert.jsp"/>
    <center>     
     	<label class="msg">${plco_plano_contas_orcamentoJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('plco_plano_contas_orcamento','insert', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('plco_plano_contas_orcamento','clear', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('plco_plano_contas_orcamento','', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
