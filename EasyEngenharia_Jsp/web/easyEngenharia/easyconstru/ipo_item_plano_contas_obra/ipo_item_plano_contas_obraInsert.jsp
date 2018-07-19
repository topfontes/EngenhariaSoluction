<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ipo_item_plano_contas_obraJB" class="br.com.easynet.gwt.easyportal.jb.Ipo_item_plano_contas_obraInsertJB" scope="request"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="*"/>                                         
<jsp:setProperty name="ipo_item_plano_contas_obraJB" property="page" value="${pageContext}"/>                                         
${ipo_item_plano_contas_obraJB.execute}                                         
                                                                               
	
<form name="ipo_item_plano_contas_obra" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraInsert.jsp"/>
    <center>     
     	<label class="msg">${ipo_item_plano_contas_obraJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>ipo_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="ipo_item_plano_contas_obraT.ipo_nr_quantidade" value="${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_vl_unitario:</label>
	</td>
	<td>
		<input type="text" name="ipo_item_plano_contas_obraT.ipo_nr_vl_unitario" value="${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_vl_unitario}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_vl_total:</label>
	</td>
	<td>
		<input type="text" name="ipo_item_plano_contas_obraT.ipo_nr_vl_total" value="${ipo_item_plano_contas_obraJB.ipo_item_plano_contas_obraT.ipo_nr_vl_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="ipo_item_plano_contas_obraT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ipo_item_plano_contas_obraJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="ipo_item_plano_contas_obraT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${ipo_item_plano_contas_obraJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('ipo_item_plano_contas_obra','insert', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('ipo_item_plano_contas_obra','clear', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('ipo_item_plano_contas_obra','', '/easyengenharia/easyconstru/ipo_item_plano_contas_obra/ipo_item_plano_contas_obraConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
