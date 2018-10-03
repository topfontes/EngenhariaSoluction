<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>                                         
${nfe_nota_fiscal_entradaJB.execute}                                         
                                                                                

<form name="nfe_nota_fiscal_entrada" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${nfe_nota_fiscal_entradaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>nfe_nr_id:</label>
	</td>
	<td>
		<input type="text" name="nfe_nota_fiscal_entradaT.nfe_nr_id" value="${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>nfe_dt_emissao:</label>
	</td>
	<td>
		<input type="text" name="nfe_nota_fiscal_entradaT.nfe_dt_emissao" value="<fmt:formatDate value="${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_dt_emissao}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>for_nr_id:</label>
	</td>
	<td>
		<input type="text" name="nfe_nota_fiscal_entradaT.for_nr_id" value="${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.for_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>nfe_nr_valor_nota:</label>
	</td>
	<td>
		<input type="text" name="nfe_nota_fiscal_entradaT.nfe_nr_valor_nota" value="${nfe_nota_fiscal_entradaJB.nfe_nota_fiscal_entradaT.nfe_nr_valor_nota}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('nfe_nota_fiscal_entrada', 'consult', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('nfe_nota_fiscal_entrada', 'update' , '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('nfe_nota_fiscal_entrada', 'delete' , '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('nfe_nota_fiscal_entrada', 'consult' , '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
