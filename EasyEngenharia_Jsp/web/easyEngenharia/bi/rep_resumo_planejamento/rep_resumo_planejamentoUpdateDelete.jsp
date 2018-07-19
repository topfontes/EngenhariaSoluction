<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="rep_resumo_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Rep_resumo_planejamentoUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="page" value="${pageContext}"/>                                         
${rep_resumo_planejamentoJB.execute}                                         
                                                                                

<form name="rep_resumo_planejamento" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${rep_resumo_planejamentoJB.tipoMsg}">${rep_resumo_planejamentoJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'update' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'delete' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'consult', '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('rep_resumo_planejamento', 'consult' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp')" /-->

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
		rep_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_id" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.emp_nr_id" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_mes" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_ano" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_tx_etapa:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_tx_etapa" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_tx_etapa}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_tx_local:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_tx_local" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_tx_local}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_termino_banco:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_termino_banco" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_termino_banco}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_termino_cliente:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_termino_cliente" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_termino_cliente}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_duracao_linha_base:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_duracao_linha_base" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_duracao_linha_base}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_inicio_linha_base:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_inicio_linha_base" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_inicio_linha_base}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_termino_linha_base:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_termino_linha_base" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_termino_linha_base}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_duracao:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_duracao" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_duracao}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_inicio:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_inicio" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_inicio}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_dt_termino:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_dt_termino" value="<fmt:formatDate value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_dt_termino}" pattern="dd/MM/yyyy"/>" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_trab_acum_realizado:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_trab_acum_realizado" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_trab_acum_realizado}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		rep_nr_trab_acum_previsto:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="rep_resumo_planejamentoT.rep_nr_trab_acum_previsto" value="${rep_resumo_planejamentoJB.rep_resumo_planejamentoT.rep_nr_trab_acum_previsto}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'update' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'delete' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('rep_resumo_planejamento', 'consult', '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('rep_resumo_planejamento', 'consult' , '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
