<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="vw_curva_abcJB" class="br.com.easynet.gwt.easyportal.jb.Vw_curva_abcInsertJB" scope="request"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="*"/>                                         
<jsp:setProperty name="vw_curva_abcJB" property="page" value="${pageContext}"/>                                         
${vw_curva_abcJB.execute}                                         
                                                                               
	
<form name="vw_curva_abc" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcInsert.jsp"/>
    <center>     
     	<label class="msg">${vw_curva_abcJB.msg}</label><br/>
	<table width="50%" border="0">
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
    			    <input type="button" value="Insert"  onClick="setOpPortal('vw_curva_abc','insert', '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('vw_curva_abc','clear', '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('vw_curva_abc','', '/easyEngenharia/easyconstru/vw_curva_abc/vw_curva_abcConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
