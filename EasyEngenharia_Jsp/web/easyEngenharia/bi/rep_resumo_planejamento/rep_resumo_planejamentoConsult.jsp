<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="rep_resumo_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Rep_resumo_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="rep_resumo_planejamentoJB" property="page" value="${pageContext}"/>                                         
${rep_resumo_planejamentoJB.execute}                                         
                                                                                

<form name="rep_resumo_planejamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${rep_resumo_planejamentoJB.tipoMsg}">${rep_resumo_planejamentoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('rep_resumo_planejamento','', '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('rep_resumo_planejamento','consult', '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${rep_resumo_planejamentoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Rep_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_tx_etapa" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_tx_etapa}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_tx_local" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_tx_local}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_termino_banco" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_termino_banco}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_termino_cliente" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_termino_cliente}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_duracao_linha_base" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_duracao_linha_base}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_inicio_linha_base" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_inicio_linha_base}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_termino_linha_base" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_termino_linha_base}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_duracao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_duracao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_inicio" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_inicio}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_dt_termino" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<fmt:formatDate value="${item.rep_dt_termino}" pattern="dd/MM/yyyy"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_trab_acum_realizado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_trab_acum_realizado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Rep_nr_trab_acum_previsto" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoUpdateDelete.jsp&op=findbyid&rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&">
      		<c:out value="${item.rep_nr_trab_acum_previsto}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('rep_resumo_planejamento','delete', '/easyEngenharia/bi/rep_resumo_planejamento/rep_resumo_planejamentoConsult.jsp?rep_resumo_planejamentoT.rep_nr_id=${item.rep_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
