<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  

<jsp:useBean id="csg_curva_s_geralJB" class="br.com.easynet.gwt.easyportal.jb.Csg_curva_s_geralInsertJB" scope="request"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="*"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="page" value="${pageContext}"/>                                         
${csg_curva_s_geralJB.execute}                                         
                                                                               
	
<form name="csg_curva_s_geral" action="portal.jsp" method="post"   > 
    <input type="hidden" name="op"/>
    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp"/>

<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Cadastrar: Item </td>
  </tr>
</table>
     	<label class="${csg_curva_s_geralJB.tipoMsg}">${csg_curva_s_geralJB.msg}</label><br/>

<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('csg_curva_s_geral','insert', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('csg_curva_s_geral','Limpar', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('csg_curva_s_geral','', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralConsult.jsp')" />
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
  		  <input type="text" name="csg_curva_s_geralT.emp_nr_id" value="${csg_curva_s_geralJB.csg_curva_s_geralT.emp_nr_id}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_mes:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_mes" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_mes}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_ano:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_ano" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_ano}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_mes_plan:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_mes_plan" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_mes_plan}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_ano_plan:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_ano_plan" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_ano_plan}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_acumulado_plan_po:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_acumulado_plan_po" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_acumulado_plan_po}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_fisico_acumulado_panejado_base:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_fisico_acumulado_panejado_base" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_panejado_base}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_fisico_acumulado_trab_atual:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_atual" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_atual}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_fisico_acumulado_trab_projetado:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_projetado" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_trab_projetado}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>
     <tr>
	<td class="ms-standardheader">
		csg_nr_fisico_acumulado_atual_projetado:<span class="style1">*</span>
	</td>
	<td class="ms-fields">
		<label class="ms-standardheader">
  		  <input type="text" name="csg_curva_s_geralT.csg_nr_fisico_acumulado_atual_projetado" value="${csg_curva_s_geralJB.csg_curva_s_geralT.csg_nr_fisico_acumulado_atual_projetado}" onKeyPress="nextField(this, event)"/> 
   	       </label>
	</td>
     </tr>

		
    	</table>
	<br/>
<table align="left" width="600" height="40" border="0" cellpadding="0" cellspacing="0">
  <tr >
    <td><div align="right">
    			    <input type="button" class="ms-ButtonHeightWidth" value="Cadastrar"  onClick="setOpPortal('csg_curva_s_geral','insert', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp')" /> &nbsp;&nbsp;
    			    <!--input type="reset"  value="Clear" onclick="setOpPortal('csg_curva_s_geral','Limpar', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp')"/-->&nbsp;&nbsp;
    			    <input type="button" class="ms-ButtonHeightWidth" value="Voltar"  onClick="setOpPortal('csg_curva_s_geral','', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralConsult.jsp')" />
    </div></td>
  </tr>
</table>
    
</form>
  
