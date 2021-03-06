<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plv_planilha_vendasJB" class="br.com.easynet.gwt.easyportal.jb.Plv_planilha_vendasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="*"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="page" value="${pageContext}"/>                                         
${plv_planilha_vendasJB.execute}                                         
                                                                                

<form name="plv_planilha_vendas" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${plv_planilha_vendasJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>plv_nr_id:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_id" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="plv_planilha_vendasT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${plv_planilha_vendasJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>plv_nr_mes_ref:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_mes_ref" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_mes_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plv_nr_ano_ref:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_ano_ref" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_ano_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plv_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_mes" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plv_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_ano" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plv_nr_previsto:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_previsto" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_previsto}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plv_nr_realizado:</label>
	</td>
	<td>
		<input type="text" name="plv_planilha_vendasT.plv_nr_realizado" value="${plv_planilha_vendasJB.plv_planilha_vendasT.plv_nr_realizado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('plv_planilha_vendas', 'consult', '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('plv_planilha_vendas', 'update' , '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('plv_planilha_vendas', 'delete' , '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('plv_planilha_vendas', 'consult' , '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
