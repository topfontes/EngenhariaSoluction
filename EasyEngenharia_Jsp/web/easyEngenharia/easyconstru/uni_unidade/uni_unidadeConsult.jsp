<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="uni_unidadeJB" class="br.com.easynet.gwt.easyportal.jb.Uni_unidadeConsultJB" scope="request"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="*"/>                                         
<jsp:setProperty name="uni_unidadeJB" property="page" value="${pageContext}"/>                                         
${uni_unidadeJB.execute}                                         
                                                                                

<form name="uni_unidade" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${uni_unidadeJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('uni_unidade','', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('uni_unidade','consult', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${uni_unidadeJB.list}"  pagesize="10" requestURI="/easyEngenharia/uni_unidade/uni_unidadeConsult.jsp?clearop=true">

		<display:column sortable="false" title="Uni_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDelete.jsp&op=findbyid&uni_unidadeT.uni_nr_id=${item.uni_nr_id}&">
      		<c:out value="${item.uni_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Uni_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uni_unidade/uni_unidadeUpdateDelete.jsp&op=findbyid&uni_unidadeT.uni_nr_id=${item.uni_nr_id}&">
      		<c:out value="${item.uni_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('uni_unidade','delete', '/easyEngenharia/easyconstru/uni_unidade/uni_unidadeConsult.jsp?uni_unidadeT.uni_nr_id=${item.uni_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
