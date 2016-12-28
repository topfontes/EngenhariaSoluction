<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="obr_obrasJB" class="br.com.easynet.gwt.easyportal.jb.Obr_obrasUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="obr_obrasJB" property="*"/>                                         
<jsp:setProperty name="obr_obrasJB" property="page" value="${pageContext}"/>                                         
${obr_obrasJB.execute}                                         
                                                                                

<form name="obr_obras" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp"/>
    <center>     
     	<label class="msg">${obr_obrasJB.msg}</label><br/>

    <table align="center" border="0" width="50%">
    		     <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_nr_id" value="${obr_obrasJB.obr_obrasT.obr_nr_id}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_nome:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_tx_nome" value="${obr_obrasJB.obr_obrasT.obr_tx_nome}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_endereco:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_tx_endereco" value="${obr_obrasJB.obr_obrasT.obr_tx_endereco}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_bairro:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_tx_bairro" value="${obr_obrasJB.obr_obrasT.obr_tx_bairro}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_cidade:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_tx_cidade" value="${obr_obrasJB.obr_obrasT.obr_tx_cidade}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_tx_uf:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_tx_uf" value="${obr_obrasJB.obr_obrasT.obr_tx_uf}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
<tr>
	<td>
		<label>emp_nr_id:</label>
	</td>
	<td>
	    <select name="obr_obrasT.emp_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${obr_obrasJB.listemp_empreendimento}" var="item">
            	  <option value="${item.emp_nr_id}">${item.emp_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>obr_nr_area_construida_total:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_nr_area_construida_total" value="${obr_obrasJB.obr_obrasT.obr_nr_area_construida_total}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_dt_inicio:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_dt_inicio" value="<fmt:formatDate value="${obr_obrasJB.obr_obrasT.obr_dt_inicio}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_dt_fim:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_dt_fim" value="<fmt:formatDate value="${obr_obrasJB.obr_obrasT.obr_dt_fim}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_dt_inicio_controle:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_dt_inicio_controle" value="<fmt:formatDate value="${obr_obrasJB.obr_obrasT.obr_dt_inicio_controle}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>obr_dt_termino_controle:</label>
	</td>
	<td>
		<input type="text" name="obr_obrasT.obr_dt_termino_controle" value="<fmt:formatDate value="${obr_obrasJB.obr_obrasT.obr_dt_termino_controle}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

	  <tr>
     	    <td colspan="2" align="center">
		<input type="button" value="Consult" onClick="setOpPortal('obr_obras', 'consult', '/easyEngenharia/easyconstru/obr_obras/obr_obrasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Update"  onClick="setOpPortal('obr_obras', 'update' , '/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Delete"  onClick="setOpPortal('obr_obras', 'delete' , '/easyEngenharia/easyconstru/obr_obras/obr_obrasUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Cancel"  onClick="setOpPortal('obr_obras', 'consult' , '/easyEngenharia/easyconstru/obr_obras/obr_obrasConsult.jsp')" />
    	    </td>
	  </tr>
	</table>
    
	<br/>
    
    </center>     
	
</form>
