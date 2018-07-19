<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="infe_item_nota_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Infe_item_nota_entradaInsertJB" scope="request"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="*"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="page" value="${pageContext}"/>                                         
${infe_item_nota_entradaJB.execute}                                         
                                                                               
	
<form name="infe_item_nota_entrada" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaInsert.jsp"/>
    <center>     
     	<label class="msg">${infe_item_nota_entradaJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>infe_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="infe_item_nota_entradaT.infe_nr_quantidade" value="${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>infe_nr_valor_unit:</label>
	</td>
	<td>
		<input type="text" name="infe_item_nota_entradaT.infe_nr_valor_unit" value="${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_valor_unit}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>infe_nr_valor_total:</label>
	</td>
	<td>
		<input type="text" name="infe_item_nota_entradaT.infe_nr_valor_total" value="${infe_item_nota_entradaJB.infe_item_nota_entradaT.infe_nr_valor_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>nfe_nr_id:</label>
	</td>
	<td>
	    <select name="infe_item_nota_entradaT.nfe_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${infe_item_nota_entradaJB.listnfe_nota_fiscal_entrada}" var="item">
            	  <option value="${item.nfe_nr_id}">${item.nfe_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>pro_nr_id:</label>
	</td>
	<td>
	    <select name="infe_item_nota_entradaT.pro_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${infe_item_nota_entradaJB.listpro_produto}" var="item">
            	  <option value="${item.pro_nr_id}">${item.pro_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('infe_item_nota_entrada','insert', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('infe_item_nota_entrada','clear', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('infe_item_nota_entrada','', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
