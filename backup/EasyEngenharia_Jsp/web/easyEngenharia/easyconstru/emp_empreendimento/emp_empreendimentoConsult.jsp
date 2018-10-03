<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="emp_empreendimentoJB" class="br.com.easynet.gwt.easyportal.jb.Emp_empreendimentoConsultJB" scope="request"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="*"/>                                         
<jsp:setProperty name="emp_empreendimentoJB" property="page" value="${pageContext}"/>                                         
${emp_empreendimentoJB.execute}                                         
                                                                                

<form name="emp_empreendimento" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${emp_empreendimentoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('emp_empreendimento','', '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('emp_empreendimento','consult', '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${emp_empreendimentoJB.list}"  pagesize="10" requestURI="/easyEngenharia/emp_empreendimento/emp_empreendimentoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Emp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_bairro" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_bairro}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_cidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_cidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Emp_tx_uf" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.emp_tx_uf}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoUpdateDelete.jsp&op=findbyid&emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('emp_empreendimento','delete', '/easyEngenharia/easyconstru/emp_empreendimento/emp_empreendimentoConsult.jsp?emp_empreendimentoT.emp_nr_id=${item.emp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
