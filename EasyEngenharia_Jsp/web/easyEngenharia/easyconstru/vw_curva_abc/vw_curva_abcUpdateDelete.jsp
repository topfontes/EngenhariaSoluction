<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_curva_abcJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abcUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abcJB.execute}                                         
                                                                                

<form name="vw_curva_abc" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_curva_abcJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abcT.obr_nr_id" value="${vw_curva_abcJB.vw_curva_abcT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abcT.obr_tx_nome" value="${vw_curva_abcJB.vw_curva_abcT.obr_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abcT.plco_nr_id" value="${vw_curva_abcJB.vw_curva_abcT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abcT.plco_tx_nome" value="${vw_curva_abcJB.vw_curva_abcT.plco_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>total:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abcT.total" value="${vw_curva_abcJB.vw_curva_abcT.total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_curva_abc', 'consult', '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_curva_abc', 'update' , '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_curva_abc', 'delete' , '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_curva_abc', 'consult' , '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
