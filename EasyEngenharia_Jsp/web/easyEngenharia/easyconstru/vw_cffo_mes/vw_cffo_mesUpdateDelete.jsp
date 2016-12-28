<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_cffo_mesJB" class="br.com.easynet.gwt.easyportal.client.jb.Vw_cffo_mesUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="*"/>                                         
<jsp:setProperty name="vw_cffo_mesJB" property="page" value="${pageContext}"/>                                         
${vw_cffo_mesJB.execute}                                         
                                                                                

<form name="vw_cffo_mes" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_cffo_mesJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_cffo_mesT.obr_nr_id" value="${vw_cffo_mesJB.vw_cffo_mesT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cffo_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="vw_cffo_mesT.cffo_nr_mes" value="${vw_cffo_mesJB.vw_cffo_mesT.cffo_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>cffo_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="vw_cffo_mesT.cffo_nr_ano" value="${vw_cffo_mesJB.vw_cffo_mesT.cffo_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>total:</label>
	</td>
	<td>
		<input type="text" name="vw_cffo_mesT.total" value="${vw_cffo_mesJB.vw_cffo_mesT.total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_cffo_mes', 'consult', '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_cffo_mes', 'update' , '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_cffo_mes', 'delete' , '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_cffo_mes', 'consult' , '/EasyEngenharia/easyconstru/vw_cffo_mes/vw_cffo_mesConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
