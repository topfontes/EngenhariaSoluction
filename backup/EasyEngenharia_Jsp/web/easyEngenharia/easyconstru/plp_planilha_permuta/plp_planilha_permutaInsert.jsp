<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="plp_planilha_permutaJB" class="br.com.easynet.gwt.easyportal.jb.Plp_planilha_permutaInsertJB" scope="request"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="*"/>                                         
<jsp:setProperty name="plp_planilha_permutaJB" property="page" value="${pageContext}"/>                                         
${plp_planilha_permutaJB.execute}                                         
                                                                               
	
<form name="plp_planilha_permuta" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaInsert.jsp"/>
    <center>     
     	<label class="msg">${plp_planilha_permutaJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="plp_planilha_permutaT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${plp_planilha_permutaJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>plp_nr_mes_ref:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_mes_ref" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_mes_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plp_nr_ano_ref:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_ano_ref" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_ano_ref}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plp_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_mes" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plp_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_ano" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plp_nr_previsto:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_previsto" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_previsto}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>plp_nr_realizado:</label>
	</td>
	<td>
		<input type="text" name="plp_planilha_permutaT.plp_nr_realizado" value="${plp_planilha_permutaJB.plp_planilha_permutaT.plp_nr_realizado}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('plp_planilha_permuta','insert', '/EasyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('plp_planilha_permuta','clear', '/EasyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('plp_planilha_permuta','', '/EasyEngenharia/easyconstru/plp_planilha_permuta/plp_planilha_permutaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
