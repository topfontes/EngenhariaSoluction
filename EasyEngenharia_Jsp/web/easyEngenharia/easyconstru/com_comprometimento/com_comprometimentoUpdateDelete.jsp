<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="com_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Com_comprometimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="com_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${com_comprometimentoJB.execute}                                         
                                                                                

<form name="com_comprometimento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${com_comprometimentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>com_nr_id:</label>
	</td>
	<td>
		<input type="text" name="com_comprometimentoT.com_nr_id" value="${com_comprometimentoJB.com_comprometimentoT.com_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="com_comprometimentoT.plc_nr_id" value="${com_comprometimentoJB.com_comprometimentoT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>com_nr_valor:</label>
	</td>
	<td>
		<input type="text" name="com_comprometimentoT.com_nr_valor" value="${com_comprometimentoJB.com_comprometimentoT.com_nr_valor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="com_comprometimentoT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${com_comprometimentoJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>com_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="com_comprometimentoT.com_nr_mes" value="${com_comprometimentoJB.com_comprometimentoT.com_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>com_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="com_comprometimentoT.com_nr_ano" value="${com_comprometimentoJB.com_comprometimentoT.com_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('com_comprometimento', 'consult', '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('com_comprometimento', 'update' , '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('com_comprometimento', 'delete' , '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('com_comprometimento', 'consult' , '/easyEngenharia/easyconstru/com_comprometimento/com_comprometimentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
