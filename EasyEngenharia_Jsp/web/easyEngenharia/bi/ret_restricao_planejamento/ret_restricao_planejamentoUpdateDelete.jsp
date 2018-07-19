<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="ret_restricao_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Ret_restricao_planejamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="page" value="${pageContext}"/>                                         
${ret_restricao_planejamentoJB.execute}                                         
                                                                                

<form name="ret_restricao_planejamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${ret_restricao_planejamentoJB.tipoMsg}">${ret_restricao_planejamentoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'update' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'delete' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'consult', '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ret_restricao_planejamento', 'consult' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp')" /-->

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
		ret_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_nr_id" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.emp_nr_id" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ret_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_nr_mes" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ret_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_nr_ano" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ret_tx_restricao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_tx_restricao" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_tx_restricao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ret_nr_ocorrencia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_nr_ocorrencia" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_ocorrencia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		ret_nr_deficet:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="ret_restricao_planejamentoT.ret_nr_deficet" value="${ret_restricao_planejamentoJB.ret_restricao_planejamentoT.ret_nr_deficet}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'update' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'delete' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('ret_restricao_planejamento', 'consult', '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('ret_restricao_planejamento', 'consult' , '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
