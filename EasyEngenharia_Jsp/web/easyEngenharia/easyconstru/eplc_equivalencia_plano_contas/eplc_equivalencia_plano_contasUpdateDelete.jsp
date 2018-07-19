<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="eplc_equivalencia_plano_contasJB" class="br.com.easynet.gwt.easyportal.jb.Eplc_equivalencia_plano_contasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="*"/>                                         
<jsp:setProperty name="eplc_equivalencia_plano_contasJB" property="page" value="${pageContext}"/>                                         
${eplc_equivalencia_plano_contasJB.execute}                                         
                                                                                

<form name="eplc_equivalencia_plano_contas" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${eplc_equivalencia_plano_contasJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>eplc_nr_id:</label>
	</td>
	<td>
		<input type="text" name="eplc_equivalencia_plano_contasT.eplc_nr_id" value="${eplc_equivalencia_plano_contasJB.eplc_equivalencia_plano_contasT.eplc_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="eplc_equivalencia_plano_contasT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${eplc_equivalencia_plano_contasJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="eplc_equivalencia_plano_contasT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${eplc_equivalencia_plano_contasJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('eplc_equivalencia_plano_contas', 'consult', '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('eplc_equivalencia_plano_contas', 'update' , '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('eplc_equivalencia_plano_contas', 'delete' , '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('eplc_equivalencia_plano_contas', 'consult' , '/easyengenharia/easyconstru/eplc_equivalencia_plano_contas/eplc_equivalencia_plano_contasConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
