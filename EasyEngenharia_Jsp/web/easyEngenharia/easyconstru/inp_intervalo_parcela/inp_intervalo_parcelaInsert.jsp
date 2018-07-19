<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="inp_intervalo_parcelaJB" class="br.com.easynet.gwt.easyportal.jb.Inp_intervalo_parcelaInsertJB" scope="request"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="*"/>                                         
<jsp:setProperty name="inp_intervalo_parcelaJB" property="page" value="${pageContext}"/>                                         
${inp_intervalo_parcelaJB.execute}                                         
                                                                               
	
<form name="inp_intervalo_parcela" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaInsert.jsp"/>
    <center>     
     	<label class="msg">${inp_intervalo_parcelaJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>par_nr_id:</label>
	</td>
	<td>
	    <select name="inp_intervalo_parcelaT.par_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${inp_intervalo_parcelaJB.listpar_parcelamento}" var="item">
            	  <option value="${item.par_nr_id}">${item.par_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>inp_nr_dias:</label>
	</td>
	<td>
		<input type="text" name="inp_intervalo_parcelaT.inp_nr_dias" value="${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_dias}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>inp_nr_per:</label>
	</td>
	<td>
		<input type="text" name="inp_intervalo_parcelaT.inp_nr_per" value="${inp_intervalo_parcelaJB.inp_intervalo_parcelaT.inp_nr_per}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('inp_intervalo_parcela','insert', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('inp_intervalo_parcela','clear', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('inp_intervalo_parcela','', '/easyEngenharia/easyconstru/inp_intervalo_parcela/inp_intervalo_parcelaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
