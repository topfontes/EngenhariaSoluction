<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ccff_copia_cronograma_fisico_financeiroJB" class="br.com.easynet.gwt.easyportal.jb.Ccff_copia_cronograma_fisico_financeiroInsertJB" scope="request"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="*"/>                                         
<jsp:setProperty name="ccff_copia_cronograma_fisico_financeiroJB" property="page" value="${pageContext}"/>                                         
${ccff_copia_cronograma_fisico_financeiroJB.execute}                                         
                                                                               
	
<form name="ccff_copia_cronograma_fisico_financeiro" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroInsert.jsp"/>
    <center>     
     	<label class="msg">${ccff_copia_cronograma_fisico_financeiroJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','insert', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','clear', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('ccff_copia_cronograma_fisico_financeiro','', '/easyEngenharia/easyconstru/ccff_copia_cronograma_fisico_financeiro/ccff_copia_cronograma_fisico_financeiroConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
