<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="nfe_nota_fiscal_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Nfe_nota_fiscal_entradaInsertJB" scope="request"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="*"/>                                         
<jsp:setProperty name="nfe_nota_fiscal_entradaJB" property="page" value="${pageContext}"/>                                         
${nfe_nota_fiscal_entradaJB.execute}                                         
                                                                               
	
<form name="nfe_nota_fiscal_entrada" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaInsert.jsp"/>
    <center>     
     	<label class="msg">${nfe_nota_fiscal_entradaJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('nfe_nota_fiscal_entrada','insert', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('nfe_nota_fiscal_entrada','clear', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('nfe_nota_fiscal_entrada','', '/easyEngenharia/easyconstru/nfe_nota_fiscal_entrada/nfe_nota_fiscal_entradaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
