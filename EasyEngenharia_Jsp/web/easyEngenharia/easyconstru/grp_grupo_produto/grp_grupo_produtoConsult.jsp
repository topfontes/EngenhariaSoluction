<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="grp_grupo_produtoJB" class="br.com.easynet.gwt.easyportal.jb.Grp_grupo_produtoConsultJB" scope="request"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="*"/>                                         
<jsp:setProperty name="grp_grupo_produtoJB" property="page" value="${pageContext}"/>                                         
${grp_grupo_produtoJB.execute}                                         
                                                                                

<form name="grp_grupo_produto" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${grp_grupo_produtoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('grp_grupo_produto','', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('grp_grupo_produto','consult', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${grp_grupo_produtoJB.list}"  pagesize="10" requestURI="/easyEngenharia/grp_grupo_produto/grp_grupo_produtoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Grp_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDelete.jsp&op=findbyid&grp_grupo_produtoT.grp_nr_id=${item.grp_nr_id}&">
      		<c:out value="${item.grp_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Grp_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoUpdateDelete.jsp&op=findbyid&grp_grupo_produtoT.grp_nr_id=${item.grp_nr_id}&">
      		<c:out value="${item.grp_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('grp_grupo_produto','delete', '/easyEngenharia/easyconstru/grp_grupo_produto/grp_grupo_produtoConsult.jsp?grp_grupo_produtoT.grp_nr_id=${item.grp_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
