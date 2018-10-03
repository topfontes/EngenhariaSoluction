<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.easyportal.jb.Cli_clienteInsertJB" scope="request"/>                                         
<jsp:setProperty name="cli_clienteJB" property="*"/>                                         
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>                                         
${cli_clienteJB.execute}                                         
                                                                               
	
<form name="cli_cliente" action="portal.jsp" method="post" enctype="multipart/form-data" > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cli_cliente/cli_clienteInsert.jsp"/>
    <center>     
     	<label class="msg">${cli_clienteJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>cli_tx_nome:</label>
	</td>
	<td>
            <input type="text" style="visibility: visible" name="cli_clienteT.cli_tx_nome" value="${cli_clienteJB.cli_clienteT.cli_tx_nome}" onKeyPress="nextField(this, event)"/>
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_tipo_pessoa:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_tipo_pessoa" value="${cli_clienteJB.cli_clienteT.cli_tx_tipo_pessoa}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_cnpj_cpf:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_cnpj_cpf" value="${cli_clienteJB.cli_clienteT.cli_tx_cnpj_cpf}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_endereco:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_endereco" value="${cli_clienteJB.cli_clienteT.cli_tx_endereco}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_bairro:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_bairro" value="${cli_clienteJB.cli_clienteT.cli_tx_bairro}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_cidade:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_cidade" value="${cli_clienteJB.cli_clienteT.cli_tx_cidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_telefone:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_telefone" value="${cli_clienteJB.cli_clienteT.cli_tx_telefone}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_fax:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_fax" value="${cli_clienteJB.cli_clienteT.cli_tx_fax}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_telefone2:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_telefone2" value="${cli_clienteJB.cli_clienteT.cli_tx_telefone2}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_by_logomarca:</label>
	</td>
	<td>
		<input type="file" name="cli_clienteT.cli_by_logomarca" value="" onKeyPress="nextField(this, event)"/> <img border="0" src="cli_clienteUpdateDelete.jsp?op=downloadImage&cli_clienteT.cli_nr_id=${cli_clienteJB.cli_clienteT.cli_nr_id}&"/>
	</td>
     </tr>
     <tr>
	<td>
		<label>cli_tx_email:</label>
	</td>
	<td>
		<input type="text" name="cli_clienteT.cli_tx_email" value="${cli_clienteJB.cli_clienteT.cli_tx_email}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('cli_cliente','insert', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('cli_cliente','clear', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('cli_cliente','', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
