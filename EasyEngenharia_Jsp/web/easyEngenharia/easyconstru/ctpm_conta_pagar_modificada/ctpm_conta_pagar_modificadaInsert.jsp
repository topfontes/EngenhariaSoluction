<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ctpm_conta_pagar_modificadaJB" class="br.com.easynet.gwt.easyportal.jb.Ctpm_conta_pagar_modificadaInsertJB" scope="request"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="*"/>                                         
<jsp:setProperty name="ctpm_conta_pagar_modificadaJB" property="page" value="${pageContext}"/>                                         
${ctpm_conta_pagar_modificadaJB.execute}                                         
                                                                               
	
<form name="ctpm_conta_pagar_modificada" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaInsert.jsp"/>
    <center>     
     	<label class="msg">${ctpm_conta_pagar_modificadaJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="ctpm_conta_pagar_modificadaT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctpm_conta_pagar_modificadaJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>ctp_nr_id:</label>
	</td>
	<td>
	    <select name="ctpm_conta_pagar_modificadaT.ctp_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ctpm_conta_pagar_modificadaJB.listctp_conta_pagar}" var="item">
            	  <option value="${item.ctp_nr_id}">${item.ctp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>ctpm_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="ctpm_conta_pagar_modificadaT.ctpm_nr_mes" value="${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctpm_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="ctpm_conta_pagar_modificadaT.ctpm_nr_ano" value="${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ctpm_tx_tipo:</label>
	</td>
	<td>
		<input type="text" name="ctpm_conta_pagar_modificadaT.ctpm_tx_tipo" value="${ctpm_conta_pagar_modificadaJB.ctpm_conta_pagar_modificadaT.ctpm_tx_tipo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('ctpm_conta_pagar_modificada','insert', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('ctpm_conta_pagar_modificada','clear', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('ctpm_conta_pagar_modificada','', '/easyEngenharia/easyconstru/ctpm_conta_pagar_modificada/ctpm_conta_pagar_modificadaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
