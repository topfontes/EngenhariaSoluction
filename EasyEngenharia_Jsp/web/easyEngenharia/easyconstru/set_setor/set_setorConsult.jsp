<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="set_setorJB" class="br.com.easynet.gwt.easyportal.jb.Set_setorConsultJB" scope="request"/>                                         
<jsp:setProperty name="set_setorJB" property="*"/>                                         
<jsp:setProperty name="set_setorJB" property="page" value="${pageContext}"/>                                         
${set_setorJB.execute}                                         
                                                                                

<form name="set_setor" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${set_setorJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('set_setor','', '/easyEngenharia/easyconstru/set_setor/set_setorInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('set_setor','consult', '/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${set_setorJB.list}"  pagesize="10" requestURI="/easyEngenharia/set_setor/set_setorConsult.jsp?clearop=true">

		<display:column sortable="false" title="Set_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/set_setor/set_setorUpdateDelete.jsp&op=findbyid&set_setorT.set_nr_id=${item.set_nr_id}&">
      		<c:out value="${item.set_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Set_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/set_setor/set_setorUpdateDelete.jsp&op=findbyid&set_setorT.set_nr_id=${item.set_nr_id}&">
      		<c:out value="${item.set_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('set_setor','delete', '/easyEngenharia/easyconstru/set_setor/set_setorConsult.jsp?set_setorT.set_nr_id=${item.set_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
