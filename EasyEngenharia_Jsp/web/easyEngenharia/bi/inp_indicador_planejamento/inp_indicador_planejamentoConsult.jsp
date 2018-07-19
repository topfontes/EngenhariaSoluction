<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="inp_indicador_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Inp_indicador_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="inp_indicador_planejamentoJB" property="page" value="${pageContext}"/>                                         
${inp_indicador_planejamentoJB.execute}                                         
                                                                                

<form name="inp_indicador_planejamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${inp_indicador_planejamentoJB.tipoMsg}">${inp_indicador_planejamentoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('inp_indicador_planejamento','', '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('inp_indicador_planejamento','consult', '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${inp_indicador_planejamentoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Inp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_numero_fun_prev_mdo_direta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_numero_fun_prev_mdo_direta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_numero_fun_real_mdo_direta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_numero_fun_real_mdo_direta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_nemro_fun_eqv_mdo_direta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_nemro_fun_eqv_mdo_direta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_perc_eficiencia_mdo_direta" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_perc_eficiencia_mdo_direta}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_ppp" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_ppp}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Inp_nr_ppc" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoUpdateDelete.jsp&op=findbyid&inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&">
      		<c:out value="${item.inp_nr_ppc}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('inp_indicador_planejamento','delete', '/easyEngenharia/bi/inp_indicador_planejamento/inp_indicador_planejamentoConsult.jsp?inp_indicador_planejamentoT.inp_nr_id=${item.inp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
