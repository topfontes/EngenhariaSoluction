<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>                                         
${tet_tmp_equivalencia_treetJB.execute}                                         
                                                                                

<form name="tet_tmp_equivalencia_treet" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${tet_tmp_equivalencia_treetJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>tet_nr_id:</label>
	</td>
	<td>
		<input type="text" name="tet_tmp_equivalencia_treetT.tet_nr_id" value="${tet_tmp_equivalencia_treetJB.tet_tmp_equivalencia_treetT.tet_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
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
		<input type="button" value="Consult" onClick="setOpPortal('tet_tmp_equivalencia_treet', 'consult', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('tet_tmp_equivalencia_treet', 'update' , '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('tet_tmp_equivalencia_treet', 'delete' , '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('tet_tmp_equivalencia_treet', 'consult' , '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
