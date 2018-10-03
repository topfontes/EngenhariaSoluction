<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="fol_folha_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fol_folha_pagamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fol_folha_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fol_folha_pagamentoJB.execute}                                         
                                                                                

<form name="fol_folha_pagamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${fol_folha_pagamentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('fol_folha_pagamento','', '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('fol_folha_pagamento','consult', '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${fol_folha_pagamentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Fol_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_tx_funcao" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_tx_funcao}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_salario_bruto_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_salario_bruto_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_adiantamento_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_adiantamento_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_horas_extra_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_horas_extra_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_salario_bruto_nao_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_salario_bruto_nao_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_adiantamento_nao_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_adiantamento_nao_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_horas_extra_nao_oficial" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_horas_extra_nao_oficial}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fol_nr_numero_funcionario" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoUpdateDelete.jsp&op=findbyid&fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&">
      		<c:out value="${item.fol_nr_numero_funcionario}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('fol_folha_pagamento','delete', '/easyEngenharia/easyconstru/fol_folha_pagamento/fol_folha_pagamentoConsult.jsp?fol_folha_pagamentoT.fol_nr_id=${item.fol_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
