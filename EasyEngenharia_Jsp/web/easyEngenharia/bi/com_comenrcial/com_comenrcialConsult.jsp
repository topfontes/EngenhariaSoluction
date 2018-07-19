<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="com_comenrcialJB" class="br.com.easynet.gwt.easyportal.jb.Com_comenrcialConsultJB" scope="request"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="*"/>                                         
<jsp:setProperty name="com_comenrcialJB" property="page" value="${pageContext}"/>                                         
${com_comenrcialJB.execute}                                         
                                                                                

<form name="com_comenrcial" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp"/>
<!-- Titulo da Operacao-->
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td class="ms-title">Consultar: Itens </td>
  </tr>
</table>
     	<label class="${com_comenrcialJB.tipoMsg}">${com_comenrcialJB.msg}</label><br/>
<table width="100%" height="30" border="0" cellpadding="6" cellspacing="0" class="ms-toolbar">
  <tr>
    <td width="100" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/add.gif" width="16" height="16" align="absmiddle" /> <a href#" onClick="setOpPortal('com_comenrcial','', '/easyEngenharia/bi/com_comenrcial/com_comenrcialInsert.jsp' )" class="ms-link">Novo Item </a></div></td>
    <td width="150" nowrap="nowrap"><div align="left" class="ms-required"><img src="/easyportal/images/ok.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link" onClick="setOpPortal('com_comenrcial','consult', '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp')">Autorizar Inscri&ccedil;&otilde;es</a></div></td>

    <td nowrap="nowrap"><!--div align="left" class="ms-required"><img src="/easyportal/images/delitem.gif" width="16" height="16" align="absmiddle" /> <a href="#" class="ms-link">Excluir Selecionado(s) </a></div--></td>
    <td nowrap="nowrap"><div align="right" class="ms-required"><strong>N</strong> item(ns) encontrado(s)</div></td>
  </tr>
</table>

	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${com_comenrcialJB.list}"  pagesize="20" >

		<display:column sortable="false" title="Com_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_mes" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_ano" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cen_nr_id" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.cen_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_tx_etapa" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_tx_etapa}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_unidade_med_acum" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_unidade_med_acum}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_preco_medio_und_vendida" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_preco_medio_und_vendida}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_unidade_a_vender" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_unidade_a_vender}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_preco_medio_unid_a_vender" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_preco_medio_unid_a_vender}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_recebimento_acumulado_pj" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_recebimento_acumulado_pj}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_recebimento_acumulado_pf" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_recebimento_acumulado_pf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_recebimento_acumulado_poupanca" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_recebimento_acumulado_poupanca}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_recebimento_acumulado_aporte" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_recebimento_acumulado_aporte}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_inadimplencia" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_inadimplencia}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_vgv_atualizado" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_vgv_atualizado}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_vgv_original" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_vgv_original}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Com_nr_recebimento_total" headerClass="ms-td-title">
	    <a class="ms-link-td" href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/bi/com_comenrcial/com_comenrcialUpdateDelete.jsp&op=findbyid&com_comenrcialT.com_nr_id=${item.com_nr_id}&">
      		<c:out value="${item.com_nr_recebimento_total}"/>
            </a>
	</display:column>
      
       <display:column headerClass="ms-td-title">

		<a onclick="setOpPortal('com_comenrcial','delete', '/easyEngenharia/bi/com_comenrcial/com_comenrcialConsult.jsp?com_comenrcialT.com_nr_id=${item.com_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.gif">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
