<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_equivalenciaInsertJB" scope="request"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_equivalenciaJB.execute}                                         
                                                                               
	
<form name="vw_equivalencia" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaInsert.jsp"/>
    <center>     
     	<label class="msg">${vw_equivalenciaJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>eplc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.eplc_nr_id" value="${vw_equivalenciaJB.vw_equivalenciaT.eplc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plc_nr_id" value="${vw_equivalenciaJB.vw_equivalenciaT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plco_nr_id" value="${vw_equivalenciaJB.vw_equivalenciaT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plco_tx_nome" value="${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plc_tx_nome" value="${vw_equivalenciaJB.vw_equivalenciaT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_tipo:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plco_tx_tipo" value="${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_tipo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_cod_externo:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plco_tx_cod_externo" value="${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_cod_externo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_unidade:</label>
	</td>
	<td>
		<input type="text" name="vw_equivalenciaT.plco_tx_unidade" value="${vw_equivalenciaJB.vw_equivalenciaT.plco_tx_unidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('vw_equivalencia','insert', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('vw_equivalencia','clear', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('vw_equivalencia','', '/easyEngenharia/easyconstru/vw_equivalencia/vw_equivalenciaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
