<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="evl_evolucao_lucroJB" class="br.com.easynet.gwt.easyportal.jb.Evl_evolucao_lucroConsultJB" scope="request"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="*"/>                                         
<jsp:setProperty name="evl_evolucao_lucroJB" property="page" value="${pageContext}"/>                                         
${evl_evolucao_lucroJB.execute}                                         
                                                                                

<form name="evl_evolucao_lucro" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${evl_evolucao_lucroJB.tipoMsg}">${evl_evolucao_lucroJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('evl_evolucao_lucro','', '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('evl_evolucao_lucro','consult', '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${evl_evolucao_lucroJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Evl_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_nr_valor" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_valor}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_nr_mes_ref" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_mes_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_nr_ano_ref" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_nr_ano_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Evl_tx_tipo" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroUpdateDelete.jsp&op=findbyid&evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&">
      		<c:out value="${item.evl_tx_tipo}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('evl_evolucao_lucro','delete', '/EasyEngenharia_Jsp/easyconstru/evl_evolucao_lucro/evl_evolucao_lucroConsult.jsp?evl_evolucao_lucroT.evl_nr_id=${item.evl_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
