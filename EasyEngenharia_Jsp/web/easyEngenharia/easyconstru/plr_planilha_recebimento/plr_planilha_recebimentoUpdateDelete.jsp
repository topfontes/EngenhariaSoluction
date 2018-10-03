<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plr_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plr_planilha_recebimentoUpdateDeleteJB" scope="request"/>
<jsp:setProperty name="plr_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plr_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plr_planilha_permutaJB.execute}                                         
                                                                                

<form name="plr_planilha_permuta" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/plr_planilha_recebimento/plr_planilha_recebimentopdateDelete.jsp"/>
    <center>     
     	<label class="msg">${plr_planilha_permutaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>plr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_id" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="plr_planilha_permutaT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${plr_planilha_permutaJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>plr_nr_mes_ref:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_mes_ref" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_mes_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_ano_ref:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_ano_ref" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_ano_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_mes" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_ano" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_efetuado_pj:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_efetuado_pj" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_efetuado_pj}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_realizado_pf:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_realizado_pf" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_realizado_pf}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plr_nr_realizado_pou:</label>
	</td>
	<td>
		<input type="text" name="plr_planilha_permutaT.plr_nr_realizado_pou" value="${plr_planilha_permutaJB.plr_planilha_permutaT.plr_nr_realizado_pou}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('plr_planilha_permuta', 'consult', '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('plr_planilha_permuta', 'update' , '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('plr_planilha_permuta', 'delete' , '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('plr_planilha_permuta', 'consult' , '/EasyEngenharia/easyconstru/plr_planilha_permuta/plr_planilha_permutaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
