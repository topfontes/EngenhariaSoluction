<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="plco_plano_contas_orcamentoJB" class="br.com.easynet.gwt.easyportal.jb.Plco_plano_contas_orcamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="*"/>                                         
<jsp:setProperty name="plco_plano_contas_orcamentoJB" property="page" value="${pageContext}"/>                                         
${plco_plano_contas_orcamentoJB.execute}                                         
                                                                                

<form name="plco_plano_contas_orcamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${plco_plano_contas_orcamentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('plco_plano_contas_orcamento','', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('plco_plano_contas_orcamento','consult', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${plco_plano_contas_orcamentoJB.list}"  pagesize="10" requestURI="/easyengenharia/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_tipo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_tx_tipo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_cod_externo" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_tx_cod_externo}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_unidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_tx_unidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id_super" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoUpdateDelete.jsp&op=findbyid&plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&">
      		<c:out value="${item.plco_nr_id_super}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('plco_plano_contas_orcamento','delete', '/easyengenharia/easyconstru/plco_plano_contas_orcamento/plco_plano_contas_orcamentoConsult.jsp?plco_plano_contas_orcamentoT.plco_nr_id=${item.plco_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
