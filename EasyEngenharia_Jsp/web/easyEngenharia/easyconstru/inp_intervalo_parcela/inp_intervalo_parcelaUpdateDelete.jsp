<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>                                         
${inp_intervalo_parcelaJB.execute}                                         
                                                                                

<form name="inp_intervalo_parcela" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${inp_intervalo_parcelaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>inp_nr_id:</label>
	</td>
	<td>
		<input type="text" name="inp_intervalo_parcelaT.inp_nr_id" value="${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>par_nr_id:</label>
	</td>
	<td>
	    <select name="inp_intervalo_parcelaT.par_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${inp_intervalo_parcelaJB.listpar_parcelamento}" var="item">
            	  <option value="${item.par_nr_id}">${item.par_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>inp_nr_dias:</label>
	</td>
	<td>
		<input type="text" name="inp_intervalo_parcelaT.inp_nr_dias" value="${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_dias}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inp_nr_per:</label>
	</td>
	<td>
		<input type="text" name="inp_intervalo_parcelaT.inp_nr_per" value="${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_per}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('inp_intervalo_parcela', 'consult', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('inp_intervalo_parcela', 'update' , '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('inp_intervalo_parcela', 'delete' , '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('inp_intervalo_parcela', 'consult' , '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
