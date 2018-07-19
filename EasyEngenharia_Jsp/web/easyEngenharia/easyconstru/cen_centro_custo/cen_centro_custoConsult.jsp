<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="cen_centro_custoJB" class="br.com.easynet.gwt.easyportal.jb.Cen_centro_custoConsultJB" scope="request"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="*"/>                                         
<jsp:setProperty name="cen_centro_custoJB" property="page" value="${pageContext}"/>                                         
${cen_centro_custoJB.execute}                                         
                                                                                

<form name="cen_centro_custo" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${cen_centro_custoJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('cen_centro_custo','', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('cen_centro_custo','consult', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${cen_centro_custoJB.list}"  pagesize="10" requestURI="/easyEngenharia/cen_centro_custo/cen_centro_custoConsult.jsp?clearop=true">

		<display:column sortable="false" title="Cen_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDelete.jsp&op=findbyid&cen_centro_custoT.cen_nr_id=${item.cen_nr_id}&">
      		<c:out value="${item.cen_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Cen_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoUpdateDelete.jsp&op=findbyid&cen_centro_custoT.cen_nr_id=${item.cen_nr_id}&">
      		<c:out value="${item.cen_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('cen_centro_custo','delete', '/easyEngenharia/easyconstru/cen_centro_custo/cen_centro_custoConsult.jsp?cen_centro_custoT.cen_nr_id=${item.cen_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
