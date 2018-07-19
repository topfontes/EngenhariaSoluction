<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaInsertJB" scope="request"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="*"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>                                         
${pes_pessoaJB.execute}                                         
                                                                               
	
<form name="pes_pessoa" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaInsert.jsp"/>
    <center>     
     	<label class="msg">${pes_pessoaJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>pes_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="pes_pessoaT.pes_tx_nome" value="${pes_pessoaJB.pes_pessoaT.pes_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pes_tx_fone:</label>
	</td>
	<td>
		<input type="text" name="pes_pessoaT.pes_tx_fone" value="${pes_pessoaJB.pes_pessoaT.pes_tx_fone}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('pes_pessoa','insert', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('pes_pessoa','clear', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('pes_pessoa','', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
