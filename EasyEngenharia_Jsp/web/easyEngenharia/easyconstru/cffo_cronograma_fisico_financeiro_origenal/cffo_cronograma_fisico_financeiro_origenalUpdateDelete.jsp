<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="cffo_cronograma_fisico_financeiro_origenalJB" class="br.com.easynet.gwt.easyportal.jb.Cffo_cronograma_fisico_financeiro_origenalUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="*"/>                                         
<jsp:setProperty name="cffo_cronograma_fisico_financeiro_origenalJB" property="page" value="${pageContext}"/>                                         
${cffo_cronograma_fisico_financeiro_origenalJB.execute}                                         
                                                                                

<form name="cffo_cronograma_fisico_financeiro_origenal" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${cffo_cronograma_fisico_financeiro_origenalJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>cffo_nr_id:</label>
	</td>
	<td>
		<input type="text" name="cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id" value="${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="cffo_cronograma_fisico_financeiro_origenalT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cffo_cronograma_fisico_financeiro_origenalJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="cffo_cronograma_fisico_financeiro_origenalT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${cffo_cronograma_fisico_financeiro_origenalJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>cffo_nr_peso:</label>
	</td>
	<td>
		<input type="text" name="cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso" value="${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_peso}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cffo_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes" value="${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cffo_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano" value="${cffo_cronograma_fisico_financeiro_origenalJB.cffo_cronograma_fisico_financeiro_origenalT.cffo_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal', 'consult', '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal', 'update' , '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal', 'delete' , '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('cffo_cronograma_fisico_financeiro_origenal', 'consult' , '/easyEngenharia/easyconstru/cffo_cronograma_fisico_financeiro_origenal/cffo_cronograma_fisico_financeiro_origenalConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
