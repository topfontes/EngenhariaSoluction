<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_curva_abc_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abc_equivalenciaUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abc_equivalenciaJB.execute}                                         
                                                                                

<form name="vw_curva_abc_equivalencia" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_curva_abc_equivalenciaJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abc_equivalenciaT.obr_nr_id" value="${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abc_equivalenciaT.plc_nr_id" value="${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abc_equivalenciaT.plc_tx_nome" value="${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>total:</label>
	</td>
	<td>
		<input type="text" name="vw_curva_abc_equivalenciaT.total" value="${vw_curva_abc_equivalenciaJB.vw_curva_abc_equivalenciaT.total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_curva_abc_equivalencia', 'consult', '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_curva_abc_equivalencia', 'update' , '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_curva_abc_equivalencia', 'delete' , '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_curva_abc_equivalencia', 'consult' , '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
