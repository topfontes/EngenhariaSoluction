<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetInsertJB" scope="request"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>                                         
${tet_tmp_equivalencia_treetJB.execute}                                         
                                                                               
	
<form name="tet_tmp_equivalencia_treet" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetInsert.jsp"/>
    <center>     
     	<label class="msg">${tet_tmp_equivalencia_treetJB.msg}</label><br/>
	<table width="50%" border="0">
	         <tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
		<input type="text" name="tet_tmp_equivalencia_treetT.plco_nr_id" value="${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plco_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="tet_tmp_equivalencia_treetT.plc_nr_id" value="${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plco_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="tet_tmp_equivalencia_treetT.plco_tx_nome" value="${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plco_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plc_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="tet_tmp_equivalencia_treetT.plc_tx_nome" value="${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.plc_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('tet_tmp_equivalencia_treet','insert', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('tet_tmp_equivalencia_treet','clear', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('tet_tmp_equivalencia_treet','', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
