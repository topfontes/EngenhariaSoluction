<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="uno_unidade_obraJB" class="br.com.easynet.gwt.easyportal.jb.Uno_unidade_obraConsultJB" scope="request"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="*"/>                                         
<jsp:setProperty name="uno_unidade_obraJB" property="page" value="${pageContext}"/>                                         
${uno_unidade_obraJB.execute}                                         
                                                                                

<form name="uno_unidade_obra" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${uno_unidade_obraJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('uno_unidade_obra','', '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('uno_unidade_obra','consult', '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${uno_unidade_obraJB.list}"  pagesize="10" requestURI="/easyEngenharia/uno_unidade_obra/uno_unidade_obraConsult.jsp?clearop=true">

		<display:column sortable="false" title="Uno_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp&op=findbyid&uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&">
      		<c:out value="${item.uno_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp&op=findbyid&uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Uno_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp&op=findbyid&uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&">
      		<c:out value="${item.uno_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Uno_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp&op=findbyid&uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&">
      		<c:out value="${item.uno_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Uno_nr_area_construida" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraUpdateDelete.jsp&op=findbyid&uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&">
      		<c:out value="${item.uno_nr_area_construida}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('uno_unidade_obra','delete', '/easyEngenharia/easyconstru/uno_unidade_obra/uno_unidade_obraConsult.jsp?uno_unidade_obraT.uno_nr_id=${item.uno_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
