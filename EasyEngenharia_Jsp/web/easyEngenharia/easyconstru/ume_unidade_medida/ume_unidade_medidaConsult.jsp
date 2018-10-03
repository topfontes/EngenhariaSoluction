<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="ume_unidade_medidaJB" class="br.com.easynet.gwt.easyportal.jb.Ume_unidade_medidaConsultJB" scope="request"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="*"/>                                         
<jsp:setProperty name="ume_unidade_medidaJB" property="page" value="${pageContext}"/>                                         
${ume_unidade_medidaJB.execute}                                         
                                                                                

<form name="ume_unidade_medida" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${ume_unidade_medidaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('ume_unidade_medida','', '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('ume_unidade_medida','consult', '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${ume_unidade_medidaJB.list}"  pagesize="10" requestURI="/easyEngenharia/ume_unidade_medida/ume_unidade_medidaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Ume_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDelete.jsp&op=findbyid&ume_unidade_medidaT.ume_nr_id=${item.ume_nr_id}&">
      		<c:out value="${item.ume_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Ume_tx_nome" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaUpdateDelete.jsp&op=findbyid&ume_unidade_medidaT.ume_nr_id=${item.ume_nr_id}&">
      		<c:out value="${item.ume_tx_nome}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('ume_unidade_medida','delete', '/easyEngenharia/easyconstru/ume_unidade_medida/ume_unidade_medidaConsult.jsp?ume_unidade_medidaT.ume_nr_id=${item.ume_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
