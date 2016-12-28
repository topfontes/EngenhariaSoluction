<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="inc_informacoes_custoJB" class="br.com.easynet.gwt.easyportal.jb.Inc_informacoes_custoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="*"/>                                         
<jsp:setProperty name="inc_informacoes_custoJB" property="page" value="${pageContext}"/>                                         
${inc_informacoes_custoJB.execute}                                         
                                                                                

<form name="inc_informacoes_custo" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${inc_informacoes_custoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>inc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_nr_id" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="inc_informacoes_custoT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${inc_informacoes_custoJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>inc_nes_nr_id:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_nes_nr_id" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nes_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_nr_ano" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="inc_informacoes_custoT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${inc_informacoes_custoJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>inc_tx_custo_acumulado:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_tx_custo_acumulado" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_custo_acumulado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_nr_custo_periodo:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_nr_custo_periodo" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_nr_custo_periodo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_tx_calsas:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_tx_calsas" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_calsas}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_tx_problemas:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_tx_problemas" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_problemas}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_tx_acoes:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_tx_acoes" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_acoes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_tx_responsavel:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_tx_responsavel" value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_tx_responsavel}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inc_dt_prazo:</label>
	</td>
	<td>
		<input type="text" name="inc_informacoes_custoT.inc_dt_prazo" value="<fmt:formatDate value="${inc_informacoes_custoJB.inc_informacoes_custoT.inc_dt_prazo}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('inc_informacoes_custo', 'consult', '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('inc_informacoes_custo', 'update' , '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('inc_informacoes_custo', 'delete' , '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('inc_informacoes_custo', 'consult' , '/easyEngenharia/easyconstru/inc_informacoes_custo/inc_informacoes_custoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
