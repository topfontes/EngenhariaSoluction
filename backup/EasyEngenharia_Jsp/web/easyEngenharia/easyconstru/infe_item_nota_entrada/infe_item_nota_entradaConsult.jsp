<!-- Gerado pelo EasyNet Generate JDragon -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<jsp:useBean id="infe_item_nota_entradaJB" class="br.com.easynet.gwt.easyportal.jb.Infe_item_nota_entradaConsultJB" scope="request"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="*"/>                                         
<jsp:setProperty name="infe_item_nota_entradaJB" property="page" value="${pageContext}"/>                                         
${infe_item_nota_entradaJB.execute}                                         
                                                                                

<form name="infe_item_nota_entrada" action="portal.jsp" method="post">                                         
    <input type="hidden" name="op"/>

    <input type="hidden" name="urlCanalAtual" value="principalPage.jsp"/>
    <input type="hidden" name="urlCanal" value="/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaConsult.jsp"/>
    <center>     
	<label class="msg" align="center">${infe_item_nota_entradaJB.msg} </label>
	<br/>
    <input type="button" value="New" onClick="setOpPortal('infe_item_nota_entrada','', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaInsert.jsp' )"/>&nbsp;&nbsp;&nbsp;
    <input type="button" value="List" onClick="setOpPortal('infe_item_nota_entrada','consult', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaConsult.jsp')"/>&nbsp;&nbsp;&nbsp;
    </center>     
	
	<hr/> 
    <h2 align="center">List</h2>
    <center>
	
    <display:table class="tabela" cellpadding="0" cellspacing="0" id="item" name="${infe_item_nota_entradaJB.list}"  pagesize="10" requestURI="/easyEngenharia/infe_item_nota_entrada/infe_item_nota_entradaConsult.jsp?clearop=true">

		<display:column sortable="false" title="Infe_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.infe_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Infe_nr_quantidade" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.infe_nr_quantidade}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Infe_nr_valor_unit" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.infe_nr_valor_unit}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Infe_nr_valor_total" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.infe_nr_valor_total}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Nfe_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.nfe_nr_id}"/>
            </a>
	</display:column>
	<display:column sortable="false" title="Pro_nr_id" >
	    <a href="portal.jsp?urlCanalAtual=principalPage.jsp&urlCanal=/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaUpdateDelete.jsp&op=findbyid&infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&">
      		<c:out value="${item.pro_nr_id}"/>
            </a>
	</display:column>
      
       <display:column title="Apagar">

<!--portal.jsp?urlCanalAtual=can_canalConsult.jsp&urlCanal=can_canalUpdateDelete.jsp&op=findbyid&can_canalT.can_nr_id=-->
		<a onclick="setOpPortal('infe_item_nota_entrada','delete', '/easyEngenharia/easyconstru/infe_item_nota_entrada/infe_item_nota_entradaConsult.jsp?infe_item_nota_entradaT.infe_nr_id=${item.infe_nr_id}&')" href="#">
    	       		<img border="0" src="/easyportal/images/delete.png">

		</a>
       </display:column>	
    </display:table>
    </center>	
    
</form>
   
