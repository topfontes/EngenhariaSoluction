<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="fat_fatorJB" class="br.com.easynet.gwt.easyportal.jb.Fat_fatorUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="fat_fatorJB" property="*"/>                                         
<jsp:setProperty name="fat_fatorJB" property="page" value="${pageContext}"/>                                         
${fat_fatorJB.execute}                                         
                                                                                

<form name="fat_fator" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${fat_fatorJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>fat_nr_id:</label>
	</td>
	<td>
		<input type="text" name="fat_fatorT.fat_nr_id" value="${fat_fatorJB.fat_fatorT.fat_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="fat_fatorT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${fat_fatorJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>fat_nr_fator_atual:</label>
	</td>
	<td>
		<input type="text" name="fat_fatorT.fat_nr_fator_atual" value="${fat_fatorJB.fat_fatorT.fat_nr_fator_atual}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fat_nr_fator_projetado:</label>
	</td>
	<td>
		<input type="text" name="fat_fatorT.fat_nr_fator_projetado" value="${fat_fatorJB.fat_fatorT.fat_nr_fator_projetado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fat_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="fat_fatorT.fat_nr_mes" value="${fat_fatorJB.fat_fatorT.fat_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>fat_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="fat_fatorT.fat_nr_ano" value="${fat_fatorJB.fat_fatorT.fat_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="fat_fatorT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${fat_fatorJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('fat_fator', 'consult', '/easyEngenharia/easyconstru/fat_fator/fat_fatorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('fat_fator', 'update' , '/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('fat_fator', 'delete' , '/easyEngenharia/easyconstru/fat_fator/fat_fatorUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('fat_fator', 'consult' , '/easyEngenharia/easyconstru/fat_fator/fat_fatorConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
