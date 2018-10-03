<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="con_contatosJB" class="br.com.easynet.gwt.easyportal.jb.Con_contatosUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="con_contatosJB" property="*"/>                                         
<jsp:setProperty name="con_contatosJB" property="page" value="${pageContext}"/>                                         
${con_contatosJB.execute}                                         
                                                                                

<form name="con_contatos" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${con_contatosJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>con_nr_id:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_nr_id" value="${con_contatosJB.con_contatosT.con_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="con_contatosT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${con_contatosJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>con_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_tx_nome" value="${con_contatosJB.con_contatosT.con_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>set_nr_id:</label>
	</td>
	<td>
	    <select name="con_contatosT.set_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${con_contatosJB.listset_setor}" var="item">
            	  <option value="${item.set_nr_id}">${item.set_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>con_tx_cargo_exercicio:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_tx_cargo_exercicio" value="${con_contatosJB.con_contatosT.con_tx_cargo_exercicio}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>con_tx_telefone:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_tx_telefone" value="${con_contatosJB.con_contatosT.con_tx_telefone}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>con_tx_telefone2:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_tx_telefone2" value="${con_contatosJB.con_contatosT.con_tx_telefone2}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>con_tx_email:</label>
	</td>
	<td>
		<input type="text" name="con_contatosT.con_tx_email" value="${con_contatosJB.con_contatosT.con_tx_email}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('con_contatos', 'consult', '/easyEngenharia/easyconstru/con_contatos/con_contatosConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('con_contatos', 'update' , '/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('con_contatos', 'delete' , '/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('con_contatos', 'consult' , '/easyEngenharia/easyconstru/con_contatos/con_contatosConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
