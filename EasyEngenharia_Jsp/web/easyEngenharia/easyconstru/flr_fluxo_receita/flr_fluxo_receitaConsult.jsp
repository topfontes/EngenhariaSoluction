<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="flr_fluxo_receitaJB" class="br.com.easynet.gwt.easyportal.jb.Flr_fluxo_receitaConsultJB" scope="request"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="*"/>                                         
<jsp:setProperty name="flr_fluxo_receitaJB" property="page" value="${pageContext}"/>                                         
${flr_fluxo_receitaJB.execute}                                         
                                                                                

<form name="flr_fluxo_receita" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${flr_fluxo_receitaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('flr_fluxo_receita','', '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('flr_fluxo_receita','consult', '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${flr_fluxo_receitaJB.list}"  pagesize="10" requestURI="/EasyEngenharia/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Flr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Flr_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Flr_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Flr_nr_original" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_nr_original}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Flr_nr_atual" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_nr_atual}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Flr_tx_key" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaUpdateDelete.jsp&op=findbyid&flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&">
      		<c:out value="${item.flr_tx_key}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('flr_fluxo_receita','delete', '/EasyEngenharia/easyconstru/flr_fluxo_receita/flr_fluxo_receitaConsult.jsp?flr_fluxo_receitaT.flr_nr_id=${item.flr_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
