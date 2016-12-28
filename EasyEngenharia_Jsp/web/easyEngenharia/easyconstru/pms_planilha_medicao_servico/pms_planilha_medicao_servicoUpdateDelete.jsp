<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="pms_planilha_medicao_servicoJB" class="br.com.easynet.gwt.easyportal.jb.Pms_planilha_medicao_servicoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="*"/>                                         
<jsp:setProperty name="pms_planilha_medicao_servicoJB" property="page" value="${pageContext}"/>                                         
${pms_planilha_medicao_servicoJB.execute}                                         
                                                                                

<form name="pms_planilha_medicao_servico" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${pms_planilha_medicao_servicoJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>pms_nr_id:</label>
	</td>
	<td>
		<input type="text" name="pms_planilha_medicao_servicoT.pms_nr_id" value="${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="pms_planilha_medicao_servicoT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pms_planilha_medicao_servicoJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>pms_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="pms_planilha_medicao_servicoT.pms_nr_mes" value="${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>plco_nr_id:</label>
	</td>
	<td>
	    <select name="pms_planilha_medicao_servicoT.plco_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${pms_planilha_medicao_servicoJB.listplco_plano_contas_orcamento}" var="item">
            	  <option value="${item.plco_nr_id}">${item.plco_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>pms_nr_quantidade_servico:</label>
	</td>
	<td>
		<input type="text" name="pms_planilha_medicao_servicoT.pms_nr_quantidade_servico" value="${pms_planilha_medicao_servicoJB.pms_planilha_medicao_servicoT.pms_nr_quantidade_servico}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('pms_planilha_medicao_servico', 'consult', '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('pms_planilha_medicao_servico', 'update' , '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('pms_planilha_medicao_servico', 'delete' , '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('pms_planilha_medicao_servico', 'consult' , '/easyEngenharia/easyconstru/pms_planilha_medicao_servico/pms_planilha_medicao_servicoConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
