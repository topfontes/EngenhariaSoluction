<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ume_unidade_medidaJB" class="br.com.easynet.gwt.easyportal.jb.Ume_unidade_medidaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="*"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="page" value="${pageContext}"/>                                         
${ume_unidade_medidaJB.execute}                                         
                                                                                

<form name="ume_unidade_medida" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${ume_unidade_medidaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>ume_nr_id:</label>
	</td>
	<td>
		<input type="text" name="ume_unidade_medidaT.ume_nr_id" value="${ume_unidade_medidaJB.ume_unidade_medidaT.ume_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ume_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="ume_unidade_medidaT.ume_tx_nome" value="${ume_unidade_medidaJB.ume_unidade_medidaT.ume_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('ume_unidade_medida', 'consult', '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('ume_unidade_medida', 'update' , '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('ume_unidade_medida', 'delete' , '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('ume_unidade_medida', 'consult' , '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
