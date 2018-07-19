<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plc_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Plc_plano_contasInsertJB" scope="request"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="plc_plano_contasJB" property="page" value="${pageContext}"/>                                         
${plc_plano_contasJB.execute}                                         
                                                                               
	
<form name="plc_plano_contas" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasInsert.jsp"/>
    <center>     
     	<label class="msg">${plc_plano_contasJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="plc_plano_contasT.plc_tx_nome" value="${plc_plano_contasJB.plc_plano_contasT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id_super:</label>
	</td>
	<td>
		<input type="text" name="plc_plano_contasT.plc_nr_id_super" value="${plc_plano_contasJB.plc_plano_contasT.plc_nr_id_super}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_caixa_banco:</label>
	</td>
	<td>
		<input type="text" name="plc_plano_contasT.plc_tx_caixa_banco" value="${plc_plano_contasJB.plc_plano_contasT.plc_tx_caixa_banco}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('plc_plano_contas','insert', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('plc_plano_contas','clear', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('plc_plano_contas','', '/easyEngenharia/easyconstru/plc_plano_contas/plc_plano_contasConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
