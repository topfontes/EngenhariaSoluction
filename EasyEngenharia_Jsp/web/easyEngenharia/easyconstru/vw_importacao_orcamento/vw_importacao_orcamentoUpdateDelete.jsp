<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_importacao_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_importacao_orcamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="vw_importacao_orcamentoJB" property="page" value="${pageContext}"/>                                         
${vw_importacao_orcamentoJB.execute}                                         
                                                                                

<form name="vw_importacao_orcamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_importacao_orcamentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>plco_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_tx_nome" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_tipo:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_tx_tipo" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_tipo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_unidade:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_tx_unidade" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_unidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.ipo_nr_quantidade" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_vl_unitario:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.ipo_nr_vl_unitario" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_vl_unitario}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_vl_total:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.ipo_nr_vl_total" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_nr_vl_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_nr_id" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_plc_nr_id_servico:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.ipo_plc_nr_id_servico" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.ipo_plc_nr_id_servico}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_cod_externo:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_tx_cod_externo" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_tx_cod_externo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.obr_nr_id" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_nivel:</label>
	</td>
	<td>
		<input type="text" name="vw_importacao_orcamentoT.plco_nr_nivel" value="${vw_importacao_orcamentoJB.vw_importacao_orcamentoT.plco_nr_nivel}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_importacao_orcamento', 'consult', '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_importacao_orcamento', 'update' , '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_importacao_orcamento', 'delete' , '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_importacao_orcamento', 'consult' , '/easyEngenharia/easyconstru/vw_importacao_orcamento/vw_importacao_orcamentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
