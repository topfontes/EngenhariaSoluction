<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="idc_indice_custoJB" class="br.com.easynet.gwt.easyportal.jb.Idc_indice_custoInsertJB" scope="request"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="*"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="page" value="${pageContext}"/>                                         
${idc_indice_custoJB.execute}                                         
                                                                               
	
<form name="idc_indice_custo" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${idc_indice_custoJB.tipoMsg}">${idc_indice_custoJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('idc_indice_custo','insert', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('idc_indice_custo','Limpar', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('idc_indice_custo','', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoConsult.jsp')" />
    </div></td>
  </tr>
</table>
<br/>
<table align="left" width="600" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="300" nowrap="nowrap">&nbsp;</td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><span class="style1">*</span> Indica um campo obrigat&oacute;rio </div></td>
  </tr>
</table>
<br/>
	<table align="left" width="50%" border="0">
	         <tr>
	<td class="ms-standardheader">
		emp_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.emp_nr_id" value="${idc_indice_custoJB.idc_indice_custoT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.idc_nr_ano" value="${idc_indice_custoJB.idc_indice_custoT.idc_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		plc_nr_id:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.plc_nr_id" value="${idc_indice_custoJB.idc_indice_custoT.plc_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_ic_atual:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.idc_nr_ic_atual" value="${idc_indice_custoJB.idc_indice_custoT.idc_nr_ic_atual}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_ic_projetado:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.idc_nr_ic_projetado" value="${idc_indice_custoJB.idc_indice_custoT.idc_nr_ic_projetado}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		idc_nr_projetado_empreendimento:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="idc_indice_custoT.idc_nr_projetado_empreendimento" value="${idc_indice_custoJB.idc_indice_custoT.idc_nr_projetado_empreendimento}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('idc_indice_custo','insert', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('idc_indice_custo','Limpar', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('idc_indice_custo','', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
