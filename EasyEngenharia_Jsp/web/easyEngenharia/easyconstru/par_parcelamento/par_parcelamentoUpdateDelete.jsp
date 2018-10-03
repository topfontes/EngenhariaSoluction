<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="par_parcelamentoJB" class="br.com.easynet.gwt.easyportal.jb.Par_parcelamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="*"/>                                         
<jsp:setProperty name="par_parcelamentoJB" property="page" value="${pageContext}"/>                                         
${par_parcelamentoJB.execute}                                         
                                                                                

<form name="par_parcelamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${par_parcelamentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>par_nr_id:</label>
	</td>
	<td>
		<input type="text" name="par_parcelamentoT.par_nr_id" value="${par_parcelamentoJB.par_parcelamentoT.par_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
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
		<input type="button" value="Consult" onClick="setOpPortal('par_parcelamento', 'consult', '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('par_parcelamento', 'update' , '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('par_parcelamento', 'delete' , '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('par_parcelamento', 'consult' , '/easyEngenharia/easyconstru/par_parcelamento/par_parcelamentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
