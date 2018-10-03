<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="pes_pessoaJB" class="br.com.easynet.gwt.easyportal.jb.Pes_pessoaConsultJB" scope="request"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="*"/>                                         
<jsp:setProperty name="pes_pessoaJB" property="page" value="${pageContext}"/>                                         
${pes_pessoaJB.execute}                                         
                                                                                

<form name="pes_pessoa" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${pes_pessoaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('pes_pessoa','', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('pes_pessoa','consult', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${pes_pessoaJB.list}"  pagesize="10" requestURI="/EasyEngenharia/pes_pessoa/pes_pessoaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Pes_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp&op=findbyid&pes_pessoaT.pes_nr_id=${item.pes_nr_id}&">
      		<c:out value="${item.pes_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pes_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp&op=findbyid&pes_pessoaT.pes_nr_id=${item.pes_nr_id}&">
      		<c:out value="${item.pes_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pes_tx_fone" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaUpdateDelete.jsp&op=findbyid&pes_pessoaT.pes_nr_id=${item.pes_nr_id}&">
      		<c:out value="${item.pes_tx_fone}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('pes_pessoa','delete', '/EasyEngenharia/easyconstru/pes_pessoa/pes_pessoaConsult.jsp?pes_pessoaT.pes_nr_id=${item.pes_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
