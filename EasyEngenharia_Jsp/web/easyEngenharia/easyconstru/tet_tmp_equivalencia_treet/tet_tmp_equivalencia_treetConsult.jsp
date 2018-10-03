<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="tet_tmp_equivalencia_treetJB" class="br.com.easynet.gwt.easyportal.jb.Tet_tmp_equivalencia_treetConsultJB" scope="request"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="*"/>                                         
<jsp:setProperty name="tet_tmp_equivalencia_treetJB" property="page" value="${pageContext}"/>                                         
${tet_tmp_equivalencia_treetJB.execute}                                         
                                                                                

<form name="tet_tmp_equivalencia_treet" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${tet_tmp_equivalencia_treetJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('tet_tmp_equivalencia_treet','', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('tet_tmp_equivalencia_treet','consult', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${tet_tmp_equivalencia_treetJB.list}"  pagesize="10" requestURI="/easyEngenharia/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp?clearop=true">

		<display:column sortable="false" title="Tet_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp&op=findbyid&tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&">
      		<c:out value="${item.tet_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp&op=findbyid&tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&">
      		<c:out value="${item.plco_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp&op=findbyid&tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plco_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp&op=findbyid&tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&">
      		<c:out value="${item.plco_tx_nome}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetUpdateDelete.jsp&op=findbyid&tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&">
      		<c:out value="${item.plc_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('tet_tmp_equivalencia_treet','delete', '/easyEngenharia/easyconstru/tet_tmp_equivalencia_treet/tet_tmp_equivalencia_treetConsult.jsp?tet_tmp_equivalencia_treetT.tet_nr_id=${item.tet_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
