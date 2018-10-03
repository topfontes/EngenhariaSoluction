<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ctp_conta_pagarJB" class="br.com.easynet.gwt.easyportal.jb.Ctp_conta_pagarInsertJB" scope="request"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="*"/>                                         
<jsp:setProperty name="ctp_conta_pagarJB" property="page" value="${pageContext}"/>                                         
${ctp_conta_pagarJB.execute}                                         
                                                                               
	
<form name="ctp_conta_pagar" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarInsert.jsp"/>
    <center>     
     	<label class="msg">${ctp_conta_pagarJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>for_nr_id:</label>
	</td>
	<td>
	    <select name="ctp_conta_pagarT.for_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctp_conta_pagarJB.listfor_fornecedor}" var="item">
            	  <option value="${item.for_nr_id}">${item.for_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>ctp_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="ctp_conta_pagarT.ctp_nr_mes" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="ctp_conta_pagarT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctp_conta_pagarJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>ctp_nr_valor:</label>
	</td>
	<td>
		<input type="text" name="ctp_conta_pagarT.ctp_nr_valor" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_valor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_nr_documento:</label>
	</td>
	<td>
		<input type="text" name="ctp_conta_pagarT.ctp_nr_documento" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_nr_documento}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctp_tx_status:</label>
	</td>
	<td>
		<input type="text" name="ctp_conta_pagarT.ctp_tx_status" value="${ctp_conta_pagarJB.ctp_conta_pagarT.ctp_tx_status}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="ctp_conta_pagarT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctp_conta_pagarJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('ctp_conta_pagar','insert', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('ctp_conta_pagar','clear', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('ctp_conta_pagar','', '/easyEngenharia/easyconstru/ctp_conta_pagar/ctp_conta_pagarConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
