<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="for_fornecedorJB" class="br.com.easynet.gwt.easyportal.jb.For_fornecedorConsultJB" scope="request"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="*"/>                                         
<jsp:setProperty name="for_fornecedorJB" property="page" value="${pageContext}"/>                                         
${for_fornecedorJB.execute}                                         
                                                                                

<form name="for_fornecedor" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${for_fornecedorJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('for_fornecedor','', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('for_fornecedor','consult', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${for_fornecedorJB.list}"  pagesize="10" requestURI="/easyEngenharia/for_fornecedor/for_fornecedorConsult.jsp?clearop=true">

		<display:column sortable="false" title="For_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_cnpj" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_cnpj}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_endereco" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_endereco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_bairro" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_cidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_cidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_uf" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_contato" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_contato}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_telefone" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_telefone}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="For_tx_email" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorUpdateDelete.jsp&op=findbyid&for_fornecedorT.for_nr_id=${item.for_nr_id}&">
      		<c:out value="${item.for_tx_email}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('for_fornecedor','delete', '/easyEngenharia/easyconstru/for_fornecedor/for_fornecedorConsult.jsp?for_fornecedorT.for_nr_id=${item.for_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
