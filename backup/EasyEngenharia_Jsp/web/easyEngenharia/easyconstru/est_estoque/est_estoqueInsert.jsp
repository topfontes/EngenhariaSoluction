<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="est_estoqueJB" class="br.com.easynet.gwt.easyportal.jb.Est_estoqueInsertJB" scope="request"/>                                         
<jsp:setProperty name="est_estoqueJB" property="*"/>                                         
<jsp:setProperty name="est_estoqueJB" property="page" value="${pageContext}"/>                                         
${est_estoqueJB.execute}                                         
                                                                               
	
<form name="est_estoque" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/est_estoque/est_estoqueInsert.jsp"/>
    <center>     
     	<label class="msg">${est_estoqueJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>est_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="est_estoqueT.est_nr_mes" value="${est_estoqueJB.est_estoqueT.est_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="est_estoqueT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${est_estoqueJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>est_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="est_estoqueT.est_nr_quantidade" value="${est_estoqueJB.est_estoqueT.est_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>est_nr_vl_unitario:</label>
	</td>
	<td>
		<input type="text" name="est_estoqueT.est_nr_vl_unitario" value="${est_estoqueJB.est_estoqueT.est_nr_vl_unitario}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>est_nr_vl_total:</label>
	</td>
	<td>
		<input type="text" name="est_estoqueT.est_nr_vl_total" value="${est_estoqueJB.est_estoqueT.est_nr_vl_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>est_tx_unidade:</label>
	</td>
	<td>
		<input type="text" name="est_estoqueT.est_tx_unidade" value="${est_estoqueJB.est_estoqueT.est_tx_unidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="est_estoqueT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${est_estoqueJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('est_estoque','insert', '/easyEngenharia/easyconstru/est_estoque/est_estoqueInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('est_estoque','clear', '/easyEngenharia/easyconstru/est_estoque/est_estoqueInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('est_estoque','', '/easyEngenharia/easyconstru/est_estoque/est_estoqueConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
