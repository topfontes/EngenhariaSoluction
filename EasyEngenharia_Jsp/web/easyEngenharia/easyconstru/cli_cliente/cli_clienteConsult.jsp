<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cli_clienteJB" class="br.com.easynet.gwt.easyportal.jb.Cli_clienteConsultJB" scope="request"/>                                         
<jsp:setProperty name="cli_clienteJB" property="*"/>                                         
<jsp:setProperty name="cli_clienteJB" property="page" value="${pageContext}"/>                                         
${cli_clienteJB.execute}                                         
                                                                                

<form name="cli_cliente" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cli_cliente/cli_clienteConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${cli_clienteJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('cli_cliente','', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('cli_cliente','consult', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cli_clienteJB.list}"  pagesize="10" requestURI="/easyEngenharia/cli_cliente/cli_clienteConsult.jsp?clearop=true">

		<display:column sortable="false" title="Cli_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_tipo_pessoa" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_tipo_pessoa}"/>
            </a>
	</display:column>
                <display:column sortable="false" title="Cli_tx_cnpj_cpf" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_cnpj_cpf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_endereco" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_endereco}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_bairro" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_cidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_cidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_telefone" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_telefone}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_fax" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_fax}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_telefone2" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_telefone2}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_by_logomarca" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<img border="0" src="/easyportal/easyEngenharia/cli_cliente/cli_clienteUpdateDelete.jsp?op=downloadImage&cli_clienteT.cli_nr_id=${item.cli_nr_id}&"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_tx_email" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cli_cliente/cli_clienteUpdateDelete.jsp&op=findbyid&cli_clienteT.cli_nr_id=${item.cli_nr_id}&">
      		<c:out value="${item.cli_tx_email}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('cli_cliente','delete', '/easyEngenharia/easyconstru/cli_cliente/cli_clienteConsult.jsp?cli_clienteT.cli_nr_id=${item.cli_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
