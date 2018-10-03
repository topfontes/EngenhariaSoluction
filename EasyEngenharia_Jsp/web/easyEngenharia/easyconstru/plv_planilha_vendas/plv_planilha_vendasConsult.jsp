<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="plv_planilha_vendasJB" class="br.com.easynet.gwt.easyportal.jb.Plv_planilha_vendasConsultJB" scope="request"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="*"/>                                         
<jsp:setProperty name="plv_planilha_vendasJB" property="page" value="${pageContext}"/>                                         
${plv_planilha_vendasJB.execute}                                         
                                                                                

<form name="plv_planilha_vendas" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${plv_planilha_vendasJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('plv_planilha_vendas','', '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('plv_planilha_vendas','consult', '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${plv_planilha_vendasJB.list}"  pagesize="10" requestURI="/EasyEngenharia/plv_planilha_vendas/plv_planilha_vendasConsult.jsp?clearop=true">

		<display:column sortable="false" title="Plv_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_mes_ref" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_mes_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_ano_ref" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_ano_ref}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_ano" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_ano}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_previsto" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_previsto}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plv_nr_realizado" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasUpdateDelete.jsp&op=findbyid&plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&">
      		<c:out value="${item.plv_nr_realizado}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('plv_planilha_vendas','delete', '/EasyEngenharia/easyconstru/plv_planilha_vendas/plv_planilha_vendasConsult.jsp?plv_planilha_vendasT.plv_nr_id=${item.plv_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
