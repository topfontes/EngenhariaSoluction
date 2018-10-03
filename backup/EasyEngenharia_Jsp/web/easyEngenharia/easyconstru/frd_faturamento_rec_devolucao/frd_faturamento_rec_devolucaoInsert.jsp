<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="frd_faturamento_rec_devolucaoJB" class="br.com.easynet.gwt.easyportal.jb.Frd_faturamento_rec_devolucaoInsertJB" scope="request"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="*"/>                                         
<jsp:setProperty name="frd_faturamento_rec_devolucaoJB" property="page" value="${pageContext}"/>                                         
${frd_faturamento_rec_devolucaoJB.execute}                                         
                                                                               
	
<form name="frd_faturamento_rec_devolucao" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoInsert.jsp"/>
    <center>     
     	<label class="msg">${frd_faturamento_rec_devolucaoJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>frd_nr_valor_permutado:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_valor_permutado" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_permutado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_vgv:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_vgv" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_vgv}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_valor_devolucao:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_valor_devolucao" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_devolucao}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_valor_faturamento:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_valor_faturamento" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_faturamento}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_valor_recebimento:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_valor_recebimento" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_recebimento}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_valor_permutas:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_valor_permutas" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_valor_permutas}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.obr_nr_id" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_mes" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>frd_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="frd_faturamento_rec_devolucaoT.frd_nr_ano" value="${frd_faturamento_rec_devolucaoJB.frd_faturamento_rec_devolucaoT.frd_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('frd_faturamento_rec_devolucao','insert', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('frd_faturamento_rec_devolucao','clear', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('frd_faturamento_rec_devolucao','', '/EasyEngenharia/easyconstru/frd_faturamento_rec_devolucao/frd_faturamento_rec_devolucaoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
