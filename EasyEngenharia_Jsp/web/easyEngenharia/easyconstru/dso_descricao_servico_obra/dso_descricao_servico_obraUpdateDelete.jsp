<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="dso_descricao_servico_obraJB" class="br.com.easynet.gwt.easyportal.jb.Dso_descricao_servico_obraUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="*"/>                                         
<jsp:setProperty name="dso_descricao_servico_obraJB" property="page" value="${pageContext}"/>                                         
${dso_descricao_servico_obraJB.execute}                                         
                                                                                

<form name="dso_descricao_servico_obra" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${dso_descricao_servico_obraJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="dso_descricao_servico_obraT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${dso_descricao_servico_obraJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>dso_tx_codigo_externo:</label>
	</td>
	<td>
		<input type="text" name="dso_descricao_servico_obraT.dso_tx_codigo_externo" value="${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_tx_codigo_externo}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>dso_tx_descriaco:</label>
	</td>
	<td>
		<input type="text" name="dso_descricao_servico_obraT.dso_tx_descriaco" value="${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_tx_descriaco}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>dso_nr_id:</label>
	</td>
	<td>
		<input type="text" name="dso_descricao_servico_obraT.dso_nr_id" value="${dso_descricao_servico_obraJB.dso_descricao_servico_obraT.dso_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('dso_descricao_servico_obra', 'consult', '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('dso_descricao_servico_obra', 'update' , '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('dso_descricao_servico_obra', 'delete' , '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('dso_descricao_servico_obra', 'consult' , '/easyEngenharia/easyconstru/dso_descricao_servico_obra/dso_descricao_servico_obraConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
