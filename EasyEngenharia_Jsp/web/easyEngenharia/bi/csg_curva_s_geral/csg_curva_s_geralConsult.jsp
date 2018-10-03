<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="csg_curva_s_geralJB" class="br.com.easynet.gwt.easyportal.jb.Csg_curva_s_geralConsultJB" scope="request"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="*"/>                                         
<jsp:setProperty name="csg_curva_s_geralJB" property="page" value="${pageContext}"/>                                         
${csg_curva_s_geralJB.execute}                                         
                                                                                

<form name="csg_curva_s_geral" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${csg_curva_s_geralJB.tipoMsg}">${csg_curva_s_geralJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('csg_curva_s_geral','', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('csg_curva_s_geral','consult', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${csg_curva_s_geralJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Csg_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_mes_plan" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_mes_plan}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_ano_plan" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_ano_plan}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_acumulado_plan_po" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_acumulado_plan_po}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_fisico_acumulado_panejado_base" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_fisico_acumulado_panejado_base}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_fisico_acumulado_trab_atual" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_fisico_acumulado_trab_atual}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_fisico_acumulado_trab_projetado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_fisico_acumulado_trab_projetado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Csg_nr_fisico_acumulado_atual_projetado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralUpdateDelete.jsp&op=findbyid&csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&">
      		<c:out value="${item.csg_nr_fisico_acumulado_atual_projetado}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('csg_curva_s_geral','delete', '/easyEngenharia/bi/csg_curva_s_geral/csg_curva_s_geralConsult.jsp?csg_curva_s_geralT.csg_nr_id=${item.csg_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
