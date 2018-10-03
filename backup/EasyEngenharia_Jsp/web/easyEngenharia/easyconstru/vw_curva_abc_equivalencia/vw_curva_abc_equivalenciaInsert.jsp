<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_curva_abc_equivalenciaJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abc_equivalenciaInsertJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abc_equivalenciaJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abc_equivalenciaJB.execute}                                         
                                                                               
	
<form name="vw_curva_abc_equivalencia" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaInsert.jsp"/>
    <center>     
     	<label class="msg">${vw_curva_abc_equivalenciaJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('vw_curva_abc_equivalencia','insert', '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('vw_curva_abc_equivalencia','clear', '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('vw_curva_abc_equivalencia','', '/easyEngenharia/easyconstru/vw_curva_abc_equivalencia/vw_curva_abc_equivalenciaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
