<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.easyportal.jb.For_fornecedorInsertJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
                                                                               
	
<form name="for_fornecedor" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorInsert.jsp"/>
    <center>     
     	<label class="msg">${for_fornecedorJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>for_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_nome" value="${for_fornecedorJB.for_fornecedorT.for_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_cnpj:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_cnpj" value="${for_fornecedorJB.for_fornecedorT.for_tx_cnpj}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_endereco:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_endereco" value="${for_fornecedorJB.for_fornecedorT.for_tx_endereco}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_bairro:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_bairro" value="${for_fornecedorJB.for_fornecedorT.for_tx_bairro}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_cidade:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_cidade" value="${for_fornecedorJB.for_fornecedorT.for_tx_cidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_uf:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_uf" value="${for_fornecedorJB.for_fornecedorT.for_tx_uf}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_contato:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_contato" value="${for_fornecedorJB.for_fornecedorT.for_tx_contato}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_telefone:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_telefone" value="${for_fornecedorJB.for_fornecedorT.for_tx_telefone}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_tx_email:</label>
	</td>
	<td>
		<input type="text" name="for_fornecedorT.for_tx_email" value="${for_fornecedorJB.for_fornecedorT.for_tx_email}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('for_fornecedor','insert', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('for_fornecedor','clear', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('for_fornecedor','', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
