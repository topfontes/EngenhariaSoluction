<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="emp_empreendimentoJB" class="br.com.easynet.gwt.easyportal.jb.Emp_empreendimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="*"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="page" value="${pageContext}"/>                                         
${emp_empreendimentoJB.execute}                                         
                                                                                

<form name="emp_empreendimento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${emp_empreendimentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>emp_nr_id:</label>
	</td>
	<td>
		<input type="text" name="emp_empreendimentoT.emp_nr_id" value="${emp_empreendimentoJB.emp_empreendimentoT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>emp_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="emp_empreendimentoT.emp_tx_nome" value="${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>emp_tx_bairro:</label>
	</td>
	<td>
		<input type="text" name="emp_empreendimentoT.emp_tx_bairro" value="${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_bairro}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>emp_tx_cidade:</label>
	</td>
	<td>
		<input type="text" name="emp_empreendimentoT.emp_tx_cidade" value="${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_cidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>emp_tx_uf:</label>
	</td>
	<td>
		<input type="text" name="emp_empreendimentoT.emp_tx_uf" value="${emp_empreendimentoJB.emp_empreendimentoT.emp_tx_uf}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>cli_nr_id:</label>
	</td>
	<td>
	    <select name="emp_empreendimentoT.cli_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${emp_empreendimentoJB.listcli_cliente}" var="item">
            	  <option value="${item.cli_nr_id}">${item.cli_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('emp_empreendimento', 'consult', '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('emp_empreendimento', 'update' , '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('emp_empreendimento', 'delete' , '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('emp_empreendimento', 'consult' , '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
