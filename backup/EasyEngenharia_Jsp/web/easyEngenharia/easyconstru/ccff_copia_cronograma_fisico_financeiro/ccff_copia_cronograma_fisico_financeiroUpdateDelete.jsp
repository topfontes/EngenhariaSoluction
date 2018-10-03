<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>                                         
${ccff_copia_cronograma_fisico_financeiroJB.execute}                                         
                                                                                

<form name="ccff_copia_cronograma_fisico_financeiro" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${ccff_copia_cronograma_fisico_financeiroJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>ccff_nr_id:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="ccff_copia_cronograma_fisico_financeiroT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ccff_copia_cronograma_fisico_financeiroJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="ccff_copia_cronograma_fisico_financeiroT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ccff_copia_cronograma_fisico_financeiroJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>ccff_nr_peso:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_peso}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ccff_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ccff_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ccff_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ccff_nr_valor:</label>
	</td>
	<td>
		<input type="text" name="ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor" value="${ccff_copia_cronograma_fisico_financeiroJB.ccff_copia_cronograma_fisico_financeiroT.ccff_nr_valor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro', 'consult', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro', 'update' , '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro', 'delete' , '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro', 'consult' , '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
