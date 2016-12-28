<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="evl_evolucao_lucroJB" class="br.com.easynet.gwt.easyportal.jb.Evl_evolucao_lucroUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="*"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="page" value="${pageContext}"/>                                         
${evl_evolucao_lucroJB.execute}                                         

<form name="evl_evolucao_lucro" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${evl_evolucao_lucroJB.tipoMsg}">${evl_evolucao_lucroJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'update' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'delete' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'consult', '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('evl_evolucao_lucro', 'consult' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
<br/>
<table width="600" align="left" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
    <table align="left" border="0" width="50%">
    		     <tr>
	<td class="ms-standardheader">
		evl_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_id" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
<tr>
	<td>
		<label>obr_nr_id:</label>
	</td>
	<td>
	    <select name="evl_evolucao_lucroT.obr_nr_id" onKeyPress="nextField(this, event)">
         	<c:forEach items="${evl_evolucao_lucroJB.listobr_obras}" var="item">
            	  <option value="${item.obr_nr_id}">${item.obr_nr_id}</option>
	 	</c:forEach>
            </select>
	</td>
     </tr>	

     <tr>
	<td class="ms-standardheader">
		evl_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_mes" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		evl_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_ano" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		evl_nr_valor:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_valor" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_valor}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		evl_nr_mes_ref:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_mes_ref" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_mes_ref}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		evl_nr_ano_ref:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_nr_ano_ref" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_nr_ano_ref}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		evl_tx_tipo:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="evl_evolucao_lucroT.evl_tx_tipo" value="${evl_evolucao_lucroJB.evl_evolucao_lucroT.evl_tx_tipo}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'update' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'delete' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('evl_evolucao_lucro', 'consult', '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('evl_evolucao_lucro', 'consult' , '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
