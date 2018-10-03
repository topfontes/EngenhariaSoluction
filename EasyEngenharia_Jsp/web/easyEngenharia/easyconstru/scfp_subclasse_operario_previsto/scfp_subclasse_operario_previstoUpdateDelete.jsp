<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="scfp_subclasse_operario_previstoJB" class="br.com.easynet.gwt.easyportal.jb.Scfp_subclasse_operario_previstoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="*"/>                                         
<jsp:setProperty name="scfp_subclasse_operario_previstoJB" property="page" value="${pageContext}"/>                                         
${scfp_subclasse_operario_previstoJB.execute}                                         
                                                                                

<form name="scfp_subclasse_operario_previsto" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${scfp_subclasse_operario_previstoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>scfp_nr_id:</label>
	</td>
	<td>
		<input type="text" name="scfp_subclasse_operario_previstoT.scfp_nr_id" value="${scfp_subclasse_operario_previstoJB.scfp_subclasse_operario_previstoT.scfp_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plc_nr_id:</label>
	</td>
	<td>
	    <select name="scfp_subclasse_operario_previstoT.plc_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${scfp_subclasse_operario_previstoJB.listplc_plano_contas}" var="item">
            	  <option value="${item.plc_nr_id}">${item.plc_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	


	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('scfp_subclasse_operario_previsto', 'consult', '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('scfp_subclasse_operario_previsto', 'update' , '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('scfp_subclasse_operario_previsto', 'delete' , '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('scfp_subclasse_operario_previsto', 'consult' , '/easyEngenharia/easyconstru/scfp_subclasse_operario_previsto/scfp_subclasse_operario_previstoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
