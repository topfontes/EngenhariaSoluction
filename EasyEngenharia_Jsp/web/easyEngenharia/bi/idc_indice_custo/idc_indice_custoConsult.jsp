<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="idc_indice_custoJB" class="br.com.easynet.gwt.easyportal.jb.Idc_indice_custoConsultJB" scope="request"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="*"/>                                         
<jsp:setProperty name="idc_indice_custoJB" property="page" value="${pageContext}"/>                                         
${idc_indice_custoJB.execute}                                         
                                                                                

<form name="idc_indice_custo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/idc_indice_custo/idc_indice_custoConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${idc_indice_custoJB.tipoMsg}">${idc_indice_custoJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('idc_indice_custo','', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('idc_indice_custo','consult', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${idc_indice_custoJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Idc_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_ic_atual" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_ic_atual}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_ic_projetado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_ic_projetado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Idc_nr_projetado_empreendimento" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/idc_indice_custo/idc_indice_custoUpdateDelete.jsp&op=findbyid&idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&">
      		<c:out value="${item.idc_nr_projetado_empreendimento}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('idc_indice_custo','delete', '/easyEngenharia/bi/idc_indice_custo/idc_indice_custoConsult.jsp?idc_indice_custoT.idc_nr_id=${item.idc_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
