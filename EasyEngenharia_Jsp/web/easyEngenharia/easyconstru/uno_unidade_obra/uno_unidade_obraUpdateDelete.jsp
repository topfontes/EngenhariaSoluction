<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="uno_unidade_obraJB" class="br.com.easynet.gwt.easyportal.jb.Uno_unidade_obraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="*"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="page" value="${pageContext}"/>                                         
${uno_unidade_obraJB.execute}                                         
                                                                                

<form name="uno_unidade_obra" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${uno_unidade_obraJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>uno_nr_id:</label>
	</td>
	<td>
		<input type="text" name="uno_unidade_obraT.uno_nr_id" value="${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="uno_unidade_obraT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${uno_unidade_obraJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>uno_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="uno_unidade_obraT.uno_tx_nome" value="${uno_unidade_obraJB.uno_unidade_obraT.uno_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>uno_nr_quantidade:</label>
	</td>
	<td>
		<input type="text" name="uno_unidade_obraT.uno_nr_quantidade" value="${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_quantidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>uno_nr_area_construida:</label>
	</td>
	<td>
		<input type="text" name="uno_unidade_obraT.uno_nr_area_construida" value="${uno_unidade_obraJB.uno_unidade_obraT.uno_nr_area_construida}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('uno_unidade_obra', 'consult', '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('uno_unidade_obra', 'update' , '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('uno_unidade_obra', 'delete' , '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('uno_unidade_obra', 'consult' , '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
