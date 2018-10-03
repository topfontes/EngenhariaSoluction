<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="con_contatosJB" class="br.com.easynet.gwt.easyportal.jb.Con_contatosConsultJB" scope="request"/>                                         
<jsp:setProperty name="con_contatosJB" property="*"/>                                         
<jsp:setProperty name="con_contatosJB" property="page" value="${pageContext}"/>                                         
${con_contatosJB.execute}                                         
                                                                                

<form name="con_contatos" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/con_contatos/con_contatosConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${con_contatosJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('con_contatos','', '/easyEngenharia/easyconstru/con_contatos/con_contatosInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('con_contatos','consult', '/easyEngenharia/easyconstru/con_contatos/con_contatosConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${con_contatosJB.list}"  pagesize="10" requestURI="/easyEngenharia/con_contatos/con_contatosConsult.jsp?clearop=true">

		<display:column sortable="false" title="Con_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cli_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.cli_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Set_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.set_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_cargo_exercicio" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_cargo_exercicio}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_telefone" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_telefone}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_telefone2" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_telefone2}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Con_tx_email" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/con_contatos/con_contatosUpdateDelete.jsp&op=findbyid&con_contatosT.con_nr_id=${item.con_nr_id}&">
      		<c:out value="${item.con_tx_email}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('con_contatos','delete', '/easyEngenharia/easyconstru/con_contatos/con_contatosConsult.jsp?con_contatosT.con_nr_id=${item.con_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
