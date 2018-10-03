<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="com_comenrcialJB" class="br.com.easynet.gwt.easyportal.jb.Com_comenrcialUpdateDeleteJB" scope="request"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="*"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="page" value="${pageContext}"/>                                         
${com_comenrcialJB.execute}                                         
                                                                                

<form name="com_comenrcial" action="portal.jsp" method="post"   >                                         
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Alteracão ou Excluir: Item </td>
  </tr>
</table>
     	<label class="${com_comenrcialJB.tipoMsg}">${com_comenrcialJB.msg}</label><br/>

<table width="600" align="left" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'update' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'delete' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'consult', '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('com_comenrcial', 'consult' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp')" /-->

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
		com_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_id" value="${com_comenrcialJB.com_comenrcialT.com_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.emp_nr_id" value="${com_comenrcialJB.com_comenrcialT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_mes" value="${com_comenrcialJB.com_comenrcialT.com_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_ano" value="${com_comenrcialJB.com_comenrcialT.com_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		cen_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.cen_nr_id" value="${com_comenrcialJB.com_comenrcialT.cen_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_tx_etapa:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_tx_etapa" value="${com_comenrcialJB.com_comenrcialT.com_tx_etapa}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_unidade_med_acum:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_unidade_med_acum" value="${com_comenrcialJB.com_comenrcialT.com_nr_unidade_med_acum}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_preco_medio_und_vendida:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_preco_medio_und_vendida" value="${com_comenrcialJB.com_comenrcialT.com_nr_preco_medio_und_vendida}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_unidade_a_vender:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_unidade_a_vender" value="${com_comenrcialJB.com_comenrcialT.com_nr_unidade_a_vender}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_preco_medio_unid_a_vender:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_preco_medio_unid_a_vender" value="${com_comenrcialJB.com_comenrcialT.com_nr_preco_medio_unid_a_vender}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_recebimento_acumulado_pj:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_recebimento_acumulado_pj" value="${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_pj}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_recebimento_acumulado_pf:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_recebimento_acumulado_pf" value="${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_pf}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_recebimento_acumulado_poupanca:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_recebimento_acumulado_poupanca" value="${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_poupanca}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_recebimento_acumulado_aporte:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_recebimento_acumulado_aporte" value="${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_acumulado_aporte}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_inadimplencia:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_inadimplencia" value="${com_comenrcialJB.com_comenrcialT.com_nr_inadimplencia}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_vgv_atualizado:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_vgv_atualizado" value="${com_comenrcialJB.com_comenrcialT.com_nr_vgv_atualizado}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_vgv_original:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_vgv_original" value="${com_comenrcialJB.com_comenrcialT.com_nr_vgv_original}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		com_nr_recebimento_total:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="com_comenrcialT.com_nr_recebimento_total" value="${com_comenrcialJB.com_comenrcialT.com_nr_recebimento_total}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

	</table>
    <br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="right">
    		<input type="button" value="Alterar" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'update' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<input type="button" value="Excluir" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'delete' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp')"/>&nbsp;&nbsp;&nbsp;
		<input type="button" value="Voltar" class="ms-ButtonHeightWidth" onClick="setOpPortal('com_comenrcial', 'consult', '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    		<!--input type="button" value="Cancel" class="ms-ButtonHeightWidth"  onClick="setOpPortal('com_comenrcial', 'consult' , '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp')" /-->

    </div></td>
  </tr>
</table>
	
</form>
