<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="fol_folha_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fol_folha_pagamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fol_folha_pagamentoJB.execute}                                         
                                                                                

<form name="fol_folha_pagamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${fol_folha_pagamentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>fol_nr_id:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_id" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="fol_folha_pagamentoT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${fol_folha_pagamentoJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="fol_folha_pagamentoT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${fol_folha_pagamentoJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>fol_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_mes" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_ano" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_tx_funcao:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_tx_funcao" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_tx_funcao}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_salario_bruto_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_salario_bruto_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_salario_bruto_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_adiantamento_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_adiantamento_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_adiantamento_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_horas_extra_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_horas_extra_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_horas_extra_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_salario_bruto_nao_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_salario_bruto_nao_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_adiantamento_nao_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_adiantamento_nao_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_horas_extra_nao_oficial:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_horas_extra_nao_oficial}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fol_nr_numero_funcionario:</label>
	</td>
	<td>
		<input type="text" name="fol_folha_pagamentoT.fol_nr_numero_funcionario" value="${fol_folha_pagamentoJB.fol_folha_pagamentoT.fol_nr_numero_funcionario}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('fol_folha_pagamento', 'consult', '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('fol_folha_pagamento', 'update' , '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('fol_folha_pagamento', 'delete' , '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('fol_folha_pagamento', 'consult' , '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
