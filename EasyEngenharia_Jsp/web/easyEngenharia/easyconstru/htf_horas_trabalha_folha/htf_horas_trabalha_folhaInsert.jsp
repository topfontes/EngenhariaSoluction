<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="htf_horas_trabalha_folhaJB" class="br.com.easynet.gwt.easyportal.jb.Htf_horas_trabalha_folhaInsertJB" scope="request"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="*"/>                                         
<jsp:setProperty name="htf_horas_trabalha_folhaJB" property="page" value="${pageContext}"/>                                         
${htf_horas_trabalha_folhaJB.execute}                                         
                                                                               
	
<form name="htf_horas_trabalha_folha" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaInsert.jsp"/>
    <center>     
     	<label class="msg">${htf_horas_trabalha_folhaJB.msg}</label><br/>
	<table width="50%" border="0">
	    <tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="htf_horas_trabalha_folhaT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${htf_horas_trabalha_folhaJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td>
		<label>htf_nr_mes:</label>
	</td>
	<td>
		<input type="text" name="htf_horas_trabalha_folhaT.htf_nr_mes" value="${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_mes}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>htf_nr_ano:</label>
	</td>
	<td>
		<input type="text" name="htf_horas_trabalha_folhaT.htf_nr_ano" value="${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_ano}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>
     <tr>
	<td>
		<label>htf_nr_horas_trabalhada:</label>
	</td>
	<td>
		<input type="text" name="htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada" value="${htf_horas_trabalha_folhaJB.htf_horas_trabalha_folhaT.htf_nr_horas_trabalhada}" onKeyPress="nextField(this, event)"/> 
	</td>
     </tr>

		<tr>
			<td colspan="2" align="center">
    			    <input type="button" value="Insert"  onClick="setOpPortal('htf_horas_trabalha_folha','insert', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaInsert.jsp')" /> &nbsp;&nbsp;
    			    <input type="reset"  value="Clear" onclick="setOpPortal('htf_horas_trabalha_folha','clear', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaInsert.jsp')"/>&nbsp;&nbsp;
    			    <input type="button" value="Voltar"  onClick="setOpPortal('htf_horas_trabalha_folha','', '/easyEngenharia/easyconstru/htf_horas_trabalha_folha/htf_horas_trabalha_folhaConsult.jsp')" />
			</td>
		</tr>
    	</table>
    </center>     
	
    
</form>
  
