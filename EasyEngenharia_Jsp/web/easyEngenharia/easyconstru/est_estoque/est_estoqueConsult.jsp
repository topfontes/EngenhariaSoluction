<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="est_estoqueJB" class="br.com.easynet.gwt.easyportal.jb.Est_estoqueConsultJB" scope="request"/>                                         
<jsp:setProperty name="est_estoqueJB" property="*"/>                                         
<jsp:setProperty name="est_estoqueJB" property="page" value="${pageContext}"/>                                         
${est_estoqueJB.execute}                                         
                                                                                

<form name="est_estoque" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/est_estoque/est_estoqueConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${est_estoqueJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('est_estoque','', '/easyEngenharia/easyconstru/est_estoque/est_estoqueInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('est_estoque','consult', '/easyEngenharia/easyconstru/est_estoque/est_estoqueConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${est_estoqueJB.list}"  pagesize="10" requestURI="/easyEngenharia/est_estoque/est_estoqueConsult.jsp?clearop=true">

		<display:column sortable="false" title="Est_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Est_nr_mes" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_nr_mes}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Plc_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.plc_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Est_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Est_nr_vl_unitario" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_nr_vl_unitario}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Est_nr_vl_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_nr_vl_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Est_tx_unidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.est_tx_unidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Obr_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/est_estoque/est_estoqueUpdateDelete.jsp&op=findbyid&est_estoqueT.est_nr_id=${item.est_nr_id}&">
      		<c:out value="${item.obr_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('est_estoque','delete', '/easyEngenharia/easyconstru/est_estoque/est_estoqueConsult.jsp?est_estoqueT.est_nr_id=${item.est_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
