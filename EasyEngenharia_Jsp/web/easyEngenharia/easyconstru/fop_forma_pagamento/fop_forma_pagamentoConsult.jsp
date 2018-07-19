<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="fop_forma_pagamentoJB" class="br.com.easynet.gwt.easyportal.jb.Fop_forma_pagamentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="*"/>                                         
<jsp:setProperty name="fop_forma_pagamentoJB" property="page" value="${pageContext}"/>                                         
${fop_forma_pagamentoJB.execute}                                         
                                                                                

<form name="fop_forma_pagamento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${fop_forma_pagamentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('fop_forma_pagamento','', '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('fop_forma_pagamento','consult', '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${fop_forma_pagamentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Fop_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp&op=findbyid&fop_forma_pagamentoT.fop_nr_id=${item.fop_nr_id}&">
      		<c:out value="${item.fop_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fop_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp&op=findbyid&fop_forma_pagamentoT.fop_nr_id=${item.fop_nr_id}&">
      		<c:out value="${item.fop_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Fop_tx_avista" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoUpdateDelete.jsp&op=findbyid&fop_forma_pagamentoT.fop_nr_id=${item.fop_nr_id}&">
      		<c:out value="${item.fop_tx_avista}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('fop_forma_pagamento','delete', '/easyEngenharia/easyconstru/fop_forma_pagamento/fop_forma_pagamentoConsult.jsp?fop_forma_pagamentoT.fop_nr_id=${item.fop_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
