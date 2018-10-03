<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="par_parcelamentoJB" class="br.com.easynet.gwt.easyportal.jb.Par_parcelamentoInsertJB" scope="request"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="*"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="page" value="${pageContext}"/>                                         
${par_parcelamentoJB.execute}                                         
                                                                               
	
<form name="par_parcelamento" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoInsert.jsp"/>
    <center>     
     	<label class="msg">${par_parcelamentoJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>par_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="par_parcelamentoT.par_tx_nome" value="${par_parcelamentoJB.par_parcelamentoT.par_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>par_nr_parcelas:</label>
	</td>
	<td>
		<input type="text" name="par_parcelamentoT.par_nr_parcelas" value="${par_parcelamentoJB.par_parcelamentoT.par_nr_parcelas}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>par_nr_intervalo_dias:</label>
	</td>
	<td>
		<input type="text" name="par_parcelamentoT.par_nr_intervalo_dias" value="${par_parcelamentoJB.par_parcelamentoT.par_nr_intervalo_dias}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('par_parcelamento','insert', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('par_parcelamento','clear', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('par_parcelamento','', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
