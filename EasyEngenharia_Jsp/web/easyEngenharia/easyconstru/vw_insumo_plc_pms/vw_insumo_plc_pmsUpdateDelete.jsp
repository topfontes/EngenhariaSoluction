<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_insumo_plc_pmsJB" class="br.com.easynet.gwt.easyportal.jb.Vw_insumo_plc_pmsUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="*"/>                                         
<jsp:setProperty name="vw_insumo_plc_pmsJB" property="page" value="${pageContext}"/>                                         
${vw_insumo_plc_pmsJB.execute}                                         
                                                                                

<form name="vw_insumo_plc_pms" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${vw_insumo_plc_pmsJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.obr_nr_id" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id_super:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.plc_nr_id_super" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_nr_id_super}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome_super:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.plc_tx_nome_super" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_tx_nome_super}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.plc_nr_id" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.plc_tx_nome" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>ipo_nr_vl_unitario:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.ipo_nr_vl_unitario" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.ipo_nr_vl_unitario}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pms_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.pms_nr_mes" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.pms_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>pms_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.pms_nr_ano" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.pms_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.plco_nr_id" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>perc:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.perc" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.perc}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>vl_total:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.vl_total" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.vl_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>vl_executado:</label>
	</td>
	<td>
		<input type="text" name="vw_insumo_plc_pmsT.vl_executado" value="${vw_insumo_plc_pmsJB.vw_insumo_plc_pmsT.vl_executado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('vw_insumo_plc_pms', 'consult', '/easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('vw_insumo_plc_pms', 'update' , '/easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('vw_insumo_plc_pms', 'delete' , '/easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('vw_insumo_plc_pms', 'consult' , '/easyEngenharia/easyconstru/vw_insumo_plc_pms/vw_insumo_plc_pmsConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
