<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="inp_indicador_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Inp_indicador_planejamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="page" value="${pageContext}"/>                                         
${inp_indicador_planejamentoJB.execute}                                         
                                                                                

<form name="inp_indicador_planejamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alterac�o ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${inp_indicador_planejamentoJB.tipoMsg}">${inp_indicador_planejamentoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'update' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'delete' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'consult', '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('inp_indicador_planejamento', 'consult' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp')" /-->

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
		inp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_id" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.emp_nr_id" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_mes" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_ano" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_numero_fun_prev_mdo_direta:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_numero_fun_prev_mdo_direta" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_numero_fun_prev_mdo_direta}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_numero_fun_real_mdo_direta:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_numero_fun_real_mdo_direta" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_numero_fun_real_mdo_direta}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_nemro_fun_eqv_mdo_direta:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_nemro_fun_eqv_mdo_direta" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_nemro_fun_eqv_mdo_direta}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_perc_eficiencia_mdo_direta:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_perc_eficiencia_mdo_direta" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_perc_eficiencia_mdo_direta}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_ppp:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_ppp" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_ppp}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		inp_nr_ppc:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="inp_indicador_planejamentoT.inp_nr_ppc" value="${inp_indicador_planejamentoJB.inp_indicador_planejamentoT.inp_nr_ppc}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'update' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'delete' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('inp_indicador_planejamento', 'consult', '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('inp_indicador_planejamento', 'consult' , '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
