<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ret_restricao_planejamentoJB" class="br.com.easynet.gwt.easyportal.jb.Ret_restricao_planejamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="*"/>                                         
<jsp:setProperty name="ret_restricao_planejamentoJB" property="page" value="${pageContext}"/>                                         
${ret_restricao_planejamentoJB.execute}                                         
                                                                                

<form name="ret_restricao_planejamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${ret_restricao_planejamentoJB.tipoMsg}">${ret_restricao_planejamentoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('ret_restricao_planejamento','', '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('ret_restricao_planejamento','consult', '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ret_restricao_planejamentoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Ret_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ret_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ret_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ret_tx_restricao" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_tx_restricao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ret_nr_ocorrencia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_nr_ocorrencia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ret_nr_deficet" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoUpdateDelete.jsp&op=findbyid&ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&">
      		<c:out value="${item.ret_nr_deficet}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('ret_restricao_planejamento','delete', '/easyEngenharia/bi/ret_restricao_planejamento/ret_restricao_planejamentoConsult.jsp?ret_restricao_planejamentoT.ret_nr_id=${item.ret_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
