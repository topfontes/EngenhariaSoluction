<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_comprometimentoJB" class="br.com.easynet.gwt.easyportal.jb.Vw_comprometimentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="*"/>                                         
<jsp:setProperty name="vw_comprometimentoJB" property="page" value="${pageContext}"/>                                         
${vw_comprometimentoJB.execute}                                         
                                                                                

<form name="vw_comprometimento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_comprometimentoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.obr_nr_id" value="${vw_comprometimentoJB.vw_comprometimentoT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>com_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.com_nr_mes" value="${vw_comprometimentoJB.vw_comprometimentoT.com_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>com_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.com_nr_ano" value="${vw_comprometimentoJB.vw_comprometimentoT.com_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.plc_nr_id" value="${vw_comprometimentoJB.vw_comprometimentoT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.plc_tx_nome" value="${vw_comprometimentoJB.vw_comprometimentoT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>com_nr_valor:</label>
	</td>
	<td>
		<input type="text" name="vw_comprometimentoT.com_nr_valor" value="${vw_comprometimentoJB.vw_comprometimentoT.com_nr_valor}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_comprometimento', 'consult', '/easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_comprometimento', 'update' , '/easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_comprometimento', 'delete' , '/easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_comprometimento', 'consult' , '/easyEngenharia/easyconstru/vw_comprometimento/vw_comprometimentoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
